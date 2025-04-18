package edu.citytech.cst3613;

//import java.util.Observable;
import java.util.ResourceBundle;

import edu.citytech.cst3613.services.CounterServices;

import java.net.URL;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import javafx.scene.Node;
//import javafx.scene.control.ComboBox;

public class CounterController implements Initializable{
    @FXML
    private FlowPane fpNumbers;
    @FXML
    private Label lblCountBy;
    @FXML
    private TreeView<String> tvCounter;
    @FXML
    private ComboBox<String> byStart;

    @Override
    public void initialize( URL url, ResourceBundle resource){
        byStart.getItems().clear();
        generateLabels(-5, 0);
        populateTreeView();
        treeViewNumberSelection();
        
    }
    
    public void generateLabels(int incrementBy, int startWith){
        ObservableList<Node> children = fpNumbers.getChildren();
        //Label label = new Label("data");
        //children.add(label);

        fpNumbers.getChildren().clear();
        String sNumbers = "";

        /*
        //good bye for loop
        //need use do-while
        for (int i = startWith; i < 200; i++){
            Label label = new Label((i * incrementBy) + "");
            children.add(label);
        }*/
        //declare values for
        int i =0, total = startWith;
        do{
            sNumbers = total + "";
            Label label = new Label(sNumbers);
            children.add(label);
            i++;

            total = total + incrementBy;
        }while(i < 200);
    }

    private void treeViewNumberSelection() {
        var itemSelected = tvCounter.getSelectionModel().selectedItemProperty();

        itemSelected.addListener((a, b, c) -> {
            //System.out.println("Selected: " + c.getValue());
            int number = counterServices.getNumberVersion(c.getValue());

            lblCountBy.setText("Count by " + c.getValue() + ": " + number);
            int starstWith = counterServices.getNumberVersion(byStart.getValue());
            generateLabels(number, starstWith);
        });
    }

    CounterServices counterServices = new CounterServices();
    private void populateTreeView(){
        TreeItem<String> rootItem= new TreeItem<>("Numbers");

        var children = rootItem.getChildren();
        rootItem.setExpanded(true);
        var numbers = counterServices.getNumbers();
        for(CounterServices.Digit digit : numbers){
            TreeItem<String> item = new TreeItem<>(digit.description);
            byStart.getItems().add(digit.description);
            children.add(item);
        }

        tvCounter.setRoot(rootItem);
    }

     @FXML
    void selectStartWith(ActionEvent event) {
        //Object object = (ComboBox) event.getSource();
        ComboBox<String> comboBox = (ComboBox<String>) event.getSource();
        //System.out.println("Event: " + comboBox.getClass().getName());

        //int number = counterServices.getNumberVersion(comboBox.getValue());
        //System.out.println("Event: " + comboBox.getValue() + " " + number);
    }
}
