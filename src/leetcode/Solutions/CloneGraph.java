package leetcode.Solutions;

import java.util.HashMap;
import java.util.LinkedList;

import leetcode.Utility.UndirectedGraphNode;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph_bfs(UndirectedGraphNode node) {
        if(node == null)
            return null;
            
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        queue.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode curnode = queue.poll();
            for(UndirectedGraphNode aneighbor: curnode.neighbors){//check each neighbor
                if(!hm.containsKey(aneighbor)){//if not visited,then add to queue
                    queue.add(aneighbor);
                    UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
                    hm.put(aneighbor, newneighbor);
                }
                
                hm.get(curnode).neighbors.add(hm.get(aneighbor));
            }
        }
        
        return head;
    }
	
	public UndirectedGraphNode cloneGraph_dfs(UndirectedGraphNode node) {
        if(node == null)
            return null;
            
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        
        DFS(hm, node);//DFS
        return head;
    }
    public void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node){
        if(node == null)
            return;
            
        for(UndirectedGraphNode aneighbor: node.neighbors){ 
            if(!hm.containsKey(aneighbor)){
                UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
                hm.put(aneighbor, newneighbor);
                DFS(hm, aneighbor);//DFS
            }
            hm.get(node).neighbors.add(hm.get(aneighbor));
        }
    }
    
    public UndirectedGraphNode cloneGraph_dfs2(UndirectedGraphNode node) {
        if(node == null)
            return null;
            
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        stack.push(node);
        
        while(!stack.isEmpty()){
            UndirectedGraphNode curnode = stack.pop();
            for(UndirectedGraphNode aneighbor: curnode.neighbors){//check each neighbor
                if(!hm.containsKey(aneighbor)){//if not visited,then push to stack
                    stack.push(aneighbor);
                    UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
                    hm.put(aneighbor, newneighbor);
                }
                
                hm.get(curnode).neighbors.add(hm.get(aneighbor));
            }
        }
        
        return head;
    }
}
