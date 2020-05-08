#include<stdlib.h>
#include<stdio.h>
#include<pthread.h>
#include <sys/types.h>
#include <unistd.h>

void * Eliminacja(void * arg);
struct struktura_t { int *a; int indexTablica;};

int main(){

    int tab[101];
    pthread_t tid[16];
    int iteratorTID=0;
    for(int i=0;i<101;i++)tab[i]=i;
    for(int i=0;i<101;i++)printf("%d ",tab[i]);
    printf("\n");
    for(int i=0;i<101;i++)
    {
        struct struktura_t struktura_main={tab,i};
        pthread_create(&tid[iteratorTID],NULL,Eliminacja,&struktura_main);
        usleep(10);
        iteratorTID++;
        if(iteratorTID==15)
        {
            iteratorTID=0;
            for(int i=0;i<16;i++)pthread_join(tid[i], NULL);
        }
    }
    printf("\n");
    for(int i=0;i<101;i++)if(tab[i]!=0)printf("%d ",tab[i]);
    printf("\n");
    return 0;
}

void * Eliminacja(void * arg){

struct struktura_t struktura_watek=*( (struct struktura_t *) arg );
int *TablicaWynikowa =struktura_watek.a;
int indexTablica =struktura_watek.indexTablica;
if(TablicaWynikowa[indexTablica]!=0 && TablicaWynikowa[indexTablica]!=1)
        {
            for(int i2=indexTablica+1;i2<101;i2++)
            {
            int temp = TablicaWynikowa[i2]%TablicaWynikowa[indexTablica];
            if(temp==0)TablicaWynikowa[i2]=0;
            }
        }
}