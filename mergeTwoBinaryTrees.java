import java.util.LinkedList;
import java.util.Queue;


public class mergeTwoBinaryTrees 
{
	//Definition for a binary tree node.
	public mergeTwoBinaryTrees() {}
	public static class TreeNode 
	{
	    int val;
	    TreeNode left;
	    TreeNode right;
	    public TreeNode() {}
	    public TreeNode(int x) 
	    { 
	    	val = x;
	    	left = null;
	    	right = null;
	    }
	    
	    public TreeNode setTreeNode(int[] x)
	    {
	    	int len = x.length;
	    	TreeNode[] nodes = new TreeNode[len];
	    	for(int i=0; i<len; i++)
	    	{
	    		TreeNode parent = new TreeNode(x[i]);
	    		nodes[i] = parent;
	    	}
	    	
	    	int lastP = len/2;  //最后一个有孩子的节点
	    	for(int i=len; i>lastP; i--)
	    	{
	    		int child = i;
	    		int pa = i/2;
	    		while(pa>=1)
	    		{
		            TreeNode parent = nodes[pa-1];
		    		if(child%2 == 0)
		    		{
		    			TreeNode le = nodes[child-1];
		    			parent.left = le;
		    		}
		    		else
		    		{
		    			TreeNode ri = nodes[child-1];
		    			parent.right = ri;
		    			TreeNode le = nodes[child-2];
		    			parent.left = le;
		    			//i--;
		    		}
		    		child = pa;
		    		pa /= 2;
	    		}
	    	}
			return nodes[0];
	    }
	    
	    public void printTree(TreeNode t)
	    {
	    	/*if(t != null)  先序遍历
	    	{
	    		System.out.print(t.val + " ");
	    		printTree(t.left);
	    		printTree(t.right);
	    	}*/
	    	
	    	Queue q = new LinkedList();
	    	q.offer(t);
	    	while(q.size()!=0)
	    	{
	    		t = (TreeNode) q.poll();
	    		System.out.print(t.val + " ");
	    		if(t.left != null) q.offer(t.left);
		    	if(t.right != null) q.offer(t.right);
	    	}
	    	System.out.println();
	    }
	}
	
    public static void mergeTrees(TreeNode t1, TreeNode t2) 
    {
    	TreeNode newT = null;
    	int[] newTx = new int[100];
    	int i=0;
    	if( t1!=null && t2!=null )
    	{
    		//newT = new TreeNode(t1.val + t2.val);
    		Queue q1 = new LinkedList();
	    	q1.offer(t1);
	    	Queue q2 = new LinkedList();
	    	q2.offer(t2);
	    	while(q1.size()!=0 && q2.size()!=0 )
	    	{
	    		t1 = (TreeNode) q1.poll();
	    		t2 = (TreeNode) q2.poll();
	    		newTx[i++] = t1.val+t2.val;
	    		if(t1.left != null) q1.offer(t1.left);
		    	if(t1.right != null) q1.offer(t1.right);
		    	if(t2.left != null) q2.offer(t2.left);
		    	if(t2.right != null) q2.offer(t2.right);
	    	}
	    	while(q1.size()!=0)
	    	{
	    		t1 = (TreeNode) q1.poll();
	    		newTx[i++] = t1.val;
	    		if(t1.left != null) q1.offer(t1.left);
		    	if(t1.right != null) q1.offer(t1.right);
	    	}
	    	while(q2.size()!=0)
	    	{
	    		t2 = (TreeNode) q2.poll();
	    		newTx[i++] = t2.val;
	    		if(t2.left != null) q2.offer(t2.left);
		    	if(t2.right != null) q2.offer(t2.right);
	    	}
    	}
    	
    	for(i=0; newTx[i]!='\0'; i++)
    	{
    		System.out.print(newTx[i]+" ");
    	}
    }
    
    public static void main(String[] args)
    {
    	//mergeTwoBinaryTrees mT = new mergeTwoBinaryTrees();
    	int[] x = {1,3,2,5};
    	TreeNode t1 = new TreeNode();
    	t1 = t1.setTreeNode(x);
    	t1.printTree(t1);
    	
    	int[] y = {2,1,3,0,4,0,7};
    	TreeNode t2 = new TreeNode();
    	t2 = t2.setTreeNode(y);
    	t2.printTree(t2);
    	
    	mergeTrees(t1,t2);
    }
}
