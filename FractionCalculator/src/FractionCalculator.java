import java.util.*;


public class FractionCalculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        intro();
        String operation = "";
        while (true){
            operation = getOperation(input).toLowerCase();
            if (operation.equalsIgnoreCase("q")){
                System.exit(0);
            } else {
                Fraction frac1 = getFraction(input);
                Fraction frac2 = getFraction(input);
                if (operation.equals("/") && frac2.getNumerator() == 0){
                    System.out.println(frac1.toString() + " " + operation + " " + frac2.toString() + " = Undefined");
                    System.out.println("--------------------------------------------------------------------------------");
                } else if (operation.equals("=")) {
                    System.out.println(frac1.toString() + " " + operation + " " + frac2.toString() + " is " + frac1.equals(frac2));
                    System.out.println("--------------------------------------------------------------------------------");
                } else {
                    Fraction result = performCalc(operation, frac1, frac2);
                    System.out.println(frac1.toString() + " " + operation + " " + frac2.toString() + " = " + result.toString());
                    System.out.println("--------------------------------------------------------------------------------");
                }

            }

        }
    }
    static void intro(){
        System.out.println("This program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("--------------------------------------------------------------------------------");
    }

    static String getOperation(Scanner input){
        String[] validInput = {"+", "-", "/", "*", "=", "q", "Q"};
        boolean valid = false;
        String entry = "";
        System.out.print("Please enter an operation (+, -, /, *, =, or Q to quit): ");
        while (!valid){
            entry = input.nextLine();
            if (Arrays.asList(validInput).contains(entry)){
                valid = true;
            } else {
                System.out.print("Invalid input (+, -, /, *, =, or Q to quit): ");
            }
        }
        return entry;
    }

    static boolean validFraction(String input){
        return input.matches("^-?[0-9]+(/[1-9][0-9]*)?$");
    }

    static Fraction getFraction(Scanner input){
        boolean valid = false;
        String entry = "";
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        while (!valid) {
            entry = input.nextLine();
            if (validFraction(entry)){
                valid = true;
            } else {
                System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            }
        }
        if (entry.matches("^-?[0-9]+$")){
            return new Fraction(Integer.parseInt(entry));
        } else {
            String[] splitEntry = entry.split("/");
            return new Fraction(Integer.parseInt(splitEntry[0]), Integer.parseInt(splitEntry[1]));
        }
    }

    static Fraction performCalc(String operation, Fraction frac1, Fraction frac2){
        Fraction result = new Fraction();
        switch (operation) {
            case "+":
                result = frac1.add(frac2);
                break;
            case "-":
                result = frac1.subtract(frac2);
                break;
            case "*":
                result = frac1.multiply(frac2);
                break;
            case "/":
                result = frac1.divide(frac2);
                break;
        }
        return result;
    }
}
