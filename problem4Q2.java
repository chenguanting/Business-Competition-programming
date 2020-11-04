import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.jar.JarOutputStream;
//Array.sort
public class problem4Q2 {
    public static void main(String[] args) throws IOException {

        File file=new File("in1.txt");
        Scanner input=new Scanner(file);
        int testGroup=Integer.parseInt(input.nextLine());
        while (testGroup>0) {
            String [] testData=input.nextLine().split("(\\s|\\n)+");
            int [] TestData=new int [testData.length];
            for(int k=0;k<testData.length;k++){
                TestData[k]=Integer.parseInt(testData[k]);
            }



            int num = 1;
            int cards[][] = new int[5][14];


            for (int i = 1; i <= cards.length - 1; i++) {
                for (int j = 1; j <= cards[i].length - 1; j++) {
                    cards[i][j] = num;
                    num++;
                }
            }
            Shun(TestData);//if ans==true 判斷tonghuashun
            testGroup--;
        }


    }

    public static boolean Shun(int [] data)
    {

        for(int i=0;i<data.length;i++){

            int cardNum=data[i]%13;

            data[i]=cardNum;

        }
        Arrays.sort(data);
        int d1 = 1;

        boolean ans=true;
        for(int i=0;i<data.length;i++){


            for (int j=i+1;j<data.length;j++){
                d1=Math.abs(data[i]-data[j]);
                if(d1==1){break;}
                else {ans=false;}


            }


        }
        return ans;


    }
    public static boolean TongHuaShun(int [] data){
        boolean Ans=true;
        int [] cardFlower=new int [data.length];

        for(int i=0;i<data.length;i++){

            cardFlower[i]=data[i]/13;

        }
        for(int i=0;i<data.length;i++){
            for(int j=i+1;j<data.length;j++)
            if(cardFlower[i]!=cardFlower[j]){Ans=false;}

        }

    }
}
