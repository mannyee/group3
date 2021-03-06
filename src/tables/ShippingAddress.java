package tables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Shipping;

public class ShippingAddress extends Stage {
	private TableView<Shipping> table = new TableView<Shipping>();

	private Shipping selected;
	private ShippingBillingInfoWindow shippingBillingInfoWindow;

	@SuppressWarnings("unchecked")
	public ShippingAddress(ShippingBillingInfoWindow stage) {
		this.shippingBillingInfoWindow = stage;
		setTitle("Shipping Address");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);

		Text header = new Text("Shipping Addresses");
		header.getStyleClass().add("custom-tile-font-style");
		// header.setFont(new Font("Arial", 16));
		HBox hboxHeader = new HBox(10);
		hboxHeader.setAlignment(Pos.CENTER);
		hboxHeader.getChildren().add(header);

		table.setMinWidth(550);

		TableColumn<Shipping, String> street = new TableColumn<>(
				String.format("Street"));
		street.setMinWidth(250);

		street.setCellValueFactory(new PropertyValueFactory<Shipping, String>(
				"street"));
		street.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<Shipping, String> city = new TableColumn<>(
				String.format("City"));
		city.setMinWidth(100);
		city.setCellValueFactory(new PropertyValueFactory<Shipping, String>(
				"city"));
		city.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<Shipping, String> state = new TableColumn<>(
				String.format("State"));
		state.setMinWidth(100);
		state.setCellValueFactory(new PropertyValueFactory<Shipping, String>(
				"state"));
		street.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<Shipping, String> zip = new TableColumn<>(
				String.format("Zip"));
		zip.setMinWidth(100);
		zip.setCellValueFactory(new PropertyValueFactory<Shipping, String>(
				"zip"));
		street.setCellFactory(TextFieldTableCell.forTableColumn());

		table.getColumns().addAll(street, city, state, zip);

		Button btnSelect = new Button("Select");

		btnSelect.setOnAction(evt -> {
			selected = table.getSelectionModel().getSelectedItem();
			// ShippingBillingInfoWindow shippingBillingInfo = new
			// ShippingBillingInfoWindow(
			// selected);
			System.out.println("Nul Check " + (shippingBillingInfoWindow == null));
				shippingBillingInfoWindow.setShippingData(selected); 
				hide();
				shippingBillingInfoWindow.show();

			});
		Button btnCancel = new Button("Cancel");
		btnCancel.setOnAction(evt -> {
			hide();
			shippingBillingInfoWindow.show();
		});

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.CENTER);
		hbBtn.getChildren().addAll(btnSelect, btnCancel);

		grid.add(hboxHeader, 0, 0);
		grid.add(table, 0, 1);
		grid.add(hbBtn, 0, 3);

		setData(FXCollections.observableList(DefaultData.shippingItemList));

		Scene scene = new Scene(grid, 600, 550);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
	}

	public void setData(ObservableList<Shipping> cats) {
		table.setItems(cats);
	}

}