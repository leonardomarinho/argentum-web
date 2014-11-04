package br.com.caelum.argentum.modelo;

import java.util.List;

// Uma série temporal é uma lista de candlesticks de um mesmo dia
public class SerieTemporal {
	
	private final List <Candlestick> candles;
	
	public SerieTemporal(List<Candlestick> candles){
		this.candles = candles;
	}
	
	public Candlestick getCandle(int i){
		return this.candles.get(i);
	}
	
	public int getUltimaPosicao(){
		return this.candles.size() - 1;
	}
}
