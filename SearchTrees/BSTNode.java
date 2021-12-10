package SearchTrees;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * <p> Node Class for Binary Search Tree<p>
 * @author arunk
 * @version 1.0
 * @param <T>
 * @since 2017
 */


public class BSTNode<T>
{
    public T data;
    public BSTNode<T> left, right;
    /**
     * <p>
     * Creates a new BSTNode object with data, left, and right elements.
     * @param data
     * @param l
     * @param r 
     */
    public BSTNode(T data, BSTNode<T> l, BSTNode<T> r)
    {
       left = l; right = r;
       this.data = data;
    }
    /**
     * <p>
     * Creates a new BSTNode object with data and null left and right elements.
     * @param data 
     */
    public BSTNode(T data)
    {
       this(data, null, null);
    }
    /**
     * Overrides toString. Returns data as a string.
     * @return 
     */ 
    @Override
    public String toString()
    {
       return data.toString();
    }
}
