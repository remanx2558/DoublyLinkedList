//Java program to create a doubly linked list 
// from a given ternary tree. 

//Custom node class. 

class CreateDDLfromTertiaryTree { 
    static newNode head=null;
	
    static class newNode 
{ 
	int data; 
	newNode left,middle,right; 
	public newNode(int data) 
	{ 
		this.data = data; 
		left = middle = right = null; 
	} 
} 

	//tail of the linked list. 
	static newNode tail; 

	//function to initiate the list process. 
	//wrpper function
	
	
	static void push(newNode head,int val){
	   
	    newNode temp=new newNode(val);
	    
	    if(head==null){
	   head=temp;
	   return;
	   }
	   
	   newNode temp2=head;
	   
	   while(temp2.right!=null){
	   temp2=temp2.right;}
	   
	   temp2.right=temp;
	   temp.left=temp2;
	   temp.middle=temp.right=null;
	   return;
	   
	   
	   }
	
	static void ternaryTree(newNode node,newNode head){
	  
	if(node == null) 
            return;                      
        newNode left = node.left; 
        newNode middle = node.middle; 
        newNode right = node.right; 
        if(tail != node) 
          
            // already root is in the tail so dont push  
            // the node when it was root.In the first  
            // case both node and tail have root in them. 
            push(head,node.data);              
              
        // First the left child is to be taken. 
        // Then middle and then right child. 
        ternaryTree(left,head);          
        ternaryTree(middle,head); 
        ternaryTree(right,head);
	   }
	   
	   public static newNode startTreeWrapper(newNode root) 
	{ 
		//Initiate the head and tail with root. 
		newNode head = root; 
		tail = root; 
		ternaryTree(root,head); 
		
		//since the head,root are passed 
		// with reference the changes in 
		// root will be reflected in head. 
		return head;		 
	} 
	
	// Utility function for printing double linked list. 
	public static void printList(newNode head) 
	{ 
		System.out.print("Created Double Linked list is:\n"); 
		while(head != null) 
		{ 
			System.out.print(head.data + " "); 
			head = head.right; 
		} 
	} 
	
	// Driver program to test above functions 
	public static void main(String args[]) 
	{ 
		
		// Construting ternary tree as shown 
		// in above figure 
		newNode root = new newNode(30); 
		root.left = new newNode(5); 
		root.middle = new newNode(11); 
		root.right = new newNode(63); 
		root.left.left = new newNode(1); 
		root.left.middle = new newNode(4); 
		root.left.right = new newNode(8); 
		root.middle.left = new newNode(6); 
		root.middle.middle = new newNode(7); 
		root.middle.right = new newNode(15); 
		root.right.left = new newNode(31); 
		root.right.middle = new newNode(55); 
		root.right.right = new newNode(65); 
		
		// The function which initiates the list 
		// process returns the head. 
		newNode head = startTreeWrapper(root);		 
		printList(head); 
	} 
} 

// This code is contributed by M.V.S.Surya Teja. 
