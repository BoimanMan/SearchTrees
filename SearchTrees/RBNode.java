package SearchTrees;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * <p> Node Class for Red-Black Tree<p>
 * @author arunk
 * @param <T>
 * 
 */
public class RBNode<T> extends BSTNode<T> 
{
    public enum RBColor{
        BLACK, RED;
    }
    
    public RBNode<T> left; //left child
    public RBNode<T> right; //right child
    public RBColor color; //Color of node
    public RBNode<T> parent; // reference to parent node
    /**
     * <p>
     * Creates a new RBNode object with data, l, r, and col elements.
     * @param data
     * @param l
     * @param r
     * @param col 
     */    
    public RBNode(T data, RBNode<T> l, RBNode<T> r, RBColor col)
    {
       super(data, l, r);
       this.color = col;
       parent = null;
    }
    /**
     * <p>
     * Creates a new RBNode object with data, l, r, and black color elements.
     * @param data
     * @param l
     * @param r 
     */
    public RBNode(T data, RBNode<T> l, RBNode<T> r)
    {
       super(data, l, r);
       this.color = RBColor.BLACK; // black node by default
       parent = null;
    }
    /**
     * Creates a new RBNode object with data, null l and r elements, and black color.
     * @param data 
     */
    public RBNode(T data)
    {
       this(data, null, null, RBColor.BLACK);
       parent = null;
    }
    /**
     * Creates a new RBNode with null data, l, and r elements, and black color.
     */
    public RBNode()
    {
        this(null, null, null, RBColor.BLACK);
        parent = null;
    }
    
    /**
     * Tests if the data is present or not
     * @return true if present false otherwise
     */
    public boolean isEmpty()
    {
        if(data == null) return true;
        else return false;
    }
    
}

