// SISTEMAS OPERACIONAIS - 2021 / 2 - UFFS
// Academica: Any Cruz Silva

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <fcntl.h>
#include <semaphore.h>
#include <math.h>
#include <unistd.h>


#define N 5
#define LEFT(philosopher_index) (philosopher_index + N - 1) % N
#define RIGHT(philosopher_index) (philosopher_index + 1) % N
#define THINKING 0
#define HUNGRY 1
#define EATING 2

void *philosopher(void* index);
void take_forks(int i);
void put_forks(int i);
void verify(int i);
void think();
void eat();
void sempahore_init();

int state[N];
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
sem_t s[N];
pthread_t philosophers[N];

int main(void) {
	sempahore_init();
    printf("Welcome to the dining philosophers problem (solved)!\n");
    printf("Press Ctrl + C to exit.\n\n");
	
	for(int i = 0; i < N; i++) {
		int *index = malloc(sizeof(int));
		*index = i;

		pthread_create(&philosophers[i], NULL, philosopher, (void *) index);
	}

	for(int i = 0; i < N; i++) {
		pthread_join(philosophers[i], NULL);
	}
    return 1;
}

void *philosopher(void* index) {
	int i = *((int*) index), op = 0;
	while(op == 0) {
		think(i);
		take_forks(i);
		eat(i);
		put_forks(i);
	}
}

void take_forks(int i) {
	pthread_mutex_lock(&mutex);
	state[i] = HUNGRY;
	printf("philosopher %d is hungry\n", i);
	verify(i);
	pthread_mutex_unlock(&mutex);
	sem_wait(&s[i]);
}

void put_forks(int i) {
	pthread_mutex_lock(&mutex);
	state[i] = THINKING;
	verify(LEFT(i));
	verify(RIGHT(i));
	pthread_mutex_unlock(&mutex);
}

void verify(int i) {
	if(state[i] == HUNGRY && state[LEFT(i)] != EATING && state[RIGHT(i)] != EATING) {
		state[i] = EATING;
		sem_post(&s[i]);
	}
}


void think(int i) {
	printf("philosopher %d is thinking\n", i);
	sleep(10);
}


void eat(int i) {
	printf("philosopher %d is eating\n", i);
	sleep(10);
}


void sempahore_init() {
	for(int i = 0; i < N; i++) {
		sem_init(&s[i], 0, 0);
		state[i] = THINKING;
	}
}
