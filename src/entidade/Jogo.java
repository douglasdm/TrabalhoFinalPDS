package entidade;

import java.util.ArrayList;

import controladores.IteratorRodada;
import entidade.casas.AbstractCasa;
import interfaces.CasaEspecial;

public class Jogo {
	
	private IteratorRodada iteratorRodado;
	ArrayList<Jogador> listaDeJogadores;
	private Tabuleiro meuTabuleiro = Tabuleiro.getInstance();
	private AgregadorRodada agregadorRodada;
	private Dado dado;
	private int numeroGerado;
	private CasaEspecial casaDaRodada;
	
	public Jogo() {
		listaDeJogadores = new ArrayList<Jogador>();
		agregadorRodada = new AgregadorRodada();
		dado = new Dado(12);
		numeroGerado = 0;
	}
	
	public boolean criarJogadores(ArrayList<String> nomeDoJogador,int qtdJogadores) {
		int i=0;
		while(i<qtdJogadores) {
			Jogador jogador = new Jogador(nomeDoJogador.get(i),i+1 );
			listaDeJogadores.add(jogador);
			i++;
		}
		iteratorRodado = agregadorRodada.criarInteratorJogador(listaDeJogadores);
		return true;
	}
	
	public boolean JogadoresRodada() {
	         Jogador jogadorVez = iteratorRodado.proximoJogador();
	        
	         System.out.println("Jogo : "+ jogadorVez.getNome());	
	         
	         this.avancarPeca(jogadorVez);
	         
	         
	         if(jogadorVez.getMinhaPeca().getCasaAtual()>=100) {
	        	return true;
	         }
			return false;	
	}
	
	public Jogador jogadorDaVez() {
		return iteratorRodado.jogadorAtual();
	}
	
	public int lancarDados() {
		return this.dado.lancarDado();
	}
	
	public void avancarPeca(Jogador jogadoDaVez) {
		int numero = this.lancarDados();
		int novaPosicao = jogadoDaVez.getMinhaPeca().getCasaAtual() + numero;
		this.setNumeroGerado(numero);
		
		System.out.println("#Jogo Numero aleatorio: "+ numero);
		CasaEspecial casaBuscada;
		if(novaPosicao>=100) {
			casaBuscada = meuTabuleiro.getListaDeCasas().get(99);
			this.setCasaDaRodada(casaBuscada);
			jogadoDaVez.avancarPeca(casaBuscada);
		}else {
			casaBuscada = meuTabuleiro.getListaDeCasas().get(novaPosicao-1);
			this.setCasaDaRodada(casaBuscada);
			jogadoDaVez.avancarPeca(casaBuscada);
		
		}
	}
	
	
	public ArrayList<Jogador> getListaDeJogadores() {
		return listaDeJogadores;
	}	
	
	public CasaEspecial getCasaDaRodada() {
		return casaDaRodada;
	}

	public void setCasaDaRodada(CasaEspecial casaDaRodada) {
		this.casaDaRodada = casaDaRodada;
	}

	public int getNumeroGerado() {
		return numeroGerado;
	}

	
	
	public void setNumeroGerado(int numeroGerado) {
		this.numeroGerado = numeroGerado;
	}

	
	
}
