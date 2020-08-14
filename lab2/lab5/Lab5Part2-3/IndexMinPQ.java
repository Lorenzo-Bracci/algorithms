//Lorenzo Bracci
//2019-10-07
//This program implements a priority queue
public class IndexMinPQ {
  class Node
  {
  int position;
  double item;
  Node next;
  Node previous;
  }
public Node createNode (double n, int i){//method to create a node
  Node node = new Node();
  node.item = n;
  node.position = i;
return node;
}

private Node first = new Node();//first node


public int delMin(){
  int i;
  if(first.next == null)//check if the list is empty
 return -1;
 if(first.next.next == null){//special case where the queue has only one object
   i = first.next.position;
first.next = null;//then if there was one elemnt the queue becomes empty
return i;
 }
 i = first.next.position;
first.next = first.next.next;//pops the first element that was inserted
first.next.previous = first;
return i;
}
public boolean contains(int i){
  Node node = first;
  while(node.next != null){
    node = node.next;
    if(node.position == i)
    return true;
  }
  return false;
}
public void change(int i, double key){
  Node node = first;
  while(node.next != null){
    node = node.next;
    if(node.position == i){
      node.item = key;
      return;
    }
  }
  }
public boolean isEmpty(){
  return (first.next == null);
}
public void insert(int i,double key) {
  Node n = createNode(key,i);
Node node = first;
  while (true){
   if (n.item < node.item){//check if we are in the right position
      n.next = node;
      n.previous = node.previous;
      node.previous.next = n;
      node.previous = n;
      return;
    }else   if (node.next == null) {//check if there is an element after, i.e if we are in the end of the list
        node.next = n;//add the node n to the end of the queue
  n.previous = node;//add the node n to the end of the queue
        return;
      }
    node = node.next;//increments the pointer to the node
  }
}
}
