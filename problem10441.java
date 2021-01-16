import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class problem10441 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output=new PrintWriter("out.txt");
        for(int i=1;i<2;i++) {
            String filename = String.format("in%d.txt", i);
            File file=new File(filename);
            Scanner input=new Scanner(file);
            int groupNum=Integer.parseInt(input.nextLine());
            while (groupNum>0){
                int size=Integer.parseInt(input.nextLine());
                String [] array=input.nextLine().split(",");
                int [] arrayList=new int [size];
                for(int j=0;j<array.length;j++){
                    arrayList[j]=Integer.parseInt(array[j]);
                }//轉換int
                Btree bt=new Btree(arrayList);
                //bt.Print();
                bt.printPostOrder();
                groupNum--;
            }
        }
    }
}
class TreeNode{  //樹節點類別
    int data;
    TreeNode left;  //參考左子樹
    TreeNode right;  //參考右子樹
    public TreeNode(int data){ //建構子TreeNode 讀入data 建立左右節點 初始為null
        this.data=data;
        this.left=this.right=null;
    }

}
class Btree{
    public TreeNode head;
    public Btree(int [] array){
        for(int i=0;i<array.length;i++)
            insertNode(array[i]);
    }
    boolean isBtreeEmpty(){
        if(head==null) return true;
        else           return false;
    }
    public void insertNode(int data){
        if(isBtreeEmpty()){
            head=new TreeNode(data);
            return;
        }
        TreeNode current=head;
        while (true){
            if(data<current.data){
                if(current.left==null){
                    current.left=new TreeNode(data);
                    return;
                }
                else current=current.left;
            }
            else {
                if(current.right==null){
                    current.right=new TreeNode(data);
                    return;
                }
                else current=current.right;
            }
        }
    }
    public void Print(){
        TreeNode ptr;
        System.out.println("root"+head.data);
        ptr= head.left;
        System.out.println("左子樹:");
        while (ptr!=null){
            System.out.println(ptr.data);
            ptr=ptr.left;
        }
        System.out.println("右子樹:");
        ptr=head.right;
        while (ptr!=null){
            System.out.println(ptr.data);
            ptr=ptr.right;
        }
    }
    public void postOrder(TreeNode ptr){
        if(ptr!=null){
            postOrder(ptr.left);
            postOrder(ptr.right);
            System.out.print(ptr.data+" ");
        }
    }
    public void printPostOrder(){
        postOrder(head);
        System.out.println();
    }
}
