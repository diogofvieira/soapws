package soapws.src.br.com.modelo.usuario;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name="InfoFault")
public class InfoFault extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;
	private Date date;
	
	
	
	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public InfoFault(String msg, Date date) {
		super();
		this.msg = msg;
		this.date = date;
	}



	@Override
	public String toString() {
		return "InfoFault [msg=" + msg + ", date=" + date + "]";
	}
	
	

}
