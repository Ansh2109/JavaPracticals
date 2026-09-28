class MyResource implements AutoCloseable{

    public MyResource(){
        System.out.println("Resource opened");
    }

    public void use(){
        System.out.println("Using resource");
    }

    public void close(){
        System.out.println("Resource closed");
    }
}

public class AutoCloseDemo{

    public static void main(String[] args){
        try(MyResource resource=new MyResource()){
            resource.use();
            throw new RuntimeException("Something went wrong");
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }

        System.out.println("Program completed");
    }
}