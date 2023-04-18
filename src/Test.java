import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MonopolyBoardGame extends Application {

	// Number of rows and columns on the board
	private static final int BOARD_SIZE = 10;
	// Size of each cell on the board
	private static final int CELL_SIZE = 60;
	// Player's current position on the board
	private final IntegerProperty playerPosition = new SimpleIntegerProperty(0);

	// Image paths
	private static final String GO_IMAGE_PATH = "images/go.png";
	private static final String JAIL_IMAGE_PATH = "images/jail.png";
	private static final String FREE_PARKING_IMAGE_PATH = "images/free_parking.png";
	private static final String GO_TO_JAIL_IMAGE_PATH = "images/go_to_jail.png";
	private static final String COMMUNITY_CHEST_IMAGE_PATH = "images/community_chest.png";
	private static final String CHANCE_IMAGE_PATH = "images/chance.png";
	private static final String RAILROAD_IMAGE_PATH = "images/railroad.png";
	private static final String TAX_IMAGE_PATH = "images/tax.png";
	private static final String WATER_IMAGE_PATH = "images/water_company.png";
	private static final String ELECTRIC_IMAGE_PATH = "images/electric_company.png";

	@Override
	public void start(Stage primaryStage) {
		// Create the board grid
		GridPane board = createBoard();
		// Create player's position label
		Label positionLabel = createPositionLabel();
		// Create dice roll button
		Button rollButton = createRollButton();
		// Create player name input field
		TextField nameInput = createNameInput();

		// Set up the layout
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(board, positionLabel, rollButton, nameInput);

		// Set up the scene
		Scene scene = new Scene(layout, BOARD_SIZE * CELL_SIZE + 20, BOARD_SIZE * CELL_SIZE + 100);
		primaryStage.setTitle("Monopoly Board Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// Creates the Monopoly board grid
	private GridPane createBoard() {
		GridPane board = new GridPane();
		board.setAlignment(Pos.CENTER);
		board.setGridLinesVisible(true);

		// Create cells for the board
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				// Create cell rectangle
				Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
				cell.setFill(Color.WHITE);
				cell.setStroke(Color.BLACK);

				// Add text to cell
				String text = "Cell " + (row * BOARD_SIZE + col + 1);
				Label label = new Label(text);
				label.setWrapText(true);
				label.setMaxWidth(CELL_SIZE);
				label.setAlignment(Pos.CENTER);
				VBox cellContents = new VBox(cell, label);
				cellContents.setAlignment(Pos.CENTER);

				// Add image to specific cells
				ImageView imageView = null;
				if (row == 0 && col == 0) {
					imageView = createImageView(FREE_PARKING_IMAGE_PATH);
				} else if (row == 0 && col == BOARD_SIZE - 1) {
					imageView = createImageView(GO_TO_JAIL_IMAGE_PATH);
				} else if (row == BOARD_SIZE - 1 && col == 0) {
					imageView = createImageView(JAIL_IMAGE_PATH);
				} else if (row == BOARD_SIZE - 1 && col == BOARD_SIZE - 1) {
					imageView = createImageView(GO_IMAGE_PATH);
				} else if (row == 0 && col == 2) {
					imageView = createImageView(COMMUNITY_CHEST_IMAGE_PATH);
				} else if (row == 0 && col == 7) {
					imageView = createImageView(CHANCE_IMAGE_PATH);
				} else if (row == 2 && col == 0) {
					imageView = createImageView(RAILROAD_IMAGE_PATH);
				} else if (row == 2 && col == 9) {
					imageView = createImageView(RAILROAD_IMAGE_PATH);
				} else if (row == 7 && col == 0) {
					imageView = createImageView(WATER_IMAGE_PATH);
				} else if (row == 7 && col == 9) {
					imageView = createImageView(ELECTRIC_IMAGE_PATH);
				} else if (row == BOARD_SIZE - 1 && col == 2) {
					imageView = createImageView(TAX_IMAGE_PATH);
				}

				// Add cell contents to the board
				if (imageView != null) {
					StackPane cellStackPane = new StackPane(cellContents, imageView);
					board.add(cellStackPane, col, row);
				} else {
					board.add(cellContents, col, row);
				}
			}
		}

		return board;
	}

	// Creates an ImageView with the specified image path
	private ImageView createImageView(String imagePath) {
		Image image = new Image(imagePath);
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(CELL_SIZE * 0.8);
		imageView.setFitWidth(CELL_SIZE * 0.8);
		return imageView;
	}

	// Creates the player's position label
	private Label createPositionLabel() {
		Label positionLabel = new Label();
		positionLabel.textProperty().bind(playerPosition.asString("Player's Position: %d"));
		return positionLabel;
	}

	// Creates the roll dice button
	private Button createRollButton() {
		Button rollButton = new Button("Roll Dice");
		rollButton.setOnAction(event -> {
			// Update player's position
			playerPosition.set(playerPosition.get() + 1);
		});
		return rollButton;
	}

	// Creates an input field for player name
	private TextField createNameInput() {
		TextField nameInput = new TextField();
		nameInput.setPromptText("Enter player name");
		return nameInput;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
