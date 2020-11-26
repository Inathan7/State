package state;

// -> Inathan

public class Criado extends EstadoMensagem {

	public Criado(Mensagem mensagem) {
		super(mensagem);
	}

	@Override
	public void enviar(String destinatario) {
		System.out.println("Mensagem enviada para  " + destinatario + "\n" + data.getTime());
		EstadoMensagem proximoEstado = new AguardandoRecebimento(this.mensagem);
		mensagem.setEstadoAtual(proximoEstado);
	}

	@Override
	public void receber() {
		System.out.println("Mensagem recebida." + "\n" + data.getTime());
		EstadoMensagem proximoEstado = new AguardandoRecebimento(this.mensagem);
		mensagem.setEstadoAtual(proximoEstado);
	}

	@Override
	public void arquivar(String solicitante) {
		// TODO Auto-generated method stub

	}

}
