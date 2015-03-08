package leetcode.Utility;

import leetcode.Solutions.Solution;


public class Main {
public static void main(String[] args){
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	TreeNode n4 = new TreeNode(4);
	TreeNode n5 = new TreeNode(5);
	TreeNode n6 = new TreeNode(6);
	TreeNode n7 = new TreeNode(7);
	TreeNode n8 = new TreeNode(8);
	
	
	n1.left = n2;
	n1.right = n3;
	n2.left = n4;
	n2.right = n5;
	n3.right = n6;
	n6.left = n7;
	n6.right = n8;
	
	Solution so = new Solution();
	System.out.println(so.findLCA(n1, n4, n7).val);
	
	System.out.println(so.findLCA(n1, n3, n7).val);
	
	
	System.out.println(so.findLCA(n1, n4, n5).val);
	
	
	System.out.println(so.findLCA(n1, n2, n6).val);
			
	}

}








//public class Main {
//	public static void main(String[] args){
//		// {{1,1},2,{1,1}}
//		NestedInteger a1 = new NestedInteger();
//		NestedInteger a2 = new NestedInteger();
//		NestedInteger a3 = new NestedInteger();
//		NestedInteger a4 = new NestedInteger();
//		NestedInteger a5 = new NestedInteger();
//		
//		NestedInteger a6 = new NestedInteger();
//		NestedInteger a7 = new NestedInteger();
//		
//		a1.setVal(1);
//		a3.setVal(1);
//		a4.setVal(1);
//		a5.setVal(1);
//		a2.setVal(2);
//		List<NestedInteger> arrlist = new ArrayList<NestedInteger>();
//		List<NestedInteger> arrlist2 = new ArrayList<NestedInteger>();
//		List<NestedInteger> arrlist3 = new ArrayList<NestedInteger>();
//		
//		arrlist2.add(a1);
//		arrlist2.add(a3);
//		arrlist3.add(a4);
//		arrlist3.add(a5);
//		a6.setListVal(arrlist2);
//		a7.setListVal(arrlist3);
//		arrlist.add(a6);
//		arrlist.add(a2);
//		arrlist.add(a7);
//		
//		Solution solt = new Solution();
//		System.out.println(solt.getLevelSum_bfs(arrlist));
//		System.out.println(solt.getLevelSum_dfs(arrlist));
//		System.out.println(solt.getReversLevelSum_bfs(arrlist));
//		System.out.println(solt.getReversLevelSum_dfs(arrlist));
//		
//		//{1,{4,{6}}}
//		NestedInteger b1 = new NestedInteger();
//		NestedInteger b2= new NestedInteger();
//		NestedInteger b3 = new NestedInteger();
//		NestedInteger b4 = new NestedInteger();
//		NestedInteger b5 = new NestedInteger();
//		
//		
//		b1.setVal(1);
//		b2.setVal(4);
//		b3.setVal(6);
//		
//		List<NestedInteger> arrl = new ArrayList<NestedInteger>();
//		List<NestedInteger> arrl2 = new ArrayList<NestedInteger>();
//		List<NestedInteger> arrl3 = new ArrayList<NestedInteger>();
//		
//		arrl2.add(b3);
//		b4.setListVal(arrl2);
//		
//		arrl3.add(b2);
//		arrl3.add(b4);
//		b5.setListVal(arrl3);
//		arrl.add(b1);
//		arrl.add(b5);
//		System.out.println(solt.getLevelSum_bfs(arrl));
//		System.out.println(solt.getLevelSum_dfs(arrl));
//		System.out.println(solt.getReversLevelSum_bfs(arrl));
//		System.out.println(solt.getReversLevelSum_dfs(arrl));
//		
//		
//		System.out.println("level");
//		 List<List<NestedInteger>> r1 = solt.getLevelTravel_bfs(arrlist);
//		 for(List<NestedInteger> li : r1){
//			 for(NestedInteger n : li){
//				 System.out.println(n.getVal());
//			 }
//			 System.out.println("nextlevel");
//		 }
//		 List<List<NestedInteger>> r2 = solt.getLevelTravel_bfs(arrl);
//		 
//		 System.out.println("level");
//		 for(List<NestedInteger> li : r2){
//			 for(NestedInteger n : li){
//				 System.out.println(n.getVal());
//			 }
//			 System.out.println("nextlevel");
//		 }
//		 
//	}
//}
