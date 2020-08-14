//Lorenzo Bracci
//2019-09-09
//The code implements a filter which can determine if parentheses are properly balanced
import java.util.Scanner;
public class Lab2Part7{
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
    Lab2Part7 stack = new Lab2Part7();
    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();
    while (scanner.hasNextLine())
    text = text + scanner.nextLine();//reads from input
    boolean notBalanced = false;
    boolean startWithRight = false;
      for (int i = 0;i < text.length();i++){//loops through all the caracthers in the strings
        char currentChar = text.charAt(i);
        if((currentChar == '}' || currentChar == ']' || currentChar == ')') && stack.isEmpty() ){//base case
        System.out.print("The brackets are not balanced");
        startWithRight = true;//used later to make sure that nothing is printed multiple times
      }else  if (currentChar == '{' || currentChar == '[' || currentChar == '(' ){//checks if we have left parenthesis
        stack.push(currentChar);//pushes the right parenthesis on the stack
    }  else  if (currentChar == '}' || currentChar == ']' || currentChar == ')' ){//checks if we have a right parenthesis
          char c = stack.pop();//saves the parenthesis popped
          if(!((currentChar == '}' && c == '{') || (currentChar == ']' && c == '[') || (currentChar == ')' && c == '('))){//checks if the parentheses match
          System.out.print("The brackets are not balanced");
          notBalanced = true;
          break;
              }
        }
        }
        if((stack.isEmpty()) && (!notBalanced)){
          if(!startWithRight){
            System.out.print("The brackets are balanced");
            }
      }else{
        if(!notBalanced)
          System.out.print("The brackets are not balanced");
    }
  }
}
