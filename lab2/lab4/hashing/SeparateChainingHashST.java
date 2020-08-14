//Lorenzo Bracci
//2019-09-29
//This program implements Hashing with separate chaining
public class SeparateChainingHashST<Key, Value>
{
private int N; // number of key-value pairs
private int M; // hash table size
private SequentialSearchST<Key, Value>[] st; // array of ST objects
public SeparateChainingHashST()
{ this(997); }//picks 997 as the size of the array
public SeparateChainingHashST(int M)
{ // Create M linked lists.
this.M = M;
st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
for (int i = 0; i < M; i++)
st[i] = new SequentialSearchST();
}
public boolean contains(Key key){
return get(key) != null;
}
private int hash(Key key)//does modulo operation after having dealt with the sign bit
{ return (key.hashCode() & 0x7fffffff) % M; }
public Value get(Key key)
{ return (Value) st[hash(key)].get(key); }
public void put(Key key, Value val)
{ st[hash(key)].put(key, val); }

}
