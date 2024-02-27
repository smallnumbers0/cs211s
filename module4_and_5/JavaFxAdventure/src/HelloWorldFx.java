
import javafx.application.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.control.Button;
import javafx.event.*;


public class HelloWorldFx extends Application {

    private Button button;
    private Text helloText;
    public void start(Stage primaryStage) {

        Pane pane = new FlowPane();
        helloText = new Text("Hello World");
        helloText.setFont(Font.font("Helvetica", 28));
        helloText.setFill(Color.DEEPPINK);
        pane.getChildren().add(helloText);

        button = new Button("Click here");
        button.setOnAction(this::handleButton);
        pane.getChildren().add(button);

        Scene scene = new Scene(pane, 200, 200, Color.OLIVE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }

    public void handleButton(ActionEvent event) {
        helloText.setText("You Clicked");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
