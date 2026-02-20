package com.remonado.solitaire;

import com.remonado.solitaire.DeckOfCards.CartaInglesa;
import com.remonado.solitaire.DeckOfCards.Mazo;
import com.remonado.solitaire.GUIComponents.CardView;
import com.remonado.solitaire.GUIComponents.Menu;
import com.remonado.solitaire.GUIComponents.SolitaireGUI;
import com.remonado.solitaire.GUIComponents.WinScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    StackPane root;
    SolitaireGUI solitaireGUI;
    Menu menu;
    WinScreen winScreen;
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        root = new StackPane();
        winScreen = new WinScreen(this);
        menu = new Menu(this);

        root.getChildren().add(menu);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 1800, 850);
        scene.getStylesheets().add("file:src/main/resources/com/remonado/solitaire/Styles/card.css");
        scene.getStylesheets().add("file:src/main/resources/com/remonado/solitaire/Styles/GUIComponents.css");
        stage.setTitle("Solitaire!");
        stage.setScene(scene);
        stage.setFullScreen(true);

        stage.show();

    }
    public void showMenu(){
        root.getChildren().setAll(menu);
        menu.startAnim();
    }
    public void startGame(){
        root.getChildren().clear();
        solitaireGUI = new SolitaireGUI(this);
        root.getChildren().setAll(solitaireGUI);
    }
    public void showWin(){
        root.getChildren().setAll(winScreen);
        winScreen.startAnim();
    }
    public static void main(String[] args) {
        launch();
    }
}