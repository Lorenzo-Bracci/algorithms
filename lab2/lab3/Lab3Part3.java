//Lorenzo Bracci
//2019-09-16
//The code augument the implementation of the previous assignment
// so that it prints the number of swaps performed when sorting the array.
public class Lab3Part3{
  public static void main (String[]args){//main method for unit testing
    int nrElements = Integer.parseInt(args[0]);//reading the input as in int
  int [] array = new int [nrElements];//inizializing the array
  for (int i = 0; i < nrElements; i++){
  array[i] = Integer.parseInt(args[i + 1]);//filling the array
  }
    insertionSort(array);
    for (int counter = 0; counter < array.length;counter++) {//prints the sorted array
      System.out.println(array[counter]);
    }
  }
 public static void insertionSort(int [] array){
   int counter = 0;//counter used to count the number of swaps
   for (int i = 0; i < array.length;i++){//loops through the array from left to right
     for (int j = i; j > 0;j--){//copy the current array pointer and start to move backwards from there
       if(array[j] < array[j-1]){//check if the current value is misplaced in relation to teh previous one
         int copy = array[j];//the next 3 lines of code are to swap
         array[j] = array[j-1];
         array[j-1] = copy;
         counter++;//increments the variable that counts the number of swaps every time that we swap
      } else{break;}//if the position is correct than we break the loop
     }
   }
   System.out.println("The number of swaps executes is: "  + counter);
 }
}
