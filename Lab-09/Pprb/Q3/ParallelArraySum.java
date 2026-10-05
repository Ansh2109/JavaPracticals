class SumTask extends Thread{
    int[] array;
    int start;
    int end;
    long[] total;

    SumTask(int[] array,int start,int end,long[] total){
        this.array=array;
        this.start=start;
        this.end=end;
        this.total=total;
    }

    public void run(){
        for(int i=start;i<end;i++){
            total[0]+=array[i];
        }
    }
}

class SafeSumTask extends Thread{
    int[] array;
    int start;
    int end;
    long[] total;

    SafeSumTask(int[] array,int start,int end,long[] total){
        this.array=array;
        this.start=start;
        this.end=end;
        this.total=total;
    }

    public void run(){
        long local=0;

        for(int i=start;i<end;i++){
            local+=array[i];
        }

        synchronized(total){
            total[0]+=local;
        }
    }
}

public class ParallelArraySum{

    public static void main(String[] args)throws Exception{
        int[] array=new int[100000];

        for(int i=0;i<array.length;i++){
            array[i]=1;
        }

        int threadCount=10;
        int part=array.length/threadCount;

        long[] wrongTotal={0};
        Thread[] threads=new Thread[threadCount];

        for(int i=0;i<threadCount;i++){
            int start=i*part;
            int end=(i==threadCount-1)?array.length:start+part;

            threads[i]=new SumTask(array,start,end,wrongTotal);
            threads[i].start();
        }

        for(Thread thread:threads){
            thread.join();
        }

        System.out.println("Without synchronization: "+wrongTotal[0]);

        long[] safeTotal={0};
        Thread[] threads2=new Thread[threadCount];

        for(int i=0;i<threadCount;i++){
            int start=i*part;
            int end=(i==threadCount-1)?array.length:start+part;

            threads2[i]=new SafeSumTask(array,start,end,safeTotal);
            threads2[i].start();
        }

        for(Thread thread:threads2){
            thread.join();
        }

        System.out.println("With synchronization: "+safeTotal[0]);

        long directTotal=0;
        long startTime=System.nanoTime();

        for(int value:array){
            directTotal+=value;
        }

        long endTime=System.nanoTime();

        System.out.println("Single thread: "+directTotal);
        System.out.println("Time: "+(endTime-startTime)+" ns");
    }
}