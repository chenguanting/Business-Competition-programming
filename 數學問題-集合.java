import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.*;


class read {

    HashSet<String> union(String[] set1, String[] set2) {
        HashSet<String> hset = new HashSet<>();
        for (int i = 0; i < set1.length; i++) {
            hset.add(set1[i]);
        }
        for (int i = 0; i < set2.length; i++) {
            hset.add(set2[i]);

        }


        return hset;
    }

    HashSet<String> intersection(String[] set1, String[] set2) {//應改為hashset較優
        HashSet<String> hset = new HashSet<>();

        hset.addAll(Arrays.asList(set1));
        hset.retainAll(Arrays.asList(set2));

        if(hset.size()==1){
           hset.add("N");
        }
        return hset;
        /*String a = null;
        boolean eq = false;
        for (int i = 1; i < set1.length; i++) {
            for (int j = 1; j < set2.length; j++) {
                if (set1[i].equals(set2[j])) {
                    eq = true;
                    a = set1[i];

                }
            }
        }
        if (eq == false) {
            return "N";
        } else return a;
*/
    }


    HashSet<String> setDifference(String[] set1, String[] set2) {
        HashSet<String> hset = new HashSet<>();

        for (int i = 0; i < set1.length; i++) {
            hset.add(set1[i]);
        }
        for (int i = 0; i < set2.length; i++) {
            hset.add(set2[i]);

        }
        for (int i = 0; i < set2.length; i++) {
            hset.removeAll(Collections.singleton(set2[i]));

        }
        if(hset.isEmpty()){
            hset.add("N");
        }
        return hset;

    }


    HashSet<String> symmetricDifference(String[] set1, String[] set2) {
        HashSet<String> hset = new HashSet<>();
        HashSet<String> a = new HashSet<>();
        HashSet<String> b = new HashSet<>();
       /*for (int i = 0; i < set1.length; i++) {
            hset.add(set1[i]);
        }
        for (int i = 0; i < set2.length; i++) {
            hset.add(set2[i]);}
        */


        hset.addAll(Arrays.asList(set1));
        hset.removeAll(Arrays.asList(set2));


        for (String h : hset) {
            a.add(h);
        }
        hset.clear();

        hset.addAll(Arrays.asList(set2));
        hset.removeAll(Arrays.asList(set1));
        for (String h : hset) {
            b.add(h);
        }

        hset.clear();
        hset.addAll(a);
        hset.addAll(b);
        if(hset.isEmpty()){
            hset.add("N");
        }
        return hset;


    }
}

public class problem2 {


    public static void A(String filename, PrintWriter output) throws FileNotFoundException {
        File file = new File(filename);
        Scanner input = new Scanner(file);
        int n = Integer.parseInt(input.nextLine());

        while (n > 0) {
            read rd = new read();
            String tstr = input.nextLine();
            String tokens[] = tstr.split("},");
            String set1[] = tokens[0].split("(\\s|\\{|,|\\})+");
            String set2[] = tokens[1].split("(\\s|\\{|,|\\})+");

            output.print(rd.union(set1, set2)+",");
            output.print(rd.intersection(set1, set2)+",");
            output.print(rd.setDifference(set1, set2)+",");
            output.print(rd.symmetricDifference(set1, set2));
            output.println();


            n--;

        }
    }

    public static void main(String[] args) throws FileNotFoundException, java.io.IOException {
        java.io.PrintWriter output = new java.io.PrintWriter("out.txt");
        for(int i=1;i<3;i++) {
            String filename=String.format("in%s.txt",i);
            problem2.A(filename, output);
            output.println();

        }
        output.close();
    }
}
