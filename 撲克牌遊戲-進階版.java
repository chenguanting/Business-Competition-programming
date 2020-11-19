import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
//使用Collections.max(score)直接獲取最大值
public class problem1033 {
    public static void Logic(String filename, PrintWriter output) throws FileNotFoundException {

            File file = new File(filename);
            Scanner input = new Scanner(file);
            int[] cardArray = new int[5];
            ArrayList score = new ArrayList();
            /*int num = 1;
            int cards[][] = new int[5][14];
            for (int j = 1; j <= cards.length - 1; j++) {
                for (int k = 1; k <= cards[j].length - 1; k++) {
                    cards[j][k] = num;
                    num++;//cards[1][1]=1..2..3..4
                }
            }用不到*/
            int testGroup = Integer.parseInt(input.nextLine());
            while (testGroup > 0) {//資料組
                String[] testData = input.nextLine().split(" ");
                int[] TestData = new int[testData.length];
                for (int k = 0; k < testData.length; k++) {
                    TestData[k] = Integer.parseInt(testData[k]);
                }//TestData為轉換int後的值
                Queue queue = new LinkedList();//使用佇列 鏈結串列 使用先進先出概念
                for (int g = 0; g < TestData.length; g++) {
                    queue.offer(TestData[g]);//先把資料加進去queue
                }
                int route=queue.size();//以queue的size跑一圈 route=6 6個數字表示6組 不重複組合
                while (route>0) {

                    int temp;
                    for (int e = 0; e < queue.size() - 1; e++) {
                        temp = (int) queue.poll();
                        cardArray[e] = temp;
                        queue.offer(temp);//先取出再存入cardArray ,cardArray存入當前五個數字 然後進入方法判斷最後再放到佇列後
                    }



                    if (Shun(cardArray) == true) {

                        if (TongHuaShun(cardArray) == true) {
                            score.add(7);//使用 一個score陣列 存入score數字
                        } else {
                            score.add(4);
                        }
                    } else {
                        char Ans = Apair(cardArray);

                        switch (Ans) {
                            case 'A': {
                                score.add(6);
                                break;
                            }
                            case 'B': {
                                score.add(3);
                                break;
                            }
                            case 'C': {
                                score.add(5);
                            }
                            case 'D': {
                                score.add(2);
                                break;
                            }
                            case 'E': {
                                score.add(1);
                                break;
                            }
                            default: {
                                score.add(0);
                            }
                        }

                    }
                route--;
                }
                output.println(Collections.max(score));
                score.clear();
                testGroup--;
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
