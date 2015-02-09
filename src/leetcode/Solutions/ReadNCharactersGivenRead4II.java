package leetcode.Solutions;

public class ReadNCharactersGivenRead4II {
//	public class Solution extends Reader4 {
//	    /**
//	     * @param buf Destination buffer
//	     * @param n   Maximum number of characters to read
//	     * @return    The number of characters read
//	     */
//	   private List<Character> left;
//	    public int read(char[] buf, int n) {
//	        if(left==null) left = new ArrayList<Character>();
//	        int ptr = Math.min(n,left.size());
//	        for(int i=0;i<ptr;i++) buf[i] = left.get(i);
//	        left.subList(0,ptr).clear();
//	        if(n<left.size()) return n;
//	        else{
//	            while(ptr < n){
//	                char[] b4 = new char[4];
//	                int r = read4(b4);
//	                if(r==0) return ptr;
//	                int min2 = Math.min(r,n-ptr);
//	                for(int i=0;i<min2;i++) buf[ptr++]=b4[i];
//	                if(min2<r)  for(int i=min2;i<r;i++) left.add(b4[i]);
//	            }
//	        return ptr;
//	        }
//	    }
//	}
}
