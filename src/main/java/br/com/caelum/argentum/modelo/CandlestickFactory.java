package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// Design Pattern "Factory" para construir objetos complexos.
public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negocios) {

		double maximo = Double.MIN_VALUE;
		double minimo = Double.MAX_VALUE;
		double volume = 0;

		for (Negociacao negocio : negocios) {
			volume += negocio.getVolume();

			// descobre maior e menor preço do dia
			double preco = negocio.getPreco();
			
			if (preco > maximo) {
				maximo = preco;
			} 
			if (preco < minimo) {
				minimo = preco;
			}
		}
		
		// valor de abertura é sempre o da primeira negociação e o de fechamento é sempre o da última
		double abertura = negocios.isEmpty() ? 0 : negocios.get(0).getPreco();
		double fechamento = negocios.isEmpty() ? 0 : negocios.get(negocios.size() - 1).getPreco();

		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}

	public List<Candlestick> constroiCandles(List<Negociacao> todasNegociacoes) {
		List<Candlestick> candles = new ArrayList<Candlestick>();
		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		Calendar dataAtual = todasNegociacoes.get(0).getData();

		for (Negociacao negociacao : todasNegociacoes) {
			
			// se não for mesmo dia, fecha candle e reinicia variáveis
			if (!negociacao.isMesmoDia(dataAtual)) {
				criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
				negociacoesDoDia = new ArrayList<Negociacao>();
				dataAtual = negociacao.getData();
			}
			
			negociacoesDoDia.add(negociacao);
		}
		
		criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);

		return candles;
	}

	private void criaEGuardaCandle(List<Candlestick> candles, List<Negociacao> negociacoesDoDia, Calendar dataAtual) {
		Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
		candles.add(candleDoDia);
	}
}
