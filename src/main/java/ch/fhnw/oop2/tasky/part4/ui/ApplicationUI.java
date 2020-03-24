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
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ApplicationUI extends BorderPane {
	private Button saveB;
	private Button deleteB;
	private Button newB;
	private Button refreshB;

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

		setTop(tasky);
		setLeft(mainL);
		setCenter(hBoxR);
	}

	private Region createRegion() {
		final Region region = new Region();
		region.setPadding(new Insets(200,50,200,50));
		region.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));

		return region;
	}

	private void rightSide() {
		box.getItems().addAll("ToDo", "Doing", "Done");

		hBoxR.getChildren().addAll(vBoxL, vBoxR);

		Stream.of(id, title, desc, date, state).forEach(n -> n.setMinWidth(50));
		
		double textHeight=25;
		double areaHeight=180;
		System.out.println(textHeight);
		id.setMinHeight(textHeight);
		title.setMinHeight(textHeight);
		desc.setMinHeight(areaHeight);
		date.setMinHeight(textHeight);
		state.setMinHeight(textHeight);
		
		desc.setAlignment(Pos.TOP_LEFT);

		vBoxL.setSpacing(10);
		vBoxL.setPadding(new Insets(10,5,10,10));
		vBoxL.getChildren().addAll(id, title, desc, date, state, saveB);

		vBoxR.setSpacing(10);
		vBoxR.setPadding(new Insets(10,10,10,5));
		vBoxR.getChildren().addAll(idText, titleText, descArea, datePicker, box, deleteB);
	}

	private void leftSide() {
		Stream.of(todo, doing, done).forEach(n -> n.setMinWidth(100));

		mainL.setSpacing(10);
		mainL.setPadding(new Insets(10));

		hBoxL1.getChildren().addAll(todo, doing, done);
		hBoxL1.setSpacing(25);

		hBoxL2.setSpacing(25);
		hBoxL2.setPrefWidth(50);
		hBoxL2.setMaxHeight(Double.MAX_VALUE);

		hBoxL2.getChildren().addAll(createRegion(), createRegion(), createRegion());

		hBoxL3.getChildren().addAll(newB, refreshB);
		hBoxL3.setSpacing(10);

		mainL.getChildren().addAll(hBoxL1, hBoxL2, hBoxL3);

	}

}
