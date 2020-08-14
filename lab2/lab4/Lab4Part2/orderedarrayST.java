//Lorenzo Bracci
//2019-09-24
//This program implements symbol tebles with ordered arrays
//lab4assignment3:Extend the orderedarrayST implementations to allow the user to query the system on which are the nth to the n+xth
// (i.e. which keys (words) fall in the range [n,n+x] most frequent words) most frequent words in the full text
import java.util.Iterator;
public class orderedarrayST<Key extends Comparable<Key>, Value extends Comparable<Value>> {//uses java generics
  private Key[] keys = (Key[]) new Comparable[1];//array the  stores all the keys
private Value[] vals = (Value[]) new Comparable[1];//array that stores the value associated with different keys
private int N = 0;//size of the array
public boolean isEmpty(){if(N == 0){return true;}else{return false;}}
public int rank(Key key)//binary search algorithm used to find the index of a key in logN time
{
int lo = 0, hi = N-1;
while (lo <= hi)
{
int mid = lo + (hi - lo) / 2;
int cmp = key.compareTo(keys[mid]);
if (cmp < 0) hi = mid - 1;
else if (cmp > 0) lo = mid + 1;
else return mid;
}
return lo;
}
private void resize1(int max)
{ // Move stack to a new array of size max.
Key[] temp = (Key[]) new Comparable[max];
for (int i = 0; i < N; i++)
temp[i] = keys[i];
keys = temp;
}
private void resize2(int max)
{ // Move stack to a new array of size max.
Value[] temp = (Value[]) new Comparable[max];
for (int i = 0; i < N; i++)
temp[i] = vals[i];
vals = temp;
}
public Value get(Key key)//gets the value of a certain key
{
if (isEmpty()) return null;
int i = rank(key);//gets the index
if (i < N && keys[i].compareTo(key) == 0) return vals[i];//checks that the index is valid
else return null;
}
public boolean contains(Key key){
return get(key) != null;
}
public int size (){
return N;
}
public void put(Key key, Value val)
{ // Search for key and update value if found; grow table if new.
  if(N == 0){keys[0] = key; vals[0] = val;}else{
int i = rank(key);//if the key doesn t exyist you get the spot where it should be
if (i < N && keys[i].compareTo(key) == 0)//if the key already exists, then update its value
{ vals[i] = val; return; }
if (N == keys.length){ resize1(2*keys.length); resize2(2*vals.length);}
for (int j = N; j > i; j--)//swaps all the vlues of the array before the spot where the new element should be
{ keys[j] = keys[j-1]; vals[j] = vals[j-1]; }
keys[i] = key; vals[i] = val;//puts the new key with its value in the right position
}
N++;
}
public Iterable<Key> keys ()
{if (N == 0) return keys(keys[0], keys[0]);
   return keys(keys[0], keys[N-1]); }
public Iterable<Key> keys(Key lo, Key hi)
{
Queue<Key> q = new Queue<Key>();
for (int i = rank(lo); i < rank(hi); i++){
q.enqueue(keys[i]);
}
if (contains(hi))
q.enqueue(keys[rank(hi)]);
return q;
}
public void print(){
  for (int i = 0; i < N; i++)
  System.out.println(keys[i] + " " + vals[i]);
}
public void mergeSort()
{
  Value[] aux = (Value[]) new Comparable[N];
  Key[] aux2 = (Key[]) new Comparable[N];
mergeSort(0, (N-1),aux, aux2);
}
private void mergeSort(int lo, int hi,Value [] aux, Key[] aux2)
{ // Sort a[lo..hi].
if (hi <= lo) return;
int mid = lo + (hi - lo)/2;
mergeSort( lo, mid, aux, aux2); // Sort left half.
mergeSort( mid+1, hi, aux, aux2); // Sort right half.
merge( lo, mid, hi, aux, aux2); // Merge results (code on page 271).
}
public void merge( int lo, int mid, int hi,Value [] aux,Key [] aux2)
{ // Merge a[lo..mid] with a[mid+1..hi].
int i = lo, j = mid+1;
int i2 = lo;
int j2 = mid + 1;
for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
aux[k] = vals[k];
for (int k = lo; k <= hi; k++) // Copy b[lo..hi] to aux2[lo..hi].
aux2[k] = keys[k];
for (int k = lo; k <= hi; k++){ // Merge back to a[lo..hi].
if (i > mid){ vals[k] = aux[j++]; keys[k] = aux2[j2++];}//if we pass the half takes elements from the second half
else if (j > hi ){ vals[k] = aux[i++]; keys[k] = aux2[i2++];}//if we pfinished the second half takes elements from the first half
else if (aux[j].compareTo(aux[i]) < 0){ vals[k] = aux[j++]; keys[k] = aux2[j2++];}//checks if the elemts from the pointer on the left or the one with the pointer to the right is smaller
else{ vals[k] = aux[i++]; keys[k] = aux2[i2++];}
}
}

public Iterable<Key> mostFrequentkeys(int lo, int hi)//method for lab4 assignment3 which return the keys between the nth most frequent and the nth + x most frequent
{
  mergeSort();
Queue<Key> q = new Queue<Key>();
for (int i = lo; i < hi; i++){
q.enqueue(keys[i]);
}
q.enqueue(keys[hi]);
return q;
}
}
