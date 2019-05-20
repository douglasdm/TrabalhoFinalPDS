package entidade;


public class Jogador {
	private String nome;
	private Peca minhaPeca;
	private int idJogador;
	private Dado dados;
	//private Tabuleiro meuTabuleiro = Tabuleiro.getInstance();
	//tem que ter um tabuleiro para pegar a casa
	
	
	public Jogador(String nome,int idJogador) {
		this.nome = nome;
		this.idJogador = idJogador;
		this.minhaPeca = new Peca(idJogador);
		this.dados = new Dado(12);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void colocarPecaNoTabuleiro() {
		this.minhaPeca.draw();
	}
	
	public int lancarDados() {
		return this.dados.lancarDado();
	}
	//chamar o move house
	//somar a posicao atual com o valor do dados e busca esse valor no meuTabuleiro
	public void avancarPeca() {
		int numero = this.lancarDados();
		int novaPosicao = minhaPeca.getCasaAtual() + numero;
		System.out.println("Posicao atual "+ minhaPeca.getCasaAtual());
		System.out.println("Numero aleatorio "+ numero);
		System.out.println("Nova posicao " + novaPosicao);
		//AbstractCasa casa = meuTabuleiro.getListaDeCasas().get(novaPosicao);
		//this.minhaPeca.moveHouse(casa);
	}
	
}
