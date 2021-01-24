import java.io.*;
import java.util.Scanner;


public class Problem1041 {
    public static void main(String[] args) throws IOException {
        PrintWriter output = new PrintWriter("out.txt");
        for (int i = 1; i < 3; i++) {
            String filename = String.format("in%d.txt", i);
            File file = new File(filename);
            Scanner input = new Scanner(file);
            Enter(input,output);
            output.println();
        }
        output.close();

    }

    public static void Enter(Scanner input, PrintWriter output) {
        int testNumber, StopNumber, Answer;
        String Stop[];


        testNumber = Integer.parseInt(input.nextLine());
        while (testNumber > 0) {
            StopNumber = Integer.parseInt(input.nextLine());
            Stop = input.nextLine().split(",");
            Answer = Logic(StopNumber, Stop);
            output.println(Answer);
            testNumber--;
        }
    }

    public static int Logic(int StopNum, String Stop[]) {
        int var1, var2, cost = 0;

        for (int i = 0; i < StopNum; i++) {
            var1 = Integer.parseInt(Stop[i]);
            for (int j = i + 1; j <= StopNum - 1;) {
                var2 = Integer.parseInt(Stop[j]);
                if (var1 < var2) cost += Math.abs(var1 - var2) * 20;
                else cost += Math.abs(var1 - var2) * 10;
                break;
            }
        }

        return cost;
    }
}
