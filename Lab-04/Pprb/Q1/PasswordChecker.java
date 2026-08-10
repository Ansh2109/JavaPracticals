package Pprb.Q1;
public class PasswordChecker{
    public static boolean minlenght(String pw){
        return pw.length()>=8;
    }
    public static boolean uppercase(String pw){
        return pw.matches(".*[A-Z].*");
    }
    public static boolean digit(String pw){
        return pw.matches(".*[0-9].*");
    }
    public static boolean specialcharacter(String pw){
        return pw.matches(".*[^a-zA-Z0-9].*");
    }
    public static String strength(String pw){
        int c=0;
        if(minlenght(pw)){
            c++;
        }
        if(uppercase(pw)){
            c++;
        }
        if(digit(pw)){
            c++;
        }
        if(specialcharacter(pw)){
            c++;
        }
        if(c<=1){
            return "Weak";
        }
        else if(c<=3){
            return "Medium";
        }
        else{
            return "Strong";
        }
    }
}