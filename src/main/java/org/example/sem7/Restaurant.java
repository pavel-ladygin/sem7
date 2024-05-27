package org.example.sem7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Restaurant extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ObservableList<String> items = FXCollections.observableArrayList("Салат Цезарь", "Салат Греческий", "Пельмени", "Пицца", "Бургер", "Мясная тарелка");
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1300, 700);

        TextField Name = new TextField();
        Name.setPromptText("Введите свое имя");
        Name.setLayoutX(100);
        Name.setLayoutY(100);

        ComboBox<String> comboBox = new ComboBox<>();
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

        ObservableList<String> list = FXCollections.observableArrayList();

        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (comboBox.getValue() != null){
                    String name = Name.getText();
                    String dish = comboBox.getValue();
                    String count1 = count.getText();
                    Order order = new Order(name, dish, count1);
                    list.add(order.toString());

                    Name.clear();
                    count.clear();
                    comboBox.setValue(null);
                }
            }
        });

        ListView<String> listOrder = new ListView<>(list);
        listOrder.setLayoutX(300);
        listOrder.setLayoutY(300);

        listOrder.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (listOrder.getSelectionModel().getSelectedItems() != null){
                    list.remove(listOrder.getSelectionModel().getSelectedItem());
                }

            }
        });


        pane.getChildren().addAll(Name, comboBox, count, add, listOrder);
        stage.setTitle("Restaurant");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}