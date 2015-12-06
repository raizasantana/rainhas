package src;

import java.util.ArrayList;

public class Solucao implements Comparable<Solucao>{
	
	public int colisoes;
	public int[] vetor ;
	public int tamanho;

	public Solucao(int t)
	{
		this.tamanho = t;
		this.vetor = new int[t];
		this.colisoes = 0;
	}


	@Override
	public int compareTo(Solucao s) {
		if(this.colisoes > s.colisoes)
			return 1;
		
		return 0;
	}
	
	public int calculaAptidao()
	{
		//Diagonais pra baixo
		for(int i = 0; i < this.tamanho; i++){
			for(int j =  1; j < this.tamanho; j++){
				if((i+1 == j) && (((vetor[i] + 1) == vetor[j]) || ((vetor[i] - 1) == vetor[j])))
					this.colisoes++;
				}
		}
		return this.colisoes;
	}
	
	public boolean contem(int i)
	{
		for(int k = 0; k < this.tamanho; k++)
			if(this.vetor[k] == i)
				return true;
	
		return false;
	}
	
	
	
}
