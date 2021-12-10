package SearchTrees;

import SearchTrees.RBNode.RBColor;

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
 * This class is used to create a red-black tree and has methods for 
 * inserting and deleting nodes, as well as traversals and returning the height
 * and black height of the tree. It also contains rotation and fixup methods
 * to preserve red black tree properties.
 */
public class RedBlackTree <T extends Comparable<T>>
{
    private RBNode<T> root;
    //private RBNode<T> nil = new RBNode<T>();
    private int size;
    
    /**
     * <p>
     * This constructor creates a new red-black tree object with a black null root
     * and a size of zero.
     */      
    public RedBlackTree()
    {
        root = new RBNode<>(); //empty root
        size = 0;
    }
    /**
     * <p>
     * This method returns the size variable of the red-black tree.
     * @return 
     */
    public int Size()
    {
        return size;
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
    public int height()
    {return heightTree(root);}
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
     * Black Height of a node
     * 
    ****************************************************************/
    /**
     * <p>
     * This method returns the black height of the tree. It goes down the left 
     * branch of the tree and increments the int variable if the node is black.
     * @return 
     */
    public int blackHeight()
    {
        RBNode current = root;
        int blackheight=0;
        while (current!=null){
            if(current.color.compareTo(RBNode.RBColor.BLACK)==0)
                blackheight++;
            current=current.left;}
        return blackheight;
    }
    
    
    /*****************************************************************
     * 
     * Finding node with minimum value
     * 
    ****************************************************************/
    /**
     * This method finds the minimum value in the tree.
     * @return 
     */
    public RBNode<T> treeMin() {
        return treeMin(root);
    }
    
    public RBNode<T> treeMin(RBNode<T> x)
    {
        while (!x.left.isEmpty())
        {
            x = x.left;
        }
        return x;
    }
    
    /* ***************************************************************
    * Insert a new node
    * Returns true on successful insert otherwise false (when already present)
    *****************************************************************/
    /**
     * <p>
     * Inserts a new element into the tree. Returns true upon successful insertion,
     * false if it fails. Size variable increments if true. insertFixup should be
     * called if the grandparent of the inserted element is not null, since inserted
     * nodes are red by default.
     * @param data
     * @return 
     */
    public boolean insert(T data){   
        if (root.data==null){
            root.data=data;
            size++;
            return true;
        }
        RBNode<T> parent=null;
        RBNode<T> child = root;
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
                parent.left=new RBNode<T>(data,null,null,RBColor.RED);
                if (parent.parent!=null)
                    insertFixup(parent.left);
                this.size++;
            }
            else{
                parent.right=new RBNode<T>(data,null,null,RBColor.RED);
                if (parent.parent!=null)   
                    insertFixup(parent.right);
                this.size++;
            }
            return true;
        
    }
    
