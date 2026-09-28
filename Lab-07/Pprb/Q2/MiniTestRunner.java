import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run{}

class MyTests{
    @Run
    public void testOne(){
        System.out.println("testOne ran");
    }

    @Run
    public void testTwo(){
        System.out.println("testTwo ran");
    }

    public void normalMethod(){
        System.out.println("normalMethod ran");
    }

    @Run
    public void testThree(){
        System.out.println("testThree ran");
    }
}

public class MiniTestRunner{
    public static void main(String[] args)throws Exception{
        MyTests tests=new MyTests();
        int count=0;

        for(Method method:MyTests.class.getDeclaredMethods()){
            if(method.isAnnotationPresent(Run.class)&&method.getParameterCount()==0){
                method.invoke(tests);
                count++;
            }
        }

        System.out.println("Total tests ran: "+count);
    }
}