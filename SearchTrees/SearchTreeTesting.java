/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchTrees;
import java.util.*;
/**
 *
 * @author arunk
 * @version 1.0
 * @since 2018-11-27
 * <p>
 * This class holds the main function that tests code from the binary search tree
 * and red-black tree.
 */
public class SearchTreeTesting {
    //Alec Hebert
    //C00274244
    //CMPS 261
    //Program Description: This program should print the size, height, and 
    //execution time for inserting elements into a binary search tree and a 
    //red black tree. It should also print the elements by inorder traversal.
    //The program should do this for random input case and sorted input case.
    //Certificate of Authenticity:
    // I certify that the code in method functions not provided by the instructor
    // including method function main of this project are entirely my own work.
    /**
     * This method uses iterators to insert and delete nodes from binary search
     * trees and red-black trees. It also displays height, size, execution time, 
     * and inorder traversal in random input case and sorted input case.
     * @param args 
     */
     public static void main(String[] args) 
     {
    //*****NOTE*****
    //Left author tag for the class alone since I did not edit the main function.
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        RedBlackTree<Integer> rbt = new RedBlackTree();
        
        // Generate 1000 random numbers between 1 and 10000
        HashSet<Integer> randomNumberSet = new HashSet<>();
        Random rand = new Random();
        int randInt;
        for (int i=1; i<=1000; i++)
        {
            do{
                randInt = rand.nextInt(10000);
            }while (randomNumberSet.contains(randInt));
            randomNumberSet.add(randInt);
        }
        System.out.println("***********Random Input Case****************");
        System.out.println();
        // Insert the numbers generated into the binary search tree
        // Calculate the total time for insertion and print it
        Iterator iter = randomNumberSet.iterator();
        long startTime = System.currentTimeMillis();
        while (iter.hasNext())
        {
            bst.insert((Integer)iter.next());
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Size of the BST = "+bst.Size());
        System.out.println("Height of the BST = "+bst.height());
        System.out.println("Time to insert in BST = "+ executionTime);
        bst.inorder();
        System.out.println();
        System.out.println();
        
        // Insert the numbers generated into the redblack tree
        // Calculate the total time for insertion and print it
        iter = randomNumberSet.iterator();
        startTime = System.currentTimeMillis();
        while (iter.hasNext())
        {
            rbt.insert((Integer)iter.next());
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Size of the RBT = "+rbt.Size());
        System.out.println("Height of the RBT = "+rbt.height());
        System.out.println("Time to insert in RBT = "+ executionTime);
        rbt.inorder();
        System.out.println();
        System.out.println();
        
        
        // Delete all the nodes in the binary search tree
        // Calculate the total time for deletion and print it
        iter = randomNumberSet.iterator();
        startTime = System.currentTimeMillis();
        while (iter.hasNext())
        {
            bst.delete((Integer)iter.next());
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Size of the BST = "+bst.Size());
        System.out.println("Height of the BST = "+bst.height());
        System.out.println("Time to delete in BST = "+ executionTime);
        bst.inorder();
        System.out.println();
        System.out.println();
        
        
        // Delete all the nodes in the red black tree
        // Calculate the total time for deletion and print it
        iter = randomNumberSet.iterator();
        startTime = System.currentTimeMillis();
        while (iter.hasNext())
        {
            rbt.delete((Integer)iter.next());
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Size of the RBT = "+rbt.Size());
        System.out.println("Height of the RBT = "+rbt.height());
        System.out.println("Time to delete in RBT = "+ executionTime);
        rbt.inorder();
        System.out.println();
        System.out.println();
        
        
        System.out.println("***********Sorted Input Case****************");
        System.out.println();
        bst.reset();
        rbt.reset();
        
        // Insert 1000 sorted numbers(1 to 1000) into the binary search tree
        // Calculate the total time for insertion and print it
        startTime = System.currentTimeMillis();
        for(int i=1; i<= 1000; i++)
        {
            bst.insert(i);
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Size of the BST = "+bst.Size());
        System.out.println("Height of the BST = "+bst.height());      
        System.out.println("Time to insert in BST = "+ executionTime);
        bst.inorder();
        System.out.println();
        System.out.println();
        
        // Insert 1000 sorted numbers(1 to 1000) into the red black tree
        // Calculate the total time for insertion and print it
        startTime = System.currentTimeMillis();
        for(int i=1; i<= 1000; i++)
        {
            rbt.insert(i);
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Size of the RBT = "+rbt.Size());
        System.out.println("Height of the RBT = "+rbt.height());      
        System.out.println("Time to insert in RBT = "+ executionTime);
        rbt.inorder();
        System.out.println();
        System.out.println();
        
        // Delete all the nodes in the binary search tree
        // Calculate the total time for deletion and print it
        startTime = System.currentTimeMillis();
        for(int i=1; i<= 1000; i++)
        {
            bst.delete(i);
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Size of the BST = "+bst.Size());
        System.out.println("Height of the BST = "+bst.height());
        System.out.println("Time to delete in BST = "+ executionTime);
        bst.inorder();
        System.out.println();
        System.out.println();
        
        
        // Delete all the nodes in the red black tree
        // Calculate the total time for deletion and print it
        startTime = System.currentTimeMillis();
        for(int i=1; i <= 1000; i++)
        {
            rbt.delete(i);
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Size of the RBT = "+rbt.Size());
        System.out.println("Height of the RBT = "+rbt.height());
        System.out.println("Time to delete in RBT = "+ executionTime);
        rbt.inorder();
        System.out.println();
        System.out.println();
                
     }
}
