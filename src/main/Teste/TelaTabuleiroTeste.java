package main.Teste;

import java.awt.Color;
import java.awt.Font;

import JGamePlay.GameImage;
import JGamePlay.Keyboard;
import JGamePlay.Sprite;
import JGamePlay.Window;
import entidade.Jogador;
import entidade.SpritePeca;
import entidade.Tabuleiro;

public class TelaTabuleiroTeste {
	
	
	public static void main(String[] args) {
		Window janela = new Window(1190,1000);
		
		Keyboard key = janela.getKeyboard();
		
		GameImage backGround = new GameImage("recursos/fundo.jpg");
		
		SpritePeca sprite = new SpritePeca(1);
		
		//vermelha
		Color cor = new Color(255,0, 0);
		Color cor2 = new Color(0,0, 0);
		//fontes
		Font fonte = new Font("serif", Font.BOLD, 24);
		Font fonte2 = new Font("Arial", Font.BOLD, 14);
		Font fonte3 = new Font("Monospaced", Font.BOLD, 14);
		
		
		Sprite dado = new Sprite("recursos/dadobotao.jpg");
		
		dado.setPosition(1050, 120);
		dado.setDimension(100, 100);
		
		Jogador j1 = new Jogador("Douglas", 1);
		Jogador j2 = new Jogador("Jose", 2);
		
		backGround.draw();
		dado.draw();
		int no =0;
		int posica =1;
		
		
		boolean executando = true;
		while (executando) {
			backGround.draw();
			dado.draw();
			sprite.draw();
			
			janela.drawText("A VEZ � DO P1",1050, 30, cor,fonte3);
			janela.drawText(j1.getNome(),1050, 60, cor,fonte2);
			janela.drawText("Valor do Dados: "+no,1050, 90, cor2,fonte2);
			janela.drawText("Posicao Atual: : "+posica,1050, 120, cor2,fonte2);
			
			
			
			if(key.keyDown(Keyboard.SPACE_KEY)) {
				// no = j1.avancarPeca(12);
				 posica = j1.getMinhaPeca().getCasaAtual();
				 janela.display();
					
			}
			
			if(key.keyDown(Keyboard.ESCAPE_KEY)) {
				executando = false;
			}
			
			janela.display();
		}
			
		janela.exit();
	}
}
