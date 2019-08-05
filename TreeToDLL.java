

		
class TreeToDLL 
{ 
   static Node head=null;
    
   static class Node 
{ 
    int key; 
    Node left, right; 
  
    public Node(int item) 
    { 
        key = item; 
        left = right = null; 
    } 
} 
    

static void printPostorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostorder(node.left); 
  
        // then recur on right subtree 
        printPostorder(node.right); 
  
        // now deal with the node 
        System.out.print(node.key + " "); 
        push(node.key);
    } 
  
     //display() will print out the nodes of the list  
    static void display() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Prints each node by incrementing the pointer.  
  
            System.out.print(current.key + " ");  
            current = current.right;  
        }  
    }  
  
    // Adding a node at the front of the list 
    static void push(int new_data) 
    { 
        /* 1. allocate node  
        * 2. put in the data */
        Node new_Node = new Node(new_data); 
  
        /* 3. Make next of new node as head and previous as NULL */
        new_Node.right = head; 
        new_Node.left = null; 
  
        /* 4. change prev of head node to new node */
        if (head != null) 
            head.left = new_Node; 
  
        /* 5. move the head to point to the new node */
        head = new_Node; 
    } 
  
	public static void main(String args[]) 
	{ 
		// Build the tree / Driver Code 
 
	Node root = new Node(10); 
		root.left = new Node(12); 
		root.right = new Node(15); 
		root.left.left = new Node(25); 
		root.left.right = new Node(30); 
		root.right.left = new Node(36); 

		printPostorder(root);
		display();
		// head refers to the head of the Link List 
		
		
	} 
} 
/*
   Convert a Binary Tree to a Circular Doubly Link List
Given a Binary Tree, convert it to a Circular Doubly Linked List (In-Place).
The left and right pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
The order of nodes in List must be same as Inorder of the given Binary Tree.
The first node of Inorder traversal must be head node of the Circular List.
Example:

Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.
The idea can be described using below steps.
1) Write a general purpose function that concatenates two given circular doubly lists (This function is explained below).
2) Now traverse the given tree
….a) Recursively convert left subtree to a circular DLL. Let the converted list be leftList.
….a) Recursively convert right subtree to a circular DLL. Let the converted list be rightList.
….c) Make a circular linked list of root of the tree, make left and right of root to point to itself.
….d) Concatenate leftList with list of single root node.
….e) Concatenate the list produced in step above (d) with rightList.
Note that the above code traverses tree in Postorder fashion. We can traverse in inorder fashion also. We can first concatenate left subtree and root, then recur for right subtree and concatenate the result with left-root concatenation.
How to Concatenate two circular DLLs?
Get the last node of the left list. Retrieving the last node is an O(1) operation, since the prev pointer of the head points to the last node of the list.
Connect it with the first node of the right list
Get the last node of the second list
Connect it with the head of the list.
Below are implementations of above idea.

// Java Program to convert a Binary Tree to a 
// Circular Doubly Linked List 
  
// Node class represents a Node of a Tree 
class Node 
{ 
    int val; 
    Node left,right; 
  
    public Node(int val) 
    { 
        this.val = val; 
        left = right = null; 
    } 
} 
  
// A class to represent a tree 
class Tree 
{ 
    Node root; 
    public Tree() 
    { 
        root = null; 
    } 
  
    // concatenate both the lists and returns the head 
    // of the List 
    public Node concatenate(Node leftList,Node rightList) 
    { 
        // If either of the list is empty, then 
        // return the other list 
        if (leftList == null) 
            return rightList; 
        if (rightList == null) 
            return leftList; 
  
        // Store the last Node of left List 
        Node leftLast = leftList.left; 
  
        // Store the last Node of right List 
        Node rightLast = rightList.left; 
  
        // Connect the last node of Left List 
        // with the first Node of the right List 
        leftLast.right = rightList; 
        rightList.left = leftLast; 
  
        // left of first node refers to 
        // the last node in the list 
        leftList.left = rightLast; 
  
        // Right of last node refers to the first 
        // node of the List 
        rightLast.right = leftList; 
  
        // Return the Head of the List 
        return leftList; 
    } 
  
    // Method converts a tree to a circular 
    // Link List and then returns the head 
    // of the Link List 
    public Node bTreeToCList(Node root) 
    { 
        if (root == null) 
            return null; 
  
        // Recursively convert left and right subtrees 
        Node left = bTreeToCList(root.left); 
        Node right = bTreeToCList(root.right); 
  
        // Make a circular linked list of single node 
        // (or root). To do so, make the right and 
        // left pointers of this node point to itself 
        root.left = root.right = root; 
  
        // Step 1 (concatenate the left list with the list  
        //         with single node, i.e., current node) 
        // Step 2 (concatenate the returned list with the 
        //         right List) 
        return concatenate(concatenate(left, root), right); 
    } 
  
    // Display Circular Link List 
    public void display(Node head) 
    { 
        System.out.println("Circular Linked List is :"); 
        Node itr = head; 
        do
        { 
            System.out.print(itr.val+ " " ); 
            itr = itr.right; 
        } 
        while (itr != head); 
        System.out.println(); 
    } 
} 
  
// Driver Code 
class Main 
{ 
    public static void main(String args[]) 
    { 
        // Build the tree 
        Tree tree = new Tree(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(12); 
        tree.root.right = new Node(15); 
        tree.root.left.left = new Node(25); 
        tree.root.left.right = new Node(30); 
        tree.root.right.left = new Node(36); 
  
        // head refers to the head of the Link List 
        Node head = tree.bTreeToCList(tree.root); 
  
        // Display the Circular LinkedList 
        tree.display(head); 
    } 
} 

   */
