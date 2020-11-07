import com.sun.security.jgss.GSSUtil;




import java.io.File;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.*;
//****樂透****
public class problem1Q2
{
    public static void main(String[] args) throws FileNotFoundException,java.io.IOException//小林的
    {
        int i=0,j=0,k=0,l=0,m=0;
        FileWriter myWriter = new FileWriter("out.txt");
        for(i=1;i<3;i++)
        {
            String FileName = String.format("in%s.txt", i);
            File file=new File(FileName);
            Scanner input=new Scanner(file);
            input.useDelimiter("(\\s|,|\\n)+");//把所有符號含空格換行切割 使數字連續 作用範圍-整個檔案
            int n1 = Integer.parseInt(input.next());
            for(j=0;j<n1;j++)
            {
                int n2 = Integer.parseInt(input.next())*5;//20
                int Number[] = new int[40];
                for(k=0;k<n2;k++)
                {
                    m = Integer.parseInt(input.next());
                    Number[m] = Number[m]+1;//儲存出現頻率
                }
                int maxindex = 1;
                int max = Number[1];
                for(k=2;k<40;k++)
                {
                    if(Number[k]>max)
                    {
                        maxindex = k;
                        max = Number[k];
                    }
                }
                List<String> Ans = new ArrayList<>();
                for(k=1;k<40;k++)
                    if(max == Number[k])
                        Ans.add(String.format("%02d", k));
                String Answer = String.join(", ", Ans);
                myWriter.write(String.format("%s%n", Answer));
            }
            myWriter.write(String.format("%s%n",""));
        }
        myWriter.close();
    }
}

/*import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class  lottery{//副程式
    int n1;
    int [] index=new int[39];//存入數字出現頻率

    void loadnumber(Scanner input){//載入數字 另toString功能可顯示輸出的格式 用sout來呼叫

        n1=input.nextInt();
        index[n1]+=1;
    }
    void pp(){//來判斷最大值

        int max=index[0];
        for(int i=1;i<index.length;i++){
             if(max<index[i]) {
                 max = index[i];//產生陣列內最大的值max
             }
        }
        for(int i=0;i<index.length;i++){
            if(index[i]==max)
            {
                if(i<10){
                    System.out.print("0"+i+",");
                }else {
                    System.out.print(i+",");
                }

            }
        }
    }
    void ppclear(){//清除 然後再裝入下一組
        for(int i=0;i<index.length;i++){
            index[i]=0;
        }
    }

}


public class problem1Q2 {
    public static void A(String filename, PrintWriter output){ //邏輯
        Scanner input=new Scanner(filename).useDelimiter("(\\s|\\n|,)+");

        lottery lotter=new lottery();
        int num=input.nextInt();
        while(num>0){
            int num1=input.nextInt();
            while (num1>0) {
                for (int i =0; i<5;i++) {
                    lotter.loadnumber(input);

                }
                num1--;
            }
            lotter.pp();
            System.out.println();
            lotter.ppclear();

            num--;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {//主程式 開檔 閉檔
        java.io.PrintWriter output=new java.io.PrintWriter("out.txt");
        A("C:\\Users\\Guan Ting\\Downloads\\術科檢測資料_1\\術科檢測資料_1\\Problem1\\子題2\\in1.txt",output);
        output.println();
        A("C:\\Users\\Guan Ting\\Downloads\\術科檢測資料_1\\術科檢測資料_1\\Problem1\\子題2\\in2.txt",output);
        output.close();

    }
}*/
