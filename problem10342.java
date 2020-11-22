import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class problem10342 {
    public static void main(String[] args) throws FileNotFoundException {
        int M, K, U, groupNum;
        PrintWriter output=new PrintWriter("out.txt");
        for (int doc = 1; doc < 3; doc++) {
            String filename = String.format("in%d.txt", doc);
            File file = new File(filename);
            Scanner input = new Scanner(file);
            groupNum = Integer.parseInt(input.nextLine());
            while (groupNum > 0) {
                String[] MKU = input.nextLine().split(",");
                M = Integer.parseInt(MKU[0]);
                K = Integer.parseInt(MKU[1]);
                U = Integer.parseInt(MKU[2]);
                int[][] array = new int[M][K+1];
                //把文字檔內數字存入二維陣列
                for (int i = 0; i <=M-1; i++) {
                    String[] Num = input.nextLine().split("(\\s)+");
                    for (int j = 0; j <=K; j++) {
                        array[i][j] = Integer.parseInt(Num[j]);
                    }
                }
                logic(K,U,array,output);


                groupNum--;
            }
            output.println();
        }
        output.close();
    }
    public static void logic(int K, int U,int array[][],PrintWriter output){
        int temp;
        ArrayList countList=new ArrayList();
        int count=0;
        for(int k=1;k<=K;k++){

                temp=array[U][k];
                while (temp!=999){
                    temp=array[temp][k];
                    count++;
                }
                countList.add(count);
                count=0;
        }

        for(int l=0;l<countList.size();l++){
            output.print(countList.get(l));
            if(l<countList.size()-1){
                output.print(",");
            }
        }
        output.println();

    }
}
