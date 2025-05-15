package edu.citytech.cst3613;

import java.util.List;
//import java.util.Observable;
import java.util.ResourceBundle;

import edu.citytech.cst3613.dto.stock;
import edu.citytech.cst3613.services.CounterServices;
import edu.citytech.cst3613.services.stockService;

import java.net.URL;
import java.text.DecimalFormat;

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

public class StockController implements Initializable {
    @FXML
    private FlowPane fpNumbers;
    @FXML
    private Label lblCountBy;
    @FXML
    private TreeView<String> tvCounter;
    @FXML
    private ComboBox<String> byStart;

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        byStart.getItems().clear();
        generateLabels("All");
        populateTreeView();
        treeViewNumberSelection();

    }

    // can tak big numbers
    private String commanFormat(double number) {
        String sNumber = number + "";
        double amount = Double.parseDouble(sNumber);
        DecimalFormat formatter = new DecimalFormat("#,###.000");
        return (formatter.format(amount));
    }

    public void generateLabels(String query) {
        ObservableList<Node> children = fpNumbers.getChildren();
        fpNumbers.getChildren().clear();

        var stockService = new stockService();

        List<stock> list = stockService.getStocks(query);

        for (stock stock_ : list) {
            Label label = new Label(stock_.symbol + " | " + commanFormat(stock_.marketCapInMillions) + 
            " | " + commanFormat(stock_.divYield * 100) + "%. ");
            children.add(label);
        }

    }

    private void treeViewNumberSelection() {
        var x = tvCounter.getSelectionModel().selectedItemProperty();

        x.addListener((a, b, c) -> {
            System.out.println("Company by the letter  -  " + c.getValue());
            generateLabels(c.getValue());
        });
    }

    CounterServices counterServices = new CounterServices();

    private void populateTreeView() {
        TreeItem<String> rootItem = new TreeItem<>("Letters");

        var children = rootItem.getChildren();
        rootItem.setExpanded(true);

        var numbers = counterServices.ABC();

        for (Character digit : numbers) {
            TreeItem<String> item = new TreeItem<>(digit + "");
            // byStart.getItems().add(digit.description);
            children.add(item);
        }

        tvCounter.setRoot(rootItem);
    }

    @FXML
    void selectStartWith(ActionEvent event) {
        ComboBox<String> comboBox = (ComboBox<String>) event.getSource();
    }
}
