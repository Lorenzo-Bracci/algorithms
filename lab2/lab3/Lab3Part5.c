//Lorenzo Bracci
//2019-09-16
//The code implements a function in C which takes an array of integers (both positive and negative)
//and orders the elements in the array so that all negative elements come before the positive and the 0s is there is any
//are in the middle.
//assignment 6: the loop invariant for the sorting method is that after every loop iteration every a[0....lt-1] is smaller then middle,
//every a[gt+1.....length-1] is grater than middle while everything between lt and i-1 is the same as middle, all the other elements
//from i to gt have yet to be examined. At the end of the loop everything between lt and gt will be equal to middle while evreything on
//on the left will be smaller and everything on the right will be greater.
}
#include <stdio.h>
#include <stdlib.h>
int absoluteValue (int a){
  if (a >= 0) {
    return a;
  }else{
    return -a;
  }
}
void sort (int *array, int length){
  int middle = array[0];
  int positionMiddle = 0;
for (int i = 1;i < length; i++){
  if(absoluteValue(array[i]) < middle){//search for the middle value used as a pivot
    middle = array[i];
    positionMiddle = i;
if(middle == 0)//if 0 is found then we can break the loop because that s the partition element
    break;
  }
}
//implements swap for first position
array[positionMiddle] = array[0];
array[0] = middle;//middle partitions the array
//implements three-way quicksort
int lt = 0;//pointer to the beginning of the array that represents the limit for all the numbers smaller than middle
int i = 1;//pointer that points to the value that we currently analyze
int copy;// used to switch values
int gt = length-1;//pointer to the end of the array that represents where the numbers greater than gt are positioned
while(i <= gt){//checks if i and gt crossed each other
  if(array[i] < middle){//if the number should be on the left of the middle move the number to the left by switching
    copy = array[lt];
    array[lt++] = array[i];//increments the upper boundry of the lower values
    array[i++] = copy;//increments the i pointer
  }else if(array[i] > middle){//if the number should be on the right of the middle move the number to the right(gt position) by switching
    copy = array[i];
    array[i] = array[gt];
    array[gt--] = copy;//decrements the lower boundary to the greater values
  }else {//if the number is equal to the middle increment the i pointer
    i++;
  }
}

}
int main (){//unit test
  int *array;
  int size;
  scanf("%d", &size);//reads the size of the array
  array = (int*)malloc(size * sizeof(int));//allocaates memory on the heap
  for(int i = 0; i < size;i++){
    scanf("%d", &array[i]);//reads the values in the array
  }
  sort(array, size);//sorts the array
  for(int i = 0; i < size;i++){
    printf("%d\n", array[i]);//prints the sorted array
  }
  return 0;
}
