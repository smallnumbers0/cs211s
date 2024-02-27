import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;


public class CharacterCreator extends Application {

    private Button button;
    private List<Character> characterList = new ArrayList<>();
    private ListView<Text> characterListView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {

        VBox vbox = new VBox(5);
        characterListView.setPrefSize(400, 400);
        vbox.getChildren().add(characterListView);

        Button addCharacterButton = new Button("Add Character");
        addCharacterButton.setOnAction(this::CharacterInitialization);
        vbox.getChildren().add(addCharacterButton);

        Scene scene = new Scene(vbox, 700, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Basic Character Creation Simulation");
        primaryStage.show();
    }


    public void CharacterInitialization(ActionEvent event) {
        Dialog<Character> dialog = new Dialog<>();
        dialog.setTitle("Add Character Form");

        TextField nameInput = new TextField();
        nameInput.setPromptText("Character Name: ");

        TextField levelInput = new TextField();
        levelInput.setPromptText("Character level: ");

        TextField healthInput = new TextField();
        healthInput.setPromptText("HP: ");

        ToggleGroup classToggleGroup = new ToggleGroup();

        RadioButton warriorRadioButton = new RadioButton("Warrior");
        warriorRadioButton.setToggleGroup(classToggleGroup);

        RadioButton archerRadioButton = new RadioButton("Archer");
        archerRadioButton.setToggleGroup(classToggleGroup);

        RadioButton mageRadioButton = new RadioButton("Mage");
        mageRadioButton.setToggleGroup(classToggleGroup);

        VBox classInput = new VBox(10, warriorRadioButton, archerRadioButton, mageRadioButton);

        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        dialog.getDialogPane().setContent(new VBox(8, nameInput, levelInput, healthInput, classInput));

        dialog.setResultConverter(button -> {
            if (button == addButton) {
                String name = nameInput.getText();
                int level = Integer.parseInt(levelInput.getText());
                int health = Integer.parseInt(healthInput.getText());
                String characterClass = ((RadioButton) classToggleGroup.getSelectedToggle()).getText();
                Character character = new Character(name, level, health, characterClass);
                characterListView.getItems().add(character.getText());

                return character;
            }
            return null;
        });
        dialog.showAndWait().ifPresent(character -> {
            characterList.add(character);

        });
    }
    public static void main(String[] args) {
        launch(args);
    }

    public class Character {
        private String name;
        private int level;
        private int health;
        private String characterClass;

        public Character(String name, int level, int health, String characterClass) {
            this.name = name;
            this.level = level;
            this.health = health;
            this.characterClass = characterClass;
        }

        public Text getText() {
            return new Text(name + " - Level: " + level + ", HP: " + health + ", Class: " + characterClass);
        }
    }
}