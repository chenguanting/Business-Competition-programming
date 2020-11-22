import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class problem1034 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output=new PrintWriter("out.txt");
        String [] binaryCode=new String[3];
        binaryCode[0]="00";
        binaryCode[1]="01";
        binaryCode[2]="100";
        String [] totalBinary=new String[10];
        totalBinary[0]="00";
        totalBinary[1]="01";
        totalBinary[2]="100";
        totalBinary[3]="101";
        totalBinary[4]="1100";
        totalBinary[5]="1101";
        totalBinary[6]="11100";
        totalBinary[7]="11101";
        totalBinary[8]="111100";
        totalBinary[9]="111101";
        //上面為新制二元碼
        ArrayList binaryArray=new ArrayList();
        ArrayList englishCode=new ArrayList();
        int groupNum,Num=68;
        String line;
        //0開頭
        for(int i=1;i<=9;i++){
            binaryArray.add(binaryCode[0].concat(totalBinary[i]));
        }
        //1開頭
        for(int i=0;i<=9;i++){
            binaryArray.add(binaryCode[1].concat(totalBinary[i]));
        }
        //2開頭
        for(int i=0;i<=6;i++){
            binaryArray.add(binaryCode[2].concat(totalBinary[i]));
        }
        //二元碼與對應英文的 轉換
        for(int j=0;j<binaryArray.size();j++){
            if(j==23){
                englishCode.add((char)65);
            }else if(j==24){
                englishCode.add((char)66);
            }else if(j==25){
                englishCode.add((char)67);
            }else
                englishCode.add((char)Num);
            Num++;

        }

        for(int Doc=1;Doc<3;Doc++) {
            String filename = String.format("in%d.txt", Doc);
            File file=new File(filename);
            Scanner input=new Scanner(file);
            groupNum=Integer.parseInt(input.nextLine());
            while (groupNum>0){
                line=input.nextLine();
                for(int k=0;k<26;k++){
                    if(line.equals(binaryArray.get(k))){
                        output.println(englishCode.get(k));
                    }
                }
                groupNum--;

            }
            output.println();
        }
        output.close();

    }
}