    // Fix up the tree that just had node inserted
    /**
     * <p>
     * This method fixes an inserted element in terms of red-black tree properties.
     * It calls rotation methods according to the possible cases.
     * @param z 
     */
    private void insertFixup(RBNode<T> z){
        while (z.parent.color==RBColor.RED){
            RBNode uncle=null;
            if (z.parent==z.parent.parent.left){
                uncle=z.parent.parent.right;
                if (uncle!=null&&uncle.color==RBColor.RED){
                    z.parent.color=RBColor.BLACK;
                    uncle.color=RBColor.BLACK;
                    z.parent.parent.color=RBColor.RED;
                    z=z.parent.parent;
                    continue;
                }
                if (z==z.parent.right){
                    z=z.parent;
                    leftRotate(z);
                }
                z.parent.color=RBColor.BLACK;
                z.parent.parent.color=RBColor.RED;
                rightRotate(z.parent.parent);
            }
            else{
                uncle=z.parent.parent.left;
                if (uncle!=null&&uncle.color==RBColor.RED){
                    z.parent.color=RBColor.BLACK;
                    uncle.color=RBColor.BLACK;
                    z.parent.parent.color=RBColor.RED;
                    z=z.parent.parent;
                    continue;
                }
                if (z==z.parent.left){
                    z=z.parent;
                    rightRotate(z);
                }
                z.parent.color=RBColor.BLACK;
                z.parent.parent.color=RBColor.RED;
                leftRotate(z.parent.parent);
            }
        }
        root.color=RBColor.BLACK;
    }
    /**
     * This method rotates a node to the left.
     * @param node 
     */
    private void leftRotate(RBNode<T> node)
    {
        if (node.parent!=null){
            if (node==node.parent.left)
                node.parent.left=node.right;
            else
                node.parent.right=node.right;
            node.right.parent=node.parent;
            node.parent=node.right;
            if (node.right.left != null)
                node.right.left.parent=node;
            node.right=node.right.left;
            node.parent.left=node;}
            else{
                RBNode rightOfRoot=root.right;
                root.right=rightOfRoot.left;
                rightOfRoot.left.parent=root;
                root.parent=rightOfRoot;
                root.parent=rightOfRoot;
                rightOfRoot.left=root;
                rightOfRoot.parent=null;
                root=rightOfRoot;
                
        }
    }
    /**
     * <p>
     * This method rotates a node to the right. 
     * @param node 
     */
    private void rightRotate(RBNode<T> node)
    {
        if (node.parent!=null){
            if (node==node.parent.left)
                node.parent.left=node.left;
            else
                node.parent.right=node.left;
            node.left.parent=node.parent;
            node.parent=node.left;
            if (node.left.right!=null)
                node.left.right.parent=node;
            node.left=node.left.right;
            node.parent.right=node;}
        else{
            RBNode leftOfRoot=root.left;
            root.left=root.left.right;
            leftOfRoot.right.parent=root;
            root.parent=leftOfRoot;
            leftOfRoot.right=root;
            leftOfRoot.parent=null;
            root=leftOfRoot;
        }
    }
    
    
    /*****************************************************************
    *  Delete a node
    *  Returns true on successful deletion and false otherwise
    *****************************************************************/
    //*****NOTE*****
    //Commented out due to issues in the main code. Tried the best I could. 
    //Constructive feedback on code would be appreciated.
    /**
     * <p>
     * Searches for an element and deletes it from the tree. Returns true if an 
     * element was deleted, false if not. Size decrements if true. Should call
     * deleteFixup and assignParent when necessary. 
     * @param data
     * @return 
     */
    public boolean delete(T data)
    {
        boolean found = false;
        /*RBNode<T> parent = null;
        RBNode<T> child = root;
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
                assignParent(child,child.right);
            }
            else{
                RBNode<T> parentOfRightMost=child;
                RBNode<T> rightmost=child.left;
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
        */return found;
    }
    
    // Assigns node v to the parent of u
    // useful while deletion
    /**
     * Assigns passed node v as passed node u's parent.
     * @param u
     * @param v 
     */
    private void assignParent(RBNode<T> u, RBNode<T> v)
    {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }
    /**
     * <p>
     * This method fixes a deleted element in terms of red-black tree properties.
     * It calls rotation methods according to the possible cases.
     * @param z 
     */
    private void deleteFixup(RBNode<T> x)
    {
        while(x!=root&&x.color==RBColor.BLACK){
            if(x==x.parent.left){
                RBNode y=x.parent.right;
                if(y.color==RBColor.RED){
                    y.color=RBColor.BLACK;
                    x.parent.color=RBColor.RED;
                    leftRotate(x.parent);
                    y=x.parent.right;
                }
                if(y.left.color==RBColor.BLACK&&y.right.color==RBColor.BLACK){
                    y.color=RBColor.RED;
                    x=x.parent;
                    continue;
                }
                else if(y.right.color==RBColor.BLACK){
                    y.left.color=RBColor.BLACK;
                    y.color=RBColor.RED;
                    rightRotate(y);
                    y=x.parent.right;
                }
                if(y.right.color==RBColor.RED){
                    y.color=x.parent.color;
                    x.parent.color=RBColor.BLACK;
                    y.right.color=RBColor.BLACK;
                    leftRotate(x.parent);
                    x=root;
                }
            }
            else{
                RBNode y=x.parent.left;
                if(y.color==RBColor.RED){
                    y.color=RBColor.BLACK;
                    x.parent.color=RBColor.RED;
                    rightRotate(x.parent);
                    y=x.parent.left;
                }
                if(y.right.color==RBColor.BLACK&&y.left.color==RBColor.BLACK){
                    y.color=RBColor.RED;
                    x=x.parent;
                    continue;
                }
                else if(y.left.color==RBColor.BLACK){
                    y.right.color=RBColor.BLACK;
                    y.color=RBColor.RED;
                    leftRotate(y);
                    y=x.parent.left;
                }
                if(y.left.color==RBColor.RED){
                    y.color=x.parent.color;
                    x.parent.color=RBColor.BLACK;
                    y.left.color=RBColor.BLACK;
                    rightRotate(x.parent);
                    x=root;
                }
            }
        }
        x.color=RBColor.BLACK;
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
        root = new RBNode<>();
        size=0;
    }
    
    /*****************************************************************
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
        System.out.print("inorder RBT:   ");
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
        System.out.print("preorder RBT:  ");
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
        System.out.print("postorder RBT: ");
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
