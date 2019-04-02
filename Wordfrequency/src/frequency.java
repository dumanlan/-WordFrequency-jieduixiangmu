import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class frequency {
	
	public static Scanner in = new Scanner(System.in);
    public static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    
    public static void main(String[] args) { // 用HashMap存放<单词:词频>这样一个映射关系
    	
        
        // 用正则表达式来过滤字符串中的所有标点符号
        String regex = "[1234567890”“…—‘’　【】、.。,，。\"!--;:?\'\\]]";
        try {
            // 读取要处理的文件
        	System.out.println("请输入读取文件的文件名：");
        	String s = in.nextLine();
            BufferedReader br = new BufferedReader(new FileReader(s));
            String value;
            while ((value = br.readLine()) != null) {
                value = value.replaceAll(regex, " ");
                // 使用StringTokenizer来分词
                StringTokenizer tokenizer = new StringTokenizer(value);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    if (!hashMap.containsKey(word)) {
                        hashMap.put(word, new Integer(1));
                    } else {
                        int k = hashMap.get(word).intValue() + 1;
                        hashMap.put(word, new Integer(k));
                    }
                }
            }
            //显示用户需要查询的若干个单词的词频
            WordQuery.wordQuery(hashMap);
            //按值排序,并输出用户要求的词频最多的前K个单词
            SortMapByValues.sortMapByValues(hashMap);
            //根据键的字母顺序排序，排好后放到result.txt文件中
            SortMapByKeys.sortMapByKeys(hashMap);
           //删除代词、冠词和介词，排好序后放到result1.txt文件中
            TongJiGaoPinCi.tongjigaopinci(hashMap);
        
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
