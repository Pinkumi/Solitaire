module com.remonado.solitaire {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.smartcardio;


    opens com.remonado.solitaire to javafx.fxml;
    exports com.remonado.solitaire;
    exports com.remonado.solitaire.GUIComponents;
    opens com.remonado.solitaire.GUIComponents to javafx.fxml;
}