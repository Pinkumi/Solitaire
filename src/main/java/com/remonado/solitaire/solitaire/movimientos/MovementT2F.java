package com.remonado.solitaire.solitaire.movimientos;

import com.remonado.solitaire.solitaire.FoundationDeck;
import com.remonado.solitaire.solitaire.TableauDeck;

public class MovementT2F extends Movement{
    private TableauDeck fuente;
    private boolean seVolteoCartaAnt;
    private FoundationDeck destino;
    public MovementT2F(TableauDeck fuente, FoundationDeck destino,boolean seVolteoCartaAnt) {
        super("T2F");
        this.fuente = fuente;
        this.destino = destino;
        this.seVolteoCartaAnt = seVolteoCartaAnt;
    }
//    public MovementT2F(TableauDeck fuente) {
//        super("T2T");
//        this.fuente = fuente;
//    }
//    public void addDestino(FoundationDeck destino) {
//        this.destino = destino;
//    }
    public void undo(){
        System.out.println("Undo "+ movementType);
        if(seVolteoCartaAnt && !fuente.isEmpty())  fuente.getUltimaCarta().makeFaceDown();
        fuente.regresarCarta(destino.removerUltimaCarta());
    }
}
