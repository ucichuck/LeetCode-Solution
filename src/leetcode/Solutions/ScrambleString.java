package leetcode.Solutions;

import java.util.Arrays;

public class ScrambleString {
	public static boolean isScramble(String s1, String s2) {  
        if(s1.length() != s2.length()){  
            return false;  
        }  
        if(s1.length()==1 && s2.length()==1){  
            return s1.charAt(0) == s2.charAt(0);  
        }  
          
        // 排序后可以通过  
        char[] s1ch = s1.toCharArray();  
        char[] s2ch = s2.toCharArray();  
        Arrays.sort(s1ch);  
        Arrays.sort(s2ch);  
        if(!new String(s1ch).equals(new String(s2ch))){  
            return false;  
        }  
          
        for(int i=1; i<s1.length(); i++){        // 至少分出一个字符出来  
            String s11 = s1.substring(0, i);  
            String s12 = s1.substring(i);  
            String s21 = s2.substring(0, i);  
            String s22 = s2.substring(i);  
//          System.out.println(s1 + "-" + s2 + ": "+ s11 + ", " + s12 + ", " + s21 + ", " + s22);  
            // 检测前半部是否匹配  
            if(isScramble(s11, s21) && isScramble(s12, s22)){  
                return true;  
            }  
            // 前半部不匹配，检测后半部是否匹配  
            s21 = s2.substring(0, s2.length()-i);  
            s22 = s2.substring(s2.length()-i);  
            if(isScramble(s11, s22) && isScramble(s12, s21)){  
                return true;  
            }  
        }  
        return false;  
    }  
      
    public static boolean isScrambleDP(String s1, String s2) {  
        int len = s1.length();  
        if(len != s2.length()){  
            return false;  
        }  
        if(len == 0){  
            return true;  
        }  
          
        char[] c1 = s1.toCharArray();  
        char[] c2 = s2.toCharArray();  
        // canTransform 第一维为子串的长度delta，第二维为s1的起始索引，第三维为s2的起始索引  
        // canTransform[k][i][j]表示s1[i...i+k]是否可以由s2[j...j+k]变化得来。  
        boolean[][][] canT = new boolean[len][len][len];      
        for(int i=0; i<len; i++){  
            for(int j=0; j<len; j++){    // 如果字符串总长度为1，则取决于唯一的字符是否想到  
                canT[0][i][j] = c1[i] == c2[j];  
            }  
        }  
          
        for(int k=2; k<=len; k++){       // 子串的长度  
            for(int i=len-k; i>=0; i--){         // s1[i...i+k]  
                for(int j=len-k; j>=0; j--){ // s2[j...j+k]  
                    boolean canTransform = false;  
                    for(int m=1; m<k; m++){  // 尝试以m为长度分割子串  
                        // canT[k][i][j]  
                        canTransform = (canT[m-1][i][j] && canT[k-m-1][i+m][j+m]) ||    // 前前后后匹配  
                                              (canT[m-1][i][j+k-m] && canT[k-m-1][i+m][j]); // 前后后前匹配  
                        if(canTransform){  
                            break;  
                        }  
                    }  
                    canT[k-1][i][j] = canTransform;  
                }  
            }  
        }  
          
        return canT[len-1][0][0];  
    }  
}
