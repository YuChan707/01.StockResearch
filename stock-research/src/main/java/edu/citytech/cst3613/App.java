package edu.citytech.cst3613;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("searchStocks"), 640, 480);
        //scene = new Scene(loadFXML("CounterTreeView"), 700, 700);
        //scene = new Scene(loadFXML("StockTreeView"), 900, 800);
        scene = new Scene(loadFXML("FinalProjectSearchETFs"), 900, 800);
        stage.setScene(scene);
        stage.setTitle("CHEN, YUZHEN: " + new java.util.Date());
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}