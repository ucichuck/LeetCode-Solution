package leetcode.Solutions;

public class OneEditDistance {
	public boolean isOneEditDistance1(String s, String t) {
        int m = s.length(), n = t.length();
        if (m>n) return isOneEditDistance1(t, s);
        if (n-m>1) return false;
        int i =0, shift = n-m;
        while (i<m && s.charAt(i)==t.charAt(i)) ++i;
        if (i==m) return shift > 0; // if two string are the same (shift==0), return false
        if (shift==0) i++; // if n==m skip current char in s (modify operation in s)
        while (i<m && s.charAt(i)==t.charAt(i+shift)) i++; // use shift to skip one char in t
        return i == m;
    }
	
	//another solution
	public boolean isOneEditDistance2(String s, String t) {
	       if(Math.abs(s.length() - t.length()) > 1) return false;
	       if(s.length() == t.length()) return isOneSameLength(s, t);
	       if(s.length() > t.length()) return isOneDifLength(t, s);
	       else return isOneDifLength(s, t);
	   }
	   private boolean isOneDifLength(String s, String l) {
	        int i = 0;
	       while(i < s.length() && s.charAt(i) == l.charAt(i)) {++i;}
	       if(i == s.length()) return true;
	       return s.substring(i).equals(l.substring(i + 1));
	   }
	   private boolean isOneSameLength(String s, String t) {
	       int dif = 0;
	       for(int i = 0; i < s.length(); ++i) {
	            if(s.charAt(i) != t.charAt(i)) ++dif;
	       }
	       return dif == 1;
	   }
}
