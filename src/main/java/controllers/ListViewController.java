package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Set;

public class ListViewController {

    @FXML
    private ListView listView;
    private Set<String> stringSet;
    ObservableList observableList = FXCollections.observableArrayList();

    public ListViewController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(("/views/listView.fxml")));
        fxmlLoader.setController(this);
        try {
            Parent parent = (Parent)fxmlLoader.load();
            Scene scene = new Scene(parent, 400, 500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setListView() {
        stringSet.add("String 1");
        stringSet.add("String 2");
        stringSet.add("String 3");
        stringSet.add("String 4");
        observableList.setAll(stringSet);
        listView.setItems(observableList);
        listView.setCellFactory(new Callback<ListView<String>, javafx.scene.control.ListCell<String>>(){
            @Override
            public ListCell<String> call(ListView<String> listView) {
                return new ListCell();
            }
        });
    }
}
