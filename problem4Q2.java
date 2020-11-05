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
            if(Shun(TestData)==true) {//if ans==true 判斷tonghuashun

              if( TongHuaShun(TestData)==true){
                  System.out.println("同花順");
              }else {
                  System.out.println("順子");
              }
            }
            char Ans=Apair(TestData);
            if(Ans!=0) {
                if (Ans == 'A') {
                    System.out.println("四條");
                } else if (Ans == 'B') {
                    System.out.println("三條");
                } else {
                    System.out.println("一對");
                }
            }
            testGroup--;
        }


    }

    public static boolean Shun(int [] data)
    {
        int [] cardNum=new int [data.length];

        for(int i=0;i<data.length;i++){

             cardNum[i]=data[i]%13;



        }
        Arrays.sort(cardNum);
        int d1 = 1;

        boolean ans=true;
        for(int i=0;i<cardNum.length;i++){


            for (int j=i+1;j<cardNum.length;j++){
                d1=Math.abs(cardNum[i]-cardNum[j]);
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
            if(cardFlower[i]!=cardFlower[j]){
                Ans=false;

            }

        }
        return Ans;
    }
    public static char Apair(int [] data){
        int [] cardNum=new int [data.length];
        int [] Num=new int[14];
        int num;
        char Ans = 0;
        for(int i=0;i<data.length;i++){

            cardNum[i]=data[i]%13;
        }
        for(int j=0;j<cardNum.length;j++){
            num=cardNum[j];
            Num[num]+=1;
        }
        for(int k=0;k<Num.length;k++){
            if(Num[k]>=4){
                Ans='A';
            }else if(Num[k]==3){
                Ans='B';
            }else if(Num[k]==2){
                Ans='C';
            }
        }
        return Ans;
    }
}
