// Lorenzo Bracci
//2019-09-04
//reads characters from stdin until a newline
//character is read and then prints them on stdout in reverse order both with a recursive
//function and with an iterative function

#include <stdio.h>
#include <stdlib.h>
void recursion(){
  char string;
  if ((string = getchar()) != '\n')//check if you are done reading the  string
  recursion();//recursive call
  putchar(string);//output the carachter store
}

void iteration(){
  char *string;
  string =(char*) malloc (15);//allocates memory to store the string
  char *stringCopy = string;//pointerv vthat keeps track of where we start to store data
  while ((*string = getchar()) != '\n'){//reads the string assuming that it has a fixed size of 10
    string++;
  }
  while (string != stringCopy){
  putchar(*(string - 1));//outputs the string backwards
  string--;
  }
  free(string);//free memory
}
int main (){
//iteration();
  recursion();//tests the recursion method
  return 0;
}
