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
          
        // ��������ͨ��  
        char[] s1ch = s1.toCharArray();  
        char[] s2ch = s2.toCharArray();  
        Arrays.sort(s1ch);  
        Arrays.sort(s2ch);  
        if(!new String(s1ch).equals(new String(s2ch))){  
            return false;  
        }  
          
        for(int i=1; i<s1.length(); i++){        // ���ٷֳ�һ���ַ�����  
            String s11 = s1.substring(0, i);  
            String s12 = s1.substring(i);  
            String s21 = s2.substring(0, i);  
            String s22 = s2.substring(i);  
//          System.out.println(s1 + "-" + s2 + ": "+ s11 + ", " + s12 + ", " + s21 + ", " + s22);  
            // ���ǰ�벿�Ƿ�ƥ��  
            if(isScramble(s11, s21) && isScramble(s12, s22)){  
                return true;  
            }  
            // ǰ�벿��ƥ�䣬����벿�Ƿ�ƥ��  
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
        // canTransform ��һάΪ�Ӵ��ĳ���delta���ڶ�άΪs1����ʼ����������άΪs2����ʼ����  
        // canTransform[k][i][j]��ʾs1[i...i+k]�Ƿ������s2[j...j+k]�仯������  
        boolean[][][] canT = new boolean[len][len][len];      
        for(int i=0; i<len; i++){  
            for(int j=0; j<len; j++){    // ����ַ����ܳ���Ϊ1����ȡ����Ψһ���ַ��Ƿ��뵽  
                canT[0][i][j] = c1[i] == c2[j];  
            }  
        }  
          
        for(int k=2; k<=len; k++){       // �Ӵ��ĳ���  
            for(int i=len-k; i>=0; i--){         // s1[i...i+k]  
                for(int j=len-k; j>=0; j--){ // s2[j...j+k]  
                    boolean canTransform = false;  
                    for(int m=1; m<k; m++){  // ������mΪ���ȷָ��Ӵ�  
                        // canT[k][i][j]  
                        canTransform = (canT[m-1][i][j] && canT[k-m-1][i+m][j+m]) ||    // ǰǰ���ƥ��  
                                              (canT[m-1][i][j+k-m] && canT[k-m-1][i+m][j]); // ǰ���ǰƥ��  
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
