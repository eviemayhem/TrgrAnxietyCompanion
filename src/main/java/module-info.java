module evieiles.trgranxietyjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens evieiles.trgranxietyjava to javafx.fxml;
    exports evieiles.trgranxietyjava;
}