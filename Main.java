package KataCalculator;

import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("������� ���������: ");
        String line = scan.nextLine();
        System.out.println(Calc(line));
    }

    public static String Calc(String input) {

        ConvertTo convertTo = new ConvertTo();
        String[] symbols = {"+", "*", "-", "/"};
        String[] escSymbols = {"\\+", "\\*", "-", "/"};

        if (input.equals("exit")) {
            throw new RuntimeException("��������� ���������.");
        }

        int symbolIndex = -1;

        for (int i = 0; i < symbols.length; ++i) {
            for (int x = input.indexOf(symbols[i]); x != -1 ; x = input.indexOf(symbols[i], x+1)) {
                if (symbolIndex != -1) {
                    throw new RuntimeException("������� ����� ���������� � ������");
                }
                symbolIndex = i;
            }
        }

        String[] string = input.split(escSymbols[symbolIndex]);
        if (convertTo.romNum(string[0]) == convertTo.romNum(string[1])) {
            int a, b;
            boolean romNum = convertTo.romNum(string[0]);

            if (romNum) {
                a = convertTo.romToInt(string[0]);
                b = convertTo.romToInt(string[1]);

            } else {
                a = Integer.parseInt(string[0]);
                b = Integer.parseInt(string[1]);
            }

            if (a > 10 || b > 10 || a <= 0 || b <= 0) {
                throw new RuntimeException("����� ������ ���� �� 1 �� 10 ������������.");
            }

            int result = 0;
            switch (symbols[symbolIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    if (romNum && result < 0) {
                        throw new RuntimeException("� ������� ������� ��� ������������� �����");
                    }
                    break;
                case "/":
                    result = a / b;

                    break;
                case "*":
                    result = a * b;
                    break;
            }

            if (romNum) {
                if (result == 0) {
                    throw new RuntimeException("� ������� ������� ��� ����� \"0\".");
                }
                return (convertTo.intToRom(result));
            } else {
                return (Integer.toString(result));
            }
        } else {
            throw new RuntimeException("������������ ������ ������� ���������.");
        }
    }
}


