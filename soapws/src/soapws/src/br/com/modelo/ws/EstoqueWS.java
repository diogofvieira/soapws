package soapws.src.br.com.modelo.ws;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import soapws.src.br.com.modelo.item.Filtro;
import soapws.src.br.com.modelo.item.Filtros;
import soapws.src.br.com.modelo.item.Item;
import soapws.src.br.com.modelo.item.ItemDao;
import soapws.src.br.com.modelo.item.ItemValidador;
import soapws.src.br.com.modelo.item.ListaItens;
import soapws.src.br.com.modelo.usuario.AutorizacaoException;
import soapws.src.br.com.modelo.usuario.TokenDao;
import soapws.src.br.com.modelo.usuario.TokenUsuario;


/*Gerar o wsdl em linha de comando a partir da pasta do projeto wsgen -wsdl -inlineSchemas -cp bin {package}.EstoqueWS*/


@WebService
public class EstoqueWS {
	
	private ItemDao dao = new ItemDao();
	
	//@WebMethod(operationName="listaTodosItens")
	//@WebResult(name="item")
	//public List<Item> getLista(){
	//	System.out.println("chamando getItens()");
	//	return dao.todosItens();
		
	//}
	
	@WebMethod(operationName="ListaTodosItens")
	@WebResult(name="itens")
	public ListaItens getLista(@WebParam(name="filtro") Filtros filtros){
		
		System.out.println("chamando getItens()");
		
		List<Filtro> listaFiltro = filtros.getLista();
		List<Item> lista = dao.todosItens(listaFiltro);
		
		//return new ListaItens(dao.todosItens()); 
		return new ListaItens(lista); 
	}
	
	/*@WebMethod(operationName="CadastrarItem")
	@WebResult(name="item")
	public void cadastrarItem(@WebParam(name="item") Item item) {
	System.out.println("Cadastrando " + item);
	this.dao.cadastrar(item);
	}*/
	
	@WebMethod(operationName="CadastrarItem") 
	@WebResult(name="item")
	public Item cadastrarItem(@WebParam(name="tokenUsuario", header=true) TokenUsuario token, 
			@WebParam(name="item") Item item) throws AutorizacaoException {

	    System.out.println("Cadastrando " + item + ", " + token);

	    boolean valido = new TokenDao().ehValido(token); 
	    if(!valido) {
	    	  throw new AutorizacaoException("Usuario Invalido");
	    }
	    
	    new ItemValidador(item).validate();
	    
	    this.dao.cadastrar(item);
	    return item;
	}


	
}
