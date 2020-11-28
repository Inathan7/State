package state;


public class Arquivada extends EstadoMensagem {

	public Arquivada(Mensagem mensagem) {
		super(mensagem);
	}

	@Override
	public String enviar(String remetente, String destinatario) {
		this.setDestinatario(destinatario);
		this.setRemetente(remetente);
		EstadoMensagem proximoEstado = new AguardandoRecebimento(this.mensagem);
		mensagem.setEstadoAtual(proximoEstado);
		return "Mensagem enviada." + "\n" + data.getTime();
	}

	@Override
	public String receber() {
		EstadoMensagem proximoEstado = new Recebida(this.mensagem);
		mensagem.setEstadoAtual(proximoEstado);
		return "Mensagem recebida." + "\n" + data.getTime();
	}

	@Override
	public String arquivar(String solicitante) {
		throw new IllegalStateException("Já arquivada!");
	}

}
