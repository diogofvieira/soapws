package soapws.src.br.com.modelo.ws;

import javax.xml.ws.Endpoint;

public class PublicaWS {
	
	public static void main(String[] args) {
		
		EstoqueWS wsImpl = new EstoqueWS();
		String url = "http://localhost:8080/estoquews";
		
		System.out.println("estoque ws rodando "+ url);
		
		//associando URL com implementacao
		Endpoint.publish(url, wsImpl);
		
	}

}
