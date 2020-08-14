// Lorenzo Bracci
//2019-09-05
//The code implements a generic iterable FIFO-queue based on a double linked list.
//
and it prints the content of the list every time that an element is enqueued/dequeued
class Node <Item>//uses java generics
{
Item item;
Node <Item> next;
Node <Item> previous;
}
public class Lab2Part3 <Item>{////uses java generics
 public Node <Item> createNode (Item n){//method to create a node
   Node <Item> node = new Node <Item>();
   node.item = n;
return node;
 }
 public static void main (String[]args){//test method
    Lab2Part3 <Integer> list = new Lab2Part3<Integer>();//creating an instance of an object of the same type as this class
//Node <Item> node1 = new Node <Item>();
//node1.item = 0;
list.push(list.createNode(0));
list.push(list.createNode(1));
list.push(list.createNode(2));
list.pop();
list.pop();
list.pop();
  }
 private Node <Item> head = new Node <Item>();//creates the head of the doubly linked list that is gonna stay empty
 public void push(Node <Item> n){//pushes an element on the queue
Node <Item> node = head;//makes a copy of the head
while(node.next != null){
  node = node.next;//iterates through all the nodes to arrive at the bottom of the queue
  System.out.println(node.item);
}
node.next = n;//add the node n to the end of the queue
n.previous = node;//add the node n to the end of the queue
System.out.println(n.item);
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
Node <Item> node = head.next;
while(node != null){//iterates through the list to print it
  System.out.println(node.item);
  node = node.next;
}
}
}
