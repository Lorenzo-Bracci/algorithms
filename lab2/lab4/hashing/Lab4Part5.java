//Lorenzo Bracci
//28-08-2019
//This program shows how evenly the built-in hash function
//for strings in Java distributes the hashes for the words found in the text.
import java.util.Scanner;
public class Lab4Part5{
  public static void main(String[] args){
    LinearProbingHashST <Integer, Integer> st = new LinearProbingHashST<Integer, Integer>(16);
      long time1 = System.currentTimeMillis();//get the number of milliseconds since 1 Jan 1970 00:00
    for(int i = 0; i < 97; i++)
    st.put( i, 0);//fills the symbol table with the indexes of the array and 0s that represents that all of these linked lists have 0 elements
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()){
      String word = scanner.next();
      int hashCode = word.hashCode();
      hashCode = (hashCode & 0x7fffffff) % 97;
      st.put(hashCode, st.get(hashCode) + 1);//fills the symbol table with the number of occurnces of every index
   }
   for (int i = 0; i < 97; i++)
   System.out.println(st.get(i));//prints the occurences of all the ashes
   long time2 = System.currentTimeMillis();
   long time = (time2 - time1)/10;//divides by 10 to after divide by 100 to get 2 decimals
   double copy = (double)time;
   double finalTime = (copy/100);
   System.out.println("The execution time was " + finalTime + " seconds");
  }
}
