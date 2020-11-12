import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
//Arraylist排序可使用Collections的sort功能
public class problem1032 {
    public static void main(String[] args) throws IOException {
        PrintWriter output=new PrintWriter("out.txt");
        for(int i=1;i<3;i++) {
            String filename = String.format("in%d.txt",i);
            File file=new File(filename);
            BufferedReader br=new BufferedReader(new FileReader(file));
            int groupNum=Integer.parseInt(br.readLine());
            while (groupNum>0){
                String line1=br.readLine();
                String line2=br.readLine();
                Repeat(line1,line2,output);
                output.println();
                groupNum--;
            }
            output.println();
        }

        output.close();
    }
    //判斷重複字元及排序
    public static void Repeat(String line1,String line2,PrintWriter output) throws FileNotFoundException {

        ArrayList repeat=new ArrayList();
        char [] line1split=line1.toCharArray();
        char [] line2split=line2.toCharArray();
        for(int i=0;i<line1split.length;i++){
            for(int j=0;j<line2split.length;j++){
                if(line1split[i]==line2split[j]&&repeat.contains(line2split[j])==false){
                    repeat.add(line2split[j]);

                }
            }
        }
        Collections.sort(repeat);
        for (Object e:repeat) {
            output.print(e);
        }

        if (repeat.isEmpty()==true){
            output.print("N");
        }
        repeat.clear();


    }
}
