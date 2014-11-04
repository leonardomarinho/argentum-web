package br.com.caelum.argentum.reader;

import java.io.InputStream;
import java.util.List;

import br.com.caelum.argentum.modelo.Negociacao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

// Lê um XML e gera uma lista de negociações baseado no seu conteúdo
public class LeitorXML {
	
	public List<Negociacao> carrega(InputStream inputStream) {
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		return (List<Negociacao>) stream.fromXML(inputStream);
		}

}
