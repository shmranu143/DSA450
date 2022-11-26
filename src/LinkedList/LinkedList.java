package LinkedList;

import netscape.security.UserTarget;

import java.util.*;

public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static void insert(LinkedList list,int data){
        Node new_node = new Node(data);
        if(list.head==null){
            list.head=new_node;
        }
        else{
            Node temp = list.head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=new_node;
        }

    }

    static Node insertAtPosition(Node head,int data,int pos){
        if(head==null){
            System.out.println("given list is empty");
            return head;
        }
        Node new_node = new Node(data);
        Node temp = head;
        for(int i =1;i<pos-1;i++){
            temp=temp.next;
            if(temp.next==null){
                System.out.println("position is invalid");
                return head;
            }
        }
        if(pos==1){
            new_node.next=head;
            return new_node;
        }
        new_node.next=temp.next;
        temp.next = new_node;
        return head;
    }

    static void printList(Node head){
        if(head==null){
            return;
        }
        Node temp = head;
        while (temp.next!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.print(temp.data+" \n");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int temp =  size;
        LinkedList list = new LinkedList();
        while (temp-->0){
            int data = sc.nextInt();
            insert(list,data);
        }
        Node linkedList =list.head;
//        linkedList = insertAtPosition(list.head,1,1);
//        linkedList = insertAtPosition(linkedList,5,5);
//        linkedList = insertAtPosition(linkedList,7,7);
//        printList(linkedList);
//        linkedList = deleteNodeFromPosition(linkedList,2);
//        printList(linkedList);
//        linkedList = makeCircular(linkedList);
//        boolean hasCircle = findCircle(linkedList);
//        System.out.println(hasCircle);
//        linkedList = reverse(linkedList);
        insertAtMid(list.head,7);
        printList(linkedList);
        System.out.println("linked list operations ends here");

    }

    public static void insertAtMid(Node head, int data){
        if(head==null) return;
        Node temp = head;
        int count=0;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        temp=head;
        count = count%2==0?count/2-1:count/2;
        for(int i =1;i<=count;i++){
            temp=temp.next;
        }
        Node mid = new Node(data);
        mid.next=temp.next;
        temp.next=mid;
//        return head;
    }

    private static Node reverse(Node head) {
        if(head==null){
            return head;
        }
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }

    private static Node deleteNodeFromPosition(Node head, int pos) {
        if(head==null || pos<1) return head;
        Node prev = head;
        Node curr = head;
        if (pos==1){
            head=curr.next;
            return head;
        }
        while (pos-->1){
            prev=curr;
            curr=curr.next;
        }
        prev.next=curr.next;
        return head;
    }

    public static Node deleteNode(Node head, int x)
    {
        if(head==null || x<1) return head;
        if(x==1) return head.next;
        Node temp = head;
        for(int i=1;i<x-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }

    private static boolean findCircle(Node head) {
        if (head==null){
            return false;
        }
        Node temp = head.next;
        while (temp.next!=null && temp.next!=head){
            temp=temp.next;
        }
        if (temp.next==null) return false;
        else return true;
    }

    private static Node makeCircular(Node head) {
        if(head==null){
            return head;
        }
        Node temp = head.next;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        return head;
    }

    //Function to remove a loop in the linked list.

}


