// Lorenzo Bracci
//2019-09-04
//reads characters from stdin until a newline
//character is read and then prints them on stdout in reverse order with an iterative method
//using a stack implemented with a resizable array
import java.lang.String;
public class Lab2Part2{
  private char[] a = new char[10]; // stack items
private int N = 0; // number of items
public boolean isEmpty() { return N == 0; }//checks wether the stack is empty
public int size() { return N; }
private void resize(int max)// Move stack to a new array of size max, it is used when the array is full or too isEmpty
{
char[] temp = new char[max];//creates the new array
for (int i = 0; i < N; i++)
temp[i] = a[i];//copies every elementof the old array in a new array
a = temp;// makes the new array point to the old array where we store the data for the stack
}
public void push(char item)// Adds item to top of stack.
{
if (N == a.length) resize(2*a.length);//if the array is full it creates an array with size double than old one
a[N++] = item;//it fills a spot in the stack with the data and than it increments N that represents where we will store the next piece of data
}
public char pop()// Remove item from top of stack.
{
char item = a[--N];//decrements the pointer that was meant to be pointing at the next element and it saves the top of the stack
//a[N] = null;
if (N > 0 && N == a.length/4) resize(a.length/2);//if only a quarter of the array is filled than we half the size of the array
return item;//returns the top of the array
}
  public static void main (String[]args){
    Lab2Part2 stack = new Lab2Part2();
    for (int i = 0; i < args.length; i++){//loops through all the strings
      for (int j = 0;j < args[i].length();j++){//loops through all the caracthers in the strings
        stack.push(args[i].charAt(j));//stacks the chars on the stack
        }
        }
        for (int i = 0; i < args.length; i++){
          for (int j = 0;j < args[i].length();j++){
            System.out.print(stack.pop());//pops all the characthers and print them(in this way the are in reverse order)
            }
            }
  }
}
