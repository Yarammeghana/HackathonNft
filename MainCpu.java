package hackathon1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
 
	
	public static void main(String[] args) throws IOException {
		File f=new File("CPU.txt");
		InputStream fis=new FileInputStream(f);
        InputStreamReader ir=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(ir);
        int i=0;
        String bline="";
        double max=0;
        JSONObject cpuvalue=new JSONObject();
		JSONObject value=new JSONObject();
		JSONObject values=new JSONObject();
		JSONArray list=new JSONArray();
		double total=0,avg=0;
        while((bline=br.readLine())!=null)
        {
        	 StringTokenizer st=new StringTokenizer(bline," "); 
        	 while(st.hasMoreTokens())
        	 {
        		 String tok=st.nextToken();
        		 if(tok.equals("S")||tok.equals("R")||tok.equals("D"))
        		 {
        			 i++;
        			 double cvalue=Double.parseDouble(st.nextToken());
        			 if(max<cvalue)
						{
							max=cvalue;
						}
        			 String cn=i+"s";
        			 total+=cvalue;
				     cpuvalue.put(cn,cvalue);
        		 }
        	 }
         
        
        }
        avg=total/i;
		avg=Math.round(avg*100.0)/100.0;
		values.put("values", cpuvalue);
		values.put("maxcpu", max);
		values.put("Avgcpu", avg);
		value.put("sampletransaction", values);
		list.add(value);
		
		try(FileWriter fw=new FileWriter("results.json"))
		{
			fw.write(list.toJSONString());
			fw.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		JSONParser parser=new JSONParser();
		try(FileReader reader =new FileReader("results.json"))
		{
			Object obj=parser.parse(reader);
			JSONArray li=(JSONArray)obj;
			System.out.println(li.toString());
		}
        }
	}


