import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.jar.JarOutputStream;
//arraylist取值 使用.get()方法
public class problem10332 {
    public static void main(String[] args) throws FileNotFoundException {
        int groupNum, data, k,sk, arrayNum;
        boolean ans=false;
        ArrayList array = new ArrayList();
        PrintWriter output=new PrintWriter("out.txt");
        for (int a = 1; a < 3; a++) {
            String filename = String.format("in%d.txt", a);
            File file = new File(filename);
            Scanner input = new Scanner(file);
            groupNum = Integer.parseInt(input.nextLine());
            while (groupNum > 0) {
                data = Integer.parseInt(input.nextLine());
                int[] index = new int[data + 2]; //從2開始的陣列 大小+2 值先都設為0
                for (int i = 0; i < index.length; i++) {
                    index[i] = 0;
                }
                /*輸入值為1 直接進入Fib()轉換
                  若值>2,找尋大於輸入值的Fib()值 再減1 表示 最接近輸入值的Fib()值 但是又
                  不超過輸入值。 如果說兩值相減等於0 表示兩者值相同。 若不相同 則計算差額 是否為某Fib()值
                  *****注意:數字過大仍可能會出現錯誤，目前該程式最多只能分解成三個值 把核心區塊用副程式操作較佳*******/
                if (data < 2) {
                    output.print(Fib(data));
                } else {
                    for (int j = 2; j <=index.length; j++) {
                        if (Fib(j)>data) {
                            array.add(j-1);
                            index[j-1] = 1;
                            k = Math.abs(data - Fib(j-1));
                            if (k == 0) {
                                break;
                            } else {
                                for (int s = 2; s <= j; s++) {
                                    if (Fib(s) == k) {
                                        index[s] = 1;
                                        ans=true;
                                        break;
                                    }
                                }
                                if (ans==false){
                                    for (int h = 2; h<=index.length; h++) {
                                        if (Fib(h)>k) {
                                           // array.add(h-1);
                                            index[h-1] = 1;
                                            sk = Math.abs(k - Fib(h-1));
                                            if (sk == 0) {
                                                break;
                                            } else {
                                                for (int s = 2; s <= h; s++) {
                                                    if (Fib(s) == sk) {
                                                        index[s] = 1;
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                        }

                                    }
                                }
                                break;
                            }
                        }

                    }

                }
                //打印陣列 從後往前打印
                if(array.isEmpty()==false){
                    arrayNum = (int) array.get(0);
                    for (int g=arrayNum; g>=2; g--) {
                        output.print(index[g]);
                    }
                    array.clear();
                }


                output.println();
                groupNum--;
            }
            output.println();
        }
        output.close();
    }

//費式數列的遞迴
    public static int Fib(int testData) {
        if (testData == 0) {
            return 0;
        } else if (testData == 1) {
            return 1;
        } else {

            return Fib(testData - 1) + Fib(testData - 2);
        }

    }

}