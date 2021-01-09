import java.beans.beancontext.BeanContextMembershipListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class problem10432 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output=new PrintWriter("out.txt");
        for(int i=1;i<3;i++) {
            String filename = String.format("in%d.txt", i);
            File file = new File(filename);
            Scanner input = new Scanner(file);
            Enter(input,output);
            output.println();
        }
        output.close();
    }
    public static void Enter(Scanner input,PrintWriter output){
        int testGroup,Arow,Acolumn,Brow,Bcolumn;
        String  [] rowColumn;
        String  [] Str;
        testGroup=Integer.parseInt(input.nextLine());
        while (testGroup>0){
            rowColumn=input.nextLine().split(",");
            Arow=Integer.parseInt(rowColumn[0]);
            Acolumn=Integer.parseInt(rowColumn[1]);
            Brow=Integer.parseInt(rowColumn[2]);
            Bcolumn=Integer.parseInt(rowColumn[3]);
            //建立陣列 (A、B、AB)
            int [][] A=new int [Arow][Acolumn];
            int [][] B=new int [Brow][Bcolumn];
            int [][] AB=new int[Arow][Bcolumn];

            for(int i=0;i<A.length;i++){
                Str=input.nextLine().split("\\s+");
                for(int j=0;j<A[i].length;j++){
                    A[i][j]=Integer.parseInt(Str[j]);
                }
            }

            for(int i=0;i<B.length;i++){
                Str=input.nextLine().split("\\s+");
                for(int j=0;j<B[i].length;j++){
                    B[i][j]=Integer.parseInt(Str[j]);

                }
            }
            for(int i=0;i<AB.length;i++){
                Str=input.nextLine().split("\\s+");
                for(int j=0;j<AB[i].length;j++){
                    AB[i][j]=Integer.parseInt(Str[j]);
                }
            }


            for(int i=0;i<A.length;i++){
                for(int j=0;j<A[i].length;j++){
                    if(A[i][j]==9999) output.println(MatrixMulA(A.length,A[i].length,i,j,A,B,AB));
                }
            }
            for(int i=0;i<B.length;i++){
                for(int j=0;j<B[i].length;j++){
                    if(B[i][j]==9999) output.println(MatrixMulB(B.length,B[i].length,i,j,A,B,AB));
                }
            }


            testGroup--;

        }
    }

    public static int MatrixMulA(int row,int column,int i,int j,int [][] A,int [][]B,int[][]AB) {
        int[][] temp = new int[row][column];
        int Answer = 0;
        for (int r = 0; r <column; r++) {
            for (int c = 0; c <column; c++) {
                temp[i][r] += A[i][c] * B[c][r];
            }
            if (temp[i][r] != AB[i][r]) {
                Answer=IntoMatrixA(column,i,r,A,B,AB);
                break;
            }
        }
        return Answer;
    }
    public static int IntoMatrixA(int columnLen,int row,int column,int[][]A,int[][]B,int[][]AB){
        int answer;
        for(int r=0;r<columnLen;r++){
            if(A[row][r]==9999){AB[row][column]/=B[r][column];}
            else AB[row][column]-=A[row][r]*B[r][column];
        }
        answer=AB[row][column];
        return answer;
    }

    public static int MatrixMulB(int row,int column,int i,int j,int [][] A,int [][]B,int[][]AB) {
        int[][] temp = new int[row][column];
        int Answer = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < row; c++) {
                temp[j][r] += (A[j][c] * B[c][r]);
            }
            if (temp[j][r] != AB[j][r]) {
                Answer=IntoMatrixB(row,j,r,A,B,AB);
                break;
            }
        }
        return Answer;
    }


    public static int IntoMatrixB(int rowLen,int row,int column,int [][] A,int [][]B,int[][]AB){
        int answer;
        for(int c=0;c<rowLen;c++){
            if(B[c][column]==9999) AB[row][column]/=A[row][c];
            else AB[row][column]-=(B[c][column] * A[row][c]);
        }
        answer=AB[row][column];
        return answer;
    }
}
