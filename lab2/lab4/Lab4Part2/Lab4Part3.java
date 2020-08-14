//Lorenzo Bracci
//2019-09-24
//Test the different symbol tables for assignment 3 of lab 3
import java.util.Scanner;
public class Lab4Part2{
  public static void main(String[] args)
  {
 int minlen = Integer.parseInt(args[0]); // key-length cutoff
 int n = Integer.parseInt(args[1]);
 int x = Integer.parseInt(args[2]);
orderedarrayST <String, Integer> st = new orderedarrayST<String, Integer>();
  Scanner scanner = new Scanner(System.in);
  long time1 = System.currentTimeMillis();//get the number of milliseconds since 1 Jan 1970 00:00
  while (scanner.hasNext()){
    String word = scanner.next();
    if (word.length() < minlen) continue; // Ignore short keys.
    if (!st.contains(word)) st.put(word, 1);
    else st.put(word, st.get(word) + 1);
  }
  for (String word : st.mostFrequentkeys(n, n+x)){//code to rank the mostFrequentkeys from n to n + x
    System.out.println(word + " " + st.get(word));
}
  long time2 = System.currentTimeMillis();
  long time = (time2 - time1)/10;//divides by 10 to after divide by 100 to get 2 decimals
  double copy = (double)time;
  double finalTime = (copy/100);
  System.out.println("The execution time was " + finalTime + " seconds");
}
  }
