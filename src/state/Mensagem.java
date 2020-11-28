package state;

import java.util.ArrayList;

/*
 * TODO STATE.01
 * 
 * 1. Crie um objeto com uma classe chamada Mensagem. Entenda que esta classe
 * possui operacoes que variam de acordo com o estado em que a mensagem se encontra.
 * 2. Logo que enviar(destinatario), o objeto deve se encontrar no estado "Aguardando recebimento",
 * devendo guardar a data do envio. Nao deve mais ser possivel enviar() estando nesse estado,
 * mas se pode receber() a mensagem, devendo se guardar a data do recebimento. 
 * 3. Logo que receber(), o objeto mensagem deve ser encontrar no estado "Recebida", em que 
 * deve ser possivel enviar(destinatario) desde que o proximo destinatario nao ja tenha recebido a mensagem anteriormente.
 * 
 * Somente estando tambem deve ser possivel arquivar(solicitante), ficando a mensagem no estado "Arquivada", 
 * mas somente o remetente original (do primeiro envio) pode fazer isso, em que deve ser armazenada a data do 
 * arquivamento e um texto com o motivo.
 * 
 */
public class Mensagem {

	private String mensagem;
	
	private ArrayList<EstadoMensagem> estados = new ArrayList<EstadoMensagem>();  //-> Inathan
	
	public Mensagem(String mensagem) {
		this.mensagem = mensagem;
		this.estados.add(new Criado(this));
	}

	public String getMensagem() {
		return mensagem;
	}
	
	//nao deve ser chamado por clientes.
	private void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	//-> Inathan
	
	public EstadoMensagem getEstadoAtual() {
		return this.estados.get(estados.size()-1);
	}
	
	public void setEstadoAtual(EstadoMensagem novoEstado) {
		this.estados.add(novoEstado);
	}
	
	public String enviar(String remetente, String destinatario) {
		return getEstadoAtual().enviar(remetente, destinatario);
	}
	
	public String receber() {
		return getEstadoAtual().receber();
	}
	
	public String arquivar(String solicitante) {
		return getEstadoAtual().arquivar(solicitante);
	}

	public ArrayList<EstadoMensagem> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<EstadoMensagem> estados) {
		this.estados = estados;
	}
	
}
