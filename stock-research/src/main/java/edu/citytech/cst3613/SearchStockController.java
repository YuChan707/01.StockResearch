package edu.citytech.cst3613;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class SearchStockController implements Initializable {
    //match what need
    @FXML
    private FlowPane fpMarketCap;

    @FXML
    private FlowPane fpMonths;

    @FXML
    private Label lblTitle;

    @FXML
    private ToggleGroup tgMarketCap;

     @FXML
    private FlowPane fpStocks;
    

    ObservableList<Node> stocks;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //ObservableList<Node> stocks = fpStocks.getChildren();
        stocks = fpStocks.getChildren();
        count(0, 1);
    }
    public void count(int i, int multipleOf){
        for (Node node : stocks) {
            Label label = (Label)node;
            label.setText(( (i = i + 1) * multipleOf) + " ");
        }
    }

    @FXML
    void monthSelection(ActionEvent event) {
        var checkBox = (CheckBox)event.getSource();
        
        System.out.println(event);
        System.out.println(checkBox.getUserData());

        int monthN = Integer.parseInt(checkBox.getUserData().toString());

        if(monthN == 0){
                boolean isSelected = checkBox.isSelected();
                selectAllMoth(isSelected);//<---------------------------------------
            return;
        }

        for (Node node: stocks){
            Label label = (Label)node;
            //int number = Integer.parseInt(checkBox.getUserData().toString());
            int number = Integer.parseInt(label.getText().trim());

            label.getStyleClass().remove("month-color");
            if(number % monthN == 0){
                label.getStyleClass().add("month-color");
            }
        }
    }

    private void selectAllMoth(boolean isSelected){
        ObservableList<Node> months = fpMonths.getChildren();

        for (Node node: months){
            var checkBox = (CheckBox)node;//<--------------------------------------
            checkBox.setSelected(isSelected);
        }
    }
    
    @FXML
    void selectMarketCap(ActionEvent event){
        //System.out.println("Market Cap: " + event);
        Node node = (Node)event.getSource();
        String sUserData = (String)node.getUserData().toString();
        int multipleOf = Integer.parseInt(sUserData);
        System.out.println(event);
        count(0, multipleOf);
    }

}
