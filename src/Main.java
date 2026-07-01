//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static double getNumber(){
        while(true){
            try{
                double num = scanner.nextDouble();
                return num;
            } catch (Exception e) {
                System.out.println("Please enter a number!");
                scanner.nextLine();
            }
        }
    }
    public static void main(String[] args) {
        while(true) {
            System.out.println("=".repeat(25));
            System.out.printf("%20s%n", "CALCULATOR MENU");
            System.out.println("=".repeat(25));
            System.out.printf("%-20s%s%n", "1. Addition", "(+)");
            System.out.printf("%-20s%s%n", "2. Subtraction", "(-)");
            System.out.printf("%-20s%s%n", "3. Multiplication", "(*)");
            System.out.printf("%-20s%s%n", "4. Division", "(/)");
            System.out.printf("%-20s%s%n", "5. Square Root", "(√)");
            System.out.printf("%-20s%s%n", "6. Power", "(^)");
            System.out.println("0. Exit");
            System.out.println("=".repeat(25));
            boolean condition = false;
            int secim = 0;
            do {
                try {
                    condition = false;
                    System.out.print("Enter your choice: ");
                    secim = scanner.nextInt();
                    if (0 > secim || 6 < secim) {
                        throw new InvalidNumException();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter integer number!");
                    scanner.nextLine();
                    condition = true;
                } catch (InvalidNumException e) {
                    System.out.println("Please enter number between 0-6 !");
                    scanner.nextLine();
                    condition = true;
                }
            } while (condition);
            double fNum = 0, sNum = 0;
            if (secim == 1 || secim == 2 || secim == 3) {
                System.out.print("Enter first number: ");
                fNum = getNumber();
                System.out.print("Enter second number: ");
                sNum = getNumber();
            }
            switch (secim) {
                case 0:
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println(fNum + " + " + sNum + " = " + (fNum + sNum));
                    break;
                case 2:
                    System.out.println(fNum + " - " + sNum + " = " + (fNum - sNum));
                    break;
                case 3:
                    System.out.println(fNum + " * " + sNum + " = " + (fNum * sNum));
                    break;
                case 4:
                    boolean case_4;
                    do {
                        case_4 = false;
                        System.out.print("Enter first number: ");
                        double numerator = getNumber();
                        System.out.print("Enter second number: ");
                        double denominator = getNumber();
                        if (denominator == 0) {
                            System.out.println("Please enter second number except 0!");
                            case_4 = true;
                        } else {
                            System.out.println(numerator + " / " + denominator + " = " + (numerator / denominator));
                        }
                    } while (case_4);
                    break;
                case 5:
                    boolean case_5;
                    do {
                        case_5 = false;
                        System.out.print("Enter a number: ");
                        double num = getNumber();
                        if (num < 0) {
                            System.out.println("Please enter a number except negative!");
                            case_5 = true;
                        } else {
                            System.out.println("√" + num + " = " + Math.sqrt(num));
                        }
                    } while (case_5);
                    break;
                case 6:
                    System.out.print("Enter base number: ");
                    double base = getNumber();
                    System.out.print("Enter power number: ");
                    double power = getNumber();
                    System.out.println(base + "^" + power + " = " + Math.pow(base, power));
                    break;
            }
        }
    }
}