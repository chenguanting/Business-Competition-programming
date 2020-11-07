import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class problem2Q2 {
    ArrayList<String> arr=new ArrayList();

    public  static void A(String filename,PrintWriter output) throws FileNotFoundException {

        File file = new File(filename);
        Scanner input = new Scanner(file);
        int a = Integer.parseInt(input.nextLine());
        while (a > 0) {

            String[] str = input.nextLine().split(",");
            int max=1;
            int n = str[0].length();
            problem2Q2 problem2Q2 = new problem2Q2();
            int sec=Integer.parseInt(str[1].trim());
            int thd=Integer.parseInt(str[2].trim());
            ArrayList<String> arrlist=problem2Q2.permute(str[0], 0, n - 1);
            int num1=Integer.parseInt(arrlist.get(sec-1));
            int num2=Integer.parseInt(arrlist.get(thd-1));
            for (int k = 2; k <= num1; k++) {
                if (num1 % k == 0 && num2 % k == 0) {
                    max = k;
                }
            }
            output.println(max);
            a--;


        }


    }
    public ArrayList<String> permute(String str, int h, int r) {

        if (h == r) {



            arr.add(str);

        } else {
            for (int i = h; i <= r; i++) {
                str = swap(str, h, i);


                permute(str, h + 1, r);

            }

        }

        return arr;
    }


    public String swap(String a, int m, int n) {
        char temp;
        char[] chararray = a.toCharArray();
        temp = chararray[m];
        chararray[m] = chararray[n];
        chararray[n] = temp;
        return String.valueOf(chararray);

    }


    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output=new PrintWriter("out.txt");
        for(int i=1;i<3;i++) {
            String filename = String.format("in%s.txt", i);
            problem2Q2.A(filename,output);
            output.println();

        }
        output.close();
    }

}
