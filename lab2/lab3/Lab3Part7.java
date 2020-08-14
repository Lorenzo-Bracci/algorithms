// Lorenzo Bracci
//2019-09-21
// The code Implement a linked list which should hold elements of type int
//and implements a method to insert new elements in ascending order
public class Lab3Part7{
private class Node
{
int item;
Node next;
Node previous;
}
public Node createNode(int n){//constructor for a node
  Node node = new Node();
  node.item = n;
  return node;
}
private Node first = new Node();//first node
public static void main (String[]args){//method for testing
  Lab3Part7 list = new Lab3Part7();//instantiate an object of the class to use the methods
list.insertAscending(list.createNode(1));
list.insertAscending(list.createNode(3));
list.insertAscending(list.createNode(2));
list.dequeue();
}

public void dequeue(){
  if(first.next == null)//check if the list is empty
 return;
 if(first.next.next == null){//special case where the queue has only one object
first.next = first;//then if there was one elemnt the queue becomes empty
return;
 }
first.next = first.next.next;//pops the first element that was inserted
first.next.previous = first;
print();
}
public void print(){
  Node node;
  node = first.next;
  while(node != null){
  System.out.println(node.item);
  node = node.next;//iterating through the nodes
  }
}

public void insertAscending(Node n) {
  Node node = first;
  boolean done = false;
  while (!done){
    if (n.item < node.item){//check if we are in the right position
      n.next = node;
      n.previous = node.previous;
      node.previous.next = n;
      node.previous = n;
      done = true;
    }else if (node.next == null) {//check if there is an element after, i.e if we are in the end of the list
      node.next = n;//add the node n to the end of the queue
n.previous = node;//add the node n to the end of the queue
      done = true;
      }
    node = node.next;//increments the pointer to the node
  }
  print();//prints the list
}
}
