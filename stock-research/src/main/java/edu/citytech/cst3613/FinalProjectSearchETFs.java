package edu.citytech.cst3613;

import java.util.List;
//import java.util.Observable;
import java.util.ResourceBundle;

import edu.citytech.cst3613.dto.etfs;
import edu.citytech.cst3613.services.CounterServices;
import edu.citytech.cst3613.services.etfsServices;

import java.net.URL;
import java.text.DecimalFormat;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import javafx.scene.Node;


public class FinalProjectSearchETFs implements Initializable {
        //need delete - start
    @FXML
    private FlowPane fpNumbers;
    @FXML
    private Label lblCountBy;
    @FXML
    private TreeView<String> tvCounter;
    @FXML
    private ComboBox<String> byStart;
        //need delete - end
        @FXML
    private Button btnSearch;

    @FXML
    private FlowPane fpInformation;

    @FXML
    private Label lblInformation;

    @FXML
    private Label lblSubtitle;

    @FXML
    private Label lblTitle;

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        byStart.getItems().clear();
        generateLabels("All");
        populateTreeView();

    }

    private etfsServices theETFs_Service = new etfsServices();

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

        var etfsServices_ = new etfsServices();

        List<etfs> list = etfsServices_.getETFs(query);

        for (etfs etf_ : list) {
            Label label1 = new Label("Rank : "+ etf_.rank);
            children.add(label1);
            Label label2 = new Label("FundName : "+ etf_.fundName);
            children.add(label2);
            Label label3 = new Label("Price : " + commanFormat(etf_.price));
            children.add(label3);
            Label label4 = new Label("Quant Rating : " + etf_.quantRating);
            children.add(label4);
            Label label5 = new Label("Aum In Billion : " + commanFormat(etf_.aumInBillion));
            children.add(label5);
            Label label6 = new Label("Frequency : " + etf_.frequency);
            children.add(label6);
            Label label7 = new Label("Pay-Out Date : " + etf_.payOutDate);
            children.add(label7);
            Label label8 = new Label("Expense Ratio : " + etf_.expenseRatio);
            children.add(label8);
        }

    }

    CounterServices counterServices = new CounterServices();

    private void populateTreeView() {
        TreeItem<String> rootItem = new TreeItem<>("Symbol");

        var children = rootItem.getChildren();
        rootItem.setExpanded(true);

        var numbers = CounterServices.ABC();
        var mapping = theETFs_Service.getMap();

        for (Character digit : numbers) {
            if(mapping.containsKey(digit)){
                int count = mapping.get(digit);

                TreeItem<String> item = new TreeItem<>(digit + " has " + count + " stocks");
                children.add(item);
            }
        }

        tvCounter.setRoot(rootItem);
    }
}
