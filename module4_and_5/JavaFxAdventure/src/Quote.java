//Number Guesser Program using Java FX for GUI
//Jacky Choi

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quote extends Application {
    private Button button;
    private List<String> quoteList;
    private Random random;
    private Text quote;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        quote = new Text("“To give anything less than your best is to sacrifice the gift.”\n— Steve Prefontaine");

        quote.setId("quote-decoration");
        quote.setWrappingWidth(380);
        quote.setTextAlignment(TextAlignment.CENTER);
        vbox.getChildren().add(quote);
        vbox.setId("container-color");

        button = new Button("Get New Quote");
        button.setOnAction(this::handleButton);
        button.setId("button-decoration");
        vbox.getChildren().add(button);
        vbox.setAlignment(Pos.CENTER);


        Scene scene = new Scene(vbox, 700, 500);
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quote");
        primaryStage.show();
    }

    public void updateQuote() { //sometimes, the same quote is displayed when button clicked
        int quoteIndex = 0; //maybe I should keep arraylist in another function to and pass a value to keep track of the quote
        random = new Random();

        quoteList = new ArrayList<>();
        quoteList.add("\"It ain’t about how hard you hit. It’s about how hard you can get hit and keep moving forward; how much you can take and keep moving forward. That’s how winning is done!” - Rocky Balboa");
        quoteList.add("\"Honor Is In The Heart, Not In The Name.” – Yasuo");
        quoteList.add("\"Who's gonna carry the boats? - David Goggins");

        quoteIndex = random.nextInt(quoteList.size());
        quote.setText(quoteList.get(quoteIndex));

    }
    public void handleButton(ActionEvent event) {
        updateQuote();
    }
}
