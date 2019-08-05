
public class TreeToDoubLinkList
{
static class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.data + " "); 
       // Doubly=push(Doubly,node.data);
        
  
        /* now recur on right child */
        printInorder(node.right); 
    } 
    
    public Node push(Node head,int new_data) 
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
    return head;
} 

    Node Doubly=null;

    Node bTreeToClist(Node root)
    {
        printInorder(root) ;
        return Doubly;
        
    }
}
