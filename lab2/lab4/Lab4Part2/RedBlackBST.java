//Lorenzo Bracci
//2019-09-26
//This program implements symbol tebles with a red black BST
public class RedBlackBST<Key extends Comparable<Key>, Value>
{
  public static final boolean RED = true;//defines the one bit variable true as red
  public static final boolean BLACK = false;//defines the one bit variable false as black
  private class Node
  {
  Key key; // key
  Value val; // associated data
  Node left, right; // subtrees
  int N; // # nodes in this subtree
  boolean color; // color of link from
  // parent to this node
  Node(Key key, Value val, int N, boolean color)//constructor for a node
  {
  this.key = key;
  this.val = val;
  this.N = N;
  this.color = color;
  }
  }
private Node root; // root of BST
private boolean isRed(Node x)
{
if (x == null) return false;
return x.color == RED;
}
Node rotateLeft(Node h)//rotate a given node to the left
{
Node x = h.right;
h.right = x.left;//puts everything between h and x to the right of h
x.left = h;//makes h become a child of x
x.color = h.color;//establishes the new proper colors
h.color = RED;
x.N = h.N;
h.N = 1 + size(h.left)
+ size(h.right);
return x;
}
Node rotateRight(Node h)//the exact same concept of rotate left but on the right direction
{
Node x = h.left;
h.left = x.right;
x.right = h;
x.color = h.color;
h.color = RED;
x.N = h.N;
h.N = 1 + size(h.left)
+ size(h.right);
return x;
}
void flipColors(Node h)//when the children of a node are both red makes them black while making the node itself red
{
h.color = RED;
h.left.color = BLACK;
h.right.color = BLACK;
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
root.color = BLACK;
}
private Node put(Node h, Key key, Value val)
{
if (h == null) // Do standard insert, with red link to parent.
return new Node(key, val, 1, RED);
int cmp = key.compareTo(h.key);//the next 3 lines use normal insertion in a BST
if (cmp < 0) h.left = put(h.left, key, val);
else if (cmp > 0) h.right = put(h.right, key, val);
else h.val = val;
if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);//if the red node is on the right than we rotate left
if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);// if both the left child and grandchild are red than we rotate right and then flip the colors
if (isRed(h.left) && isRed(h.right)) flipColors(h);
h.N = size(h.left) + size(h.right) + 1;
return h;
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
