package src;

import java.util.ArrayList;

public class AlgoritmoGenetico {

	public static void main(String[] args) {

		ArrayList<Solucao> populacaoInicial = Reprodutor.geraPopulacaoInicial(5,8);
		
		int min = 100, nGeracoes = 0;
		//Avaliando quantas colisoes existem em cada solucao
		
		for (Solucao solucao : populacaoInicial) {
			
			solucao.calculaAptidao();
			
			//Pegando o menor valor de colisões
			if(solucao.colisoes < min)
				min = solucao.colisoes;
		}
		
		System.out.println(min);
		
		while (min > 0)//Número de colisões maior que zero
		{
			System.out.println("Entrou aqui");
			ArrayList<Solucao> novaGeracao = Reprodutor.reproducao(populacaoInicial, 20);
			nGeracoes++;
			for (Solucao solucao : novaGeracao) {
				System.out.println("avaliando");
				solucao.calculaAptidao();
				
				//Pegando o menor valor de colisões
				if(solucao.colisoes < min)
					min = solucao.colisoes;
			}
			
		System.out.println(">>>"+min);
		}
		
		System.out.println(nGeracoes);
			
	

}
	public static int avaliaPopulacao(ArrayList<Solucao> pop)
	{
		int min = 100;
		for (Solucao solucao : pop) {
			System.out.println("avaliando");
			solucao.calculaAptidao();
			
			//Pegando o menor valor de colisões
			if(solucao.colisoes < min)
				min = solucao.colisoes;
		}
		
		return min;
	}
}
