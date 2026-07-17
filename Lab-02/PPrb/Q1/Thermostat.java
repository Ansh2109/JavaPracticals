import java.util.*;

public class Thermostat {

    private String location;
    private int temperature;
    private static int MIN=16;
    private static int MAX=30;
    private static int activeCount=0;
    public Thermostat(String l,int t){
        if(t>MIN || t<MAX){
            temperature=t;
        }
        else{
            temperature=22;
        }
        activeCount++;
        
        this.location=l;

    }
    public Thermostat(String l){
        this(l,22);

    }
    public  void raise(){
        if(temperature<MAX){
            temperature+=1;
        }
        else{
            System.out.println("Already at maximum(30)");
        }

    }
    public void lower(){
        if(temperature>MIN){
            temperature--;
        }
        else{
            System.out.println("Already at minimum(16)");
        
        }
    }   
    public int getTemperature(){
        return temperature;
    }
    public static int getActiveCount(){
        return activeCount;
    }
    public static void main(String[] args){

        Scanner s1 = new Scanner(System.in);
        int temp = s1.nextInt();

        Thermostat t1 =  new Thermostat("room");
        Thermostat t2 =  new Thermostat("hall", temp);

        for(int i=0;i<10;i++){
            t1.raise();
            t2.raise();
            System.out.println("Temp from t1 = "+t1.getTemperature()+" Temp from t2 = "+t2.getTemperature());
        }
        for(int j=0;j<20;j++){
            t1.lower();
            t2.lower();
            System.out.println("Temp from t1 = "+t1.getTemperature()+" Temp from t2 = "+t2.getTemperature());

        }
        System.out.println(getActiveCount());        
        // int temp;
        // Scanner s=new Scanner(System.in);
        // System.out.print("Enter temperature:");
        // temp= s.nextInt();
        // String loc;
        // System.out.print("Enter loaction:");
        // loc=s.next();
        // Thermostat t1=new Thermostat(loc,temp);
        // String l2;
        // System.out.print("Enter loaction:");
        // l2=s.next();
        // Thermostat t2=new Thermostat(l2);
        // s.close();
        // for(int i=0;i<10;i++){
        //     int te=t1.getTemperature();
        //     t1.raise();
        //     System.out.println("Temperature:"+te);
        // }
        // for(int i=0;i<20;i++){
        //     int te=t1.getTemperature();
        //     t2.lower();
        //     System.out.println("Temperature:"+te);
        
        // }
        // System.out.println("Active count:"+ Thermostat.getActiveCount());
    }
    
}
