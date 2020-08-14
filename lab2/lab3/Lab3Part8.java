// Lorenzo Bracci
//2019-09-21
//This program compares the execution times for sorting large arrays of integers
//with mergesort and quicksort.
import java.util.Random;
public class Lab3Part8{
  public static void main (String[]args){
    Random rand = new Random();
    int size = Integer.parseInt(args[0]);//reads an input and sets it as the size of the array that needs to be sorted
    int [] array = new int [size];
    for (int i = 0; i < size; i++)//creates an array with values from 0 to 1 milion
    array[i] = rand.nextInt(1000000);
    long time1 = System.currentTimeMillis();//get the number of milliseconds since 1 Jan 1970 00:00
mergeSort(array);
long time2 = System.currentTimeMillis();
long time = (time2 - time1)/10;//divides by 10 to after divide by 100 to get 2 decimals
double copy = (double)time;
double finalTime = (copy/100);
System.out.println("The time for the sorting was " + finalTime + " seconds");
  }
  public static void mergeSort(int[] a)
{
  int [] aux = new int[a.length];
mergeSort(a, 0, a.length - 1,aux);
}
private static void mergeSort(int[] a, int lo, int hi,int [] aux)
{ // Sort a[lo..hi].
if (hi <= lo) return;
int mid = lo + (hi - lo)/2;
mergeSort(a, lo, mid, aux); // Sort left half.
mergeSort(a, mid+1, hi, aux); // Sort right half.
merge(a, lo, mid, hi, aux); // Merge results (code on page 271).
}
public static void merge(int[] a, int lo, int mid, int hi,int [] aux)
{ // Merge a[lo..mid] with a[mid+1..hi].
int i = lo, j = mid+1;
for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
aux[k] = a[k];
for (int k = lo; k <= hi; k++){ // Merge back to a[lo..hi].
if (i > mid) a[k] = aux[j++];//if we pass the half takes elements from the second half
else if (j > hi ) a[k] = aux[i++];//if we pfinished the second half takes elements from the first half
else if (aux[j] < aux[i]) a[k] = aux[j++];//checks if the elemts from the pointer on the left or the one with the pointer to the right is smaller
else a[k] = aux[i++];
}
}
public static void quickSort(int[] a)
{
quickSort(a, 0, a.length - 1);
}
public static void quickSort(int[] a, int lo, int hi)
{
if (hi <= lo) return;
int j = partition(a, lo, hi); // Partition
quickSort(a, lo, j-1); // Sort left part a[lo .. j-1].
quickSort(a, j+1, hi); // Sort right part a[j+1 .. hi].
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
  }
