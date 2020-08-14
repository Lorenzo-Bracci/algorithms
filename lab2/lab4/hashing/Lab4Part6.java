//Lorenzo Bracci
//28-08-2019
//This program allows the user to ask the question "on which positions in the text
//(i.e. the number of characters from the beginning) you find the word X".
// The program should list the position of all occurrences of X as answer to the query.
//In this assignment you may use the Java library (built-in) lists.
import java.util.LinkedList;
import java.util.Scanner;
public class Lab4Part6{
  public static void main(String[] args){
    String word = args[0];
    LinkedList<Integer> occurences = new LinkedList<Integer>();
    Scanner scanner = new Scanner(System.in);
    int index = 1;
    while (scanner.hasNext()){
      String text = scanner.next();
      if(text.equals(word))
      occurences.add(index);//add the index to the linked list if we found the right word
      index = index + text.length() + 1;//The one represents space
   }
   for (Integer i : occurences)
   System.out.println(i);//prints the indexes
  }
}
