//Lorenzo Bracci
//28-08-2019
//This program compare the performance of Hashing with separate chaining to Hashing with linear probing
import java.util.Scanner;
public class Lab4Part7{
  public static void main(String[] args)
  {
    int minlen = Integer.parseInt(args[0]); // key-length cutoff
 LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>(16);
  Scanner scanner = new Scanner(System.in);
  long time1 = System.currentTimeMillis();//get the number of milliseconds since 1 Jan 1970 00:00
  while (scanner.hasNext()){
    String word = scanner.next();
    if (word.length() < minlen) continue; // Ignore short keys.
    if (!st.contains(word)) st.put(word, 1);
    else st.put(word, st.get(word) + 1);
  }

  long time2 = System.currentTimeMillis();
  long time = (time2 - time1)/10;//divides by 10 to after divide by 100 to get 2 decimals
  double copy = (double)time;
  double finalTime = (copy/100);
  System.out.println("The execution time was " + finalTime + " seconds");
}
  }
