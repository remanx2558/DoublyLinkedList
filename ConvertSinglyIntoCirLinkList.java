
public class ConvertSinglyIntoCirLinkList
{
    /*Linked list node */
static class Node  
{ 
    int data; 
    Node next; 
}; 
  
// Function that convert  
// singly linked list into 
// circular linked list. 
static Node circular(Node head) 
{ 
    
    if(head==null){return head;}
    if(head!=null && head.next==null){
    head.next=head;
    return head;
    }
    Node end=head;
    Node temp=head;
    while(temp.next!=null){
    temp=temp.next;
    }
    end=temp;
    end.next=head;
    return head;
} 
  
static Node push(Node head, int data) 
{ 
    // Allocate dynamic memory  
    // for newNode. 
    Node newNode = new Node(); 
  
    // Assign the data into newNode. 
    newNode.data = data; 
  
    // newNode.next assign the  
    // address of head node. 
    newNode.next = (head); 
  
    // newNode become the headNode. 
    (head) = newNode; 
      
    return head; 
} 
  
// Function that display the elements  
// of circular linked list. 
static void displayList( Node node) 
{ 
    Node start = node; 
  
    while (node.next != start) 
    { 
        System.out.print(" "+ node.data); 
        node = node.next; 
    } 
      
    // Display the last node of   
    // circular linked list. 
    System.out.print(" " + node.data); 
} 
  
// Driver Code 
public static void main(String args[]) 
{ 
    // Start with empty list 
    Node head = null; 
  
    // Using push() function to  
    // convert singly linked list 
    // 17.22.13.14.15 
    head = push(head, 15); 
    head = push(head, 14); 
    head = push(head, 13); 
    head = push(head, 22); 
    head = push(head, 17); 
  
    // Call the circular_list function  
    // that converst singly linked  
    // list to circular linked list. 
    circular(head); 
  
    System.out.print("Display list: \n"); 
    displayList(head); 
} 
  
}
