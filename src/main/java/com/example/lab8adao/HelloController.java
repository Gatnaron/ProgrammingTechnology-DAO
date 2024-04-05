package com.example.lab8adao;

import com.example.lab8adao.DAO.EquipDbDAO;
import com.example.lab8adao.infrastructure.IEquipDAO;
import com.example.lab8adao.model.Equip;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    public Button searchButton;
    public Button deleteButton;
    public Button addButton;
    public TextField idEquip;
    public ListView<String> listEquip;
    public TextField name;
    public TextField status;
    public ComboBox<String> CBSwap;
    public Button ButtonUpDAO;
    private IEquipDAO equipDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        ObservableList<String> dao = FXCollections.observableArrayList("db", "file");
        CBSwap.setItems(dao);
        CBSwap.setValue("db");



    }

    public void changeValueComboBoxHandler(ActionEvent actionEvent){
        //equipDAO = SwapDAO.createTaskDAO(CBSwap.getValue());
    }

    public void ButtonUpDAO(ActionEvent actionEvent){
        equipDAO = SwapDAO.createTaskDAO(CBSwap.getValue());
        if (equipDAO == null) return;

        try {
            var list = equipDAO.getAll().stream().map(Equip::toString).toList();
            System.out.println(list.get(0));
            listEquip.setItems(FXCollections.observableArrayList(list));
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteButtonHandler(ActionEvent actionEvent) throws SQLException {
        equipDAO.delete(Integer.parseInt(idEquip.getText()));
        var list = equipDAO.getAll().stream().map(Equip::toString).toList();
        listEquip.getItems().clear();
        listEquip.setItems(FXCollections.observableArrayList(list));
    }

    public void searchButtonHandler(ActionEvent actionEvent) throws SQLException {
        if (Objects.equals(idEquip.getText(), "")) {
            var list = equipDAO.getAll().stream().map(Equip::toString).toList();
            listEquip.getItems().clear();
            listEquip.setItems(FXCollections.observableArrayList(list));
            return;
        }

        var item = equipDAO.get(Integer.parseInt(idEquip.getText()));

        listEquip.getItems().clear();
        listEquip.setItems(FXCollections.observableArrayList(item.toString()));
    }
    public void addButtonHandler(ActionEvent actionEvent) throws SQLException {
        equipDAO.add(new Equip(name.getText(), status.getText()));
        var list = equipDAO.getAll().stream().map(Equip::toString).toList();

        listEquip.getItems().clear();
        listEquip.setItems(FXCollections.observableArrayList(list));
    }
}