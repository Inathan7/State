package state;


// -> Inathan

public class AguardandoRecebimento extends EstadoMensagem {

	public AguardandoRecebimento(Mensagem mensagem) {
		super(mensagem);
	}

	@Override
	public String enviar(String remetente, String destinatario) {
		throw new IllegalStateException("Aguardando recebimento... Impossível enviar!");
	}

	@Override
	public String receber() {
		EstadoMensagem proximoEstado = new Recebida(this.mensagem);
		mensagem.setEstadoAtual(proximoEstado);
		return "Mensagem recebida." + "\n" + data.getTime();

	}

	@Override
	public String arquivar(String solicitante) {
		throw new IllegalStateException("Aguardando recebimento... Impossível arquivar!");
	}

}
