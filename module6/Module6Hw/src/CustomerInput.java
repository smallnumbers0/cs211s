//Module 6 HW CS211s
//Gevilee Mari, Jacky Choi

import java.io.*;
import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.Scanner;

public class CustomerInput extends Application {
    private Stage primaryStage;
    private Text statusText, resultText;
    private Button uploadButton;
    private final static Font RESULT_FONT = Font.font("Helvetica", 24);
    private final static Font INPUT_FONT = Font.font("Helvetica", 20);

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox primaryBox = new VBox();
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(20);
        primaryBox.setStyle("-fx-background-color: white");

        VBox uploadBox = new VBox();
        uploadBox.setAlignment(Pos.CENTER);
        uploadBox.setSpacing(20);
        Text uploadLabel = new Text("Upload a comma-separated file with customer data.");
        uploadLabel.setFont(INPUT_FONT);
        uploadButton = new Button("Upload data");
        uploadButton.setOnAction(this::processDataUpload);

        uploadBox.getChildren().add(uploadLabel);
        uploadBox.getChildren().add(uploadButton);
        primaryBox.getChildren().add(uploadBox);

        VBox resultsBox = new VBox();
        resultsBox.setAlignment(Pos.CENTER);
        resultsBox.setSpacing(20);
        statusText = new Text("");
        statusText.setVisible(false);
        statusText.setFont(RESULT_FONT);
        statusText.setFill(Color.RED);
        resultText = new Text("");
        resultText.setVisible(false);
        resultText.setFont(RESULT_FONT);
        resultsBox.getChildren().add(statusText);
        resultsBox.getChildren().add(resultText);
        primaryBox.getChildren().add(resultsBox);

        Scene scene = new Scene(primaryBox, 800, 500, Color.TRANSPARENT); //We changed this size because text was going off the edge
        primaryStage.setTitle("Customer Data Upload");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void processDataUpload(ActionEvent event) {
        statusText.setVisible(false);
        resultText.setVisible(false);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        parseFile(file);
    }

    private void parseFile(File file) {
       // ??? YOUR CODE HERE
        if (file == null) {
            setStatusText("No file selected.");
            return;
        }
        List<Customer> customers = new ArrayList<>(); // Initialize the list of customers
        int totalOrders = 0; // Initialize total number of orders

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                //bad situation2: checking name for "@"
                String id = data[0];
                try {
                    checkName(id);
                } catch (AtSymbolException ex) {
                    setStatusText(ex.getMessage());
                    return;
                }

                int orders;
                try {
                    orders = Integer.parseInt(data[1]);
                } catch (NumberFormatException e) {
                    setStatusText("Error: Non-Integer detected: " + data[1] + " in orders for \"" + id + "\"");
                    return;
                }

                Customer customer = new Customer(id, orders); //Customer object to list
                customers.add(customer);
                totalOrders += orders;


            }
            // Text display
            setStatusText("Success! " + " Customer objects: "+ customers.size());
            setResultText("Total orders: " + totalOrders);
            disableUpload();

        } catch (FileNotFoundException e) {
            setStatusText("File not found!");
        }
    }

    private void setStatusText(String text) {
        statusText.setText(text);
        statusText.setVisible(true);
    }

    private void setResultText(String text) {
        resultText.setText(text);
        resultText.setVisible(true);
    }

    private void disableUpload() {
        uploadButton.setDisable(true);
    }

//    class AtSymbolException extends Exception {
//        public static final String MESSAGE = "Name is invalid";
//
//        public AtSymbolException() {
//            super(MESSAGE);
//        }
//        public AtSymbolException(String message) {
//            super(message);
//        }
//    }
    private void checkName(String name) throws AtSymbolException {
        if(name.contains("@")) {
            throw new AtSymbolException(name + " is not a valid name. It should not contain an @.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}