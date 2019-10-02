import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	public void testFindLCA() {
		
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        assertEquals(tree.findLCA(2, 4),2);
        assertEquals(tree.findLCA(6, 7),3);
        assertEquals(tree.findLCA(5, 5),5);
        assertEquals(tree.findLCA(1, 2),1);
	    assertEquals(tree.findLCA(1, 1),1);
	    assertEquals(tree.findLCA(0,0),0);
	}
}
