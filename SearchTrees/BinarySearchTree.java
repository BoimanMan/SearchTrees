package SearchTrees;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alec Hebert
 * @version 1.0
 * @since 2018-11-27
 * <p>
 * This class is used to create a binary search tree and has methods for 
 * inserting and deleting nodes, as well as traversals and returning the height
 * of the tree.
 */
public class BinarySearchTree <T extends Comparable<T>>
{
    
    private BSTNode<T> root;
    private int size;
    /**
     * <p>
     * This constructor creates a new binary search tree object with a null root
     * and a size of zero.
     */   
    public BinarySearchTree()
    {
        root = null;
        size = 0;
    }
    /**
     * <p>
     * This method returns the size variable of the binary search tree.
     * @return 
     */
    
    public int Size()
    {
        return size;
    }
    
        
    /* ***************************************************************
    *  Insert a new node
    *  Returns true on successful insert otherwise false (when already present)
    *****************************************************************/
    /**
     * <p>
     * Inserts a new element into the tree. Returns true upon successful insertion,
     * false if it fails. Size variable increments if true.
     * @param data
     * @return 
     */
    public boolean insert(T data) 
    {
        if (root==null){
            root=new BSTNode<T>(data);
            this.size++;
            return true;
        }
        BSTNode<T> parent = null;
        BSTNode<T> child = root;
        while (child!=null){
            if (data.compareTo(child.data)<0){
                parent = child;
                child = child.left;
            }
            else if (data.compareTo(child.data)>0){
                parent=child;
                child=child.right;
            }
            else
                return false;}
            if (data.compareTo(parent.data)<0){
                parent.left=new BSTNode<T>(data);
                this.size++;
            }
            else{
                parent.right=new BSTNode<T>(data);
                this.size++;
            }
            return true;
        }
    
    /*****************************************************************
    *  Delete a node
    *  Returns true on successful deletion and false otherwise
    *****************************************************************/
    /**
     * <p>
     * Searches for an element and deletes it from the tree. Returns true if an 
     * element was deleted, false if not. Size decrements if true.
     * @param data
     * @return 
     */
    public boolean delete(T data) 
    {
        boolean found = false;
        BSTNode<T> parent = null;
        BSTNode<T> child = root;
        while (child != null) {
            if (data.compareTo(child.data) < 0) {
                parent = child;
                child = child.left;
            } else if (data.compareTo(child.data) > 0) {
                parent = child;
                child = child.right;
            } else {
                found = true;
                break;
            }
        }
        if (found) {
            if (child.left==null){
                if (parent == null)
                    root=child.right;
                else{
                    if (data.compareTo(parent.data)<0)
                        parent.left=child.right;
                    else
                        parent.right=child.right;
                }
            }
            else{
                BSTNode<T> parentOfRightMost=child;
                BSTNode<T> rightmost=child.left;
                while (rightmost.right !=null){
                    parentOfRightMost=rightmost;
                    rightmost=rightmost.right;
                }
                child.data=rightmost.data;
                if (parentOfRightMost.right==rightmost)
                    parentOfRightMost.right=rightmost.left;
                else
                    parentOfRightMost.left=rightmost.left;
            }
            this.size--;
        }
        return found;
    }
    
    /****************************************************************
    * 
    * Reset Tree
    * 
    ***************************************************************/
    /**
     * <p>
     * Clears the tree. Root set back to null and size set back to zero.
     */
    public void reset()
    {
        root = null;
        size=0;
    }
    
    /*****************************************************************
     * 
     * Height of tree 
     * 
    ****************************************************************/
    /**
     * <p>
     * Returns the height of the tree using helper method heightTree.
     * @return 
     */
    public int height(){
        return heightTree(root);}
    /**
     * <p>
     * Returns the height of the tree and gives it to the height method. Uses
     * recursion to continue adding to the two depth variables and returns the
     * largest depth.
     * @param node
     * @return 
     */
    public int heightTree(BSTNode<T> node){
        if(node==null){
            return 0;
        }
        else{
            int leftDepth=heightTree(node.left);
            int rightDepth=heightTree(node.right);
            if (leftDepth>rightDepth)
                return leftDepth+1;
            else
                return rightDepth+1;
        }
    }
    
    /*****************************************************************
    * 
    *      Traversal 
    * 
    ******************************************************************/
    /**
     * <p>
     * Prints elements from the tree by traversing in inorder traversal order.
     * Uses recursion and helper method to print in the order it prints in.
     */
    public void inorder() 
    {
        System.out.print("inorder BST:   ");
        inorder(root);
        System.out.println();
    }
    /**
     * <p>
     * Helper method to public inorder method. Uses recursion and formatting to
     * print in order.
     * @param current 
     */
    private void inorder(BSTNode<T> current){
        if (current!=null){
            inorder(current.left);
            System.out.printf("%5s",current.toString());
            inorder(current.right);
        }
    }
    /**
     * <p>
     * Prints elements from the tree by traversing in preorder traversal order.
     * Uses recursion and helper method to print in the order it prints in.
     */
    public void preorder() 
    {
        System.out.print("preorder BST:  ");
        preorder(root);
        System.out.println();
    }
    /**
     * <p>
     * Helper method to public preorder method. Uses recursion and formatting to
     * print in preorder order.
     * @param current 
     */
    private void preorder(BSTNode current){
        if (current!=null){
            System.out.printf("%5s",current.toString());
            preorder(current.left);
            preorder(current.right);
        }
    }
    /**
     * <p>
     * Prints elements from the tree by traversing in postorder traversal order.
     * Uses recursion and helper method to print in the order it prints in.
     */
    public void postorder() 
    {
        System.out.print("postorder BST: ");
        postorder(root);
        System.out.println();
    }
    /**
     * <p>
     * Helper method to public postorder method. Uses recursion and formatting to
     * print in postorder order.
     * @param current 
     */
    private void postorder(BSTNode current){
        if (current!=null){
            postorder(current.left);
            postorder(current.right);
            System.out.printf("%5s",current.toString());
        }
    }
}
