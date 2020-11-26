package state;


// -> Inathan

public class AguardandoRecebimento extends EstadoMensagem {

	public AguardandoRecebimento(Mensagem mensagem) {
		super(mensagem);
	}

	@Override
	public void enviar(String destinatario) {
		throw new IllegalStateException("Aguardando recebimento... Impossível enviar!");
	}

	@Override
	public void receber() {
		System.out.println("Mensagem recebida." + "\n" + data.getTime());
		EstadoMensagem proximoEstado = new Recebida(this.mensagem);
		mensagem.setEstadoAtual(proximoEstado);

	}

	@Override
	public void arquivar(String solicitante) {
		// TODO Auto-generated method stub

	}

}
