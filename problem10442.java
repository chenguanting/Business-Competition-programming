import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class problem10442 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output = new PrintWriter("output.txt");
        for (int i = 1; i < 2; i++) {
            String filename = String.format("in%d.txt", i);
            File file = new File(filename);
            Scanner input = new Scanner(file);
            Enter(output, input);
        }
        output.close();
    }

    public static void Enter(PrintWriter output, Scanner input) {


        int DataNum = Integer.parseInt(input.nextLine());
        while (DataNum > 1) {
            TreeSet map=new TreeSet();
            String [] Line = input.nextLine().split(",| ");
            int rows=Line.length/3;
            int [][] edge=new int [rows][3];
            ArrayList<Integer> temparray=new ArrayList<>();
            //轉換輸入值 英文轉數字
            for(int i=0;i<Line.length;i++){
                if((i+1)%3==0)
                {
                    temparray.add(Integer.parseInt(Line[i]));
                    continue;
                }
                char [] ch=Line[i].toCharArray();
                for (char c:ch) {
                    int temp=(int) c;
                    int temp_inter=65;
                    if(temp>=65){
                        temparray.add(temp-temp_inter+1);
                        map.add(temp);//map求節點總數
                    }

                }
            }
            //轉二維陣列
            int a=0;
            for(int i=0;i<edge.length;i++)
            {
                for(int j=0;j<edge[i].length;j++){

                    edge[i][j]=temparray.get(a);
                    a++;
                }
            }
            Arrays.sort(edge[2]);
            for(int i=0;i<edge.length;i++)
            {
                for(int j=0;j<edge[i].length;j++){

                    System.out.print(edge[i][j]+",");
                }
                System.out.println();
            }
            EdgeList e1=new EdgeList(map.size()+1,edge);
            //e1.minSpanTree();

            DataNum--;
        }
    }


}
class Edge{
    int from;
    int to;
    int weight;
    Edge next;
    public Edge(int from,int to,int weight){
        this.from=from;
        this.to=to;
        this.weight=weight;
        next=null;
    }
}
class EdgeList{
    public int[]vertex;
    public Edge first;
    public EdgeList(int size,int[][] edge){
        Edge newnode;
        Edge last=null;
        vertex=new int[size];//建立頂點陣列
        for(int i=0;i<size;i++) vertex[i]=-1;
        for(int i=0;i<edge.length;i++){
            newnode=new Edge(edge[i][0],edge[i][1],edge[i][2]);//建立edge物件
            if(first==null){
                first=newnode;
                last=first;
            }else {
                last.next=newnode;
                last=newnode;
            }
        }
    }
    public void addSet(int from,int to){
        int to_root=to;
        while (vertex[to_root]>0)
            to_root=vertex[to_root];
        vertex[to_root]=from;
    }
    public boolean isSameSet(int from,int to){
        int from_root=from;
        int to_root=to;
        while (vertex[from_root]>0)
            from_root=vertex[from_root];
        while (vertex[to_root]>0)
            to_root=vertex[to_root];
        if(from_root==to_root)
            return true;
        else return false;
    }
    public void minSpanTree(){
        Edge ptr=first;
        int i,total=0;
        while (ptr!=null){
            if(!isSameSet(ptr.from,ptr.to)){
                total+=ptr.weight;
                addSet(ptr.from,ptr.to);
            }
            ptr=ptr.next;
        }
        System.out.println("最低成本擴張術:"+total);
    }

}



