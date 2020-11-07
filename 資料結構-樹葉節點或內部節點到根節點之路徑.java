import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class problem3 {

    public static void define(String filename, PrintWriter output) throws FileNotFoundException {//定義值 與讀取資料
        File file = new File(filename);
        Scanner input = new Scanner(file);

        int testNumber = Integer.parseInt(input.nextLine());
        while (testNumber > 0) {
            String[] data = input.nextLine().split(",");//第一個是節點總數，第二個是要判斷路徑長度的值
            int totalNode = Integer.parseInt(data[0]);
            int length = Integer.parseInt(data[1]);
            int[] node = new int[totalNode];
            int[] fatherNode = new int[totalNode];
            for (int i = 0; i < totalNode; i++) {//把兩列值存入兩陣列
                String[] nodeData = input.nextLine().split(",");
                node[i] = Integer.parseInt(nodeData[0]);
                fatherNode[i] = Integer.parseInt(nodeData[1]);
            }
            int[] answerList = tree(node, fatherNode);
            int sum = 0;
            for (int e : answerList) {
                if (e == length) {
                    sum += 1;
                }

            }
            output.println(sum);

            testNumber--;
            if (testNumber == 2 || testNumber == 1)
                input.nextLine();
        }
    }

    public static int[] tree(int[] array1, int[] array2) {//副程式 核心邏輯 判斷任意節點到跟節點路徑長
        int dist;

        int[] answerList = new int[8];
        for (int i = 0; i < array1.length; i++) {
            dist = 0;
            for (int j = i; j < array2.length; ) {
                if (array2[j] == 99) {
                    dist += 0;
                    answerList[i] = dist;
                    break;
                } else {
                    dist += 1;
                    j = array2[array1[j]];
                }
            }
        }
        return answerList;
    }

    public static void main(String[] args) throws FileNotFoundException {//主程式
        PrintWriter output = new PrintWriter("out.txt");
        for (int i = 1; i < 3; i++) {
            String filename = String.format("in%d.txt", i);
            output.println();
            define(filename,output);

        }
        output.close();


    }

}
