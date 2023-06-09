module com.example.javafx1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;
    requires org.controlsfx.controls;
    requires com.fasterxml.jackson.databind;

  /*  requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
*/
    opens com.example.javafx1 to javafx.fxml;
    exports com.example.javafx1;

    opens CircleMover to javafx.fxml;
    exports CircleMover;

    opens SceneSwithing to javafx.fxml;
    exports SceneSwithing;

    opens UserLogin to javafx.fxml;
    exports UserLogin;

    opens LogoutWindow to javafx.fxml;
    exports LogoutWindow;

    opens TextFieldVerify to javafx.fxml;
    exports TextFieldVerify;

    opens CheckBox to javafx.fxml;
    exports CheckBox;

    opens RadioButton to javafx.fxml;
    exports RadioButton;

    opens newDatePicker to javafx.fxml;
    exports newDatePicker;

    opens Color_Picker to javafx.fxml;
    exports Color_Picker;

    opens Choice_Box to javafx.fxml;
    exports Choice_Box;

    opens Sliders to javafx.fxml;
    exports Sliders;

    opens ProgressBars to javafx.fxml;
    exports ProgressBars;

    opens Spinners to javafx.fxml;
    exports Spinners;

    opens ListViews to javafx.fxml;
    exports ListViews;

    opens TreeViews to javafx.fxml;
    exports TreeViews;

    opens MenuBars to javafx.fxml;
    exports MenuBars;

    opens FlowPanes to javafx.fxml;
    exports FlowPanes;

    opens KeyEvent to javafx.fxml;
    exports KeyEvent;

    opens Animations to javafx.fxml;
    exports Animations;

    opens MediaVieww to javafx.fxml;
    exports MediaVieww;

    opens WebVieww to javafx.fxml;
    exports WebVieww;

    opens MP3_Player to javafx.fxml;
    exports MP3_Player;

    opens webBrowser to javafx.fxml;
    exports webBrowser;

    opens javafx.scene.web to javafx.fxml;


}