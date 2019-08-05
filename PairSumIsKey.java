// Java program to find a 
// pair with given sum x. 
class PairSumIsKey
{ 

// structure of node of 
// doubly linked list 
static class Node 
{ 
	int data; 
	Node next, prev; 
}; 

// Function to find pair whose 
// sum equal to given value x. 
static void pairSum( Node head, int x) 
{ 
	// Set two pointers, first 
	// to the beginning of DLL 
	// and second to the end of DLL. 
	Node first = head; 
	Node second = head; 
	while (second.next != null) 
		second = second.next; 

	// To track if we find a pair or not 
	boolean found = false; 

	// The loop terminates when either 
	// of two pointers become null, or 
	// they cross each other (second.next 
	// == first), or they become same 
	// (first == second) 
	
	while(first!=second && first.next!=second && first!=null && second!=null){
	  
	    if(first.data+second.data>x){
	   second=second.prev;
	   }
	   	  else if((first.data + second.data)==x){
	   	      System.out.println(first.data+"+"+second.data+"="+x);
	   	      first=first.next;
	   	      second=second.prev;
	   	   }
	   	   else{
	   	   	   	   first=first.next;
}
 }
 	   	      System.out.println("No match found besides this");

	
} 

// A utility function to insert 
// a new node at the beginning 
// of doubly linked list 
static Node insert(Node head, int data) 
{ 
	Node temp = new Node(); 
	temp.data = data; 
	temp.next = temp.prev = null; 
	if (head == null) 
		(head) = temp; 
	else
	{ 
		temp.next = head; 
		(head).prev = temp; 
		(head) = temp; 
	} 
	return temp; 
} 

// Driver Code 
public static void main(String args[]) 
{ 
	Node head = null; 
	head = insert(head, 9); 
	head = insert(head, 8); 
	head = insert(head, 6); 
	head = insert(head, 5); 
	head = insert(head, 4); 
	head = insert(head, 2); 
	head = insert(head, 1); 
	int x = 7; 

	pairSum(head, x); 
} 
} 

// This code is contributed 
// by Arnab Kundu 
