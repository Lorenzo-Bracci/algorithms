//Lorenzo Bracci
//2019-09-16
//The test code from the previous assignment is changed so that
// the array is sorted in descending order instead of ascending order
public class Lab3Part2{
  public static void main (String[]args){//main method for unit testing
    int nrElements = Integer.parseInt(args[0]);//reading the input as in int
  int [] array = new int [nrElements];//inizializing the array
  for (int i = 0; i < nrElements; i++){
  array[i] = Integer.parseInt(args[i + 1]);//filling the array
  }
  for (int i = 0; i < nrElements; i++){
  array[i] = -array[i];//change the sign of every number so that the array will actually be sorted in descending order
  }
insertionSort(array);//sorts the array
for (int i = 0; i < nrElements; i++){
array[i] = -array[i];//change the sign of every number so that the array will have the right sign again
System.out.println(array[i]);
}

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
