import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class problem3Q2 {
    Node head=null;
    class Node{
        Node next=null;//節點引用 指向下一個節點
        int data;//節點的物件，即內容
        public  Node(int data){
            this.data=data;
        }
    }
    public void addNode(int d){
        Node newNode =new Node(d);
        if(head==null){
            head=newNode;
            return;
        }
        Node tmp=head;
        while (tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=newNode;

    }
    public void printList(){
        Node tmp=head;
        while (tmp!=null){
            System.out.println(tmp.data);
            tmp=tmp.next;
        }
    }
    public static void showLinkData(String[] linkData) {
        for (int i = 0; i < linkData.length; i++) {

            System.out.print(linkData[i]);
        }


    }

    public static void main(String[] args) throws FileNotFoundException {
        for (int i = 1; i < 3; i++) {
            String filename = String.format("in%d.txt", i);
            File file = new File(filename);
            Scanner input = new Scanner(file);
            int line1 = Integer.parseInt(input.nextLine());
            while (line1 > 0) {

                int line2 = Integer.parseInt(input.nextLine());
                while (line2 > 0) {
                    String[] linkData = input.nextLine().split("-| ");
                    problem3Q2.showLinkData(linkData);
                    System.out.println();
                    line2--;
                }
                line1--;
                if (line1 != 0) {
                    String space = input.nextLine();
                }


            }
        }
    }
}
