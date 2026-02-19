package com.remonado.solitaire;

import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.DeckOfCards.Mazo;
import com.remonado.solitaire.GUIComponents.CardView;
import com.remonado.solitaire.GUIComponents.SolitaireGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
//region prueba carta
//        Mazo m = new Mazo();
//        ArrayList<CardView> cardViews = new ArrayList<>();
//        for(CartaInglesa c : m.getCartas()){
//            cardViews.add(new CardView(c));
//        }

//        Pane table = new Pane();
//        CardView card = cardViews.get(1);
//        card.setLayoutX(50);
//        card.setLayoutY(50);
//        card.setOnMouseReleased(e -> {
//            card.setLayoutX(50);
//            card.setLayoutY(50);
//        });
//
//        table.getChildren().add(card);
//        ScrollPane scroll = new ScrollPane(table);
//
//        scroll.setPannable(false);
//        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//        scroll.setStyle("-fx-background: #0b6623;");
        //endregion
        SolitaireGUI  solitaireGUI = new SolitaireGUI();
        Scene scene = new Scene(solitaireGUI, 1800, 850);
        scene.getStylesheets().add("file:src/main/resources/com/remonado/solitaire/Styles/card.css");
        scene.getStylesheets().add("file:src/main/resources/com/remonado/solitaire/Styles/GUIComponents.css");
        stage.setTitle("Solitaire!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}