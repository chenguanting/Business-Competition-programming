import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;
/*國際標準書號 ISBN。
須注意幾點
1.main呼叫副程式與副程式呼叫方法 要加static
2.字串跟整數比較要先轉換同為string或同為int才可
3.使用toCharArray方法 會傳回該數的ASCII碼 使用48扣除Math.abs方法即可

*/

public class problem4 {

    public static void Logic(String filename, PrintWriter output) throws IOException {
        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));
        int testNumber = Integer.parseInt(br.readLine());//輸入測試資料組
        while (testNumber > 0) {
            String line = br.readLine();//測試資料
            int len=line.length();//data的長度 以此區別10碼帶有-號，13碼帶有-號以及13碼不帶-號
            if (line.contains("-")&&(len<=13)) {
                String[] ISBN = line.split("-");//以-號區別各碼 分別是國碼、出版機構、序號與檢查碼
                String nation = ISBN[0];
                String publish = ISBN[1];
                String serial = ISBN[2];
                String checkNumber = ISBN[3];
                String ISBN10 = nation.concat(publish).concat(serial).concat(checkNumber);
                int ans=checkISBN10(ISBN10);//ans用來回傳N值，以N值對應檢查碼
                showAnswer10(ans,checkNumber,output);

            } else if(line.contains("-")&&(len>13)) {
                String[] ISBN2 = line.split("-");
                String nation = ISBN2[0];
                String language=ISBN2[1];
                String publish = ISBN2[2];
                String serial = ISBN2[3];
                String checkNumber = ISBN2[4];
                String ISBN13=nation.concat(language).concat(publish).concat(serial).concat(checkNumber);
                int ans=checkISBN13(ISBN13);
                showAnswer13(ans,checkNumber,output);


            }else {//此區為13碼不帶-號 直接判斷是否等於line的最後一碼檢查碼
                char [] charline=line.toCharArray();
                int check=Math.abs(48-charline[line.length()-1]);
                int ans=checkISBN132(line);
                if(ans==check){
                    output.println("T");
                }else output.println("F");
            }


            testNumber--;
        }


    }

    public static int checkISBN10(String ISBN10) {//此區判斷10碼
        int S=0; int weight=10;
        int M,N;
        char [] charISBN10= ISBN10.toCharArray();
        for (int i = 0; i < ISBN10.length()-1; i++) {

            S+=Math.abs(48-(charISBN10[i]))*weight;//返回為char值 使用48扣除再abs
            weight--;
        }
        M=S%11;
        N=11-M;
        return N;//對應到ans
    }

    public static int checkISBN13(String ISBN13)//此區檢查13碼並有-符號
    {
        int S=0;
        int M,N;
        char[] charISBN13=ISBN13.toCharArray();
        for (int i = 0; i < ISBN13.length()-1; i++){
            if(i%2==0){
                S+=Math.abs(48-charISBN13[i])*1;
            }
            else {
                S+=Math.abs(48-charISBN13[i])*3;
            }
        }
        M=S%10;
        N=10-M;
        return N;
    }
    public static int checkISBN132(String ISBN13){//此區檢查13碼並無-符號
        char[] charISBN13=ISBN13.toCharArray();
        int ans=Math.abs(48-charISBN13[ISBN13.length()-1]);
        return ans;
    }
   public static void showAnswer10(int ans,String checkNumber,PrintWriter output){//此區為輸出用

        if(ans==10){
            if(checkNumber.equals("X"))
            {
                output.println("T");
            }else output.println("F");
        }else if(ans==11){
            if(Integer.parseInt(checkNumber)==(0)){
                output.println("T");
            }else output.println("F");
        }else {
            if(Integer.parseInt(checkNumber)==(ans))
            {
                output.println("T");
            }else output.println("F");
        }






        /*switch (ans){//使用switch寫法失敗
           case 10:
               if(checkNumber.equals("X")) output.println("T");
               else output.println("F");break;
           case 11:
               if(checkNumber.equals(0)) output.println("T");
               else  output.println("F");break;
           default: output.println(ans);
       }*/
   }
    public static void showAnswer13(int ans,String checkNumber,PrintWriter output){
        if(ans==10){
            if(Integer.parseInt(checkNumber)==(0))
            {
                output.println("T");
            }else output.println("F");
        } else {
            if(Integer.parseInt(checkNumber)==(ans))
            {
                output.println("T");
            }else output.println("F");
        }
    }
        public static void main (String[]args) throws IOException {


            PrintWriter output = new PrintWriter("out.txt");
           for(int i=1;i<3;i++) {
               String filename=String.format("in%d.txt",i);
               Logic(filename, output);
               output.println();
           }
            output.close();


        }

}
