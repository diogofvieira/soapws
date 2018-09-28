package soapws.src.br.com.modelo.usuario;


import javax.xml.ws.WebFault;

@WebFault(name="AutorizacaoFault")
public class AutorizacaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String mensagem) {
		super(mensagem);
	}
	
	//public InfoFault getFaultInfo() {
	//    return new InfoFault("Token invalido", new Date());
	//}

	public String getFaultInfo(){
		return "Token Invalido";
	}

}
