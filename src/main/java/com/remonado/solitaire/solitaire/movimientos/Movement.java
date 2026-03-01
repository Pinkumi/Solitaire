package com.remonado.solitaire.solitaire.movimientos;

import com.remonado.solitaire.DeckOfCards.CartaInglesa;

public abstract class Movement {
    private String movementType;
    protected CartaInglesa cardUsed;
    public Movement(String movementType) {
        this.movementType = movementType;
    }


    public abstract void undo();
//    public abstract void execute();
    public String getMovementType() {
        return movementType;
    }

}



