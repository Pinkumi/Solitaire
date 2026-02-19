package com.remonado.solitaire;

import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.DeckOfCards.Mazo;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        ArrayList<CartaInglesa> cartas = new ArrayList<>();
        cartas = mazo.getCartas();
        for(int i = 0; i < cartas.size(); i++){
            cartas.get(i).makeFaceUp();
            System.out.println(cartas.get(i).toString());
        }
    }
}
