package leetcode.Solutions;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
        if(T.length()>S.length()){
            return "";
        }
        char[] ta= T.toCharArray();
    	char[] sa = S.toCharArray();
    	int[] table = new int[256];
    	int[] window = new int[256];
    	for(int i=0;i<256;i++){
    		table[i]=0;
    		window[i]=0;
    	}
    	int count=0;
    	for(int i=0; i<T.length();i++){
    		table[ta[i]]+=1;
    	}
    	int minLen = Integer.MAX_VALUE;
    	int start = 0;
    	int end = 0;
    	int minBegin = 0;
    	for(;end<S.length();end++){
    		
    		if(table[sa[end]]==0){
    			continue;
    		}
    		if(++window[sa[end]]<=table[sa[end]]){
    			count++;
    		}
    		if(count == T.length()){
    			while(table[sa[start]]<window[sa[start]]||table[sa[start]]==0){
    				if(window[sa[start]]>table[sa[start]]){
    					window[sa[start]]--;
    				}
    				start++;
    			}
    			int len = end-start+1;
    			if(len<minLen){
    				minLen=len;
    				minBegin = start;
    			}
    		}
    	}
    	if(minLen <= S.length())
    	return S.substring(minBegin,minBegin+minLen);
    	else return "";
    }
}
