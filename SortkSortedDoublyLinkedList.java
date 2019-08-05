
public class SortkSortedDoublyLinkedList
{
    // structure of node of 
// doubly linked list 
static class Node 
{ 
	int data; 
	Node next, prev; 
}

    
static Node insert(Node head, int data) 
{ 
	Node temp = new Node(); 
	temp.data = data; 
	temp.next = temp.prev = null; 
	if (head == null) 
		{head = temp;} 
	else
	{Node curr=head;
	    while(curr.next!=null){
	       curr=curr.next;}
	       curr.next=temp;
	} 
	
return head;} 

//swap data of a with b
static Node swap(Node a,Node b){
    int val=a.data;
    a.data=b.data;
    b.data=val;
return a;}

static Node Sorter(Node head,int k){

    //0 or 1 nodes
    if(head==null||head.next==null){return head;}
    
    Node curr=head;
    
    while(curr!=null && curr.next!=null){
    int counter=k;
    
    Node c=curr.next;
    
    while(counter>0 && c!=null){
    
        if(curr.data>=c.data){
        curr=swap(curr,c);//values
       // c=swap(curr,c);//nodes
        }
        
     c=c.next;
    counter--;
    }
    
    curr=curr.next;
    }
    
return head;

} 

static void printo(Node head){
    
Node curr=head;

if(head==null){return;}

while(curr!=null){
System.out.print(curr.data+" ");
curr=curr.next;
}
return;

}
    // Driver Code 
public static void main(String args[]) 
{ 
	Node head = null; 
	
	head = insert(head, 3); 
	head = insert(head, 6); 
	head = insert(head, 2); 
	head = insert(head, 12); 
	head = insert(head, 56);
	head = insert(head, 8); 
	
	int k=2;
	printo(head);
	System.out.println();
	head=Sorter(head,k);
	printo(head);
} 
}
