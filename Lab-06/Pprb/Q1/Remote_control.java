import java.util.*;

interface Switchable {
    abstract void on();
    abstract void off();
    boolean ison();
    default void toggle(){
        if (ison()){
            off();
        }
        else{
            on();
        }
    }
    
}
class Fan implements Switchable{
    boolean run=false;
    public void on(){
        System.out.println("Fan on");
        run=true;
    }
    public void off(){
        System.out.println("Fan off");
    }
    public boolean ison(){
        return run;
    }
}
class Light implements Switchable{
    boolean run=false;
    public void on(){
        System.out.println("Light on");
        run=true;
    }
    public void off(){
        System.out.println("Light off");
    }
    public boolean ison(){
        return run;
    }
}

@FunctionalInterface 
interface  Restriction {
    boolean check(Switchable dev,int hrs);
}
public class Remote_control{
    public static void main(String[] args){
        Switchable[] d={new Light(),new Fan()};
        for(Switchable s:d){
            s.toggle();
        }
        Restriction lightrestriction=new Restriction(){
            public boolean check(Switchable dev,int hrs){
                if(hrs<5 || hrs>23){
                    return false;
                }
                return true;
            }
        
        };
        
        Restriction fanrestriction=(dev,hrs)->{
            if(hrs>11 && hrs<17){
                return false;
            }
            return true;
        };
        int hour = 13;
        for(Switchable s:d){
            
            System.out.println("Light Allowed:" + hour+"="+lightrestriction.check(s,hour));
            System.out.println("Fan Allowed:" + hour+"="+fanrestriction.check(s,hour));
        }
        
           
        



    }
}