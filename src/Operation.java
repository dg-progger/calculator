import java.util.Scanner;


public class Operation {
    public static void main(String[] args) {

        while (true)    // делаю программу цикличной

            {
                // прошу у пользователя ввод и проверяю его на правильность методом Valid
            Scanner in = new Scanner(System.in);
            String operationToExecute;
            System.out.println("Введите операцию:");
            do {
                operationToExecute = in.nextLine();
            } while (!Valid(operationToExecute));


            // из введенной строки делаю массив строк, в котором 3 строки: первая - это первая цифра, вторая - это операнд, третья - вторая цифра
            String[] operationParts = operationToExecute.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

            // по операнду (второй строке в массиве строк) определяю, какой метод должен использовать калькулятор
            if (operationParts[1] == "+") {
                Sum sum = new Sum();
                sum.Execute(operationParts);
            }

            if (operationParts[1] == "-") {
                Minus minus = new Minus();
                minus.Execute(operationParts);
            }

            if (operationParts[1] == "/") {
                Divide divide = new Divide();
                divide.Execute(operationParts);
            }

            if (operationParts[1] == "*") {
                Multiply multiply = new Multiply();
                multiply.Execute(operationParts);
            }


        }
    }

    public static boolean Valid(String operationToExecute) {

        // проверяю правильность ввода
        for (int i = 0; i <= operationToExecute.length() - 1; i++) {
            char c = operationToExecute.charAt(i);
            if (!(Character.isDigit(c)) && (c != '+') && (c != '-') && (c != '/') && (c != '*')) {
                System.out.println("Введите операцию правильно (Пример: 17+4 или 21-13, без пробелов):");
                return false;
            }
        }
        return true;
    }
}


class Operation1 {

    int Execute(String[] operationParts) {
        int numb1 = Integer.parseInt(operationParts[0]);
        int numb2 = Integer.parseInt(operationParts[2]);
        System.out.println("Результат: " + numb1 + numb2);
        return numb1 + numb2;
    }
}

class Sum extends Operation1 {


    @Override
    int Execute(String[] operationParts) {
        int numb1 = Integer.parseInt(operationParts[0]);
        int numb2 = Integer.parseInt(operationParts[2]);
        System.out.println("Результат: " + (numb1 + numb2));
        return numb1 + numb2;
    }

}

class Minus extends Operation1 {

    @Override
    int Execute(String[] operationParts) {
        int numb1 = Integer.parseInt(operationParts[0]);
        int numb2 = Integer.parseInt(operationParts[2]);
        System.out.println("Результат: " + (numb1 - numb2));
        return numb1 - numb2;
    }

}

class Multiply extends Operation1 {

    @Override
    int Execute(String[] operationParts) {
        int numb1 = Integer.parseInt(operationParts[0]);
        int numb2 = Integer.parseInt(operationParts[2]);
        System.out.println("Результат: " + (numb1 * numb2));
        return numb1 * numb2;
    }

}

class Divide extends Operation1 {

    @Override
    int Execute(String[] operationParts) {
        int numb1 = Integer.parseInt(operationParts[0]);
        int numb2 = Integer.parseInt(operationParts[2]);
        System.out.println("Результат: " + (numb1 / numb2));
        return numb1 / numb2;
    }

}

