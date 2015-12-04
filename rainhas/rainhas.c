#include <stdio.h>
#include <stdlib.h>
#define N 8

int existe_colisao(int iA, int jA, int iB, int jB) //Detecta colisão nas linhas, colunas, diagonais principais e secundárias
{
    if((iA == iB) || (jA == jB) || ((iA == jA) && (iB == jB)) || ((iA + 1) == N - (jB + 1) + 1))
        return 1;
    return 0;

}

int fo(int *rainhas, int tam) //Para cada rainha verifica se há colisão com todas as outras rainhas
{
    int i, count = 0, j;
    for(i = 0; i < N; i++)
    {
        for(j = i + 1; j<N;j++)
            count += existe_colisao(i,rainhas[i],j,rainhas[j]);
    }

    return count;
}


void trocaPosicoes(int *vet, int p1, int p2)
{
    int temp;
    temp = vet[p1];
    vet[p1] = vet[p2];
    vet[p2] = temp;
}

void  permuta(int *vet, int k)
{

    int i, l;
    if(k == N){
       // return vet;
       printf("(%d, %d, %d, %d, %d, %d, %d, %d)\n", vet[0],vet[1],vet[2],vet[3],vet[4],vet[5],vet[6],vet[7]);
    } else
    {
        for(i = k; i < N; i++)
        {
            trocaPosicoes(vet, k, i);
            permuta(vet, k+1);
            trocaPosicoes(vet, i, k);
        }
    }



}

void gera_vetor_original(int *vet)
{
    int k;

    for(k =0; k<N;k++)
        vet[k] = k;
}

int main()
{
    int vo[N], p;

    gera_vetor_original(vo);

    permuta(vo,0);


}
