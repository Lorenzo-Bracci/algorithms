// Lorenzo Bracci
//2019-09-27
//The code implements a generic iterable FIFO-queue based on a double linked list.
import java.util.Iterator;
public class Queue<Item> implements Iterable<Item> {//implements the interface iterable in order to create an iterator for the object
 class Node<Item>
  {
  Item item;
  Node <Item> next;
  Node <Item> previous;
  }
  public Node <Item> createNode(Item n){//method to create a node
    Node <Item> node = new Node <Item>();
    node.item = n;
    return node;
  }
  private Node <Item> head = new Node<Item>();
  public Iterator<Item> iterator()
  { return new listIterator(); }
  private class listIterator implements Iterator<Item>{
    private Node <Item> current = head.next;//starts from the first Node that contains an element
  public boolean hasNext() { return current != head; }//checks of the node.next reached the end of the list
  public Item next() {//returns the current item and then increments the pointer
    Item item = current.item;//copies the element of the current node
 current = current.next;//increase the node pointer
  return item;//returns the item saved
 }
  }
  public void print(){
    Node <Item> n = head.next;
    while(n != head){
      System.out.println(n.item);
      n = n.next;
    }
}
public void enqueue(Item item){//insert a new Node in the bottom of the list
  Node n = createNode(item);
  if(head.next == null){//covers the base case where the list is empty
    head.next = n;
  n.next = head;
  head.previous = n;
  n.previous = head;
}else{
  n.next = head;//1) n->next = head->next
n.previous = head.previous;//2) n->prev = head
head.previous.next = n;//3) head->previous->next = n
head.previous = n;//4) head->prev = n
}
}
public void removeTop (){//removes element from the top of the list
    if(head.next == null)//check if the list is empty
    return;
    if(head.next.next == null){//special case where the queue has only one object
  head.next = head;//then if there was one elemnt the queue becomes empty
  return;
    }
  head.next = head.next.next;//pops the first element that was inserted
  head.next.previous = head;//updates the previous value of the new head.next to head
  Iterator<Item> iterator = iterator();//creates an iterator object
  while (iterator.hasNext()){//checks if we reached the end of the list
  System.out.println(iterator.next());//prints the current item
  }
}
public void removeBottom (){//removes element from the bottom of the list
    if(head.next == null)//check if the list is empty
    return;
    if(head.next.next == null){//special case where the list has only one object
  head.next = head;//then if there was one elemnt the list becomes empty
  return;
    }
  head.previous = head.previous.previous;//pops the last element that was inserted
  head.previous.next = head;//updates the next value of the new head.previous to head
  Iterator<Item> iterator = iterator();//creates an iterator object
  while (iterator.hasNext()){//checks if we reached the end of the list
  System.out.println(iterator.next());//prints the current item
  }
}
}
