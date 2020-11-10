import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Scanner;

public class problem10312 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output=new PrintWriter("out.txt");
        for(int i=1;i<3;i++) {
            String filename = String.format("in%d.txt", i);
            File file = new File(filename);
            Scanner input=new Scanner(file);
            int groupNumber=Integer.parseInt(input.nextLine());
            while (groupNumber>0){
                String [] data=input.nextLine().split(",");
                int stampNum=Integer.parseInt(data[0]);
                int Denomination1=Integer.parseInt(data[1]);
                int Denomination2=Integer.parseInt(data[2]);
                int total=Integer.parseInt(data[3]);
                stamp(stampNum,Denomination1,Denomination2,total,output);
                groupNumber--;
            }
            output.println();
        }
        output.close();
    }

    public static void stamp(int stampNum ,int Denomination1 ,int Denomination2,int total,PrintWriter output) {

        for(int x=0;x<=stampNum;x++){
            for(int y=0;y<=stampNum;y++){
                if((x*Denomination1+y*Denomination2)==total&&(x+y==stampNum)){
                    output.println(x+","+y);
                    break;
                }
            }
        }

    }
}
