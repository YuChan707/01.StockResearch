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
import javafx.scene.layout.VBox;

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
            Label noResult = new Label("🔍 No ETFs found for symbol: " + query);
            noResult.setStyle("-fx-font-size: 16px; -fx-text-fill: darkred;");
            children.add(noResult);
            return;
        }

        for (etfs etf_ : list) {
            VBox card = new VBox(5); // vertical spacing between labels
            card.setStyle("""
                        -fx-background-color:rgb(177, 211, 245);
                        -fx-border-radius: 6px;
                        -fx-background-radius: 6px;
                        -fx-padding: 10;
                    """);

            card.getChildren().addAll(
                    new Label("Rank: " + etf_.rank),
                    new Label("Company Name: " + etf_.fundName),
                    new Label("Price: $" + formatNumber(etf_.price)),
                    new Label("Quant Rating: " + etf_.quantRating),
                    new Label("AUM in Billions: $" + (etf_.aumInBillions)),
                    new Label("Frequency: " + etf_.frequency),
                    new Label("Pay-Out Date: " + etf_.payOutDate),
                    new Label("Expense Ratio: " + etf_.expenseRatio + "%")
            );

            children.add(card);
        }
    }


    private String formatNumber(double number) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        return df.format(number);
    }
}
