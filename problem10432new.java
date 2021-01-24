import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class problem10432new {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output=new PrintWriter("out.txt");
        for(int i=1;i<3;i++) {
            String filename = String.format("in%d.txt", i);
            File file=new File(filename);
            Scanner input=new Scanner(file);
            int DataGroup=Integer.parseInt(input.nextLine());
            while (DataGroup>0){
                String [] rowCol=input.nextLine().split(",");
                int aRow=Integer.parseInt(rowCol[0]);
                int aCol=Integer.parseInt(rowCol[1]);
                int bRow=Integer.parseInt(rowCol[2]);
                int bCol=Integer.parseInt(rowCol[3]);
                int [][] A=new int[aRow][aCol];
                int [][] B=new int[bRow][bCol];
                int [][] AB=new int [aRow][bCol];
                for(int Ar=0;Ar<A.length;Ar++){
                    String [] Str=input.nextLine().split("\\s+");
                    for(int Ac=0;Ac<A[Ar].length;Ac++){
                        A[Ar][Ac]=Integer.parseInt(Str[Ac]);
                    }
                }
                for(int Br=0;Br<B.length;Br++){
                    String [] Str=input.nextLine().split("\\s+");
                    for(int Bc=0;Bc<B[Br].length;Bc++){
                        B[Br][Bc]=Integer.parseInt(Str[Bc]);
                    }
                }
                for(int ABr=0;ABr<AB.length;ABr++){
                    String [] Str=input.nextLine().split("\\s+");
                    for(int ABc=0;ABc<AB[ABr].length;ABc++){
                        AB[ABr][ABc]=Integer.parseInt(Str[ABc]);

                    }
                }
                TempArray(A,B,AB,aRow,bCol,output);


                DataGroup--;
            }
        }
        output.close();
    }
    public static void TempArray(int[][]A,int [][]B,int[][]AB,int aRow,int bCol,PrintWriter output){
        int [][] Temp=new int[aRow][bCol];
        boolean Matrix=false;
        for(int i=0;i<AB.length;i++){
            for(int j=0;j<AB[i].length;j++){
                for(int k=0;k<B.length;k++){
                    Temp[i][j]+=A[i][k]*B[k][j];
                }
                if(Temp[i][j]!=AB[i][j]) {
                    ABMatrix(i, j, A, B, AB,output);
                    Matrix=true;
                    break;
                }
            }
            if(Matrix==true) break;
        }
    }
    public static void ABMatrix(int row,int col,int[][]A,int[][]B,int[][]AB,PrintWriter output){
        int R = 0,C=0;
        boolean star=false;
        for(int r=0;r<B.length;r++){
            if(A[row][r]==9999) {
                R=r;C=col;
            }
            else if(B[r][col]==9999) {
                R=row;C=r;
                star=true;
            }
            else AB[row][col]-=(A[row][r]*B[r][col]);
        }
        if(star==true) AB[row][col]/=A[R][C];
        else AB[row][col]/=B[R][C];

        output.println(AB[row][col]);

    }
}
