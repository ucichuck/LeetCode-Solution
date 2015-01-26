package leetcode.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Anagrams {
	public  String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }   

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        HashMap<String, LinkedList<String>> hash = new HashMap<String, LinkedList<String>>();
     
        /* Group words by anagram */
        for (String s : strs) {
            String key = sortChars(s); 
            if (!hash.containsKey(key)) {
                hash.put(key, new LinkedList<String>());
            }   
            LinkedList<String> anagrams = hash.get(key);
            anagrams.push(s);
        } 
        for (String key : hash.keySet()) {
            LinkedList<String> list = hash.get(key);
            if (list.size() > 1) {
// should be bigger than 1.  1 means no anagrams
                for (String t : list) {
                    res.add(t);
                }   
            }
        }   
        return res;
    }
}
