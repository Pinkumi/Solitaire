package com.remonado.solitaire.solitaire.movimientos;

import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.solitaire.TableauDeck;
import com.remonado.solitaire.solitaire.WastePile;
import com.remonado.solitaire.tools.Pile;

import java.util.ArrayList;

public class MovementW2T extends Movement{
    private WastePile fuente;
    private TableauDeck destino;
    public MovementW2T(WastePile fuente, TableauDeck destino) {
        super("W2T");
        this.fuente = fuente;
        this.destino = destino;
    }
    public void undo() {
        System.out.println("Undo "+ movementType);
        fuente.addCarta(destino.removerUltimaCarta());
    }

}
