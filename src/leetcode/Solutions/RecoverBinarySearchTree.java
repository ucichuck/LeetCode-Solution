package leetcode.Solutions;

import leetcode.Utility.TreeNode;

public class RecoverBinarySearchTree {
	TreeNode pre;       // ָ��ǰ����Ԫ�ص�ǰһ��  
	   TreeNode first; // ��һ�������Ԫ��  
	   TreeNode second;// �ڶ��������Ԫ��  
	   public void recoverTree(TreeNode root) {  
	       
	       pre = null;         // �����������ʼ��һ�飬����OJ�ᱨ��  
	       first = null;  
	       second = null;  
	       inorder(root);  
	       if(first!=null && second!=null){        // ֻ��Ҫ����Ԫ��ֵ����û��Ҫ����ָ�������  
	           int tmp = first.val;  
	           first.val = second.val;  
	           second.val = tmp;  
	       }  
	   }  
	   
	   public void inorder(TreeNode root){  
	       if(root == null){  
	           return;  
	       }  
	       inorder(root.left);  
	       if(pre == null){  
	           pre = root;  
	       }else{  
	           if(pre.val > root.val){  
	               if(first == null){  
	                   first = pre;        // �ҵ���һ�������Ԫ��  
	               }  
	               second = root;      // �ڶ��������Ԫ�ء��������else�����޷�ͨ��ֻ������Ԫ�ص����  
	           }  
	           pre = root;             // ��������  
	       }  
	       inorder(root.right);  
	   }  
}
