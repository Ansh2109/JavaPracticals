package Pprb.Q1;

public class Driver{

    public static void main(String[] args) {
        String[] passwords = {"abc", "abcdefgh","Abcdefgh",
                "Abcd1234","Abcd1234!"};
        for(String s:passwords){
            System.out.println(s);

            System.out.println("Lenght >=8:" + PasswordChecker.minlenght(s));
            System.out.println("Uppercase:" + PasswordChecker.uppercase(s));
            System.out.println("Digit:" + PasswordChecker.digit(s));
            System.out.println("Special Character" + PasswordChecker.specialcharacter(s));
            System.out.println("Strength:" + PasswordChecker.strength(s));
        }
    }
}