module com.example.javafx1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

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


}