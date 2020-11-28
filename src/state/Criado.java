package state;

// -> Inathan

public class Criado extends EstadoMensagem {

	public Criado(Mensagem mensagem) {
		super(mensagem);
	}

	@Override
	public String enviar(String remetente, String destinatario) {
		this.setDestinatario(destinatario);
		this.setRemetente(remetente);
		EstadoMensagem proximoEstado = new AguardandoRecebimento(this.mensagem);
		mensagem.setEstadoAtual(proximoEstado);
		return "Mensagem enviada para  " + this.getDestinatario() + "\n" + data.getTime();
	}

	@Override
	public String receber() {
		EstadoMensagem proximoEstado = new AguardandoRecebimento(this.mensagem);
		mensagem.setEstadoAtual(proximoEstado);
		return "Mensagem enviada para  " + this.getDestinatario() + "\n" + data.getTime();
	}

	@Override
	public String arquivar(String solicitante) {
		throw new IllegalStateException("Impossível arquivar!");
	}

}
