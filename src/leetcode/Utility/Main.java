package leetcode.Utility;

import java.util.ArrayList;
import java.util.List;

import leetcode.Solutions.Solution;





public class Main {
	public static void main(String[] args){
		// {{1,1},2,{1,1}}
		NestedInteger a1 = new NestedInteger();
		NestedInteger a2 = new NestedInteger();
		NestedInteger a3 = new NestedInteger();
		NestedInteger a4 = new NestedInteger();
		NestedInteger a5 = new NestedInteger();
		
		NestedInteger a6 = new NestedInteger();
		NestedInteger a7 = new NestedInteger();
		
		a1.setVal(1);
		a3.setVal(1);
		a4.setVal(1);
		a5.setVal(1);
		a2.setVal(2);
		List<NestedInteger> arrlist = new ArrayList<NestedInteger>();
		List<NestedInteger> arrlist2 = new ArrayList<NestedInteger>();
		List<NestedInteger> arrlist3 = new ArrayList<NestedInteger>();
		
		arrlist2.add(a1);
		arrlist2.add(a3);
		arrlist3.add(a4);
		arrlist3.add(a5);
		a6.setListVal(arrlist2);
		a7.setListVal(arrlist3);
		arrlist.add(a6);
		arrlist.add(a2);
		arrlist.add(a7);
		
		Solution solt = new Solution();
		System.out.println(solt.getLevelSum_bfs(arrlist));
		System.out.println(solt.getLevelSum_dfs(arrlist));
		
		//{1,{4,{6}}}
		NestedInteger b1 = new NestedInteger();
		NestedInteger b2= new NestedInteger();
		NestedInteger b3 = new NestedInteger();
		NestedInteger b4 = new NestedInteger();
		NestedInteger b5 = new NestedInteger();
		
		
		b1.setVal(1);
		b2.setVal(4);
		b3.setVal(6);
		
		List<NestedInteger> arrl = new ArrayList<NestedInteger>();
		List<NestedInteger> arrl2 = new ArrayList<NestedInteger>();
		List<NestedInteger> arrl3 = new ArrayList<NestedInteger>();
		
		arrl2.add(b3);
		b4.setListVal(arrl2);
		
		arrl3.add(b2);
		arrl3.add(b4);
		b5.setListVal(arrl3);
		arrl.add(b1);
		arrl.add(b5);
		System.out.println(solt.getLevelSum_bfs(arrl));
		System.out.println(solt.getLevelSum_dfs(arrl));
	}
}
