//Lorenzo Bracci
//2019-09-16
//This code takes the previous assignment and a method which counts the number
//of inversions in the input array and prints a list of all inversions.


public class Lab3Part4{
  public static void main (String[]args){//main method for unit testing
    int nrElements = Integer.parseInt(args[0]);//reading the input as in int
  int [] array = new int [nrElements];//inizializing the array
  for (int i = 0; i < nrElements; i++){
  array[i] = Integer.parseInt(args[i + 1]);//filling the array
  }
  System.out.println("The number of inversions is:" + countInversions(array));//prints the number of inversions
    insertionSort(array);
  }
  public static int countInversions(int [] array){//returns the number of inversions in the array
    int inversions = 0;
    for (int i = 0; i < array.length;i++){//iterates through the loop
      for (int j = i+1; j < array.length;j++){//checks which elements after the current i are in the wrong position in respect to the ith element
        if(array[i] > array[j]){
          inversions++;//increments the counter for the number of inversions
System.out.println("[" + i + "," + array[i] + "] , [" + j + "," + array[j] + "]" );//prints the inversion in the requested format
      }
        }
    }
    return inversions;
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
