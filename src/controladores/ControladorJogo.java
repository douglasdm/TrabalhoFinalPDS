package controladores;

import java.util.ArrayList;


import entidade.Jogo;
import fronteiras.TelaJogadorInfoConsole;
//import main.Teste.TelaTabuleiroInfoGUI;

public class ControladorJogo {
	
	private Jogo jogo;
	private TelaJogadorInfoConsole telaInfo;
	//private TelaTabuleiroInfoGUI tabuleiroInfo;
	private static ControladorJogo controladorJogo;
	
	private ControladorJogo() {
		jogo = new Jogo();

		telaInfo = new TelaJogadorInfoConsole();
	}
	
	public static ControladorJogo getInstance() {
		if(controladorJogo==null)
			return controladorJogo = new ControladorJogo();
		return controladorJogo;
	}
	
	public void criarJogador(ArrayList<String> nomeDoJogador,int qtdJogadores) {
		if(!nomeDoJogador.isEmpty()) {
			if(jogo.criarJogadores(nomeDoJogador,qtdJogadores)) {
				JogadoresRodada(qtdJogadores);
			}
		}
	}
	
	public void JogadoresRodada(int qtdJogadores) {
		String comando ="";
		boolean comandoSpace = true;
		//divide em dois controle Console e GUI
		//recebendo o jogo
		do{	
			if(comando.isEmpty() || comandoSpace) {
				telaInfo.setJogador(jogo.jogadorDaVez());
				comando = telaInfo.rolarDadoJogador();
				if(jogo.JogadoresRodada()) {
					telaInfo.FimDeJogo(jogo.getNumeroGerado());
					break;
				}
				telaInfo.setCasa(jogo.getCasaDaRodada());
				telaInfo.setNumeroAleatorio(jogo.getNumeroGerado());	
				telaInfo.infoJogador();
			}
//		else if(comandoSpace) {
//				tabuleiroInfo = TelaTabuleiroInfoGUI.getInstace();
//				//
//				tabuleiroInfo.exibirTabuleiro();
//				
//				//iniciar pecas aqui pegando a qttd de jogadores
//				tabuleiroInfo.inicializarPecasJogadores(qtdJogadores);
//				//tabuleiroInfo.exibirPecasJogadores();
//				
//				//set para tela
//				tabuleiroInfo.setJogadorInfo(jogo.jogadorDaVez());
//				tabuleiroInfo.setCasaAtual(jogo.getCasaDaRodada());
//				tabuleiroInfo.setValorDoDado(jogo.getNumeroGerado());
//				
//				
//				tabuleiroInfo.posicaoSpritePeca();
//				//melhorou
//				
//				tabuleiroInfo.inforJogador();
//				tabuleiroInfo.exibirPecasJogadores();
//				
//				
//				tabuleiroInfo.atualizarTabuleiro();
//				
//				if(jogo.JogadoresRodada()) {
//					System.out.println("Fim de Jogo");
//					tabuleiroInfo.fechaJanela();
//					break;
//				}
//				
//				
//				comandoSpace = tabuleiroInfo.rolarDadoJogador();
//				//sei la
//				//tabuleiroInfo.atualizarTabuleiro();
//				
//			}
		}while(comando.isEmpty() || comandoSpace);
			
		
				
	}

	


	
	
	
	
	
}
