public class IndexMinPQ<Key extends Comparable<Key>> {
  class Node<Key extends Comparable<Key>>
  {
  int position;
  Key item;
  Node next;
  Node previous;
  }
public Node createNode (Key n, int i){//method to create a node
  Node<Key> node = new Node<Key>();
  node.item = n;
  node.position = i;
return node;
}

private Node<Key> first = new Node<Key>();//first node


public int dequeue(){
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
  Node<Key> node = first;
  while(node.next != null){
    node = node.next;
    if(node.position == i)
    return true;
  }
  return false;
}
public void change(int i, Key key){
  Node<Key> node = first;
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
public void insert(int i,Key key) {
  Node<Key> n = createNode(key,i);
  Node<Key> node = first;
  boolean done = false;
  while (!done){
    if (n.item.compareTo(node.item) < 0){//check if we are in the right position
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
}
}
