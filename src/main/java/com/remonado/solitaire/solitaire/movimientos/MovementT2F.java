package com.remonado.solitaire.solitaire.movimientos;

import com.remonado.solitaire.solitaire.FoundationDeck;
import com.remonado.solitaire.solitaire.TableauDeck;

public class MovementT2F extends Movement{
    private TableauDeck fuente;
    private FoundationDeck destino;
    public MovementT2F(TableauDeck fuente, FoundationDeck destino) {
        super("T2T");
        this.fuente = fuente;
        this.destino = destino;
    }
//    public MovementT2F(TableauDeck fuente) {
//        super("T2T");
//        this.fuente = fuente;
//    }
//    public void addDestino(FoundationDeck destino) {
//        this.destino = destino;
//    }
    public void undo(){
        fuente.regresarCarta(destino.removerUltimaCarta());
    }
}
