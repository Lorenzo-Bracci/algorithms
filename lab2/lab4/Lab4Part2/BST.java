//Lorenzo Bracci
//2019-09-24
//This program implements symbol tebles with BST
public class BST<Key extends Comparable<Key>, Value>
{
private Node root; // root of BST
private class Node
{
private Key key; // key
private Value val; // associated value
private Node left, right; // links to subtrees
private int N; // number nodes in subtree rooted here
public Node(Key key, Value val, int N)//constructor for the node
{ this.key = key; this.val = val; this.N = N; }
}
public int size()//returns the size of the tree
{ return size(root); }
public boolean contains(Key key){
return get(key) != null;
}
private int size(Node x){//return the size of a node
if (x == null) return 0;
else return x.N;
}
public Value get(Key key)//used to search for a key in the whole tree
{ return get(root, key); }
private Value get(Node x, Key key)
{ // Return value associated with key in the subtree rooted at x;
// return null if key not present in subtree rooted at x.
if (x == null) return null;
int cmp = key.compareTo(x.key);
if (cmp < 0) return get(x.left, key);//recursive calls that search for left node if the value of the key is smaller than the value at visited key
else if (cmp > 0) return get(x.right, key);//recursive calls that search for right node if the value of the key is bigger than the value at visited key
else return x.val;
}
public void put(Key key, Value val)
{ // Search for key. Update value if found; grow table if new.
root = put(root, key, val);
}
private Node put(Node x, Key key, Value val)
{
// Change key’s value to val if key in subtree rooted at x.
// Otherwise, add new node to subtree associating key with val.
if (x == null) return new Node(key, val, 1);//if the subtree is empty only add the node
int cmp = key.compareTo(x.key);
if (cmp < 0) x.left = put(x.left, key, val);//recursive call for left
else if (cmp > 0) x.right = put(x.right, key, val);//recursive call for right
else x.val = val;//if we found the key we update it s value
x.N = size(x.left) + size(x.right) + 1;//we compute the new size
return x;//we return the root of the subtree
}
public Iterable<Key> postkeys()
{ return postkeys(min(), max()); }
public Iterable<Key> postkeys(Key lo, Key hi)
{
Queue<Key> queue = new Queue<Key>();
postkeys(root, queue, lo, hi);
return queue;
}
private void postkeys(Node x, Queue<Key> queue, Key lo, Key hi)
{
if (x == null) return;
int cmplo = lo.compareTo(x.key);
int cmphi = hi.compareTo(x.key);
if (cmplo < 0) postkeys(x.left, queue, lo, hi);
if (cmphi > 0) postkeys(x.right, queue, lo, hi);
if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
}
public Iterable<Key> prekeys()//uses postfix iteration
{ return prekeys(min(), max()); }
public Iterable<Key> prekeys(Key lo, Key hi)
{
Queue<Key> queue = new Queue<Key>();
prekeys(root, queue, lo, hi);
return queue;
}
private void prekeys(Node x, Queue<Key> queue, Key lo, Key hi)
{
if (x == null) return;
int cmplo = lo.compareTo(x.key);
int cmphi = hi.compareTo(x.key);
if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
if (cmplo < 0) prekeys(x.left, queue, lo, hi);
if (cmphi > 0) prekeys(x.right, queue, lo, hi);
}
public Iterable<Key> keys()//uses prefix iteration
{ return keys(min(), max()); }
public Iterable<Key> keys(Key lo, Key hi)
{
Queue<Key> queue = new Queue<Key>();
keys(root, queue, lo, hi);
return queue;
}
private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
{
if (x == null) return;
int cmplo = lo.compareTo(x.key);
int cmphi = hi.compareTo(x.key);
if (cmplo < 0) keys(x.left, queue, lo, hi);
if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
if (cmphi > 0) keys(x.right, queue, lo, hi);
}
public Key min()
{
return min(root).key;
}
private Node min(Node x)
{
if (x.left == null) return x;
return min(x.left);
}
public Key max()
{
return max(root).key;
}
private Node max(Node x)
{
if (x.right == null) return x;
return max(x.right);
}
}
