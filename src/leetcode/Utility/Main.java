package leetcode.Utility;

import java.util.HashSet;

import leetcode.Solutions.Solution;





public class Main {
	public static void main(String[] args){
		
		Solution solut = new Solution();

		for(String tmp : solut.combinFactors(12)){
			System.out.println(tmp);
		}
		
		for(String tmp : solut.combinFactors(1)){
			System.out.println(tmp);
		}
		
		for(String tmp : solut.combinFactors(8)){
			System.out.println(tmp);
		}
		
		
		
		//		HashSet<String> dic = new HashSet<String>();
//		dic.add("sam");
//		dic.add("sung");
//		dic.add("I");
//		dic.add("like");
//		
//		System.out.println(solut.isWord("Ilikesamsung", dic));
//		System.out.println(solut.isWord("Ilike2samsung", dic));
//		System.out.println(solut.isWord("IsamsungIlike", dic));
		
		//		System.out.println(solut.change(11, new int[]{1,3,5}));
//		System.out.println(solut.change(1, new int[]{2,3,5}));
//		System.out.println(solut.change(5, new int[]{2,3,5}));
//		System.out.println(solut.change(6, new int[]{2,3,5}));
//		List<Integer> res = solut.findCombination(12, new int[]{10,5,1,6});
//		
//		for(int tmp : res){
//			System.out.println(tmp);
//		}
//		
//		List<Integer> res2 = solut.findCombination(12, new int[]{10,5,1,6,11});
//		
//		for(int tmp : res2){
//			System.out.println(tmp);
//		}
//		
//		List<Integer> res3 = solut.findCombination(12, new int[]{10,5,1,6,12});
//		
//		for(int tmp : res3){
//			System.out.println(tmp);
//		}
		
		
//		DivideTwoIntegers st = new DivideTwoIntegers();
//		st.divide(Integer.MIN_VALUE, -1);
//		System.out.println(st.largestNumber(new int[]{3, 30, 34, 5, 9}));
//		st.numDecodings("0");
//		st.numDistinct("ccc", "c");
//		st.isPalindrome(1874994781);
//		st.exist(new char[][]{{'a','b'},{'c','d'}}, "acdb");
//		st.setZeroes(new int[][]{{0,1}});
		
//		st.push(0);
//		st.push(1);
//		st.push(0);
//		System.out.println(st.trailingZeroes(16));
//		System.out.println(st.trailingZeroes(26));
//		System.out.println(st.trailingZeroes(51));
//		System.out.println(st.lengthOfLongestSubstring("abba"));
		//
//		System.out.println(solut.isOneEditDistance("abccd", "aabcd"));
		
		//		ListNode a = new ListNode(-1);
//		ListNode a2 = new ListNode(5);
//		ListNode a3 = new ListNode(11);
//		
//		ListNode b1 = new ListNode(6);
//		ListNode b2 = new ListNode(10);
//		
//		a.next = a2;
//		a2.next = a3;
//		
//		b1.next = b2;
//		List<ListNode> lists = new ArrayList<ListNode>();
//		lists.add(null);
//		lists.add(a);
//		lists.add(null);
//		lists.add(b1);
//		
//		ListNode res = solut.mergeKLists(lists);
//		
//		while(res != null){
//			System.out.println(res.val);
//		}
//		System.out.println(solut.maxProduct(new int[]{-4,-3,-2}));
		
//		System.out.println(solut.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//		System.out.println(solut.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		
//		ListNode a1 = new ListNode(1);
//		ListNode a2 = new ListNode(2);
//		ListNode a3 = new ListNode(3);
//		ListNode a4 = new ListNode(4);
//		ListNode a5 = new ListNode(5);
//		ListNode a6 = new ListNode(6);
//		ListNode a7 = new ListNode(7);
//		ListNode a8 = new ListNode(8);
//		ListNode a9 = new ListNode(9);
		
//		a1.next = a2;
//		a2.next = a3;
//		a3.next = a4;
//		a4.next = a5;
//		a5.next = a6;
//		a6.next = a7;
//		a7.next = a8;
//		a8.next = a9;
		
		
//		ListNode res = solut.reverseKGroup(a1, 3);
//		while(res != null){
//			System.out.println(res.val);
//			res = res.next;
//		}
	}
}
