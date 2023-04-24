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
import Objects.*;

public class Main extends Application {

	// Number of rows and columns on the board
	private static final int BOARD_SIZE = 11;
	// Size of each cell on the board
	private static final int CELL_SIZE = 60;
	// Player's current position on the board
	private final IntegerProperty playerPosition = new SimpleIntegerProperty(0);

	// Image paths
	private static final String GO_IMAGE_PATH = "images\\go.png";
	private static final String JAIL_IMAGE_PATH = "images\\jail.png";
	private static final String FREE_PARKING_IMAGE_PATH = "images\\free_parking.png";
	private static final String GO_TO_JAIL_IMAGE_PATH = "images\\go_to_jail.png";
	private static final String COMMUNITY_CHEST_IMAGE_PATH = "images\\community_chest.png";
	private static final String CHANCE_IMAGE_PATH = "images\\chance.png";
	private static final String RAILROAD_IMAGE_PATH = "images\\railroad.png";
	private static final String WATER_IMAGE_PATH = "images\\water_works.png";
	private static final String ELECTRIC_IMAGE_PATH = "images\\electric_company.png";
	private static final String INCOME_TAX = "images\\luxury_tax.png";
	private static final String LUXURY_TAX = "images\\luxury_tax.png";

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
		for (int y = 0; y < BOARD_SIZE; y++) {
			for (int x = 0; x < BOARD_SIZE; x++) {
				// Create cell rectangle
				Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
				cell.setFill(Color.WHITE);
				cell.setStroke(Color.BLACK);

				// Add text to cell

				VBox cellContents = new VBox(cell);
				cellContents.setAlignment(Pos.CENTER);

				// Add image to specific cells
				ImageView imageView = null;
				if (y == 0 && x == 0) {
					imageView = createImageView(FREE_PARKING_IMAGE_PATH, true);
				} else if (y == 0 && x == BOARD_SIZE - 1) {
					imageView = createImageView(GO_TO_JAIL_IMAGE_PATH, true);
				} else if (y == BOARD_SIZE - 1 && x == 0) {
					imageView = createImageView(JAIL_IMAGE_PATH, true);
				} else if (y == BOARD_SIZE - 1 && x == BOARD_SIZE - 1) {
					imageView = createImageView(GO_IMAGE_PATH, true);
				} else if (y == 3 && x == 0 || y == BOARD_SIZE - 1 && x == 8 || y == 3 && x == BOARD_SIZE - 1) {
					imageView = createImageView(COMMUNITY_CHEST_IMAGE_PATH, false);
				} else if (y == 6 && x == BOARD_SIZE - 1 || y == 0 && x == 2 || y == BOARD_SIZE - 1 && x == 3) {
					imageView = createImageView(CHANCE_IMAGE_PATH, false);
				} else if (y == 5 && (x == 0 || x == BOARD_SIZE - 1)) {
					imageView = createImageView(RAILROAD_IMAGE_PATH, false);
				} else if ((y == 0 || y == BOARD_SIZE - 1) && x == 5) {
					imageView = createImageView(RAILROAD_IMAGE_PATH, false);
				} else if (y == 0 && x == 8) {
					imageView = createImageView(WATER_IMAGE_PATH, false);
				} else if (y == 8 && x == 0) {
					imageView = createImageView(ELECTRIC_IMAGE_PATH, false);
				} else if (y == BOARD_SIZE - 1 && x == 6) {
					imageView = createImageView(INCOME_TAX, false);
				} else if (y == 8 && x == BOARD_SIZE - 1) {
					imageView = createImageView(LUXURY_TAX, false);
				}


				// Add cell contents to the board
				if (imageView != null) {
					StackPane cellStackPane = new StackPane(cellContents, imageView);
					board.add(cellStackPane, x, y);
				} else {
					board.add(cellContents, x, y);
				}
			}
		}

		return board;
	}

	// Creates an ImageView with the specified image path
	public static ImageView createImageView(String imagePath, boolean isCorner) {
		if (isCorner) {
			Image image = new Image(imagePath);
			ImageView imageView = new ImageView(image);
			imageView.setFitWidth(CELL_SIZE);
			imageView.setFitHeight(CELL_SIZE);
			return imageView;
		} else {
			Image image = new Image(imagePath);
			ImageView imageView = new ImageView(image);
			imageView.setPreserveRatio(true);
			imageView.setFitWidth(CELL_SIZE / 2.0);
			imageView.setFitHeight(CELL_SIZE / 2.0);
			imageView.setLayoutX((CELL_SIZE - imageView.getBoundsInLocal().getWidth()) / 2);
			imageView.setLayoutY((CELL_SIZE - imageView.getBoundsInLocal().getHeight()) / 2);
			return imageView;
		}
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
