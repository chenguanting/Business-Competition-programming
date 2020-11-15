import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class problem1033 {
    public static void Logic(String filename, PrintWriter output) throws FileNotFoundException {
        for (int i = 1; i < 3; i++) {

            File file = new File(filename);
            Scanner input = new Scanner(file);
            int testGroup = Integer.parseInt(input.nextLine());
            while (testGroup > 0) {
                String[] testData = input.nextLine().split(" ");
                int[] TestData = new int[testData.length];
                for (int k = 0; k < testData.length; k++) {
                    TestData[k] = Integer.parseInt(testData[k]);//TestData為轉換int後的值
                }
               //Queue


                int num = 1;
                int cards[][] = new int[5][14];
                for (int j = 1; j <= cards.length - 1; j++) {
                    for (int k = 1; k <= cards[i].length - 1; k++) {
                        cards[j][k] = num;
                        num++;//cards[1][1]=1..2..3..4
                    }
                }
                if (Shun(TestData) == true) {

                    if (TongHuaShun(TestData) == true) {
                        output.println("同花順");
                    } else {
                        output.println("順子");
                    }
                } else {
                    char Ans = Apair(TestData);

                    switch (Ans) {
                        case 'A': {
                            output.println("四條");
                            break;
                        }
                        case 'B': {
                            output.println("三條");
                            break;
                        }
                        case 'C': {
                            output.println("葫蘆");
                            break;
                        }
                        case 'D': {
                            output.println("兩對");
                            break;
                        }
                        case 'E': {
                            output.println("一對");
                            break;
                        }
                        default: {
                            output.println("雜牌");
                        }
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output = new PrintWriter("out.txt");
        for (int i = 1; i < 3; i++) {
            String filename = String.format("in%d.txt", i);

            Logic(filename, output);
            output.println();
        }
        output.close();
    }


    public static boolean Shun(int[] data) {
        int[] cardNum = new int[data.length];
        boolean ans = true;
        int d1 = 1;
        for (int i = 0; i < data.length; i++) {
            cardNum[i] = data[i] % 13;
        }

        Arrays.sort(cardNum);

        for (int i = 0; i < cardNum.length; i++) {

            for (int j = i + 1; j < cardNum.length; j++) {

                d1 = Math.abs(cardNum[i] - cardNum[j]);

                if (d1 == 1) {
                    break;
                } else {
                    ans = false;
                }
            }
        }
        return ans;
    }

    public static boolean TongHuaShun(int[] data) {
        boolean Ans = true;
        int[] cardFlower = new int[data.length];

        for (int i = 0; i < data.length; i++) {

            cardFlower[i] = data[i] / 13;

        }
        for (int i = 0; i < data.length; i++) {

            for (int j = i + 1; j < data.length; j++)

                if (cardFlower[i] != cardFlower[j]) {
                    Ans = false;
                }
        }
        return Ans;
    }

    public static char Apair(int[] data) {
        int[] cardNum = new int[data.length];
        int[] Num = new int[14];
        int three = 0, two = 0;
        int num;
        for (int i = 0; i < data.length; i++) {

            cardNum[i] = data[i] % 13;
        }
        for (int j = 0; j < cardNum.length; j++) {
            num = cardNum[j];
            Num[num] += 1;
        }

        for (int k = 0; k < Num.length; k++) {
            if (Num[k] >= 4) {
                return 'A';
            } else if (Num[k] == 3) {
                three += 1;
            } else if (Num[k] == 2) {
                two += 1;
            } else ;
        }
        if (three == 1 && two == 0) {
            return 'B';
        }//三條
        else if (three == 1 && two == 1) {
            return 'C';
        }//葫蘆
        else if (two == 2) {
            return 'D';
        }//兩對
        else if (two == 1) {
            return 'E';
        }//一對
        else {
            return '0';
        }//雜牌

    }


}