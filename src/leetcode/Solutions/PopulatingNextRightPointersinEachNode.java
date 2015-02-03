package leetcode.Solutions;

import java.util.ArrayList;

import leetcode.Utility.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
        if(root == null){
        	return;
        }
        ArrayList<TreeLinkNode> lis = new ArrayList<TreeLinkNode>();
        ArrayList<TreeLinkNode> lis2 = new ArrayList<TreeLinkNode>();
        lis.add(root);
        while(!lis.isEmpty()){
        	TreeLinkNode cur = lis.remove(0);
        	if(cur.left != null){
        		lis2.add(cur.left);
        	}
        	if(cur.right != null){
        		lis2.add(cur.right);
        	}
        	
        	if(lis.isEmpty()){
        		cur.next = null;
        		lis = lis2;
        		lis2 = new ArrayList<TreeLinkNode>();
        	}else{
        		cur.next = lis.get(0);
        	}
        }
    }
}
