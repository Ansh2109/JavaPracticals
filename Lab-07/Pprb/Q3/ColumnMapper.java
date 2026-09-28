import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column{
    String name();
}

class Student{
    @Column(name="id")
    int id;

    @Column(name="name")
    String name;

    @Column(name="email")
    String email;

    public String toString(){
        return id+" "+name+" "+email;
    }
}

public class ColumnMapper{
    static <T>T map(String[] header,String[] data,Class<T> clazz)throws Exception{
        T obj=clazz.getDeclaredConstructor().newInstance();

        for(Field field:clazz.getDeclaredFields()){
            Column column=field.getAnnotation(Column.class);

            if(column==null){
                continue;
            }

            int index=-1;

            for(int i=0;i<header.length;i++){
                if(header[i].equals(column.name())){
                    index=i;
                    break;
                }
            }

            if(index==-1){
                throw new IllegalArgumentException("Missing column: "+column.name());
            }

            if(index>=data.length){
                throw new IllegalArgumentException("Missing data for column: "+column.name());
            }

            field.setAccessible(true);

            if(field.getType()==int.class){
                field.setInt(obj,Integer.parseInt(data[index]));
            }else if(field.getType()==String.class){
                field.set(obj,data[index]);
            }
        }

        return obj;
    }

    public static void main(String[] args)throws Exception{
        String[] header={"id","name","email"};
        String[] data={"101","Ansh","ansh@gmail.com"};

        Student student=map(header,data,Student.class);

        System.out.println(student);
    }
}