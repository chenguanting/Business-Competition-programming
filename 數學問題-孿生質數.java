import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
//孿生質數 也稱為孿生素數、雙生質數，是指一對質數，它們之間相差2。例如3和5，5和7，11和13，10016957和10016959等等都是孿生質數。
public class problem1031 {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output=new PrintWriter("out.txt");
        for (int i = 1; i < 3; i++) {
            String filename=String.format("in%d.txt",i);
            File file = new File(filename);
            Scanner input = new Scanner(file);
            boolean Ans;
            int d1;
            int groupNumber = Integer.parseInt(input.nextLine());
            while (groupNumber > 0) {
                String[] line = input.nextLine().split(",");
                int num1 = Integer.parseInt(line[0]);
                int num2 = Integer.parseInt(line[1]);
                d1 = Math.abs(num1 - num2);
                Ans = Prime(num1, num2);
                if (Ans == true && d1 == 2) {
                    output.println("Y");
                } else output.println("N");
                groupNumber--;
            }
            output.println();
        }

        output.close();
    }

    public static boolean Prime(int num1, int num2) {
        boolean ans = true;
        for (int i = 2; i < num1; i++) {
            if (num1 % i == 0) {
                ans = false;
            }

        }
        for (int i = 2; i < num2; i++) {
            if (num2 % i == 0) {
                ans = false;
            }
        }
        return ans;

    }
}
