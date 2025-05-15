package edu.citytech.cst3613;

import java.util.List;
//import java.util.Observable;
import java.util.ResourceBundle;

import edu.citytech.cst3613.dto.stock;
import edu.citytech.cst3613.services.CounterServices;
import edu.citytech.cst3613.services.stockService;

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

public class StockController implements Initializable{
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
        fpNumbers.getChildren().clear();

        var stockService = new stockService();

        List<stock> list = stockService.getStocks();

        for(stock stock_ : list){
            Label label = new Label(stock_.symbol);
            children.add(label);
        }


    }

    private void treeViewNumberSelection() {
        var itemSelected = tvCounter.getSelectionModel().selectedItemProperty();

        itemSelected.addListener((a, b, c) -> {
            //System.out.println("Selected: " + c.getValue());
            int number = counterServices.getNumberVersion(c.getValue());

            lblCountBy.setText("Company by the letter" + c.getValue() + ": " + number);
            int starstWith = counterServices.getNumberVersion(byStart.getValue());
            generateLabels(number, starstWith);
        });
    }

    CounterServices counterServices = new CounterServices();

    private void populateTreeView(){
        TreeItem<String> rootItem= new TreeItem<>("Letters");

        var children = rootItem.getChildren();
        rootItem.setExpanded(true);

        var numbers = counterServices.ABC();

        for(Character digit : numbers){
            TreeItem<String> item = new TreeItem<>(digit + "");
            //byStart.getItems().add(digit.description);
            children.add(item);
        }

        tvCounter.setRoot(rootItem);
    }

     @FXML
    void selectStartWith(ActionEvent event) {
        ComboBox<String> comboBox = (ComboBox<String>) event.getSource();
    }
}
