import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	
	public void testNormalParameters() {	
		//We build a tree, containing seven nodes, where node one is the root.
		
		LowestCommonAncestor tree = new LowestCommonAncestor();
		
		tree.root = new Node(1); 
		
        tree.root.left = new Node(2); 
        
        tree.root.right = new Node(3); 
        
        tree.root.left.left = new Node(4); 
        
        tree.root.left.right = new Node(5); 
        
        tree.root.right.left = new Node(6); 
        
        tree.root.right.right = new Node(7); 
        
        //First we try normal parameters, where both parameters are different and the LCA is a different node as well.
        
        assertEquals(tree.findLCA(3, 4),1);
        
        assertEquals(tree.findLCA(6, 7),3);
        
        //Then we try out what happens when we have the same parameter twice, with the LCA obviously being the same.
        
        assertEquals(tree.findLCA(5, 5),5);
        
        //Here we test what happens when the root is one of the parameters(or both).
        
        assertEquals(tree.findLCA(1, 2),1);
        
	    assertEquals(tree.findLCA(1, 1),1);
	    
	    //We also make sure, that putting the higher number first, is not a problem with the implementation.
	    
	    assertEquals(tree.findLCA(7, 6),3);
	    
	    assertEquals(tree.findLCA(6, 4),1);
	    
	    assertEquals(tree.findLCA(5, 2),2);
	    
	    //We try out just a few more cases just to make sure there is not some sort of bug somewhere.
	    
	    assertEquals(tree.findLCA(2, 3),1);
	    
	    assertEquals(tree.findLCA(3, 7),3);
	    
	    assertEquals(tree.findLCA(7, 2),1);
	    
	    assertEquals(tree.findLCA(4, 6),1);
	    
	    assertEquals(tree.findLCA(5, 7),1);
	    
	    assertEquals(tree.findLCA(6, 5),1);
	    
	    assertEquals(tree.findLCA(3, 6),3);
	    
	    assertEquals(tree.findLCA(5, 3),1);
	}
	@Test
	public void testAwkwardParameters() {
	
		LowestCommonAncestor tree = new LowestCommonAncestor();
		
		tree.root = new Node(1); 
        
		tree.root.left = new Node(2); 
        
		tree.root.right = new Node(3); 
        
		tree.root.left.left = new Node(4); 
        
		tree.root.left.right = new Node(5); 
        
		tree.root.right.left = new Node(6); 
        
		tree.root.right.right = new Node(7);
      
		//Now we try out what happens when we put one or two parameters, that are not within the bounds of one to seven.
      
		//This gives out n1 and n2 are missing, even when only n1 is missing and n2 is given. 
		//They should return -1, which they do. 
        
assertEquals(tree.findLCA(0, 1),-1);
	    
		assertEquals(tree.findLCA(0, 0),-1);
	    
		assertEquals(tree.findLCA(8, 0),-1);
	    
		assertEquals(tree.findLCA(8, 8),-1);
	}
		@Test
		public void testOnlyRoot() {
			LowestCommonAncestor tree= new LowestCommonAncestor();
			tree.root = new Node(1);
			//Here we test if everything still works as intended if we instantiate a tree only containing a root.
			//The first test case should give us 1 as the LCA, the others should return -1 as they are not
			//part of the tree.
			assertEquals(tree.findLCA(1, 1),1);
			assertEquals(tree.findLCA(1,2),-1);
			assertEquals(tree.findLCA(4,2),-1);
			assertEquals(tree.findLCA(2,10),-1);
			assertEquals(tree.findLCA(6,9),-1);
			assertEquals(tree.findLCA(0, 0),-1);
		}
		
		@Test
		public void testDag() {
			LowestCommonAncestor dag = new LowestCommonAncestor();
			dag.dagRoot = new DagNode(1,2);
			dag.dagRoot.nextNode = new DagNode(2,3);
			dag.dagRoot.nextNode.nextNode = new DagNode(3,4);
			dag.dagRoot.nextNode.nextNode.nextNode = new DagNode(4,5);
			
			assertEquals(dag.findLCADag(1, 2),1);
			
			
		}
	}
