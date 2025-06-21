public class BasicLinkedList
{
    // 1. Node Definition
    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    // 2. Insert at Head
    static Node insertAtHead(Node head, int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    // 3. Insert at Tail
    static Node insertAtTail(Node head, int data)
    {
        Node newNode = new Node(data);
        if(head == null) return newNode;

        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // 4. Delete Head
    static Node deleteHead(Node head)
    {
        if(head == null) return null;
        return head.next;
    }

    // 5. Delete Tail
    static Node deleteTail(Node head)
    {
        if(head == null || head.next == null) return null;

        Node temp = head;
        while(temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // 6. Print List
    static void printList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args)
    {
        Node head = null;

        head = insertAtHead(head, 30);
        head = insertAtHead(head, 20);
        head = insertAtTail(head, 40);
        head = insertAtTail(head, 50);

        System.out.print("List: ");
        printList(head);  // 20 -> 30 -> 40 -> 50 -> null

        head = deleteHead(head);
        System.out.print("After deleting head: ");
        printList(head);  // 30 -> 40 -> 50 -> null

        head = deleteTail(head);
        System.out.print("After deleting tail: ");
        printList(head);  // 30 -> 40 -> null
    }
}
