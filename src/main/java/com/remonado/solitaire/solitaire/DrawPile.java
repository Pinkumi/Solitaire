package com.remonado.solitaire.solitaire;

import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.tools.Pile;

import java.util.ArrayList;

/**
 * Modela un mazo de cartas de solitario.
 * @author Cecilia Curlango
 * @version 2025
 */
public class DrawPile {
    private Pile<CartaInglesa> cartas;
   // private Pile<CartaInglesa> cards;
    private int cuantasCartasSeEntregan = 3;

    public DrawPile() {
        com.remonado.solitaire.DeckOfCards.Mazo mazo = new com.remonado.solitaire.DeckOfCards.Mazo();
        cartas = mazo.getCartas();
        setCuantasCartasSeEntregan(3);
    }

    /**
     * Establece cuantas cartas se sacan cada vez.
     * Puede ser 1 o 3 normalmente.
     * @param cuantasCartasSeEntregan
     */
    public void setCuantasCartasSeEntregan(int cuantasCartasSeEntregan) {
        this.cuantasCartasSeEntregan = cuantasCartasSeEntregan;
    }

    /**
     * Regresa la cantidad de cartas que se sacan cada vez.
     * @return cantidad de cartas que se entregan
     */
    public int getCuantasCartasSeEntregan() {
        return cuantasCartasSeEntregan;
    }

    /**
     * Retirar una cantidad de cartas. Este método se utiliza al inicio
     * de una partida para cargar las cartas de los tableaus.
     * Si se tratan de remover más cartas de las que hay,
     * se provocará un error.
     * @param cantidad de cartas que se quieren a retirar
     * @return cartas retiradas
     */
    public ArrayList<CartaInglesa> getCartas(int cantidad) {
        ArrayList<CartaInglesa> retiradas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            retiradas.add(cartas.pop());
        }
        return retiradas;
    }

    /**
     * Retira y entrega las cartas del monton. La cantidad que retira
     * depende de cuántas cartas quedan en el montón y serán hasta el máximo
     * que se configuró inicialmente.
     * @return Cartas retiradas.
     */
    public Pile<CartaInglesa> retirarCartas() {
        Pile<CartaInglesa> retiradas = new Pile<>(54);
        int maximoARetirar = Math.min(cartas.getSize(), cuantasCartasSeEntregan);

        for (int i = 0; i < maximoARetirar; i++) {
            CartaInglesa retirada = cartas.pop();
            retirada.makeFaceUp();
            retiradas.push(retirada);
        }
        return retiradas;
    }

    /**
     * Indica si aún quedan cartas para entregar.
     * @return true si hay cartas, false si no.
     */
    public boolean hayCartas() {
        return !cartas.pila_vacia();
    }

    public CartaInglesa verCarta() {
        CartaInglesa regresar = null;
        if (!cartas.pila_vacia()) {
            regresar = cartas.pop();
        }
        return regresar;
    }
    /**
     * Agrega las cartas recibidas al monton y las voltea
     * para que no se vean las caras.
     * @param cartasAgregar cartas que se agregan
     */
    public void recargar(Pile<CartaInglesa> cartasAgregar) {
        while(!cartasAgregar.pila_vacia()) {
            CartaInglesa carta = cartasAgregar.pop();
            carta.makeFaceDown();
            cartas.push(carta);
        }
    }

    @Override
    public String toString() {
        if (cartas.pila_vacia()) {
            return "-E-";
        }
        return "@";
    }
}
