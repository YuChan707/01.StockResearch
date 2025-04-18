package edu.citytech.cst3613;

import java.util.Observable;
import java.util.ResourceBundle;

import edu.citytech.cst3613.services.CounterServices;

// Removed unused import for org.w3c.dom.css.Counter

import java.net.URL;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import javafx.scene.Node;

public class CounterController implements Initializable{
    @FXML
    private FlowPane fpNumbers;
    @FXML
    private Label lblCountBy;
    @FXML
    private TreeView<String> tvCounter;

    @Override
    public void initialize( URL url, ResourceBundle resource){
        ObservableList<Node> children = fpNumbers.getChildren();
        
        //Label label = new Label("data");
        //children.add(label);
        for (int i = 0; i < 150; i++){
            //Label label = new Label(String.valueOf(i));
            Label label = new Label(i + "");
            children.add(label);
        }

        populateTreeView();
        treeViewNumberSelection();
    }
    
    private void treeViewNumberSelection() {
        var itemSelected = tvCounter.getSelectionModel().selectedItemProperty();
        itemSelected.addListener((a, b, c) -> {
            //System.out.println("Selected: " + c.getValue());
            lblCountBy.setText("Count by " + c.getValue());
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
            children.add(item);
        }

        tvCounter.setRoot(rootItem);
    }
}
