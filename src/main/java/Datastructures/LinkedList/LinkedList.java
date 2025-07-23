package Datastructures.LinkedList;

public class LinkedList {
    static class Node {
        int data;
        Node next;
        Node (int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data, null);
        if (head == null ) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static void printLinkedList(Node head) {
        while (head != null ) {
            System.out.print(head.data +"->");
            head = head.next;
        }
    }
    public static void main(String args[]) {
        Node head = new Node(1, null);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);
        System.out.println("Linked List:");
        printLinkedList(head);
    }
}
