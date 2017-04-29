#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    int t;
    scanf("%d", &t);
    for(int i = 0; i < t; i++)
    {
        unsigned long n;
        scanf("%lu", &n);
        int numzeros = 0;
        int numones = 0;
        while(n % 2 == 0)
        {
            n = n >> 1;
            numzeros++;
        }
        
        while(n > 0)
        {
            if(n&1)
            {
                numones++;
            }
            n = n >> 1;
        }
        
        if((numzeros + numones) % 2 == 1)
        {
            printf("Richard\n");
        }
        else
        {
            printf("Louise\n");
        }
        
    }
    
    return 0;
}
