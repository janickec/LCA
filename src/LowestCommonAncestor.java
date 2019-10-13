//solution found on https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
import java.util.ArrayList; 
import java.util.List; 

// A Binary Tree node 
class Node { 
	int data; 
	Node left, right; 

	Node(int value) { 
		data = value; 
		left = right = null; 
	} 
} 

class DagNode{
	int data;
	int next;
	int nextNext;
	DagNode nextNode;
	DagNode(int value, int next){
		data= value;
		nextNode= new DagNode(next, nextNext);
	}
	
}

public class LowestCommonAncestor
{ 
    DagNode dagRoot;
	
    Node root; 
	private List<Integer> path1 = new ArrayList<>(); 
	private List<Integer> path2 = new ArrayList<>(); 

	int findLCADag(int n1, int n2){
		path1.clear(); 
		path2.clear(); 
	return findLCAInternalDag(dagRoot, n1, n2);	
	}
	
	int findLCAInternalDag(DagNode dagRoot, int n1, int n2) {
		if (!findDagPath(dagRoot, n1, path1) || !findDagPath(dagRoot, n2, path2)) { 
			System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
			System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing"); 
			return -1; 
		} 

		int i; 
		for (i = 0; i < path1.size() && i < path2.size(); i++) { 
			
		// System.out.println(path1.get(i) + " " + path2.get(i)); 
			if (!path1.get(i).equals(path2.get(i))) 
				break; 
		} 

		return path1.get(i-1); 
		
	}
	
	
	boolean findDagPath(DagNode dagRoot, int n, List<Integer> path){
		if (dagRoot==null) {
		return false;
		}
		path.add(dagRoot.data);
		if (dagRoot.data==n) {
			return true;
		}
		if(dagRoot.nextNode != null && findDagPath(dagRoot.nextNode, n, path)) {
			return true;
		}
		path.remove(path.size()-1);
		return false;
	}
	
	
	// Finds the path from root node to given root of the tree. 
	int findLCA(int n1, int n2) { 
		path1.clear(); 
		path2.clear(); 
		return findLCAInternal(root, n1, n2); 
	} 

	private int findLCAInternal(Node root, int n1, int n2) { 

		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) { 
			System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
			System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing"); 
			return -1; 
		} 

		int i; 
		for (i = 0; i < path1.size() && i < path2.size(); i++) { 
			
		// System.out.println(path1.get(i) + " " + path2.get(i)); 
			if (!path1.get(i).equals(path2.get(i))) 
				break; 
		} 

		return path1.get(i-1); 
	} 
	
	// Finds the path from root node to given root of the tree, Stores the 
	// path in a vector path[], returns true if path exists otherwise false 
	private boolean findPath(Node root, int n, List<Integer> path) 
	{ 
		// base case 
		if (root == null) { 
			return false; 
		} 
		
		// Store this node . The node will be removed if 
		// not in path from root to n. 
		path.add(root.data); 

		if (root.data == n) { 
			return true; 
		} 

		if (root.left != null && findPath(root.left, n, path)) { 
			return true; 
		} 

		if (root.right != null && findPath(root.right, n, path)) { 
			return true; 
		} 

		// If not present in subtree rooted with root, remove root from 
		// path[] and return false 
		path.remove(path.size()-1); 

		return false; 
	} 
	

	// Driver code 
	public static void main(String[] args) 
	{ 
		 
	
	} 
} 


