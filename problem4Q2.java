import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.jar.JarOutputStream;

//1.使用陣列排序Array.sort方法
public class problem4Q2 {
    public static void Logic(String filename, PrintWriter output) throws FileNotFoundException {
        File file = new File(filename);
        Scanner input = new Scanner(file);
        int testGroup = Integer.parseInt(input.nextLine());
        while (testGroup > 0) {
            String[] testData = input.nextLine().split("(\\s|\\n)+");
            int[] TestData = new int[testData.length];
            for (int k = 0; k < testData.length; k++) {
                TestData[k] = Integer.parseInt(testData[k]);//TestData為轉換int型態後的testData 以方便做後續計算
            }


            int num = 1;//數字從1開始 黑桃1對應1 依序累加 直到梅花k為52
            int cards[][] = new int[5][14];//總共有 四種花色 13個數字 為了以1開始 故增加一個容量

            //23-29行-將卡牌依序存入cards[][]
            for (int i = 1; i <= cards.length - 1; i++) {
                for (int j = 1; j <= cards[i].length - 1; j++) {
                    cards[i][j] = num;
                    num++;
                }
            }
            /*31-66行 為判斷卡牌類型
            Shun()判斷順子 TongHuaShun()判斷同花順 同花順的前提是順子要為true
            也就是順子為先決條件，如果排序後公差是1表示數字連續，然後花色又一樣，就
            可成立同花順。
            Apair()判斷剩下卡牌
            若卡牌非順子/同花順 則進入剩下卡牌判斷
            * */
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
            testGroup--;
        }


    }
    //順子邏輯- 1.將卡牌內容%13算出對應的數字部分 2.排序 3.計算公差是否為1
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
    //同花順邏輯-使用cardFlower來存花色 花色使用/13來取得
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
    /*剩餘卡牌邏輯-cardNum存卡牌數字
      Num存入每個數字出現的頻率
      使用int變數來判斷該數字出現幾次
    */
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
        if (three == 1 && two == 0) { return 'B'; }//三條
        else if (three == 1 && two == 1) { return 'C'; }//葫蘆
        else if (two == 2) { return 'D'; }//兩對
        else if (two == 1) { return 'E'; }//一對
        else { return '0'; }//雜牌

    }


    public static void main(String[] args) throws IOException {
        PrintWriter output = new PrintWriter("out.txt");
        for(int i=1;i<3;i++) {
            String filename=String.format("in%d.txt",i);

            Logic(filename,output);
            output.println();
        }
        output.close();
    }
}