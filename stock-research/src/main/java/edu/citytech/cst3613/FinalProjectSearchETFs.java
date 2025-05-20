package edu.citytech.cst3613;

import edu.citytech.cst3613.dto.etfs;
import edu.citytech.cst3613.services.etfsServices;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.text.DecimalFormat;
import java.util.List;

public class FinalProjectSearchETFs {

    @FXML
    private TextField tfGetSymbol;

    @FXML
    private Button btnSearch;

    @FXML
    private FlowPane fpInformation;

    private etfsServices service;

    @FXML
    public void initialize() {
        // Initialize service and attach event
        service = new etfsServices();
        btnSearch.setOnAction(this::handleSearch);
    }

    private void handleSearch(ActionEvent event) {
        String query = tfGetSymbol.getText().trim();

        if (query.isEmpty()) {
            displayMessage("⚠ Please enter a symbol to search.");
        } else {
            generateLabels(query);
        }
    }

    private void displayMessage(String message) {
        fpInformation.getChildren().clear();
        fpInformation.getChildren().add(new Label(message));
    }

    public void generateLabels(String query) {
        ObservableList<Node> children = fpInformation.getChildren();
        children.clear();

        List<etfs> list = service.getETFs(query);

        if (list == null || list.isEmpty()) {
            children.add(new Label("🔍 No ETFs found for symbol: " + query));
            return;
        }

        for (etfs etf_ : list) {
            children.add(new Label("Rank: " + etf_.rank));
            children.add(new Label("Fund Name: " + etf_.fundName));
            children.add(new Label("Symbol: " + etf_.symbol));
            children.add(new Label("Price: $" + formatNumber(etf_.price)));
            children.add(new Label("Quant Rating: " + etf_.quantRating));
            children.add(new Label("AUM In Billion: $" + formatNumber(etf_.aumInBillion)));
            children.add(new Label("Frequency: " + etf_.frequency));
            children.add(new Label("Pay-Out Date: " + etf_.payOutDate));
            children.add(new Label("Expense Ratio: " + etf_.expenseRatio));

            Label spacer = new Label("                                      ");
            spacer.setStyle("-fx-padding: 10 0 10 0;");
            children.add(spacer);
        }
    }

    private String formatNumber(double number) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        return df.format(number);
    }
}
