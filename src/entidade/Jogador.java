package entidade;

import JGamePlay.Sprite;
import entidade.casas.AbstractCasa;

public class Jogador {
	private String nome;
	private Peca minhaPeca;
	private int idJogador;
	private Dado dados;
	private SpritePeca spritePeca;
	
	///criar um classe estaticas para salvar as info da rodade talvez no jogo que vai
	//pegar do jogador da vez
	
	private Tabuleiro meuTabuleiro = Tabuleiro.getInstance();
	
	
	public Jogador(String nome,int idJogador) {
		this.nome = nome;
		this.idJogador = idJogador;
		this.minhaPeca = new Peca(idJogador);
		this.dados = new Dado(12);
		//spritePeca = new SpritePeca(idJogador);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void colocarPecaNoTabuleiro() {
		this.spritePeca.draw();
	}
	
	public int lancarDados() {
		return this.dados.lancarDado();
	}
	
	public int avancarPeca() {
		int numero = this.lancarDados();
		int novaPosicao = minhaPeca.getCasaAtual() + numero;
		System.out.println("Posicao Inicial "+ minhaPeca.getCasaAtual());
		minhaPeca.setCasaAtual(novaPosicao);
		System.out.println("Numero aleatorio "+ numero);
		System.out.println("Nova posicao " + novaPosicao);
		AbstractCasa casaBuscada;
		if(novaPosicao>=100) {
			casaBuscada = meuTabuleiro.getListaDeCasas().get(99);
			System.out.println("Nova Posicao Atual: "+ minhaPeca.getCasaAtual());
			System.out.println("---------------------------------------------------");
				
			this.minhaPeca.moveHouse(casaBuscada);
			this.minhaPeca.setCasaAtual(casaBuscada.getNome());
			
			//this.spritePeca.moveHouse(casaBuscada);
			//this.spritePeca.setCasaAtual(casaBuscada.getNome());
			
			
			return numero;
		}else {
			casaBuscada = meuTabuleiro.getListaDeCasas().get(novaPosicao-1);
			System.out.println("Nova Posicao Atual: "+ minhaPeca.getCasaAtual());
			System.out.println("---------------------------------------------------");
			
			this.minhaPeca.moveHouse(casaBuscada);
			this.minhaPeca.setCasaAtual(casaBuscada.getNome());
			
			
			//this.spritePeca.moveHouse(casaBuscada);
			//this.spritePeca.setCasaAtual(casaBuscada.getNome());
			
			
			return numero;
		}
	}
	
	
	
	public Peca getMinhaPeca() {
		return minhaPeca;
	}
	

}
