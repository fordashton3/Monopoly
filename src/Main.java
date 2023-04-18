import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	private static final int BOARD_WIDTH = 960;
	private static final int BOARD_HEIGHT = 960;

	private ImageView player1Piece;
	// Add more ImageView variables for player pieces similarly

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// Create root pane
		AnchorPane root = new AnchorPane();
		root.setPrefSize(BOARD_WIDTH, BOARD_HEIGHT);

		// Set background image
		BackgroundImage backgroundImage = new BackgroundImage(
				new Image("file:monopoly_board.png"),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(BOARD_WIDTH, BOARD_HEIGHT, false, false, false, false)
		);
		root.setBackground(new Background(backgroundImage));

		// Add game board spaces
		Rectangle space1 = createBoardSpace(130, 542, 100, 130, Color.RED, "GO");
		root.getChildren().add(space1);

		Rectangle space2 = createBoardSpace(242, 542, 100, 100, Color.GREEN, "MEDITERRANEAN AVE");
		ImageView mediterraneanAveImage = new ImageView("file:mediterranean_ave.jpg");
		mediterraneanAveImage.setFitWidth(80);
		mediterraneanAveImage.setFitHeight(60);
		Label mediterraneanAveLabel = createBoardLabel(247, 562, 90, 60, Pos.CENTER, "BLACK", "Bold 12", "MEDITERRANEAN AVE", mediterraneanAveImage);
		root.getChildren().addAll(space2, mediterraneanAveLabel);

		// Add buttons for actions
		Button rollDiceButton = createButton("Roll Dice", 450, 600);
		rollDiceButton.setOnAction(event -> rollDice());
		Button endTurnButton = createButton("End Turn", 550, 600);
		endTurnButton.setOnAction(event -> endTurn());
		root.getChildren().addAll(rollDiceButton, endTurnButton);

		// Add player pieces
		player1Piece = createPlayerPiece("file:player1_piece.png", 150, 600);
		// Add more player pieces similarly

		// Create scene
		Scene scene = new Scene(root);
		primaryStage.setTitle("Monopoly");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Rectangle createBoardSpace(double x, double y, double width, double height, Color fill, String text) {
		Rectangle space = new Rectangle(x, y, width, height);
		space.setFill(fill);
		space.setStroke(Color.BLACK);
		Label label = createBoardLabel(x + 20, y + 20, width - 40, height - 40, Pos.CENTER, "WHITE", "Bold 20", text, null);
		return space;
	}

	private Label createBoardLabel(double x, double y, double width, double height, Pos alignment, String textFill, String font, String text, ImageView graphic) {
		Label label = new Label(text);
		label.setLayoutX(x);
		label.setLayoutY(y);
		label.setPrefSize(width, height);
		label.setAlignment(alignment);
		label.setTextFill(Color.valueOf(textFill));
		label.setFont(Font.font(font));
		if (graphic != null) {
			label.setGraphic(graphic);
			label.setGraphicTextGap(10);
		}
		return label;
	}
	private Button createButton(String text, double x, double y) {
		Button button = new Button(text);
		button.setLayoutX(x);
		button.setLayoutY(y);
		button.setPrefSize(100, 40);
		return button;
	}

	private ImageView createPlayerPiece(String imageUrl, double x, double y) {
		ImageView imageView = new ImageView(imageUrl);
		imageView.setFitWidth(40);
		imageView.setFitHeight(40);
		imageView.setLayoutX(x);
		imageView.setLayoutY(y);
		return imageView;
	}

	private void rollDice() {
		// Implement logic for rolling dice and updating game state
	}

	private void endTurn() {
		// Implement logic for ending current player's turn and updating game state
	}

}
