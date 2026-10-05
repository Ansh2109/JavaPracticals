class Cinema{
    int seatsLeft=5;

    boolean book(){
        if(seatsLeft>0){
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            seatsLeft--;
            return true;
        }
        return false;
    }
}

class SafeCinema{
    int seatsLeft=5;

    synchronized boolean book(){
        if(seatsLeft>0){
            seatsLeft--;
            return true;
        }
        return false;
    }
}

public class SeatBookingRace{

    public static void main(String[] args)throws Exception{
        Cinema cinema=new Cinema();
        Thread[] threads=new Thread[10];
        int[] success={0};

        for(int i=0;i<10;i++){
            threads[i]=new Thread(()->{
                if(cinema.book()){
                    synchronized(success){
                        success[0]++;
                    }
                }
            });
            threads[i].start();
        }

        for(Thread thread:threads){
            thread.join();
        }

        System.out.println("Without synchronization:");
        System.out.println("Successful bookings: "+success[0]);
        System.out.println("Seats left: "+cinema.seatsLeft);

        SafeCinema safeCinema=new SafeCinema();
        Thread[] threads2=new Thread[10];
        int[] success2={0};

        for(int i=0;i<10;i++){
            threads2[i]=new Thread(()->{
                if(safeCinema.book()){
                    synchronized(success2){
                        success2[0]++;
                    }
                }
            });
            threads2[i].start();
        }

        for(Thread thread:threads2){
            thread.join();
        }

        System.out.println("With synchronization:");
        System.out.println("Successful bookings: "+success2[0]);
        System.out.println("Seats left: "+safeCinema.seatsLeft);
    }
}