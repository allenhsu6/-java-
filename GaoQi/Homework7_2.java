package GaoQi;

import java.util.Scanner;

public class Homework7_2 {
    public static void main(String[] args) {
        char[] word = {'h', 'e', 'l', 'l', 'o'};
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (int i = 0; i < word.length && s.charAt(i) == word[i]; i++) {
            if (i == word.length - 1) System.out.println(true);
        }

    }

}
