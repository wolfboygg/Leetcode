package printN;

import java.util.Arrays;

public class PrintOrderN {

    public void print1ToMaxOfNDigits(int n) {
        if (n == 0) {
            return;
        }
        char[] numbers = new char[n];
        print1ToMaxOfNDigits(numbers, 0);
    }

    public void print1ToMaxOfNDigits(char[] numbers, int index) {
        if (index == numbers.length) {
            printNumber(numbers);
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index] = (char) (i + '0');
            print1ToMaxOfNDigits(numbers, index + 1);
        }
    }

    public void printNumber(char[] numbers) {
        int index = 0;
        while(index < numbers.length && numbers[index] =='0') {
            index++;
        }
        while (index < numbers.length) {
            System.out.print(numbers[index++]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new PrintOrderN().print1ToMaxOfNDigits(1);
    }
}
