module br.edu.femass.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens br.edu.femass.biblioteca to javafx.fxml;
    exports br.edu.femass.biblioteca;
    exports br.edu.femass.biblioteca.gui;
    exports br.edu.femass.biblioteca.model;
    exports br.edu.femass.biblioteca.dao;
    opens br.edu.femass.biblioteca.gui to javafx.fxml;
}