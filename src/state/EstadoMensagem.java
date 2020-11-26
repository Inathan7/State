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

	public EstadoMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
		this.data = new Date();
	}

	public abstract void enviar(String destinatario);
		
	public abstract void receber();

	public abstract void arquivar(String solicitante);

}
