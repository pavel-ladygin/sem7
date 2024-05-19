package org.example.sem7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ObservableList<String> items = FXCollections.observableArrayList("Салат Цезарь", "Салат Греческий", "Пельмени", "Пицца", "Бургер", "Мясная тарелка");
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1300, 700);

        TextField name = new TextField();
        name.setPromptText("Введите свое имя");
        name.setLayoutX(100);
        name.setLayoutY(100);

        ComboBox<Object> comboBox = new ComboBox<>();
        comboBox.setPromptText("Выберете блюдо");
        comboBox.getItems().addAll(items);
        comboBox.setLayoutX(300);
        comboBox.setLayoutY(100);

        TextField count = new TextField();
        count.setPromptText("Количество порций");
        count.setLayoutX(500);
        count.setLayoutY(100);

        Button add = new Button("Добавить блюдо в заказ");
        add.setLayoutX(650);
        add.setLayoutY(100);






        pane.getChildren().addAll(name, comboBox, count, add);
        stage.setTitle("Restaurant");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}