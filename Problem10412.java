import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Problem10412 {
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
        int testGroup,totalCount;

        boolean swift=false;
        String lottery [] = new String[0];

         testGroup=Integer.parseInt(input.nextLine());
         while (testGroup>0){
             ArrayList luckyTicket =new ArrayList();

             String ticket [];
             ArrayList countList=new ArrayList();
             if(swift==false) {
                 lottery = input.nextLine().split(",");
                 swift=true;
             }
             ticket=input.nextLine().split(",");
             Queue<String > queue=new LinkedList<String >();
             for(int i=0;i<ticket.length;i++){
                 queue.offer(ticket[i]);
             }
             for(int i=0;i<queue.size();i++){
                 for(int j=0;j<queue.size()-1;j++){
                     String num = queue.poll();
                     luckyTicket.add(num);
                     queue.offer(num);
                 }
                totalCount=Logic(lottery,luckyTicket);
                 luckyTicket.clear();
                countList.add(totalCount);
             }

             output.print(Collections.frequency(countList,2)+",");
             output.print(Collections.frequency(countList,3)+",");
             output.print(Collections.frequency(countList,4)+",");
             output.println(Collections.frequency(countList,5));
             countList.clear();

             testGroup--;
         }
    }
    public static int Logic(String [] lottery,ArrayList luckyTicket){
        int count = 0;
        for(int i=0;i<lottery.length;i++){
            for(int j=0;j<luckyTicket.size();j++){
                if(lottery[i].equals(luckyTicket.get(j))){
                    count++;
                }
            }
        }
        return count;
    }
}
