package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;


// Implementa design pattern "Decorator" (uma Strategy dentro de outra Strategy)
public class MediaMovelSimples implements Indicador {
	private Indicador outroIndicador;

	public MediaMovelSimples(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
		
	}
	
	// Soma o valor de fechamento ou abertura do dia atual e 
	// dos 2 dias anteriores e divide pela quantidade de dias considerada (3)
	// Ex.: Se estou determinando média móvel simples para o dia 06
	// Deve somar valores do dia 06, 05, 04
	@Override
	public double calcula(int posicao, SerieTemporal serie){
		double soma = 0.0;
		for (int i = posicao; i > posicao - 3; i--){
			soma += outroIndicador.calcula(i, serie);
		}
		
		return soma/3;
	}
	
	@Override
	public String toString() {
		return "MMS de " + outroIndicador.toString();
	}
}
