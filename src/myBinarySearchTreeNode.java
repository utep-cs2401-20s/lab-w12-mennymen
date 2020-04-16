class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    // created a new node with empty child pointers
    myValue = inValue;
    left = null;
    right = null;
  }
  
  myBinarySearchTreeNode(int[] A){
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.

    //The first element of the array will become the root of this new tree
    myValue = A[0];

    //Go through the array and insert the elements into the array in the order they appear in the array
    for(int i = 1; i < A.length; i++)
      insert(A[i]);
  }

  public void insert(int inValue){
    // This method takes a new integer as input and decides 
    // if it should be place: 
    //    * as the left child,
    //    * as the right child, 
    //    * in the left subtree,
    //    * or in the right subtree.
    // If the value already exists in the tree, no action is taken. 

    //If inValue is less than the value we're currently at, we're going to go to its left, if it exists
    //If there is no left, we insert inValue as the left of the current value
    if(inValue < myValue) {
      if (left == null)
        left = new myBinarySearchTreeNode(inValue);

      else
        left.insert(inValue);
    }

    //If inValue is more than the value we're currently at, we're going to go to its right, if it exists
    //If there is no right, we insert inValue as the right of the current value
    if(inValue > myValue){
      if (right == null)
        right = new myBinarySearchTreeNode(inValue);

      else
        right.insert(inValue);
    }

    //If inValue has the same value as the current number we're currently at, we print an error saying this number is already in the tree
    if(inValue == this.myValue) {
      System.out.println(inValue + " is already in the tree");
    }

  }


  public int height(){
     // This method recursively calculates the height of the entire (sub)tree.
     // This method will take O(n) time

    //Create an int for each half the method will be traversing
    int leftH = 0;
    int rightH = 0;

    //Recursive cases

    //If the current node has a left, we're calling the method again, checking its left and adding 1 to our height count
    if(left != null)
      leftH += 1 + left.height();

    //If the current node has a right, we're calling the method again, checking its right and adding 1 to our height count
    if(right != null)
      rightH += 1 + right.height();

    //Base case
    //If the node's left and right are both null, return the highest value between the left height and the right height
    return Math.max(leftH, rightH);
  }
  
  public int depth(int search){
     // This method recursively calculates the depth of a given search value. 
     // If the given value is not in the tree, this method returns -1. 
     // Note that if the tree is a proper BST, this method should complete in O(log n) time.
     // Additionally, remember that the depth is the number of nodes on the path from a node to the root 
     // (i.e. the number of the recursive calls).

    //Recursive cases
    //If the integer we're looking for is larger than the current node's value and
    //this node has a right that is not null, it's going to return 1 + another call
    // to the method, looking at this node's right
    if(search > myValue && right != null)
      return 1 + right.depth(search);

    //If the integer we're looking for is smaller than the current node's value and
    //this node has a left that is not null, it's going to return 1 + another call
    // to the method, looking at this node's left
    if(search < myValue && left != null)
      return 1 + left.depth(search);

    //Base cases
    //If the current node's value and the integer we're looking for are the same, it means we found it and return 0
    if(myValue == search)
      return 0;

    //If the number was never found, return -1
    return -1;
  }

  public int size(){
    // This method recursively calculates the number of nodes in the (sub)tree.

    //Start with a 1 as we count the current node
    int size = 1;

    //Recursive cases
    //If this node's left is not null, we call the method looking at this node's left and add it to size
    if(left != null)
      size+=  left.size();

    //If this node's right is not null, we call the method looking at this node's right and add it to size
    if(right != null)
      size+= right.size();

    //Base case
    return size;
  }


  
  // Utility function included so you can debug your solution. 
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
  
} 
