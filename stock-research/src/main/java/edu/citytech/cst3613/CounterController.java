package edu.citytech.cst3613;

import java.util.Observable;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import javafx.scene.Node;

public class CounterController implements Initializable{
    @FXML
    private FlowPane fpNumbers;
    @FXML
    private Label lblCountBy;
    @FXML
    private TreeView<?> tvCounter;
    @Override
    public void initialize( URL url, ResourceBundle resource){
        ObservableList<Node> children = fpNumbers.getChildren();
        
        //Label label = new Label("data");
        //children.add(label);
        for (int i = 0; i < 15; i++){
            Label label = new Label(String.valueOf(i));
            children.add(label);
        }
    }
}
