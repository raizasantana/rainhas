package src;

import java.util.ArrayList;


public  abstract class Reprodutor {
	
	public static Solucao cruzamento(Solucao a, Solucao b, int pontoCorte)
	{
		Solucao filho = new Solucao(a.tamanho);
		
		for(int i = 0; i < a.tamanho; i++)
			if(i <= pontoCorte)
				filho.vetor[i] = a.vetor[i];
			else
				filho.vetor[i] = b.vetor[i];
		
		return filho;
	}
	
	public static  Solucao mutacao(Solucao a)
	{
		Solucao filho = new Solucao(a.tamanho);
		
		int geneMutante = (int) Math.round(Math.random()*(a.tamanho - 1));
		filho.vetor[geneMutante] = 2;
		
		return filho;
	}
	
	public static ArrayList<Solucao> reproducao(ArrayList<Solucao> populacao, int tamanho)
	{
		ArrayList<Solucao> novaGeracao = new ArrayList<Solucao>();
		ArrayList<Solucao> pais = new ArrayList<Solucao>();
		
		
		for(int i = 0; i < tamanho; i++)
		{		
			Solucao melhor = torneio(populacao.get(i), populacao.get(i+1));
			
			if(!pais.contains(melhor))
					pais.add(melhor);
		}
		
		for(int j = 0; j < pais.size();j++)
			if(j == 3)
				novaGeracao.add(mutacao(pais.get(j)));
			else
			{
				if((j+1) == pais.size())
					novaGeracao.add(cruzamento(pais.get(j),pais.get(pais.size()-1),(tamanho/2)));
				else
					novaGeracao.add(cruzamento(pais.get(j),pais.get(j+1),(tamanho/2)));
			}
				

		
		//populacao.sort();
		
		
		return novaGeracao;
	}
	
	public static ArrayList<Solucao> geraPopulacaoInicial(int tamanhoPopulacao, int tamanhoSolucao)
	{
		ArrayList<Solucao> populacaoInicial = new ArrayList<Solucao>();
		
		Integer posicao = 0, t = 0, limite = 0;
		limite = ((tamanhoSolucao <= 5) ? (limite = 5) : (limite = tamanhoSolucao - 1));
		
		
		
		for (int i = 0; i < tamanhoPopulacao; i++) 
		{
			//Primeiro elemento
			Solucao cromossoma = new Solucao(tamanhoSolucao);
			cromossoma.vetor[0] = geraValor(7);
						
			//Demais elementos
			while(t < (limite - 1))
			{	
				posicao = geraValor(7);
				
				if((!cromossoma.contem(posicao)))
				{
					cromossoma.vetor[t + 1] = posicao;
					t++;
				}	
				
			}
			t = 0;
			populacaoInicial.add(i,cromossoma);
			
		}
		
		return populacaoInicial;
	}
	
	public static int geraValor(int limite)
	{
		int posicao = (int) Math.round(Math.random()*limite);
		
		if(posicao >= limite)
			posicao = limite;
		
		return posicao;
	}
	
	public static Solucao torneio(Solucao a, Solucao b)
	{
		if(a.calculaAptidao() < b.calculaAptidao())
			return a;
		else
			return b;
	}
	

}
