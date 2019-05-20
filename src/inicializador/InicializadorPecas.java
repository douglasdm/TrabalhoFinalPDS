package inicializador;

import java.util.ArrayList;

import entidade.Peca;


public class InicializadorPecas {
    private ArrayList<Peca> pecas;
    
    public InicializadorPecas(){
        pecas = new ArrayList<>();
        criarPecas();
    }
    
    private void criarPecas(){
        for(int i=1; i<=4; i++){
            pecas.add(new Peca(i));
        }
    }
    
    public ArrayList<Peca> getPecas(){
        return pecas;
    }
}
