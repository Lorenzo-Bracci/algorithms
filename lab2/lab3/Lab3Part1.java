//Lorenzo Bracci
//2019-09-16
//This code implements insertion sort.
//The content of the array that is being sorted is printed after each inner loop iteration.
// A unit test in main() allows the user to define the
// size of the input (N) and then input (N) integers from stdin which is to be sorted.
public class Lab3Part1{
  public static void main (String[]args){//main method for unit testing
    int nrElements = Integer.parseInt(args[0]);//reading the input as in int
  int [] array = new int [nrElements];//inizializing the array
  for (int i = 0; i < nrElements; i++){
  array[i] = Integer.parseInt(args[i + 1]);//filling the array
  }
    insertionSort(array);

  }
 public static void insertionSort(int [] array){
   for (int i = 0; i < array.length;i++){//loops through the array from left to right
     for (int j = i; j > 0;j--){//copy the current array pointer and start to move backwards from there
       if(array[j] < array[j-1]){//check if the current value is misplaced in relation to teh previous one
         int copy = array[j];//the next 3 lines of code are to swap
         array[j] = array[j-1];
         array[j-1] = copy;
      } else{break;}//if the position is correct than we break the loop
     }
     for (int counter = 0; counter < array.length;counter++) {//prints the array
       System.out.println(array[counter]);
     }
   }
 }
}


//{}
