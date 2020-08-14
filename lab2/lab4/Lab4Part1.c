//Lorenzo Bracci
//2019-09-23
//This program implements a simple filter to clean a text, i.e. to remove all characters that are not alphabetic, blank or newline
//replacing every such character by a blank to keep the number of characters constant to the original text.
#include <stdio.h>
#include <ctype.h>//imports is alpha
int main()
{
  char c;
   while ((c = getchar()) != EOF){//checking if we are done reading(needed to press control z)
     if(isalpha(c)){
      putchar(c);
     }else{
     putchar(' ');
    }
   }
   return 0;
}
