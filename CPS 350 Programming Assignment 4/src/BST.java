/*
 * CPS 350 Assignment 4
 * 
 * Patrick Conley
 * 
 * Binary Search Tree object class
 */
public class BST
{
	TreeNode root; //root of the tree
	public BST(TreeNode root)
	{
		this.root = root;
	}	//end BST constructor
	
	public TreeNode insert(TreeNode root, County county)
	{
	    if (root == null) //base case
	    {
	        return new TreeNode(county);
	    }	//end if statement

	    if (county.getFIPS() < root.county_info.getFIPS())
	    {
	        root.left = insert(root.left, county);	//recursive case
	    }	//end if statement 
	    else if (county.getFIPS() > root.county_info.getFIPS()) 
	    {
	        root.right = insert(root.right, county);	//recursive case
	    }	//end else if statement

	    return root;
	}	//end insert method
	
	public TreeNode delete(TreeNode root, int val) 
	{
	    if (root == null) //base case
	    {
	        return root;
	    }	//end if statement
	    
	    if (val < root.county_info.getFIPS()) 
	    {
	        root.left = delete(root.left, val);	//recursive case
	    } //end if statement
	    else if (val > root.county_info.getFIPS()) 
	    {
	        root.right = delete(root.right, val);	//recursive case
	    } //end else if statement
	    else 
	    {
	        //no left child
	        if (root.left == null) 
	        {
	            return root.right;
	        }	//end if statement
	        //no right child
	        else if (root.right == null) 
	        {
	            return root.left;
	        }	//end else if statement
	        
	        //node has two children
	        TreeNode minNode = findMin(root.right);
	        //replace data with smallest value
	        root.county_info = minNode.county_info;
	        //delete duplicate node
	        root.right = delete(root.right, minNode.county_info.getFIPS());
	    }
	    return root;	
	}

	//helper method to find minimum
	private TreeNode findMin(TreeNode root) 
	{
	    while (root.left != null) 
	    {
	        root = root.left;
	    }	//end while loop
	    return root;
	}
	
	void preorder(TreeNode root)
	{
		if (root != null)
		{
			root.display();
			preorder(root.left);
			preorder(root.right);
			
		}	//end if statement
	}	//end preorder method
	
	void inorder(TreeNode root)
	{
		if (root != null)
		{
			inorder(root.left);
			root.display();
			inorder(root.right);
		}	//end if statement
	}	//end inorder method
	
	void postorder(TreeNode root)
	{
		if (root != null)
		{
			postorder(root.left);
			postorder(root.right);
			root.display();
		}	//end if statement
	}	//end postorder method
}	//end BST class
