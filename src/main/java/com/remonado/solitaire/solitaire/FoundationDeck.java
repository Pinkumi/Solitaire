package com.remonado.solitaire.solitaire;

import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.DeckOfCards.Palo;
import com.remonado.solitaire.tools.Pile;

import java.util.ArrayList;

/**
 * Modela un monículo donde se ponen las cartas
 * de un solo palo.
 *
 * @author Cecilia M. Curlango
 * @version 2025
 */

public class FoundationDeck {
    public Palo palo;
    Pile<CartaInglesa> cartas = new Pile<>(52);
    private Pile<CartaInglesa> cards;

    public FoundationDeck(Palo palo) {
        this.palo = palo;
    }

    public FoundationDeck(CartaInglesa carta) {
        palo = carta.getPalo();
        // solo agrega la carta si es un A
        if (carta.getValorBajo() == 1) {
            cartas.push(carta);
        }
    }

    /**
     * Agrega una carta al montículo. Sólo la agrega si
     * la carta es del palo del montículo y el la siguiente
     * carta en la secuencia.
     *
     * @param carta que se intenta almancenar
     * @return true si se pudo guardar la carta, false si no
     */
    public boolean agregarCarta(CartaInglesa carta) {
        boolean agregado = false;
        if (carta.tieneElMismoPalo(palo)) {
            if (cartas.pila_vacia()) {
                if (carta.getValorBajo() == 1) {
                    // si no hay cartas entonces la carta debe ser un A
                    cartas.push(carta);
                    agregado = true;
                }
            } else {
                // si hay cartas entonces debe haber secuencia
                CartaInglesa ultimaCarta = cartas.peak();
                if (ultimaCarta.getValorBajo() + 1 == carta.getValorBajo()) {
                    // agregar la carta si el la siguiente a la última
                    cartas.push(carta);
                    agregado = true;
                }
            }
        }
        return agregado;
    }

    /**
     * Remover la última carta del montículo.
     *
     * @return la carta que removió, null si estaba vacio
     */
    public CartaInglesa removerUltimaCarta() {
        CartaInglesa ultimaCarta = null;
        if (!cartas.pila_vacia()) {
            ultimaCarta = cartas.pop();
        }
        return ultimaCarta;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (cartas.pila_vacia()) {
            builder.append("---");
        } else {
            builder. append(cartas.toString());
        }
        return builder.toString();
    }

    /**
     * Determina si hay cartas en el Foundation.
     * @return true hay al menos una carta, false no hay cartas
     */
    public boolean estaVacio() {
        return cartas.pila_vacia();
    }

    /**
     * Obtiene la última carta del Foundation sin removerla.
     * @return última carta, null si no hay cartas
     */
    public CartaInglesa getUltimaCarta() {
//        CartaInglesa ultimaCarta = null;
//        if (!cartas.pila_vacia()) {
//            ultimaCarta = cartas.pop();
//        }
        return cartas.pop();
    }
}
