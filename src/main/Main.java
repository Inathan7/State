package main;

import state.Mensagem;

public class Main {

	/*
	 * TODO STATE.03
	 * 
	 * 1. Demonstre como uma sequencia possivel, descomentando as linhas para ver se atuam corretamente.
	 * Programe para lancar execao caso nao seja suportada a chamada no caso da Mensagem se encontrar em determinado estado
	 * (veja as regras de transicoes sobre estados no TODO.STATE.01).
	 * 
	 * PERGUNTA.STATE.A: O cliente do objeto que varia de estados esta responsavel
	 * pela transicao dos mesmos? Se ele ficasse responsavel, em tese, teriamos um Strategy ou
	 * haveria mais coisas?
	 * 
	 * R/A: Não está, quem se responsabiliza por isso é o contexto e os própios subtipos de estado,
	 * Em tese sim, pois uma diferença bem percepitível do Strategy para o State é justamente o Strategy ter 
	 * sua estratégia setada comumente pelo cliente  e isso descaracterizaria o State. 
	 * 
	 * PERGUNTA.STATE.B: Os dados especificos do objeto contexto ficaram na classe dele ou nas classes
	 * de estados? O que fica menos acoplado e coeso?
	 * 
	 * R/B: Ficaram no supertipo de estados, ambos tem um nível de acoplamento e coesão muito parecidos,
	 * apesar de parecer um pouco mais coeso manter os atributos específicos no contexto, foi optado
	 * por manter os mesmo no supertipo estado por facilidade de codificação.
	 * 
	 * PERGUNTA.STATE.C: O objeto contexto pode ficar em mais de um estado ao mesmo tempo neste caso?
	 * Ou ele apenas guarda todos os jÃ¡ assumidos, mas em termos de setup das operacoes, se compoe apenas com o ultimo estado?
	 * 
	 * R/C: Não, um objeto contexto apenas tem um estado por vez, e guarda todos os anteriores dentro de si, se compondo apenas
	 * com o último estado.
	 * 
	 * PERGUNTA.STATE.D: Noutro exemplo, eh sempre obrigatorio guardar o historico dos estados ou isso depende do caso, tipo,
	 * em State so exige que se referencie ou se componha com estado atual de alguma forma, isso? 
	 * 
	 * R/D: Em State não é obrigatorio que se guarde os históricos dos estados, mas apenas que o contexto se componha
	 * com o estado atual.
	 * 
	 */
	public static void main(String[] args) {
		Mensagem mensagem = new Mensagem("Olá, tudo bem. Confirme que leu por favor!");
		System.out.println(mensagem.enviar("Killua","Fulano"));//deve funcionar, veja as regras de transicao na clase Mensagem
		
//		mensagem.enviar("Fulano");//nao deve funcionar
//		mensagem.enviar("Cicrano");//nao deve funcionar
		System.out.println(mensagem.receber());//deve funcionar
//		
//		mensagem.enviar("Fulano");//nao deve funcionar
		System.out.println(mensagem.enviar("Miranha","Cicrano"));//deve funcionar
		
		System.out.println(mensagem.receber());
//		
//		mensagem.arquivar("Cicrano");//nao deve funcionar
		System.out.println(mensagem.arquivar("Killua"));//deve funcionar
	}
	
}
