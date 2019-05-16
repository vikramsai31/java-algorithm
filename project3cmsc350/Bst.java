/**
 * Filename: Bst.java Author: vikram Pendyam Date: 04/18/2019 Description:
 * Binary search tree to insert node,preorder & postorder traversal
 * 
*/
package project3cmsc350;

import java.util.*;

public class Bst {

    //calling node object
    public static Node root;

    public Bst() {
        //setting initial value of root to null
        this.root = null;

    }

    //binary tree is built calling below method
    public void insert(int id) {
        root = insertNode(root, id);
    }

    public Node insertNode(Node root, int id) {
        /*checking to see if root node is null then assign the first value */
        if (root == null) {
            root = new Node(id);
            return root;
        }
        /*comparing root to the id , if its less than the root node then goes left otherwise right child*/
        if (id <= root.data) {
            root.left = insertNode(root.left, id);
        } else if (id >= root.data) {
            root.right = insertNode(root.right, id);
        }

        return root;

    }

    /*
     this is mainly arranging the in ascending order  
     @arg : size is the arraylist size
     */
    public int[] preOrder(int size) {
        int[] array = new int[size];
        int index = 0;//counter to build array
        preOrdertraverse(root, index, array);
        return array;//sorted array

    }

    //using recursion to call the method itself and adding it to the  array  
    public int preOrdertraverse(Node root, int index, int[] array) {
        if (root != null) {
            index = preOrdertraverse(root.left, index, array);  //reading tree from left
            array[index++] = root.data;
            index = preOrdertraverse(root.right, index, array);//reading tree from right
        }
        return index;
    }

    //this is mainly arranging the in descending order
    public int[] postOrder(int size) {
        int[] array = new int[size];
        int index = 0;
        postOrdertraverse(root, index, array);
        return array;//counter to build array
    }

    //using recursion to call the method itself and adding it to the  array 
    public int postOrdertraverse(Node root, int index, int[] array) {
        if (root != null) {
            index = postOrdertraverse(root.right, index, array);  //reading tree from right
            array[index++] = root.data;//adding int to array
            index = postOrdertraverse(root.left, index, array);//reading tree from left
        }
        return index; //counter to build array
    }

}
