import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Vector;
import java.util.*;
public class ReadFileTest{

	int num = -1;//节点数
	Vector vec = new Vector();//边集
	HashMap[] map_front = new HashMap[20000];//经统计，最大的节点编号约为19868，设置20000防止越界
	HashMap[] map_back = new HashMap[20000]; //正向网络与负向网络分别存储
	
   public void load(String path){
    	  	
    	LineNumberReader reader = null;   
    	FileReader in = null; 
    	String key = null;
    	int value = 0;
    	
    	String [] pairs = new String[4];
    	for (int i = 0 ; i<20000 ; i++) {
    		map_front[i] = new HashMap();
    		map_back[i] = new HashMap();
    	}
    	try {   
    	      in = new FileReader(path);   
    	      reader = new LineNumberReader(in); 
    	      
    	      while (true) {
    	        	 String str = reader.readLine();   
    	             if (str == null)   
    	                  break;   
    	              //System.out.println(str);
    	              pairs= str.split(" ");
    	              String strLine = pairs[0] + " "+pairs[1]+" "+pairs[2]+" "+pairs[3];
    	              /*
    	               * 将网络构建起来
    	               * 正向网络和负向网络分别构建在map_front与map_back中
    	               * 
    	               */
    	              /**********************************/
    	              
    	              int t0 = Integer.valueOf(pairs[0]);
    	              int t1 = Integer.valueOf(pairs[1]);
    	              int t2 = Integer.valueOf(pairs[2]);
    	              double t3 = Double.valueOf(pairs[3]);
    	              num = Math.max(Math.max(t0,t1), num);
    	              if(t2 == 1) {
    	     
    	            	  map_front[t0].put(t1,t3);
    	              }else {
    	            	  
    	            	  map_back[t0].put(t1,t3);
    	              }
    	              /**********************************/
    	              vec.add(strLine);
    	      }   
    	      
    	      } catch (FileNotFoundException e) {   
    	          e.printStackTrace();   
    	      } catch (IOException e) {   
    	          e.printStackTrace();   
    	      } finally {   
    	          try {   
    	              if (reader != null)   
    	                  reader.close();   
    	          } catch (IOException e) {   
    	              e.printStackTrace();   
    	          }   
    	          try {   
    	              if (in != null)   
    	                  in.close();   
    	          } catch (IOException e) {   
    	              e.printStackTrace();   
    	          }   
    	      } 
    	 	  
    }
   
   
   public static void main(String args[]){
	   
	   
	   ReadFileTest test = new ReadFileTest();
	   test.load(".\\links.txt");
	   int count = 0;
	   
	   for(int i=0;i<test.vec.size();i++){
		   
		   //System.out.println(test.vec.get(i).toString());
		   count++;
	   }
	   System.out.println("link number:"+count);
	   
   }
   
   

}