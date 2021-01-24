import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class problem10442 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output = new PrintWriter("output.txt");
        for (int i = 1; i < 2; i++) {
            String filename = String.format("in%d.txt", i);
            File file = new File(filename);
            Scanner input = new Scanner(file);
            Enter(output,input);
        }
        output.close();
    }
    public static void Enter(PrintWriter output,Scanner input){

        int DataNum=Integer.parseInt(input.nextLine());
        while (DataNum>1){

            String [] Line=input.nextLine().split(",| ");

            //for(int i=0;i<Line.length;i++) System.out.println(Line[i]);測試用

            int LineLen=Line.length;//以第一題來說=30
            int Group=LineLen/3;
            String [][] vertex=new String[Group][3];
            int len=0;
            for(int i=0;i<vertex.length;i++){
                for(int j=0;j<vertex[i].length;j++){
                    vertex[i][j]=Line[len];
                    if(len<LineLen) len++;
                }
            }
            Arrays.sort(vertex, new java.util.Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.compare(Integer.parseInt(o1[2]),Integer.parseInt(o2[2]));
                }
            });
            for(int i=0;i<vertex.length;i++){
                for(int j=0;j<vertex[i].length;j++){
                    System.out.print(vertex[i][j]);
                }
                System.out.println();
            }

            DataNum--;
        }
    }
}
