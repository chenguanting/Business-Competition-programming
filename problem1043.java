import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class problem1043 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output=new PrintWriter("out.txt");
        for(int i=1;i<3;i++){
            String filename = String.format("in%d.txt", i);
            File file=new File(filename);
            Scanner input=new Scanner(file);
            Enter(input,output);
            output.println();
        }
        output.close();

    }
    public static void Enter(Scanner input,PrintWriter output){
        int TestGroup,Data;
        TestGroup=Integer.parseInt(input.nextLine());
        while (TestGroup>0){
            Data=Integer.parseInt(input.nextLine());
            output.println(TransBinary(Data));
            TestGroup--;
        }
    }
    public static int TransBinary(int data){
        int count=0;
        while (data>0){

            if(data%2==1){
                count++;
            }
            data/=2;

        }
        return count;
    }
}
