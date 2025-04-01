package edu.citytech.cst3613;

import java.io.IOException;
import javafx.fxml.FXML;

/* 
@FXML
void selectMarketCap(ActionEvent event){
    System.out.println("Market Cap: " + event);
}
*/
public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
