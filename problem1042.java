import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
//關於static 取決於可否獨立呼叫 若沒有聲明static 則透過該class呼叫
public class problem1042 {
    ArrayList<String> arr=new ArrayList();
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output=new PrintWriter("out.txt");
        for(int i=1;i<3;i++) {
            String filename = String.format("in%d.txt",i);
            File file = new File(filename);
            Scanner input=new Scanner(file);
            Enter(input,output);
            output.println();
        }
        output.close();
    }
    public static void Enter(Scanner input,PrintWriter output){
        int testGroup,len,sec,thd,Answer;
        String dataLine[];
        int Num1,Num2;
        problem1042 pro=new problem1042();
        ArrayList <String > combine;
        testGroup=Integer.parseInt(input.nextLine());

        while (testGroup>0){
            dataLine=input.nextLine().split(",");

            len=dataLine[0].length();
            sec=Integer.parseInt(dataLine[1].trim());
            thd=Integer.parseInt(dataLine[2].trim());
            combine=pro.permute(dataLine[0],0,len-1);
            Num1=Integer.parseInt(combine.get(sec-1));
            Num2=Integer.parseInt(combine.get(thd-1));
            Answer=Num1+Num2;
            output.println(Answer);

            combine.clear();


            testGroup--;
        }

    }
    public  ArrayList<String> permute(String str, int fir, int lat){

        if(fir==lat){
            arr.add(str);
        }else {
            for(int i=fir;i<=lat;i++){
                str=swap(str,fir,i);
                permute(str,fir+1,lat);

            }

        }

        return arr;
    }
    //string轉為char 方面擷取字元 對調
    public static String swap(String a,int m,int n){
        char temp;
        char[] charArray=a.toCharArray();
        temp=charArray[m];
        charArray[m]=charArray[n];
        charArray[n]=temp;
        return String.valueOf(charArray);

    }
}
