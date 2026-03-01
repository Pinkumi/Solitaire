package com.remonado.solitaire.DeckOfCards;
/**
 * Write a description of class Mazo here.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (2025-2)
 */
import com.remonado.solitaire.tools.Pile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private Pile<CartaInglesa> cartas = new Pile<>(54);

    public Mazo() {
        llenar(); // crea todas las cartas, excluyendo Jokers
        mezclar();
    }

    /**
     * Obtiene todas las cartas del mazo.
     * @return
     */
    public Pile<CartaInglesa> getCartas() {
        return cartas;
    }

    public CartaInglesa obtenerUnaCarta() {
        if (!cartas.pila_vacia()) {
            return cartas.pop();
        }
        return null;
    }
    private void mezclar() {
        ArrayList<CartaInglesa> cartasLista = new ArrayList<>();
        while (!cartas.pila_vacia()) {
            cartasLista.add(cartas.pop());
        }
        Collections.shuffle(cartasLista);
        for (CartaInglesa c : cartasLista) {
            cartas.push(c);
        }
    }

    private void llenar() {
        for (int i = 2; i <=14 ; i++) {
            for (Palo palo : Palo.values()) {
                CartaInglesa c = new CartaInglesa(i,palo, palo.getColor());
                cartas.push(c);
            }
        }
    }

    public void ordenar() {
        Arrays.sort(cartas.getCartas());
    }

    @Override
    public String toString() {
        return cartas.toString();
    }
}
