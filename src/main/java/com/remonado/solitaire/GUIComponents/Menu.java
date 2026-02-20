package com.remonado.solitaire.GUIComponents;

import com.remonado.solitaire.Main;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Menu extends VBox {
    private ImageView tittle;
    private Button start, exit;
    public Menu(Main m) {
        this.getStyleClass().add("menu");
        tittle = new ImageView(new Image("file:src/main/resources/com/remonado/solitaire/Assets/Images/tittle.png"));
        start = new Button();
        ImageView imgStart = new ImageView(new Image("file:src/main/resources/com/remonado/solitaire/Assets/Images/start.png"));
        ImageView imgExit = new ImageView(new Image("file:src/main/resources/com/remonado/solitaire/Assets/Images/exit.png"));
        exit  = new Button();
        start.setGraphic(imgStart);
        exit.setGraphic(imgExit);

        imgStart.getStyleClass().add("menuButton");
        imgExit.getStyleClass().add("menuButton");
        imgStart.setOnMouseClicked(e -> m.startGame());
        imgExit.setOnMouseClicked(e -> Platform.exit());
        this.getChildren().addAll(tittle,imgStart,imgExit);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        startAnim();
    }
    public void startAnim() {
        ScaleTransition st = new ScaleTransition(Duration.millis(4000), tittle);
        st.setToX(1.18);
        st.setToY(1.18);
        st.play();
    }
}
