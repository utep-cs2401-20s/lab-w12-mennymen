import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class myBinarySearchTreeTester {



    /*
     * This test was done to test the insert method with a number that is smaller than the head
     * to  see if it would insert the number as a new node correctly.
     * Input: A tree with its head being 4, its right 6, and its left null
     * Expected output: root's left = 4
     * Output: root's left = 4
     * Test passed, meaning that the method does insert values as intended to the left.
     */
    @Test
    public void insertTester1(){
        myBinarySearchTreeNode newTree1 = new myBinarySearchTreeNode(new int[] {4,6});
        newTree1.insert(2);
        assertEquals(2, newTree1.left.myValue);
    }


    /*
     * This test was done to test the insert method with a number that is larger than the head
     * to  see if it would insert the number as a new node correctly.
     * Input: A tree with its head being 3, its left 1, and its right null
     * Expected output: root's right = 5
     * Output: root's right = 5
     * Test passed, meaning that the method does insert values as intended to the right.
     */
    @Test
    public void insertTester2(){
        myBinarySearchTreeNode newTree1 = new myBinarySearchTreeNode(new int[] {3,1});
        newTree1.insert(5);
        assertEquals(5, newTree1.right.myValue);
    }


    /*
     * This test was done to test that the height method calculates a tree's height appropriately.
     * Input: A tree with the values {0,1,2,3,4,5,6,7,8,9}
     * Expected output: 9 since each number is larger than the previous one, there are no left children and there are 10 nodes.
     * Output: 9
     * Test passed, meaning that the method does calculate a tree's height as intended.
     */
    @Test
    public void heightTester1(){
        myBinarySearchTreeNode newTree2 = new myBinarySearchTreeNode(new int[] {0,1,2,3,4,5,6,7,8,9});
        assertEquals(9,newTree2.height());
    }


    /*
     * This test was done to test that the depth method calculates the depth of a node appropriately.
     * Input: A tree with the values {8,9,1,35,47,1,0,5}
     * Expected output: 2 as the root's right child is 9 and 9's right is 35, so its depth is 2
     * Output: 2
     * Test passed, meaning that the method does calculate a node's depth as intended.
     * Also, I intentionally had two 1's in the array to verify that it would actually print the error statement and not insert 1 twice.
     */
    @Test
    public void depthTester1(){
        myBinarySearchTreeNode newTree3 = new myBinarySearchTreeNode(new int[] {8,9,1,35,47,1,0,5});
        assertEquals(2, newTree3.depth(35));
    }


    /*
     * This test was done to test that the depth method returns -1 if it does not find a node with the input value.
     * Input: A tree with the values {1,3,5,7,9,2,4,6,8}
     * Expected output: -1 as there is no node that contains 0 in the tree
     * Output: -1
     * Test passed, meaning that the method does return -1 when the value it is searching for is not in the tree.
     */
    @Test
    public void depthTester2(){
        myBinarySearchTreeNode newTree4 = new myBinarySearchTreeNode(new int[] {1,3,5,7,9,2,4,6,8});
        assertEquals(-1, newTree4.depth(0));
    }

    /*
     * This test was done to test that the size method appropriately counts all nodes from the tree.
     * Input: A tree with the values {10,9,8,7,6,5,4,3,2,1,2,3}
     * Expected output: 10 as there are 10 nodes in the tree
     * Output: 10
     * Test passed, meaning that the method does count the number of nodes in the tree as intended.
     * Also, I intentionally put an extra 2 and 3 in the array to verify that these values were not inserted in the array and not counted twice.
     */
    @Test
    public void sizeTester1(){
        myBinarySearchTreeNode newTree5 = new myBinarySearchTreeNode(new int[] {10,9,8,7,6,5,4,3,2,1,2,3});
        assertEquals(10, newTree5.size());
    }

}
