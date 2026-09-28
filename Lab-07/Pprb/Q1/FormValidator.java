import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
    int value();
}

class SignupForm{
    @NotBlank
    @MaxLength(20)
    String username;

    @NotBlank
    @MaxLength(50)
    String email;

    @MaxLength(10)
    String phone;

    SignupForm(String username,String email,String phone){
        this.username=username;
        this.email=email;
        this.phone=phone;
    }
}

public class FormValidator{
    static List<String> validate(Object obj)throws Exception{
        List<String> errors=new ArrayList<>();

        for(Field field:obj.getClass().getDeclaredFields()){
            field.setAccessible(true);
            Object value=field.get(obj);

            if(field.isAnnotationPresent(NotBlank.class)){
                if(value==null||value.toString().trim().isEmpty()){
                    errors.add(field.getName()+" must not be blank");
                }
            }

            MaxLength max=field.getAnnotation(MaxLength.class);
            if(max!=null&&value!=null&&value.toString().length()>max.value()){
                errors.add(field.getName()+" must be at most "+max.value()+" characters");
            }
        }

        return errors;
    }

    public static void main(String[] args)throws Exception{
        SignupForm form=new SignupForm("","thisemailaddressiswaytoolong@example.com","12345678901");

        List<String> errors=validate(form);

        if(errors.isEmpty()){
            System.out.println("Form is valid");
        }else{
            for(String error:errors){
                System.out.println(error);
            }
        }
    }
}