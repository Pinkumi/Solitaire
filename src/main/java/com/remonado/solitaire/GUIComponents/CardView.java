package com.remonado.solitaire.GUIComponents;

import com.remonado.solitaire.Controller;
import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CardView extends StackPane { //extiende de stackpane para usarlo como elemento grafico
    private ImageView cardView; //Imagen de la carta
    private CartaInglesa card;
    private double xMovement;
    private double yMovement;
    private boolean isOnTableau = false; //Indica si vendra de un tableau o desde el wastePile
    private int tableauIdx = 0; //indica el indice del tableau, no se usa si isOnTableau = false

    public CardView(CartaInglesa carta) { //cargamos una carta inglesa
        this.card = carta;
        cardView = new ImageView();
        //carta.makeFaceUp();
        draw();
        cardView.setFitWidth(135);
        cardView.setPreserveRatio(true);
        this.getStyleClass().addAll("card");
        this.getChildren().add(cardView);
        setMovement();
    }

    /**
     * @return true si esta dentro de un tableau
     */
    public boolean isOnTableau() {
        return isOnTableau;
    }
    /**
     * @return indice del tableau en el que esta
     */
    public int getTableauIdx(){
        if(!isOnTableau){
            return -1;
        }else{
            return tableauIdx;
        }
    }
    /**
     * @return true si esta dentro de un tableau
     */
    public void setTableauIdx(int idx){
        tableauIdx = idx;
        isOnTableau = true;
    }
    /**
     * setea el movimiento
     */
    private void setMovement() {
        setOnMousePressed((MouseEvent e) -> {
            xMovement =e.getSceneX()-getLayoutX();
            yMovement =e.getSceneY()-getLayoutY();
        });
        setOnMouseDragged((MouseEvent e) -> {
            setLayoutX(e.getSceneX()-xMovement);
            setLayoutY(e.getSceneY()-yMovement);
            toFront();
        });
    }
    /**
     * Dibuja la carta desde la ruta de la imagen o si esta volteada
     *
     */
    public void draw(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("file:src/main/resources/com/remonado/solitaire/Assets/images/");
        if(card.isFaceup()){
            this.setDisable(false);
            switch (card.getPalo().getFigura()) {
                case "♣\uFE0E":
                    stringBuilder.append("trebol");
                    break;
                case "♠\uFE0F":
                    stringBuilder.append("pica");
                    break;
                case "❤\uFE0F":
                    stringBuilder.append("corazon");
                    break;
                case "♦\uFE0F":
                    stringBuilder.append("diamante");
                    break;
            }
            stringBuilder.append(card.getValorBajo());
        }else{
            stringBuilder.append("trasera");
            this.setDisable(true);
        }
        stringBuilder.append(".png");
        cardView.setImage(new Image(stringBuilder.toString()));
        Rectangle clip = new Rectangle(cardView.getImage().getWidth(), cardView.getImage().getHeight());
        clip.setArcHeight(15);
        clip.setArcWidth(15);
        clip.setStroke(Color.BLACK);
        cardView.setClip(clip);
        SnapshotParameters prm = new SnapshotParameters();
        prm.setFill(Color.TRANSPARENT);
        WritableImage image = cardView.snapshot(prm, null);
        cardView.setClip(null);
        cardView.setImage(image);
    }
    /**
     * Controla la accion de solar una carta dentro de otro elemento gráfico.
     *
     * @param c Controller donde se conectara con el modelo
     */
    public void setReleased(Controller c){
        setOnMouseReleased((MouseEvent e) -> {
            c.drop(this);
        });
    }
    /**
     * Regresa el modelo al que esta ligado
     *
     * @return modelo de carta
     */
    public CartaInglesa getCard() {
        return card;
    }


}
