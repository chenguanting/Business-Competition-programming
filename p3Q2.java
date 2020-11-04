import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class p3Q2{
    //定義陣列 儲存所有節點 內部節點 拜訪節點 使用ArratList
    public static ArrayList nodeList=new ArrayList();
    public static int Tree[][]=new int [60][60];
    public static ArrayList internalList=new ArrayList();
    public static ArrayList totalinternalList=new ArrayList();
    public static  ArrayList visitNodeList=new ArrayList();



    public static void main(String[] args) throws IOException {
        PrintWriter output=new PrintWriter("out.txt");
        boolean answer = true;
        for (int n = 1; n < 3; n++) {
            String filename = String.format("in%d.txt", n);
            File file = new File(filename);

            //使用BufferReader讀取值
            BufferedReader data = new BufferedReader(new FileReader(file));
            //讀取資料組數
            int groupData = Integer.parseInt(data.readLine());
            while (groupData > 0) {
            //讀取每組資料組內的測試資料組數
                int testData = Integer.parseInt(data.readLine());
                while (testData > 0) {
                    int edgeNum = 0;
                    int nodeNum = 0;
                    String br = data.readLine();//data
                    Scanner reader = new Scanner(br);//掃描data 切割
                    reader.useDelimiter("(\\s|-|\\n)+");
                    while (reader.hasNext()) {
                        edgeNum += 1;
                        int node1 = reader.nextInt();
                        int node2 = reader.nextInt();
                        addNode(node1);
                        addNode(node2);
                        //flag1用來判斷是否有重複的邊線
                        boolean flag1 = addEdge(node1, node2);
                        if (flag1 == false) {
                            answer = false;
                        }

                    }
                    nodeNum = edgeNum + 1;//節點是邊線+1
                    //flag2判斷是不是樹
                    boolean flag2 = checkTree(nodeNum);
                    if (flag2 == false) {
                        answer = false;

                    }


                    testData--;
                    init();
                }
                //判斷是否有重複的內部節點
                int internal = internalList.size() - 1;

                for (int k = 0; k < internal; k++) {
                    Object t = internalList.get(k);
                    if (totalinternalList.contains(t) == true) {
                        answer = false;
                    } else {
                        totalinternalList.add(t);
                    }
                }
                //清空tree[][]
                for (int i = 0; i < 60; i++) {
                    for (int j = 0; j < 60; j++) {
                        Tree[i][j] = 0;

                    }

                }
                internalList.clear();
                totalinternalList.clear();
                if (answer == true) {
                    output.println("T");
                } else output.println("F");
                data.readLine();
                groupData--;

            }
        }
        output.close();
    }

    public static void addNode(int node){
        if(nodeList.contains(node)==true&&internalList.contains(node)==false)
        {
            internalList.add(node);

        }
        else {

            nodeList.add(node);
        }
    }
    public static boolean addEdge(int node1,int node2){
        boolean ans=true;
        if((Tree[node1][node2]==1)||(Tree[node2][node1]==1)){
            ans=false;

        }
        else {
            Tree[node1][node2]=1;
            Tree[node2][node1]=1;

        }
        return ans;
    }
    public static boolean checkTree(int nodeNum){
        boolean ans=true;
        int vistNodeNum=0;
        Stack stack=new Stack();

        stack.push(1);
        while (stack.isEmpty()==false){

            int temp=(int)(stack.pop());
            if(visitNodeList.contains(temp)==false) {
                visitNodeList.add(temp);
                vistNodeNum += 1;
                for (int i = 1; i <= nodeNum; i++) {
                    if ((Tree[temp][i] == 1) && (visitNodeList.contains(i) == false)) {
                        stack.push(i);
                    }
                }
            }
        }
        if(vistNodeNum<nodeNum){
             ans=false;

        }
        return ans;
    }
    public static void init(){
        nodeList.clear();

        visitNodeList.clear();


    }
}
