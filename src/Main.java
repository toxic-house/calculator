import java.util.Scanner;

public class Main {

    public static void print(int msg) {
        System.out.println(msg);
    }

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static RomanInteger eval(RomanInteger a, String op, RomanInteger b) throws BadOperationException {
        switch (op) {
            case "+":
                return a.add(b);
            case "-":
                return a.minus(b);
            case "*":
                return a.times(b);
            case "/":
                return a.div(b);
        }
        throw new BadOperationException("Invalid operation");
    }

    public static int eval(int a, String op, int b) throws BadOperationException {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return (int) (a / b);
        }
        throw new BadOperationException("Invalid operation");
    }


    public static void main(String[] args) throws NotRomanException, BadOperationException {
        while (true) {
            print("next");
            Scanner myObj = new Scanner(System.in);
            String equation = myObj.nextLine();

            String[] els = equation.split(" ");
            String operation = els[1];

            try {
                int num1 = Integer.parseInt(els[0]);
                int num2 = Integer.parseInt(els[2]);
                int ans = eval(num1, operation, num2);

                print(ans);

            } catch (NumberFormatException e1) {
                RomanInteger num1 = new RomanInteger(els[0]);
                RomanInteger num2 = new RomanInteger(els[2]);
                RomanInteger ans = eval(num1, operation, num2);

                print(ans.toString());
            }

        }
    }
}
