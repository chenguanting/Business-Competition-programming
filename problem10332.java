import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class problem10332 {
    public static void main(String[] args) throws FileNotFoundException {
      int groupNum,data,ans;
        ArrayList array=new ArrayList();
        for(int i=1;i<3;i++) {
          String filename = String.format("in%d.txt", i);
          File file=new File(filename);
          Scanner input=new Scanner(file);
          groupNum=Integer.parseInt(input.nextLine());
          while (groupNum>0){
              data=Integer.parseInt(input.nextLine());
              if(data==1){
                  System.out.println(1);
              }else {
                    Fib(data,array);
                  System.out.println(array);
              }

              array.clear();
          }
      }
      }
    public static  int  Fib(int testData,ArrayList array){
        if(testData==0){
            return 0;
        }else if(testData==1||testData==2){
            return 1;
        }else {

            return Fib(testData-1,array)+Fib(testData-2,array);
        }

    }
}
