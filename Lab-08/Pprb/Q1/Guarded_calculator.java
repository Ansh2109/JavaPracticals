import java.util.*;

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}

class InvalidOperatorException extends Exception {
    public InvalidOperatorException(String message) {
        super(message);
    }
}

class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class Guarded_calculator {

    private static double parseNumber(String input) throws InvalidNumberException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Invalid number format: '" + input + "'. Please enter numeric values only.");
        }
    }

private static double calculate(double num1, double num2, String op) throws InvalidOperatorException,DivideByZeroException {
        return switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    throw new DivideByZeroException("Division by zero error");
                }
                yield num1 / num2;
            }
            default -> throw new InvalidOperatorException("Invalid operator");
        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean t = false;

        while (!t) {
            try {
                System.out.print("Enter number 1:");
                double num1=parseNumber(s.nextLine());

                System.out.print("Enter number 2:");
                double num2=parseNumber(s.nextLine());

                System.out.print("Enter operator(+, -, *, /):");
                String op=s.nextLine();

                double result = calculate(num1,num2,op);
                System.out.printf("Result: %s %s %s = %.2f%n", num1, op, num2, result);
                t = true;

            } catch (InvalidNumberException|InvalidOperatorException|DivideByZeroException e) {
                System.out.println("Error:" + e.getMessage());
            } 
        }

        s.close();
    }
}