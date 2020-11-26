package state;

//-> Inathan

public class Recebida extends EstadoMensagem {

	public Recebida(Mensagem mensagem) {
		super(mensagem);
	}

	@Override
	public void enviar(String destinatario) {
		
		System.out.println("Mensagem enviada para  " + destinatario + "\n" + data.getTime());
	//	EstadoMensagem proximoEstado = new Recebida(this.mensagem);
	//	mensagem.setEstadoAtual(proximoEstado);
	}

	@Override
	public void receber() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void arquivar(String solicitante) {
		// TODO Auto-generated method stub
		
	}

}
