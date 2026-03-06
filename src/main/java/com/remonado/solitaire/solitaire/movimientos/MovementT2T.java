package com.remonado.solitaire.solitaire.movimientos;

import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.solitaire.TableauDeck;

import java.util.ArrayList;

public class MovementT2T extends Movement{
    private TableauDeck fuente;
    private TableauDeck destino;
    private ArrayList<CartaInglesa> cartasMovidas;
    private boolean seVolteoCartaAnt;
    public MovementT2T(TableauDeck fuente, TableauDeck destino, boolean seVolteoCartaAnt, ArrayList<CartaInglesa> cartasMovidas) {
        super("T2T");
        this.fuente = fuente;
        this.destino = destino;
        this.seVolteoCartaAnt = seVolteoCartaAnt;
        this.cartasMovidas = new ArrayList<>(cartasMovidas);
    }
    public void undo(){
        System.out.println("Undo "+ movementType);
        if(seVolteoCartaAnt) fuente.getUltimaCarta().makeFaceDown();
        ArrayList<CartaInglesa> cards = destino.removeCartasDesde(destino.getCards().size()-cartasMovidas.size());;
        fuente.regresarBloqueDeCartas(cards);
    }

}
