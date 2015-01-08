package tables;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProductCatalog extends Stage {
	private TableView<Product> table = new TableView<Product>();
	private ComboBox<Catalog> comboBox;
	private TableColumn<Product, String> catalogName;
	private TableColumn<Product, String> mfgDate;
	private TableColumn<Product, Double> unitPrice;
	private Label label;
	private TableColumn<Product, Integer> quantity;
	private Button btnAdd;
	private Button btnEdit;
	private Button btnDelete;
	private Button btnSearch;
	private Button btnBack;
	private HBox btnBox;
	private GridPane grid;
	private Stage stage;

	@SuppressWarnings("unchecked")
	public ProductCatalog(Stage primaryStage) {
		this.stage = primaryStage;

		label = new Label("Maintain Product Catalog");
		label.getStyleClass().add("custom-tile-font-style");
		HBox labelHbox = new HBox(10);
		labelHbox.setAlignment(Pos.CENTER);
		labelHbox.getChildren().add(label);

		comboBox = new ComboBox<Catalog>();
		comboBox.getItems().setAll(DefaultData.CATALOG_LIST_DATA);
		comboBox.setValue(DefaultData.CATALOG_LIST_DATA.get(0));
		HBox hCombo = new HBox(10);
		hCombo.setAlignment(Pos.BOTTOM_LEFT);
		hCombo.setPadding(new Insets(0, 0, 0, 20));
		hCombo.getChildren().add(comboBox);

		catalogName = new TableColumn<>("Name");
		catalogName.setMinWidth(240);
		catalogName
				.setCellValueFactory(new PropertyValueFactory<Product, String>(
						"productName"));
		catalogName.setCellFactory(TextFieldTableCell.forTableColumn());

		mfgDate = new TableColumn<>("Mfg. Date");
		mfgDate.setMinWidth(150);
		mfgDate.setCellValueFactory(new PropertyValueFactory<Product, String>(
				"mfgDate"));
		mfgDate.setCellFactory(TextFieldTableCell.forTableColumn());

		unitPrice = new TableColumn<>("Unit Price");
		unitPrice.setMinWidth(150);
		unitPrice
				.setCellValueFactory(new PropertyValueFactory<Product, Double>(
						"unitPrice"));
		// unitPrice.setCellFactory(TextFieldTableCell.forTableColumn());

		quantity = new TableColumn<>("Quantities");
		quantity.setMinWidth(125);
		quantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>(
				"quantityAvail"));
		// quantity.setCellFactory(TextFieldTableCell.forTableColumn());

		table.getColumns().addAll(catalogName, mfgDate, unitPrice, quantity);

		HBox tableBox = new HBox();
		tableBox.setPadding(new Insets(0, 20, 0, 20));
		tableBox.getChildren().add(table);

		table.setItems(FXCollections
				.observableArrayList(DefaultData.PRODUCT_LIST_DATA
						.get(DefaultData.CATALOG_LIST_DATA.get(0))));

		comboBox.setOnAction(evt -> {

			// System.out.println("model: " +
			// comboBox.getSelectionModel().getSelectedItem());
			Catalog c = comboBox.getSelectionModel().getSelectedItem();
			if (DefaultData.PRODUCT_LIST_DATA.get(c) != null) {

				table.setItems(FXCollections
						.observableArrayList(DefaultData.PRODUCT_LIST_DATA
								.get(c)));

			} else {
				table.setItems(null);
			}
		});

		btnAdd = new Button("Add");
		btnEdit = new Button("Edit");
		btnDelete = new Button("Delete");
		btnSearch = new Button("Search");
		btnBack = new Button("Back to Main");

		btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(btnAdd, btnEdit, btnDelete, btnBack);

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(labelHbox, 0, 0);
		grid.add(hCombo, 0, 1);
		grid.add(tableBox, 0, 2);
		grid.add(btnBox, 0, 3);

		btnBack.setOnAction(evt -> {

			hide();
			stage.show();
		});

		btnAdd.setOnAction(evt -> {
			hide();
			AddProduct add = new AddProduct(stage);
			add.show();
		});

		btnEdit.setOnAction(evt -> {
			Product p = table.getSelectionModel().getSelectedItem();

			if (p == null) {
				ModalDialog md = new ModalDialog();
				md.show();

			} else {

				EditProduct ep = new EditProduct(p, comboBox
						.getSelectionModel().getSelectedItem(), stage);
				ep.show();

				// hide product catalog
				hide();

			}
		});

		btnDelete.setOnAction(evt -> {
			Product p = table.getSelectionModel().getSelectedItem();

			if (p == null) {
				ModalDialog md = new ModalDialog();
				md.show();
			} else {

				DefaultData.PRODUCT_LIST_DATA.get(
						comboBox.getSelectionModel().getSelectedItem()).remove(
						table.getSelectionModel().getSelectedIndex());
				table.getSelectionModel().clearSelection(
						table.getSelectionModel().getSelectedIndex());

				table.setItems(FXCollections
						.observableArrayList(DefaultData.PRODUCT_LIST_DATA
								.get(comboBox.getSelectionModel()
										.getSelectedItem())));

			}

			// System.out.println("index: " +
			// table.getSelectionModel().getSelectedIndex());

			});

		Scene scene = new Scene(grid, 700, 600);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
	}
}
