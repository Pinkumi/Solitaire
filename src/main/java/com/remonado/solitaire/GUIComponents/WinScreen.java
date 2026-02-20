package com.remonado.solitaire.GUIComponents;

import com.remonado.solitaire.Main;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class WinScreen extends StackPane {
    private ImageView tittle;
    private Button goMenu, exit;

    public WinScreen(Main m) {
        //this.getStyleClass().add("menu");
        tittle = new ImageView(new Image("file:src/main/resources/com/remonado/solitaire/Assets/Images/win.png"));
        ImageView imgMenu = new ImageView(new Image("file:src/main/resources/com/remonado/solitaire/Assets/Images/menu.png"));
        ImageView imgExit = new ImageView(new Image("file:src/main/resources/com/remonado/solitaire/Assets/Images/exit.png"));
        imgMenu.getStyleClass().add("menuButton");
        imgExit.getStyleClass().add("menuButton");
        imgMenu.setOnMouseClicked(e -> m.showMenu());
        imgExit.setOnMouseClicked(e -> Platform.exit());
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(60);
        root.getChildren().addAll(tittle, imgMenu, imgExit);
        setStyle("-fx-background-color: rgba(0,0,0,0.6);");
        this.getStyleClass().add("win");
        this.getChildren().add(root);
        this.setAlignment(Pos.CENTER);
    }

    public void startAnim() {
        ScaleTransition st = new ScaleTransition(Duration.millis(4000), tittle);
        st.setToX(1.2);
        st.setToY(1.2);
        st.play();
    }
}