import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class p3Q2{
    public static ArrayList nodeList=new ArrayList();
    public static int Tree[][]=new int [60][60];
    public static ArrayList internalList=new ArrayList();
    public static void main(String[] args) throws IOException {

        File file=new File("C:\\Users\\Lenovo\\Downloads\\術科檢測資料_1\\Problem3\\子題2\\in1.txt");
        BufferedReader data=new BufferedReader(new FileReader(file));

        int groupData=Integer.parseInt(data.readLine());
        int edgeNum=0;
        int nodeNum=0;
        while (groupData>0)
        {
            int testData=Integer.parseInt(data.readLine());
            while (testData>0){
                String br=data.readLine();
                Scanner reader=new Scanner(br);
                reader.useDelimiter("(\\s|-|\\n)+");
                while(reader.hasNext()){
                    edgeNum+=1;
                    int node1=reader.nextInt();
                    int node2=reader.nextInt();
                    addNode(node1);
                    addNode(node2);
                    addEdge(node1,node2);
                }
                nodeNum=edgeNum+1;
                System.out.println(internalList);

                testData--;
                init();
            }
             data.readLine();
            groupData--;
        }
    }

    public static void addNode(int node){
        if(nodeList.contains(node)==true&&internalList.contains(node)==false)
        {
            internalList.add(node);
        }
        else nodeList.add(node);
    }
    public static boolean addEdge(int node1,int node2){
        boolean ans=true;
        if(Tree[node1][node2]==1||Tree[node2][node1]==1){
            ans=false;
            return ans;
        }
        else {
            Tree[node1][node2]=1;
            Tree[node1][node2]=1;
            return ans;
        }
    }
    public static void init(){
        nodeList.clear();
        internalList.clear();
    }
}