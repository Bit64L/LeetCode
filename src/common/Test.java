package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner lineScanner =new Scanner(System.in);
        System.out.print("Enter a space separated list of numbers: ");
        String line=lineScanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        String[] strs = line.split("\\s");
        for(String str : strs) list.add(str);
        System.out.println(Arrays.deepToString(strs));
    }

}
