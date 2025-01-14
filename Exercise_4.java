// Time Complexity : insert --> O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not really 


// Your code here along with comments explaining your approach


import java.util.LinkedList; 
import java.util.Queue;

public class Exercise_4 { 
       
    /* A binary tree node has key, pointer to  
    left child and a pointer to right child */
    static class Node { 
        int key; 
        Node left, right; 
          
        // constructor 
        Node(int key){ 
            this.key = key; 
            left = null; 
            right = null; 
        } 
    } 
    static Node root; 
    static Node temp = root; 
      
    /* Inorder traversal of a binary tree*/
    static void inorder(Node temp) 
    { 
        if (temp == null) 
            return; 
       
        inorder(temp.left); 
        System.out.print(temp.key+" "); 
        inorder(temp.right); 
    } 
       
    /*function to insert element in binary tree */
    static void insert(Node temp, int key) 
    { 

        // Do level order traversal until we find 
        // an empty place and add the node.
        if(temp==null){
            root= new Node(key);
            return;
        }  
        Queue<Node> queueNode= new LinkedList<Node>();
        queueNode.add(temp);

        while(!queueNode.isEmpty()){
            temp=queueNode.peek();
            queueNode.remove();

            if(temp.left==null){
                temp.left= new Node(key);
                break;

            }
            else 
                queueNode.add(temp.left);


            if(temp.right==null){
                temp.right= new Node(key);
                break;
            }
            else    
                queueNode.add(temp.right);

        }
        
    } 
       
    // Driver code 
    public static void main(String args[]) 
    { 
        root = new Node(10); 
        root.left = new Node(11); 
        root.left.left = new Node(7); 
        root.right = new Node(9); 
        root.right.left = new Node(15); 
        root.right.right = new Node(8); 
       
        System.out.print( "Inorder traversal before insertion:"); 
        inorder(root); 
       
        int key = 12; 
        insert(root, key); 
       
        System.out.print("\nInorder traversal after insertion:"); 
        inorder(root); 
    } 
}