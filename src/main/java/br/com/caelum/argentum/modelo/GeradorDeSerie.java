package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.SerieTemporal;

// Gerador de Séries para ser usado nos testes
// cria Candlesticks com os mesmos valores de abertura, fechamento, preço e quantidade

public class GeradorDeSerie {
	
	public static SerieTemporal criaSerie(double... valores){
		List<Candlestick> candles = new ArrayList<Candlestick>();
		
		for(double d: valores){
			candles.add(new Candlestick(d, d, d, d, 1000, Calendar.getInstance()));
		}
		
		return new SerieTemporal(candles);
	}

}
