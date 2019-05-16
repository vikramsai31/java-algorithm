/**
 * Filename: Node.java Author: vikram Pendyam Date: 04/18/2019 Description:
 * class which defines node
 * 
*/
package project3cmsc350;

public class Node {

    int data;// parent node
    Node left, right;

    public Node(int data) {
        this.data = data; //setting the current value
        left = null;//setting child nodes to null
        right = null;

    }

}
