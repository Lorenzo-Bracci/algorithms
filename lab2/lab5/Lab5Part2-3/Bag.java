//Lorenzo Bracci
//2019-10-05
//Ths program implements a bag implemented with a linked list
import java.util.Iterator;
public class Bag<Item> implements Iterable<Item>
{
private Node first; // first node in list
private class Node
{
Item item;
Node next;
}
public boolean isEmpty() { return first == null; }
public void add(Item item)
{
Node oldfirst = first;
first = new Node();
first.item = item;//sets the first item as the new first(the same implementaton as in a stack)
first.next = oldfirst;
}
public Iterator<Item> iterator()
{ return new ListIterator(); }
private class ListIterator implements Iterator<Item>
{
private Node current = first;
public boolean hasNext()
{ return current != null; }
public void remove() { }
public Item next()
{
Item item = current.item;
current = current.next;
return item;
}
}
}
