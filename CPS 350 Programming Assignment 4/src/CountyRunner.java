import java.util.ArrayList;
/*
 * CPS 350 Assignment 4
 * 
 * Patrick Conley
 * 
 * Runner class
 */
public class CountyRunner 
{
    public static void main(String[] args) 
    {
        ArrayList<County> counties = new ArrayList<>();	//ArrayList of counties
        counties.add(new County("Franklin", "049", "Columbus", 1264518, 539.87));
        counties.add(new County("Hamilton", "061", "Cincinnati", 802374, 407.36));
        counties.add(new County("Butler", "017", "Hamilton", 368130, 467.27));
        counties.add(new County("Montgomery", "113", "Dayton", 535153, 461.68));
        counties.add(new County("Clinton", "027", "Wilmington", 42040, 410.88));

        BST bst = new BST(null);	//creating new BST

        for (County county : counties) 
        {
            bst.root = bst.insert(bst.root, county);	//inserting counties into empty BST
        } // end for loop

        System.out.println("Preorder traversal: ");
        bst.preorder(bst.root);
        System.out.println("\nInorder traversal: ");
        bst.inorder(bst.root);

        //adding new county
        County newCounty = new County("Cuyahoga", "035", "Cleveland", 1249352, 458.49);
        bst.root = bst.insert(bst.root, newCounty);

        System.out.println("\nAfter adding Cuyahoga:");
        System.out.println("Preorder traversal:");
        bst.preorder(bst.root);
        System.out.println("\nInorder traversal:");
        bst.inorder(bst.root);

        //deleting Franklin
        bst.root = bst.delete(bst.root, 49); // Assuming we want to delete Franklin (FIPS 49)

        System.out.println("\nAfter deleting Franklin:");
        System.out.println("Preorder traversal:");
        bst.preorder(bst.root);
        System.out.println("\nInorder traversal:");
        bst.inorder(bst.root);
        
        /*
         * The Franklin (049) node is deleted successfully because it is replaced with 
         *    its in-order successor, which will still maintain the properties of a binary search
         *     tree. The in-order successor was found by finding the smallest value in the right subtree
         *     of the root of the tree. It replaced the data in the root and maintained the BST properties
         */
        
    } // end main method
} // end CountyRunner class
