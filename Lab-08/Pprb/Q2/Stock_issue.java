import java.util.*;

class OutOfStockException extends Exception{
    private int shortfall;

    public OutOfStockException(String message,int shortfall){
        super(message);
        this.shortfall=shortfall;
    }

    public int getShortfall(){
        return shortfall;
    }
}

class InvalidQuantityException extends Exception{
    public InvalidQuantityException(String message){
        super(message);
    }
}

class Warehouse{
    private Map<String,Integer> stock=new HashMap<>();

    public void addItem(String item,int qty){
        stock.put(item,stock.getOrDefault(item,0)+qty);
    }

    public void issue(String item,int qty)throws OutOfStockException,InvalidQuantityException{
        if(qty<=0){
            throw new InvalidQuantityException("Quantity must be greater than zero");
        }

        int available=stock.getOrDefault(item,0);

        if(available<qty){
            int shortfall=qty-available;
            throw new OutOfStockException("Not enough stock for "+item+". Shortfall: "+shortfall,shortfall);
        }

        stock.put(item,available-qty);
        System.out.println("Issued "+qty+" "+item);
    }
}

public class Stock_issue{

    public static void main(String[] args){
        Warehouse warehouse=new Warehouse();

        warehouse.addItem("Laptop",5);
        warehouse.addItem("Mouse",10);
        warehouse.addItem("Keyboard",3);

        String[][] requests={
            {"Laptop","2"},
            {"Mouse","15"},
            {"Keyboard","0"},
            {"Keyboard","2"},
            {"Monitor","4"}
        };

        for(String[] request:requests){
            String item=request[0];
            int qty=Integer.parseInt(request[1]);

            try{
                warehouse.issue(item,qty);
            }catch(OutOfStockException e){
                System.out.println("Error:"+e.getMessage());
            }catch(InvalidQuantityException e){
                System.out.println("Error:"+e.getMessage());
            }
        }

        System.out.println("All requests processed.");
    }
}