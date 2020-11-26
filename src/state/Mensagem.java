package state;

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
 * Somente estando tambem deve ser possivel arquivar(solicitante), ficando a mensagem no estado "Arquivada", mas somente o remetente original (do primeiro envio)
 * pode fazer isso, em que deve ser armazenada a data do arquivamento e um texto com o motivo.
 * 
 */
public class Mensagem {

	private String mensagem;
	
	public Mensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	//nao deve ser chamado por clientes.
	private void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
