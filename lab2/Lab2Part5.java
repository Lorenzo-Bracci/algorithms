//Lorenzo Bracci
//2019-09-06
//The code implements a genealized queue which allows the user
// to remove the kth element from the queue.
public class Lab2Part5 <Item>{//uses java generics
  class Node <Item>//uses java generics
  {
  Item item;
  Node <Item> next;
  Node <Item> previous;
  }
 public Node <Item> createNode (Item n){//method to create a node
   Node <Item> node = new Node <Item>();
   node.item = n;
return node;
 }
 public static void main (String[]args){//test method
    Lab2Part5 <Integer> list = new Lab2Part5<Integer>();//creating an instance of an object of the same type as this class
//Node <Item> node1 = new Node <Item>();
//node1.item = 0;
list.push(list.createNode(0));
list.push(list.createNode(1));
list.push(list.createNode(2));
list.popkth(3);
list.popkth(1);
list.popkth(2);
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
public void popkth(int k){
  if(head.next == null)//check if the list is empty
  return;
  int counter = 0;
  boolean elementNotFound = false;
Node <Item> node = head;
while(counter != k){//iterates through the list to search the position where the new element has to be inserted
  if(node.next == null){//checks if we are in the end of the list
  elementNotFound = true;
    break;
    }
  node = node.next;
  counter++;
}
if(!elementNotFound){//check if the element that we want to remove is not in the list
if (node.next == null){//checks if the queue ends to create a special case to avoid null pointer exception
  node.previous.next = null;//makes the new last element point to null
}else{
node.previous.next = node.next;//updates the next pointer of the previous element
node.next.previous = node.previous;//updates the previous pointer of the next element
}
}
Node <Item> nodeCopy = head.next;
while(nodeCopy != null){//iterates through the list to print it
  System.out.println(nodeCopy.item);
  nodeCopy = nodeCopy.next;
}
}
}
