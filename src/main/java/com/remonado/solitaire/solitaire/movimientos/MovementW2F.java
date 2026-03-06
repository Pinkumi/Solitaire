package com.remonado.solitaire.solitaire.movimientos;

import com.remonado.solitaire.solitaire.FoundationDeck;
import com.remonado.solitaire.solitaire.TableauDeck;
import com.remonado.solitaire.solitaire.WastePile;

public class MovementW2F extends Movement{
    private WastePile fuente;
    private FoundationDeck destino;
    public MovementW2F(WastePile fuente, FoundationDeck destino) {
        super("W2F");
        this.fuente = fuente;
        this.destino = destino;
    }
    public void undo() {
        System.out.println("Undo "+ movementType);
        fuente.addCarta(destino.removerUltimaCarta());
    }
}
