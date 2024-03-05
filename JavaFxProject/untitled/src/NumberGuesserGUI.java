//Number Guesser with Java FX Gui

//CS 211s Gevilee Mari, Jacky Choi

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.Random;
import static java.lang.Integer.parseInt;



public class NumberGuesserGUI extends Application {

  private Text messageTop;
  private Text messageBottom;
  private TextField guess;
  private Button playAgain;
  
  private Button submitGuess;

  private int computerGuess;
//Load imageViews... 
  private ImageView images = new ImageView();
  
  @Override
  public void start(Stage primaryStage) {
	  computerGuess = computerGuess();
	  
      DropShadow ds = new DropShadow();
      ds.setOffsetY(3.0f);
      ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

      VBox vbox = new VBox();

      vbox.setAlignment(Pos.CENTER);

      vbox.setStyle("-fx-background-image: url(matrix.png);");
      vbox.setPadding(new Insets(10)); // Add some padding around the VBox

      messageTop = new Text("Number Guesser\n");
      messageTop.setFont(Font.font("Impact", FontWeight.BOLD, 28));
      messageTop.setEffect(ds);
      messageTop.setCache(true);
      messageTop.setX(10.0f);
      messageTop.setY(270.0f);
      messageTop.setFill(Color.DARKVIOLET);
      messageTop.setFontSmoothingType(FontSmoothingType.GRAY);

      messageTop.setTextAlignment(TextAlignment.CENTER);
      vbox.getChildren().add(messageTop);


      messageBottom = new Text("Enter a guess (1-100): \n");
      messageBottom.setFont(Font.font("Impact", FontWeight.BOLD, 28));
      messageBottom.setFill(Color.RED);

      messageBottom.setTextAlignment(TextAlignment.CENTER);

      vbox.getChildren().add(messageBottom);

      guess = new TextField();
      guess.setOnAction(this::processGuess);
      guess.setMaxWidth(200);
      vbox.getChildren().add(guess);

      submitGuess = new Button("Submit");
      submitGuess.setOnAction(this::processGuess);
      submitGuess.setTextFill(Color.WHITE);
      submitGuess.setFont(Font.font(20));
      submitGuess.setStyle("-fx-background-color: red;" + "-fx-background-radius: 5px;" + "-fx-padding: 10px 20px; "  + "-fx-font-size: 16px;");

      vbox.getChildren().add(submitGuess);

      playAgain = new Button("Play Again");
      playAgain.setOnAction(this::playAgain);
      playAgain.setVisible(false);
      playAgain.setStyle("-fx-background-color: red;" + "-fx-background-radius: 5px;" + "-fx-padding: 10px 20px; "  + "-fx-font-size: 16px;");
      vbox.getChildren().add(playAgain);

  	  vbox.getChildren().add(images);
      
      images.setVisible(false);
  
      Scene scene = new Scene(vbox, 800, 700, Color.WHITE);
      primaryStage.setTitle("Number Guesser");
      primaryStage.setScene(scene);
      primaryStage.show();

  }

  public void processGuess(ActionEvent event) {
      String textInput = guess.getText();
   
      if(textInput.isEmpty()) {
          messageTop.setText("You did not enter a guess!");

//Display no guess image              
          setImageProperties(images, "file:images/noGuess.png");  
          images.setVisible(true);
       
      }
      else {
          int userGuess = parseInt(textInput);
          if (userGuess < computerGuess) {
              messageTop.setText("Your guess was too low \n");
//Display guess higher image     
              setImageProperties(images, "file:images/up.png");
              images.setVisible(true);
            
              guess.clear();
          } else if (userGuess > computerGuess) {
              messageTop.setText("Your guess was too high \n");
              
//Display guess lower image              
              setImageProperties(images, "file:images/down.png");
              images.setVisible(true);

              guess.clear();
          } else {
              messageTop.setText(userGuess + " was the correct number! \n");
              messageBottom.setText("Congrats! \n");
              
//Display guess correct image
              setImageProperties(images, "file:images/thumbsUp.jpg");
              images.setVisible(true);
              
              submitGuess.setVisible(false);
              playAgain.setVisible(true);
          }
      }

  }

  private static int computerGuess() {
      Random random = new Random();
      return random.nextInt(100) + 1;
  }

  private void playAgain(ActionEvent event) {
      computerGuess = computerGuess();
      messageTop.setText("Number Guesser \n");
      messageBottom.setText("Enter a guess (1-100):\n");
      guess.clear();

      resetImageVisibility(); 
      
      playAgain.setVisible(false);
      submitGuess.setVisible(true);
      
  }
 
private void setImageProperties(ImageView imageView, String imagePath) {
      Image image = new Image(imagePath, 0, 0, true, true);
      imageView.setImage(image);
      imageView.setFitWidth(100);
      imageView.setFitHeight(100);
      imageView.setVisible(false);
}
private void resetImageVisibility() {
    images.setVisible(false);
}

  
  
  public static void main(String[] args) {
      launch(args);
  }
}
