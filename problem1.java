import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.PrintWriter;
//****找出這字串中阿拉伯數的字元****
public class problem1 {

    public static void A(String filename,PrintWriter output) throws FileNotFoundException {//核心邏輯 建立方法
        File file = new File(filename);
        Scanner input = new Scanner(file);
        TreeSet<String> hset = new TreeSet<>();

        String fir = input.nextLine();
        while (input.hasNext()) {
            String str1 = input.nextLine();
            for (int i = 0; i < str1.length(); i++) {

                if (str1.charAt(i) >= 48 && str1.charAt(i) <= 57) {//轉換ASCII
                    char str2 = str1.charAt(i);
                    String str3 = String.valueOf(str2);

                    hset.add(str3);//存到TREESET 不重複且排序

                } else if ((i == (str1.length()-1)) && ((str1.charAt(i) >= 48 && str1.charAt(i) <= 57)==false)) {
                    output.print("N");
                }

            }

            Iterator k = hset.iterator();//迭代輸出
            while (k.hasNext()) {

                output.print(k.next());


            }
            output.println();

            hset.clear();

        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        java.io.PrintWriter output = new java.io.PrintWriter("out.txt");

        A( "C:\\Users\\Guan Ting\\Downloads\\術科檢測資料_1\\術科檢測資料_1\\Problem1\\子題1\\in1.txt",output);
        output.println();
        A( "C:\\Users\\Guan Ting\\Downloads\\術科檢測資料_1\\術科檢測資料_1\\Problem1\\子題1\\in2.txt" ,output);
        output.close();//記得關閉

    }
}
