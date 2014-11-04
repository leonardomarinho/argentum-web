package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

//Implementa design pattern "Decorator" (uma Strategy dentro de outra Strategy)
public class MediaMovelPonderada implements Indicador{
	
	private Indicador outroIndicador;
	
	public MediaMovelPonderada(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador; 
	}

	// Soma o valor de fechamento ou abertura dos últimos 3 dias, mas atribui um peso para o valor mais
	// recente e vai diminuindo esse peso para os valores mais antigos. Depois divide tudo por seis (3 * 2 * 1)
	// Ex.: Se estou determinando média móvel simples para o dia 06
	// Deve somar valores do dia (06 * 3), (05 * 2), (04 * 1)
	public double calcula(int posicao, SerieTemporal serie){
		double soma = 0.0;
		int peso = 3;
		
		for(int i = posicao; i > posicao - 3; i--){
			soma += outroIndicador.calcula(i, serie) * peso;
			peso --;
		}
		return soma / 6;
	}

	
	@Override
	public String toString(){
		return "MMP de " + outroIndicador.toString();
	}
}
