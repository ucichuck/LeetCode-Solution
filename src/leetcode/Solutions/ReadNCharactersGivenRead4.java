package leetcode.Solutions;

//public class ReadNCharactersGivenRead4 {
//	public class Solution extends Reader4 {
//		   /**
//		    * @param buf Destination buffer
//		    * @param n   Maximum number of characters to read
//		    * @return    The number of characters read
//		    */
//		   public int read(char[] buf, int n) {
//		      char[] buffer = new char[4];
//		      int readBytes = 0;
//		      boolean eof = false;
//		      while (!eof && readBytes < n) {
//		          int sz = read4(buffer);
//		          if (sz < 4) eof = true;
//		          int bytes = Math.min(n - readBytes, sz); 
//		          System.arraycopy(buffer /* src */, 0 /* srcPos */, buf /* dest */, readBytes /* destPos */, bytes /* length */);
//		      readBytes += bytes;
//		}
//		      return readBytes;
//		   }
//		}   
//}

//public class Solution extends Reader4 {
//    /**
//     * @param buf Destination buffer
//     * @param n   Maximum number of characters to read
//     * @return    The number of characters read
//     */
//    public int read(char[] buf, int n) {
//        int index = 0;
//    	while(index < n){
//        	char[] tmp = new char[4];
//        	int next = read4(tmp);
//        	if(next == 0){
//        		return index;
//        	}
//        	
//        	int nextIndex = Math.min(next, n-index);
//        	
//        	for(int i=0; i<nextIndex; i++){
//        		buf[index++] = tmp[i];
//        	}
//        }
//    	return index;
//    }
//}