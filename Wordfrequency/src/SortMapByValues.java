import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class SortMapByValues {
	
	static Scanner in =new Scanner(System.in);

	//按值排序,并输出用户要求的词频最多的前K个单词
    public static void sortMapByValues(Map<String, Integer> Map) {  
    	  
        Set<Entry<String,Integer>> mapEntries = Map.entrySet();   
        LinkedList<Entry<String, Integer>> List = new LinkedList<Entry<String,Integer>>(mapEntries);  
  
     // 根据映射的值对列表排序
        Collections.sort(List, new Comparator<Entry<String,Integer>>() {  
            @Override  
            public int compare(Entry<String, Integer> ele1,  Entry<String, Integer> ele2) {  
  
                return ele2.getValue().compareTo(ele1.getValue());  
            }  
        });  
  
        // Storing the list into Linked HashMap to preserve the order of insertion.   
        Map<String,Integer> Map2 = new LinkedHashMap<String, Integer>();  
        for(Entry<String,Integer> entry: List) {  
            Map2.put(entry.getKey(), entry.getValue());  
        }  
  
        // 输入需要查看的词频最高的前K个单词
        System.out.println("请输入需要查看的词频最高的单词个数：");
        int n = in.nextInt();
        for(Entry<String,Integer> entry : Map2.entrySet()) {  
            System.out.println(entry.getKey() + " - " + entry.getValue());  
            n--;
            if(n<=0)	break;
        } 
       
    } 
    
}
