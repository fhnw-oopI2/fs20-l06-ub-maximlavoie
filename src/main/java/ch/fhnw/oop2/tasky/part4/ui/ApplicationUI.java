package ch.fhnw.oop2.tasky.part4.ui;

import java.util.stream.Stream;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ApplicationUI extends BorderPane {
	private Button saveB;
	private Button deleteB;
	private Button newB;
	private Button refreshB;
	private Button task1;
	private Button task2;
	private Button task3;

	private VBox region1;
	private VBox region2;
	private VBox region3;

	private Label todo;
	private Label doing;
	private Label done;
	private Label id;
	private Label title;
	private Label desc;
	private Label date;
	private Label state;
	private Label tasky;

	private VBox mainL;

	private HBox hBoxL1;
	private HBox hBoxL2;
	private HBox hBoxL3;
	private VBox vBoxL;
	private VBox vBoxR;
	private HBox hBoxR;

	private TextField idText;
	private TextField titleText;

	private TextArea descArea;

	private DatePicker datePicker;

	private ComboBox<String> box;

	public ApplicationUI() {
		initializeControls();
		layoutControls();

	}

	private void initializeControls() {
		saveB = new Button("Save");
		deleteB = new Button("Delete");
		newB = new Button("New");
		refreshB = new Button("Refresh");
		task1 = new Button("ID\nTitle");
		task2 = new Button("ID\nTitle");
		task3 = new Button("ID\nTitle");

		region1 = createRegion();
		region2 = createRegion();
		region3 = createRegion();

		mainL = new VBox();
		hBoxL1 = new HBox();
		hBoxL2 = new HBox();
		hBoxL3 = new HBox();
		hBoxR = new HBox();
		vBoxL = new VBox();
		vBoxR = new VBox();

		tasky = new Label("Tasky");
		todo = new Label("Todo");
		doing = new Label("Doing");
		done = new Label("Done");
		id = new Label("ID");
		title = new Label("Title");
		desc = new Label("Desc");
		date = new Label("Date");
		state = new Label("State");

		idText = new TextField();
		titleText = new TextField();
		descArea = new TextArea();

		datePicker = new DatePicker();

		box = new ComboBox<>();
	}

	private void layoutControls() {

		leftSide();
		rightSide();
		tasky.setPadding(new Insets(5));
		setTop(tasky);
		setLeft(mainL);
		setCenter(hBoxR);
	}

	/**
	 * Erstellt eine Region durch VBoxes.
	 * @return VBox
	 */
	private VBox createRegion() {
		final VBox region = new VBox();
		region.setSpacing(10);
		region.setAlignment(Pos.TOP_CENTER);
		region.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));

		return region;
	}

	private void rightSide() {
		// optionen für combobox
		box.getItems().addAll("ToDo", "Doing", "Done");
		// hinzufügen der vboxen für die beiden spalten der labels und felder
		hBoxR.getChildren().addAll(vBoxL, vBoxR);

		// sicherstellen, dass labels voll ausgeschrieben sind
		Stream.of(id, title, desc, date, state).forEach(n -> n.setMinWidth(50));

		// anpassen der ausrichtung für labels und dazugehörigem label
		double textHeight = 25;
		double areaHeight = 180;
		id.setMinHeight(textHeight);
		title.setMinHeight(textHeight);
		desc.setMinHeight(areaHeight);
		date.setMinHeight(textHeight);
		state.setMinHeight(textHeight);

		// desc soll nicht in der mitte des labels sein sondern oben
		desc.setAlignment(Pos.TOP_LEFT);

		// layout der linken spalte
		vBoxL.setSpacing(10);
		vBoxL.setPadding(new Insets(10, 5, 10, 10));
		vBoxL.getChildren().addAll(id, title, desc, date, state, saveB);

		// layout der rechten spalte
		vBoxR.setSpacing(10);
		vBoxR.setPadding(new Insets(10, 10, 10, 5));
		vBoxR.getChildren().addAll(idText, titleText, descArea, datePicker, box, deleteB);
	}

	private void leftSide() {
		// grösse der tasks einstellen
		Stream.of(task1, task2, task3).forEach(n -> n.setMinWidth(45));

		// tasks den regionen zuordnen
		region1.getChildren().addAll(task1, task2);
		region2.getChildren().addAll();
		region3.getChildren().addAll(task3);
		addRegionPadding();

		// labels über die Spalten setzen
		Stream.of(todo, doing, done).forEach(n -> n.setMinWidth(100));

		mainL.setSpacing(10);
		mainL.setPadding(new Insets(10));

		hBoxL1.getChildren().addAll(todo, doing, done);
		hBoxL1.setSpacing(25);

		hBoxL2.setSpacing(25);
		hBoxL2.setPrefWidth(50);
		hBoxL2.setMaxHeight(Double.MAX_VALUE);

		hBoxL2.getChildren().addAll(region1, region2, region3);

		hBoxL3.getChildren().addAll(newB, refreshB);
		hBoxL3.setSpacing(10);

		mainL.getChildren().addAll(hBoxL1, hBoxL2, hBoxL3);

	}

	/**
	 * Setzt fest, wie gross die Taskspalte sein soll. Unterscheided zwischen leerer
	 * Spalte und Spalten mit Tasks.
	 */
	private void addRegionPadding() {
		Stream.of(region1, region2, region3).forEach(region -> {
			double top = 0;
			double right = 0;
			double bottom = 0;
			double left = 0;
			int size = region.getChildren().size();
			if (region.getChildren().isEmpty()) {
				top = 200;
				right = 50;
				bottom = 200;
				left = 50;
			} else {
				double x = region.getChildren().get(size - 1).getLayoutX();
				double y = region.getChildren().get(size - 1).getLayoutY();
				top = 10;
				bottom = (400 - (size * task1.getHeight() + (size - 1) * 10)) / 2;
				right = (100 - task1.getWidth()) / 4;
				left = right;

			}

			region.setPadding(new Insets(top, right, bottom, left));
		});

	}

}
