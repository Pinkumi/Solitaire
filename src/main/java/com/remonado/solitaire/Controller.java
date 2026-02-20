package com.remonado.solitaire;

import com.remonado.solitaire.GUIComponents.CardView;
import com.remonado.solitaire.GUIComponents.SolitaireGUI;
import com.remonado.solitaire.GUIComponents.TableauView;
import com.remonado.solitaire.solitaire.SolitaireGame;
import javafx.geometry.Bounds;

public class Controller {
    private SolitaireGame game;
    private SolitaireGUI gui;
    public Controller(SolitaireGame game, SolitaireGUI gui) {
        this.game = game;
        game.getDrawPile().setCuantasCartasSeEntregan(1);
        this.gui = gui;
        

    }

    public void drop(CardView card) {
        boolean colisiono = false;
        Bounds cardBounds = card.localToScene(card.getBoundsInLocal());
        Bounds foundationBounds = gui.getPaneFoundation().localToScene(gui.getPaneFoundation().getBoundsInLocal());
        if(cardBounds.intersects(foundationBounds)) {
            if(card.isOnTableau()){
                int prevTableauIdx = card.getTableauIdx();
                game.moveTableauToFoundation(card.getTableauIdx()+1);
                gui.reDraw(prevTableauIdx, -1);
                colisiono = true;
                //System.out.println("Moviste de tableau a foundation");
            }else{
                colisiono = true;
                game.moveWasteToFoundation();
                gui.reDraw(-2, -1);
               // System.out.println("Moviste de waste a foundation");
            }
        }else{
            for(TableauView tv : gui.getTableauViews()){
                Bounds tableauBounds = tv.localToScene(tv.getBoundsInLocal());
                if(tv.getIdx() == card.getTableauIdx()){
                    continue;
                }
                if(cardBounds.intersects(tableauBounds)){
                    if(card.isOnTableau()){
                        game.moveTableauToTableau(card.getTableauIdx()+1, tv.getIdx()+1);
                        gui.reDraw(card.getTableauIdx(), tv.getIdx());
                        return;
//                        System.out.println("Moviste de tableau a tableau");
//                        System.out.println((card.getTableauIdx()) + " " + (tv.getIdx()));
                    }else{
                        game.moveWasteToTableau(tv.getIdx()+1);
                        gui.reDraw(tv.getIdx(), -2);
                        return;
//                        System.out.println("Moviste de waste a tableau");
                    }

                }

            }
        }
        if(!colisiono){
            if(card.isOnTableau()){
                gui.reDraw(card.getTableauIdx(), -10);
            }else{
                gui.reDraw(-3, -3);
            }

        }
        if(game.isGameOver()){
            gui.gameOver();
        }

    }

    public void drawCard() {
        if(game.getDrawPile().hayCartas()) {
            game.drawCards();
        }else{
            game.reloadDrawPile();
            gui.clearWasteView();
        }
        gui.reDraw(-3,-10);
    }



}
