//Lorenzo Bracci
//2019-09-09
//The code implements an ordered queue based on the implementation of Lab2Part3
// The elements stored in the queue should be integer values.
//The elements should be ordered when insertion so that all elements are stored in ascending order.
public class Lab2Part6 {
  class Node
  {
  int item;
  Node next;
  Node previous;
  }
 public Node createNode (int n){//method to create a node
   Node node = new Node ();
   node.item = n;
return node;
 }
 public static void main (String[]args){//test method
    Lab2Part6 list = new Lab2Part6();//creating an instance of an object of the same type as this class
list.insertAscending(list.createNode(0));
list.insertAscending(list.createNode(1));
list.insertAscending(list.createNode(3));
list.insertAscending(list.createNode(4));
list.insertAscending(list.createNode(2));
//list.pop();
//list.pop();
//list.pop();
  }
 private Node head = new Node ();//creates the head of the doubly linked list that is gonna stay empty
 /*public void insertAscending(Node n) {
  Node node = first;
  int done = 0;
  while (done == 0){
    if (n.item < node.item){//check if we are in the right position
      done = 1;
    }else if (node.next == null) {//check if there is an element after, i.e if we are in the end of the list
      done = 2;
      node.next = n;
      }
    if (done == 1) {//allowing to insert the element if we found the position
      n.next = node.next;
      node.next = n;
    }
    node = node.next;
  }
  elements++;
}
 */
 public void insertAscending(Node n){//pushes an element on the queue in ascending order
   if(head.next == null){//covers the case where the list is empty
     head.next = n;
     System.out.println(n.item);
     return;
   }
Node node = head.next;//makes a copy of the head
boolean done = false;//checks if we found the right position
while(!done){
  if (n.item < node.item){//check if we are in the right position, if it is insert the new element in the list
    n.next = node;
  n.previous = node.previous;
  node.previous.next = n;
  node.previous = n;
  done = true;
  System.out.println(n.item);//prints the node added
  }else if (node.next == null) {//check if there is an element after, i.e if we are in the end of the list
    node.next = n;
    n.previous = node;
    done = true;
    }
    System.out.println(node.item);//prints the list before incrementing the pointer
    if(!done)//checks if we are done
    node = node.next;
}
while (node.next != null){//prints the rest of the list
  System.out.println(node.next.item);
  node = node.next;
  }
}
public void pop(){
  if(head.next == null)//check if the list is empty
  return;
  if(head.next.next == null){//special case where the queue has only one object
head.next = head;//then if there was one elemnt the queue becomes empty
return;
  }
head.next = head.next.next;//pops the first element that was inserted
head.next.previous = head;
Node node = head.next;
while(node != null){//iterates through the list to print it
  System.out.println(node.item);
  node = node.next;
}
}
}
