import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class problem10422 {


    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output=new PrintWriter("out.txt");
        for(int i=1;i<3;i++) {
            String filename = String.format("in%d.txt", i);
            File file=new File(filename);
            Scanner input=new Scanner(file);
            Enter(input,output);
            output.println();
        }
        output.close();
    }
    public static void Enter(Scanner input,PrintWriter output){
        int dataGroup,Answer;
        String dataLine[];
        dataGroup=Integer.parseInt(input.nextLine());
        while (dataGroup>0){
            dataLine=input.nextLine().split(",");
            Answer=Logic(dataLine);
            output.println(Answer);
            dataGroup--;
        }
    }
    public static int Logic(String[] dataLine){
        ArrayList list=new ArrayList<>();
        for(int k=0;k<dataLine.length;k++){
            list.add(Integer.parseInt(dataLine[k]));
        }
        int count=0,answer = 0;
        int min= (int) Collections.min(list);
        for(int i=min;i>=1;i--){
            for(int j=0;j<list.size();j++){
                int temp= (int) list.get(j);
                if(temp%i==0){
                    count++;
                }
                if(count==list.size())break;
            }
            if(count==list.size()){
                answer=i;
                break;
            }
            count=0;
        }

    return answer;

        }

}
