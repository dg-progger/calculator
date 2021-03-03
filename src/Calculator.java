import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {

        while (true)    // делаю программу цикличной

        {
            // прошу у пользователя ввод и проверяю его на правильность методом Valid
            Scanner in = new Scanner(System.in);
            String operationToExecute;
            System.out.println("Введите операцию:");


            do {
                operationToExecute = in.nextLine();
                if (operationToExecute.equals("stop")) {
                    System.exit(1); // стоп-слово, останавливающее программу
                }
            } while (!Valid(operationToExecute));


            // из введенной строки делаю массив строк, в котором 3 строки: первая - это первая цифра, вторая - это операнд, третья - вторая цифра
            String[] operationParts = operationToExecute.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

            double numb1 = Double.parseDouble(operationParts[0]);
            double numb2 = Double.parseDouble(operationParts[2]);

            // по операнду (второй строке в массиве строк) определяю, какой метод должен использовать калькулятор
            if (operationParts[1].equals("+")) {
                Sum sum = new Sum();
                sum.execute(numb1, numb2);
            }

            if (operationParts[1].equals("-")) {
                Minus minus = new Minus();
                minus.execute(numb1, numb2);
            }

            if (operationParts[1].equals("/")) {
                Divide divide = new Divide();
                divide.execute(numb1, numb2);
            }

            if (operationParts[1].equals("*")) {
                Multiply multiply = new Multiply();
                multiply.execute(numb1, numb2);
            }


        }
    }


    public static boolean Valid(String operationToExecute) {


        // проверяю правильность ввода
        for (int i = 0; i <= operationToExecute.length() - 1; i++) {
            char c = operationToExecute.charAt(i);
            if (!(Character.isDigit(c)) && (c != '+') && (c != '-') && (c != '/') && (c != '*')) {
                System.out.println("Введите операцию правильно (Пример: 17+4 или 21-13, без пробелов, только целочисленные значения):");
                return false;
            }
        }
        return true;
    }
}


class Operation {

    void execute(double numb1, double numb2) {
        System.out.println("Результат: " + numb1 + numb2);
    }
}

class Sum extends Operation {


    @Override
    void execute(double numb1, double numb2) {
        System.out.println("Результат: " + (numb1 + numb2));
    }

}

class Minus extends Operation {

    @Override
    void execute(double numb1, double numb2) {
        System.out.println("Результат: " + (numb1 - numb2));
    }

}

class Multiply extends Operation {

    @Override
    void execute(double numb1, double numb2) {
        System.out.println("Результат: " + (numb1 * numb2));
    }

}

class Divide extends Operation {

    @Override
    void execute(double numb1, double numb2) {
        System.out.println("Результат: " + (numb1 / numb2));
    }

}

