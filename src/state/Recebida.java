package state;

//-> Inathan

public class Recebida extends EstadoMensagem {

	public Recebida(Mensagem mensagem) {
		super(mensagem);
	}

	@Override
	public String enviar(String remetente, String destinatario) {
		String retorno = "";
		for (int i = 0; i < mensagem.getEstados().size(); i++) {
			if(mensagem.getEstados().get(i).getDestinatario() != null && mensagem.getEstados().get(i).getDestinatario().equals(destinatario)) {
				throw new IllegalStateException("Destinatario j� recebeu mensagem anteriormente... Imposs�vel enviar!");
			}else if(i==mensagem.getEstados().size()-1) {
				this.setRemetente(remetente);
				this.setDestinatario(destinatario);
				EstadoMensagem proximoEstado = new AguardandoRecebimento(this.mensagem);
				mensagem.setEstadoAtual(proximoEstado);
				retorno = "Mensagem enviada para  " + this.getDestinatario() + "\n" + data.getTime();
				break;
			}
			
		}
		return retorno;
	}

	@Override
	public String receber() {
		throw new IllegalStateException("Mensagem j� recebida... Imposs�vel receber!");
	}

	@Override
	public String arquivar(String solicitante) {
		if(mensagem.getEstados().get(0).getRemetente().equals(solicitante)) {
			EstadoMensagem proximoEstado = new Arquivada(this.mensagem);
			mensagem.setEstadoAtual(proximoEstado);
			return "Mensagem arquivada." + "\n" + data.getTime();
		}
		throw new IllegalStateException("Solicitante n�o � remetente original... Imposs�vel arquivar!");
	}

}
