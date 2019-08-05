
public class PriorityQueueUsingDoublLinkedList
{
static Node front , rear; 
      
// Linked List Node  
static class Node {  
    int info;  
    int priority;  
     Node prev, next;  
} 
        //queue first come first go
// Function to insert a new Node  
static void push(Node fr, Node rr, int n, int p)  
{Node news = new Node();  
    news.info = n;  
    news.priority = p;  
    
    // If linked list is empty  
    if (fr == null) {  
        fr = news;  
        rr = news;  
        news.next = null;  
    }  
    else {  
        // If p is less than or equal front  
        // node's priority, then insert at  
        // the front.  
        if (p <= (fr).priority) {  
            news.next = fr;  
            (fr).prev = news.next;  
            fr = news;  
        }  
    
        // If p is more rear node's priority,   
        // then insert after the rear.  
        else if (p > (rr).priority) {  
            news.next = null;  
            (rr).next = news;  
            news.prev = (rr).next;  
            rr = news;  
        }  
    
        // Handle other cases  
        else {  
    
            // Find position where we need to  
            // insert.  
            Node start = (fr).next;  
            while (start.priority > p)   
                start = start.next;              
            (start.prev).next = news;  
            news.next = start.prev;  
            news.prev = (start.prev).next;  
            start.prev = news.next;  
        }  
    }  
    front =fr; 
    rear=rr; 
}


// Diver code  
public static void main(String args[])  
{  
      
    push(front, rear, 2, 3);  
    push(front, rear, 3, 4);  
    push(front, rear, 4, 5);  
    push(front, rear, 5, 6);  
    push(front, rear, 6, 7);  
    push(front, rear, 1, 2);  
    
    
    
}  
}
