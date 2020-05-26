package File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONObject;

public class Memory1 {
	
    public static Float findMax(List<Float> list) 
    { 
  
        if (list == null || list.size() == 0) { 
            return Float.MIN_VALUE; 
        } 
  
        List<Float> sortedlist = new ArrayList<>(list); 
  
        Collections.sort(sortedlist); 
  
        return sortedlist.get(sortedlist.size() - 1); 
    } 
	
    public static void main(String[] args) throws FileNotFoundException, IOException {
        @SuppressWarnings("resource")
		BufferedReader Buff = new BufferedReader(new FileReader("memory1.txt"));
        String text = Buff.readLine();
        List<Float> list = new ArrayList<Float>();
        int i = 0,k = 0;
        JSONObject obj1 = new JSONObject();
        while(text != null) {
        	if(i%2 != 0) {	
        		obj1.put(k+"s",Float.parseFloat(text.replaceAll(" ","").substring(6, 12))/1000);
        		list.add(Float.parseFloat(text.replaceAll(" ","").substring(6, 12))/1000);
        		//System.out.println(Float.parseFloat(text.replaceAll(" ","").substring(6, 12))/1000);
        	}
        	i++;
        	text = Buff.readLine();
        }
        Float sum = (float) 0.00;
        for (Float i1: list) {
            sum += i1;
        }
        sum = sum/list.size();
        
        JSONObject obj = new JSONObject();
        
        obj.put("AverageMemory(MB)",sum);
        obj.put("values",obj1);
        
        obj.put("MaxMemory(MB)",findMax(list));
        obj.put("Usecasename","HomePage");
        
        try(FileWriter file = new FileWriter("myJason.json")){
        	file.write(obj.toString());
        	file.flush();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
        
        System.out.println(obj);
    }
}


