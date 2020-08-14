//Lorenzo Bracci
//2019-10-05
//Ths program implements a stack implemented with a resizable array
import java.util.Iterator;
public class Stack<Item> implements Iterable<Item>
{
private Item[] a = (Item[]) new Object[1]; // stack items
private int N = 0; // number of items
public boolean isEmpty() { return N == 0; }
public int size() { return N; }
private void resize(int max)
{ // Move stack to a new array of size max.
Item[] temp = (Item[]) new Object[max];
for (int i = 0; i < N; i++)
temp[i] = a[i];
a = temp;
}
public void push(Item item)
{ // Add item to top of stack.
if (N == a.length) resize(2*a.length);
a[N++] = item;
}
public Item pop()
{ // Remove item from top of stack.
Item item = a[--N];
a[N] = null; // Avoid loitering (avoid having space in memory for data no loger used).
if (N > 0 && N == a.length/4) resize(a.length/2);
return item;
}
public Iterator<Item> iterator()
{ return new ReverseArrayIterator(); }
private class ReverseArrayIterator implements Iterator<Item>
{ // Support LIFO iteration.
private int i = N;
public boolean hasNext() { return i > 0; }
public Item next() { return a[--i]; }
public void remove() { }
}
}
