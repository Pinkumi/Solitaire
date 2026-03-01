package com.remonado.solitaire.solitaire;

import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.tools.Pile;

import java.util.ArrayList;
/**
 * Modela el montículo donde se colocan las cartas
 * que se extraen de Draw pile.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (2025-2)
 */
public class WastePile {
    //private ArrayList<CartaInglesa> cartas;
    private Pile<CartaInglesa> cartas;
    public WastePile() {
        cartas = new Pile<>(52);
    }

    public void addCartas(Pile<CartaInglesa> nuevas) {
        while(!nuevas.pila_vacia()){
            cartas.push(nuevas.pop());
        }
    }
    public void addCarta(CartaInglesa c) {
        cartas.push(c);
    }
    public Pile<CartaInglesa> emptyPile() {
        Pile<CartaInglesa> pile = new Pile<>(52);
        if (!cartas.pila_vacia()) {
            while(!cartas.pila_vacia()) {
                pile.push(cartas.pop());
            }
            cartas = new Pile<>(52);
        }
        return pile;
    }

    /**
     * Obtener la última carta sin removerla.
     * @return Carta que está encima. Si está vacía, es null.
     */
    public CartaInglesa verCarta() {
        CartaInglesa regresar = null;
        if (!cartas.pila_vacia()) {
            regresar = cartas.peak();
        }
        return regresar;
    }
    public CartaInglesa getCarta() {
        CartaInglesa regresar = null;
        if (!cartas.pila_vacia()) {
            regresar = cartas.pop();
        }
        return regresar;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        if (cartas.pila_vacia()) {
            stb.append("---");
        } else {
            CartaInglesa regresar = cartas.pop();
            regresar.makeFaceUp();
            stb.append(regresar.toString());
        }
        return stb.toString();
    }

    public boolean hayCartas() {
        return !cartas.pila_vacia();
    }
}
