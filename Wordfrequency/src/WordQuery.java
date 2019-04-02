import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


//显示用户需要查询的若干个单词的词频
public class WordQuery {

	static Scanner in =new Scanner(System.in);
	public static void wordQuery(Map<String, Integer> Map)
	{
		//显示用户需要查询的若干个单词的词频
        System.out.println("请输入需要查询的单词,单词之间用空格隔开");
        String s = in.nextLine();
        String[] word= s.split(" ");
        int length = word.length;
        int[] num = new int[length];
        int i, sum=0;
        for(i=0; i<word.length; i++) {
        	for(Entry<String,Integer> entry : Map.entrySet()) { 
        		if(word[i].equals(entry.getKey()))
        		{
        			sum += entry.getValue();
        			num[i] = entry.getValue();
        			System.out.println(entry.getKey() + ":\t " + entry.getValue()+ num[i]); 
        			break;
        		}
                
            } 
        }
        System.out.println("各单词相关的柱状图如下（一个*代表出现十次）：");
        int j;
        for(i=0; i<word.length; i++) {
        	for(Entry<String,Integer> entry : Map.entrySet()) { 
        		if(word[i].equals(entry.getKey()))
        		{
        			double t = (double)(entry.getValue())/sum*100;
        			BigDecimal a =new BigDecimal(t).setScale(2, BigDecimal.ROUND_HALF_UP);		//对浮点数进行四舍五入处理
        			Integer result = a.intValue();
        			String re = "";
        			for(j=0; j<result; j++) {
        				re += "*";
        			}
        			System.out.println(word[i] + ":\t"  + "|" + re);
        			break;
        		}
                
            } 
        }
        
		
	}
}
