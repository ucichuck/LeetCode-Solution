package leetcode.Solutions;







//public class Solution {
//    public int trailingZeroes(int n) {
//        if(n< 4){
//        	return 0;
//        }
//        
//        int ret = 0;
//        while(n>0)
//        {
//            ret += n/5;
//            n /= 5;
//        }
//        return ret;
//    }
//}





//import java.util.HashMap;
//import java.util.LinkedList;
//
//import leetcode.Utility.UndirectedGraphNode;
//
//public class Solution {
//	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if(node == null)
//            return null;
//            
//        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
//        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
//        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
//        hm.put(node, head);
//        queue.add(node);
//        
//        while(!queue.isEmpty()){
//            UndirectedGraphNode curnode = queue.poll();
//            for(UndirectedGraphNode aneighbor: curnode.neighbors){//check each neighbor
//                if(!hm.containsKey(aneighbor)){//if not visited,then add to queue
//                    queue.add(aneighbor);
//                    UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
//                    hm.put(aneighbor, newneighbor);
//                }
//                
//                hm.get(curnode).neighbors.add(hm.get(aneighbor));
//            }
//        }
//        
//        return head;
//    }
//}





//public class Solution {
//    public int minCut(String s) {
//        if(s == null || s.length() <2){
//        	return 0;
//        }
//        
//        int[] dp = new int[s.length()+1];
//        boolean[][] arr = new boolean[s.length()][s.length()];
//        
//        for(int i= s.length(); i>=0; i--){
//        	dp[i] = s.length() - i;
//        }
//        
//        for(int i=s.length()-1; i>=0; i--){
//        	for(int j = i; j<s.length(); j++){
//        		if(s.charAt(i) == s.charAt(j) &&(j-i < 2 || arr[i+1][j-1])){
//        			arr[i][j] = true;
//        			dp[i] = Math.min(dp[i], dp[j+1]+1);
//        		}
//        	}
//        }
//        return dp[0]-1;
//    }
//}





//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//import java.util.Set;
//
//public class Solution {
//    public List<List<String>> findLadders(String start, String end,
//            Set<String> dict) {
//        List<List<String>> ladders = new ArrayList<List<String>>();
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        Map<String, Integer> distance = new HashMap<String, Integer>();
//
//        dict.add(start);
//        dict.add(end);
// 
//        bfs(map, distance, start, end, dict);
//        
//        List<String> path = new ArrayList<String>();
//        
//        dfs(ladders, path, end, start, distance, map);
//
//        return ladders;
//    }
//
//    void dfs(List<List<String>> ladders, List<String> path, String crt,
//            String start, Map<String, Integer> distance,
//            Map<String, List<String>> map) {
//        path.add(crt);
//        if (crt.equals(start)) {
//            Collections.reverse(path);
//            ladders.add(new ArrayList<String>(path));
//            Collections.reverse(path);
//        } else {
//           if(map.containsKey(crt)){
//                for (String next : map.get(crt)) {
//                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) { 
//                    dfs(ladders, path, next, start, distance, map);
//                }
//            }          
//           } 
//        }
//        path.remove(path.size() - 1);
//    }
//
//    void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
//            String start, String end, Set<String> dict) {
//        Queue<String> q = new LinkedList<String>();
//        q.offer(start);
//        distance.put(start, 0);
////        for (String s : dict) {
////            map.put(s, new ArrayList<String>());
////        }
//        
//        while (!q.isEmpty()) {
//            String crt = q.poll();
//
//            List<String> nextList = expand(crt, dict);
//            for (String next : nextList) {
//            	if(!map.containsKey(next)){
//            		map.put(next, new ArrayList<String>());
//            	}
//                map.get(next).add(crt);
//                if (!distance.containsKey(next)) {
//                    distance.put(next, distance.get(crt) + 1);
//                    q.offer(next);
//                }
//            }
//        }
//    }
//
//    List<String> expand(String crt, Set<String> dict) {
//        List<String> expansion = new ArrayList<String>();
//
//        for (int i = 0; i < crt.length(); i++) {
//            for (char ch = 'a'; ch <= 'z'; ch++) {
//                if (ch != crt.charAt(i)) {
//                    String expanded = crt.substring(0, i) + ch
//                            + crt.substring(i + 1);
//                    if (dict.contains(expanded)) {
//                        expansion.add(expanded);
//                    }
//                }
//            }
//        }
//
//        return expansion;
//    }
//}





//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Solution {
//    public int ladderLength(String start, String end, Set<String> dict) {
//        HashSet<String> visited = new HashSet<String>();
//        ArrayList<String> curr = new ArrayList<String>();
//        ArrayList<String> nexts = new ArrayList<String>();
//        
//        curr.add(start);
//        int count = 1;
//        
//        while(!curr.isEmpty()){
//        	String tmp = curr.remove(0);
//        	ArrayList<String> changedKey = get(tmp, dict, visited);
//        	for(String newKey : changedKey){
//        		if(newKey.equals(end)){
//        			return count+1;
//        		}else{
//        			nexts.add(newKey);
//        		}
//        	}
//        	if(curr.isEmpty()){
//        		curr = nexts;
//        		count ++;
//        		nexts = new ArrayList<String>();
//        	}
//        }
//        return 0;
//    }
//    
//    private  ArrayList<String> get(String tmp, Set<String> dict, HashSet<String> visited){
//    	ArrayList<String> res = new ArrayList<String>();
//    	char[] arr = tmp.toCharArray();
//    	for(int i=0; i<tmp.length(); i++){
//    		char currentChar = tmp.charAt(i);
//    		for(char a = 'a'; a<='z'; a++){
//    			if(a != currentChar){
//    				arr[i] = a;
//    				String convert = new String(arr);
//    				if(dict.contains(convert) && !visited.contains(convert)){
//    					res.add(convert);
//    					visited.add(convert);
//    				}
//    				arr[i] = currentChar;
//    			}
//    		}
//    		
//    	}
//    	return res;
//    }
//}




//
//public class Solution {
//	private int count = 0;
//    public int totalNQueens(int n) {
//      if(n <= 0){
//      	return 0;
//      }
//      
//      int[] arr = new int[n];
//      for(int i=0; i<n; i++){
//      	arr[i] = -1;
//      }
//            
//      cal(0, n ,arr);
//      
//      return count;
//  }
//  private void cal(int index, int n, int[] arr){
//  	if(n == index){
//  		count++;
//  		return;
//  	}
//  	
//  	for(int i=0; i<n; i++){
//  		arr[index] = i;
//  		if(isValid(arr, index)){
//  			cal(index+1, n, arr);
//  		}
//  		arr[index] = -1;
//  	}
//  }
//  
//  private boolean isValid(int[] arr, int index){
//  	if(index == 0){
//  		return true;
//  	}
//  	
//  	for(int i=0; i<index; i++){
//  		if(arr[i] == arr[index]){
//  			return false;
//  		}
//  		
//  		if(Math.abs(i-index) == Math.abs(arr[i] - arr[index])){
//  			return false;
//  		}
//  	}
//  	return true;
//  }
//}





//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Solution {
//    public List<String[]> solveNQueens(int n) {
//    	List<String[]> res = new ArrayList<String[]>();
//        if(n <= 0){
//        	return res;
//        }
//        
//        int[] arr = new int[n];
//        for(int i=0; i<n; i++){
//        	arr[i] = -1;
//        }
//        
//        List<int[]> boards = new ArrayList<int[]>();
//        
//        cal(0, n ,arr,boards);
//        
//        for(int[] a : boards){
//        	String[] sss = new String[n];
//        	for(int j=0; j<a.length; j++){
//        		String tmp = "";
//        		for(int i=0; i<n; i++){
//            		if(i == a[j]){
//            			tmp+="Q";
//            		}else{
//            			tmp+=".";
//            		}
//            	}
//        		sss[j] = tmp;
//        	}
//        	res.add(sss);
//        }
//        return res;
//    }
//    private void cal(int index, int n, int[] arr , List<int[]> boards){
//    	if(n == index){
//    		int[] arr2 = Arrays.copyOfRange(arr, 0, arr.length);
//    		boards.add(arr2);
//    		return;
//    	}
//    	
//    	for(int i=0; i<n; i++){
//    		arr[index] = i;
//    		if(isValid(arr, index)){
//    			cal(index+1, n, arr, boards);
//    		}
//    		arr[index] = -1;
//    	}
//    }
//    
//    private boolean isValid(int[] arr, int index){
//    	if(index == 0){
//    		return true;
//    	}
//    	
//    	for(int i=0; i<index; i++){
//    		if(arr[i] == arr[index]){
//    			return false;
//    		}
//    		
//    		if(Math.abs(i-index) == Math.abs(arr[i] - arr[index])){
//    			return false;
//    		}
//    	}
//    	return true;
//    }
//}





//public class Solution {
//    public String intToRoman(int num) {
//        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
//        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L","XL","X","IX","V","IV","I"}; 
//        
//        StringBuilder res = new StringBuilder();
//        int i=0;
//        while(num > 0){
//        	int k = num / values[i];
//        	for(int j=0; j< k; j++){
//        		res.append(strings[i]);
//        		num -= values[i];
//        	}
//        	i++;
//        }
//        return res.toString();
//    }
//}





//import java.util.HashMap;
//
//public class Solution {
//    public int romanToInt(String s) {
//        HashMap<Character, Integer> table = new HashMap<Character,Integer>();
//        table.put('I', 1);
//        table.put('V', 5);
//        table.put('X', 10);
//        table.put('L', 50);
//        table.put('C', 100);
//        table.put('D', 500);
//        table.put('M', 1000);
//        
//        if(s == null || s.length() == 0){
//        	return 0;
//        }
//        int pre = 0; int res = 0;
//        for(int i=0; i<s.length(); i++){
//        	int cur = table.get(s.charAt(i));
//        	if(cur <= pre){
//        		res+=cur;
//        	}else{
//        		res += cur - pre*2;
//        	}
//        	pre = cur;
//        }
//        return res;
//    }
//}




//import java.util.Arrays;
//import java.util.Comparator;
//
//public class Solution {
//    public String largestNumber(int[] num) {
//        int len = num.length;
//        String array[] = new String[len];
//        for (int i = 0; i < len; i++) {
//            array[i] = String.valueOf(num[i]);
//        }
//        Arrays.sort(array, new MySort());
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < len; i++) {
//            sb.append(array[i]);
//        }
//        String result = sb.toString();
//        if ("".equals(result.replace("0",""))) {
//            return "0";
//        }
//        return sb.toString();
//    }
//
//    public class MySort implements Comparator<String> {
//        @Override
//        public int compare(String o1, String o2) {
//            return (o2 + o1).compareTo(o1 + o2);
//        }
//    }
//}





///* The read4 API is defined in the parent class Reader4.
//      int read4(char[] buf); */
//public class Solution extends Reader4 {
//   /**
//    * @param buf Destination buffer
//    * @param n   Maximum number of characters to read
//    * @return    The number of characters read
//    */
//   public int read(char[] buf, int n) {
//      char[] buffer = new char[4];
//      int readBytes = 0;
//      boolean eof = false;
//      while (!eof && readBytes < n) {
//          int sz = read4(buffer);
//          if (sz < 4) eof = true;
//          int bytes = Math.min(n - readBytes, sz); 
//          System.arraycopy(buffer /* src */, 0 /* srcPos */, buf /* dest */, readBytes /* destPos */, bytes /* length */);
//      readBytes += bytes;
//}
//      return readBytes;
//   }
//}   






//public class TwoSum {
//	
//	public void add(int number) {
//	    
//	}
//
//	public boolean find(int value) {
//	    
//	}
//}





//public class Solution {
//    public int majorityElement(int[] num) {
//    	if(num.length == 0){
//    		throw new IllegalArgumentException("wrong input");
//    	}
//    	
//    	int cur = 0;
//    	int count = 0;
//    	for(int a : num){
//    		if(count == 0){
//    			cur = a;
//    			count++;
//    			continue;
//    		}
//    		if(cur == a){
//    			count++;
//    		}else{
//    			count--;
//    		}
//    	}
//    	if(count < 1){
//    		throw new IllegalArgumentException("wrong input");
//    	}
//    	return cur;
//    }
//}





//public class Solution {
//    public int majorityElement(int[] num) {
//    	int candidate = num[0];
//        int nTimes, i;
//        for (i = nTimes = 0; i < num.length; i++)
//        {
//            if (candidate == num[i])
//                nTimes++;
//            else 
//                nTimes--;
//            if (nTimes == 0)
//            {
//                candidate = num[i];
//                nTimes = 1;
//            }
//        }
//        return candidate;
//    }
//}





//public class Solution {
//    public int findPeakElement(int[] num) {
//    	if (num == null) {
//            return 0;
//        }
//        
//        if (num.length == 1) {
//            return 0;
//        }
//        
//      return get(num,0,num.length-1);
//    }
//    private int get(int[] num, int left, int right){
//    	if(left == right){
//    		return left;
//    	}
//    	int mid = (left+right)/2;
//    	int mid2 = mid+1;
//    	if(num[mid] > num[mid2]){
//    		return get(num,left,mid);
//    	}else{
//    		return get(num,mid2,right);
//    	}
//    }
//}





//import leetcode.Utility.ListNode;
//
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if(headA == null || headB == null){
//        	return null;
//        }
//        ListNode pA = headA;
//        ListNode pB = headB;
//        while(pA != null && pB != null){
//        	pA = pA.next;
//        	pB = pB.next;
//        }
//        
//        while(pA != null){
//        	pA = pA.next;
//        	headA = headA.next;
//        }
//        
//        while(pB != null){
//        	pB = pB.next;
//        	headB = headB.next;
//        }
//        
//    	while(headA != headB){
//    		headA= headA.next;
//    		headB = headB.next;
//    	}
//    	return headA;
//        
//    }
//}





//import java.util.Stack;
//class MinStack {
//	Stack<Integer> st1 = new Stack<Integer>();
//	Stack<Integer> st2 = new Stack<Integer>();
//	
//    public void push(int x) {
//        st1.push(x);
//        if(st2.isEmpty()){
//        	st2.push(x);
//        }else{
//        	if(x <= getMin()){
//        		st2.push(x);
//        	}
//        }
//    }
//
//    public void pop() {
//    	if(st1.isEmpty()){
//        	throw new IllegalArgumentException("no min");
//        }else{
//        	int res = st1.pop();
//        	if(res == getMin()){
//        		st2.pop();
//        	}
//        }
//    }
//
//    public int top() {
//        if(st1.isEmpty()){
//        	throw new IllegalArgumentException("no min");
//        }else{
//        	return st1.peek();
//        }
//    }
//
//    public int getMin() {
//        if(st2.isEmpty()){
//        	throw new IllegalArgumentException("no min");
//        }else{
//        	return st2.peek();
//        }
//    }
//}







//import leetcode.Utility.ListNode;
//import leetcode.Utility.TreeNode;
//
//public class Solution {
//	ListNode head = null;
//    public TreeNode sortedListToBST(ListNode head) {
//        if(head == null){
//        	return null;
//        }
//        
//        ListNode cur = head;
//        int count = 0;
//        while(cur != null){
//        	count++;
//        	cur = cur.next;
//        }
//        
//        this.head = head;
//        return get(0, count-1);
//    }
//    private TreeNode get(int left, int right){
//    	if(left > right){
//    		return null;
//    	}
//    	int mid = (left+right)/2;
//    	TreeNode leftNode = get(left,mid - 1);
//    	TreeNode cur = new TreeNode(head.val);
//    	head = head.next;
//    	cur.left = leftNode;
//    	TreeNode rightNode = get(mid+1, right);
//    	cur.right = rightNode;
//    	return cur;
//    }
//}





//public class Solution {
//    public boolean isOneEditDistance(String s, String t) {
//        int m = s.length(), n = t.length();
//        if (m>n) return isOneEditDistance(t, s);
//        if (n-m>1) return false;
//        int i =0, shift = n-m;
//        while (i<m && s.charAt(i)==t.charAt(i)) ++i;
//        if (i==m) return shift > 0; // if two string are the same (shift==0), return false
//        if (shift==0) i++; // if n==m skip current char in s (modify operation in s)
//        while (i<m && s.charAt(i)==t.charAt(i+shift)) i++; // use shift to skip one char in t
//        return i == m;
//    }
//}
//
//public class Solution {
//    public boolean isOneEditDistance(String s, String t) {
//       if(Math.abs(s.length() - t.length()) > 1) return false;
//       if(s.length() == t.length()) return isOneSameLength(s, t);
//       if(s.length() > t.length()) return isOneDifLength(t, s);
//       else return isOneDifLength(s, t);
//   }
//   private boolean isOneDifLength(String s, String l) {
//        int i = 0;
//       while(i < s.length() && s.charAt(i) == l.charAt(i)) {++i;}
//       if(i == s.length()) return true;
//       return s.substring(i).equals(l.substring(i + 1));
//   }
//   private boolean isOneSameLength(String s, String t) {
//       int dif = 0;
//       for(int i = 0; i < s.length(); ++i) {
//            if(s.charAt(i) != t.charAt(i)) ++dif;
//       }
//       return dif == 1;
//   }
//}




//public class Solution {
//    public boolean isOneEditDistance(String s, String t) {
//        int a = s.length();
//        int b = t.length();
//        int[][] arr = new int[a+1][b+1];
//        for(int i=0; i<=a; i++){
//        	for(int j=0; j<=b; j++){
//        		if(i == 0 && j == 0){
//        			arr[i][j] = 0;
//        		}else if(i == 0){
//        			arr[i][j] = arr[i][j-1]+1;
//        		}else if(j == 0){
//        			arr[i][j] = arr[i-1][j]+1;
//        		}else{
//        			if(s.charAt(i-1) == t.charAt(j-1)){
//        				arr[i][j] = arr[i-1][j-1];
//        			}else{
//        				arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1]))+1;
//        			}
//        		}
//        	}
//        }
//        return arr[a][b] == 1;
//    }
//}





//import leetcode.Utility.ListNode;
//
//public class Solution {
//    public void reorderList(ListNode head) {
//        if(head == null || head.next == null) return;
//
//        ListNode slow = head;
//        ListNode fast = head;
//        while(fast.next != null && fast.next.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        ListNode mid = slow.next;
//        ListNode last = mid;
//        ListNode pre = null;
//        while(last != null){
//            ListNode next = last.next;
//            last.next = pre;
//            pre = last;
//            last = next;
//        }
//        slow.next = null;
//
//        while(head != null && pre != null){
//            ListNode next1 = head.next;
//            head.next = pre;
//            pre = pre.next;
//            head.next.next = next1;
//            head = next1;
//        }
//    }
//}





//public class Solution {
//    public int findMin(int[] num) {
//      if(num.length == 0){
//    	return -1;
//    }
//    int left = 0;
//    int right = num.length-1;
//    
//    while(left < right){
//    	int mid = (left+right)/2;
//    	if(num[mid] > num[right]){
//    		left = mid +1;
//    	}else if(num[mid] < num[right]){
//    		right = mid;
//    	}else{
//    		right --;
//    	}
//    }
//    return num[left];
//    }
//}





//public class Solution {
//    public int findMin(int[] num) {
//        if(num.length == 0){
//        	return -1;
//        }
//        int left = 0;
//        int right = num.length-1;
//        while(left <= right){
//        	int mid = (left+right)/2;
//        	if(num[mid] > num[right]){
//        		left = mid +1;
//        	}else{
//        		right = mid - 1;
//        	}
//        }
//        return left;
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public List<Integer> postorderTraversal(TreeNode root) {
//    	List<Integer> res = new ArrayList<Integer>();
//    	if(root == null){
//		return res;
//    	}
//    	
//    	Stack<TreeNode> st = new Stack<TreeNode>();
//    	Stack<TreeNode> st2 = new Stack<TreeNode>();
//    	st.add(root);
//    	while(!st.isEmpty()){
//    		TreeNode cur = st.pop();
//    		st2.push(cur);
//    		if(cur.left != null){
//    			st.add(cur.left);
//    		}
//    		if(cur.right != null){
//    			st.add(cur.right);
//    		}
//    	}
//    	
//    	while(!st2.isEmpty()){
//    		res.add(st2.pop().val);
//    	}
//    	return res;
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
//    	List<Integer> res = new ArrayList<Integer>();
//    	if(root == null){
//    		return res;
//    	}
//    	
//    	Stack<TreeNode> st = new Stack<TreeNode>();
//    	st.add(root);
//    	while(!st.isEmpty()){
//    		TreeNode cur = st.pop();
//    		res.add(cur.val);
//    		if(cur.right != null){
//    			st.add(cur.right);
//    		}
//    		if(cur.left != null){
//    			st.add(cur.left);
//    		}
//    	}
//    	return res;
//    }
//}





//public class Solution {
//    public int removeDuplicates(int[] A) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int len =A.length;
//        if(len==1){
//            return 1;
//        }else if(len<=0){
//            return 0;
//        }
//        int count=1;
//        int cur=A[0];
//        int b=1;
//        int resLen =0;
//        for(int i=1; i<len; i++){
//            if(cur==A[i]){
//                if(count<2){
//                    count++;
//                    A[b]=A[i];
//                    b++;
//                }
//            }else{
//                A[b]=A[i];
//                cur=A[i];
//                b++;
//                count=1;
//            }
//        }
//        
//        return b;
//        
//    }
//}





//public class Solution {
//
//    public int divide(int dividend, int divisor) {
//        if(dividend == Integer.MIN_VALUE && divisor == -1){
//            return Integer.MAX_VALUE;
//        }
//        boolean negative = (dividend > 0 && divisor < 0) ||
//            (dividend < 0 && divisor > 0);
//
//        long a = Math.abs((long)dividend);
//        long b = Math.abs((long)divisor);
//        int ans = 0;
//
//        while (a >= b) {
//            int shift = 0;
//            while ((b << shift) <= a) {
//                shift++;
//            }
//            ans += 1 << (shift-1);
//            a = a - (b << (shift-1));
//        }
//
//        return negative ? -ans : ans;
//    }
//}





//import java.util.List;
//
//import leetcode.Utility.ListNode;
//
//public class Solution {
//    public ListNode mergeKLists(List<ListNode> lists) {
//        if(lists.isEmpty()){
//        	return null;
//        }
//        
//        int left = 0;
//        int right = lists.size()-1;
//        
//        while(right >0){
//        	while(left < right){
//        		lists.set(left, merge(lists,left,right));
//        		right--;
//        		left++;
//        	}
//        	left = 0;
//        }
//        return lists.get(0);
//    }
//    
//    private ListNode merge(List<ListNode> lists, int left, int right){
//    	ListNode pre = new ListNode(-1);
//    	ListNode res = pre;
//    	ListNode a =lists.get(left);
//    	ListNode b = lists.get(right);
//    	
//    	while(a != null && b != null){
//    		if(a.val < b.val){
//    			pre.next = a;
//    			a = a.next;
//    		}else{
//    			pre.next = b;
//    			b = b.next;
//    			
//    		}
//    		pre = pre.next;
//    	}
//    	if(a != null){
//    		pre.next =a;
//    	}else if(b != null){
//    		pre.next = b;
//    	}
//    	return res.next;
//    }
//}





//public class Solution {
//    public boolean search(int[] A, int target) {
//        if(A.length == 0){
//        	return false;
//        }
//        
//        return sea(A, target, 0, A.length-1);
//    }
//    private boolean sea(int[] A, int target, int left, int right){
//    	if(left > right){
//    		return false;
//    	}
//    	int mid = (left+right)/2;
//    	if(A[mid] == target){
//    		return true;
//    	}
//    	
//    	if(A[left] < A[mid]){
//    		if(target >= A[left] && target < A[mid]){
//    			return sea(A,target,left, mid-1);
//    		}else{
//    			return sea(A,target,mid+1,right);
//    		}
//    	}else if(A[left] > A[mid]){
//    		if(target <= A[right] && target > A[mid]){
//    			return sea(A,target,mid+1,right);
//    		}else{
//    			return sea(A,target,left, mid-1);
//    		}
//    	}else{
//    		if(A[right] != A[mid]){
//    			return sea(A,target,mid+1,right);
//    		}else{
//    			return sea(A,target,mid+1,right) || sea(A,target,left, mid-1);
//    		}
//    	}
//    }
//}





//public class Solution {
//    public boolean exist(char[][] board, String word) {
//        int m = board.length;
//        int n = board[0].length;
//    	
//    	int[][] visit = new int[board.length][board[0].length];
//        
//        for(int i=0; i<m; i++){
//        	for(int j = 0 ; j<n; j++){
//        		if(board[i][j] == word.charAt(0)){
//        			visit[i][j] = 1;
//        			if(cal(board,i,j, visit, word.substring(1))){
//        				return true;
//        			}
//        			visit[i][j] = 0;
//        		}
//        	}
//        }
//        return false;
//    }
//    
//    private boolean cal(char[][] board, int i, int j, int[][] visit, String word){
//    	if(word.isEmpty()){
//    		return true;
//    	}
//    	
//    	if(i < 0 || i >= board.length || j<0 || j >= board[0].length){
//    		return false;
//    	}
//    	
//    	if(i>0 && visit[i-1][j] != 1 && board[i-1][j] == word.charAt(0)){
//    		visit[i-1][j] = 1;
//    		if(cal(board,i-1,j, visit, word.substring(1))){
//				return true;
//			}
//    		visit[i-1][j] = 0;
//    	}
//    	
//    	if(j>0 && visit[i][j-1] != 1 && board[i][j-1] == word.charAt(0)){
//    		visit[i][j-1] = 1;
//    		if(cal(board,i,j-1, visit, word.substring(1))){
//				return true;
//			}
//    		visit[i][j-1] = 0;
//    	}
//    	
//    	if(j<board[0].length-1 && visit[i][j+1] != 1 && board[i][j+1] == word.charAt(0)){
//    		visit[i][j+1] = 1;
//    		if(cal(board,i,j+1, visit, word.substring(1))){
//				return true;
//			}
//    		visit[i][j+1] = 0;
//    	}
//    	
//    	if(i<board.length-1 && visit[i+1][j] != 1 && board[i+1][j] == word.charAt(0)){
//    		visit[i+1][j] = 1;
//    		if(cal(board,i+1,j, visit, word.substring(1))){
//				return true;
//			}
//    		visit[i+1][j] = 0;
//    	}
//    	return false;
//    }
//    
//}





//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Solution {
//    public List<List<Integer>> subsets(int[] S) {
//        Arrays.sort(S);
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//    	if(S == null || S.length == 0){
//    		return res;
//    	}
//    	
//    	List<Integer> tmp = new ArrayList<Integer>();
//    	cal(S, 0, tmp, res);
//    	return res;
//    }
//    
//    private void cal(int[] S, int index, List<Integer> tmp, List<List<Integer>> res){
//    	if(index == S.length){
//    		List<Integer> tmp2 = new ArrayList<Integer>();
//    		tmp2.addAll(tmp);
//    		res.add(tmp2);
//    		return;
//    	}
//    	
//    		cal(S,index+1,tmp,res);
//    		tmp.add(S[index]);
//    		cal(S,index+1,tmp,res);
//    		tmp.remove(tmp.size()-1);
//    	
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//    public List<List<Integer>> combine(int n, int k) {
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//    	if(n < k){
//    		return res;
//    	}
//    	List<Integer> tmp = new ArrayList<Integer>();
//    	cal(n,k,0,tmp,res);
//    	return res;
//    }
//    private void cal(int n, int k, int cur, List<Integer> tmp, List<List<Integer>> res){
//    	if(k == 0){
//    		 List<Integer> tmp2 = new ArrayList<Integer>();
//    		 tmp2.addAll(tmp);
//    		 res.add(tmp2);
//    	}
//    	if(k > (n-cur)){
//    		return;
//    	}
//    	
//    	for(int i= cur+1; i<=n; i++){
//    		tmp.add(i);
//    		cal(n,k-1,i,tmp,res);
//    		tmp.remove(tmp.size()-1);
//    	}
//    	
//    }
//}





//public class Solution {
//    public String minWindow(String S, String T) {
//        if(T.length()>S.length()){
//            return "";
//        }
//        char[] ta= T.toCharArray();
//    	char[] sa = S.toCharArray();
//    	int[] table = new int[256];
//    	int[] window = new int[256];
//    	for(int i=0;i<256;i++){
//    		table[i]=0;
//    		window[i]=0;
//    	}
//    	int count=0;
//    	for(int i=0; i<T.length();i++){
//    		table[ta[i]]+=1;
//    	}
//    	int minLen = Integer.MAX_VALUE;
//    	int start = 0;
//    	int end = 0;
//    	int minBegin = 0;
//    	for(;end<S.length();end++){
//    		
//    		if(table[sa[end]]==0){
//    			continue;
//    		}
//    		if(++window[sa[end]]<=table[sa[end]]){
//    			count++;
//    		}
//    		if(count == T.length()){
//    			while(table[sa[start]]<window[sa[start]]||table[sa[start]]==0){
//    				if(window[sa[start]]>table[sa[start]]){
//    					window[sa[start]]--;
//    				}
//    				start++;
//    			}
//    			int len = end-start+1;
//    			if(len<minLen){
//    				minLen=len;
//    				minBegin = start;
//    			}
//    		}
//    	}
//    	if(minLen <= S.length())
//    	return S.substring(minBegin,minBegin+minLen);
//    	else return "";
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//    public List<Integer> spiralOrder(int[][] matrix) {
//    	List<Integer> res = new ArrayList<Integer>();
//        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
//        	return res;
//        }
//        
//        int k = matrix.length;
//        int l = matrix[0].length;
//        int x = 0;
//        int y = 0;
//      while(k >0 && l > 0){
//    	if(k == 1){
//    		for(int i=0; i<l; i++){
//    			res.add(matrix[x][y++]);
//    		}
//    		break;
//    	}else if(l == 1){
//    		for(int i =0; i<k; i++){
//    			res.add(matrix[x++][y]);
//    		}
//    		break;
//    	}
//    	
//    	for(int i=0; i<l-1; i++){
//    		res.add(matrix[x][y++]);
//    	}
//    	
//    	for(int i=0; i<k-1; i++){
//    		res.add(matrix[x++][y]);
//    	}
//    	
//    	for(int i=0; i<l-1; i++){
//    		res.add(matrix[x][y--]);
//    	}
//    	
//    	for(int i=0; i<k-1; i++){
//    		res.add(matrix[x--][y]);    	}
//    	
//    	x++;
//    	y++;
//    	k = k-2;
//    	l = l-2;
//    }
//    return res;
//    }
//}





//public class Solution {
//    public int[][] generateMatrix(int n) {
//        if(n <= 0){
//        	return null;
//        }
//        int[][] res = new int[n][n];
//        int count = 1;
//        int k = n;
//        int l = n;
//        int x = 0;
//        int y = 0;
//        while(k >0 && l > 0){
//        	if(k == 1){
//        		for(int i=0; i<l; i++){
//        			res[x][y++] = count++;
//        		}
//        		break;
//        	}else if(l == 1){
//        		for(int i =0; i<k; i++){
//        			res[x++][y] = count++;
//        		}
//        		break;
//        	}
//        	
//        	for(int i=0; i<l-1; i++){
//        		res[x][y++] = count++;
//        	}
//        	
//        	for(int i=0; i<k-1; i++){
//        		res[x++][y] = count++;
//        	}
//        	
//        	for(int i=0; i<l-1; i++){
//        		res[x][y--] = count++;
//        	}
//        	
//        	for(int i=0; i<k-1; i++){
//        		res[x--][y] = count++;
//        	}
//        	
//        	x++;
//        	y++;
//        	k = k-2;
//        	l = l-2;
//        }
//        return res;
//    }
//}





//public class Solution {
//    public void rotate(int[][] matrix) {
//        if(matrix == null || matrix.length == 0){
//        	return ;
//        }
//        int n = matrix.length;
//        int k = n%2 == 0? n/2 : n/2+1;
//        for(int i=0; i<n/2; i++){
//        	for(int j=0; j<k; j++){
//        		int tmp = matrix[i][j];
//        		matrix[i][j] = matrix[n-1-j][i];
//        		matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
//        		matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
//        		matrix[j][n-1-i] = tmp;
//        	}
//        }
//        return ;
//    }
//}





//public class Solution {
//    public int[] twoSum(int[] numbers, int target) {
//        int[] res = new int[2];
//        int left = 0;
//        int right = numbers.length-1;
//        
//        while(left < right){
//        	int sum = numbers[left] + numbers[right];
//        	if(sum == target){
//        		res[0] = left+1;
//        		res[1] = right+1;
//        		break;
//        	}else if(sum > target){
//        		right -- ;
//        	}else{
//        		left ++;
//        	}
//        }
//        return res;
//    }
//}





//public class Solution {
//    public int lengthOfLongestSubstringTwoDistinct(String s) {
//        int i = 0, j = -1, maxLen = 0;
//        for (int k = 1; k < s.length(); k++) {
//            if (s.charAt(k) == s.charAt(k - 1)) continue;
//            if (j >= 0 && s.charAt(j) != s.charAt(k)) {
//                maxLen = Math.max(k - i, maxLen);
//                i = j + 1; 
//            }
//            j = k - 1;  
//        }
//        return Math.max(s.length() - i, maxLen);
//    }
//}





//
//public class Solution {
//    public int compareVersion(String version1, String version2) {
//        if(version1.isEmpty() && version2.isEmpty())return 0;
//        
//        int left = 0;
//        int right = 0;
//        
//        while(left < version1.length() && version1.charAt(left)!='.'){
//        	left++;
//        }
//        while(right < version2.length() && version2.charAt(right)!='.'){
//        	right++;
//        }
//        
//        int a = version1.isEmpty() ? 0 :Integer.valueOf(version1.substring(0,left));
//        int b = version2.isEmpty() ? 0 :Integer.valueOf(version2.substring(0,right));
//        if(a < b){
//        	return -1;
//        }else if(a > b){
//        	return 1;
//        }else{
//        	return compareVersion(left == version1.length()? "" : version1.substring(left+1),
//        			right == version2.length()? "" : version2.substring(right+1));
//        }
//        
//    }
//}





//import leetcode.Utility.ListNode;
//
//public class Solution {
//    public ListNode sortList(ListNode head) {
//        if(head == null || head.next == null){
//        	return head;
//        }
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
//        ListNode p1 = head;
//        ListNode p2 = head;
//        while(p2 != null && p2.next != null){
//        	pre = pre.next;
//        	p1 = p1.next;
//        	p2 = p2.next.next;
//        }
//        
//        pre.next = null;
//        return merge(sortList(head), sortList(p1));
//    }
//    private ListNode merge(ListNode p1, ListNode p2){
//    	ListNode pre = new ListNode(-1);
//    	ListNode res = pre;
//    	while(p1 != null && p2 != null){
//    		if(p1.val < p2.val){
//    			pre.next = p1;
//    			p1 = p1.next;
//    		}else{
//    			pre.next = p2;
//    			p2 = p2.next;
//    					
//    		}
//    		pre = pre.next;
//    	}
//    	if(p1 != null){
//    		pre.next = p1;
//    	}
//    	if(p2 != null){
//    		pre.next = p2;
//    	}
//    	return res.next;
//    }
//}





//public class Solution {
//    public String convertToTitle(int n) {
//        if(n <= 0){
//        	return "";
//        }
//        String res = "";
//        while( n > 0){
//        	int tmpInt = n%26;
//        	char tmp;
//        	n = n/26;
//        	if(tmpInt == 0){
//        		tmp = 'Z';
//        		n--;
//        	}else{
//        		tmp = (char)(tmpInt+'A'-1);
//        	}
//        	 
//        	res = tmp + res;
//        	
//        }
//        return res;
//    }
//}





//public class Solution {
//    public int titleToNumber(String s) {
//        int res = 0;
//        for(int i =0; i<s.length(); i++){
//        	res = res*26 + (s.charAt(i)-'A'+1);
//        }
//        return res;
//    }
//}





//public class Solution {
//    public int maxProduct(int[] A) {
//        if(A == null || A.length <= 0){
//        	return 0;
//        }
//        int max = A[0];
//        int maxcon = A[0];
//        int mincon = A[0];
//        for(int i=1; i<A.length; i++){
//        	int tmp1  = Math.max(A[i], Math.max(A[i]*maxcon, A[i]*mincon));
//        	int tmp2 = Math.min(A[i], Math.min(A[i]*maxcon, A[i]*mincon));
//        	maxcon = tmp1;
//        	mincon = tmp2;
//        	if(maxcon > max){
//        		max = maxcon;
//        	}
//        }
//        return max;
//    }
//}                                           





//import java.util.Stack;
//
//public class Solution {
//    public int evalRPN(String[] tokens) {
//        if(tokens == null || tokens.length == 0){
//        	return 0;
//        }
//        
//        Stack<Integer> st = new Stack<Integer>();
//        for( int i=0; i<tokens.length; i++){
//        	if(!isFac(tokens[i])){
//        		st.push(Integer.valueOf(tokens[i]));
//        	}else{
//        		int b = st.pop();
//        		int a = st.pop();
//        		st.push(cal(a,b,tokens[i]));		
//        	}
//        }
//        return st.pop();
//    }
//    private boolean isFac(String st){
//    	return st.equals("*")||st.equals("/")||st.equals("+")||st.equals("-");
//    }
//    private int cal(int a, int b, String st){
//    	switch(st){
//    	case "+": return a+b;
//    	case "-": return a-b;
//    	case "*" : return a*b;
//    	default : return a/b;
//    	}
//    		
//    }
//}





//import leetcode.Utility.ListNode;
//
//public class Solution {
//    public ListNode rotateRight(ListNode head, int n) {
//    	if(head == null || head.next == null){
//    		return head;
//    	}
//        if(n <= 0){
//        	return head;
//        }
//        
//        ListNode p1 = head;
//        ListNode p2 = head;
//        while(n > 0){
//        	p2 = p2.next;
//        	n--;
//        	if(p2 == null){
//        		p2 = head;
//        	}
//        }
//        if(p1 == p2){
//        	return head;
//        }
//        
//        while(p2.next != null){
//        	p1 = p1.next;
//        	p2 = p2.next;
//        }
//        ListNode res = p1.next;
//        p1.next = null;
//        p2.next = head;
//        return res;
//    }
//}





//public class Solution {
//    public int lengthOfLastWord(String s) {
//        if(s == null || s.length() == 0){
//        	return 0;
//        }
//        int end = s.length()-1;
//        while(end >= 0){
//        	if(s.charAt(end)==' '){
//        		end --;
//        	}else{
//        		break;
//        	}
//        }
//        if(end < 0){
//        	return 0;
//        }
//        
//        int count = 0;
//        while(end >=0 ){
//        	if(s.charAt(end) != ' '){
//        		end--;
//        		count++;
//        	}else{
//        		break;
//        	}
//        }
//        return count;
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//
//import leetcode.Utility.Interval;
//
//public class Solution {
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//    	List<Interval> res = new ArrayList<Interval>();
//    	if(intervals == null || intervals.size() == 0){
//        	res.add(newInterval);
//        	return res;
//        }
//    	int i=0;
//    	boolean notInsert = true;
//    	for( ;i<intervals.size(); i++){
//    		Interval tmp = intervals.get(i);
//    		if(tmp.end < newInterval.start){
//    			res.add(tmp);
//    		}else if(tmp.start > newInterval.end){
//    			if(notInsert){
//    				res.add(newInterval);
//    				notInsert = false;
//    			}
//    			res.add(tmp);
//    		}else{
//    			newInterval.start = Math.min(tmp.start, newInterval.start);
//    			newInterval.end = Math.max(newInterval.end, tmp.end);
//    		}
//    	}
//    	if(notInsert){
//			res.add(newInterval);
//			notInsert = false;
//		}
//    	return res;
//
//    }
//}





//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//import leetcode.Utility.Interval;
//
//public class Solution {
//    public List<Interval> merge(List<Interval> intervals) {
//        if(intervals == null ||intervals.size()== 0){
//        	return intervals;
//        }
//        
//        Collections.sort(intervals, new TmpComparator());
//        List<Interval> res = new ArrayList<Interval>();
//        Interval cur = intervals.get(0);
//        for(int i=1; i<intervals.size(); i++ ){
//        	Interval tmp = intervals.get(i);
//        	if(cur.end < tmp.start){
//        		res.add(cur);
//        		cur = tmp;
//        	}else{
//        		cur.end = Math.max(cur.end, tmp.end);
//        	}
//        }
//        res.add(cur);
//        return res;
//    }
//    private class TmpComparator implements Comparator<Interval>{
//
//		@Override
//		public int compare(Interval t1, Interval t2) {
//			if(t1.start < t2.start){
//				return -1;
//			}else if(t1.start == t2.start){
//				return 0;
//			}else{
//				return 1;
//			}
//		}
//    	
//    }
//}





//import java.util.List;
//
//public class Solution {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if(triangle == null || triangle.size() == 0){
//        	return 0;
//        }
//        int len = triangle.size();
//        
//        int[] arr = new int[len];
//        
//        for(int i= len-1; i>=0; i--){
//        	if(i==len-1){
//        		for(int j=0; j<triangle.get(i).size(); j++){
//        			arr[j] = triangle.get(i).get(j);
//        		}
//        	}else{
//        		for(int j=0; j<triangle.get(i).size(); j++){
//        			arr[j] = Math.min(arr[j], arr[j+1])+triangle.get(i).get(j);
//        		}
//        	}
//        }
//        return arr[0];
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//	public ArrayList<Integer> getRow(int rowIndex) {
//	    ArrayList<Integer> res = new ArrayList<Integer>();
//	    if(rowIndex<0)
//	        return res;
//	    res.add(1);
//	    for(int i=1;i<=rowIndex;i++)
//	    {
//	        for(int j=res.size()-2;j>=0;j--)
//	        {
//	            res.set(j+1,res.get(j)+res.get(j+1));
//	        }
//	        res.add(1);
//	    }
//	    return res;
//	}
//}





//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//    public List<List<Integer>> generate(int numRows) {
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//    	if(numRows <= 0){
//    		return res;
//    	}
//    	List<Integer> tmp = new ArrayList<Integer>();
//    	tmp.add(1);
//    	res.add(tmp);
//    	while(numRows > 1){
//    		List<Integer> tmp2 = new ArrayList<Integer>();
//    		tmp2.add(1);
//    		for(int i=1; i<tmp.size(); i++){
//    			int cur = tmp.get(i)+tmp.get(i-1);
//    			tmp2.add(cur);
//    		}
//    		tmp2.add(1);
//    		res.add(tmp2);
//    		tmp = tmp2;
//    	}
//    	return res;
//    }
//}





//import leetcode.Utility.TreeLinkNode;
//
//public class Solution {
//    public void connect(TreeLinkNode root) {
//        if (root == null) {
//            return;
//        }
//
//        TreeLinkNode parent = root;
//        TreeLinkNode pre;
//        TreeLinkNode next;
//        while (parent != null) {
//            pre = null;
//            next = null;
//            while (parent != null) {
//                if (next == null){
//                    next = (parent.left != null) ? parent.left: parent.right;
//                }
//
//                if (parent.left != null){
//                    if (pre != null) {
//                        pre.next = parent.left;
//                        pre = pre.next;
//                    } else {
//                        pre = parent.left;
//                    }
//                }
//
//                if (parent.right != null) {
//                    if (pre != null) {
//                        pre.next = parent.right;
//                        pre = pre.next;
//                    } else {
//                        pre = parent.right;
//                    }
//                }
//                parent = parent.next;
//            }
//            parent = next;
//        }
//    }
//}





//import java.util.ArrayList;
//
//import leetcode.Utility.TreeLinkNode;
//
//public class Solution {
//    public void connect(TreeLinkNode root) {
//        if(root == null){
//        	return;
//        }
//        ArrayList<TreeLinkNode> lis = new ArrayList<TreeLinkNode>();
//        ArrayList<TreeLinkNode> lis2 = new ArrayList<TreeLinkNode>();
//        lis.add(root);
//        while(!lis.isEmpty()){
//        	TreeLinkNode cur = lis.remove(0);
//        	if(cur.left != null){
//        		lis2.add(cur.left);
//        	}
//        	if(cur.right != null){
//        		lis2.add(cur.right);
//        	}
//        	
//        	if(lis.isEmpty()){
//        		cur.next = null;
//        		lis = lis2;
//        		lis2 = new ArrayList<TreeLinkNode>();
//        	}else{
//        		cur.next = lis.get(0);
//        	}
//        }
//    }
//}





//public class Solution {
//    public int numDistinct(String S, String T) {
//        if(S.length()==0 && T.length()!=0){
//            return 0;
//        }
//        int[][] arr = new int[T.length()+1][S.length()+1];
//        arr[0][0] = 1;
//        for(int i=1; i<arr.length; i++){
//        	arr[i][0] = 0;
//        }
//        
//        for(int i=0; i<arr[0].length; i++){
//        	arr[0][i]= 1;
//        }
//        
//        for(int i=1; i<arr.length; i++){
//        	for(int j=1; j<arr[0].length; j++){
//        		if(T.charAt(i-1) != S.charAt(j-1)){
//        			arr[i][j] = arr[i][j-1];
//        		}else{
//        			arr[i][j] = arr[i-1][j-1] + arr[i][j-1];
//        		}
//        	}
//        }
//        return arr[T.length()][S.length()];
//    }
//}





//import java.util.Stack;
//
//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public void flatten(TreeNode root) {
//        if(root == null){
//        	return;
//        }
//        Stack<TreeNode> st = new Stack<TreeNode>();
//        st.push(root);
//        TreeNode pre = new TreeNode(-1);
//        while(!st.isEmpty()){
//        	TreeNode cur = st.pop();
//        	pre.right = cur;
//        	pre.left = null;
//        	pre = cur;
//        	if(cur.right != null){
//        		st.add(cur.right);
//        	}
//        	if(cur.left != null){
//        		st.add(cur.left);
//        	}
//        }
//        
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//
//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//    	List<Integer> tmp = new ArrayList<Integer>();
//    	if(root == null){
//    		return res;
//    	}
//    	tmp.add(root.val);
//    	build(root, sum, tmp, res);
//    	return res;
//    }
//    private void build(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res){
//    	if(root.left == null && root.right == null){
//    		if(sum == root.val){
//    			List<Integer> tmp2 = new ArrayList<Integer>();
//    			tmp2.addAll(tmp);
//    			res.add(tmp);	
//    		}
//    		return;
//    	}
//    	
//    	if(root.left != null){
//    		tmp.add(root.left.val);
//    		build(root.left,sum-root.val,tmp,res);
//    		tmp.remove(tmp.size()-1);
//    	}
//    	
//    	if(root.right != null){
//    		tmp.add(root.right.val);
//    		build(root.right,sum-root.val,tmp,res);
//    		tmp.remove(tmp.size()-1);
//    	}
//    }
//}





//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if(root == null){
//        	return false;
//        }
//        if(sum == root.val && (root.left == null) && (root.right == null)){
//        	return true;
//        }       
//        	return hasPathSum(root.left , sum - root.val) || hasPathSum(root.right, sum-root.val);
//    }
//}





//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public int minDepth(TreeNode root) {
//        if(root == null){
//        	return 0;
//        }
//        if(root.left == null){
//        	return minDepth(root.right)+1;
//        }
//        if(root.right == null){
//        	return minDepth(root.left)+1;
//        	
//        }
//        return Math.min(minDepth(root.right), minDepth(root.left))+1;
//    }
//}





//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public boolean isBalanced(TreeNode root) {
//        int res = getDepth(root);
//        if(res == -1){
//        	return false;
//        }else{
//        	return true;
//        }
//    }
//    public int getDepth(TreeNode root){
//    	if(root == null){
//    		return 0;
//    	}
//    	
//    	int left = getDepth(root.left);
//    	if(left == -1){
//    		return -1;
//    	}
//    	
//    	int right = getDepth(root.right);
//    	if(right == -1){
//    		return -1;
//    	}
//    	
//    	if(Math.abs(left - right) >= 2){
//    		return -1;
//    	}
//    	
//    	return Math.max(left, right)+1;
//    }
//}





//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public TreeNode sortedArrayToBST(int[] num) {
//        if(num == null || num.length == 0){
//        	return null;
//        }
//        
//        return build(num, 0, num.length-1);
//    }
//    private TreeNode build(int[] num, int left, int right){
//    	if(left > right){
//    		return null;
//    	}
//    	
//    	int mid = (left+right)/2;
//    	TreeNode cur = new TreeNode(num[mid]);
//    	TreeNode leftN = build(num, left, mid-1);
//    	TreeNode rightN = build(num, mid+1, right);
//    	cur.left = leftN;
//    	cur.right = rightN;
//    	return cur;
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//
//import leetcode.Utility.TreeNode;
//
//public class Solution {
//public List<List<Integer>> levelOrderBottom(TreeNode root) {
//	List<List<Integer>> res = new ArrayList<List<Integer>>();
//	List<Integer> tmp = new ArrayList<Integer>();
//	List<TreeNode> level = new ArrayList<TreeNode>();
//	if(root == null){
//		return res;
//	}
//	level.add(root);
//	List<TreeNode> level2 = new ArrayList<TreeNode>();
//	while(!level.isEmpty()){
//		TreeNode cur = level.remove(0);
//		tmp.add(cur.val);
//		if(cur.left != null){
//			level2.add(cur.left);
//		}
//		if(cur.right != null){
//			level2.add(cur.right);
//		}
//		if(level.isEmpty()){
//			res.add(0,tmp);
//			tmp = new ArrayList<Integer>();
//			level = level2;
//			level2 = new ArrayList<TreeNode>();
//		}
//	}
//	return res;
//}
//}





//import java.util.HashMap;
//
//import leetcode.Utility.TreeNode;
//
//public class Solution {
//	HashMap<Integer,Integer> table = new HashMap<Integer, Integer>();
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//      for(int i=0; i<inorder.length; i++){
//    	table.put(inorder[i], i);
//      }
//      return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
//    }
//    
//  private TreeNode build(int[] postorder, int pl, int pr, int[] inorder, int il, int ir){
//	if(pl > pr || il > ir){
//		return null;
//	}
//	
//	if(pl == pr || il == ir){
//		return new TreeNode(postorder[pr]);
//	}
//	
//	TreeNode cur = new TreeNode(postorder[pr]);
//	
//	int iin = table.get(postorder[pr]);
//	
//	TreeNode left = build(postorder, pl, pl+(iin - il-1), inorder, il, iin-1);
//	TreeNode right = build(postorder, pl+(iin - il), pr-1, inorder, iin+1, ir);
//	
//	cur.left = left;
//	cur.right = right;
//	return cur;
//}
//}





//import java.util.HashMap;
//
//import leetcode.Utility.TreeNode;
//
//public class Solution {
//	HashMap<Integer,Integer> table = new HashMap<Integer, Integer>();
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        
//        for(int i=0; i<inorder.length; i++){
//        	table.put(inorder[i], i);
//        }
//        
//        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
//    }
//    private TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
//    	if(pl > pr || il > ir){
//    		return null;
//    	}
//    	
//    	if(pl == pr || il == ir){
//    		return new TreeNode(preorder[pl]);
//    	}
//    	
//    	TreeNode cur = new TreeNode(preorder[pl]);
//    	
//    	int iin = table.get(preorder[pl]);
//    	
//    	TreeNode left = build(preorder, pl+1, pl+(iin - il), inorder, il, iin-1);
//    	TreeNode right = build(preorder, pl+(iin - il)+1, pr, inorder, iin+1, ir);
//    	
//    	cur.left = left;
//    	cur.right = right;
//    	return cur;
//    }
//}





//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public int maxDepth(TreeNode root) {
//        if(root == null){
//        	return 0;
//        }
//        
//        if(root.left == null){
//        	return maxDepth(root.right) + 1;
//        }else if(root.right == null){
//        	return maxDepth(root.left)+1;
//        }else{
//        	return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//        }
//    }
//}





//import java.util.ArrayList;
//import java.util.Stack;
//
//import leetcode.Utility.TreeNode;
//
//
//public class Solution {
//    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//        if (root == null) {
//            return result;
//        }
//        Stack<TreeNode> currLevel = new Stack<TreeNode>();
//        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
//        Stack<TreeNode> tmp;
//        
//        currLevel.push(root);
//        boolean normalOrder = true;
//
//        while (!currLevel.isEmpty()) {
//            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
//
//            while (!currLevel.isEmpty()) {
//                TreeNode node = currLevel.pop();
//                currLevelResult.add(node.val);
//
//                if (normalOrder) {
//                    if (node.left != null) {
//                        nextLevel.push(node.left);
//                    }
//                    if (node.right != null) {
//                        nextLevel.push(node.right);
//                    }
//                } else {
//                    if (node.right != null) {
//                        nextLevel.push(node.right);
//                    }
//                    if (node.left != null) {
//                        nextLevel.push(node.left);
//                    }
//                }
//            }
//
//            result.add(currLevelResult);
//            tmp = currLevel;
//            currLevel = nextLevel;
//            nextLevel = tmp;
//            normalOrder = !normalOrder;
//        }
//
//        return result;
//
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//
//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//    	List<Integer> tmp = new ArrayList<Integer>();
//    	List<TreeNode> level = new ArrayList<TreeNode>();
//    	if(root == null){
//    		res.add(tmp);
//    		return res;
//    	}
//    	level.add(root);
//    	List<TreeNode> level2 = new ArrayList<TreeNode>();
//    	while(!level.isEmpty()){
//    		TreeNode cur = level.remove(0);
//    		tmp.add(cur.val);
//    		if(cur.left != null){
//    			level2.add(cur.left);
//    		}
//    		if(cur.right != null){
//    			level2.add(cur.right);
//    		}
//    		if(level.isEmpty()){
//    			res.add(tmp);
//    			tmp = new ArrayList<Integer>();
//    			level = level2;
//    			level2 = new ArrayList<TreeNode>();
//    		}
//    	}
//    	return res;
//    }
//}





//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null){
//            return true;
//        }
//        
//        return isSameTree(root.left, root.right);
//    }
//    private boolean isSameTree(TreeNode root1, TreeNode root2){
//        if(root1 == null && root2 == null){
//            return true;
//        }else if(root1 == null){
//            return false;
//        }else if(root2 == null){
//            return false;
//        }else if(root1.val != root2.val){
//            return false;
//        }
//        return isSameTree(root1.left, root2.right) && isSameTree(root1.right, root2.left);
//    }
//}





//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p == null && q == null){
//        	return true;
//        }else if(p == null){
//        	return false;
//        }else if(q == null){
//        	return false;
//        }else{
//        	if(p.val != q.val){
//        		return false;
//        	}
//        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        }
//    }
//}






//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public boolean isValidBST(TreeNode root) {
//        if(root == null){
//        	return true;
//        }
//        Long min = (long)Integer.MIN_VALUE - 1;
//        Long max = (long)Integer.MAX_VALUE + 1;
//        return isValid(root, min, max);
//    }
//    private boolean isValid(TreeNode root, long min, long max){
//    	if(root.val >=max || root.val <= min){
//    		return false;
//    	}
//    	boolean res = true;
//    	if(root.left != null){
//    		res = isValid(root.left, min, root.val);
//    		if(!res){
//    			return res;
//    		}
//    	}
//    	
//    	if(root.right != null){
//    		res = isValid(root.right, root.val, max);
//    		if(!res){
//    			return res;
//    		}
//    	}
//    	
//    	return res;
//    }
//}





//public class Solution {
//    public boolean isInterleave(String s1, String s2, String s3) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        if (s1 == null || s2 == null || s3 == null) return false;
//        if (s1.length() + s2.length() != s3.length()) return false;
//        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
//        dp[0][0] = true;
//        for(int i = 0; i < s1.length() + 1; i++) {
//            for(int j = 0; j < s2.length() + 1; j++) {
//            	if(i == 0 && j == 0){
//            		dp[i][j] = true;
//            	}else if(i == 0){
//            		if (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1]) {
//                        dp[0][j] = true;
//                    }
//            	}else if(j == 0){
//            		if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) {
//                        dp[i][0] = true;
//                    }
//            	}else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {
//                    dp[i][j] = true;
//                }else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {
//                    dp[i][j] = true;
//                }
//            }
//        }
//        return dp[s1.length()][s2.length()];
//    }
//}





//public class Solution {
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s3.isEmpty()){
//        	return s1.isEmpty() && s2.isEmpty();
//        }
//        if(s1.isEmpty() && s2.isEmpty()){
//        	return s3.isEmpty();
//        }
//        boolean compare1 = false;
//        if(!s1.isEmpty()){
//        	if(s3.charAt(0) == s1.charAt(0) ){
//            	compare1 = isInterleave(s1.substring(1),s2,s3.substring(1));
//            }
//        }
//        
//        boolean compare2 = false;
//        if(!s2.isEmpty()){
//        	if(s3.charAt(0) == s2.charAt(0) ){
//            	compare2 = isInterleave(s1,s2.substring(1),s3.substring(1));
//            }
//        }
//        
//        
//        return compare1 || compare2;
//    }
//}





//import java.util.ArrayList;
//
//import leetcode.Utility.TreeNode;
//
//public class Solution {
//    public ArrayList<TreeNode> generateTrees(int n) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        return generateTrees(1, n);
//    }
// 
//    private ArrayList<TreeNode> generateTrees(int begin, int end){
//        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
//        if(begin > end) result.add(null);
//        else{
//            for(int i = begin; i <= end; i++){
//                ArrayList<TreeNode> left = generateTrees(begin, i - 1);
//                ArrayList<TreeNode> right = generateTrees(i + 1, end);
//                for(int j = 0; j < left.size(); j++){
//                    for(int k = 0; k < right.size(); k++){
//                        TreeNode node = new TreeNode(i);
//                        node.left = left.get(j);
//                        node.right = right.get(k);
//                        result.add(node);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//}





//public class Solution {
//    public int numTrees(int n) {
//    	if(n <= 1){
//    		return n;
//    	}
//        int[] table = new int[n+1];
//        table[0] = 1;
//        table[1] = 1;
//        for(int i=2; i<=n; i++){
//        	int sum = 0;
//        	for(int j=0; j<i; j++){
//        		sum += table[i-j-1]*table[j];
//        	}
//        	table[i] = sum;
//        }
//        
//        return table[n];
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//import leetcode.Utility.TreeNode;
//
//
//public class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//    	List<Integer> res = new ArrayList<Integer>();
//        if(root == null){
//        	return res;
//        }
//        Stack<TreeNode> table = new Stack<TreeNode>();
//        
//        while(root != null){
//        	table.push(root);
//        	root = root.left;
//        }
//        
//        while(!table.isEmpty()){
//        	TreeNode cur = table.pop();
//        	res.add(cur.val);
//        	cur = cur.right;
//        	while(cur != null){
//        		table.push(cur);
//        		cur = cur.left;
//        	}
//        }
//        return res;
//    }
//}





//import leetcode.Utility.ListNode;
//
//public class Solution {
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//    	ListNode pre = new ListNode(-1);
//    	pre.next = head;
//    	ListNode res = pre;
//    	
//    	ListNode p1 = pre;
//    	while(m > 1){
//    		p1 = p1.next;
//    		m--;
//    	}
//    	ListNode p2 = pre;
//    	while(n > 1){
//    		p2 = p2.next;
//    		n--;
//    	}
//    	p2 = p2.next;
//    	ListNode cur = p1.next;
//    	ListNode post = cur.next;
//    	while(cur != p2){
//    		ListNode next = post.next;
//    		post.next = cur;
//    		cur = post;
//    		post = next;
//    	}
//    	
//    	ListNode tmp = p1.next;
//    	tmp.next = post;
//    	p1.next = cur;
//    	
//    	return res.next;
//    }
//}





//public class Solution {
//    public int numDecodings(String s) {
//    	if (s.length() == 0) return 0;
//		int[] c = new int[s.length() + 1];
//		c[0] = 1;
//		if (s.charAt(0) != '0')
//			c[1] = c[0];
//		else
//			c[1] = 0;
//		for (int i = 2; i <= s.length(); i++) {
//			if (s.charAt(i - 1) == '0') {
//				c[i] = 0;
//			} else {
//				c[i] = c[i - 1];
//			}
//			if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
//				c[i] += c[i - 2];
//			}
//		}
//		return c[s.length()];
//	}
//}





//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//
//public class Solution {
//	HashSet<List<Integer>> table = new HashSet<List<Integer>>();
//    public List<List<Integer>> subsetsWithDup(int[] num) {
//        Arrays.sort(num);
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//    	List<Integer> tmp = new ArrayList<Integer>();
//    	if(num.length == 0){
//    		res.add(tmp);
//    		return res;
//    	}
//    	
//    	get(num, 0, tmp, res);
//    	return res;
//    }
//    private void get(int[] num, int index, List<Integer> tmp,List<List<Integer>> res ){
//    	if(index == num.length){
//    		
//    		if(!table.contains(tmp)){
//    			List<Integer> tmp2 = new ArrayList<Integer>();
//        		tmp2.addAll(tmp);
//        		res.add(tmp2);
//        		table.add(tmp2);
//        		return;
//    		}
//    		
//    	}
//    	
//    	for(int i= index; i<num.length; i++){
//    		tmp.add(num[i]);
//    		get(num,i+1,tmp,res);
//    		tmp.remove(tmp.size()-1);
//    		get(num,i+1,tmp,res);
//    	}
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//    public List<Integer> grayCode(int n) {
//    	List<Integer> res = new ArrayList<Integer>();
//        if(n == 0){
//        	res.add(0);
//        	return res;
//        }
//        
//        List<Integer> tmp = grayCode(n-1);
//        
//        for(int i=0; i<tmp.size(); i++){
//        	int cur = tmp.get(i);
//        	if(i%2 == 0){
//        		res.add(cur*2);
//        		res.add(cur*2+1);
//        	}else{
//        		res.add(cur*2+1);
//        		res.add(cur*2);
//        	}
//        }
//        return res;
//    }
//}




//public class Solution {
//    public void merge(int A[], int m, int B[], int n) {
//        int len = m+n-1;
//        for(;n>0;len--){
//        	if(m == 0){
//        		A[len] = B[n-1];
//        		n--;
//        	}else{
//        		if(A[m-1] > B[n-1]){
//        			A[len] = A[m-1];
//        			m--;
//        		}else{
//        			A[len] = B[n-1];
//        			n--;
//        		}
//        	}
//        }
//    }
//}






//import leetcode.Utility.ListNode;
//
//public class Solution {
//    public ListNode partition(ListNode head, int x) {
//    	ListNode pre1 = new ListNode(-1);
//    	ListNode h1 = pre1;
//    	ListNode pre2 = new ListNode(-1);
//    	ListNode h2 = pre2;
//    	
//    	while(head != null){
//    		if(head.val < x){
//    			pre1.next = head;
//    			pre1 = head;
//    			head = head.next;
//    			pre1.next = null;
//    		}else{
//    			pre2.next = head;
//    			pre2 = head;
//    			head = head.next;
//    			pre2.next = null;
//    		}
//    	}
//    	if(h2.next == null){
//    		return h1.next;
//    	}
//    	pre1.next = h2.next;
//    	return h1.next;
//    }
//}





//public class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//      if(head == null || head.next == null){
//    	return head;
//      }
//      
//      ListNode pre = new ListNode(-1);
//      pre.next = head;
//      ListNode res = pre;
//      boolean isDup = false;
//      
//      while(head.next != null){
//    	  ListNode next = head.next;
//    	  if(next.val == head.val){
//    		  pre.next = null;
//    		  head.next = next.next;
//    		  isDup = true;
//    		  continue;
//    	  }else{
//    		  if(!isDup){
//    			  pre = head;
//    			  head = next;
//    		  }else{
//    			  pre.next = next;
//    			  head = next;
//    		  }
//    		  isDup = false;
//    	  }
//      }
//      return res;
//    }
//}







//public class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null){
//        	return head;
//        }
//        
//        ListNode cur = head;
//        while(cur.next != null){
//        	ListNode next = cur.next;
//        	if(next.val != cur.val){
//        		cur = next;
//        	}else{
//        		cur.next = next.next;
//        	}
//        }
//        return head;
//    }
//}





//public class Solution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int i = matrix.length-1;
//        int j = 0;
//        while(i >= 0 && j < matrix[0].length){
//        	if(matrix[i][j] == target){
//        		return true;
//        	}else if(matrix[i][j] > target){
//        		i--;
//        	}else{
//        		j++;
//        	}
//        }
//        return false;
//    }
//}





//public class Solution {
//    public void setZeroes(int[][] matrix) {
//        if(matrix.length == 0 || matrix[0].length == 0){
//        	return;
//        }
//        
//        int[] is = new int[matrix.length];
//        int[] js = new int[matrix[0].length];
//        
//        for(int i=0; i<matrix.length; i++){
//        	for(int j=0; j<matrix[0].length; j++){
//        		if(matrix[i][j] == 0){
//        			is[i] = 1;
//        			js[j] = 1;
//        		}
//        		
//        	}
//        }
//        
//        for(int i=0; i<matrix.length; i++){
//        	for(int j=0; j<matrix[0].length; j++){
//        		if(is[i] == 1 || js[j] == 1){
//        			matrix[i][j] = 0;
//        		}
//        		
//        	}
//        }
//    }
//}





//public class Solution {
//    public int minDistance(String word1, String word2) {
//        if(word1.length() == 0){
//        	return word2.length();
//        }else if(word2.length() == 0){
//        	return word1.length();
//        }
//        
//        int[][] arr = new int[word1.length()+1][word2.length()+1];
//        
//        for(int i=0; i<=word1.length(); i++){
//        	for(int j=0; j<=word2.length(); j++){
//        		if(i == 0 && j == 0){
//        			arr[i][j] = 0;
//        		}else if( i == 0){
//        			arr[i][j] = arr[i][j-1]+1;
//        		}else if( j == 0){
//        			arr[i][j] = arr[i-1][j]+1;
//        		}else if(word1.charAt(i-1) == word2.charAt(j-1)){
//        			arr[i][j] = arr[i-1][j-1];
//        		}else{
//        			arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1])) + 1;
//        		}
//        	}
//        }
//        return arr[word1.length()][word2.length()];
//    }
//}





//public class Solution {
//    public int climbStairs(int n) {
//        if(n <=2){
//        	return n;
//        }
//    	int a = 1;
//    	int b = 2;
//    	while( n > 2){
//    		int c = a+b;
//    		a = b;
//    		b = c;
//    		n--;
//    	}
//    	return b;
//    }
//}





//public class Solution {
//    public int sqrt(int x) {
//        if(x <= 0){
//        	return -1;
//        }
//        if(x == 1){
//        	return x;
//        }
//        
//        long left = 1;
//        long right = x;
//        while(left <= right){
//        	long mid = (left+right)/2;
//        	if(mid*mid <= x && (mid+1)*(mid+1) > x){
//        		return (int)mid;
//        	}else if(mid*mid > x){
//        		right = mid-1;
//        	}else{
//        		left = mid+1;
//        	}
//        }
//        return -1;
//    }
//}





//public class Solution {
//    public String addBinary(String a, String b) {
//        if(a.isEmpty()){
//        	return b;
//        }else if(b.isEmpty()){
//        	return a;
//        }
//        
//        int lena = a.length()-1;
//        int lenb = b.length()-1;
//        int carry = 0;
//        String res = "";
//        for(;lena>=0 || lenb >=0; lena--, lenb--){
//        	int aa = 0;
//        	if(lena >= 0){
//        		aa = a.charAt(lena)-'0';
//        	}
//        	int ba = 0;
//        	if(lenb >= 0){
//        		ba = b.charAt(lenb)-'0';
//        		
//        	}
//        	int sum = aa + ba +carry;
//        	res= sum%2 + res;
//        	carry = sum/2;
//        }
//        if(carry != 0){
//        	res = carry + res;
//        }
//        return res;
//    }
//}





//public class Solution {
//    public int[] plusOne(int[] digits) {
//        if(digits == null || digits.length == 0){
//        	return digits;
//        }
//        int carry = 1;
//        for(int i=digits.length-1; i>=0; i--){
//        	int sum = digits[i]+carry;
//        	carry = sum / 10;
//        	digits[i] = sum%10;
//        	if(carry == 0){
//        		return digits;
//        	}
//        }
//        
//        int[] res = new int[digits.length+1];
//        for(int i=0; i<res.length; i++){
//        	if(i == 0){
//        		res[i] = 1;
//        	}else{
//        		res[i] = digits[i-1];
//        	}
//        }
//        return res;
//    }
//}





//public class Solution {
//    public boolean isNumber(String s) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int len = s.length();
//        int i = 0, e = len - 1;
//        while (i <= e && Character.isWhitespace(s.charAt(i))) i++;
//        if (i > len - 1) return false;
//        while (e >= i && Character.isWhitespace(s.charAt(e))) e--;
//        // skip leading +/-
//        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
//        boolean num = false; // is a digit
//        boolean dot = false; // is a '.'
//        boolean exp = false; // is a 'e'
//        while (i <= e) {
//            char c = s.charAt(i);
//            if (Character.isDigit(c)) {
//                num = true;
//            }
//            else if (c == '.') {
//                if(exp || dot) return false;
//                dot = true;
//            }
//            else if (c == 'e') {
//                if(exp || num == false) return false;
//                exp = true;
//                num = false;
//            }
//            else if (c == '+' || c == '-') {
//                if (s.charAt(i - 1) != 'e') return false;
//            }
//            else {
//                return false;
//            }
//            i++;
//        }
//        return num;
//    }
//}





//public class Solution {
//    public int minCut(String s) {
//        
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//    public List<List<String>> partition(String s) {
//    	List<List<String>> list = new ArrayList<List<String>>();
//    	List<String> li = new ArrayList<String>();
//        if(s == null || s.isEmpty()){
//        	li.add("");
//        	list.add(li);
//        	return list;
//        }
//        
//        split(s, list, li);
//        return list;
//        
//        
//    }
//    
//    private void split(String s, List<List<String>> list, List<String> li ){
//    	if(s.isEmpty()){
//    		 List<String> li2 = new ArrayList<String>();
//    		 li2.addAll(li);
//    		list.add(li2);
//    	}
//    	
//    	for(int i=1; i<=s.length(); i++){
//    		String cur = s.substring(0,i);
//    		if(isPal(cur)){
//    			li.add(cur);
//    			split(s.substring(i),list,li);
//    			li.remove(li.size()-1);
//    		}
//    	}
//    }
//    
//    private boolean isPal(String cur){
//    	if(cur.length()<=1){
//    		return true;
//    	}
//    	int left = 0;
//    	int right = cur.length()-1;
//    	while(left < right){
//    		if(cur.charAt(left) != cur.charAt(right)){
//    			return false;
//    		}
//    		left ++;
//    		right --;
//    	}
//    	return true;
//    }
//}





//import leetcode.Utility.ListNode;
//
//public class Solution {
//    public ListNode detectCycle(ListNode head) {
//        if(head == null || head.next == null){
//        	return null;
//        }
//        
//        ListNode h1 = head;
//        ListNode h2 = head;
//        
//        while(h2 != null && h2.next != null){
//        	h1 = h1.next;
//        	h2 = h2.next.next;
//        	if(h1 == h2){
//        		break;
//        	}
//        }
//        if(h2 == null || h2.next == null) {
//        	return null;
//        }
//        
//        h1 = head;
//        while(h1 != h2){
//        	h1 = h1.next;
//        	h2 = h2.next;
//        }
//        return h1;
//    }
//}





//import leetcode.Utility.ListNode;
//
//public class Solution {
//    public boolean hasCycle(ListNode head) {
//        if(head == null || head.next == null){
//        	return false;
//        }
//        
//        ListNode h1 = head;
//        ListNode h2 = head;
//        while(h2 != null && h2.next != null){
//        	h1 = h1.next;
//        	h2 = h2.next.next;
//        	if(h1 == h2){
//        		return true;
//        	}
//        }
//        return false;
//    }
//}





//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Set;
//
//public class Solution {
//    public List<String> wordBreak(String s, Set<String> dict) {
//    	List<String> res = new ArrayList<String>();
//    	if(s == null || s.isEmpty()){
//    		return res;
//    	}
//    	
//    	HashMap<String, List<String>> table = new HashMap<String, List<String>>();
//    	
//    	return getWord(s,dict,table);   	
//    }
//    
//    private List<String> getWord(String s, Set<String> dict, HashMap<String, List<String>> table){
//    	List<String> res = new ArrayList<String>();
//    	if(table.containsKey(s)){
//    		return table.get(s);
//    	}
//    	
//    	if(s.isEmpty()){
//    		return res;
//    	}
//    	
//    	if(dict.contains(s)){
//    		res.add(s);
//    	}
//    	
//    	for(int i=1; i<=s.length(); i++){
//    		String tmp = s.substring(0,i);
//    		if(dict.contains(tmp)){
//    			List<String> next = getWord(s.substring(i),dict,table);
//    			if(!next.isEmpty()){
//    				for(String ss : next){
//    					res.add(tmp+" "+ss);
//    				}
//    			}
//    		}
//    	}
//    	table.put(s, res);
//    	return res;
//    }
//}






//import java.util.HashMap;
//import java.util.Set;
//
//public class Solution {
//    public boolean wordBreak(String s, Set<String> dict) {
//        if(s == null || s.length() == 0){
//        	return true;
//        }
//        HashMap<String, Boolean> table = new HashMap<String, Boolean>();
//        return isWord(s,table, dict);
//    }
//    private boolean isWord(String s, HashMap<String, Boolean> table, Set<String> dict){
//    	if(table.containsKey(s)){
//    		return table.get(s);
//    	}
//    	
//    	if(s.isEmpty() || dict.contains(s)){
//    		return true;
//    	}
//    	
//    	for(int i=1; i<=s.length(); i++){
//    		if(dict.contains(s.substring(0,i))){
//    			if(isWord(s.substring(i),table,dict)){
//    				table.put(s, true);
//    				return true;
//    			}
//    		}
//    	}
//    	table.put(s,false);
//    	return false;
//    }
//}





//import leetcode.Utility.RandomListNode;
//
//public class Solution {
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if(head == null){
//        	return null;
//        }
//        RandomListNode cur = head;
//       while(cur != null ){
//    	   RandomListNode next = cur.next;
//    	   RandomListNode tmp = new RandomListNode(cur.label);
//    	   cur.next = tmp;
//    	   tmp.next = next;
//    	   cur = next;
//       }
//       
//       cur = head;
//       while(cur != null){
//    	   RandomListNode ran = cur.random;
//    	   if(ran != null){
//    	      cur.next.random = cur.random.next;
//    	   
//    	   }
//    	   cur = cur.next.next; 
//       }
//       
//       cur = head;
//       RandomListNode res = new RandomListNode(-1);
//       res.next = cur.next;
//       while(cur != null){
//    	   RandomListNode next = cur.next.next;
//    	   RandomListNode copy = cur.next;
//    	   cur.next = next;
//    	   if(next == null){
//    		   copy.next = null;
//    		   break;
//    	   }else{
//    		   copy.next = next.next;
//    	   }
//    	   cur = next;
//       }
//       
//       return res.next;
//       
//        
//    }
//}





//public class Solution {
//    public int singleNumber(int[] A) {
//      if(A == null || A.length == 0){
//    	return 0;
//    }
//      int one = 0, two = 0, three = 0;
//      for(int i=0; i<A.length; i++){
//    	  two |= one & A[i];
//    	  one ^= A[i];
//    	  three = two & one;
//    	  
//    	  one &= ~three;
//    	  two &= ~three;
//      }
//      return one;
//    }
//}





//public class Solution {
//    public int singleNumber(int[] A) {
//        if(A == null || A.length == 0){
//        	return 0;
//        }
//        int res = A[0];
//        
//        for(int i=1; i<A.length; i++){
//        	res = res ^ A[i];
//        }
//        
//        return res;
//    }
//}





//public class Solution {
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        if(gas.length == 0 || cost.length == 0){
//        	return 0;
//        }
//        if(gas.length == 1){
//        	return (gas[0]-cost[0]) < 0 ? -1 : 0;
//        }
//    	int start = 0;
//    	int end = 1;
//    	int left = gas[0]-cost[0];
//    	while(start != end){
//    		if(left < 0){
//    			start --;
//    			if(start == -1){
//    				start = gas.length-1;
//    			}
//    			left = left + gas[start] - cost[start];
//    		}else{
//    			left = left + gas[end] - cost[end];
//    			end ++;
//    			if(end == gas.length){
//    				end = 0;
//    			}
//    			
//    		}
//    	}
//    	if(left < 0){
//    		return -1;
//    	}
//    	return start;
//        
//    }
//}





//public class Solution {
//    public int candy(int[] ratings) {
//        if(ratings == null || ratings.length == 0){
//        	return 0;
//        }
//        
//        int[] left = new int[ratings.length];
//        int[] right = new int[ratings.length];
//        left[0] = 1;
//        for(int i=1; i<ratings.length; i++){
//        	if(ratings[i] > ratings[i-1]){
//        		left[i] = left[i-1]+1;
//        	}else{
//        		left[i] = 1;
//        	}
//        }
//        
//        right[ratings.length-1] = 1;
//        for(int i= ratings.length-2; i>=0; i--){
//        	if(ratings[i] > ratings[i+1]){
//        		right[i] = right[i+1]+1;
//        	}else{
//        		right[i] = 1;
//        	}
//        }
//        int res = 0;
//        for(int i=0; i<ratings.length; i++){
//        	res+= Math.max(left[i], right[i]);
//        }
//        return res;
//    }
//}





//import java.util.LinkedList;
//
//public class Solution {
//    
//    public void solve(char[][] board) {
//        if (board==null || board.length<1)
//            return;
//        boolean[][] visit = new boolean[board.length][board[0].length];
//        for (int i=0; i<board.length; i++)
//            for (int j=0; j<board[i].length; j++)
//                if (board[i][j]=='O' && !visit[i][j] && (i==0||j==0||i==board.length-1||j==board[i].length-1)) {
//                	LinkedList<Point> queue = new LinkedList<Point>();
//                    queue.add(new Point(i, j));
//                    visit[i][j] = true;
//                    while (!queue.isEmpty()) {
//                        Point point = queue.poll();
//                        if (point.j>0 && board[point.i][point.j-1]=='O' && !visit[point.i][point.j-1]) {
//                            queue.add(new Point(point.i, point.j-1));
//                           visit[point.i][point.j-1] = true; //add code here
//                        }
//                        if (point.j<board[point.i].length-1 && board[point.i][point.j+1]=='O' && !visit[point.i][point.j+1]) {
//                            queue.add(new Point(point.i, point.j+1));
//                           visit[point.i][point.j+1] = true;//add code here
//                        }
//                        if (point.i>0 && board[point.i-1][point.j]=='O' && !visit[point.i-1][point.j]) {
//                            queue.add(new Point(point.i-1, point.j));
//                            visit[point.i-1][point.j] = true;//add code here
//                        }
//                        if (point.i<board.length-1 && board[point.i+1][point.j]=='O' && !visit[point.i+1][point.j]) {
//                            queue.add(new Point(point.i+1, point.j));
//                           visit[point.i+1][point.j] = true;//add code here
//                        }
//                    }
//                }
//        for (int i=0; i<board.length; i++)
//            for (int j=0; j<board[i].length; j++)
//                if (visit[i][j])
//                    board[i][j] = 'O';
//                else
//                    board[i][j] = 'X';
//    }
//    class Point {
//        public int i;
//        public int j;
//        public Point(int ii, int jj) {
//            this.i = ii;
//            this.j = jj;
//        }
//    }
//}






//public class Solution{
//	public int maximalRec(char[][] matrix) {
//        if (matrix.length == 0 || matrix[0].length == 0) {
//                return 0;
//        }
//        int m = matrix.length, n = matrix[0].length;
//        int[][] l = new int[m][n + 2];
//        int[][] r = new int[m][n + 2];
//        for (int i = 0; i < m; i++) {
//                for (int j = 1; j <= n; j++) {
//                        if (matrix[i][j - 1] == '1') {
//                                l[i][j] = l[i][j - 1] + 1;
//                        }
//                }
//        }
//        for (int i = 0; i < m; i++) {
//                for (int j = n; j >= 1; j--) {
//                        if (matrix[i][j - 1] == '1') {
//                                r[i][j] = r[i][j + 1] + 1;
//                        }
//                }
//        }
//        int result = 0;
//        for (int j = 0; j < n; j++) {
//                int leftMost = n, rightMost = n;
//                int count = 0;
//                for (int i = 0; i < m; i++) {
//                        if (matrix[i][j] == '0') {
//                                count = 0;
//                                leftMost = n;
//                                rightMost = n;
//                        } else {
//                                count++;
//                                leftMost = Math.min(leftMost, l[i][j + 1]);
//                                rightMost = Math.min(rightMost, r[i][j + 1]);
//                                int temp = (leftMost + rightMost - 1) * count;
//                                result = Math.max(result, temp);
//                        }
//                }
//        }
//        return result;
//}
//}





// World ladder 2
//public class Solution {
//    public List<List<String>> findLadders(String start, String end, Set<
//String> dict) {
//        List<List<String>> result = new ArrayList<List<String>>();
//        if (start == null || end == null || start.length() != end.length() |
//| dict.size() == 0) {
//            return result;
//        }
//        
//        HashMap<String, HashSet<String>> visited = new HashMap<String, 
//HashSet<String>>();
//        HashMap<String, Integer> level = new HashMap<String, Integer>();
//        Queue<String> queue = new LinkedList<String>();
//        HashSet<String> path = new HashSet<String>();
//        visited.put(start,path);
//        queue.offer(start);
//        level.put(start,1);
//        int min = Integer.MAX_VALUE;
//        dict.remove(start);
//        dict.add(end);
//        
//        while (!queue.isEmpty()) {
//            String str = queue.poll();
//            for (int i = 0; i < str.length(); i++) {
//                char original = str.charAt(i);
//                for (char c = 'a'; c <= 'z'; c++) {
//                    if (c != original) {
//                        String newStr = replace(str,i,c);
//                        if ((dict.contains(newStr) && !visited.containsKey(
//newStr))
//                        || (visited.containsKey(newStr) && level.get(newStr)
//> level.get(str))) {
//                            if (visited.containsKey(newStr)) {
//                                visited.get(newStr).add(str);
//                            }
//                            else {
//                                HashSet<String> path1 = new HashSet<String>(
//);
//                                visited.put(newStr,path1);
//                                path1.add(str);
//                                level.put(newStr,level.get(str) + 1);
//                                queue.offer(newStr);
//                            }
//                            
//                            if (newStr.equals(end)) {
//                                if (level.get(str) < min) {
//                                    ArrayList<String> entry = new ArrayList<
//String>();
//                                    entry.add(end);
//                                    result.addAll(back_trace(str,visited,
//entry));
//                                    min = level.get(str) + 1;
//                                }
//                            }
//                            
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
//    
//    private String replace (String s, int i , char c) {
//        char[] ch = s.toCharArray();
//        ch[i] = c;
//        return new String(ch);
//    }
//    
//    private ArrayList<ArrayList<String>> back_trace(String s, HashMap<String
//, HashSet<String>> visited, ArrayList<String> path) {
//        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String
//>>();
//        ArrayList<String> entry = new ArrayList<String>(path);
//        entry.add(0,s);
//        if (visited.get(s).size() < 1) {
//            result.add(entry);
//            return result;
//        }
//        for (String ss: visited.get(s)) {
//            result.addAll(back_trace(ss,visited,entry));
//        }
//        return result;
//    }
//}





//import java.util.ArrayList;
//
//import javax.swing.tree.TreeNode;
//
//public class Solution {
//    public int sumNumbers(TreeNode root) {
//        if(root == null){
//        	return 0;
//        }
//        
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        cal(root, 0, res);
//        int sum = 0;
//        for(Integer tmp : res){
//        	sum += tmp;
//        }
//        return sum;
//    }
//    
//    private void cal(TreeNode root, int sum, ArrayList<Integer> res){
//    	if(root.left == null && root.right == null){
//    		res.add(sum*10+root.val);
//    	}
//    	
//    	if(root.left != null){
//    		cal(root.left,sum*10+root.val, res);
//    	}
//    	
//    	if(root.right != null){
//    		cal(root.right,sum*10+root.val, res);
//    	}
//    }
//}





//import java.util.HashSet;
//
//public class Solution {
//    public int longestConsecutive(int[] num) {
//        if(num == null || num.length == 0){
//        	return 0;
//        }
//        
//        HashSet<Integer> table = new HashSet<Integer>();
//        for(int i : num){
//        	table.add(i);
//        }
//        int max = 0;
//        for(int i : num){
//        	int left = get(num, table,i, true);
//            int right = get(num, table,i, false);
//            max = Math.max(max, left+right);
//        }
//        return max;
//        
//    }
//    private int get(int[] num, HashSet<Integer> table, int key, boolean left){
//    	int res = 0;
//    	if(left){
//    		while(table.contains(key)){
//    			table.remove(key);
//    			res++;
//    			key--;
//    		}
//    		return res;
//    	}else{
//    		while(table.contains(key+1)){
//    			table.remove(key+1);
//    			res++;
//    			key++;
//    		}
//    		return res;
//    	}
//    }
//}





//public class Solution {
//    public int maxPathSum(TreeNode root) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//       int[] res = maxPathSums(root);
//        return res[1];
//    }
//    
//    public int[] maxPathSums(TreeNode root){
//        int[] res = new int[2];
//        if(root==null){
//            res[0]=Integer.MIN_VALUE; // Must be min value since it will add root.val;
//            res[1]=Integer.MIN_VALUE;
//            return res;
//        }
//        int[] fromLeft = maxPathSums(root.left),
//              fromRight = maxPathSums(root.right);
//        
//        int temp1 = fromLeft[0]>0?(fromLeft[0]+root.val):root.val;
//        int temp2 = fromRight[0]>0?(fromRight[0]+root.val):root.val;
//        
//        res[0]=Math.max(temp1,temp2);
//        res[1]=Math.max(fromLeft[1],Math.max(fromRight[1], Math.max(temp1+temp2-root.val,res[0]))); //double root.val and if fromLeft or fromRightis negative will not be added.
//        
//        return res;
//    }
//}





//public class Solution {
//    public boolean isPalindrome(String s) {
//    	if(s == null || s.isEmpty()){
//    		return true;
//    	}
//        s = s.toLowerCase();
//        int left = 0;
//        int right = s.length()-1;
//        while(left < right){
//        	if(!((s.charAt(left)<='z'&&s.charAt(left)>='a')||(s.charAt(left)<='9'&&s.charAt(left)>='0'))){
//                left++;
//                continue;
//            }
//            if(!((s.charAt(right)<='z'&&s.charAt(right)>='a')||(s.charAt(right)<='9'&&s.charAt(right)>='0'))){
//                right--;
//                continue;
//            }
//        	if(s.charAt(left) != s.charAt(right)){
//        		return false;
//        	}
//        	left ++;
//        	right --;
//        }
//        return true;
//    }
//}





//public class Solution {
//    public int maxProfit(int[] prices) {
//    	if(prices == null || prices.length <2){
//    	return 0;
//    	}
//    	int[] arr1 = new int[prices.length];
//    	int min = prices[0];
//    	arr1[0] = 0;
//    	int profit = 0;
//    	for(int i=1; i<prices.length ; i++ ){
//    		if(prices[i] < min){
//    			min = prices[i];
//    			
//    		}else{
//    			profit = Math.max(profit,  prices[i] - min);
//    		}
//    		arr1[i] = profit;
//    	}
//    	int[] arr2 = new int[prices.length];
//    	int max = prices[prices.length-1];
//    	arr2[prices.length-1] = 0;
//    	profit = 0;
//    	for(int i=prices.length-2; i>=0; i--){
//    		if(prices[i] > max){
//    			max = prices[i];
//    		}else{
//    			profit = Math.max(profit, max - prices[i]);
//    		}
//    		arr2[i] = profit;
//    	}
//    	
//    	int res = 0;
//    	for(int i=0; i< prices.length; i++){
//    		res = Math.max(arr1[i] + arr2[i], res);
//    	}
//    	return res;
//    }
//}





//public class Solution {
//    public int maxProfit(int[] prices) {
//    	if(prices == null || prices.length <2){
//        	return 0;
//        }
//    	int maxp = 0;
//    	for(int i=1; i<prices.length; i++){
//    		if(prices[i] > prices[i-1]){
//    			maxp+=prices[i]-prices[i-1];
//    		}
//    	}
//    	return maxp;
//    }
//}





//public class Solution {
//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length <2){
//        	return 0;
//        }
//        
//        int min = prices[0];
//        int maxp = 0;
//        for(int i=1; i<prices.length; i++){
//        	if(prices[i] < min){
//        		min = prices[i];
//        	}else{
//        		int ded = prices[i] - min;
//        		if(ded > maxp){
//        			maxp = ded;
//        		}
//        	}
//        }
//        return maxp;
//        
//        
//    }
//}





//public class Solution {
//    public void sortColors(int[] A) {
//        if(A == null || A.length == 0){
//        	return;
//        }
//        
//        int cur = 0;
//        int left = 0;
//        int right = A.length-1;
//        
//        while(cur <= right){
//        	if(A[cur] == 2){
//        		A[cur] = A[right];
//        		A[right] = 2;
//        		right--;
//        	}else if(A[cur] == 1){
//        		cur ++;
//        	}else{
//        		A[cur] = A[left];
//        		A[left] = 0;
//        		left++;
//        		cur++;
//        	}
//        }
//        		
//    }
//}






//import leetcode.Utility.ListNode;
//
//public class Solution {
//  public ListNode reverseKGroup(ListNode head, int k) {
//	  if(head == null || head.next == null || k == 1){
//      	return head;
//      }
//      
//     int size = 0;
//     ListNode cur = head;
//     while(cur != null){
//  	   cur = cur.next;
//  	   size ++;
//     }
//     
//     int loop = size / k;
//     cur = head;
//     ListNode res = new ListNode(-1);
//     res.next = head;
//     ListNode pre = res;
//    
//     
//     for(int i=0; i<loop; i++){
//  	   int j = 0;
//  	   ListNode post = cur.next;
//  	   if(i % 2 == 0){
//  		 while(post != null){
//    		   ListNode next = post.next;
//    		   post.next = cur;
//    		   cur = post;
//    		   post = next;
//    		   j++;
//    		   if(j == k-1){
//    			   ListNode tmp = pre.next;
//    			   pre.next = cur;
//    			   tmp.next = post;
//    			   pre = tmp;
//    			   cur = pre.next;
//    			   break;
//    		   }
//    	   }
//  	   }else{
//  		   while(post != null){
//  			   cur = cur.next;
//  			   post = post.next;
//  			   pre = pre.next;
//  			   j++;
//  			   if(j == k){
//  				   break;
//  			   }
//  		   }
//  	   }
//     }
//     
//     return res.next;
//  }
//  
//} 





//public class Solution {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(head == null || head.next == null || k == 1){
//        	return head;
//        }
//        
//       int size = 0;
//       ListNode cur = head;
//       while(cur != null){
//    	   cur = cur.next;
//    	   size ++;
//       }
//       
//       int loop = size / k;
//       cur = head;
//       ListNode res = new ListNode(-1);
//       res.next = head;
//       ListNode pre = res;
//      
//       
//       for(int i=0; i<loop; i++){
//    	   int j = 0;
//    	   ListNode post = cur.next;
//    	   while(post != null){
//    		   ListNode next = post.next;
//    		   post.next = cur;
//    		   cur = post;
//    		   post = next;
//    		   j++;
//    		   if(j == k-1){
//    			   ListNode tmp = pre.next;
//    			   pre.next = cur;
//    			   tmp.next = post;
//    			   pre = tmp;
//    			   cur = pre.next;
//    			   break;
//    		   }
//    	   }
//       }
//       
//       return res.next;
//        
//    }
//}





//public class Solution {
//    public boolean canJump(int[] A) {
//        if(A == null || A.length == 0){
//        	throw new IllegalArgumentException("wrong input");
//        }
//        
//        int cur = A[0];
//        for(int i=1; i< A.length; i++){
//        	if(cur == 0){
//        		return false;
//        	}
//        	cur--;
//        	cur = Math.max(cur, A[i]);
//        }
//        return true;
//    }
//}





//public class Solution {
//    public double pow(double x, int n) {
//        if(n == 0){
//        	return 1;
//        }
//        if(n == 1){
//            return x;
//        }
//        
//        if(n < 0){
//        	x = 1/x;
//        	n = -n;
//        }
//        
//        double m = x;
//        
//        	m = pow(x*x, n/2);
//        	if(n%2 != 0){
//        		m = m*x;
//        	}
//        return m;	
//    }
//}





//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.LinkedList;
//
//
//public class Solution {
//    public  String sortChars(String s) {
//        char[] content = s.toCharArray();
//        Arrays.sort(content);
//        return new String(content);
//    }   
//
//    public ArrayList<String> anagrams(String[] strs) {
//        ArrayList<String> res = new ArrayList<String>();
//        HashMap<String, LinkedList<String>> hash = new HashMap<String, LinkedList<String>>();
//     
//        /* Group words by anagram */
//        for (String s : strs) {
//            String key = sortChars(s); 
//            if (!hash.containsKey(key)) {
//                hash.put(key, new LinkedList<String>());
//            }   
//            LinkedList<String> anagrams = hash.get(key);
//            anagrams.push(s);
//        } 
//        for (String key : hash.keySet()) {
//            LinkedList<String> list = hash.get(key);
//            if (list.size() > 1) {
//// should be bigger than 1.  1 means no anagrams
//                for (String t : list) {
//                    res.add(t);
//                }   
//            }
//        }   
//        return res;
//    }
//}




//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//public class Solution {
//	private HashSet<List<Integer>> table = new HashSet<List<Integer>>();
//    public List<List<Integer>> permuteUnique(int[] num) {
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//        if(num == null || num.length == 0){
//        	return res;
//        }
//        
//        return insert(num,0);
//    }
//    private List<List<Integer>> insert(int[] num, int index){
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//    	if(index == num.length){
//    		List<Integer> tmp = new ArrayList<Integer>();
//    		res.add(tmp);
//    		return res;
//    	}
//    	
//    	res = insert(num, index+1);
//    	List<List<Integer>> res2 = new ArrayList<List<Integer>>();
//    	for(List<Integer> cur : res){
//    		for(int i=0; i<=cur.size(); i++){
//    			List<Integer> tmp = new ArrayList<Integer>();
//    			tmp.addAll(cur);
//    			tmp.add(i, num[index]);
//    			if(!table.contains(tmp)){
//    				table.add(tmp);
//    				res2.add(tmp);
//    			}
//    		}
//    	}
//    	return res2;
//    }
//}





//public class Solution {
//    public int jump(int[] A) {
//        if(A == null || A.length <=1){
//        	return 0;
//        }
//        int cur = A[0];
//        int step = 1;
//        int next = cur;
//        for(int i=1; i<A.length; i++){
//        	cur --;
//        	next --;
//        	next = Math.max(next, A[i]);
//        	if(cur == 0 && i<A.length-1){
//        		cur = next;
//        		step++;
//        	}
//        }
//        return step;
//    }
//}





//public class Solution {
//    public int firstMissingPositive(int[] A) {
//    	if(A == null || A.length == 0){
//    		return 1;
//    	}
//    	int n = A.length;
//    	for (int i = 0; i < n; )
//		{
//			if (0<A[i]&& A[i]<n && A[i] != i && A[A[i]] != A[i]) {
//				int tmp = A[i];
//				int ind = 
//				A[i] = A[A[i]];
//				A[tmp] = tmp;
//			}else{
//			   i++;  
//			}
//				
//			
//		}
//		for (int i = 1; i < n; i++){
//		    if (A[i] != i) return i;
//		} 
//			
//
//		return A[0] == n? n+1:n;
//    }
//    
//}




//public class Solution {
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//    	List<Integer> tmp = new ArrayList<Integer>();
//    	if(candidates == null || candidates.length == 0 ){
//    		res.add(tmp);
//    		return res;
//    	}
//    	Arrays.sort(candidates);
//    	com(candidates, target, 0, 0, res,tmp);
//    	return res;
//    }
//    
//    private void com(int[] candidates, int target, int sum, int index,List<List<Integer>> res, List<Integer> tmp  ){
//    	if(sum == target){
//    		List<Integer> ctmp = new ArrayList<Integer>();
//    		ctmp.addAll(tmp);
//    		res.add(ctmp);
//    	}
//    	if(sum > target){
//    		return;
//    	}
//    	
//    	for(int i = index; i<candidates.length; i++){
//    		int rest = sum + candidates[i];
//    		if(rest <= target ){
//    			tmp.add(candidates[i]);
//    			com(candidates, target, rest, i+1, res, tmp);
//    			tmp.remove(tmp.size()-1);
//    		}
//    	}
//    }
//}





//public class Solution {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        
//    	List<List<Integer>> res = new ArrayList<List<Integer>>();
//    	List<Integer> tmp = new ArrayList<Integer>();
//    	if(candidates == null || candidates.length == 0 ){
//    		res.add(tmp);
//    		return res;
//    	}
//    	Arrays.sort(candidates);
//    	com(candidates, target, 0, 0, res,tmp);
//    	return res;
//    }
//    
//    private void com(int[] candidates, int target, int sum, int index,List<List<Integer>> res, List<Integer> tmp  ){
//    	if(sum == target){
//    		List<Integer> ctmp = new ArrayList<Integer>();
//    		ctmp.addAll(tmp);
//    		res.add(ctmp);
//    	}
//    	if(sum > target){
//    		return;
//    	}
//    	
//    	for(int i = index; i<candidates.length; i++){
//    		int rest = sum + candidates[i];
//    		if(rest <= target ){
//    			tmp.add(candidates[i]);
//    			com(candidates, target, rest, i, res, tmp);
//    			tmp.remove(tmp.size()-1);
//    		}
//    	}
//    }
//}





//public class Solution {
//    public int minPathSum(int[][] grid) {
//        int[][] res = new int[grid.length][grid[0].length];
//        
//        for(int i=0; i<grid.length ; i++){
//        	for(int j=0; j<grid[0].length; j++){
//        		if(i == 0 && j == 0){
//        			res[i][j] = grid[i][j];
//        		}else if( i == 0){
//        			res[i][j] = grid[i][j] + res[i][j-1];
//        		}else if( j == 0){
//        			res[i][j] = grid[i][j] + res[i-1][j];
//        		}else{
//        			res[i][j] = grid[i][j] + Math.min(res[i-1][j], res[i][j-1]);
//        		}
//        	}
//        }
//        return res[grid.length-1][grid[0].length-1];
//    }
//}





//public class Solution {
//    public static void main(String[] args){
//    	H2O que = new H2O();
//    	
//    	ThreadGH r1 = new ThreadGH(que);
//    	ThreadGO r2 = new ThreadGO(que);
//    	ThreadGH r3 = new ThreadGH(que);
//    	
//    	Thread t1 = new Thread(r1);
//    	Thread t3 = new Thread(r3);
//    	Thread t2 = new Thread(r2);
//    	
//    	t1.start();
//    	t3.start();
//    	t2.start();
//    	
//    	
//    }
//}





//public class Solution {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int[][] table = new int[obstacleGrid.length][obstacleGrid[0].length];
//        
//        for(int i=0; i<obstacleGrid.length; i++ ){
//        	for(int j=0; j<obstacleGrid[0].length; j++){
//        		if(i == 0 && j == 0){
//        			if(obstacleGrid[i][j] == 1){
//        				table[i][j] = 0;
//        			}else{
//        				table[i][j] =1;
//        			}
//        		}else if( j == 0){
//        			if(obstacleGrid[i][j] == 1){
//        				table[i][j] = 0;
//        			}else{
//        				table[i][j] = table[i-1][j];
//        			}
//        		}else if( i == 0){
//        			if(obstacleGrid[i][j] == 1){
//        				table[i][j] = 0;
//        			}else{
//        				table[i][j] = table[i][j-1];
//        			}
//        		}else{
//        			if(obstacleGrid[i][j] == 1){
//        				table[i][j] = 0;
//        			}else{
//        				table[i][j] = table[i][j-1] + table[i-1][j];
//        			}
//        		}
//        	}
//        }
//        return table[obstacleGrid.length-1][obstacleGrid[0].length-1];
//    }
//}





//public class Solution {
//    public String countAndSay(int n) {
//        if(n <= 0){
//        	throw new IllegalArgumentException("wrong input");
//        }
//        
//        String res = "1";
//        while( n > 1){
//        	res = getNext(res);
//        	n--;
//        }
//        return res;
//    }
//    private String getNext(String res){
//    	String next = "";
//    	char cur = res.charAt(0);
//    	int count = 1;
//    	for(int i=1; i<res.length(); i++){
//    		if(res.charAt(i) == cur){
//    			count ++;
//    		}else{
//    			next = next+count+cur;
//    			cur = res.charAt(i);
//    			count = 1;
//    		}
//    	}
//    	next = next+count+cur;
//    	return next;
//    }
//}





//import java.util.HashSet;
//
//public class Solution {
//	public void solveSudoku(char[][] board) {
//		if(board==null || board.length == 0 || board[0].length == 0){
//          	throw new IllegalArgumentException("wrong input");
//          }
//		solveSudoku2(board);
//    }
//    public boolean solveSudoku2(char[][] board) {
//    	if(board==null || board.length == 0 || board[0].length == 0){
//          	throw new IllegalArgumentException("wrong input");
//          }
//    	boolean full = true;
//    	for(int i=0; i<board.length; i++){
//          	for(int j=0; j<board[0].length; j++){
//          		if(board[i][j] == '.'){
//          			full = false;
//          			for(char m = '1'; m<='9'; m++){
//          				board[i][j] = m;
//          				if(checkLine(board,i,j) && checkBox(board,i,j)){
//          					boolean res =solveSudoku2(board);
//          					if(res){
//          						return true;
//          					}
//          				}
//          				board[i][j] = '.';
//          			}
//          			return false;
//          		}
//          		
//          	}
//          	
//          }
//    	return full;
//    	
//    }
//    
//    
//  private boolean checkLine(char[][] board, int i, int j){
//  	HashSet<Character> table = new HashSet<Character>();
//  	for(int m=0; m<board.length; m++){
//  		if(board[m][j] != '.'){
//  			if(table.contains(board[m][j])){
//  				return false;
//  			}else{
//  				table.add(board[m][j]);
//  			}
//  		}
//  	}
//  	table = new HashSet<Character>();
//  	for(int m=0; m<board[0].length; m++){
//  		if(board[i][m] != '.'){
//  			if(table.contains(board[i][m])){
//  				return false;
//  			}else{
//  				table.add(board[i][m]);
//  			}
//  		}
//  	}
//  	return true;
//  }
//  
//  private boolean checkBox(char[][] board, int i, int j){
//  	HashSet<Character> table = new HashSet<Character>();
//  	i = (i/3)*3;
//  	j = (j/3)*3;
//  	
//  	for(int m=i; m<i+3; m++){
//  		for(int n=j; n<j+3; n++){
//  			if(board[m][n] != '.'){
//      			if(table.contains(board[m][n])){
//      				return false;
//      			}else{
//      				table.add(board[m][n]);
//      			}
//      		}
//  		}
//  	}
//  	return true;
//  }
//}





//import java.util.HashSet;
//
//public class Solution {
//    public boolean isValidSudoku(char[][] board) {
//        if(board==null || board.length == 0 || board[0].length == 0){
//        	throw new IllegalArgumentException("wrong input");
//        }
//        
//        for(int i=0; i<board.length; i++){
//        	for(int j=0; j<board[0].length; j++){
//        		if(!checkBox(board, i, j) || !checkLine(board, i, j)){
//        			return false;
//        		}
//        	}
//        }
//        return true;
//    }
//    private boolean checkLine(char[][] board, int i, int j){
//    	HashSet<Character> table = new HashSet<Character>();
//    	for(int m=0; m<board.length; m++){
//    		if(board[m][j] != '.'){
//    			if(table.contains(board[m][j])){
//    				return false;
//    			}else{
//    				table.add(board[m][j]);
//    			}
//    		}
//    	}
//    	table = new HashSet<Character>();
//    	for(int m=0; m<board[0].length; m++){
//    		if(board[i][m] != '.'){
//    			if(table.contains(board[i][m])){
//    				return false;
//    			}else{
//    				table.add(board[i][m]);
//    			}
//    		}
//    	}
//    	return true;
//    }
//    
//    private boolean checkBox(char[][] board, int i, int j){
//    	HashSet<Character> table = new HashSet<Character>();
//    	i = (i/3)*3;
//    	j = (j/3)*3;
//    	
//    	for(int m=i; m<i+3; m++){
//    		for(int n=j; n<j+3; n++){
//    			if(board[m][n] != '.'){
//        			if(table.contains(board[m][n])){
//        				return false;
//        			}else{
//        				table.add(board[m][n]);
//        			}
//        		}
//    		}
//    	}
//    	return true;
//    }
//}





//public class Solution {
//    public int searchInsert(int[] A, int target) {
//    	 if(A == null || A.length == 0){
//         	return 0;
//         }
//    	 
//    	 int left = 0;
//    	 int right = A.length-1;
//    	 while(left < right){
//    		 int mid = (left+right)/2;
//    		 
//    		 if(A[mid] == target){
//    			 return mid;
//    		 }else if(A[mid] < target){
//    			 left = mid+1;
//    		 }else{
//    			 right = mid;
//    		 }
//    	 }
//    	 return left;
//    }
//}





//public class Solution {
//    public int[] searchRange(int[] A, int target) {
//    	int[] res = new int[2];
//        if(A == null || A.length == 0){
//        	return new int[]{-1,-1};
//        }
//        
//        res[0] = find(A,target,0,A.length-1,true);
//        res[1] = find(A,target,0,A.length-1,false);
//        return res;
//    }
//    
//    private int find(int[] A, int target, int left, int right, boolean isLeft){
//    	if(right < left){
//    		return -1;
//    	}
//    	
//    	int mid = (right+left)/2;
//    	if(A[mid] == target){
//    		if(isLeft){
//    			if(mid == 0 || A[mid-1] != target){
//    				return mid;
//    			}else{
//    				return find(A,target,left,mid-1,isLeft);
//    			}
//    		}else{
//    			if(mid == A.length-1 || A[mid+1] != target){
//    				return mid;
//    			}else{
//    				return find(A,target,mid+1,right,isLeft);
//    			}
//    		}
//    	}else if(A[mid] < target){
//    		return find(A,target,mid+1,right,isLeft);
//    	}else{
//    		return find(A,target,left,mid-1,isLeft);
//    	}
//    }
//}




//public class Solution {
//    public int search(int[] A, int target) {
//        if(A == null || A.length == 0){
//        	return -1;
//        }
//        
//        return search2(A,target,0,A.length -1);
//    }
//    private int search2(int[] A, int target, int left, int right){
//    	if(left > right){
//    		return -1;
//    	}
//    	
//    	int mid = (left+right)/2;
//    	if(A[mid] == target){
//    		return mid;
//    	}else if( A[mid] < A[right]){
//    		if(target > A[mid] && target <= A[right]){
//    			return search2(A,target,mid+1,right);
//    		}else{
//    			return search2(A,target,left,mid-1);
//    		}
//    	}else {
//    		if(target >= A[left] && target < A[mid]){
//    			return search2(A,target,left,mid-1);
//    		}else{
//    			return search2(A,target,mid+1,right);
//    		}
//    	}
//    }
//}





//public class Solution {
//    public String convert(String s, int nRows) {
//        if(s == null || s.isEmpty()){
//        	return "";
//        }
//        if(nRows == 1)  
//            return s;  
//        StringBuilder res = new StringBuilder();
//        
//        for(int i=0; i<nRows; i++){
//        	
//        	for(int j = i; j<s.length(); ){
//        		res.append(s.charAt(j));
//        		if(i != 0 && i != nRows-1){
//        			if((j+2*nRows-2-2*i)<s.length()){
//        				res.append(s.charAt(j+2*nRows-2-2*i));
//        			}
//        		}
//        		j = j+2*nRows - 2;
//        	}
//        }
//        return res.toString();
//    }
//}





//public class Solution {
//    public boolean isMatch(String s, String p) {
//    	
//        if(p.length() < 2 || p.charAt(1) != '*'){
//        	if(p.length() < 1){
//        		return s.length() == 0;
//        	}else{
//        		if(s.length() < 1 || (p.charAt(0)!= '.' && p.charAt(0)!= s.charAt(0))){
//        			return false;
//        			
//        		}else{
//        			return isMatch(s.substring(1), p.substring(1));
//        		}
//        	}
//        }else{
//        	int len = s.length();
//        	int i = -1;
//        	while(i < len && (i<0 || p.charAt(0)=='.' || p.charAt(0) == s.charAt(i))){
//        		if(isMatch(s.substring(i+1),p.substring(2))){
//        			return true;
//        		}
//        		i++;
//        	}
//        	return false;
//        }
//    }
//}





//public class Solution {
//    public int search(int[] A, int target) {
//    	Vehicle description:
//
//    		5UXWX9C56E0D34401 JIAN ZHANG
//    }
//}





//public class Solution {
//    public int longestValidParentheses(String s) {
//        Stack<Integer> lefts = new Stack<Integer>();
//        int right = -1;
//        int max = 0;
//        for(int i=0; i<s.length(); i++){
//        	if(s.charAt(i) == '('){
//        		lefts.push(i);
//        	}else{
//        		if(lefts.isEmpty()){
//        			right = i;
//        		}else{
//        			int tmp = lefts.pop();
//        			if(lefts.isEmpty()){
//        				max = Math.max(max, i-right);
//        			}else{
//        				max = Math.max(max, i-lefts.peek());
//        			}
//        		}
//        	}
//        }
//        return max;
//    }
//}





//public class Solution {
//    public void nextPermutation(int[] num) {
//        if(num == null || num.length == 0){
//        	throw new IllegalArgumentException("wrong input");
//        }
//        
//        int index = num.length-1;
//        int len = num.length-1;
//        while(index >= 0){
//        	if(num[index] < num[len]){
//        		int tmp = num[len];
//        		num[len] = num[index];
//        		num[index] = tmp;
//        		break;
//        	}
//        	index--;
//        }
//        index++;
//        sort(num, index);
//        
//    }
//    private void sort(int[] num, int index){
//    	for(int j=0; j<num.length-index; j++){
//    		for(int i = num.length-1; i>index+j; i--){
//        		if(num[i] < num[i-1]){
//        			int tmp = num[i];
//        			num[i] = num[i-1];
//        			num[i-1] = tmp;
//        		}
//        	}
//    	}
//    }
//}





//public class Solution {
//	public TreeNode postfixToBST(String postFix){
//		if(postFix == null || postFix.isEmpty()){
//			throw new IllegalArgumentException("wrong input");
//		}
//		Stack<TreeNode> nods = new Stack<TreeNode>();
//		
//		for(int i = 0; i<postFix.length(); i++){
//			if(postFix.charAt(i)>='0' && postFix.charAt(i)<= '9'){
//				nods.push(new TreeNode(postFix.charAt(i)));
//			}else{
//				TreeNode node2 = nods.pop();
//				TreeNode node1 = nods.pop();
//				nods.push(new TreeNode(postFix.charAt(i), node1, node2));
//			}
//		}
//		
//		if(nods.size() != 1){
//			throw new IllegalArgumentException("wrong input");
//		}
//		
//		return nods.pop();
//	}
//	
//	public int calculatePostfixTree(TreeNode root){
//		if(root == null){
//			throw new IllegalArgumentException("wrong input");
//		}
//		
//		if(root.left == null && root.right == null){
//			return root.lable - '0';
//		}else{
//			return cal(calculatePostfixTree(root.left), root.lable, calculatePostfixTree(root.right));
//		}
//	}
//	
//	private int cal(int left, char root, int right){
//		switch(root){
//		case '+' : return left + right;
//		case '-' : return left - right;
//		case '*' : return left * right;
//		default : return left / right;
//		}
//	}
//}





//public class Solution {
//    public int evalRPN(String[] tokens) {
//        if(tokens == null || tokens.length == 0){
//        	throw new IllegalArgumentException("wrong input");
//        }
//        
//        Stack<String> nums = new Stack<String>();
//        
//        for(int i=0; i<tokens.length; i++){
//        	if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")|| tokens[i].equals("/")){
//        		if(nums.isEmpty()){
//        			throw new IllegalArgumentException("wrong input");
//        		}
//        		String b = nums.pop();
//        		if(nums.isEmpty()){
//        			throw new IllegalArgumentException("wrong input");
//        		}
//        		String a = nums.pop();
//        		nums.push(cal(a,b,tokens[i]));
//        	}else{
//        		nums.push(tokens[i]);
//        	}
//        }
//        if(nums.size() != 1){
//        	throw new IllegalArgumentException("wrong input");
//        }
//        return Integer.valueOf(nums.pop());
//    }
//    private String cal(String a, String b, String op){
//    	switch(op){
//    		case "+" : return String.valueOf(Integer.valueOf(a)+Integer.valueOf(b)); 
//    		case "-" : return String.valueOf(Integer.valueOf(a)-Integer.valueOf(b)); 
//    		case "*" : return String.valueOf(Integer.valueOf(a)*Integer.valueOf(b)); 
//    		default : return String.valueOf(Integer.valueOf(a)/Integer.valueOf(b)); 
//    	}
//    		
//    }
//}





//public class Solution {
//	public static String infixToPostfix(String infix){
//		if(infix == null || infix.length() == 0){
//			throw new IllegalArgumentException("wrong input");
//		}
//		Stack<Character> table = new Stack<Character>();
//		StringBuilder res = new StringBuilder();
//		
//		for(int i=0; i<infix.length(); i++){
//			if(infix.charAt(i) == '('){
//				table.push(infix.charAt(i));
//				continue;
//			}else if(infix.charAt(i) == '+' || infix.charAt(i) == '-' || infix.charAt(i) == '*' || infix.charAt(i) == '/'){
//				while(!table.isEmpty() && getPriority(infix.charAt(i)) <= getPriority(table.peek())){
//					res.append(table.pop());
//				}
//				table.push(infix.charAt(i));
//			}else if(infix.charAt(i) == ')'){
//				while(table.peek() != '('){
//					res.append(table.pop());
//					if(table.isEmpty()){
//						throw new IllegalArgumentException("wrong input");
//					}
//				}
//				table.pop();
//				
//			}else{
//				res.append(infix.charAt(i));
//			}
//		}
//		
//		while(!table.isEmpty()){
//			res.append(table.pop());
//		}
//		return res.toString();
//	}
//	
//	private static int getPriority(Character cur){
//		if(cur == '+' || cur == '-'){
//			return 1;
//		}else{
//			return 2;
//		}
//	}
//	
//	public static void main(String[] args){
//		System.out.println(infixToPostfix("1+2*3-4"));
//		System.out.println(infixToPostfix("1/2*3-4"));
//		System.out.println(infixToPostfix("1*2-3/4"));
//		System.out.println(infixToPostfix("1-2+3*4"));
//	}	
//}





//public class Solution {
//    public ListNode detectCycle(ListNode head) {
//    	if(head == null || head.next == null){
//    		return null;
//    	}
//    	
//    	ListNode p1 = head;
//    	ListNode p2 = head;
//    	boolean cycle = false;
//    	while(p2 != null && p2.next != null){
//    		p1 = p1.next;
//    		p2=p2.next.next;
//    		
//    		if(p1 == p2){
//    			cycle = true;
//    			break;
//    		}
//    	}
//    	
//    	if(cycle){
//    		p1 = head;
//    		while(p1 != p2){
//    			p1=p1.next;
//    			p2=p2.next;
//    		}
//    		return p1;
//    	}else{
//    		return null;
//    	}
//    }
//}





//import java.util.List;
//
//public class Solution {
//    public List<Integer> postorderTraversal(TreeNode root) {
//    	List<Integer> arr = new ArrayList<Integer>();
//    	if(root == null){
//        	return arr;
//        }
//    	
//    	Stack<TreeNode> sta = new Stack<TreeNode>();
//    	Stack<Integer> sta2 = new Stack<Integer>();
//    	sta.push(root);
//    	while(!sta.isEmpty()){
//    		TreeNode tmp = sta.pop();
//    		sta2.push(tmp.val);
//    		if(tmp.left != null){
//    			sta.push(tmp.left);
//    		}
//    		if(tmp.right != null){
//    			sta.push(tmp.right);
//    		}
//    	}
//    	
//    	while(!sta2.isEmpty()){
//    		arr.add(sta2.pop());
//    	}
//    	
//    	return arr;
//    }
//}





//public class Solution{
//	public int findMaxProfit(int[] arr){
//		
//		int leftLeastPrice = arr[0];
//		int maxProfit = 0;
//		int profit = 0;
//		for(int i =1; i<arr.length; i++){
//			profit = arr[i] - leftLeastPrice;
//			if(profit > maxProfit){
//				maxProfit = profit;
//			}else if(profit < 0){
//				leftLeastPrice = arr[i];
//			}
//			
//		}
//		
//		return maxProfit;
//	}
//}





//public class Solution{
//	public int findMaxSub(int[] arr){
//		
//		int sum = 0;
//		int sumMax = 0;
//		
//		for(int i =0 ; i <arr.length; i++){
//			sum += arr[i];
//			if(sum > sumMax){
//				sumMax = sum;
//			}else if(sum < 0){
//				sum = 0;
//			}
//		}
//		
//		return sumMax;
//		
//	}
//}





//public class Solution{
//	public int findMaxSub(int[] arr, int left, int right){
//		if(left == right){
//			return arr[(left+right)/2];
//		}
//		int mid = (left+right)/2;
//		int leftMax = findMaxSub(arr,left,mid);
//		int rightMax = findMaxSub(arr, mid+1, right);
//		int sumMax = findCrossMax(arr, mid, left, right);
//		
//		return Math.max(Math.max(rightMax, leftMax), sumMax);
//		
//	}
//	
//	public int findCrossMax(int[] arr, int mid, int left, int right){
//		if(left > right){
//			return 0;
//		}
//		
//		if(left == right){
//			return arr[mid];
//		}
//		int leftMax = Integer.MIN_VALUE;
//		int sum = 0;
//		for(int i = mid+1 ; i>=left ; i--){
//			sum+=arr[i];
//			if(sum>leftMax) leftMax = sum;
//			
//		}
//		
//		int rightMax = Integer.MIN_VALUE;
//		int sumR = 0;
//		for(int i = mid; i<=right; i++){
//			sumR += arr[i];
//			if(sumR > rightMax){
//				rightMax = sumR;
//			}
//		}
//		
//		return leftMax + rightMax;
//	}
//}





//public class Solution{
//	public boolean binarySearch(int[] arr, int val, int left, int right){
//		if(left > right){
//			return false;
//		}
//		int mid = (left+right)/2;
//		int midVal = arr[mid];
//		if(midVal == val){
//			return true;
//		}else if(midVal > val){
//			return binarySearch(arr, midVal, left,mid-1 );
//		}else{
//			return binarySearch(arr, midVal, mid+1, right);
//		}
//	}
//}





//public class Solution {
//	public int[] insertSortDec(int[] arr){
//		for(int j = 1; j<arr.length; j++){
//			int i = j-1;
//			int key = arr[j];
//			while(i>=0 && arr[i] < key){
//				arr[i+1] = arr[i];
//				i--;
//			}
//			
//			arr[i+1] = key;
//			
//		}
//		
//		return arr;
//	}
//}





//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//    public List<List<Integer>> permute(int[] num) {
//    	List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if(num == null || num.length == 0){
//        	return result;
//        }
//        
//       return getPer(num,0);
//        
//    }
//    
//    public List<List<Integer>> getPer(int[] num, int index){
//    	List<List<Integer>> result = new ArrayList<List<Integer>>();
//    	if(index == num.length-1){
//    		List<Integer> newRes = new ArrayList<Integer>();
//    		newRes.add(num[index]);
//    		result.add(newRes);
//    		return result;
//    	}
//    	
//    	result = getPer(num, index+1);
//    	List<List<Integer>> result2 = new ArrayList<List<Integer>>();
//    	for(List<Integer> element : result){
//    		List<Integer> newRes;
//    		for(int i =0; i<=element.size(); i++){
//    			newRes = new ArrayList<Integer>();
//        		newRes.addAll(element);
//        		newRes.add(i,num[index]);
//        		result2.add(newRes);
//        	}
//    	}
//    	return result2;
//    } 
//}





//public class Solution {
//    public int total = 0;
//    public int totalNQueens(int  n){
//    		total = 0;
//    	   int[] pos = new int[n];
//		   n_dfs( pos, 0,n);
//		  return total;
//	   }
//	   
//	    public void n_dfs( int[] pos, int cur, int n){
//		   if(cur == n) { 
//			   total ++; 
//			   return; 
//			   }
//		   for(int i = 0; i < n; i ++){
//			   pos[cur] = i;
//			   
//			   if(valid(pos,cur)){
//				   n_dfs(pos,cur+1,n);
//			   } 
//		   }
//		   
//	   } 
//	   public boolean valid(int[] pos, int cur){
//		   for(int i = 0; i < cur; i++){
//			   if(pos[i] == pos[cur] || Math.abs(cur - i) == Math.abs(pos[cur] - pos[i]))
//				   return false;
//		   }
//		   return true;
//	   }
//
//}






//public class Solution {
//    public void setZeroes(int[][] matrix) {
//    	if(matrix.length == 0 || matrix[0].length == 0){
//    		return ;
//    	}
//    	
//    	boolean rowIsZero = false;
//    	for(int i=0; i<matrix[0].length; i++){
//    		if(matrix[0][i] == 0){
//    			rowIsZero = true;
//    			break;
//    		}
//    	}
//    	
//    	boolean colIsZero = false;
//    	for(int i = 0; i<matrix.length; i++){
//    		if(matrix[i][0] == 0){
//    			colIsZero = true;
//    			break;
//    		}
//    	}
//    	
//    	for(int i =1; i<matrix.length ; i++){
//    		for(int j=1; j<matrix[0].length; j++){
//    			if(matrix[i][j] == 0){
//    				matrix[0][j] = 0;
//    				matrix[i][0] = 0;
//    			}
//    		}
//    	}
//    	
//    	for(int i=0; i<matrix[0].length; i++){
//    		if(matrix[0][i] == 0){
//    			for(int j = 1; j<matrix.length; j++){
//    				matrix[j][i] = 0;
//    			}
//    		}
//    	}
//    	
//    	for(int i = 0; i<matrix.length; i++){
//    		if(matrix[i][0] == 0){
//    			for(int j = 1; j<matrix[0].length; j++){
//    				matrix[i][j] = 0;
//    			}
//    		}
//    	}
//    	
//    	if(rowIsZero){
//    		for(int i=0; i<matrix[0].length; i++){
//        		matrix[0][i] = 0;
//        	}
//    	}
//    	
//    	if(colIsZero){
//    		for(int i = 0; i<matrix.length; i++){
//    			matrix[i][0] = 0;
//        	}
//    	}
//    }
//}





//public class Solution {
//	public static int get(){
//		return 1;
//	}
//}





//public class Solution {
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        if(m < 1 || m>n) return null;
//        int k = n-m;
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
//        ListNode pre2 = pre;
//        ListNode cur = head;
//        while(m>1){
//        	pre = pre.next;
//        	cur = cur.next;
//        	m--;
//        }
//        
//        ListNode post = cur.next;
//        while(k>0){
//        	System.out.println(k+" "+post.val);
//        	ListNode next = post.next;
//        	
//        	post.next = cur;
//        	cur = post;
//        	post = next;
//        	k--;	
//        }
//        ListNode next = pre.next;
//        pre.next = cur;
//        next.next = post;
//        
//        return pre2.next;
//    }
//}





//import java.util.Stack;
//
//public class Solution {
//    public int evalRPN(String[] tokens) {
//        int res = 0;
//        if(tokens == null || tokens.length == 0){
//        	return res;
//        }
//        
//        Stack<Integer> table = new Stack<Integer>();
//        for(int i=0; i<tokens.length; i++){
//        	if(isOperator(tokens[i])){
//        		if(table.size()<2){
//        			return 0;
//        		}
//        		
//        		int b = table.pop();
//        		int a = table.pop();
//        		if(tokens[i].equals("*")){
//        			table.push(a*b);
//        		}else if(tokens[i].equals("/")){
//        			table.push(a/b);
//        		}else if(tokens[i].equals("-")){
//        			table.push(a-b);
//        		}else{
//        			table.push(a+b);
//        		}
//        	}else{
//        		table.push(Integer.valueOf(tokens[i]));
//        	}
//        }
//        
//        if(table.size() > 1 || table.size()==0){
//        	return 0;
//        }else{
//        	return table.pop();
//        }
//    }
//    public boolean isOperator(String str){
//    	if(str.equals("*") || str.equals("-") || str.equals("+") ||str.equals("/")){
//    		return true;
//    	}else{
//    		return false;
//    	}
//    }
//}





//public class Solution{
//	public int[] replaceArr(int[] arr){
//		if(arr.length <= 1){
//			return arr;
//		}
//		
//		int[] left = new int[arr.length];
//		int[] right = new int[arr.length];
//		left[0] = 1;
//		right[right.length-1] = 1;
//		for(int i = 1; i<left.length; i++){
//			left[i] = left[i-1]*arr[i-1];
//		}
//		
//		for(int i = right.length-2; i>=0; i--){
//			right[i] = right[i+1]*arr[i+1];
//		}
//		
//		for(int i = 0; i< arr.length; i++){
//			arr[i] = left[i]*right[i];
//		}
//		return arr;
//	}
//}





//public class Solution{
//	public String revers(String s){
//		if(s == null || s.length() <=1){
//			return s;
//		}
//		
//		int start = 0;
//		int end = 0;
//		boolean isInteger = true;
//		String res = "";
//		for(;end<s.length();end++){
//			if(s.charAt(end)>='0' && s.charAt(end)<='9'){
//				continue;
//			}else if(s.charAt(end) == ',' || s.charAt(end) == '.' || s.charAt(end)==' '){
//				String key = s.substring(start,end);
//				if(isInteger){
//					res += key;
//				}else{
//					res += reversString(key);
//				}
//				isInteger = true;
//				res += s.charAt(end);
//				start = end+1;
//			}else{
//				isInteger = false;
//			}
//		}
//		return res;
//		
//	}
//	
//	public String reversString(String key){
//		int left = 0;
//		int right = key.length()-1;
//		char[] arr = key.toCharArray();
//		while(left < right){
//			char tmp = arr[left];
//			arr[left] = arr[right];
//			arr[right] = tmp;
//			left++;
//			right--;
//		}
//		return new String(arr);
//	}
//}





//import java.util.Set;
//
//public class Solution {
//    public ArrayList<String> wordBreak(String s, Set<String> dict) {
//    	ArrayList<String> res = new ArrayList<String>();
//        if(s == null || s.length()==0 || dict.size() == 0){
//        	return res;
//        }
//        
//        HashMap<String,ArrayList<String>>table = new HashMap<String,ArrayList<String>>();
//        return wordbb(s,table,dict);
//    }
//    public ArrayList<String> wordbb(String s, HashMap<String, ArrayList<String>> table, Set<String> dict){
//    	
//    }
//}




//public class Solution {
//    public double pow(double x, int n) {
//     if( n < 0){
//    	 x = 1/x;
//    	 n = -n;
//    	 return pow(x,n);
//     }
//     if( n == 0){
//    	 return 1;
//     }
//     if(n == 1){
//    	 return x;
//     }
//     double m = x;
//     double res = pow(m*m, n/2);
//     if(n%2 == 1){
//    	 res *= x;
//     }
//     return res;
//     
//    }
//}





//public class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null){
//        	return head;
//        }
//        
//        ListNode pre = new ListNode(-1);
//        ListNode pre2 = pre;
//        pre.next = head;
//        ListNode cur = head;
//        
//        while(cur != null && cur.next != null){
//        	if(cur.val == cur.next.val){
//        		int key = cur.val;
//        		while(cur != null && cur.val == key){
//        			cur = cur.next;
//        		}
//        		pre.next = cur;
//        		
//        	}else{
//        		pre.next = cur;
//        		cur = cur.next;
//        		pre = pre.next;
//        	}
//        	
//        }
//        return pre2.next;
//    }
//}





//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//
//
//public class Solution {
//    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
//    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        if( candidates == null || candidates.length == 0){
//        	return res;
//        }
//        ArrayList<Integer> tmp = new ArrayList<Integer>();
//        Arrays.sort(candidates);
//        HashSet<ArrayList<Integer>> table = new HashSet<ArrayList<Integer>>();
//        comb(res,candidates,target,0,tmp,0,table);
//        return res;
//    }
//    
//    public void comb(ArrayList<ArrayList<Integer>> res, int[] num, int target, int index, ArrayList<Integer> tmp,
//    		int sum,HashSet<ArrayList<Integer>>table){
//    	if(sum > target){
//    		return ;
//    	}
//    	if(sum == target){
//    		if(!table.contains(tmp)){
//    			ArrayList<Integer> tmp2 = new ArrayList<Integer>();
//    			tmp2.addAll(tmp);
//    			table.add(tmp2);
//    			res.add(tmp2);
//    		}
//    		return;
//    	}
//    	
//    	for(int i = index; i<num.length ; i++){
//    		sum += num[i];
//    		tmp.add(num[i]);
//    		comb(res,num,target,index,tmp,sum,table);
//    		sum -= num[i];
//    		tmp.remove(tmp.size()-1);
//    	}
//    	
//    }
//}




//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//
//public class Solution {
//    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
//    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        if( num == null || num.length == 0){
//        	return res;
//        }
//        ArrayList<Integer> tmp = new ArrayList<Integer>();
//        Arrays.sort(num);
//        HashSet<ArrayList<Integer>> table = new HashSet<ArrayList<Integer>>();
//        comb(res,num,target,0,tmp,0,table);
//        return res;
//    }
//    
//    public void comb(ArrayList<ArrayList<Integer>> res, int[] num, int target, int index, ArrayList<Integer> tmp,
//    		int sum,HashSet<ArrayList<Integer>>table){
//    	if(sum > target){
//    		return ;
//    	}
//    	if(sum == target){
//    		if(!table.contains(tmp)){
//    			ArrayList<Integer> tmp2 = new ArrayList<Integer>();
//    			tmp2.addAll(tmp);
//    			table.add(tmp2);
//    			res.add(tmp2);
//    		}
//    		return;
//    	}
//    	
//    	for(int i = index; i<num.length; i++){
//    		sum += num[i];
//    		tmp.add(num[i]);
//    		comb(res,num,target,i+1,tmp,sum,table);
//    		sum -= num[i];
//    		tmp.remove(tmp.size()-1);
//    	}
//    	
//    }
//}





//import java.util.HashMap;
//
//public class Solution{
//	public boolean isMax(int[] arr){
//		if(arr == null || arr.length == 0){
//			return false;
//		}
//		
//		boolean res = false;
//		
//		int maxVal = 0;
//		HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
//		
//		for(int tmp : arr){
//			if(table.containsKey(tmp)){
//				int val = table.get(tmp)+1;
//				table.put(tmp, val+1);
//				if(val > maxVal){
//					res = true;
//					maxVal = val;
//				}else if(val == maxVal){
//					res = false;
//				}
//			}else{
//				table.put(tmp, 1);
//				if(maxVal == 1){
//					res = false;
//				}else if(maxVal < 1){
//					res = true;
//					maxVal = 1;
//				}
//			}
//		}
//		return res;
//		
//		
//	}
//}





//public class Solution{
//	public LinkedListNode sortList(LinkedListNode root){
//		if(root == null || root.next == null){
//			return root;
//		}
//		LinkedListNode pre = new LinkedListNode(-1);
//		pre.next = root;
//		LinkedListNode point1 = root;
//		LinkedListNode point2 = root;
//		while(point2 != null && point2.next != null){
//			pre = pre.next;
//			point1 = point1.next;
//			point2 = point2.next.next;
//		}
//		pre.next = null;
//		return merge(sortList(root),sortList(point1));
//	}
//	public LinkedListNode merge(LinkedListNode r1, LinkedListNode r2){
//		if(r1 == null){
//			return r2;
//		}else if(r2 == null){
//			return r1;
//		}
//		
//		LinkedListNode pre = new LinkedListNode(-1);
//		LinkedListNode cur = pre;
//		while(r1 != null && r2 != null){
//			if(r1.value<r2.value){
//				cur.next = r1;
//				r1 = r1.next;
//			}else{
//				cur.next = r2;
//				r2 = r2.next;
//			}
//			cur = cur.next;
//		}
//		
//		if(r1 != null){
//			cur.next = r1;
//		}
//		if(r2 != null){
//			cur.next = r2;
//		}
//		return pre.next;
//		
//	}
//}





//public class Solution {
//    public String strStr(String haystack, String needle) {
//    	if( needle.length() == 0){
//    		return haystack;
//    	}
//        if(haystack.length() == 0 || needle.length() > haystack.length()){
//        	return null;
//        }
//        
//        for(int i = 0; i<=haystack.length()-needle.length() ; i++){
//        	if(haystack.charAt(i)==needle.charAt(0)){
//        		for(int j = 0; j<needle.length(); j++){
//        			if(haystack.charAt(i+j) != needle.charAt(j)){
//        				break;
//        			}
//        			
//        			if(j == needle.length()-1){
//        				return haystack.substring(i);
//        			}
//        		}
//        	}
//        }
//        return null;
//    }
//}





//public class Solution {
//    public int maxDepth(TreeNode root) {
//        if(root == null){
//        	return 0;
//        }
//        
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }
//}





//// String Reorder Distance apart
//
//public class Solution{
//	public String convertStr(String str, int distance){
//		if(str.isEmpty() || distance <=1){
//			return str;
//		}
//		char[] res = new char[str.length()];
//		int[] arr = new int[256];
//		for(int i =0; i<str.length() ; i++){
//			arr[str.charAt(i)]++;
//		}
//		int[] used = new int[256];
//		for(int i=0; i<str.length() ; i++){
//			boolean[] expect = new boolean[256];
//			boolean done = false;
//			while(!done){
//				int m = getMostChar(arr,expect);
//				if(m == -1){
//					return "false";
//				}
//				expect[m] = true;
//				if(used[m] <= 0){
//					res[i] = (char)m;
//					arr[m] --;
//					done = true;
//					used[m] = distance;
//					
//				}
//			}
//			for(int j = 0; j<used.length; j++){
//				used[j] --;
//			}
//			
//		}
//		
//		return new String(res);
//	}
//	
//	public int getMostChar(int[] arr, boolean[] expect){
//		int index = -1;
//		int max = -1;
//		for(char i='a'; i<='z'; i++){
//			if(arr[i]>0 && arr[i] > max && !expect[i]){
//				index = i;
//				max = arr[i];
//			}
//		}
//		return index;
//	}
//}





//public class Solution {
//    public boolean isValidSudoku(char[][] board) {
//        
//    }
//}





//import java.util.HashMap;
//import java.util.Set;
//
//public class Solution {
//    public boolean wordBreak(String s, Set<String> dict) {
//        if(s == null || s.length() == 0 || dict == null || dict.size() == 0){
//        	return false;
//        }
//        HashMap<String,Boolean> table = new HashMap<String, Boolean>();
//        return wordBreakIndex(s,0,dict,table);
//    }
//    
//    public boolean wordBreakIndex(String s, int index, Set<String> dict, HashMap<String,Boolean> table){
//    	if(index == s.length()){
//    		return true;
//    	}
//    	
//    	for(int i = s.length(); i>= index; i--){
//    		String key = s.substring(index, i);
//    		if(dict.contains(key)){
//    			if(i != s.length()){
//    				String next = s.substring(i);
//    				if(table.containsKey(next)){
//    					if(table.get(next)){
//    						return true;
//    					}
//    				}else{
//    					boolean nextRes = wordBreakIndex(s,i,dict,table);
//    					table.put(next, nextRes);
//    					if(nextRes){
//    						return true;
//    					}
//    				}
//    				
//    			}else{
//    				return true;
//    			}
//    		
//    		}
//    	}
//    	return false;
//    }
//}





///**
// * Definition for singly-linked list with a random pointer.
// * class RandomListNode {
// *     int label;
// *     RandomListNode next, random;
// *     RandomListNode(int x) { this.label = x; }
// * };
// */
//public class Solution {
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if(head == null) return null;
//        RandomListNode cur = head;
//        while(cur!=null){
//        	RandomListNode tmp = new RandomListNode(cur.label);
//        	RandomListNode next = cur.next;
//        	cur.next = tmp;
//        	tmp.next = next;
//        	cur = next;
//        }
//        
//        cur = head;
//        while(cur != null){
//        	RandomListNode rand = cur.random;
//        	RandomListNode next = cur.next;
//        	if(rand != null){
//        	   next.random = rand.next;
//        	}
//        	cur = next.next;
//        }
//        cur = head;
//        
//        RandomListNode res = cur.next;
//        
//        RandomListNode tmp = cur.next;
//        
//        while(cur != null){
//        	tmp = cur.next;
//        	cur.next = tmp.next;
//        	if(tmp.next != null){
//        	   tmp.next = tmp.next.next; 
//        	}
//        	
//        	cur = cur.next;
//        }
//        
//        return res;
//    }
//}





//import java.util.ArrayList;
//
//public class Solution {
//    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
//    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        if(root == null){
//        	return res;
//        }
//        ArrayList<Integer> tmp = new ArrayList<Integer>();
//        path(res, tmp, sum, root);
//        return res;
//    }
//    public void path(ArrayList<ArrayList<Integer>>res, ArrayList<Integer>tmp, int sum, TreeNode root){
//    	if(root == null || root.val > sum){
//    		return;
//    	}
//    	if(root.val == sum && root.left == null && root.right == null){
//    		tmp.add(root.val);
//    		ArrayList<Integer> tmp2 = new ArrayList<Integer>();
//    		for(int i = 0 ; i<tmp.size(); i++){
//    			tmp2.add(0,tmp.get(i));
//    		}
//    		res.add(tmp2);
//    		return;
//    	}
//    	
//    	tmp.add(root.val);
//    	
//    	path(res,tmp,sum-root.val, root.left);
//    	path(res,tmp,sum-root.val, root.right);
//    	
//    	tmp.remove(tmp.size()-1);
//    	
//    }
//}





//public class Solution {
//    public int climbStairs(int n) {
//    	
//        if(n <= 2){
//        	return n;
//        }
//        
//        int aa = 1;
//        int bb = 2;
//        int res = 0;
//        for(int i = 3; i<=n; i++){
//        	res = aa + bb;
//        	aa = bb;
//        	bb = res;
//        }
//        return res;
//        
//        
//    }
//}





//public class Solution {
//    public int lengthOfLastWord(String s) {
//        if(s == null || s.trim().length() == 0){
//        	return 0;
//        }
//        s=s.trim();
//        int right = s.length()-1;
//        int count = 0;
//        while(right >= 0){
//        	if(s.charAt(right)==' '){
//        		break;
//        	}else{
//        		right--;
//        		count++;
//        	}
//        }
//        return count;
//    }
//}





//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//class Solution{
//    /* Head ends here*/
//    static void median(String a[],int x[]) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//       for(int i=0; i<a.length; i++){
//    	   if(a[i].equals("r")){
//    		   if(list.contains(x[i])){
//    			   int c = 0;
//    			   while(c<list.size()){
//    				   if(list.get(c)==x[i]){
//    					   list.remove(c);
//    					   break;
//    				   }else{
//    					   c++;
//    				   }
//    			   }
//    			   if(list.isEmpty()){
//    				   System.out.println("Wrong!");
//    			   }else{
//    				   System.out.println(getMedian(list));
//    			   }
//    			   
//    		   }else{
//    			   System.out.println("Wrong!");
//    		   }
//    	   }else if(a[i].equals("a")){
//    		   if(list.isEmpty()){
//    			   list.add(x[i]);
//    			   
//    		   }else{
//    			   for(int j =0; j<list.size(); j++){
//        			   if(x[i] < list.get(j)){
//        				   list.add(j, x[i]);
//        				   break;
//        			   }else if(j == list.size()-1){
//        				   list.add(x[i]);
//        				   break;
//        			   }
//        		   }
//    		   }
//    		   
//    		   
//    		   System.out.println(getMedian(list));
//    	   }else{
//    		   System.out.println("Wrong!");
//    	   }
//       }
//    }
//    
//    public static BigDecimal getMedian(ArrayList<Integer> list){
//    	int len = list.size();
//    	if(len % 2 == 1){
//    		BigDecimal res = new BigDecimal(list.get((len-1)/2));
//    		res.stripTrailingZeros();
//    		return res;
//    	}else{
//    		
//    		float a = list.get((len-1)/2);
//    		float b = list.get((len)/2);
//    		BigDecimal res = new BigDecimal((a+b)/2);
//    		res.stripTrailingZeros();
//    		return res;
//    		
//    	}
//    }
//    
//    /* Tail starts here*/
//    
//   public static void main( String args[] ){
//      
//
//      Scanner in = new Scanner(System.in);
//      
//      int N;
//      N = in.nextInt();
//   
//      String s[] = new String[N];
//      int x[] = new int[N];
//      
//      for(int i=0; i<N; i++){
//         s[i] = in.next();
//         x[i] = in.nextInt();
//      }
//   
//      median(s,x);
//    }
//}





//public class Solution {
//    public int minPathSum(int[][] grid) {
//         if(grid.length == 0 || grid[0].length == 0)return 0;
//         int[][] table = new int[grid.length][grid[0].length];
//         for(int i =0; i<grid.length; i++){
//        	 for(int j=0; j<grid[0].length; j++){
//        		 if(i ==0 && j ==0){
//        			 table[i][j] = grid[i][j];
//        		 }else if(i == 0){
//        			 table[i][j] = table[i][j-1]+grid[i][j];reproduction
//        		 }else if(j == 0){
//        			 table[i][j] = table[i-1][j]+grid[i][j];
//        		 }else{
//        			 table[i][j] = Math.min(table[i-1][j], table[i][j-1])+grid[i][j];
//        		 }
//        	 }
//         }
//         return table[grid.length-1][grid[0].length-1];
//    }
//}





//import java.util.HashMap;
//
//public class Solution {
//	HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
//    public int climbStairs(int n) {
//        
//        if(n<=2){
//        	return n;
//        }
//        if(table.containsKey(n)){
//        	return table.get(n);
//        }
//        int res = climbStairs(n-1)+climbStairs(n-2);
//        table.put(n, res);
//        return res;
//        
//    }
//}





//public class Solution{
//	public String reverString(String str){
//		if(str == null || str.length() <= 1){
//			return str;
//		}
//		int start =0;
//		int end = 0;
//		boolean isInteger = true;
//		String res ="";
//		
//		for(; end<str.length(); end++){
//			if(str.charAt(end)>='0' && str.charAt(end)<='9'){
//				continue;
//			}else if(str.charAt(end)==',' || str.charAt(end)==' ' || str.charAt(end)=='.'){
//				String cur = str.substring(start,end);
//				if(isInteger){
//					res += cur;
//				}else{
//					res += revers(cur);
//				}
//				res+=str.charAt(end);
//				isInteger = true;
//				start = end+1;
//			}else{
//				isInteger = false;
//			}
//		}
//		return res;
//	}
//	private String revers(String str){
//		if(str.length()<=1){
//			return str;
//		}
//		char[] arr = str.toCharArray();
//		int left = 0;
//		int right = arr.length-1;
//		while(left < right){
//			char tmp = arr[left];
//			arr[left] = arr[right];
//			arr[right] = tmp;
//			left++;
//			right--;
//		}
//		return new String(arr);
//	}
//}





//public class Solution{
//	public String reverString(String str){
//		if(str == null || str.length()==0){
//			return str;
//		}
//		
//		String[] arr = str.split(" ");
//		
//		for(int i =0; i<arr.length; i++){
//			System.out.println("arr "+arr[i]);
//			char r = 'a';
//			if(arr[i].charAt(arr[i].length()-1) == ',' || arr[i].charAt(arr[i].length()-1) == '.'){
//				
//				r=arr[i].charAt(arr[i].length()-1);
//				arr[i] = arr[i].substring(0,arr[i].length()-1);
//			}
//			arr[i] = format(arr[i]);
//			if(r != 'a'){
//				arr[i]+=r;
//			}
//			
//			
//		}
//		String res = "";
//		for(int i=0; i<arr.length; i++){
//			res += arr[i]+" ";
//		}
//		return res.substring(0,res.length()-1);
//	}
//	
//	public String format(String str){
//		if(str.length() <= 1){
//			return str;
//		}
//		int left = 0;
//		int right = str.length()-1;
//		
//		while(left <= right){
//			if(str.charAt(right)>='0' && str.charAt(right)<='9'){
//				right--;
//			}else if(str.charAt(left)>='0' && str.charAt(left)<='9'){
//				left++;
//			}else{
//				break;
//			}
//			
//		}
//		
//		if(left > right){
//			return str;
//		}else{
//			return revers(str);
//		}
//	}
//	
//	public String revers(String str){
//		System.out.println("str "+str);
//		char[] arr = str.toCharArray();
//		int left = 0;
//		int right = arr.length-1;
//		while(left < right){
//			char tmp = arr[left];
//			arr[left] = arr[right];
//			arr[right] = tmp;
//			left++;
//			right--;
//		}
//		System.out.println("tsr "+new String(arr));
//		return new String(arr);
//	}
//}





//public class Solution {
//    public int jump(int[] A) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int curStep = 0, nextStep=0,res=0;
//        for(int i =0; i<A.length;i++){
//    		if(i>curStep){
//    			curStep=nextStep;
//    			res++;
//    		}
//    		nextStep=Math.max(nextStep, A[i]+i);
//        }
//    	return res;
//    }
//}





//public class Solution{
//	// Greedy solution, O(n) time complexity and O(1) memrory.
//	public void hooper(int[] arr){
//		if(arr == null || arr.length == 0){
//			System.out.println("out");
//		}
//		// start from 0 index.
//		int cur = arr[0];
//		// defind a int which means the maximum distance we can hop.
//		int maxStep = arr[0];
//		int maxStepIndex = 0;
//		
//		String res = "0";	
//		// for loop from 1 index to the end.
//		for(int i = 1; i< arr.length; i++){
//			if(cur-1<0){
//				// cur-1<0 means we cannot hop to this i index and should output "failure"
//				System.out.println("failure");
//				return;
//			}else{
//				cur--;			
//				maxStep --;
//				//update maxStep we can hop.
//				if(arr[i] > maxStep){
//					maxStep = arr[i];
//					maxStepIndex = i;
//				}
//				//if cur values is 0, we need hop to another index
//				if(cur == 0){
//					// if the maximum steps is also 0, that means we cannot hop forward.
//					if(maxStep == 0){
//						System.out.println("failure");
//						return;
//					}
//					cur = maxStep;
//					res += ", "+maxStepIndex;
//				}
//			}
//		}
//		System.out.println(res+", out");
//	}	
//}





//public class Solution {
//    public int minCut(String s) {
//    	if(s == null || s.length() == 0)return 0;
//    	
//    	int[] res = new int[s.length()+1];
//    	
//    	for(int i = s.length(); i>=0 ; i--){
//    		res[i] = s.length()-i;
//    	}
//    	
//    	boolean[][] table = new boolean[s.length()][s.length()];
//    	
//    	for(int i = s.length()-1; i>=0; i++){
//    		for(int j = i; j<s.length(); j++){
//    			if(s.charAt(i) == s.charAt(j) &&((j-i<2)|| table[i+1][j-1])){
//    				table[i+1][j-1] = true;
//    				res[i] = Math.min(res[i], res[j+1]+1);
//    			}
//    		}
//    	}
//    	return res[0];
//    }
//}





//import java.util.ArrayList;
//
//public class Solution {
//    public ArrayList<String> restoreIpAddresses(String s) {
//    	ArrayList<String> res = new ArrayList<String>();
//    	
//    	if(s == null || s.length() == 0){
//    		return res;
//    	}
//    	
//    	getIP(s, 0, 0, "",res);
//    	return res;
//    }
//    public void getIP(String s, int index, int n, String cur, ArrayList<String> res){
//
//    	if(s.length() == index && n == 4){
//    		res.add(cur);
//    		
//    		return;
//    	}
//    	
//    	if((s.length()-(index))>(4-n)*3){
//    		return ;
//    	}
//    	
//    	if((s.length()-(index) )< (4-n)){
//    		return;
//    	}  	
//    	
//    	for(int i = index; i<= index+2 && i<s.length(); i++){
//    		String key = s.substring(index,i+1);
//    		int value = Integer.valueOf(key);
//    		if(value >= 0 && value <= 255){
//    			String newS = cur.equals("")? key : cur+"."+key;
//    			getIP(s,i+1,n+1,newS,res);
//    		}
//    		if(value == 0){
//    		    break;
//    		}
//    	}
//    }
//}





//import java.util.ArrayList;
//import java.util.Stack;
//
//import javax.swig.tree.TreeNode;
//
//public class Solution {
//    public ArrayList<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        
//        Stack<TreeNode> table = new Stack<TreeNode>();
//        
//        if(root == null){
//        	return res;
//        }
//        table.push(root);
//        
//        while(!table.isEmpty()){
//        	TreeNode cur = table.pop();
//        	res.add(cur.val);
//        	
//        	if(cur.right != null){
//        		table.push(cur.right);
//        	}
//        	
//        	if(cur.left != null){
//        		table.push(cur.left);
//        	}
//        	
//        	
//        }
//        
//    }
//}





//public class Solution {
//    public boolean exist(char[][] board, String word) {
//        if(board.length == 0 || board[0].length == 0){
//        	return false;
//        }
//        
//        int[][] arr = new int[board.length][board[0].length];
//        
//        for(int i=0 ; i<board.length; i++){
//        	for( int j=0; j<board[0].length; j++){
//        		if(board[i][j] == word.charAt(0)){
//        			arr[i][j] = 1;
//        			if(existEle(word, 1, board, arr, i, j)){
//        				return true;
//        			}
//        			arr[i][j] = 0;
//        			
//        		}
//        	}
//        }
//        return false;
//    }
//    public boolean existEle(String word, int index, char[][] board, int[][] arr, int a, int b){
//    	if(index == word.length()){
//    		return true;
//    	}
//    	
//    	if(arr[a][b+1] != 1 && arr[a][b+1] == word.charAt(index+1)){
//    		if(existEle(word,index+1,board,arr,a,b+1)){
//    			return true;
//    		}
//    	}
//    }
//}





//public class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null){
//        	return head;
//        }
//        
//        ListNode pre1 = new ListNode(-1);
//        pre1.next = head;
//        ListNode pre = pre1;
//        
//        while(head.next != null){
//        	ListNode next = head.next;
//        	if(head.val != next.val){
//        		pre = pre.next;
//        		head = head.next;
//        	}else{
//        		while(head.val == head.next.val){
//        			head.next = head.next.next;
//        		}
//        		pre.next = head.next;
//        		head = head.next;
//        	}
//        }
//    }
//}





//public class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null){
//        	return head;
//        }
//        ListNode h1 = head;
//        
//        while(h1.next != null){
//        	ListNode next = h1.next;
//        	if(h1.val == next.val){
//        		h1.next = next.next;
//        	}else{
//        		h1 = next;
//        	}
//        }
//        return head;
//        
//    }
//}





//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//
//
//public class Solution{
//	public String findMax(Integer[] arr){
//		if(arr == null || arr.length == 0){
//			return "";
//		}
//	
//		Arrays.sort(arr,
//				new Comparator<Integer>(){
//
//			@Override
//			public int compare(Integer a, Integer b) {
//				// TODO Auto-generated method stub
//				if(comb(a,b) < comb(b,a)){
//					return 1;
//				}else if(comb(a,b) > comb(b,a)){
//					return -1;
//				}else{
//					return 0;
//				}
//			}
//		}
//		
//		);
//		
//		String res = "";
//		for(int tmp : arr){
//			res+=String.valueOf(tmp);
//		}
//		return res;
//		
//	}
//	
//	public int comb(int a, int b){
//		String aa = String.valueOf(a);
//		String bb = String.valueOf(b);
//		
//		System.out.println(Integer.valueOf(aa+bb));
//		return Integer.valueOf(aa+bb);
//	}
//}





//public class Solution{
//	public String countElement(String str){
//		if(str == null || str.length() ==0){
//			return ""; 
//		}
//		
//		Stack<Integer> table = new Stack<Integer>();
//		
//		int num = 0;
//		
//		for(int i= str.length()-1; i>=0; i--){
//			char cur = str.charAt(i);
//			
//			
//		}
//	}
//}





//public class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        
//    }
//}





//public class Solution {
//    public boolean search(int[] A, int target) {
//        if(A == null || A.length == 0){
//        	return false;
//        }
//        
//        int left = 0;
//        int right = A.length-1;
//        while(left < right){
//        	int mid = (left+right)/2;
//        	if(A[mid] == target){
//        		return true;
//        	}
//        	
//        	
//        }
//    }
//}





//import javax.swing.tree.TreeNode;
//
//public class Solution {
//	ListNode head;
//    public TreeNode sortedListToBST(ListNode head) {
//    	this.head = head;
//        ListNode p1 = head;
//        
//        int len = 0;
//        while(p1 != null){
//        	p1=p1.next;
//        	len ++;
//        }
//        return sortList(0,len-1);
//    }
//    public TreeNode sortList(int left, int right){
//    	if(head == null || left>right){
//    		return null;
//    	}
//    	if(left == right){
//    		ListNode tmp = new TreeNode(head.val);
//    		head = head.next;
//    		return tmp;
//    	}
//    	int mid = (left+right)/2;
//    	
//    	TreeNode leftNode = sortList(head, left, mid-1);
//    	
//    	TreeNode root = new TreeNode(head.val);
//    	head = head.next;
//    	root.left = leftNode;
//    	root.right = sortList(head,mid+1,right);
//    	
//    	return root;
//    	
//    }
//}





//import java.util.ArrayList;
//
//public class Solution {
//    public ArrayList<Integer> grayCode(int n) {
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        
//        if(n<0){
//        	return res;
//        }
//        res.add(0);
//        
//        while(n>0){
//        	ArrayList<Integer> next = new ArrayList<Integer>();
//        	for(int i=0; i<res.size(); i++){
//        		int cur = res.get(i);
//        		if(i%2 == 0){
//        			next.add(cur*2+0);
//        			next.add(cur*2+1);
//        		}else{
//        			next.add(cur*2+1);
//        			next.add(cur*2+0);
//        		}
//        	}
//        	res = next;
//        	n--;
//        }
//        
//        return res;
//        
//        
//    }
//}





//public class Solution {
//    public boolean isNumber(String s) {
//        if(s == null || s.length() == 0)return true;
//        boolean isDigit = false;
//        boolean isE = false;
//        boolean isP = false;
//        
//        for(int i =0; i<s.length(); i++){
//        	char cur = s.charAt(i);
//        	if(cur>='0' && cur<='9'){
//        		isDigit = true;
//        		
//        	}else if(cur == 'e'){
//        		if(!isDigit || isP){
//        			return false;
//        		}
//        		isE = true;
//        	}else if(cur == '.'){
//        		if(isE || isP){
//        			return false;
//        		}
//        		isP = true;
//        	}else if(cur == '+' || cur =='-'){
//        		if(i!= 0 && s.charAt(i-1) != 'e'){
//        			return false;
//        		}
//        	}else{
//        		return false;
//        	}
//        }
//        return true;
//    }
//}





//import java.util.Stack;
//
//public class Solution {
//    public boolean isValid(String s) {
//    	if(s == null || s.length() == 0) return true;
//    	Stack<Character> table = new Stack<Character>();
//    	for(int i=0; i<s.length(); i++){
//    		char cur = s.charAt(i);
//    		if(isLeft(cur)){
//    			table.push(cur);
//    		}else{
//    			if(table.isEmpty()){
//    				return false;
//    			}
//    			char left = table.pop();
//    			if(!isMatch(cur,left)){
//    				return false;
//    			}
//    		}
//    	}
//    	if(!table.isEmpty()){
//    		return false;
//    	}
//    	return true;
//    	
//    }
//    public boolean isLeft(char cur){
//    	if(cur == '{' || cur == '[' || cur=='('){
//    		return true;
//    	}else{
//    		return false;
//    	}
//    }
//    
//    public boolean isMatch(char cur, char left){
//    	if((left == '{' && cur=='}')||(left == '[' && cur == ']')||(cur == ')' && left == '(')){
//    		return true;
//    	}
//    	else {
//    		return false;
//    	}
//    }
//}





//public class Solution {
//    public void rotate(int[][] matrix) {
//        if(matrix.length == 0 || matrix[0].length == 0)return;
//        int n = matrix.length-1;
//        for(int i =0 ; i<(matrix.length)/2; i++){
//        	
//        	for(int j =i; j<matrix.length-1-i; j++){
//        		int tmp = matrix[i][j];
//        		matrix[i][j] = matrix[n-j][i];
//        		matrix[n-j][i] = matrix[n-i][n-j];
//        		matrix[n-i][n-j] = matrix[j][n-i];
//        		matrix[j][n-i] = tmp;
//        		
//        		
//        	}
//        	
//        }
//    }
//}





//public class Solution {
//    public String multiply(String num1, String num2) {
//        char[] aa = num1.toCharArray();
//        char[] bb = num2.toCharArray();
//        
//        int[] res = new int[aa.length+bb.length];
//        for(int i=aa.length-1; i>=0; i--){
//        	int carry = 0;
//        	for(int j=bb.length-1; j>=0; j--){
//        		int aav = aa[i]-'0';
//        		int bbv = bb[j]-'0';
//        		
//        		int result = res[i+j+1]+aav*bbv + carry;
//        		res[i+j+1] = result%10;
//        		carry = result / 10;
//        	}
//        	res[i] = carry;
//        }
//        
//        StringBuffer val = new StringBuffer();
//        int index = 0;
//        while(res[index] == 0){
//        	index ++;
//        	if(index == res.length-1){
//        		break;
//        	}
//        }
//        for(int i = index; i<res.length; i++){
//        	val.append(res[i]);
//        }
//        return val.toString();
//    }
//}





//public class Solution {
//    public int maxDepth(TreeNode root) {
//       if(root == null){
//    	   return 0;
//       }
//       
//       return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
//    }
//}





//public class Solution {
//    public String multiply(String num1, String num2) {
//        
//    }
//}





//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class Solution {
//    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
//    	ArrayList<Interval> res = new ArrayList<Interval>();
//    	Collections.sort(intervals,new Comparator<Interval>(){
//    		public int compare(Interval a, Interval b){
//    			if(a.start > b.start){
//    				return 1; 
//    			}else if(a.start == b.start){
//    				return 0;
//    			}else{
//    				return -1;
//    			}
//    		}
//    	});
//    	if(intervals == null || intervals.size()<=1  ){
//    		return intervals;
//    	}
//    	
//    	Interval cur = intervals.get(0);
//    	for(int i=1; i<intervals.size(); i++){
//    		Interval tmp = intervals.get(i);
//    		if(tmp.start > cur.end){
//    			res.add(cur);
//    			cur = tmp;
//    		}else{
//    			cur.start = Math.min(cur.start, tmp.start);
//    			cur.end = Math.max(cur.end, tmp.end);
//    		}
//    	}
//    	res.add(cur);
//    	return res;
//    }
//}





//import java.util.ArrayList;
//
//public class Solution {
//    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
//    	ArrayList<Interval> res = new ArrayList<Interval>();
//    	
//    	if(intervals == null){
//    		return res;
//    	}
//    	
//    	int i = 0;
//    	for( ; i<intervals.size(); i++){
//    		Interval cur = intervals.get(i);
//    		if(cur.end < newInterval.start){
//    			res.add(cur);
//    		}else if(cur.start > newInterval.end){
//    			break;
//    		}else{
//    			newInterval.start = Math.min(cur.start, newInterval.start);
//    			newInterval.end = Math.max(cur.end, newInterval.end);
//    		}
//    	}
//    	
//    	res.add(newInterval);
//    	for(;i<intervals.size();i++){
//    		res.add(intervals.get(i));
//    	}
//    	return res;
//    }
//}





//import java.util.ArrayList;
//import java.util.HashSet;
//
//public class Solution {
//    public int ladderLength(String start, String end, HashSet<String> dict) {
//    		if(start == null || end == null || dict == null )
//    			return 0;
//    		
//    		ArrayList<String> visiting = new ArrayList<String>();
//    		visiting.add(start);
//    		ArrayList<Integer> level = new ArrayList<Integer>();
//    		level.add(1);
//    		
//    		HashSet<String> visited = new HashSet<String>();
//    		
//    		visited.add(start);
//    		
//    		while(!visiting.isEmpty()){
//    			String cur = visiting.remove(0);
//    			int lev = level.remove(0);
//    			if(cur.equals(end)){
//    				return lev;
//    			}else{
//    				ArrayList<String> next = getWords(cur,dict,visited,end);
//    				for(String tmp : next){
//    					visiting.add(tmp);
//    					level.add(lev+1);
//    				}
//    			}
//    		}
//    		return 0;
//    }
//    
//    public ArrayList<String> getWords(String input, HashSet<String> dict, HashSet<String> visited, String end){
//    	ArrayList<String> res = new ArrayList<String> ();
//    	char[] arr = input.toCharArray();
//    	for(int j=0; j<arr.length; j++){
//    		for(char i='a'; i<='z'; i++){
//        		char now = arr[j];
//        		if(now != i){
//        			arr[j] = i;
//        			String next = new String(arr);
//        			if( (next.equals(end))|| (dict.contains(next)) && !visited.contains(next) ){
//        				res.add(next);
//        				visited.add(next);
//        			}
//        			arr[j] = now;
//        		}
//        	}
//    	}
//    	return res;
//    		
//    	
//    }
//}





//public class Solution {
//    public int candy(int[] ratings) {
//    	if(ratings == null || ratings.length==0)
//    		return 0;
//    	
//    	int[] left = new int[ratings.length];
//    	int[] right = new int[ratings.length];
//    	left[0]=1;
//    	for(int i=1; i<ratings.length ;i++){
//    		if(ratings[i]>ratings[i-1]){
//    			left[i] = left[i-1]+1;
//    		}else{
//    			left[i] = 1;
//    		}
//    	}
//    	
//    	right[ratings.length-1] = 1;
//    	for(int i = ratings.length-2; i>=0; i--){
//    		if(ratings[i]>ratings[i+1]){
//    			right[i] = right[i+1]+1;
//    		}else{
//    			right[i]=1;
//    		}
//    	}
//    	int res = 0;
//    	for(int i =0; i<ratings.length; i++){
//    		res+=Math.max(left[i], right[i]);
//    	}
//    	return res;
//    }
//}





//public class Solution {
//    public ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null){
//        	return head;
//        }
//        
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
//        ListNode nextHead = pre;
//        ListNode cur = head;
//        ListNode post = head.next;
//        
//        int count = 0;
//        while(post != null){
//        	ListNode next = post.next;
//        	if(count%2 == 0){
//        		post.next = cur;
//            	cur.next = next;
//            	pre.next = post;
//            	pre=cur;
//            	
//        	}
//        	count++;
//        	cur = post;
//        	post = next;
//        	
//        }
//        return nextHead.next;
//    }
//}





//public class Solution {
//    public int trap(int[] A) {
//    	if(A == null || A.length == 0){
//        	return 0;
//        }
//        
//        int[] left = new int[A.length];
//        int[] right = new int[A.length];
//        int maxLeft = 0;
//        
//        for(int i=0; i<left.length; i++){
//        	if(A[i] > maxLeft){
//        		maxLeft = A[i];
//        	}
//        	
//        	left[i] = maxLeft;
//        }
//        
//        int maxRight = 0;
//        for(int i= right.length-1; i>=0; i--){
//        	if(A[i] > maxRight){
//        		maxRight = A[i];
//        	}
//        	right[i] = maxRight;
//        }
//        int res = 0;
//        for(int i=0; i<A.length; i++){
//        	int cur = Math.min(right[i], left[i]);
//        	if(cur > A[i]){
//        		res+=cur-A[i];
//        	}
//        }
//        return res;
//    }
//}


//public class Solution {
//    public int maxArea(int[] height) {
//    	if(height == null || height.length == 0){
//        	return 0;
//        }
//    	
//    	int left = 0;
//    	int right = height.length-1;
//    	int res = 0;
//    	while(left<right){
//    		int leftV = height[left];
//    		int rightV = height[right];
//    		int value = (right - left)*Math.min(rightV, leftV);
//    		
//    		if(value > res){
//    			res = value;
//    		}
//    		
//    		if(leftV >= rightV){
//    			right--;
//    		}else{
//    			left++;
//    		}
//    	}
//    	return res;
//    }
//}





//public class Solution {
//    public int maxArea(int[] height) {
//        if(height == null || height.length == 0){
//        	return 0;
//        }
//        
//        int[] left = new int[height.length];
//        int[] right = new int[height.length];
//        int maxLeft = 0;
//        
//        for(int i=0; i<left.length; i++){
//        	if(height[i] > maxLeft){
//        		maxLeft = height[i];
//        	}
//        	
//        	left[i] = maxLeft;
//        }
//        
//        int maxRight = 0;
//        for(int i= right.length-1; i>=0; i--){
//        	if(height[i] > maxRight){
//        		maxRight = height[i];
//        	}
//        	right[i] = maxRight;
//        }
//        int res = 0;
//        for(int i=0; i<height.length; i++){
//        	int cur = Math.min(right[i], left[i]);
//        	if(cur > height[i]){
//        		res+=cur-height[i];
//        	}
//        }
//        return res;
//    }
//}
	








//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Hashtable;
//
//public class Solution {
//	
//	
//	public ArrayList<String> anagrams(String[] strs) {
//		ArrayList<String> ret = new ArrayList<String>();
//
//		HashMap<String, ArrayList<String>> ht = new HashMap<String, ArrayList<String>>();
//		
//		for(String tmp : strs){
//        	String key = sorted(tmp);
//        	if(ht.containsKey(key)){
//        		ArrayList<String> cur = ht.get(key);
//        		cur.add(tmp);
//        		ht.put(key,cur);
//        	}else{
//        		ArrayList<String> cur = new ArrayList<String>();
//        		cur.add(tmp);
//        		ht.put(key, cur);
//        	}
//        }
//			
//		for(String s : ht.keySet()){
//			ArrayList<String> val = ht.get(s);
//			
//			if(val.size() > 1){
//				ret.addAll(val);
//			}
//		}
//		
//		return ret;
//    }
//	
//	public String sorted(String a){
//		char[] achar = a.toCharArray();
//		Arrays.sort(achar);
//		return new String(achar);
//	}
//	
//	
////    public ArrayList<String> anagrams(String[] strs) {
////    	ArrayList<String> res = new ArrayList<String>();
////        if(strs == null || strs.length==0){
////        	return res;
////        }
////        
////        HashMap<String, ArrayList<String>> table = new HashMap<String,ArrayList<String>>();
////        
//        for(String tmp : strs){
//        	String key = getString(tmp);
//        	if(table.containsKey(key)){
//        		ArrayList<String> cur = table.get(key);
//        		cur.add(tmp);
//        		table.put(key,cur);
//        	}else{
//        		ArrayList<String> cur = new ArrayList<String>();
//        		cur.add(tmp);
//        		table.put(key, cur);
//        	}
//        }
//        
//        for(String tmp : table.keySet()){
//        	if(table.get(tmp) != null && !table.get(tmp).isEmpty()){
//        		res.addAll(table.get(tmp));
//        	}
//        	
//        }
//        return res;
//    }
//    public String getString(String str){
//    	char[] arr = str.toCharArray();
//    	
//    	Arrays.sort(arr);
//    	
//    	return new String(arr);
//    }
//}





//public class Solution {
//    public TreeNode sortedArrayToBST(int[] num) {
//        if(num == null || num.length == 0)
//        	return null;
//        return convertTree(num,0,num.length);
//        
//    }
//    public TreeNode convertTree(int[] num, int left, int right){
//    	if(left > right){
//    		return null;
//    	}
//    	
//    	int mid = (left + right)/2;
//    	
//    	TreeNode root = new TreeNode(num[mid]);
//    	root.left=convertTree(num,left,mid-1);
//    	root.right = convertTree(num,mid+1,right);
//    	return root;
//    }
//}





//import java.util.ArrayList;
//
//import javax.swing.tree.TreeNode;
//
//public class Solution {
//    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
//    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//    	if(root == null){
//    		return res;
//    	}
//    	ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
//    	nodes.add(root);
//    	ArrayList<TreeNode> next = new ArrayList<TreeNode>()
//    	while(!nodes.isEmpty()){
//    		TreeNode cur = nodes.remove(0);
//    		
//    		if(cur.left != null){
//    			next.add(cur.left);
//    		}
//    		if(cur.right != null){
//    			next.add(cur.right);
//    		}
//    		
//    		if(nodes.isEmpty()){
//    			ArrayList<Integer> anew = new ArrayList<Integer>();
//    			for(TreeNode tmp : next){
//    				anew.add(tmp.val);
//    			}
//    			res.add(anew);
//    			nodes.addAll(next);
//    			next = new ArrayList<TreeNode>();
//    		}
//    	}
//    	
//    }
//}





//public class Solution {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
//        return 0;
//        int[][] table = new int[obstacleGrid.length][obstacleGrid[0].length];
//        for(int i =0; i<obstacleGrid.length; i++){
//        	for(int j =0; j<obstacleGrid[0].length; j++){
//        		if(obstacleGrid[i][j] != 1){
//        			if(i==0 || j==0){
//        				table[i][j] = 1;
//        			}else{
//        				table[i][j] = table[i-1][j]+table[i][j-1];
//        			}
//        		}
//        	}
//        }
//        return table[obstacleGrid.length][obstacleGrid[0].length];
//        
//    }
//}





//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Set;
//
//public class Solution {
//    public ArrayList<String> wordBreak(String s, Set<String> dict) {
//        if(s == null || dict == null || s.length() == 0){
//        	return null;
//        }
//        
//        HashMap<String,ArrayList<String>> table = new HashMap<String,ArrayList<String>>();
//        return wordBreak(s,dict,table);
//    }
//    
//    public ArrayList<String> wordBreak(String s, Set<String> dict, HashMap<String,ArrayList<String>> table){
//    	ArrayList<String> res = new ArrayList<String>();
//    	if(table.containsKey(s)){
//    		return table.get(s);
//    	}
//    	if(s == null || s.equals("")){
//    		 res.add("");
//    		 return res;
//    	}
//    	for(int i =1; i<=s.length(); i++){
//    		String cur = s.substring(0,i);
//    		if(dict.contains(cur)){
//    			String next = s.substring(i,s.length());    			
//    			ArrayList<String> nextValue = wordBreak(next, dict, table);
//    			
//    			if(nextValue != null && !nextValue.isEmpty()){
//    				for(String tmp : nextValue){
//    					if(tmp.equals("")){
//    						res.add(tmp);
//    					}else{
//    						res.add(cur+" "+tmp);
//    					}
//    				}
//    			}
//    			
//    		}
//    	}
//    	table.put(s, res);
//    	return res;
//    }
//}





//public class Solution {
//    public int reverse(int x) {
//        boolean positive = x < 0 ? false : true; ;
//        if(!positive){
//        	x = -x;
//        }
//        
//        long a = x;
//        long b =0;
//        while(a > 0){
//        	b = b*10+(a%10);
//        	a = a/10;
//        }
//        
//        if(!positive){
//        	b= -b;
//        }
//        if(b>Integer.MAX_VALUE){
//        	return Integer.MAX_VALUE;
//        }
//        if(b<Integer.MIN_VALUE){
//        	return Integer.MIN_VALUE;
//        }
//        return (int)b;
//    }
//}





//public class Solution{
//	public void sortArr(int[] arr, int index){
//		if(index < 0 || index > arr.length){
//			return;
//		}
//		
//		sort(arr,0,arr.length-1);
//		sort(arr,0,index-1);
//		sort(arr,index,arr.length-1);
//	}
//	public void sort(int[] arr, int left, int right){
//		int m = (left+right)%2==0? (left+right)/2 : (left+right)/2+1;
//		
//		for(int i =left; i<m ; i++){
//			int tmp = arr[i];
//			arr[i] = arr[right-(i-left)];
//			arr[right-(i-left)] = tmp;
//		}
//	}
//}





//import java.util.ArrayList;
//import java.util.HashSet;
//
//public class Solution {
//    public int ladderLength(String start, String end, HashSet<String> dict) {
//    	if(start.length() != end.length() || dict.size()==0){
//    		return 0;
//    	}
//    	start = start.toLowerCase();
//    	end = end.toLowerCase();
//    	ArrayList<String> visiting = new ArrayList<String>();
//    	ArrayList<Integer> level = new ArrayList<Integer>();
//    	HashSet<String> visited = new HashSet<String>();
//    	visiting.add(start);
//    	level.add(1);
//    	while(!visiting.isEmpty()){
//    		String cur = visiting.remove(0);
//    		int deep = level.remove(0);
//    		if(cur.equals(end)){
//    			return deep;
//    		}else{
//    			getNextW(cur,visited,level,visiting, dict,deep);
//    			
//    		}
//    		
//    	}
//    	
//    	return 0;
//    }
//    
//    
//    public void getNextW(String cur, HashSet<String> visited, ArrayList<Integer> level, ArrayList<String> visiting,HashSet<String> dict,int deep){
//    	char[] arr = cur.toCharArray();
//    	for(int i=0; i<cur.length(); i++){
//    		char now = arr[i];
//    		for(char j = 'a' ; j<='z'; j++){
//    			if(j!=now ){
//    				arr[i]=j;
//    				String res = new String(arr);
//    				if(dict.contains(res)&&!visited.contains(res)){
//    					visited.add(res);
//    					level.add(deep+1);
//    					visiting.add(res);
//    				}
//    				arr[i] = now;
//    			}
//    		}
//    	}
//    }
//}





//public class Solution {
//    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        if(num == null || num.length==0){
//            res.add(new ArrayList<Integer>());
//            return res;
//        }
//        return permute(num, 0);
//    }
//    
//    
//    public ArrayList<ArrayList<Integer>> permute(int[] num, int index){
//        ArrayList<ArrayList<Integer>> res;
//        if(index == num.length-1){
//            res = new ArrayList<ArrayList<Integer>>();
//            ArrayList<Integer> tmp = new ArrayList<Integer>();
//            tmp.add(num[index]);
//            res.add(tmp);
//            return res;
//        }
//        HashSet<ArrayList<Integer>> table = new HashSet<ArrayList<Integer>>();
//        res = permute(num, index+1);
//        ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
//        for(ArrayList<Integer> tmp : res){
//            
//            for(int i =0; i<= tmp.size(); i++){
//                ArrayList<Integer> tmp2 = new ArrayList<Integer>();
//                tmp2.addAll(tmp);
//                tmp2.add(i,num[index]);
//                if(!table.contains(tmp2)){
//                    table.add(tmp2);
//                    res2.add(tmp2);
//                }
//                
//            }
//        }
//        return res2;
//        
//    }
//}





//import java.util.ArrayList;
//
//public class Solution {
//    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//        if(triangle == null || triangle.size() == 0){
//        	return 0;
//        }
//        
//        int[] table = new int[triangle.get(triangle.size()-1).size()];
//        
//        for(int i = triangle.size()-1; i>=0; i--){
//        	for(int j =0; j<triangle.get(i).size(); j++){
//        		if(i == triangle.size()-1){
//        			table[j] = triangle.get(i).get(j);
//        		}else{
//        			table[j] = Math.min(table[j],table[j+1])+triangle.get(i).get(j);
//        		}
//        	}
//        	}
//        
//        return table[0];
//    }
//}





//public class Solution {
//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        
//        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
//    }
//}




//public class Solution {
//    public int singleNumber(int[] A)throws Exception {
//        if(A == null || A.length == 0){
//        	throw new Exception("wrong input!");
//        }
//        
//        int res = 0;
//        
//        for(int n : A){
//        	res ^=n;
//        }
//        
//        return res;
//    }
//}





//public class Solution {
//    public boolean isPalindrome(String s) {
//    	if(s == null || s.length()<=1){
//    		return true;
//    	}
//    	s = s.toLowerCase();
//    	int left = 0;
//    	int right = s.length()-1;
//    	while(left<right){
//    		if(!isChar(s.charAt(left))){
//    			left++;
//    		}else if(!isChar(s.charAt(right))){
//    			right--;
//    		}else if(s.charAt(left) != s.charAt(right)){
//    			return false;
//    		}else{
//    			left++;
//    			right--;
//    		}
//    	}
//    	return true;
//    }
//    
//    public boolean isChar(char word){
//    	if((word >= 'a' && word<='z') || (word >= '0' && word<='9')){
//    		return true;
//    	}else{
//    		return false;
//    	}
//    }
//}





//public class Solution {
//    public int jump(int[] A) {
//        if(A == null || A.length <= 1){
//        	return 0;
//        }
//        int res = 1;
//        int distance = A[0];
//        int next = 0;
//        for(int i =1; i<A.length; i++){
//        	if(distance > 0){
//        		distance--;
//        		
//        		next = Math.max(next-1, A[i]);
//        		
//        		if(distance == 0 && i!=A.length-1){
//        			distance = next;
//            		res++;
//        		}
//        		
//        	}else{
//        		return -1;
//        	}
//        }
//        return res;
//    }
//}





//public class Solution {
//    public boolean canJump(int[] A) {
//        if(A == null || A.length == 0){
//        	return false;
//        }
//        int[] step = new int[A.length];
//        step[0] = A[0];
//        for(int i =1; i<step.length; i++){
//        	step[i] = Math.max(step[i-1]-1, A[i]);
//        	if(step[i-1] == 0){
//        		return false;
//        	}
//        }
//        
//        return true;
//    }
//}





//public class CountCompleteBinayTreeNodes {
//    public int countNodes(TreeNode root) {
//    	if(TreeNodeUtil.isNullNode(root)){
//    		return 0;
//    	}
//    	
//    	int hieghtl = countDeep(TreeNodeUtil.getLeftChildNode(root));
//    	int hieghtr = countDeep(TreeNodeUtil.getRightChildNode(root));
//        return hieghtl == hieghtr ? (1<<hieghtl) + countNodes(TreeNodeUtil.getRightChildNode(root)) : (1<<hieghtr) + countNodes(TreeNodeUtil.getLeftChildNode(root));
//    }
//    
//    public int countDeep(TreeNode root){
//    	int hieght = 0;
//    	while(!TreeNodeUtil.isNullNode(root)){
//    		hieght++;
//    		root = TreeNodeUtil.getLeftChildNode(root);
//    	}
//    	return hieght;
//    }
//}





//import java.util.Arrays;
//
//class Solution { 
//    public int threeSumClosest(int[] numbers, int target) { 
//    	if(numbers == null || numbers.length <= 2)return 0;
//    	Arrays.sort(numbers);
//    	int minValue= Integer.MIN_VALUE;
//    	for(int i=0; i<numbers.length-2; i++){
//    		int left = i+1;
//    		int right = numbers.length-1;
//    		while(left < right){
//    			int sum = numbers[i]+numbers[left]+numbers[right];
//    			if(Math.abs(target - sum) < Math.abs(target - minValue)){
//    				minValue = sum;
//    			}
//    			
//    			if(sum > target){
//    				right--;
//    			}else if(sum < target){
//    				left++;
//    			}else{
//    				return sum;
//    			}
//    		}
//    	}
//    	return minValue;
//    } 
//}





//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//
//class Solution { 
//    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers, int target) { 
//    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//    	if(numbers==null || numbers.length==0){
//    		res.add(new ArrayList<Integer>());
//    		return res;
//    	}
//    	Arrays.sort(numbers);
//    	
//    	HashSet<ArrayList<Integer>> table = new HashSet<ArrayList<Integer>>();
//    	for(int i =0; i<numbers.length-2; i++){
//    		int left =i+1;
//    		int right = numbers.length-1;
//    		while(left<right){
//    			int sum = numbers[i]+numbers[left]+numbers[right];
//    			if(sum>target){
//    				right--;
//    			}else if(sum < target){
//    				left++;
//    			}else{
//    				ArrayList<Integer> tmp = new ArrayList<Integer>();
//    				tmp.add(numbers[i]);
//    				tmp.add(numbers[left]);
//    				tmp.add(numbers[right]);
//    				if(!table.contains(tmp)){
//    					table.add(tmp);
//    					res.add(tmp);
//    				}
//    				right--;
//    				left++;
//    			}
//    		}
//    	}
//    	return res;
//    } 
//}





//import java.util.ArrayList;
//import java.util.HashMap;
//
//class Solution { 
//    public ArrayList<Integer> twoSum(int[] numbers, int target) { 
//    	if(numbers == null || numbers.length <= 1){
//    		return new ArrayList<Integer>();
//    	}
//    	
//    	HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
//    	ArrayList<Integer> res = new ArrayList<Integer>();
//    	for(int i =0; i<numbers.length; i++){
//    		int rest = target-numbers[i];
//    		if(table.containsKey(numbers[i])){
//    			res.add(table.get(numbers[i])+1);
//    			res.add(i+1);
//    			break;
//    		}else{
//    			
//    			table.put(rest, i);
//    		}
//    	}
//    	return res;
//    } 
//}





//import java.util.ArrayList;
//import java.util.HashSet;
//
//class Solution { // permute II 
//    public ArrayList<ArrayList<Integer>> permute(int[] num) { 
//    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//    	res.add(new ArrayList<Integer>());
//    	HashSet<ArrayList> table = new HashSet<ArrayList>();
//    	if(num==null || num.length==0){
//    		return res;
//    	}
//    	
//    	
//    	return permute2(num,0,table);
//    } 
//    public ArrayList<ArrayList<Integer>> permute2(int[] num, int index, HashSet<ArrayList> table){
//    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//    	
//    	if(index == num.length-1){
//    		ArrayList<Integer> tmp2 = new ArrayList<Integer>();
//    		tmp2.add(num[num.length-1]);
//    		res.add(tmp2);
//    		return res;
//    	}
//    	ArrayList<ArrayList<Integer>> res2 = permute2(num,index+1,table);
//    	
//    	for(ArrayList<Integer> tmp : res2){
//    		for(int i=0; i<=tmp.size(); i++){
//    			ArrayList<Integer> tmp2 = new ArrayList<Integer>();
//    			tmp2.addAll(tmp);
//    			tmp2.add(i, num[index]);
//    			if(!table.contains(tmp2)){
//    				table.add(tmp2);
//    				res.add(tmp2);
//    			}
//    		}
//    	}
//    	return res;
//    }
//}





//public class Solution {
//    public int longestConsecutive(int[] num) {
//        if(num == null || num.length==0)
//        return 0;
//        
//        HashSet<Integer> table = new HashSet<Integer>();
//        
//        for(int tmp : num){
//            table.add(tmp);
//        }
//        int maxNum = 0;
//        
//        for(int i=0; i<num.length; i++){
//            if(table.contains(num[i])){
//                int a= getnum(num[i],table,true);
//                int b = getnum(num[i]+1,table,false);
//                if(a+b > maxNum){
//                    maxNum = a+b ;
//                }
//            }
//        }
//        return maxNum;
//    }
//    
//    public int getnum(int key, HashSet<Integer> table, boolean goLeft){
//        int count = 0;
//        while(table.contains(key)){
//            count++;
//            table.remove(key);
//            if(goLeft){
//                key--;
//            }else{
//                key++;
//            }
//        }
//        return count;
//        
//        
//    }
//}





//import java.awt.Point;
//import java.util.HashMap;
//
//public class Solution {
//    public int maxPoints(Point[] points) {
//        // IMPORTANT: Please reset any member data you declared, as
//        // the same Solution instance will be reused for each test case.
//        if(points == null || points.length == 0){
//        	return 0;
//        }
//        int maxPoints = 0;
//        
//        for(int i =0; i<points.length; i++){
//        	Point cur = points[i];
//        	int samePoints = 0;
//            int verticalPoints = 0;
//            int maxp = 0;
//        	HashMap<Float,Integer> table = new HashMap<Float,Integer>();
//        	for(int j= i+1; j<points.length; j++){
//        		Point tmp = points[j];
//        		if(cur.x == tmp.x && cur.y == tmp.y){
//        			samePoints++;
//        		}else if(cur.x == tmp.x){
//        			verticalPoints ++;
//        			if(verticalPoints > maxp){
//        				maxp = verticalPoints;
//        			}
//        		}else{
//        			float angol = (float)(cur.y-tmp.y)/(float)(cur.x-tmp.x);
//        			if(angol == -0.0){
//        			    angol = 0;
//        			}
//        			if(table.containsKey(angol)){
//        				table.put(angol, table.get(angol)+1);
//        			}else{
//        				table.put(angol, 1);	
//    				}
//        			if(table.get(angol)>maxp){
//    					maxp = table.get(angol);
//    				}
//        		} 
//        	}
//        	if(maxPoints<maxp+samePoints){
//        		maxPoints = maxp+samePoints;
//        	}
//        	
//        }
//        return maxPoints+1;
//    }
//}

//public class Solution {
//    public int maxPoints(Point[] points) {
//        // IMPORTANT: Please reset any member data you declared, as
//        // the same Solution instance will be reused for each test case.
//        if(points == null || points.length == 0){
//        	return 0;
//        }
//        int maxPoints = 0;
//        
//        for(int i =0; i<points.length; i++){
//        	Point cur = points[i];
//        	int samePoints = 0;
//            int verticalPoints = 0;
//            int maxp = 0;
//        	HashMap<Float,Integer> table = new HashMap<Float,Integer>();
//        	for(int j= 0; j<points.length; j++){
//        		Point tmp = points[j];
//        		if(cur.x == tmp.x && cur.y == tmp.y){
//        			samePoints++;
//        		}else if(cur.x == tmp.x){
//        			verticalPoints ++;
//        			if(verticalPoints > maxp){
//        				maxp = verticalPoints;
//        			}
//        		}else{
//        			float angol = (float)(cur.y-tmp.y)/(float)(cur.x-tmp.x);
//        			if(table.containsKey(angol)){
//        				table.put(angol, table.get(angol)+1);
//        			}else{
//        				table.put(angol, 1);	
//    				}
//        			if(table.get(angol)>maxp){
//    					maxp = table.get(angol);
//    				}
//        		} 
//        	}
//        	if(maxPoints<maxp+samePoints){
//        		maxPoints = maxp+samePoints;
//        	}
//        	
//        }
//        return maxPoints;
//    }
//}





//Shuffle an array
//
//
//import java.util.Random;
//
//public class Solution{
//	public void shuffle(int[] arr, int n){
//		if(n>0){
//			for(int i = n; i>0; i--){
//				Random generator = new Random();
//				int j = generator.nextInt(i);
//				System.out.println("j "+j);
//				swap(i,j,arr);
//				for(int h =0; h<arr.length; h++){
//					System.out.print(arr[h]);
//				}
//			}
//		}
//	}
//	
//	public void swap(int i, int j, int[] arr){
//		int tmp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = tmp;
//	}
//}





//public class Solution {
//    public int evalRPN(String[] tokens) {
//        java.util.Stack<Integer> sTokens = new java.util.Stack<Integer>();
//        for(int i = 0; i < tokens.length; i++)
//        {
//            if (tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && 
//tokens[i] != "/")
//            {
//                int currInt = Integer.parseInt(tokens[i]);
//                sTokens.push(currInt);
//            }
//            else
//            {
//                int int2 = sTokens.pop();
//                int int1 = sTokens.pop();
//                int int3 = 0;
//                if (tokens[i] == "+")
//                {
//                    int3 = int1 + int2;
//                }
//                if (tokens[i] == "-")
//                {
//                    int3 = int1-int2;
//                }
//                if (tokens[i] == "*")
//                {
//                    int3 = int1 * int2;
//                }
//                if (tokens[i] == "/")
//                {
//                    int3 = int1/int2;
//                }
//                sTokens.push(int3);
//            }
//        }
//        return sTokens.pop();
//    }
//}





//import java.util.Stack;
//
//public class Solution {
//    public int evalRPN(String[] tokens) {
//       if(tokens == null || tokens.length == 0)return 0;
//       
//       Stack<Integer> table = new Stack<Integer>();
//       for(String n : tokens){
//           if(isNumber(n)){
//               table.push(Integer.valueOf(n));
//           }else{
//               if(table.size()<2) return -1;
//               int b = table.pop();
//               int a = table.pop();
//               table.push(count(a,b,n));
//           }
//       }
//       if(table.size() != 1){
//           return -1;
//       }else{
//           return table.pop();
//       }
//    }
//    
//    public boolean isNumber(String n){
//    	if(n.equals("+") || n.equals("*") || n.equals("-") || n.equals("/")){
//    		return false;
//    	}else{
//    		return true;
//    	}
//    }
//    
//    public int count(int a, int b, String n){
//    	if(n.equals("+")){
//    		return a+b;
//    	}else if(n.equals("-")){
//    		return a-b;
//    	}else if(n.equals("*")){
//    		return a*b;
//    	}else if(n.equals("/")){
//    		return a/b;
//    	}else{
//    		return -1;
//    	}
//    }
//}





//public class Solution {
//    public ListNode sortList(ListNode head) {
//        // IMPORTANT: Please reset any member data you declared, as
//        // the same Solution instance will be reused for each test case.
//        if(head == null || head.next == null){
//        	return head;
//        }
//        ListNode p1 = head;
//        ListNode p2 = head.next.next;
//        
//        while(p2 != null && p2.next != null){
//        	p1 = p1.next;
//        	p2 = p2.next.next;
//        }
//        ListNode ne = p1.next;
//        p1.next = null;
//        return (mergeSort(sortList(head),sortList(ne)));
//    }
//    
//    public ListNode mergeSort(ListNode r1, ListNode r2){
//    	ListNode root = new ListNode(-1);
//    	ListNode pre = root;
//    	while(r1 != null && r2 != null){
//    		if(r1.val < r2.val){
//    			root.next = r1;
//    			r1 = r1.next;
//    			root = root.next;
//    		}else{
//    			root.next = r2;
//    			r2 = r2.next;
//    			root = root.next;
//    		}
//    	}
//    	if(r1 != null){
//    		root.next = r1;
//    	}else{
//    		root.next = r2;
//    	}
//    	return pre.next;
//    	
//    }
//}





//import java.util.ArrayList;
//import java.util.List;
//
//import java.util.Stack;
//
//public class Solution{
//	public int calculate(String str)throws Exception{
//		if(str == null || str.length() == 0){
//			return 0;
//		}
//		Stack<Character> table = new Stack<Character>();
//		StringBuffer res = new StringBuffer();
//		switch (str.charAt(0)){
//		case '+' : case '-':
//			break;
//		case '/':
//			break;
//		default:
//			break;
//		}
//		if(true){
//			throw new Exception("asdasd");
//		}
//		for(int i =0; i<str.length(); i++){
//			if(str.charAt(i)<='9' && str.charAt(i)>='0'){
//				res.append(str.charAt(i));
//			}else if(str.charAt(i)=='('){
//				table.add(str.charAt(i));
//			}else if(str.charAt(i) == '+' || str.charAt(i)=='-' || str.charAt(i) == '*' || str.charAt(i) == '/'){
//				while(!table.isEmpty() && getPriority(table.peek())>= getPriority(str.charAt(i))){
//					res.append(table.pop());
//				}
//				table.add(str.charAt(i));
//			}else if(str.charAt(i) == ')'){
//				while(table.peek() != '('){
//					res.append(table.pop());
//				}
//				table.pop();
//			}
//		}
//		while(!table.isEmpty()){
//			res.append(table.pop());
//		}
//		System.out.println("POST "+res.toString());
//		return calculatePostFix(res.toString());
//	}
//	
//	public int getPriority(char input){
//		if(input == '+' || input=='-'){
//			return 1;
//		}else if(input == '*' || input == '/'){
//			return 2;
//		}else{
//			return 0;
//		}
//	}
//	
//	public int calculatePostFix(String str){
//		if(str == null || str.length()==0)return 0;
//		Stack<Integer> table = new Stack<Integer>();
//		for(int i=0; i<str.length() ; i++){
//			if(str.charAt(i)<='9' && str.charAt(i)>='0'){
//				table.add(str.charAt(i)-'0');
//			}else if(table.size()<2){
//				return -1;
//			}else{
//				int sum = getValue(table,str.charAt(i));
//				System.out.println("sum "+sum);
//				table.add(sum);
//			}
//			System.out.println(table.peek());
//		}
//		if(table.size() != 1){
//			return -1;
//		}
//		return table.pop();
//	}
//	
//	public int getValue(Stack<Integer> table, char cha){
//		int b = table.pop();
//		int a = table.pop();
//		if(cha == '+'){
//			return a+b;
//		}else if(cha == '-'){
//			return a-b;
//		}else if(cha == '*'){
//			return a*b;
//		}else{
//			return a/b;
//		}
//	}
//}
//
//public class Solution{
//	 
//}



//import java.util.HashSet;
//
//public class Solution {
//    public int[] longestConsecutive(int[] num) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//    	int[] bound = new int[2];
//    	if(num == null || num.length == 0)return bound;
//    	
//    	HashSet<Integer> table = new HashSet<Integer>();
//    	for(int tmp : num){
//    		table.add(tmp);
//    	}
//    	int maxNum = Integer.MIN_VALUE;
//    	
//    	for(int i =0; i<num.length && !table.isEmpty(); i++){
//    		int res = 0;
//    		int[] resarrleft = new int[2];
//    		int[] resarrright = new int[2];
//    		if(table.contains(num[i])){
//    			resarrleft = get(num[i],table,true);
//    			res += resarrleft[0];
//    		}
//    		if(table.contains(num[i]+1)){
//    			resarrright = get(num[i]+1,table,false);
//    			res += resarrright[0];
//    		}
//    		if(res>maxNum){
//    			maxNum = res;
//    			bound[0] = resarrleft[1];
//    			bound[1] = resarrright[1];
//    		}
//    	}
//    	return bound;
//    }
//    public int[] get(int num, HashSet<Integer> table, boolean goLeft){
//    	int[] res = new int[2];
//    	while(table.contains(num)){
//    		res[0]++;
//    		table.remove(num);
//    		res[1]=num;
//    		if(goLeft){
//    			num--;
//    		}else{
//    			num++;
//    		}
//    	}
//    	return res;
//    }
//}






//import java.util.HashSet;
//
//public class Solution {
//    public int longestConsecutive(int[] num) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//    	if(num == null || num.length == 0)return 0;
//    	
//    	HashSet<Integer> table = new HashSet<Integer>();
//    	for(int tmp : num){
//    		table.add(tmp);
//    	}
//    	int maxNum = Integer.MIN_VALUE;
//    	for(int i =0; i<num.length && !table.isEmpty(); i++){
//    		int res = 0;
//    		if(table.contains(num[i])){
//    			res+=get(num[i],table,true);
//    		}
//    		if(table.contains(num[i]+1)){
//    			res+=get(num[i]+1,table,false);
//    		}
//    		if(res>maxNum){
//    			maxNum = res;
//    		}
//    	}
//    	return maxNum;
//    }
//    public int get(int num, HashSet<Integer> table, boolean goLeft){
//    	int res = 0;
//    	while(table.contains(num)){
//    		res++;
//    		table.remove(num);
//    		if(goLeft){
//    			num--;
//    		}else{
//    			num++;
//    		}
//    	}
//    	return res;
//    }
//}





//public class Solution{
//	public void getPrime(int n){
//		if(n<=0)return ;
//		int[] table = new int[n+1];
//		
//		for(int i =2; i<=n ;i++){
//			if(table[i]==0){
//				System.out.println("Prime Integer: "+i);
//				table[i]=1;
//				if(i<=Math.sqrt(n)){
//					int k = i;
//					while(i*k<=n){
//						table[i*k]=1;
//						k++;
//					}
//				}
//				
//			}else{
//				continue;
//			}
//		}
//	}
//}





//import java.util.ArrayList;
//
//public class Solution{
//	public int getPrime(int n){
//		if(n<=0){
//			return 0;
//		}
//		ArrayList<Integer> table = new ArrayList<Integer>();
//		int k = 1;
//		LOOP:
//		while(n>0){
//			k++;
//			for(int i =0; i<table.size() && table.get(i)*table.get(i)<=k; i++){
//				if(k%table.get(i)==0){
//					continue LOOP;
//				}
//			}
//			table.add(k);
//			n--;
//		}
//		return table.get(table.size()-1);
//	}
//}





//Flatten Binary Tree to Linked List
//

//public class Solution {
//    public void flatten(TreeNode root) {
//        // IMPORTANT: Please reset any member data you declared, as
//        // the same Solution instance will be reused for each test case.
//        if(root == null)return ;
//        Stack<TreeNode> stac = new Stack<TreeNode>();
//        Stack<TreeNode> stac2 = new Stack<TreeNode>();
//        stac.push(root);
//        while(!stac.isEmpty()){
//            TreeNode cur = stac.pop();
//            stac2.push(cur);
//            if(cur.right != null){
//                stac.push(cur.right);
//            }
//            if(cur.left != null){
//                stac.push(cur.left);
//            }
//        }
//        stac2.peek().right = null;
//        while(!stac2.isEmpty()){
//            TreeNode cur = stac2.pop();
//            TreeNode peek = stac2.isEmpty()? null : stac2.peek();
//            cur.left = null;
//            if(peek != null){
//                peek.right = cur;
//            }
//        }
//    }
//    
//}





//public class LinkListSort {
//    public ListNode sort(ListNode head) {
//    	if(head == null || head.next == null){
//    		return head;
//    	}
//    	
//    	ListNode point1 = head;
//    	ListNode point2 = head;
//    	while(point2 != null && point2.next != null){
//    		point1 = point1.next;
//    		point2 = point2.next.next;
//    	}
//    	ListNode next = point1.next;
//    	point1.next = null;
//    	merge(sort(head),sort(next));
//    }
//    
//    public ListNode merge (ListNode root1, ListNode root2){
//    	if(root1 == null){
//    		return root2;
//    	}else if(root2 == null){
//    		return root1;
//    	}
//    	
//    	ListNode head = new ListNode();
//    	ListNode cur = head;
//    	while(root1 != null && root2 != null){
//    		if(root1.val >= root2.val){
//    			cur.next = root1;
//    			root1 = root1.next;
//    			cur = cur.next;
//    		}else{
//    			cur.next = root2;
//    			root2 = root2.next;
//    			cur = cur.next;
//    		}
//    	}
//    	if(root1 != null){
//    		cur.next = root1;
//    	}else if(root2 != null){
//    		cur.next = root2;
//    	}
//    	return head.next;
//    }
//}





//gas station
//
//
//public class Solution {
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        // IMPORTANT: Please reset any member data you declared, as
//        // the same Solution instance will be reused for each test case.
//        int n = gas.length;
//        
//        int start = 0;
//        int cur = 0;
//        int end = 0;
//        int sum = 0;
//        int i = 0;
//       
//        while(i<n){
//            sum +=gas[cur] - cost[cur];
//            if(sum < 0){
//                if(start == 0){
//                    start = n-1;
//                }else{
//                    start --;
//                }
//                
//                cur = start;
//            }else{
//                end++;
//                cur = end;
//            }
//            i++;
//            
//        }
//        if(sum<0){
//            return -1;
//        }else{
//            return start;
//        }
//    }
//}





//import java.util.HashMap;
//
//public class Solution{
//	public int fiboIter(int n){
//		if(n<=1){
//			return n;
//		}
//		int[] res = new int[n+1];
//		res[0]=0;
//		res[1]=1;
//		for(int i =2; i<=n; i++){
//			res[i]=res[i-1]+res[i-2];
//		}
//		return res[n];
//	}
//	private HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
//	public int fiboRecur(int n){
//		if(n<=1){
//			return n;
//		}
//		if(table.containsKey(n)){
//			return table.get(n);
//		}
//		int res = fiboRecur(n-1)+fiboRecur(n-2);
//		table.put(n, res);
//		return res;
//	}
//}


//Find the maximum length of consecutive ones in a nxm matrix which has only 0's and 1's.
//
//
//public class Solution{
//	public int findones(int[][] arr){
//		if(arr == null || arr.length == 0 || arr[0].length == 0)return 0;
//		
//		int[][] table = new int[arr.length][arr[0].length];
//		
//		int count = 0;
//		int maxLen = 0;
//		for(int i =0; i<arr.length ; i++){
//			for(int j=0; j<arr[0].length ; j++){
//				if(table[i][j] != 1){
//					if(arr[i][j] == 1){
//						count = getOne(arr,i,j,table);
//						if(count > maxLen){
//							maxLen = count;
//						}
//					}
//					table[i][j] = 1;
//				}
//			}
//		}
//		return maxLen;
//	}
//	
//	public int getOne(int[][] arr, int i, int j, int[][] table){
//		if(i<0||i>=arr.length||j<0||j>=arr[0].length||arr[i][j]==0 || table[i][j]==1){
//			return 0;
//		}else{
//			table[i][j]=1;
//			return 1+getOne(arr,i+1,j,table)+getOne(arr,i,j+1,table)+getOne(arr,i,j-1,table)+getOne(arr,i-1,j,table);
//		}
//	}
//}





//Binary Tree Postorder Traversal 
//
//
//public class Solution {
//    public ArrayList<Integer> postorderTraversal(TreeNode root) {
//        // IMPORTANT: Please reset any member data you declared, as
//        // the same Solution instaxzcnce will be reused for each test case.
//        Stack<TreeNode> sta = new Stack<TreeNode>();
//        Stack<TreeNode> sta2 = new Stack<TreeNode>();
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        if(root == null){
//            return res;
//        }
//        sta.push(root);		
//        while(!sta.isEmpty()){
//            TreeNode cur = sta.pop();
//            sta2.push(cur);
//            if(cur.left != null){
//                sta.push(cur.left);
//            }
//            if(cur.right != null){
//                sta.push(cur.right);
//            }
//        }
//        while(!sta2.isEmpty()){
//            res.add(sta2.pop().val);
//        }
//        return res;
//    }
//}





//public class Solution {
//    public int atoi(String str) {
//        // IMPORTANT: Please reset any member data you declared, as
//        // the same Solution instance will be reused for each test case.
//        str = str.trim();
//        if(str == null || str.length()==0){
//            return 0;
//        }
//        long value=0;
//        boolean positive = true;
//        for(int i =0 ; i<str.length(); i++){
//            if(i==0 && str.charAt(i)=='-'){
//                positive = false;
//                continue;
//            }else if(i==0 && str.charAt(i)=='+'){
//                positive = true;
//                continue;
//            }
//            if(str.charAt(i)>'9'||str.charAt(i)<'0'){
//                break;
//            }
//            value = value*10+str.charAt(i)-'0';
//        }
//        if(!positive){
//            value = value*(-1);
//        }
//        if(value < Integer.MIN_VALUE){
//            return Integer.MIN_VALUE;
//        }
//        if(value > Integer.MAX_VALUE){
//            return Integer.MAX_VALUE;
//        }
//        return (int)value;
//    }
//}





//public class Solution{
//	public DoubleLinkedListNode removeMid(DoubleLinkedListNode root){
//		if(root == null || root.next == null){
//			return null;
//		}
//		DoubleLinkedListNode point1 = root;
//		DoubleLinkedListNode point2 = root;
//		while(point2 != null && point2.next != null){
//			point2 = point2.next.next;
//			point1 = point1.next;
//		}
//		
//		DoubleLinkedListNode pre = point1.pre;
//		DoubleLinkedListNode post = point1.next;
//		pre.next = post;
//		post.pre = pre;
//		return root;
//		
//	}
//}





//import java.util.HashSet;
//
//public class Solution{
//	public LinkedListNode reversNodeRecursion(LinkedListNode root){
//		if(root == null || root.next == null){
//			return root;
//		}
//		
//		LinkedListNode head = reversNodeRecursion(root.next);
//		LinkedListNode next = root.next;
//		next.next = root;
//		root.next = null;
//		return head;
//	}
//	
//	public LinkedListNode reversNodeIter(LinkedListNode root){
//		
//		if(root == null || root.next == null){
//			return root;
//		}
//		
//		LinkedListNode head = root;
//		LinkedListNode post = root.next;
//		while(post != null){
//			LinkedListNode next = post.next;
//			post.next = head;
//			head = post;
//			post = next;
//			
//		}
//		root.next = null;
//		return head;
//		
//	}
//}





//class Solution{
//	public int sqrt(int x) {
//        // IMPORTANT: Please reset any member data you declared, as
//        // the same Solution instance will be reused for each test case.
//        if(x<0){
//    		return -1;
//    	}
//        long left = 0;
//        long right = x;
//        long xx = x;
//        while(left <= right){
//        	long mid = (left+right)/2;
//            if(mid*mid<=xx &&(mid+1)*(mid+1)>xx){
//                return (int)mid;
//            }else if(mid*mid > xx){
//                right = mid-1;
//            }else{
//                left = mid+1;
//            }
//        }
//        return -1;
//    }
//	
//}

//Single Number II
//
//
//public class Solution {
//    public int singleNumber(int[] A) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        int a = 0; int b = 0; int c = 0;
//        for(int i=0;i<A.length; i++){
//        	  b |= a&A[i];  //鍑虹幇涓ゆ鐨�灏卞姞鍒癇閲岄潰
//              a ^= A[i];    //浠嶢閲岄潰鍒犻櫎 鍑虹幇涓ゆ鐨�
//              c = ~(a&b);   //濡傛灉鏄笁娆＄殑 灏变細鍚屾椂鍑虹幇鍦ˋ鍜孊閲岄潰锛�
//              a &= c;       //鐒跺悗鍒犻櫎A閲屼笁娆＄殑
//              b &= c;       //鍒犻櫎B閲屼笁娆＄殑
//        }
//        return a;
//    }
//}




//public class Solution {
//    public ArrayList<ArrayList<String>> findLadders(String start, String end,
//   HashSet<String> dict) {
//  // Start typing your Java solution below
//  // DO NOT write main() function
//  ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
//
//  Queue<Node> queue = new LinkedList<Node>();
//  queue.offer(new Node(start, null));
//  HashSet<String> unique = new HashSet<String>();
//        boolean first = false;
//        int min = Integer.MIN_VALUE;
//
//  while (!queue.isEmpty()) {
//   Node n = queue.poll();
//   String s = n.c;
//
//   Sign: for (int i = 0; i < s.length(); i++) {
//    for (char c = 'a'; c <= 'z'; c++) {
//     StringBuilder sb = new StringBuilder(s);
//     sb.setCharAt(i, c);
//     String t = sb.toString();
//     if (t.equals(end)) {
//      ArrayList<String> match = new ArrayList<String>();
//      match.add(end);
//      while (n != null) {
//       match.add(0, n.c);
//       n = n.p;
//      }
//                        if(!first){
//                first = true;
//                            min = match.size();
//      } else{
//             if(match.size()>min) return res;   
//      }
//      res.add(match);
//      
//     }
//
//     if (!unique.contains(t) && dict.contains(t)) {
//      queue.offer(new Node(t, n));
//                        unique.add(s);
//     }
//    }
//   }
//  }
//
//  return res;
// }
//
// static class Node {
//
//  public String c;
//  public Node p;
//
//  public Node(String c, Node p) {
//   this.c = c;
//   this.p = p;
//  }
// }
//}





//public class Solution {
//    public int divide(int dividend, int divisor) {
//        // IMPORTANT: Please reset any member data you declared, as
//        // the same Solution instance will be reused for each test case.
//        assert(divisor!=0);
//        boolean positive = true;
//        long divisor1 = divisor;
//        long dividend1 = dividend;
//        if(dividend1 <0){
//            dividend1 = -dividend1;
//            positive = !positive;
//        }
//        if(divisor1 < 0 ){
//            divisor1 = - divisor1;
//            positive = !positive;
//        }
//        
//        int carry = 0;
//        while((divisor1<<carry)<=dividend1){
//            carry++;
//        }
//        carry--;
//        int res = 0;
//        for(int i = carry; i>=0; i--){
//            if((divisor1<<i)<=dividend1){
//                res+=(1<<i);
//                dividend1 -= (divisor1<<i);
//                
//            }
//        }
//        return positive == true ? res : -(res);
//    }
//}




//public class Solution{
//	public LinkedListNode swapNode(LinkedListNode head, int n){
//		if(head == null || head.next == null || n == 1)return head;
//		LinkedListNode pre = head;
//		int m = n;
//		for(int i=0; i<n-2; i++){
//			
//			pre = pre.next;
//			if(pre == null){
//				return head;
//			}
//			m--;
//		}
//		
//		LinkedListNode cur = pre.next;
//		if(cur == null){
//			return head;
//		}
//		LinkedListNode next = cur.next;
//		if(pre != head){
//			
//			pre.next = head;
//			cur.next = head.next;
//			head.next = next;
//		}else{
//			cur.next =head;
//			head.next = next;
//		}
//		
//		return cur;
////		LinkedListNode pre = new LinkedListNode(-1);
////		pre.next = head;
////		LinkedListNode cur = head;
////		int m = n;
////		while(m>1 && cur!= null){
////			cur = cur.next;
////			pre = pre.next;
////			m--;
////		}
////		if(m>1){
////			return head;
////		}
////		LinkedListNode next = cur.next;
////		cur.next =head.next;
////		head.next = next;
////		if(pre != next) pre.next = head;
////		return cur;
//	}
//
//}





//Surrounded Regions
//
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Solution {
//    
//    public void solve(char[][] board) {
//        if (board==null || board.length<1)
//            return;
//        boolean[][] visit = new boolean[board.length][board[0].length];
//        for (int i=0; i<board.length; i++)
//            for (int j=0; j<board[i].length; j++)
//                if (board[i][j]=='O' && !visit[i][j] && (i==0||j==0||i==board.length-1||j==board[j].length-1)) {
//                    Queue<Point> queue = new LinkedList<Point>();
//                    queue.add(new Point(i, j));
//                    visit[i][j] = true;
//                    while (!queue.isEmpty()) {
//                        Point point = queue.poll();
//                        if (point.j>0 && board[point.i][point.j-1]=='O' && !visit[point.i][point.j-1]) {
//                            queue.add(new Point(point.i, point.j-1));
//                           visit[point.i][point.j-1] = true; //add code here
//                        }
//                        if (point.j<board[point.i].length-1 && board[point.i][point.j+1]=='O' && !visit[point.i][point.j+1]) {
//                            queue.add(new Point(point.i, point.j+1));
//                           visit[point.i][point.j+1] = true;//add code here
//                        }
//                        if (point.i>0 && board[point.i-1][point.j]=='O' && !visit[point.i-1][point.j]) {
//                            queue.add(new Point(point.i-1, point.j));
//                            visit[point.i-1][point.j] = true;//add code here
//                        }
//                        if (point.i<board.length-1 && board[point.i+1][point.j]=='O' && !visit[point.i+1][point.j]) {
//                            queue.add(new Point(point.i+1, point.j));
//                           visit[point.i+1][point.j] = true;//add code here
//                        }
//                    }
//                }
//        for (int i=0; i<board.length; i++)
//            for (int j=0; j<board[i].length; j++)
//                if (visit[i][j])
//                    board[i][j] = 'O';
//                else
//                    board[i][j] = 'X';
//    }
//}
//class Point {
//    public int i;
//    public int j;
//    public Point(int ii, int jj) {
//        this.i = ii;
//        this.j = jj;
//    }
//}





//Regular Expression Matching
//
//
//public class Solution {
//    public boolean isMatch(String s, String p) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        assert(p!=null && (p.length()==0 || p.charAt(0)!='*'));
//        
//        if(p.length()==0) return s.length()==0;
//        
//        if(p.length()==1 || p.charAt(1)!='*'){
//            if(s.length()<1 || (p.charAt(0)!='.' && p.charAt(0)!=s.charAt(0))) 
//                return false;
//            return isMatch(s.substring(1),p.substring(1));
//        }else{
//            int i=-1;
//            while(i<s.length() && (i<0 || p.charAt(0)=='.' || p.charAt(0)==s.charAt(i))){
//                if(isMatch(s.substring(i+1),p.substring(2))) 
//                    return true;
//                i++;
//            }
//            return false;
//        }
//        
//    }
//}





//Longest Palindromic Substring
//
//
//public class Solution {
//    public String longestPalindrome(String s) {
//        int length = s.length();
//        String result = "";
//        for (int i = 0; i < length; i++) {
//            String ps = getPalindrome(s, i, i);
//                if (ps.length() > result.length()) {
//        	    result = ps;
//        	}
//        	ps = getPalindrome(s, i, i + 1);
//        	if (ps.length() > result.length()) {
//        	    result = ps;
//        	}
//        }
//        return result;
//    }
//
//    private String getPalindrome(String s, int l, int r) {
//	while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
//	    l--;
//	    r++;
//	}
//	return s.substring(l + 1, r);
//    }
//}





//Search in Rotated Sorted Array II
//
//
//public class Solution {
//    public boolean search(int[] A, int target) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        
//   return search2(A,target,0,A.length-1);
//    }
//    public boolean search2(int[] A, int target, int left, int right){
//        if(left>right){
//            return false;
//        }
//        int mid = (left+right)/2;
//        
//        if(A[mid] == target){
//            return true;
//        }
//        
//        if(A[left] > A[mid]){
//            if(target < A[mid] || target >= A[left]){
//                return search2(A, target, left, mid-1);
//            }else{
//                return search2(A, target, mid+1, right);
//            }
//        }else if(A[left]< A[mid]){
//            if(target<A[mid] && target>=A[left]){
//                return search2(A, target, left, mid-1);
//            }else{
//                return search2(A, target,mid+1,right);
//            }
//        }else{
//            if(A[right]!=A[mid]){
//                return search2(A,target,mid+1,right);
//            }else{
//                boolean temp = search2(A,target,left,mid-1);
//                return temp==false ?search2(A,target,mid+1,right):temp;
//            }
//        }
//    }
//}





//import java.util.LinkedList;
//import java.util.List;
//
//public class Solution{
//	
//	private List queue = new LinkedList();
//	  private int  limit = 10;
//
//	  public Solution(int limit){
//	    this.limit = limit;
//	  }
//	public synchronized void enqueue(int value) throws InterruptedException{
//		if(queue.size() == limit){
//			wait();
//		}
//	}
//}





//public class Solution {
//    public String minWindow(String S, String T) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        int slen = S.length();
//        int tlen = T.length();
//        if(slen<tlen){
//            return "";
//        }
//        
//        int[] tarr = new int[256];
//        int[] window = new int[256];
//        
//        for(int i =0; i<tlen; i++){
//        	window[T.charAt(i)]++;
//        }
//        int end=0;
//        int start = 0;
//        int minLen=Integer.MAX_VALUE;
//        int minStart = 0;
//        int count = 0;
//        for(;end<slen;end++){
//        	if(window[S.charAt(end)] == 0){
//        		continue;
//        	}
//        	if(++tarr[S.charAt(end)]<=window[S.charAt(end)]){
//        		count++;
//        	}
//        	if(count == tlen){
//        		while(tarr[S.charAt(start)]>window[S.charAt(start)] || window[S.charAt(start)]==0){
//        			if(tarr[S.charAt(start)]>window[S.charAt(start)] ){
//        				tarr[S.charAt(start)]--;
//        			}
//        			start++;
//        			
//        		}
//        		int llen= end-start+1;
//        			if(llen < minLen){
//        				minLen = llen;
//        				minStart = start;
//        			}
//        	
//        	}
//        
//        }
//        if(minLen<=slen){
//        	return S.substring(minStart, minStart+minLen);
//        }else{
//        	return "";
//        }
//        
//    }
//}





//Copy List with Random Pointer 
//
//
///**
// * Definition for singly-linked list with a random pointer.
// * class RandomListNode {
// *     int label;
// *     RandomListNode next, random;
// *     RandomListNode(int x) { this.label = x; }
// * };
// */
//public class Solution {
//    public RandomListNode copyRandomList(RandomListNode head) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        if(head==null)return head;
//        RandomListNode curhead = head;
//        while(curhead != null){
//            RandomListNode next = curhead.next;
//            RandomListNode newOne = new RandomListNode(curhead.label);
//            newOne.next = next;
//            curhead.next = newOne;
//            curhead = next;
//        }
//        curhead = head;
//        while(curhead!=null){
//            RandomListNode rando = curhead.random;
//            if(rando!=null){
//                curhead.next.random = rando.next;
//            }
//            curhead = curhead.next.next;
//        }
//        curhead = head;
//        RandomListNode res = head.next;
//        while(curhead != null){
//            RandomListNode newOne = curhead.next;
//            RandomListNode next = newOne.next;
//            curhead.next = next;
//            
//            if(next != null){
//                newOne.next = next.next;
//            }else{
//                newOne.next = null;
//            }
//            
//            curhead = next;
//            
//            
//        }
//        return res;
//    }
//}
//




//Remove Duplicates from Sorted List II 
//
//
//public class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        if(head == null) return head;
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
//        ListNode nextHead = pre;
//        boolean isdelete= false;
//        while(head.next != null){
//            ListNode post = head.next;
//            if(head.val == post.val){
//                isdelete = true;
//                head.next = post.next;
//            }else{
//                if(!isdelete){
//                    pre=head;
//                    head=post;
//                }else{
//                    pre.next = post;
//                    head = post;
//                    isdelete = false;
//                }
//            }
//        }
//        if(isdelete){
//            pre.next = head.next;
//        }
//        return nextHead.next;
//    }
//}





//Word Search
//
//
//public class Solution {
//    public boolean exist(char[][] board, String word) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        int m = board.length;
//        if(m == 0 )return false;
//        int n = board[0].length;
//        if(n==0)return false;
//        if(m*n < word.length())return false;
//        
//        for(int i =0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(board[i][j]==word.charAt(0)){
//                    int[][] table = new int[m][n];
//                    table[i][j]=1;
//                    if(search(board,i,j,table,word.substring(1))){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//    
//    public boolean search(char[][] board, int i, int j, int[][] table, String word){
//        if(word==null || word.length()==0){
//            return true;
//        }
//        
//        for(int l = -1; l<2; l++){
//            for(int k = -1; k<2; k++){
//                if((l+i)>=0 && (l+i)<board.length && (k+j)>=0 && (k+j)<board[0].length && Math.abs(l)!=Math.abs(k)){
//                    if(board[i+l][k+j]==word.charAt(0)&&table[i+l][k+j]==0){
//                        table[i+l][k+j]=1;
//                        if(search(board,i+l,k+j,table,word.substring(1))) return true;
//                        table[i+l][k+j]=0;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//}





//Longest Valid Parentheses
//
//
//public class Solution {
//    public int longestValidParentheses(String s) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int n = s.length();
//        if(n<=1){
//            return 0;
//        }
//        
//        int[] res = new int[n];
//        int max = 0;
//        for(int i = n-2; i>=0; i--){
//            if(s.charAt(i)=='('){
//                int j = i+1+res[i+1];
//                int sum = 0;
//                if(j<n && s.charAt(j)==')'){
//                    sum=j-i+1;
//                     res[i]=sum;
//                if(j+1<n && res[j+1]!=0){
//                    res[i]+=res[j+1];
//                }
//                if(res[i]>max){
//                    max=res[i];
//                }
//                }
//               
//                
//            }
//        }
//        return max;
//    }
//}





//Swap Nodes in Pairs
//
//
//public class Solution {
//    public ListNode swapPairs(ListNode head) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
//        ListNode nextHead = pre;
//        ListNode post = head.next;
//        int count =1;
//        while(post != null){
//            ListNode nex = post.next;
//            if(count == 1){
//                post.next = head;
//                head.next = nex;
//                pre.next = post;
//                pre=head;
//                head = post;
//                post = nex;
//                
//                count-- ;
//            }else{
//                head = post;
//                post = nex;
//                count++;
//            }
//        }
//        return nextHead.next;
//    }
//}





//Minimum Path Sum
//
//
//public class Solution {
//    public int minPathSum(int[][] grid) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        if(grid == null || grid.length==0 || grid[0].length==0){
//            return 0;
//        }
//        
//        
//        int[][] res = new int[grid.length][grid[0].length];
//        
//        for(int i=0; i< grid.length; i++){
//            for(int j =0; j<grid[0].length;j++){
//                if(i==0 && j==0){
//                    res[i][j]=grid[i][j];
//                }else if(i==0){
//                    res[i][j] = res[i][j-1]+grid[i][j];
//                }else if(j==0){
//                    res[i][j] = res[i-1][j]+grid[i][j];
//                }else{
//                    res[i][j] = Math.min(res[i-1][j],res[i][j-1])+grid[i][j];
//                }
//            }
//        }
//        return res[grid.length-1][grid[0].length-1];
//    }
//}





//Remove Element
//
//
//public class Solution {
//    public int removeElement(int[] A, int elem) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        if(A==null || A.length==0)return 0;
//        int left=0;
//        int right = A.length-1;
//        while(left<right){
//            if(A[left]!=elem){
//                left++;
//                continue;
//            }else{
//                while(A[right]==elem){
//                    right--;
//                    if(right<0){
//                        return 0;
//                    }
//                }
//                if(left>=right){
//                    return left;
//                }else{
//                    int tmp = A[right];
//                    A[right]=A[left];
//                    A[left]=tmp;
//                    left++;
//                    
//                }
//            }
//            
//        }
//        if(A[left]!=elem){
//            return left+1;
//        }else{
//            return left;
//        }
//    }
//}





//Unique Paths II 
//
//
//public class Solution {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(obstacleGrid == null || obstacleGrid.length==0 || obstacleGrid[0].length==0){
//        	return 0;
//        }
//        
//        int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
//    	for(int i=0; i<obstacleGrid.length; i++){
//    		for(int j=0; j<obstacleGrid[0].length; j++){
//			  if(obstacleGrid[i][j]!=1){
//				if(i==0&&j==0){
//				res[i][j]=1;	
//		}else if(i==0){
//					res[i][j]=res[i][j-1];
//				}else if(j==0){
//					res[i][j]=res[i-1][j];
//				}else{
//					res[i][j]=res[i-1][j]+res[i][j-1];
//				}
//			}
//			}
//    	}
//		return res[obstacleGrid.length-1][obstacleGrid[0].length-1];
//    }
//}





//Word Break II
//
//
//public class Solution {
//    public ArrayList<String> wordBreak(String s, Set<String> dict) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
// 		ArrayList<String> res = new ArrayList<String>();
// 		if(dict == null || s == null){
// 			return res;
// 		}
// 		HashMap<String, ArrayList<String>> table = new HashMap<String,ArrayList<String>>();
// 		return breaks(s,dict,table);
// 		       
//    }
//    public ArrayList<String> breaks(String s, Set<String> dict,HashMap<String,ArrayList<String>> table){
//        ArrayList<String> res = new ArrayList<String>();
//        if(s==null || s.isEmpty()){
//            res.add("");
//            return res;
//        }
//        if(table.containsKey(s)){
//            return table.get(s);
//        }
//        
//        for(int i = 1; i<=s.length(); i++){
//            String newS = s.substring(0,i);
//            if(dict.contains(newS)){
//            	ArrayList<String> next = breaks(s.substring(i,s.length()),dict,table);
//            	if(next != null || !next.isEmpty()){
//            		for(String tmp : next){
//            		    if(tmp.equals("")){
//            		        res.add(newS);
//            		    }else{
//            		        res.add(newS+" "+tmp);
//            		    }
//            			
//            		}
//            	}
//            }
//        }
//        table.put(s,res);
//        return res;
//    }
//    
//}





//Valid Number
//
//
//public class Solution {
//    public boolean isNumber(String s) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        if(s == null || s.length()==0){
//        	return false;
//        }
//        s=s.trim();
//        int left = 0, right = s.length()-1;
//        if(left>right){
//			  return false;      
//        }
//        boolean positive = true;
//        if(s.charAt(0)=='+'){
//        	left++;
//        }else if(s.charAt(0)=='-'){
//        	positive = false;
//        	left++;
//        }
//        boolean digit = false;
//        boolean point = false;
//        boolean esign = false;
//        while(left<=right){
//        	if(s.charAt(left)>='0'&&s.charAt(left)<='9'){
//        		digit=true;
//        		left++;
//        	}else if(s.charAt(left)=='.'){
//        		if(point || esign){
//        			return false;
//        		}
//        		point = true;
//        		left++;
//        	}else if(s.charAt(left)=='e'){
//        		if(esign || !digit){
//        		return false;
//        		}
//        		esign = true;
//        		digit = false;
//        		left ++;
//        	}else if (s.charAt(left) == '+' || s.charAt(left) == '-') {
//                if (s.charAt(left-1) != 'e') return false;
//                left++;
//            }else{
//        		return false;
//        	}
//        }
//        return digit;
//    }
//}





//public class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int index = 0;
//        int maxLen = 1;
//        if(s==null || s.length()==0){
//            return 0;
//        }
//        for(int i =1; i<s.length();i++){
//            int k = index;
//            while(k<i){
//                if(s.charAt(k)!= s.charAt(i)){
//                    k++;
//                }else{
//                    index = k+1;
//                    int len = i-k;
//                    if(index>maxLen){
//                        maxLen = index;
//                    }
//                    break;
//                }
//            }
//            if(k==i){
//                    int len = i-index+1;
//                    if(index>maxLen){
//                        maxLen = len;
//                    }
//                }
//        }
//        return maxLen;
//        
//    }
//}





//public class Solution{
//	public int hashCode(String str) {
//		int h = 0;
//	        int len = str.length();
//		if (h == 0 && len > 0) {
//		    int off = 0;
//		    char val[] = str.toCharArray();
//
//	            for (int i = 0; i < len; i++) {
//	            	System.out.println("val[off++] "+val[off] +" 31h "+31*h);
//	                h = 31*h + val[off++];
//	                System.out.println("h "+h);
//	            }
//	           
//	        }
//	        return h;
//	    }
//}





//public class Solution{
//	public String convertWordsInString(String str){
//		if(str == null){
//			return null;
//		}
//		str = str.trim();
//		if(str.equals("")){
//			return "";
//		}
//		
//		char[] strChar = str.toCharArray();
//		
//		strChar = revertString(strChar,0,strChar.length-1);
//		
//		int index1=0;
//		for(int index2 = 0; index2<=strChar.length; index2++){
//			if(index2==strChar.length || strChar[index2]==' '){
//				strChar = revertString(strChar,index1,index2-1);
//				index1 = index2+1;
//			}
//		}
//		return new String(strChar);
//	}
//	public char[] revertString(char[] strChar, int start, int end){
//		char tmp;
//		while(start<end){
//			tmp=strChar[end];
//			strChar[end]=strChar[start];
//			strChar[start]=tmp;
//			end--;
//			start++;
//		}
//		return strChar;
//	}
//}





//Longest Common Prefix
//
//
//public class Solution {
//    public String longestCommonPrefix(String[] strs) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(strs == null || strs.length==0){
//            return "";
//        }
//        int i=0;
//        LOOP:
//        for(; i<strs[0].length(); i++){
//            char key = strs[0].charAt(i);
//            for(int j=1; j<strs.length; j++){
//                if(strs[j].length() <= i || key!=strs[j].charAt(i) ){
//                    break LOOP;
//                }
//            }
//        }
//        return strs[0].substring(0,i);
//    }
//}


//Longest Consecutive Sequence
//
//
//public class Solution {
//    public int longestConsecutive(int[] num) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(num == null || num.length==0){
//            return 0;
//        }
//        HashSet<Integer> table = new HashSet<Integer>();
//        for(int n : num){
//            table.add(n);
//        }
//        int max = 0;
//        for(int n: num){
//            max = Math.max(max, getConsecutive(table,n,false)+getConsecutive(table,n+1,true));
//        }
//        return max;
//    }
//    public int getConsecutive(HashSet<Integer> table, int n, Boolean asc){
//        int count=0;
//        while(table.contains(n)){
//            count++;
//            table.remove(n);
//            if(asc){
//                n++;
//            }else{
//                n--;
//            }
//        }
//        return count;
//    }
//}
//public class Solution {
//    public int longestConsecutive(int[] num) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(num == null || num.length==0){
//            return 0;
//        }
//        int count=1;
//        int maxLen = 0;
//        Arrays.sort(num);
//        for(int i =1; i<num.length; i++){
//            if(num[i]==num[i-1]+1){
//                count++;
//            }else if(num[i]==num[i-1]){
//                continue;
//            }else{
//                if(count > maxLen){
//                    maxLen = count;
//                }
//                count=1;
//            }            
//        }
//        if(count > maxLen){
//            maxLen = count;
//        }
//        return maxLen;
//    }
//}

//class Solution extends Test{
//	public void run(){
//		System.out.println("Solution run");
//	}
//	public void solu(){
//	
//		System.out.println("Solution Solution");
//		
//	}
//	public static int findWays(Integer x, Integer y){
//		System.out.println("xx run");
//		return 0;
//	}
//}


//public static void findPrime(int nth){
//		int i =1;
//		int n = nth;
//		
//		ArrayList<Integer> table = new ArrayList<Integer>();
//		Loop:
//		while(nth>0){
//			
//			i++;
//			for(int j =0 ; j<table.size()&&table.get(j)*table.get(j)<=i;j++){
//				if(i%table.get(j)==0){
//			
//					continue Loop;
//				}
//			}
//			table.add(i);
//			nth--;
//		}
//		System.out.print(n+"th: "+table.get(table.size()-1));
//	}





//public static void findPrime(int num){
//		int sqrt = (int)Math.sqrt(num);
//		int[] table = new int[num+1];
//		for(int i =2; i<=sqrt;i++){
//			if(table[i]==0){
//				System.out.print(i+" ");
//				int k =i*i;
//				while(k<=num){
//					table[k]=1;
//					k+=i;
//				}
//			}
//			
//		}
//		for(int i=sqrt+1 ; i<=num; i++){
//			if(table[i]==0){
//				System.out.print(i+" ");
//			}
//		}
//	}


//Jump Game II
//
//
//public class Solution {
//    public int jump(int[] A) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int curStep = 0, nextStep=0,res=0;
//        for(int i =0; i<A.length;i++){
//    		if(i>curStep){
//    			curStep=nextStep;
//    			res++;
//    		}
//    		nextStep=Math.max(nextStep, A[i]+i);
//        }
//    	return res;
//    }
//}





//public class Solution {
//    public boolean canJump(int[] A) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(A == null){
//        	return true;
//        }
//        int[] step = new int[A.length];
//        for(int i =0; i<A.length;i++){
//        	if(i==0){
//        		step[i]=A[i];
//        	}else{
//        		step[i]=Math.max(A[i-1]-1, A[i]);
//        		if(step[i-1]<1){
//        			return false;
//        		}
//        	}
//        }
//        return true;
//    }
//}





//Unique Binary Search Trees II
//
//
//public class Solution {
//    public ArrayList<TreeNode> generateTrees(int n) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        return generateTrees(1, n);
//    }
// 
//    private ArrayList<TreeNode> generateTrees(int begin, int end){
//        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
//        if(begin > end) result.add(null);
//        else{
//            for(int i = begin; i <= end; i++){
//                ArrayList<TreeNode> left = generateTrees(begin, i - 1);
//                ArrayList<TreeNode> right = generateTrees(i + 1, end);
//                for(int j = 0; j < left.size(); j++){
//                    for(int k = 0; k < right.size(); k++){
//                        TreeNode node = new TreeNode(i);
//                        node.left = left.get(j);
//                        node.right = right.get(k);
//                        result.add(node);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//}





//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Solution {
//    public HashMap<ArrayList<String>,Integer> table = new HashMap<ArrayList<String>,Integer>();
//	public int minDistance(String word1, String word2) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//		ArrayList<String> tmp =new ArrayList<String>();
//		tmp.add(word1);
//		tmp.add(word2);
//		if(table.containsKey(tmp)){
//			return table.get(tmp);
//		}
//    	if(word1.length()==0){
//        	return word2.length();
//        }
//        if(word2.length() == 0){
//        	return word1.length();	
//        }
//        if(word1.charAt(0)==word2.charAt(0)){
//        	int res = minDistance(word1.substring(1),word2.substring(1));
//        	table.put(tmp, res);
//        	return res;
//        }else{
//        	int res = 1+ Math.min(minDistance(word1.substring(1),word2),Math.min(minDistance(word1.substring(1),word2.substring(1)), minDistance(word1,word2.substring(1))));
//        	table.put(tmp, res);
//        	return res;
//        }
//        
//    }
//}





//public class Solution {
//    public int uniquePaths(int m, int n) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int[][] res = new int[m][n];
//        for(int i = 0; i<m; i++){
//        	res[i][0]=1;
//        }
//        for(int i =0 ; i<n;i++){
//        	res[0][i] = 1;
//        }
//        for(int i =1 ; i<m ; i++){
//        	for(int j =1; j<n ; j++){
//        		res[i][j] = res[i-1][j]+res[i][j-1];
//        	}
//        }
//        return res[m-1][n-1];
//    }
//}

//public class Solution {
//    public int uniquePaths(int m, int n) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(n==0)return 1;
//        if(m==0)return 1;
//        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
//    }
//}

//import java.util.ArrayList;
//
//public class Solution {
//    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(triangle == null){
//        	return 0;
//        }
//        ArrayList<int[]> table = new ArrayList<int[]>();
//        for(ArrayList<Integer> tmp : triangle){
//        	table.add(new int[tmp.size()]);
//        }
//        return minTotal(table,triangle,0,0);      	
//        
//    }
//    public int minTotal(ArrayList<int[]> table, ArrayList<ArrayList<Integer>> triangle, int row,int column){
//    	if(row == triangle.size()-1){
//    		table.get(row)[column]=triangle.get(row).get(column);
//    	}else if(table.get(row)[column]==0){
//    		table.get(row)[column]=(Math.min(minTotal(table,triangle,row+1,column+1),minTotal(table,triangle,row+1,column)))+triangle.get(row).get(column);
//    	}
//    	return table.get(row)[column];
//    	
//    }
//}

//public class Solution {
//    public ListNode partition(ListNode head, int x) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        
//    }
//}

//Rotate List
//
//
//public class Solution {
//    public ListNode rotateRight(ListNode head, int n) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(head == null || n == 0){
//        	return head;
//        }
//        ListNode p1 = head;
//        ListNode p2 = head;
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
//        int m = n;
//        while(m>1){
//        	p2 = p2.next;
//        	if(p2 == null){
//        		p2 = head;
//        	}
//        	m--;
//        }
//        while(p2.next != null){
//        	p2 = p2.next;
//        	p1 = p1.next;
//        	pre=pre.next;
//        }
//        if(p1 == head){
//        	return head;
//        }else{
//        	p2.next = head;
//        	pre.next = null;
//        	return p1;
//        }
//    }
//}

//Reverse Nodes in k-Group
//
//
//public class Solution {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(head == null || k == 1){
//        	return head;
//        }
//        int len =0;
//        ListNode p1 = head;
//        while(p1!=null){
//        	p1=p1.next;
//        	len++;
//        }
//        int n = len/k;
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
//        ListNode ret = pre;
//        ListNode cur = head;
//        ListNode post = cur.next;
//        for(int i =0; i<n;i++){
//        	post = cur.next;
//        	int j =0;
//        	while(post != null){
//        		ListNode next = post.next;
//        		post.next = cur;
//        		cur=post;
//        		post = next;
//        		j++;
//        		if(j==k-1){
//        			break;
//        		}
//        	}
//        	ListNode tmp = pre.next;
//        	pre.next = cur;
//        	tmp.next = post;
//        	pre=tmp;
//        	cur = post;
//        }
//        return ret.next;
//    }
//}

//Merge Two Sorted Lists
//
//
//public class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        
//        ListNode cur = new ListNode(-1);
//        ListNode pre = cur;
//        
//        while(l1 != null && l2 != null){
//        	if(l1.val<=l2.val){
//        		ListNode next = l1.next;
//        		cur.next = l1;
//        		l1.next=null;
//        		cur = cur.next;	
//        		l1=next;
//        	}else{
//        		ListNode next = l2.next;
//        		cur.next=l2;
//        		l2.next=null;
//        		cur = cur.next;
//        		l2 = next;
//        	}
//        }
//        if(l1!=null){
//        	cur.next=l1;
//        }
//        if(l2!=null){
//        	cur.next=l2;
//        }
//        return pre.next;
//    }
//}

//3sum
//
//
//public class Solution {
//    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        if(num == null || num.length<3){
//        	return res;
//        }
//        Arrays.sort(num);
//        HashSet<ArrayList<Integer>> table = new HashSet<ArrayList<Integer>>();
//        for(int i =0 ; i<num.length-2;i++){
//        	int left = i+1;
//        	int right = num.length-1;
//        	while(left < right){
//        		int sum = num[i]+num[left]+num[right];
//        		if(sum == 0){
//        			ArrayList<Integer> tmp = new ArrayList<Integer>();
//        			tmp.add(num[i]);
//        			tmp.add(num[left]);
//        			tmp.add(num[right]);
//        			if(!table.contains(tmp)){
//        				table.add(tmp);
//        				res.add(tmp);
//        			}
//        			left++;
//        			right--;
//        		}else if(sum > 0){
//        			right--;
//        		}else{
//        			left++;
//        		}
//        	}
//        }
//        return res;
//    }
//}

//Remove Duplicates from Sorted List II
//
//
//public class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        ListNode prev = new ListNode(0);
//        prev.next = head;
//        head = prev;
//        
//        ListNode n1=head;
//        while(n1.next!=null){
//            ListNode n2=n1.next;
//            while(n2.next!=null && n2.next.val==n2.val){
//                n2=n2.next;
//            }
//            if(n2!=n1.next){
//                n1.next=n2.next;
//            }else{
//                n1=n1.next;   
//            }
//        }
//        return head.next;
//    }
//}

//Remove Duplicates from Sorted Array
//
//
//public class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//    	if(head == null || head.next == null){return head;}
//    	ListNode p1 = head;
//        ListNode p2 = head;
//        while(p1 !=null){
//        	while(p2 != null){
//        		if(p2.next != null && p2.next.val == p1.val){
//        			p2 = p2.next.next;
//        		}else{
//        			p2 = p2.next;
//        		}
//        	}
//        	p1 = p1.next;
//        	p2 = p1;
//        }
//        return head;
//    }
//}

//Remove Nth Node From End of List
//
//
//public class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        ListNode p1 = head;
//        ListNode p2 = head;
//        int k = n;
//        while(p2!=null && k>0){
//            p2=p2.next;
//        	k--;
//        }
//        if(p2 == null && k>0){
//        	return null;
//        }
//        while(p2 != null && p2.next!=null){
//        	p2 = p2.next;
//        	p1=p1.next;
//        }
//        if(p1 == head && p2==null){
//        	return head.next;
//        }else{
//        	p1.next = p1.next.next;
//        }
//        return head;
//    }
//}

//Search a 2D Matrix
//
//
//public class Solution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(matrix == null || matrix.length==0){
//        	return false;
//        }
//        int row = matrix.length -1;
//        int col = 0;
//        while(row>=0 && col<matrix[0].length){
//        	if(matrix[row][col]<target){
//            	col++;
//            }else if(matrix[row][col]>target){
//            	row--;
//            }else{
//            	return true;
//            }
//        }
//        return false;
//        
//    }
//}

//Balanced Binary Tree
//
//
//public class Solution {
//    public boolean isBalanced(TreeNode root) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(root == null){
//        	return true;
//        }else{
//        	int deduct = Math.abs(getLength(root.left)-getLength(root.right));
//        	if(deduct>1){
//        		return false;
//        	}else{
//        		return isBalanced(root.left)&&isBalanced(root.right);
//        	}
//        }
//    }
//    public int getLength(TreeNode root){
//    	if(root == null){
//    		return 0;
//    	}else{
//    		return Math.max(getLength(root.left), getLength(root.right))+1;
//    	}
//    }
//}

//Two Sum
//
//
//public class Solution {
//    public int[] twoSum(int[] numbers, int target) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
//        for(int i =0; i<numbers.length ; i++){
//            if(!table.containsKey(numbers[i])){
//        		table.put(target - numbers[i], i );
//        	}else{
//        		int[] res = new int[2];
//        		res[0] = table.get(numbers[i])+1;
//        		res[1] = i+1;
//        		return res;
//        	}
//        }
//        return null;
//    }
//}

//Sudoku Solver
//
//
//public class Solution {
//    
//    public boolean isValid(char[][] board, int a, int b){
//        boolean[] flag = new boolean[9];
//         
//        Set<Character> contained = new HashSet<Character>();
//        for(int j=0;j<9;j++){
//            if(contained.contains(board[a][j])) return false;
//            if(board[a][j]>'0' && board[a][j]<='9')
//                contained.add(board[a][j]);
//        }
//        contained = new HashSet<Character>();
//        for(int j=0;j<9;j++){
//            if(contained.contains(board[j][b])) return false;
//            if(board[j][b]>'0' && board[j][b]<='9')
//                contained.add(board[j][b]);
//        }
//        contained = new HashSet<Character>();
//        for(int m=0;m<3;m++){
//            for(int n=0;n<3;n++){
//                int x=a/3*3+m, y=b/3*3+n;
//                if(contained.contains(board[x][y])) return false;
//                    if(board[x][y]>'0' && board[x][y]<='9')
//                        contained.add(board[x][y]);
//            }  
//        }
//        return true;
//    }
//    public boolean solveSudoku(char[][] board) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                if(board[i][j]=='.'){
//                    for(int k=0;k<9;k++){
//                        board[i][j]=(char)('1'+k);
//                        if(isValid(board,i,j) && solveSudoku(board)) return true;
//                        board[i][j]='.';
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;   
//    }
//}

//Valid Sudoku
//
//
//public class Solution {
//    public boolean isValidSudoku(char[][] board) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        for(int i=0; i<9 ; i++){
//        	HashSet<Character> table = new HashSet<Character>();
//        	for(int j =0 ;j<9;j++){
//        		if(board[i][j] != '.'){
//        			if(!table.contains(board[i][j])){
//            			table.add(board[i][j]);
//            		}else{
//            			return false;
//            		}
//        		}
//        		
//        	}
//        }
//        for(int i=0; i<9 ; i++){
//        	HashSet<Character> table = new HashSet<Character>();
//        	for(int j =0 ;j<9;j++){
//        		if(board[j][i] != '.'){
//        			if(!table.contains(board[j][i])){
//            			table.add(board[j][i]);
//            		}else{
//            			return false;
//            		}
//        		}
//        		
//        	}
//        }
//        for(int i =0 ; i<3 ; i++){
//        	for(int j =0 ; j<3 ; j++){
//        		HashSet<Character> table = new HashSet<Character>();
//        		for(int x=0; x<3; x++){
//        			for(int y =0; y<3; y++){
//        				if(board[1*i+x][1*j+y] != '.'){
//        					if(!table.contains(board[1*i+x][1*j+y])){
//            					table.add(board[1*i+x][1*j+y]);
//            				}else{
//            					return false;
//            				}
//                		}
//        				
//        			}
//        		}
//        	}
//        }
//        return true;
//    }
//}

//import java.util.ArrayList;
//
//public class Solution {
//    public ArrayList<String> letterCombinations(String digits) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        return lettercom(digits,0);
//    }
//    public ArrayList<String> lettercom(String digits, int index){
//    	ArrayList<String> res ;
//    	if(index == digits.length()){
//    		res = new ArrayList<String>();
//    		res.add("");
//    		return res;
//    	}
//    	res = lettercom(digits,index+1);
//    	ArrayList<String> res2 = new ArrayList<String>();
//    	ArrayList<String> keys = getLetters(digits.substring(index,index+1));
//    	for(String tmp : res){
//    		for(String key : keys){
//    			String next = key+tmp;
//    			res2.add(next);
//    		}
//    	}
//    	return res2;
//    }
//    public ArrayList<String> getLetters(String cur){
//    	 ArrayList<String> res = new ArrayList<String>();
//    	 switch( Integer.valueOf(cur) ){
//    	 case 2:
//    	 res.add("a");
//    	 res.add("b");
//    	 res.add("c");
//    	 break;
//    	 case 3:
//    	 res.add("d");
//    	 res.add("e");
//    	 res.add("f");
//    	 break;
//    	 case 4:
//    	 res.add("g");
//    	 res.add("h");
//    	 res.add("i");
//    	 break;
//    	 case 5:
//    	 res.add("j");
//    	 res.add("k");
//    	 res.add("l");
//    	 break;
//    	 case 6:
//    	 res.add("m");
//    	 res.add("n");
//    	 res.add("o");
//    	 break;
//    	 case 7:
//    	 res.add("p");
//    	 res.add("q");
//    	 res.add("r");
//    	 res.add("s");
//    	 break;
//    	 case 8:
//    	 res.add("t");
//    	 res.add("u");
//    	 res.add("v");
//    	 break;
//    	 case 9:
//    	 res.add("w");
//    	 res.add("x");
//    	 res.add("y");
//    	 res.add("z");
//    	 break;
//    	 }
//    	 return res;
//    	 }
//}

// N-Queens
//
//
// public class Solution {
// public ArrayList<String[]> solveNQueens(int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<String[]> res = new ArrayList<String[]>();
// int[] arr = new int[n];
// solveNQ(n,0,arr,res);
// return res;
// }
// public void solveNQ(int n, int index,int[] arr,ArrayList<String[]> res){
// if(index == n){
// res.add(convert(arr));
// return;
// }
// for(int i=0; i<n; i++){
// arr[index]=i;
// if(isValid(arr,index)){
// solveNQ(n,index+1,arr,res);
// }
// }
//
// }
// public String[] convert(int[] arr){
// String[] res = new String[arr.length];
// for(int i=0; i<arr.length;i++){
// res[i]="";
// for(int j =0; j<arr.length;j++){
// if(j==arr[i]){
// res[i]+='Q';
// }else{
// res[i]+='.';
// }
// }
// }
// return res;
// }
// public boolean isValid(int[] arr, int index){
// for(int i = 0; i < index; i++){
// if(arr[i]==arr[index]){
// return false;
// }
// int d = Math.abs(i-index);
// int dd = Math.abs(arr[i]-arr[index]);
// if(d == dd){
// return false;
// }
// }
// return true;
// }
// }

// Palindrome Number
//
//
// public class Solution {
// public boolean isPalindrome(int x) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int t = 0;
// int xx =x;
// while(xx>0){
// int k = xx%10;
// t =t*10+ k;
// xx= xx/10;
// }
// if(t==x){
// return true;
// }
// return false;
// }
// }

// public class Solution {
// public ListNode reverseKGroup(ListNode head, int k) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(head == null || k ==1 )return head;
// ListNode start = new ListNode(-1);
// start.next = head;
// ListNode pre = start;
// ListNode cur = head;
// ListNode post = head.next;
// ListNode p1 = head;
// int len =0;
// while(p1 != null){
// p1 = p1.next;
// len++;
// }
// int m = len/k;
// for(int i =0; i<m; i++){
// post = cur.next;
// int j =0;
// while(post != null){
// ListNode tmp = post.next;
// post.next = cur;
// cur = post;
// post = tmp;
// j++;
// if(j==k-1){
// break;
// }
// }
// ListNode tmp = pre.next;
// pre.next = cur;
// tmp.next = post;
// pre = tmp;
// cur = post;
// }
// return start.next;
// }
// }

// Rotate List
//
// public class Solution {
// public ListNode rotateRight(ListNode head, int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(head == null || n ==0)return head;
// ListNode p1 = head;
// ListNode p2 = head;
// while(n>0){
// p2 = p2.next;
// n--;
// if(p2 == null) p2 = head;
// }
// while (p2.next != null){
// p2 = p2.next;
// p1 = p1.next;
// }
// if(p1.next == null){
// return head;
// }
// p2.next = head;
// ListNode start = p1.next;
// p1.next = null;
// return start;
// }
// }

// Reverse Linked List II
//
//
// public class Solution {
// public ListNode reverseBetween(ListNode head, int m, int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(m==n)return head;
// int nn = m;
// ListNode p1 = head;
// ListNode pre = new ListNode(-1);
// pre.next = head;
// while(nn>1){
// p1 = p1.next;
// pre = pre.next;
// nn--;
// }
// ListNode post = p1.next;
// int i=0;
// while(post!=null){
// ListNode tmp = post.next;
// post.next = p1;
// p1 = post;
// post = tmp;
// i++;
// if(i==n-m){
// break;
// }
// }
// ListNode tmp = pre.next;
// pre.next = p1;
// tmp.next = post;
// if(m ==1 )return pre.next;
// return head;
// }
// }

// // Fibonacci
//
// public class Solution{
// public int fibo(int n){
// int[] table = new int[n+1];
// table[0] = 0;
// table[1] = 1;
// for(int i = 2; i<=n;i++){
// table[i] = table[i-1]+table[i-2];
// }
// return table[n];
// }
// }

// // Fibonacci
//
// public class Solution{
// public int fibo(int n){
// return n<=1? n : fibo(n-1)+fibo(n-2);
// }
// }

// //CC150 9.5
// public class Solution{
// public ArrayList<String> permutation(String s){
// ArrayList<String> res = new ArrayList<String>();
// if(s == null){
// return res;
// }
// return perm(s,0);
// }
// public ArrayList<String> perm (String s, int index){
// ArrayList<String> res;
// if(s.length()==index){
// res = new ArrayList<String>();
// res.add("");
// return res;
// }
// res = perm(s,index+1);
// char key = s.charAt(index);
// ArrayList<String> res2 = new ArrayList<String>();
// HashSet<String> table = new HashSet<String>();
// for(String tmp : res){
// for(int i=0; i<=tmp.length();i++){
// String next = addChar(tmp,i,key);
// if(!table.contains(next)){
// res2.add(next);
// table.add(next);
//
// }
// }
// }
// return res2;
// }
// public String addChar(String tmp, int index, char key){
// String left = tmp.substring(0,index);
// String right = tmp.substring(index,tmp.length());
// return left+key+right;
// }
// }

// Permutations II
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//
// if(num == null){
// return res;
// }
// return perm(num,0);
// }
// public ArrayList<ArrayList<Integer>> perm(int[] num, int index){
// ArrayList<ArrayList<Integer>> res;
// if(num.length-1 == index){
// res = new ArrayList<ArrayList<Integer>>();
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// tmp.add(num[index]);
// res.add(tmp);
// return res;
// }
// res = perm(num,index+1);
// ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
// HashSet<ArrayList<Integer>> table = new HashSet<ArrayList<Integer>>();
// for(ArrayList<Integer> tmp : res){
//
// for(int i =0; i<=tmp.size();i++){
// ArrayList<Integer> tmp2 = new ArrayList<Integer>();
// tmp2.addAll(tmp);
// tmp2.add(i, num[index]);
// if(!table.contains(tmp2)){
// res2.add(tmp2);
// table.add(tmp2);
// }
//
// }
// }
// return res2;
// }
// }

// Search for a Range
//
//
//
// public class Solution {
// public int[] searchRange(int[] A, int target) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int left = search(A,0,A.length-1,target,true);
// int right = search(A,0,A.length-1,target,false);
// int[] res = new int[2];
// res[0] = left;
// res[1] = right;
// return res;
// }
// public int search(int[] A, int left, int right, int target, boolean searchL){
// if(left > right){
// return -1;
// }
// int mid = (right+left)/2;
// if(A[mid]== target){
// if(searchL){
// if(mid == 0) return mid;
// else{
// if(A[mid -1]==target){
// return search(A,left,mid-1,target,true);
// }else{
// return mid;
// }
// }
// }else{
// if(mid==A.length-1){return mid;
// }else{
// if(A[mid+1]==target){
// return search(A,mid+1,right,target,false);
// }else{
// return mid;
// }
// }
// }
// }else if(A[mid]<target){
// return search(A,mid+1,right,target,searchL);
// }else{
// return search(A,left,mid-1,target,searchL);
// }
// }
// }

// public class Solution {
// public int search(int[] A, int target) {
// // Start typing your Java solution below
// // DO NOT write main() function
// return searchK(A,0,A.length-1,target);
// }
// public int searchK(int[] A, int left ,int right, int target){
// if(left>right){
// return -1;
// }
// int mid = (left+right)/2;
// if(A[mid] == target ){
// return mid;
// }else if(A[mid] >target){
// if(A[mid] > A[left]){
// int a = searchK(A,left,mid-1,target);
// int b = searchK(A,mid+1,right,target);
// return a == -1? b : a;
//
// }else{
// return searchK(A,left, mid-1, target);
// }
// }else{
// if(A[mid]<A[right]){
// return searchK(A,mid+1,right,target);
// }else{
// int a = searchK(A,left,mid-1,target);
// int b = searchK(A,mid+1,right,target);
// return a == -1? b : a;
// }
//
// }
// }
// }

// Divide Two Integers
//
//
//
// public class Solution {
// public int divide(int dividend, int divisor) {
// // Start typing your Java solution below
// // DO NOT write main() function
// boolean positive = true;
// long dividendl = dividend;
// long divisorl = divisor;
// if(dividendl<0){
// dividendl = Math.abs(dividendl);
// positive = !positive;
// }
// if(divisorl <0){
// divisorl = Math.abs(divisorl);
// positive = !positive;
// }
// int carry =0;
// while((divisorl<<carry)<=dividendl){
// carry++;
//
// }
// carry--;
// int res =0;
// for(int i = carry ; i>=0; i--){
// if((divisorl<<i)<=dividendl){
// res += (1 <<i);
// dividendl -= (divisorl<<i);
// }
// }
//
// return positive == true ? res : -(res);
//
// }
// }

// public class Solution {
// public int divide(int dividend, int divisor) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(dividend < divisor) return 0;
// boolean positive = true;
// if(dividend<0){
// dividend = Math.abs(dividend);
// positive = !positive;
// }
// if(divisor <0){
// divisor = Math.abs(divisor);
// positive = !positive;
// }
// int carry =1;
// int divisor1 = divisor;
// while(divisor1*2<dividend){
// divisor1 = divisor1 <<1;
// carry = carry<<1;
//
// }
// System.out.println("dvisor "+divisor1+" carry "+carry);
// dividend -= divisor1;
// System.out.println("dividend "+dividend+" carry "+carry);
// return positive == true ? carry+divide(dividend,divisor) : -(carry+divide(dividend,divisor));
//
// }
// }

// public class Solution {
// public String minWindow(String S, String T) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(S == null || T == null || S.length()<T.length())
// return "";
// char[] ss= S.toCharArray();
// char[] tt = T.toCharArray();
// int[] window = new int[256];
// int[] windowN = new int[256];
// for(int i=0 ; i<tt.length; i++){
// window[tt[i]]++;
// }
// int start =0;
// int end =0;
// int minSt=0;
// int count=0;
// int minLen = Integer.MAX_VALUE;
// for(;end<ss.length;end++){
// if(window[ss[end]]==0){
// continue;
// }
// if(++windowN[end]<window[end]){
// count++;
// }
// if(count == tt.length){
// while(window[start]==0||windowN[start]>window[start]){
// if(windowN[start]>window[start]){
// windowN[start]--;
// }
// start++;
// }
// int len = end - start+ 1;
// if(len<minLen){
// minLen = len;
// minSt = start;
// }
// }
// }
// return minLen<=S.length()?S.substring(minSt,minSt+minLen):"";
//
// }
// }

// public class Solution {
// public String minWindow(String S, String T) {
// char[] ta= T.toCharArray();
// char[] sa = S.toCharArray();
// int[] table = new int[256];
// int[] window = new int[256];
// for(int i=0;i<256;i++){
// table[i]=0;
// window[i]=0;
// }
// int count=0;
// for(int i=0; i<T.length();i++){
// table[ta[i]]+=1;
// }
// int minLen = Integer.MAX_VALUE;
// int start = 0;
// int end = 0;
// int minBegin = 0;
// for(;end<S.length();end++){
//
// if(table[sa[end]]==0){
// continue;
// }
// if(++window[sa[end]]<=table[sa[end]]){
// count++;
// }
// if(count == T.length()){
// while(table[sa[start]]==0||window[sa[start]]>table[sa[start]]){
// if(window[sa[start]]>table[sa[start]]){
// window[sa[start]]--;
// }
// start++;
// }
// int len = end-start+1;
// if(len<minLen){
// minLen=len;
// minBegin = start;
// }
// }
// }
// return minLen<=S.length()?S.substring(minBegin,minBegin+minLen):"";
// }
// }

// Sort Colors
//
//
//
// public class Solution {
// public void sortColors(int[] A) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(A == null || A.length<2)return ;
// int red = 0;
// int blue = A.length-1;
// int cur =0;
// while(cur<=blue){
// if(A[cur]==0){
// A[cur] = A[red];
// A[red] = 0;
// red++;
// cur++;
// }else if(A[cur] == 2){
// int tmp = A[cur];
// A[cur] = A[blue];
// A[blue]= tmp;
// blue--;
// }else{
// cur++;
// }
// }
// }
// }

// Valid Palindrome
//
//
//
// public class Solution {
// public boolean isPalindrome(String s) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(s==null || s.isEmpty()){
// return true;
// }
// char[] ss = s.toLowerCase().toCharArray();
// int left =0;
// int right =ss.length-1;
// while(left<right){
// if(!isvalidchar(ss[left])){
// left++;
// }else if(!isvalidchar(ss[right])){
// right--;
// }else{
// if(ss[left] != ss[right]){
// return false;
// }
// left++;
// right--;
// }
// }
// return true;
// }
// public boolean isvalidchar(char s){
// if(s>='a' && s<='z' || s>='0'&& s<='9'){
// return true;
// }
// return false;
// }
// }

// Trapping Rain Water
//
//
// public class Solution {
// public int trap(int[] A) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(A.length <3)return 0;
// int len = A.length;
// int[] left = new int[len];
// int[] right = new int[len];
// for(int i=0; i<len;i++){
// left[i] = Math.max(A[i], (i== 0 ? 0 :left[i-1]));
// }
// for(int i= len-1 ; i>=0; i--){
// right[i] = Math.max(A[i], (i == len-1 ? 0 :right[i+1]));
// }
// int sum =0;
// for(int i=1 ; i<len-1;i++){
// sum+= Math.min(left[i], right[i])-A[i]; }
// return sum;
// }
// }

// public class Solution {
// public ArrayList<Integer> findSubstring(String S, String[] L) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<Integer> res = new ArrayList<Integer>();
// if(L == null || L == null){
// return res;
// }
// int len = L.length;
// int clen = L[0].length();
// HashMap<String,Integer> table = new HashMap<String, Integer>();
// for(String ss : L){
// if(table.containsKey(ss)){
// table.put(ss, table.get(ss)+1);
// }else{
// table.put(ss, 1);
// }
// }
// int cur =0;
// while(cur<=S.length()-len*clen){
// HashMap<String,Integer> table1 = new HashMap<String, Integer>();
// table1.putAll(table);
// for(int j=0;j<len;j++){
// String tmp = S.substring(cur+j*clen, cur+(1+j)*clen);
// if(table1.containsKey(tmp)){
// int resInt = table1.get(tmp)-1;
// if(resInt==0){
// table1.remove(tmp);
// }else{
// table1.put(tmp, resInt);
// }
// if(table1.size()==0){
// res.add(cur);
//
// break;
// }
// }else{
//
// break;
// }
// }
// cur++;
// }
// return res;
//
// }
// }

// Remove Duplicates from Sorted Array
//
//
// public class Solution {
// public int removeDuplicates(int[] A) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int index =1;
// int cur=0;
// if(A.length == 0) return 0;
// while(index<A.length){
// if(A[index]>A[cur]){
//
// A[cur+1]=A[index];
//
// index++;
// cur++;
// }else{
// index++;
// }
// }
// return cur+1;
// }
// }

// 4Sum
//
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// if(num.length<4)return res;
// Arrays.sort(num);
// HashSet<ArrayList<Integer>> table = new HashSet<ArrayList<Integer>>();
// for(int i=0; i<num.length-3; i++){
// for(int j=i+1; j<num.length-2; j++){
// int left = j+1;
// int right = num.length-1;
// while(left<right){
// int sum = num[i]+num[j]+num[left]+num[right];
// if(sum == target){
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// tmp.add(num[i]);
// tmp.add(num[j]);
// tmp.add(num[left]);
// tmp.add(num[right]);
// if(!table.contains(tmp)){
// table.add(tmp);
// res.add(tmp);
//
// }
// left++;
// right--;
// }else if(sum>target){
// right--;
// }else{
// left++;
// }
// }
// }
// }
// return res;
// }
// }

// 3Sum
//
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// if(num.length<3){
// return res;
// }
// Arrays.sort(num);
// HashSet<ArrayList<Integer>> table = new HashSet<ArrayList<Integer>>();
// for(int i=0; i<num.length-2;i++){
// int left = i+1;
// int right = num.length-1;
// while(left < right){
// int sum = num[i]+num[left]+num[right];
// if(sum == 0){
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// tmp.add(num[i]);
// tmp.add(num[left]);
// tmp.add(num[right]);
// if(!table.contains(tmp)){
// table.add(tmp);
// res.add(tmp);
// }
// left++;
// right--;
// }else if(sum<0){
// left++;
// }else{
// right--;
// }
// }
// }
// return res;
// }
// }

// subsets
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> subsets(int[] S) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// if(S == null)return res;
// Arrays.sort(S);
// return subset(S,0);
// }
// public ArrayList<ArrayList<Integer>> subset(int[] S, int index){
// ArrayList<ArrayList<Integer>> res;
// if(index == S.length){
// res = new ArrayList<ArrayList<Integer>>();
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// res.add(tmp);
// return res;
// }else{
// res = subset(S, index+1);
// ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
// for(ArrayList<Integer> tmp : res){
// ArrayList<Integer> tmp1 = new ArrayList<Integer>();
// tmp1.add(S[index]);
// tmp1.addAll(tmp);
//
// res2.add(tmp1);
// }
// res.addAll(res2);
// return res;
// }
// }
// }

// combinationSum
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if (candidates == null) return null;
// Arrays.sort(candidates);
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// comb(candidates, target, 0, 0,res,tmp );
// return res;
// }
// public void comb(int[] candidates, int target,int index, int curSum,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> tmp ){
// if(curSum > target){
// return;
// }
// if(curSum == target){
// ArrayList<Integer> tmp1 = new ArrayList<Integer>();
// tmp1.addAll(tmp);
// res.add(tmp1);
// return;
// }
//
// for(int i=index;i<candidates.length;i++){
// tmp.add(candidates[i]);
// curSum+=candidates[i];
// comb(candidates, target, i, curSum,res,tmp);
// tmp.remove(tmp.size()-1);
// curSum -= candidates[i];
// }
// }
// }

// Combinations
//
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> combine(int n, int k) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int[] resa = new int[k];
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// if(n<k){return res;}
// comb(n,k,res,resa,0,0);
// return res;
// }
// public void comb(int n, int k, ArrayList<ArrayList<Integer>> res, int[] resa,
// int curp, int np){
// if(curp == k){
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// for(int x : resa){
// tmp.add(x);
// }
// res.add(tmp);
// }else{
// for(int i = np; i<n && (n-i >= k-curp);i++){
// resa[curp] = i+1;
// comb(n,k,res,resa,curp+1,i+1);
// }
// }
//
// }
//
// }

// Permutations II
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
// // Start typing your Java solution below
// // DO NOT write main() function
//
// return perm(num, 0);
// }
// public ArrayList<ArrayList<Integer>> perm(int[] num, int index){
// ArrayList<ArrayList<Integer>> res;
// if(index == num.length-1){
// res = new ArrayList<ArrayList<Integer>>();
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// tmp.add(num[index]);
// res.add(tmp);
// return res;
// }
// res = perm(num,index+1);
// HashSet<ArrayList<Integer>> table = new HashSet<ArrayList<Integer>>();
// ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
// for(ArrayList<Integer> tmp : res){
// for(int i=0; i<=tmp.size(); i++){
// ArrayList<Integer> tmp2 = new ArrayList<Integer>();
// tmp2.addAll(tmp);
// tmp2.add(i,num[index]);
// if(!table.contains(tmp2)){
// table.add(tmp2);
// res2.add(tmp2);
// }
// }
// }
// return res2;
// }
// }

// Permutation
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> permute(int[] num) {
// // Start typing your Java solution below
// // DO NOT write main() function
// return perm(num,0);
// }
// public ArrayList<ArrayList<Integer>> perm(int[] num, int index){
// ArrayList<ArrayList<Integer>> res;
// if(index == num.length-1){
// res = new ArrayList<ArrayList<Integer>>();
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// tmp.add(index);
// res.add(tmp);
// }else{
// res = perm(num, index+1);
// ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
// for(ArrayList<Integer> tmp : res){
//
// for(int i=0; i<=tmp.size(); i++){
// ArrayList<Integer> tmp2 = new ArrayList<Integer>();
// tmp2.addAll(tmp);
// tmp2.add(i,num[index]);
// res2.add(tmp2);
// }
// return res2;
// }
// }
// return res;
//
// }
// }

// Longest Consecutive Sequence
//
//
// public class Solution {
// public int longestConsecutive(int[] num) {
// int max = 0;
// HashSet<Integer> h = new HashSet<Integer>();
// for (int n : num) {
// h.add(n);
// }
// for (int n : num) {
// max = Math.max(max, getCount(h, n, false) + getCount(h, n + 1, true));
// }
// return max;
// }
//
// public int getCount(HashSet<Integer> h, int value, boolean asc) {
// int count = 0;
// while (h.contains(value)) {
// count++;
// h.remove(value);
// if (asc)
// value++;
// else
// value--;
// }
// return count;
// }
// }

// Integer to Roman
//
//
// public class Solution {
// private static int[] bases = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9,
// 5, 4, 1 };
// private static HashMap<Integer, String> map = new HashMap<Integer, String>();
//
// private static void setup() {
// map.put(1, "I");
// map.put(4, "IV");
// map.put(5, "V");
// map.put(9, "IX");
// map.put(10, "X");
// map.put(40, "XL");
// map.put(50, "L");
// map.put(90, "XC");
// map.put(100, "C");
// map.put(400, "CD");
// map.put(500, "D");
// map.put(900, "CM");
// map.put(1000, "M");
// }
//
// public String intToRoman(int num) {
// setup();
// String result = new String();
// for (int i : bases) {
// while (num >= i) {
// result += map.get(i);
// num -= i;
// }
// }
// return result;
// }
// }

// Roman to Integer
//
//
// public class Solution {
// public int romanToInt(String s) {
// // Start typing your Java solution below
// // DO NOT write main() function
//
// HashMap<Character, Integer> map = new HashMap<Character, Integer>();
// map.put('I', 1);
// map.put('V', 5);
// map.put('X', 10);
// map.put('L', 50);
// map.put('C', 100);
// map.put('D', 500);
// map.put('M', 1000);
//
// int x = 0;
// for (int i = 0; i < s.length(); i++) {
// char c = s.charAt(i);
// x += sign(s, i, map) * map.get(c);
// }
//
// return x;
// }
//
// public int sign(String s, int i, HashMap<Character, Integer> map) {
// if (i == s.length()-1) {
// return 1;
// }
// if (map.get(s.charAt(i+1)) > map.get(s.charAt(i))) {
// return -1;
// }
// else {
// return 1;
// }
// }
// }

// Insert Interval
//
//
// public class Solution {
// public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
// // Start typing your Java solution below
// // DO NOT write main() function
//
// ArrayList<Interval> re = new ArrayList<Interval>();
//
// int len = intervals.size();
// int i = 0;
//
// while(i<len){
// Interval temp = intervals.get(i);
//
// if(temp.end < newInterval.start)
// re.add(temp);
// else if(temp.start>newInterval.end){
// break;
// }
// else{
// newInterval.start = Math.min(temp.start,newInterval.start);
// newInterval.end = Math.max(temp.end, newInterval.end);
// }
// i++;
//
// }
//
// re.add(newInterval);
//
// while(i<len){
// re.add(intervals.get(i));
// i++;
// }
//
// return re;
//
//
// }
// }

// Merge Intervals
//
//
// public class Solution {
// public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
// // Start typing your Java solution below
// // DO NOT write main() function
// Collections.sort(intervals, new Comparator<Interval>(){public int compare(Interval a, Interval b){return a.start>b.start?1:(a.start==b.start?0:-1);}});
//
// ArrayList<Interval> res = new ArrayList<Interval>();
//
// int i=0;
// while(i<intervals.size()){
// int j=i+1;
// int end = intervals.get(i).end;
// while(j<intervals.size() && end>=intervals.get(j).start){
// end=Math.max(end, intervals.get(j).end);
// j++;
// }
// res.add(new Interval(intervals.get(i).start,end));
// i=j;
//
// }
// return res;
// }
// }

// multiply string
//
//
// public class Solution {
// public String multiply(String num1, String num2) {
// // Start typing your Java solution below
// // DO NOT write main() function
//
// int[] num = new int[num1.length()+num2.length()];
// for(int i=0;i<num1.length();i++){
// int carry = 0;
// int a = num1.charAt(num1.length()-1-i)-'0';
// for(int j=0;j<num2.length();j++){
// int b = num2.charAt(num2.length()-1-j)-'0';
// num[i+j]+=carry+a*b;
// carry=num[i+j]/10;
// num[i+j]%=10;
// }
// num[i+num2.length()]+=carry;
// }
// int i=num.length-1;
// while(i>0 && num[i]==0) i--;
//
// StringBuilder temp = new StringBuilder("");
// while(i>=0)
// temp.append((char)('0'+num[i--]));
//
// return temp.toString();
// }
// }

// Spiral Matrix
//
//
// public class Solution {
// public ArrayList<Integer> spiralOrder(int[][] matrix) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(matrix==null || matrix.length==0 || matrix[0].length==0) return new ArrayList<Integer>();
// return spiralOrder(matrix,0,0,matrix.length,matrix[0].length);
// }
//
//
// public ArrayList<Integer> spiralOrder(int [][] matrix, int x, int y, int m, int n){
// ArrayList<Integer> res = new ArrayList<Integer>();
// if(m<=0||n<=0) return res;
// if(m==1&&n==1) {
// res.add(matrix[x][y]);
// return res;
// }
// for(int i=0;i<n-1;i++){
// res.add(matrix[x][y++]);
// }
// for(int i=0;i<m-1;i++){
// res.add(matrix[x++][y]);
// }
// if(m>1){
// for(int i=0;i<n-1;i++){
// res.add(matrix[x][y--]);
// }
// }
// if(n>1){
// for(int i=0;i<m-1;i++){
// res.add(matrix[x--][y]);
// }
// }
// if(m==1||n==1)
// res.addAll(spiralOrder(matrix,x,y,1,1));
// else
// res.addAll(spiralOrder(matrix,x+1,y+1,m-2,n-2));
// return res;
// }
// }

// Rotate Image
//
//
// public class Solution {
// public void rotate(int[][] matrix) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int n = matrix.length-1;
// for(int i=0; i<(n+1)/2; i++){
// for(int j=i; j<n-i;j++){
// int tmp = matrix[i][j];
// matrix[i][j] = matrix[n-j][i];
// matrix[n-j][i]= matrix[n-i][n-j];
// matrix[n-i][n-j]=matrix[j][n-i];
// matrix[j][n-i] = tmp;
//
// }
// }
// }
// }

// Anagrams
//
//
//
// public class Solution {
// public ArrayList<String> anagrams(String[] strs) {
// // Start typing your Java solution below
// // DO NOT write main() functiArrayList<E>
// HashMap<String,ArrayList<String>> table = new HashMap<String,ArrayList<String>>();
// ArrayList<String> res = new ArrayList<String>();
// if(strs == null || strs.length==0)return res;
// for(String tmp : strs){
// char[] tmp1 = tmp.toCharArray();
// Arrays.sort(tmp1);
// String key = new String(tmp1);
// if(table.containsKey(key)){
// table.get(key).add(tmp);
// }else{
// ArrayList<String> group = new ArrayList<String>();
// group.add(tmp);
// table.put(key, group);
// }
//
// }
//
// for(String key : table.keySet()){
// if(table.get(key).size()>1){
// res.addAll(table.get(key));
// }
//
// }
// return res;
// }
// }

// Set Matrix Zeroes
//
//
// public class Solution {
// public void setZeroes(int[][] matrix) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(matrix == null)return;
// int ro =matrix.length;
// int co = matrix[0].length;
// int[] row = new int[matrix.length];
// int[] col = new int[matrix[0].length];
// for(int i=0; i<ro;i++){
// for(int j=0; j<co;j++){
// if(matrix[i][j]==0){
// row[i]=1;
// col[j]=1;
// }
// }
// }
// for(int i=0; i<ro;i++){
// for(int j=0; j<co;j++){
// if(row[i]==1 ||col[j]==1 ){
// matrix[i][j]=0;
// }
// }
// }
// }
// }

// Valid Number
//
//
// public class Solution {
// public boolean isNumber(String s) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int len = s.length();
// int i = 0, e = len - 1;
// while (i <= e && Character.isWhitespace(s.charAt(i))) i++;
// if (i > len - 1) return false;
// while (e >= i && Character.isWhitespace(s.charAt(e))) e--;
// // skip leading +/-
// if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
// boolean num = false; // is a digit
// boolean dot = false; // is a '.'
// boolean exp = false; // is a 'e'
// while (i <= e) {
// char c = s.charAt(i);
// if (Character.isDigit(c)) {
// num = true;
// }
// else if (c == '.') {
// if(exp || dot) return false;
// dot = true;
// }
// else if (c == 'e') {
// if(exp || num == false) return false;
// exp = true;
// num = false;
// }
// else if (c == '+' || c == '-') {
// if (s.charAt(i - 1) != 'e') return false;
// }
// else {
// return false;
// }
// i++;
// }
// return num;
// }
// }

// Valid Parentheses
//
//
//
// public class Solution {
// public boolean isValid(String s) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(s==null||s.isEmpty()){return true;}
// if(s.length()%2!=0)return false;
// char[] cha = s.toCharArray();
// int a=0, b=0,c=0;
// Stack<Character> left = new Stack<Character>();
// for(int i=0;i<cha.length; i++){
// if(cha[i]=='('){
// a++;
// left.push(cha[i]);
// }else if(cha[i]=='{'){
// b++;
// left.push(cha[i]);
// }else if(cha[i]=='['){
// c++;
// left.push(cha[i]);
// }else if(cha[i]==')'){
// a--;
// if(a<0||left.size()==0||left.peek()!='('){
// return false;
// }
// left.pop();
// }else if(cha[i]=='}'){
// b--;
// if(b<0||left.size()==0||left.peek()!='{'){
// return false;
// }
// left.pop();
// }else if(cha[i]==']'){
// c--;
// if(c<0||left.size()==0||left.peek()!='['){
// return false;
// }
// left.pop();
// }
// }
// if(!left.isEmpty()){
// return false;
// }
// return true;
// }
// }

// Word ladder
//
//
// public class Solution {
// public int ladderLength(String start, String end, HashSet<String> dict) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(start.length() != end.length()){return 0;}
// ArrayList<String> visiting = new ArrayList<String>();
// ArrayList<Integer> level = new ArrayList<Integer>();
// HashSet<String> visited = new HashSet<String>();
// visiting.add(start);
// visited.add(start);
// level.add(1);
// while(!visiting.isEmpty()){
//
// String cur = visiting.remove(0);
// int lev = level.remove(0);
// if(cur.endsWith(end)){
// return lev;
// }else{
// for(String next : getAdjacent(cur,dict,visited)){
// if(next.equals(end)){
// return lev+1;
// }else{
// visiting.add(next);
// visited.add(next);
// level.add(lev+1);
// }
//
// }
// }
// }
// return 0;
// }
// public ArrayList<String> getAdjacent(String s,HashSet<String> dict,HashSet<String> visited){
// int size = s.length();
// char[] start = s.toCharArray();
// ArrayList<String> res = new ArrayList<String>();
// for(int i=0; i<size; i++){
// char tmp = start[i];
// for(char m='a';m<='z';m++ ){
// if(tmp!=m){
//
// start[i]=m;
// String next = new String(start);
// if(m=='g'){
// }
// if(dict.contains(next) && !visited.contains(next)){
// res.add(next);
// }
// start[i]=tmp;
// }
// }
// }
// return res;
// }
// }

// Gray Code
//
// public class Solution {
// public ArrayList<Integer> grayCode(int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<Integer> res = new ArrayList<Integer>();
// if(n == 0){
// res.add(0);
// return res;
// }else{
// res = grayCode(n-1);
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// for(int i=0; i<res.size();i++){
// if(i%2==0){
// tmp.add(res.get(i)*2);
// tmp.add(res.get(i)*2+1);
// }else{
// tmp.add(res.get(i)*2+1);
// tmp.add(res.get(i)*2);
// }
// }
// return tmp;
// }
//
// }
// }

// N-Queens
//
//
// public class Solution {
// public ArrayList<String[]> solveNQueens(int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<String[]> res = new ArrayList<String[]>();
// int[] nq = new int[n];
// solveN(n,res,nq,0);
// return res;
// }
// public void solveN(int n, ArrayList<String[]> res, int[] nq, int row){
// if(row == n){
// String[] str = new String[n];
// for(int i=0; i<n ; i++){
// int qPosition = nq[i];
// String s = "";
// for(int j=0; j<n; j++){
// if(j==qPosition){
// s+="Q";
// }else{
// s+=".";
// }
// }
// str[i]=s;
// }
// res.add(str);
// }else{
// for(int i=0; i<n; i++){
// nq[row]=i;
// if(isValid(row,nq)){
// solveN(n,res,nq,row+1);
// }
// }
// }
//
// }
// public boolean isValid(int row, int[] nq){
// for(int i=0; i<row; i++){
// if(nq[row] == nq[i]) return false;
// int dis1= Math.abs(row-i);
// int dis2= Math.abs(nq[row] - nq[i]);
// if(dis1 == dis2){
// return false;
// }
//
// }
// return true;
// }
// }

// Sudoku Solver
//
//
// public class Solution {
//
// public boolean isValid(char[][] board, int a, int b){
// boolean[] flag = new boolean[9];
//
// Set<Character> contained = new HashSet<Character>();
// for(int j=0;j<9;j++){
// if(contained.contains(board[a][j])) return false;
// if(board[a][j]>'0' && board[a][j]<='9')
// contained.add(board[a][j]);
// }
// contained = new HashSet<Character>();
// for(int j=0;j<9;j++){
// if(contained.contains(board[j][b])) return false;
// if(board[j][b]>'0' && board[j][b]<='9')
// contained.add(board[j][b]);
// }
// contained = new HashSet<Character>();
// for(int m=0;m<3;m++){
// for(int n=0;n<3;n++){
// int x=a/3*3+m, y=b/3*3+n;
// if(contained.contains(board[x][y])) return false;
// if(board[x][y]>'0' && board[x][y]<='9')
// contained.add(board[x][y]);
// }
// }
// return true;
// }
// public boolean solveSudoku(char[][] board) {
// // Start typing your Java solution below
// // DO NOT write main() function
// for(int i=0;i<9;i++){
// for(int j=0;j<9;j++){
// if(board[i][j]=='.'){
// for(int k=0;k<9;k++){
// board[i][j]=(char)('1'+k);
// if(isValid(board,i,j) && solveSudoku(board)) return true;
// board[i][j]='.';
// }
// return false;
// }
// }
// }
// return true;
// }
// }

// Generate Parentheses
//
//
// public class Solution {
// public ArrayList<String> generateParenthesis(int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<String> res = new ArrayList<String>();
// if(n<=0)return res;
// gener(n,n,res,"");
// return res;
// }
// public void gener(int left, int right, ArrayList<String> res, String s){
// if(left>right){
// return;
// }
// if(left == 0 && right == 0){
// res.add(s);
// }
// if(left >0 && left<=right){
//
// gener(left-1,right,res,s+"(");
// }
// if(right >0 && right>=left){
//
// gener(left,right-1,res,s+")");
// }
// }
// }

// Letter Combinations of a Phone Number
//
//
//
// public class Solution {
// public ArrayList<String> letterCombinations(String digits) {
// // Start typing your Java solution below
// // DO NOT write main() function
//
// ArrayList<String> res;
//
// if(digits == null || digits.isEmpty()){
// res =new ArrayList<String>();
// res.add("");
// return res;
// }
// String cur = digits.substring(0,1);
// res = letterCombinations(digits.substring(1,digits.length()));
// ArrayList<String> letters = getLetters(cur);
// ArrayList<String> res2 = new ArrayList<String>();
// for(String old : res){
// for(String cha : letters){
// res2.add(combine(old,cha));
// }
// }
// return res2;
// }
// public String combine(String old, String cha){
// return cha+old;
// }
// public ArrayList<String> getLetters(String cur){
// ArrayList<String> res = new ArrayList<String>();
// switch( Integer.valueOf(cur) ){
// case 2:
// res.add("a");
// res.add("b");
// res.add("c");
// break;
// case 3:
// res.add("d");
// res.add("e");
// res.add("f");
// break;
// case 4:
// res.add("g");
// res.add("h");
// res.add("i");
// break;
// case 5:
// res.add("j");
// res.add("k");
// res.add("l");
// break;
// case 6:
// res.add("m");
// res.add("n");
// res.add("o");
// break;
// case 7:
// res.add("p");
// res.add("q");
// res.add("r");
// res.add("s");
// break;
// case 8:
// res.add("t");
// res.add("u");
// res.add("v");
// break;
// case 9:
// res.add("w");
// res.add("x");
// res.add("y");
// res.add("z");
// break;
// }
// return res;
// }
// }

// Jump Game
// jump[i] = max(jump[i-1], A[i-1]) -1, i!=0
// jump[i] = 0 , i==0
//
// public class Solution {
// public boolean canJump(int[] A) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(A == null) return false;
// int n = A.length;
// int[] table = new int[A.length+1];
// table[0] = 0;
// for(int i=1; i<=n;i++){
// table[i]=Math.max(table[i-1]-1, A[i-1]);
// if(i<n && table[i]<=0){
// return false;
// }else if(i == n){
// return true;
// }
// }
// return true;
// }
// }

// Decode Ways
//
//
// public class Solution {
// public int numDecodings(String s) {
// if (s.length() == 0) return 0;
// int[] c = new int[s.length() + 1];
// c[0] = 1;
// if (s.charAt(0) != '0')
// c[1] = c[0];
// else
// c[1] = 0;
// for (int i = 2; i <= s.length(); i++) {
// if (s.charAt(i - 1) == '0') {
// c[i] = 0;
// } else {
// c[i] = c[i - 1];
// }
// if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
// c[i] += c[i - 2];
// }
// }
// return c[s.length()];
// }
// }

// Unique Binary Search Trees
//
//
// public class Solution {
// public int numTrees(int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(n<=0)return 0;
// int[] bsts = new int[n+1];
// bsts[0]=1;
// bsts[1]=1;
// for(int i=2; i<=n; i++){
// for(int left =0; left<i; left++){
// int leftT = bsts[left];
// int rightT = bsts[i-left-1];
// bsts[i] += leftT*rightT;
// }
// }
// return bsts[n];
//
//
// }
// }

// Edit Distance
//
//
//public class Solution {
//	public int minDistance(String word1, String word2) {
//		int[][] table = new int[word1.length() + 1][word2.length() + 1];
//		for (int i = 0; i < table.length; ++i) {
//			for (int j = 0; j < table[i].length; ++j) {
//				if (i == 0)
//					table[i][j] = j;
//				else if (j == 0)
//					table[i][j] = i;
//				else {
//					if (word1.charAt(i - 1) == word2.charAt(j - 1))
//						table[i][j] = table[i - 1][j - 1];
//					else
//						table[i][j] = 1 + Math.min(Math.min(table[i - 1][j - 1], table[i - 1][j]), table[i][j - 1]);
//				}
//			}
//		}
//		return table[word1.length()][word2.length()];
//	}
//}

// Best Time to Buy and Sell Stock II
//
//
// public class Solution {
// public int maxProfit(int[] prices) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int minPrice = 0;
// int maxPro = 0;
// for(int i =1; i<prices.length; i++){
// if(prices[i]<prices[minPrice]){
// minPrice =i;
// }else{
// maxPro += prices[i]-prices[minPrice];
// minPrice = i;
// }
// }
// return maxPro;
// }
// }

// Best Time to Buy and Sell Stock
//
//
// public class Solution {
// public int maxProfit(int[] prices) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(prices == null) return 0;
// int maxPro = 0;
// int minIndex = 0;
// for(int i=1; i<prices.length; i++){
// if(prices[i] < prices[minIndex]){
// minIndex = i;
// }else{
// int tmp = prices[i]- prices[minIndex];
// if(tmp > maxPro){
// maxPro = tmp;
// }
// }
//
// }
// return maxPro;
// }
// }

// Unique Paths II
//
//
// public class Solution {
// public int uniquePathsWithObstacles(int[][] obstacleGrid) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int[][] grid = obstacleGrid;
// int m = grid.length;
// int n = m > 0 ? grid[0].length : 0;
// int[][] sum = new int[m][n];
// for(int i = 0; i < m; i++){
// for(int j = 0; j < n; j++){
// if(grid[i][j] == 0){
// if(i == 0 && j == 0){
// sum[i][j] = 1;
// }else{
// sum[i][j] = (i > 0 ? sum[i - 1][j] : 0) + (j > 0 ? sum[i][j - 1] : 0);
// }
// }
// }
// }
// if(m == 0 || n == 0){
// return 0;
// }else{
// return sum[m - 1][n - 1];
// }
// }
//
// }

// public class Solution {
// public int uniquePaths(int m, int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int dp[][] = new int[m][n];
// for(int i =0;i<m;i++)
// dp[i][0] = 1;
// for(int i =0;i<n;i++)
// dp[0][i] = 1;
// for(int i = 1; i<m;i++){
// for(int j = 1;j<n;j++){
// dp[i][j] = dp[i-1][j] + dp[i][j-1];
// }
// }
// return dp[m-1][n-1];
//
// }
// }
//

// Maximum Subarray
//
//
// public class Solution {
// public int maxSubArray(int[] A) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int maxSum = Integer.MIN_VALUE;
// int sum =0;
// for(int a : A){
// sum += a;
//
// if(sum >maxSum){
// maxSum =sum ;
// }
//
// if(sum<0){
// sum =0;
// }
//
// }
// return maxSum;
// }
// }

// Triangle
//
//
// public class Solution {
// public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
// if(triangle == null || triangle.size() == 0) return 0;
// if(triangle.size() == 1) return triangle.get(0).get(0);
//
// ArrayList<int[]> dp = new ArrayList<int[]>();
//
// for(int i = 0; i < triangle.size() - 1; i++){
// dp.add(new int[i + 1]);
// }
//
// return find(dp, 0, 0, triangle);
//
// }
//
// public int find(ArrayList<int[]> dp, int row, int colum, ArrayList<ArrayList<Integer>> triangle){
// if(row == triangle.size() - 1){
// return triangle.get(row).get(colum);
// }
//
// if(dp.get(row)[colum] == 0){
// dp.get(row)[colum] = triangle.get(row).get(colum) +
// Math.min(find(dp, row + 1, colum, triangle), find(dp, row + 1, colum + 1, triangle));
// }
//
// return dp.get(row)[colum];
// }
// }

// Binary Tree Maximum Path Sum
//
//
//
// public class Solution {
// public int maxPathSum(TreeNode root) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int[] res = maxPathSums(root);
// return res[1];
// }
//
// public int[] maxPathSums(TreeNode root){
// int[] res = new int[2];
// if(root==null){
// res[0]=Integer.MIN_VALUE; // Must be min value since it will add root.val;
// res[1]=Integer.MIN_VALUE;
// return res;
// }
// int[] fromLeft = maxPathSums(root.left),
// fromRight = maxPathSums(root.right);
//
// int temp1 = fromLeft[0]>0?(fromLeft[0]+root.val):root.val;
// int temp2 = fromRight[0]>0?(fromRight[0]+root.val):root.val;
//
// res[0]=Math.max(temp1,temp2);
// res[1]=Math.max(fromLeft[1],Math.max(fromRight[1], Math.max(temp1+temp2-root.val,res[0]))); //double root.val and if fromLeft or fromRightis negative will not be added.
//
// return res;
// }
// }

// find path 2
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<Integer>> res =new ArrayList<ArrayList<Integer>>();
// if(root == null) return res;
// int level = findDeep(root);
// int[] arr = new int[level];
// arr[0] = root.val;
// pathS(root, sum,arr, 0, res);
// return res;
// }
// public void pathS(TreeNode root, int sum, int[] arr , int index ,ArrayList<ArrayList<Integer>> res){
// arr[index] = root.val;
// if(root.left == null && root.right == null){
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// int sum1=0;
// for(int i=0 ; i<index+1; i++){
// sum1 += arr[i];
// tmp.add(arr[i]);
//
// }
// if(sum == sum1){
// res.add(tmp);
// }
// }else{
//
// if(root.left == null){
// pathS(root.right, sum, arr, index+1, res);
//
// }else if(root.right ==null){
// pathS(root.left, sum, arr, index+1, res);
//
// }else{
// pathS(root.left, sum, arr, index+1, res);
// pathS(root.right, sum, arr, index+1, res);
// }
//
// }
//
//
// }
// public int findDeep(TreeNode root){
// if(root == null )return 0;
// return Math.max(findDeep(root.left)+1, findDeep(root.right)+1);
// }
// }

// Path Sum
//
//
// public class Solution {
// public boolean hasPathSum(TreeNode root, int sum) {
// // Start typing your Java solution below
// // DO NOT write main() function
//
// if(root == null) return false;
// if(root.val == sum && root.right == null && root.left == null){
// return true;
// }
// sum = sum - root.val;
//
// return hasPathSum(root.left, sum)|| hasPathSum(root.right , sum);
//
// }
// }

// Construct Binary Tree from Preorder and Inorder Traversal
//
//
// public class Solution {
// public TreeNode buildTree(int[] preorder, int[] inorder) {
// // Start typing your Java solution below
// // DO NOT write main() function
// return buildBt(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
// }
// public TreeNode buildBt(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
// if(prestart> preend || instart > inend)return null;
// TreeNode root = new TreeNode(preorder[prestart]);
// for(int i =0 ; i <= inend - instart ; i++){
// if(inorder[i+instart]==root.val){
// TreeNode left = buildBt(preorder, prestart+1, prestart+i, inorder, instart, instart+i-1);
// TreeNode right = buildBt(preorder, prestart+i+1, preend, inorder, instart+i+1, inend);
// root.left = left;
// root.right = right;
// }
// }
// return root;
// }
// }

// Construct Binary Tree from Inorder and Postorder Traversal
//
//
// public class Solution {
// public TreeNode buildTree(int[] inorder, int[] postorder) {
// // Start typing your Java solution below
// // DO NOT write main() function
// return buildBt(inorder,0,inorder.length-1, postorder, 0 , postorder.length-1);
// }
// public TreeNode buildBt(int[] inorder,int instart, int inend, int[] postorder, int poststart, int postend){
// if(instart > inend || poststart > postend){
// return null;
// }
// TreeNode root = new TreeNode(postorder[postend]);
// for(int i=0; i<=inend-instart; i++){
// if(inorder[i+instart] == root.val){
// TreeNode left = buildBt(inorder, instart, instart+i-1, postorder, poststart, poststart+i-1);
// TreeNode right = buildBt(inorder, instart+i+1, inend, postorder, poststart+i,postend-1);
// root.left = left;
// root.right = right;
// }
// }
// return root;
// }
// }

// Flatten Binary Tree to Linked List
//
// import javax.swing.tree.TreeNode;
//
// public class Solution {
// public void flatten(TreeNode root) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<TreeNode> res = new ArrayList<TreeNode>();
// flat(root,res);
// for(int i=0; i<res.size();i++){
// TreeNode cur =res.get(i);
// cur.left = null;
// if(i == res.size()-1){
// cur.right = null;
// }else{
// cur.right = res.get(i+1);
// }
// }
//
// }
// public void flat(TreeNode root , ArrayList<TreeNode> res){
// if(root == null){
// return;
// }
// res.add(root);
// flat(root.left , res);
// flat(root.right , res);
// }
// }
//

// Binary Tree Level Order Traversal II
//
//
//
// import javax.swing.tree.TreeNode;
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// if(root == null)return res;
// ArrayList<TreeNode> visiting = new ArrayList<TreeNode>();
// ArrayList<TreeNode> next = new ArrayList<TreeNode> ();
// visiting.add(root.val);
// ArrayList<Integer> list = new ArrayList<Integer>();
// while(!visiting.isEmpty()){
// TreeNode cur = visiting.remove(0);
// list.add(cur.val);
// if(cur.left!=null)next.add(cur.left);
// if(cur.right != null) next.add(cur.right);
//
// if(visiting.isEmpty()){
// res.add(list);
// list = new ArrayList<Integer>();
// visiting = next;
// next = new ArrayList<TreeNode> ();
// }
// }
// ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
// for(int i = res.size()-1 ; i >=0;i--){
// res2.add(res.get(i));
// }
//
// return res2;
// }
// }
//
//

// Binary Tree Inorder Traversal
//
//
//
//
// import javax.swing.tree.TreeNode;
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(root == null)return null;
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// ArrayList<Integer> level = new ArrayList<Integer>();
// ArrayList<TreeNode> visiting = new ArrayList<TreeNode>();
// visiting.add(root);
// level.add(0);
// ArrayList<Integer> temp2 = new ArrayList<Integer>();
// temp2.add(root.val);
// res.add(temp2);
//
// while(!visiting.isEmpty()){
// TreeNode cur = visiting.remove(0);
// int lev= level.remove(0);
// if(cur.left!=null){
// visiting.add(cur.left);
// level.add(lev+1);
// }
// if(cur.right != null) {
// visiting.add(cur.right);
// level.add(lev+1);}
// int size = level.size()-1;
//
//
// if(size>0 && level!=null&&level.get(size)==level.get(0)&&level.get(0)==lev+1&&visiting!=null){
// ArrayList<Integer> temp = new ArrayList<Integer>();
// for(TreeNode node : visiting){
// temp.add(node.val);
// }
// res.add(temp);
// }
// }
//
// return res;
// }
// }

// Binary Tree Inorder Traversal
//
// public class Solution {
// public ArrayList<Integer> inorderTraversal(TreeNode root) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<Integer> res = new ArrayList<Integer>();
//
// inorder(res,root);
// return res;
// }
// public void inorder(ArrayList<Integer> res, TreeNode root){
// if(root == null){
// return;
// }
// inorder(res,root.left);
// res.add(root.val);
// inorder(res,root.right);
// }
// }

// Convert Sorted Array to Binary Search Tree
//
//
// public class Solution {
// public TreeNode sortedArrayToBST(int[] num) {
// // Start typing your Java solution below
// // DO NOT write main() function
// return convert(num,0,num.length-1);
// }
//
// public TreeNode convert(int[] num, int left, int right){
// if(left > right){
// return null;
// }
// int mid = (left+right)/2;
// TreeNode root = new TreeNode(num[mid]);
// TreeNode leftr = convert(num, left, mid-1);
// TreeNode rightr = convert(num,mid+1,right);
// root.left = leftr;
// root.right = rightr;
// return root;
// }
// }

// convert sorted array to binary search tree
//
//
// public class Solution {
// static ListNode head;
// public TreeNode sortedListToBST(ListNode head) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(head==null) return null;
// ListNode curr=head;
// this.head = head;
// int size=1;
// while (null != (curr = curr.next)) size++;
// return deep(0, size-1);
// }
// public TreeNode deep( int start, int end){
// if (start > end) return null;
// int mid = start + (end - start) / 2;
// TreeNode leftTree = deep( start, mid - 1);
// TreeNode root = new TreeNode(head.val);
// root.left = leftTree;
// head = head.next;
// root.right = deep( mid + 1, end);
// return root;
// }
// }

// Recover Binary Search Tree O(n) Space
//
//
// public class Solution {
// ArrayList<TreeNode> nodes;
// ArrayList<Integer> values;
// public void inOrder(TreeNode root){
// if(root == null) return;
//
// inOrder(root.left);
//
// values.add(root.val);
// nodes.add(root);
//
// inOrder(root.right);
// }
// public void recoverTree(TreeNode root) {
// // Start typing your Java solution below
// // DO NOT write main() function
// nodes = new ArrayList<TreeNode>();
// values = new ArrayList<Integer>();
// inOrder(root);
// Collections.sort(values);
// int index = 0;
// for(TreeNode n : nodes){
// n.val = values.get(index++);
// }
//
// }
// }

// Validate Binary Search Tree
//
//
// public class Solution {
// public boolean isValidBST(TreeNode root) {
// // Start typing your Java solution below
// // DO NOT write main() function
// return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
// }
// public boolean isValid(TreeNode root, int left, int right){
// if(root == null){
// return true;
// }
// if(root.val >= right || root.val <= left){
// return false;
// }
// return isValid(root.left,left,root.val)&&isValid(root.right,root.val,right);
// }
// }

// Reverse Linked List II
//
//
// class ListNode {
// int val;
// ListNode next;
// ListNode(int x) {
// val = x;
// next = null;
// }
// }
// public class Solution {
// public ListNode reverseBetween(ListNode head, int m, int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(head == null || head.next == null)return null;
// if(n==m)return head;
// ListNode p1 = head;
// ListNode pre = new ListNode(-1);
// pre.next = p1;
// int m1 = m;
// while(m1>1){
// p1=p1.next;
// pre = pre.next;
// m1--;
// }
// ListNode post = p1.next;
// int x=0;
// while(p1!=null){
// ListNode tmp = post.next;
// post.next = p1;
// p1=post;
// post=tmp;
// x++;
// if(x==n-m){
// break;
// }
// }
// ListNode tmp = pre.next;
// pre.next = p1;
// tmp.next = post;
// if(m ==1 )return pre.next;
// return head;
// }
// }
//

// Partition List
//
// public class Solution {
// public ListNode partition(ListNode head, int x) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(head == null) return null;
// ListNode lst=new ListNode(-1);
// ListNode lend=new ListNode(-1);
// ListNode rst=new ListNode(-1);
// ListNode rend=new ListNode(-1);
// while(head!=null){
// ListNode cur = head;
//
// if(cur.val < x){
// if(lst.val == -1){
// lst =cur;
// lend=cur;
// }else{
// lend.next=cur;
// lend=lend.next;
// }
// }else{
// if(rst.val == -1){
// rst = cur;
// rend=cur;
// }else{
// rend.next = cur;
// rend = rend.next;
// }
// }
// head = head.next;
// cur.next = null;
// }
// if(lst.val==-1){
// return rst;
// }
// if(rst.val == -1){
// return lst;
// }
// lend.next=rst;
// return lst;
// }
// }

// Rotate List
//
//
// public class Solution {
// public ListNode rotateRight(ListNode head, int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(n==0)return head;
// if(head == null){
// return null;
// }
// ListNode point1 = head;
// ListNode point2 = head;
// while(n>0){
// point2=point2.next;
// n--;
// if(point2 == null){
// point2 = head;
// }
// }
// while(point2.next!=null){
// point1=point1.next;
// point2=point2.next;
// }
// if(point1.next == null){
// return head;
// }
// ListNode pre=point1.next;
// point2.next=head;
// point1.next=null;
// return pre;
//
// }
// }

// Polish Notation
//
// import java.util.Stack;
// public class Solution {
// public int polishNotation(String s){
// Stack<Integer> stac = new Stack<Integer>();
// for(int i=s.length()-1; i>=0;i--){
//
// if(s.charAt(i)<='9' && s.charAt(i)>='0'){
// System.out.println("in "+s.charAt(i));
// stac.push(Integer.valueOf(s.substring(i,i+1)));
// }else{
// int a=stac.pop();
// System.out.println("out "+a);
// int b=stac.pop();
// System.out.println("out "+b);
// stac.push(count(a,b,s.charAt(i)));
// }
// }
// return stac.pop();
// }
// private int count(int a, int b, char c){
// switch(c){
// case '+': return a+b;
// case '-': return a-b;
// case '*': return a*b;
// case '/': return a/b;
// }
// return 0;
// }
// }

// Remove Nth Node From End of List
//
// public class Solution {
// public ListNode removeNthFromEnd(ListNode head, int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ListNode p1 = head;
// ListNode p2 = head;
// int k = n;
// while(p2!=null && k>0){
// p2=p2.next;
// k--;
// }
// if(p2 == null && k>0){
// return null;
// }
// while(p2 != null && p2.next!=null){
// p2 = p2.next;
// p1=p1.next;
// }
// if(p1 == head && p2==null){
// return head.next;
// }else{
// p1.next = p1.next.next;
// }
// return head;
// }
// }

// Remove Duplicates from Sorted List
//
// public class Solution {
// public ListNode deleteDuplicates(ListNode head) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(head == null || head.next == null){return head;}
// ListNode pre = new ListNode(-1);
// pre.next = head;
//
// HashMap<Integer,Boolean> table = new HashMap<Integer,Boolean>();
// while(head != null){
// ListNode cur = head;
// while(cur.next != null){
// if(cur.next.val == head.val){
// cur.next = cur.next.next;
//
// }else{
// cur = cur.next;
// }
//
// }
// head=head.next;
// }
// return pre.next;
// }
// }

// Merge Two Sorted Lists
//
// public class Solution {
// public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(l1 == null){
// return l2;
// }else if( l2 == null){
// return l1;
// }
// ListNode head = new ListNode(-1);
// ListNode pre = (l1.val <= l2.val)? l1: l2;
// head.next = pre;
// if(pre == l1){
// l1= l1.next;
// }else{
// l2 =l2.next;
// }
// while(l1 != null && l2 != null){
// if(l1.val <= l2.val){
// pre.next = l1;
// l1=l1.next;
// pre = pre.next;
// }else{
// pre.next = l2;
// l2=l2.next;
// pre = pre.next;
// }
// }
// if(l1 != null){
// pre.next = l1;
// }
// if(l2 != null){
// pre.next = l2;
// }
// return head.next;
// }
// }

// Reverse Nodes in k-Group
//
//
// public class Solution {
// public ListNode reverseKGroup(ListNode head, int k) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(head == null || k == 1)return head;
// int size = 0;
// ListNode point = head;
// while(point != null){
// point = point.next;
// size++;
// }
// int loop = size / k;
// ListNode pre2 = new ListNode(-1);
// pre2.next=head;
// ListNode pre = pre2;
// ListNode cur = head;
// ListNode next = head.next;
// for(int i=0; i<loop;i++){
// int j =0;
// next = cur.next;
// while(cur.next!=null){
// ListNode tmp = next.next;
// next.next=cur;
// cur=next;
// next=tmp;
// j++;
// if(j == k-1){
// break;
// }
//
// }
// ListNode tmp = pre.next;
// tmp.next = next;
// pre.next = cur;
// pre = tmp;
// cur = pre.next;
// }
// return pre2.next;
//
// }
// }

// Reverse Nodes in k-Group
//
//
// public class Solution {
// public ListNode reverseKGroup(ListNode head, int k) {
// // Start typing your Java solution below
// // DO NOT write main() function
//
// if(head == null || k == 1)
// return head;
//
// int len = 0;
// ListNode p = head;
// while(p != null){
// p = p.next;
// len ++;
// }
//
// ListNode safeG = new ListNode(-1);
// safeG.next = head;
// ListNode pre = safeG, cur = head, post = head.next;
//
// int m = len / k;
// for(int i = 0; i < m; i++){
// post = cur.next;
// //reverse(pre, cur, post, k);
// int j = 0;
// while(post != null){
// ListNode tmp = post.next;
// post.next = cur;
// cur = post;
// post = tmp;
// j ++;
// if(j == k - 1)
// break;
// }
// ListNode tmp = pre.next;
// pre.next = cur;
// tmp.next = post;
// pre = tmp;
// cur = pre.next;
//
// }
//
// return safeG.next;
// }
// }

// Merge Two Sorted Lists
//
//
// public class Solution {
// public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(l1 == null){
// return l2;
// }else if(l2 == null){
// return l1;
// }
// ListNode head = new ListNode(0);
// ListNode start =head;
// while(l2 != null && l1 != null){
// if(l2.val<l1.val){
// head.next = l2;
// head = l2;
// l2=l2.next;
//
// }else{
// head.next = l1;
// head = l1;
// l1 = l1.next;
// }
// }
// if(l1 != null){
// head.next=l1;
// }else if(l2!=null){
// head.next = l2;
// }
// return start.next;
// }
// }

// Remove Duplicates from Sorted List
//
//
//
// import java.util.HashMap;
//
// public class Solution {
// public ListNode deleteDuplicates(ListNode head) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(head == null || head.next == null){
// return head;
// }
// ListNode start = head;
// HashMap<Integer,Boolean> table = new HashMap<Integer,Boolean>();
// table.put(start.val,true);
// while(start!=null && start.next!=null){
// ListNode next = start.next;
// if(!table.containsKey(next.val)){
// table.put(next.val,true);
// start=next;
// }else{
// start.next = next.next;
// }
// }
// return head;
// }
// }

// Remove Nth Node From End of List
//
//
// public class Solution {
// public ListNode removeNthFromEnd(ListNode head, int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ListNode p1 = head;
// ListNode p2 = head;
// int k = n;
// while(p2!=null && k>0){
// p2=p2.next;
// k--;
// }
// if(p2 == null && k>0){
// return null;
// }
// while(p2 != null && p2.next!=null){
// p2 = p2.next;
// p1=p1.next;
// }
// if(p1 == head && p2==null){
// return head.next;
// }else{
// p1.next = p1.next.next;
// }
// return head;
// }
// }

// Search a 2D Matrix
//
//
// public class Solution {
// public boolean searchMatrix(int[][] matrix, int target) {
// // Start typing your Java solution below
// // DO NOT write main() function
// int y =0;
// int x = matrix.length-1;
//
// while(x>=0 && y<matrix[0].length){
// if(matrix[x][y] == target){
// return true;
// }else if(matrix[x][y]>target){
// x--;
// }else{
// y++;
// }
// }
// return false;
//
// }
// }

// Sqrt(x)
//
//
// public class Solution {
// public int sqrt(int x) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(x<0){
// return -1;
// }
// return findsqrt(0,x,x);
// }
// public int findsqrt(long left , long right, int x){
// if(left > right){
// return -1;
// }
// long mid = (left+right)/2;
// long tmp = mid*mid;
// if(tmp <= x && (mid+1)*(mid+1)>x){
// return (int)mid;
// }else if(tmp>x){
// return findsqrt(left,mid-1,x);
// }else{
// return findsqrt(mid+1,right,x);
// }
// }
// }

// Media of two sorted array C++
//
//
// class Solution {
// public:
// double findMedianSortedArrays(int A[], int m, int B[], int n) {
// if((n+m)%2 ==0)
// {
// return (GetMedian(A,m,B,n, (m+n)/2) + GetMedian(A,m,B,n, (m+n)/2+1))/2.0;
// }
// else
// return GetMedian(A,m,B,n, (m+n)/2+1);
// }
// int GetMedian(int a[], int n, int b[], int m, int k)
// {
// assert(a && b);
// if (n <= 0) return b[k-1];
// if (m <= 0) return a[k-1];
// if (k <= 1) return min(a[0], b[0]);
// if (b[m/2] >= a[n/2])
// {
// if ((n/2 + 1 + m/2) >= k)
// return GetMedian(a, n, b, m/2, k);
// else
// return GetMedian(a + n/2 + 1, n - (n/2 + 1), b, m, k - (n/2 + 1));
// }
// else
// {
// if ((m/2 + 1 + n/2) >= k)
// return GetMedian( a, n/2,b, m, k);
// else
// return GetMedian( a, n, b + m/2 + 1, m - (m/2 + 1),k - (m/2 + 1));
// }
// }
// };

// Pow(x, n)

// public class Solution {
// public double pow(double x, int n) {
// // Start typing your Java solution below
// // DO NOT write main() function
// x = n<0? 1/x: x;
// n = n<0? -n : n;
//
// if(n==0){
// return 1;
// }
// double m = pow(x*x, n/2);
// if(n%2==1){
// m=m*x;
// }
// return m;
// }
// }

// Search for a range

// public class Solution {
// public int[] searchRange(int[] A, int target) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(A == null){
// return null;
// }
// int left = searchInd(A,0,A.length-1,true,target);
// int right = searchInd(A,0,A.length-1,false,target);
// int[] res = new int[2];
// res[0]=left;
// res[1]=right;
// return res;
// }
// public int searchInd(int[] A, int left, int right, boolean searchLeft, int target){
// if(right<left){
// return -1;
// }
// int mid =(left+right)/2;
// if(A[mid] == target){
// if(searchLeft){
// int res = searchInd(A,left,mid-1,searchLeft,target);
// return res == -1 ? mid:res;
// }else{
// int res = searchInd(A,mid+1,right,searchLeft,target);
// return res == -1 ? mid:res;
// }
// }else if(target > A[mid]){
// return searchInd(A, mid+1,right,searchLeft,target);
// }else{
// return searchInd(A,left,mid-1,searchLeft,target);
// }
// }
// }

// Search in Rotated Sorted Array
//
// public class Solution {
// public int search(int[] A, int target) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(A == null){
// return -1;
// }
// return searchInd (A,0,A.length-1,target);
// }
// public int searchInd(int[] A, int left, int right,int target){
// if(left > right){
// return -1;
// }
// int mid =(left+right)/2;
// if(A[mid] == target){
// return mid;
// }
// if(A[mid]>A[right]){
// if(target <A[mid] && target >= A[left]){
// return searchInd(A,left,mid-1,target);
// }else{
// return searchInd(A,mid+1,right,target);
// }
// }else if(A[mid]<A[right]){
// if(target <= A[right] && target>A[mid]){
// return searchInd(A,mid+1,right,target);
// }else{
// return searchInd(A,left,mid-1,target);
// }
// }else{
// return searchInd(A,left,right-1,target);
// }
// }
// }

// Find Missing Number

// public class Solution {
// public int getMissing (int[] arr){
// if( arr == null){
// return -1;
// }
// int left=0;
// int right=arr.length-1;
// while(left <= right){
// int mid = (left + right)/2;
// if(arr[mid]!=mid){
// if(mid == 0){
// return mid;
// }else if(arr[mid-1] == mid-1){
// return mid;
// }else{
// right = mid -1;
// continue;
// }
// }else{
// left = mid+1;
// continue;
// }
// }
// return -1;
// }
// }

// import java.util.HashMap;
//
// public class Solution {
// public String minWindow(String S, String T) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(S == null || T == null){
// return "";
// }
// int lenS = S.length();
// int lenT = T.length();
// if(lenS<lenT){
// return "";
// }
// int left=0;
// int right=lenS;
// int start=0;
// int end=0;
// int minSize = Integer.MAX_VALUE;
// HashMap<Character,Integer> table = new HashMap<Character,Integer>();
// for(int i=0;i<lenT;i++){
// if(table.containsKey(T.charAt(i))){
// table.put(T.charAt(i), table.get(T.charAt(i))+1);
// }else{
// table.put(T.charAt(i), 1);
// }
// }
// while(left+lenT<=lenS){
// if(!table.containsKey(S.charAt(left))){
// left++;
// continue;
// }else{
// HashMap<Character,Integer> table2 = new HashMap<Character,Integer>(table);
// for(int j=0; j+left<lenS && j<minSize;j++){
// if(!table2.containsKey(S.charAt(left+j))){
// continue;
// }else{
// int total = table2.get(S.charAt(j+left))-1;
// if(total == 0){
// table2.remove(S.charAt(j+left));
// }else{
// table2.put(S.charAt(j+left), total);
// }
// if(table2.size()==0){
// int tmp = j;
// if(tmp<minSize){
// minSize = tmp;
// start=left;
// end = left+j;
// if(minSize == lenT-1){
// return S.substring(start, end+1);
// }
// }
// break;
// }
// }
// }
// left++;
// }
// }
// if(minSize <= lenS){
// return S.substring(start, end+1);
// }else{
// return "";
// }
// }
// }
//
//

// Valid Palindrome

// public class Solution {
// public boolean isPalindrome(String s) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(s == null || s.length()<2){
// return true;
// }
// s=s.toLowerCase();
// int left =0;
// int right = s.length()-1;
// while(left<right){
// if(!((s.charAt(left)<='z'&&s.charAt(left)>='a')||(s.charAt(left)<='9'&&s.charAt(left)>='0'))){
// left++;
// continue;
// }
// if(!((s.charAt(right)<='z'&&s.charAt(right)>='a')||(s.charAt(right)<='9'&&s.charAt(right)>='0'))){
// right--;
// continue;
// }
// if(s.charAt(left) != s.charAt(right)){
// return false;
// }else{
// left++;
// right--;
// }
// }
// return true;
// }
// }

// Substring with Concatenation of All Words

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Map;
//
// public class Solution {
// public ArrayList<Integer> findSubstring(String S, String[] L) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<Integer> res = new ArrayList<Integer>();
// int lenC = L[0].length();
// int lenL = L.length;
// if(S == null || S.length() < lenC*lenL){
// return res;
// }
//
// Map<String,Integer> table = new HashMap<String,Integer>();
// for(String elem : L){
// if(table.containsKey(elem)){
// int value = table.get(elem)+1;
// table.put(elem, value);
// }else{
// table.put(elem, 1);
// }
// }
//
// for(int i=0 ; i+lenL*lenC<=S.length(); i++){
// HashMap<String,Integer> temptable = new HashMap<String,Integer>(table);
// for(int j=0; j<lenL; j++){
// String tmp = S.substring(i+j*lenC, i+(1+j)*lenC);
// if(temptable.containsKey(tmp)){
// int quan = temptable.get(tmp)-1;
// if(quan <= 0){
// temptable.remove(tmp);
// }else{
// temptable.put(tmp, quan);
// }
//
// }else{
// break;
// }
//
// }
// if(temptable.size() == 0){
// res.add(i);
// }
//
// }
// return res;
// }
// }

// str Str

// public class Solution {
// public String strStr(String haystack, String needle) {
// // Start typing your Java solution below
// // DO NOT write main() function
// assert(haystack!=null && needle!=null);
// if(needle.length()==0) return haystack;
// int indexH=0;
// int sizeN=needle.length();
// while(indexH+sizeN <= haystack.length()){
// if(haystack.charAt(indexH)!=needle.charAt(0)){
// indexH++;
// }else{
// for(int i=1;i<sizeN;i++){
// if(haystack.charAt(indexH+i)!=needle.charAt(i)){
// indexH++;
// continue;
// }
// }
// return haystack.substring(indexH);
// }
// }
// return null;
// }
// }

// 4sum

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// if(num.length<4){
// return res;
// }
// Arrays.sort(num);
// HashMap<String,Boolean> table = new HashMap<String,Boolean>();
// for(int i=0;i<num.length-3;i++){
// for(int j=i+1;j<num.length-2;j++){
// int left = j+1;
// int right=num.length-1;
// while(left<right){
// if(left-1>j&&num[left]==num[left-1]){
// left++;
// continue;
// }
// if(right+1<num.length&&num[right]==num[right+1]){
// right--;
// continue;
// }
// int sum = num[i]+num[j]+num[left]+num[right];
// if(sum==target){
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// tmp.add(num[i]);
// tmp.add(num[j]);
// tmp.add(num[left]);
// tmp.add(num[right]);
// StringBuffer key = new StringBuffer();
// key.append(num[i]);
// key.append(num[j]);
// key.append(num[left]);
// key.append(num[right]);
// if(!table.containsKey(key.toString())){
// table.put(key.toString(), true);
// res.add(tmp);
// }
// left++;
// right--;
// }else if (sum<target){
// left++;
// }else{
// right--;
// }
// }
// }
// }
// return res;
// }
// }

// 3Sum

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// if(num == null || num.length<3){
// return res;
// }
// Arrays.sort(num);
// int sum;
//
// HashMap<ArrayList<Integer>,Boolean> table = new HashMap<ArrayList<Integer>,Boolean>();
// for(int i=0; i<num.length-2; i++){
// int left = i+1;
// int right = num.length-1;
// while(left<right){
// if(left-1>i&&num[left]==num[left-1]){
// left++;
// continue;
// }
// if(right+1<num.length&&num[right] == num[right+1]){
// right--;
// continue;
// }
// sum=num[i]+num[left]+num[right];
// if(sum == 0){
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// tmp.add(num[i]);
// tmp.add(num[left]);
// tmp.add(num[right]);
// if(!table.containsKey(tmp)){
// table.put(tmp, true);
// res.add(tmp);
// }
// left++;
// right--;
// }else if(sum<0){
// left++;
// }else{
// right--;
// }
// }
// }
// return res;
// }
// }

// Container With Most Water
//
// public class Solution {
// public int maxArea(int[] height) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(height == null || height.length == 1){
// return 0;
// }
// int area = 0;
// int maxArea=0;
// int left=0;
// int right=height.length-1;
// while(left<right){
// if(height[left]<=height[right]){
// area = height[left]*(right-left);
// if(area > maxArea){
// maxArea = area;
// }
// left++;
// }else{
// area = height[right]*(right-left);
// if(area > maxArea){
// maxArea = area;
// }
// right--;
// }
// }
// return maxArea;
// }
// }

// Longest Substring Without Repeating Characters
//
// public class Solution {
// public int lengthOfLongestSubstring(String s) {
// // Start typing your Java solution below
// // DO NOT write main() function
// char[] str = s.toCharArray();
// if(s == null || s.equals("")){
// return 0;
// }
// int maxLen = 1;
// int len = 0;
// int uniqueIndex = 0;
// int cur = 1;
// while(cur<str.length){
// int i = uniqueIndex;
// while(i<cur){
// if(str[cur] != str[i]){
// i++;
// }else{
// uniqueIndex = i+1;
// len = cur-i;
// if(len > maxLen){
// maxLen = len;
// }
// break;
// }
// }
//
// if(i==cur){
// len=cur-uniqueIndex+1;
// if(len>maxLen){
// maxLen = len;
// }
// }
// cur++;
// }
// return maxLen;
// }
// }

// Combination Sum
//
// import java.util.ArrayList;
// import java.util.Arrays;
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if (candidates == null) return null;
// Arrays.sort(candidates);
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// comb(candidates, target, 0, 0,res,tmp );
// return res;
// }
// public void comb(int[] candidates, int target,int index, int curSum,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> tmp ){
// if(curSum > target){
// return;
// }
// if(curSum == target){
// ArrayList<Integer> tmp1 = new ArrayList<Integer>();
// tmp1.addAll(tmp);
// res.add(tmp1);
// return;
// }
//
// for(int i=index;i<candidates.length;i++){
// tmp.add(candidates[i]);
// curSum+=candidates[i];
// comb(candidates, target, i, curSum,res,tmp);
// tmp.remove(tmp.size()-1);
// curSum -= candidates[i];
// }
// }
// }

// Subset 2

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
// // Start typing your Java solution below
// // DO NOT write main() function
// Arrays.sort(num);
// HashMap<ArrayList<Integer>,Boolean> table = new HashMap<ArrayList<Integer>,Boolean>();
// return subsets(num,0,table);
// }
// public ArrayList<ArrayList<Integer>> subsets(int[] num, int index,HashMap<ArrayList<Integer>,Boolean> table){
// ArrayList<ArrayList<Integer>> res ;
//
// if(index == num.length){
// res = new ArrayList<ArrayList<Integer>>();
// res.add(new ArrayList<Integer>());
// return res;
// }
//
// res = subsets(num,index+1,table);
// ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
// ArrayList<Integer> newa;
// for(ArrayList<Integer> a : res){
// newa = new ArrayList<Integer>();
// newa.add(num[index]);
// newa.addAll(a);
// if(!table.containsKey(newa)){
// table.put(newa, true);
// res2.add(newa);
// }
//
// }
// res.addAll(res2);
// return res;
// }
// }

// subset

// import java.util.ArrayList;
// import java.util.Arrays;
//
// public class Solution {
//
// public ArrayList<ArrayList<Integer>> subsets(int[] S) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// Arrays.sort(S);
// return getSubsets(res,S,0);
// }
// public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<ArrayList<Integer>> res, int[] S, int index ){
// if(index == S.length){
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// res.add(tmp);
// return res;
// }
//
// res = getSubsets(res,S,index+1);
// ArrayList<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
// ArrayList<Integer> tmp ;
// for(ArrayList<Integer> a : res){
// tmp = new ArrayList<Integer>();
// tmp.add(S[index]);
// tmp.addAll(a);
//
// res2.add(tmp);
// }
// res.addAll(res2);
// return res;
// }
// }

// Integer palindrome
// public class Solution {
// public boolean isPalindrome(int x) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(x<0)return false;
// int a =x;
// int b = 0;
// while(a>0){
// b=b*10 + a%10;
// a=a/10;
// }
// if(a==0) return x == b;
// else{
// return x == b || x == b/10 ;
// }
// }
// }

// Palindrome Partitioning

// import java.util.ArrayList;
//
// public class Solution {
// public ArrayList<ArrayList<String>> partition(String s) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
// ArrayList<String> tmp = new ArrayList<String>();
// partit(res,tmp,0,s);
// return res;
// }
//
// public void partit(ArrayList<ArrayList<String>> res, ArrayList<String> tmp, int start, String s){
// if(start == s.length()){
// ArrayList<String> tmp1 = new ArrayList<String>(tmp);
// res.add(tmp1);
// return ;
// }
// for(int i=start+1; i<=s.length();i++){
// if(isPalin(s,start,i)){
// tmp.add(s.substring(start,i));
// partit(res,tmp,i,s);
// tmp.remove(tmp.size()-1);
// }
// }
// }
//
// public boolean isPalin(String s, int start, int i){
// if(start > i-1){
// return false;
// }
// while(start < i-1){
// if(s.charAt(start)!=s.charAt(i-1)){
// return false;
// }
// start++;
// i--;
// }
// return true;
//
// }
// }

// combine

// import java.util.ArrayList;
//
// public class Solution {
// public ArrayList<ArrayList<Integer>> combine(int n, int k) {
// // Start typing your Java solution below
// // DO NOT write main() function
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// if(n<k){
// return res;
// }
// int[] tmp = new int[k];
// comb(n,k,0,0,res,tmp);
// return res ;
// }
//
// public void comb(int n, int k, int pos, int curpos, ArrayList<ArrayList<Integer>> res, int[] tmp){
// if(curpos == k){
// ArrayList<Integer> tmp1 = new ArrayList<Integer>();
// for(int j : tmp){
// tmp1.add(j);
// }
// res.add(tmp1);
// }else{
// for(int i=pos; i<n&&(k-curpos<=n-i); i++){
// tmp[curpos]=i+1;
// comb(n,k,i+1,curpos+1,res,tmp);
// }
// }
//
//
// }
// }

// permute

// import java.util.ArrayList;
// import java.util.HashMap;

// public class Solution {
// public ArrayList<ArrayList<Integer>> permute(int[] num) {
// // Start typing your Java solution below
// // DO NOT write main() function
// if(num == null){
// return null;
// }
// return permutRes(num,0);
// }
// public ArrayList<ArrayList<Integer>> permutRes(int[] num, int index){
// ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// HashMap<String,Boolean> table = new HashMap<String,Boolean>();
// if(num.length == index){
//
// ArrayList<Integer> tmp = new ArrayList<Integer>();
// res.add(tmp);
// return res;
// }
// ArrayList<ArrayList<Integer>> callback = new ArrayList<ArrayList<Integer>>();
// callback = permutRes(num,index+1);
// for(ArrayList<Integer> tmp : callback){
// if(tmp == null){
// tmp.add(num[index]);
// res.add(tmp);
// }else{
// for(int i=0; i<=tmp.size();i++){
// ArrayList<Integer> tmp2 = new ArrayList<Integer>();
// tmp2.addAll(tmp);
// tmp2.add(i, num[index]);
// String tmp3 = toString(tmp2);
// if(!table.containsKey(tmp3)){
// res.add(tmp2);
// table.put(tmp3, true);
// }
//
// }
// }
// }
// return res;
// }
//
// public String toString(ArrayList<Integer> tmp){
// String res = "";
// for(Integer a : tmp){
// res+=a;
// }
// return res;
// }
// }