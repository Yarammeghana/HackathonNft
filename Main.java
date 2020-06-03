package hackathon1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class Main{

    public static void main(String []args){
        try {
            String content = new String(Files.readAllBytes(Paths.get("cpu.txt")));
            String[] elements = content.split("\n");
            int max=-9999;
            int avg=0;
            HashMap<Integer,String> map=new HashMap<Integer,String>();
            for(int j=0;j<elements.length;j++) {
                String t = elements[j].replaceAll("\\s+", " ");
                String[] s = t.split(" ");
                map.put(j,s[8]);
                System.out.println(t);
                int x = Integer.valueOf(s[8]);
                if(x>max){
                    max = x;
                }
                avg += x;
            }
            avg /= elements.length;
            System.out.println(max+" "+avg);
        }
        catch(Exception e) {

        }
    }
}
