import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//[].size計算字串內的字元數量
public class problem10322 {
    public static void main(String[] args) throws IOException {
        PrintWriter output=new PrintWriter("out.txt");
        for(int i=1;i<3;i++) {
            String filename = String.format("in%d.txt", i);
            File file=new File(filename);
            Scanner input=new Scanner(file);
            int groupNum=Integer.parseInt(input.nextLine());
            while (groupNum>0){
                String [] line1=input.nextLine().split(" ");
                String [] line2=input.nextLine().split(" ");
                Friend(line1,line2,output);
                groupNum--;
            }
            output.println();
        }
        output.close();
    }
    public static void Friend(String[] line1,String[] line2,PrintWriter output){
        ArrayList common=new ArrayList();
        int size1=line1.length;
        int size2=line2.length;
        for(int i=0;i<size1;i++){
            for(int j=0;j<line2.length;j++){
                if(line1[i].equals(line2[j])&&common.contains(line2[j])==false){
                    common.add(line2[j]);
                }
            }
        }
        output.println(common.size());
    }
}
