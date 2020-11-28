package state;

import java.util.Date;

/*
 * TODO STATE.02 
 * 
 * 1. Indique que operacoes abstratas essa classe deve conter.
 * 2. Indique eventuais atributos ou composicoes convenientes a todos os subtipos de estados.
 * 3. Crie os subtipos, de acordo com estados referenciados em TODO.STATE.01.
 */
public abstract class EstadoMensagem {

	//-> Inathan

	protected Mensagem mensagem;
	protected Date data;
	private String destinatario;
	private String remetente;

	public EstadoMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
		this.data = new Date();
	}

	public abstract String enviar(String remetente, String destinatario);
		
	public abstract String receber();

	public abstract String arquivar(String solicitante);

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

}
