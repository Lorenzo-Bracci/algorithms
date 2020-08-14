// Lorenzo Bracci
//2019-09-21
//This program experiments with the cut-off to insertionsort in quicksort.
import java.util.Random;
public class Lab3Part9{
  public static void main (String[]args){
   Random rand = new Random();
    int size = Integer.parseInt(args[0]);//reads an input and sets it as the size of the array that needs to be sorted
    int cutoff =  Integer.parseInt(args[1]);//reads the cutoff value from the input 
    int [] array = new int [size];
    for (int i = 0; i < size; i++)//creates an array with values from 0 to 1 milion
    array[i] = rand.nextInt(1000000);
    long time1 = System.currentTimeMillis();//get the number of milliseconds since 1 Jan 1970 00:00
quickSort(array, cutoff);
long time2 = System.currentTimeMillis();
long time = (time2 - time1)/10;//divides by 10 to after divide by 100 to get 2 decimals
double copy = (double)time;
double finalTime = (copy/100);
System.out.println("The time for the sorting was " + finalTime + " seconds");
  }
  public static void quickSort(int[] a, int cutoff)
  {
  quickSort(a, 0, a.length - 1, cutoff);
  }
  public static void quickSort(int[] a, int lo, int hi, int cutoff)
  {
  if (hi <= (lo + cutoff)){ //checks if the subarrays length is smaller or equal to the cutoff value
insertionSort(a, lo, hi);//performs insertion sort on the small sub-array
    return;
  }
  int j = partition(a, lo, hi); // Partition
  quickSort(a, lo, j-1, cutoff); // Sort left part a[lo .. j-1].
  quickSort(a, j+1, hi, cutoff); // Sort right part a[j+1 .. hi].
  }
  public static int partition(int[] a, int lo, int hi)
  { // Partition into a[lo..i-1], a[i], a[i+1..hi].
  int i = lo, j = hi+1; // left and right scan indices
  int v = a[lo]; // partitioning item
  while (true)
  { // Scan right, scan left, check for scan complete, and exchange.
  while (a[++i] < v){  if (i == hi) break;}//checks for elements to swap from left
  while (v < a[--j]){  if (j == lo) break;}//checks for elements to swap from right
  if (i >= j) break;//if they crossed we are done
  exch(a, i, j);
  }
  exch(a, lo, j); // Put v = a[j] into position
  return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
  }
  public static void exch(int[] array, int pos1, int pos2){//method to swap elements in position pos1 and pos2
    int copy = array[pos1];
    array[pos1] = array[pos2];
    array[pos2] = copy;
  }
  public static void insertionSort(int[] array, int lo, int hi){//method to swap elements in position pos1 and pos2
    for (int i = lo; i <= hi;i++){//loops through the subarray from left to right
      for (int j = i; j > 0;j--){//copy the current array pointer and start to move backwards from there
        if(array[j] < array[j-1]){//check if the current value is misplaced in relation to teh previous one
          int copy = array[j];//the next 3 lines of code are to swap
          array[j] = array[j-1];
          array[j-1] = copy;
       } else{break;}//if the position is correct than we break the loop
      }
    }
  }
    }
