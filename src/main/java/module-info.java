module cz.vse.stae07 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;




    opens cz.vse.stae07.main to javafx.fxml;
    exports cz.vse.stae07.main;
}