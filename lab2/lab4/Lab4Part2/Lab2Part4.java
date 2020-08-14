//Lorenzo Bracci
//2019-09-24
//Test the different symbol tables for assignment 2 of lab 3
import java.util.Scanner;
public class Lab4Part2{
  public static void main(String[] args)
  {
  int minlen = Integer.parseInt(args[0]); // key-length cutoff
  orderedarrayST <String, Integer> st = new orderedarrayST<String, Integer>();
  while (!StdIn.isEmpty())
  { // Build symbol table and count frequencies.
  String word = StdIn.readString();
  if (word.length() < minlen) continue; // Ignore short keys.
  if (!st.contains(word)) st.put(word, 1);
  else st.put(word, st.get(word) + 1);
  }
  // Find a key with the highest frequency count.
  String max = "";
  st.put(max, 0);
  for (String word : st.keys())
  if (st.get(word) > st.get(max))
  max = word;
  StdOut.println(max + " " + st.get(max));
  }
  }
