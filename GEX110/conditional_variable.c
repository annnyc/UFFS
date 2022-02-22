// SISTEMAS OPERACIONAIS - 2021 / 2 - UFFS
// Academica: Any Cruz Silva
// Please use gcc -o condition_variable condition_variable.c -lpthread ./condition_variable to execute

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

pthread_mutex_t count_mutex     = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t  condition_var   = PTHREAD_COND_INITIALIZER;

void *functionCount1();
void *functionCount2();
void *functionCount3();
int  count = 0;
#define COUNT_DONE  10
// #define COUNT_HALT1  3
// #define COUNT_HALT2  6

void main()
{
   pthread_t thread1, thread2, thread3;

   pthread_create( &thread1, NULL, &functionCount1, NULL);
   pthread_create( &thread2, NULL, &functionCount2, NULL);
   pthread_create( &thread3, NULL, &functionCount1, NULL);

   pthread_join( thread1, NULL);
   pthread_join( thread2, NULL);
   pthread_join( thread1, NULL);

   printf("Final count: %d\n",count);

   exit(EXIT_SUCCESS);
}

// Write numbers 1-3 and 8-10 as permitted by functionCount2()

void *functionCount1()
{
   int sleepseed = (rand()%2+1);
   for(;;)
   {
      // Lock mutex and then wait for signal to relase mutex
      pthread_mutex_lock( &count_mutex );
      if (count == COUNT_DONE) {
            pthread_mutex_unlock(&count_mutex);
            pthread_cond_signal(&condition_var);
            break;
        }

      if (count % 3 != 0) {
            pthread_mutex_unlock(&count_mutex);
            pthread_cond_signal(&condition_var);
        
        } else {
           count++;
            printf("thread 0: global:" "%d\n", count);
            sleep(sleepseed);
            pthread_mutex_unlock(&count_mutex);
        }

      // Wait while functionCount2() operates on count
      // mutex unlocked if condition varialbe in functionCount2() signaled.

   }
}

// Write numbers 4-7

void *functionCount2()
{
   int sleepseed = (rand()%2+1);
   unsigned long i;
    for(;;)
    {
        pthread_mutex_unlock(&count_mutex);
        pthread_cond_wait(&condition_var, &count_mutex);

        if (count == COUNT_DONE) {
            pthread_mutex_unlock(&count_mutex);
            break;
        }

         if(count% 3 != 1 ) {
            pthread_mutex_unlock(&count_mutex);

        } else {
            count++;
            printf("thread 1: global:""%d\n", count);
            sleep(sleepseed);
            pthread_mutex_unlock(&count_mutex);
        }
        pthread_mutex_lock( &count_mutex );

       
    }

}

void *functionCount3()
{
   int sleepseed = (rand()%2+1);
   unsigned long i;
    for(;;)
    {
        pthread_mutex_unlock(&count_mutex);
        pthread_cond_wait(&condition_var, &count_mutex);

        if (count == COUNT_DONE) {
            pthread_mutex_unlock(&count_mutex );
            break;
        }

        if( count% 3 != 2  ) {
            pthread_mutex_unlock(&count_mutex);

        } else {
            count++;
            printf("thread 2: global:""%d\n", count);
            sleep(sleepseed);
            pthread_mutex_unlock(&count_mutex);
        }
        pthread_mutex_lock(&count_mutex);

       
    }

}
