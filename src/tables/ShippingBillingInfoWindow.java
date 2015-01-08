package tables;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Shipping;

public class ShippingBillingInfoWindow extends Stage {

	// Stage primaryStage;

	final int WINDOW_WIDTH = 600;
	final int WINDOW_HEIGHT = 480;
	TextField stateTxtField,zipTxtField,addressTxtField,cityTxtField;
	Stage cartItems;
	public ShippingBillingInfoWindow(Stage stage) {
		cartItems = stage;

		// Add title on window
		setTitle("Shipping and Billing Information");

		// Create GridPane layout
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 15, 15, 15));

		// Setting columns size in percent
		ColumnConstraints column = new ColumnConstraints();
		// column.setPercentWidth(100);
		grid.getColumnConstraints().add(column);

		column = new ColumnConstraints();
		// column.setPercentWidth(100);
		column.setFillWidth(true);
		grid.getColumnConstraints().add(column);
		grid.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT); // Default width and
														// height
		grid.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

		// Add Title bar label
		Label titleLbl = new Label("Shipping and Billing Information");
//		titleLbl.setFont(new Font("Arial", 16));
		titleLbl.getStyleClass().add("custom-tile-font-style");
		titleLbl.setAlignment(Pos.CENTER);
		titleLbl.setPrefWidth(WINDOW_WIDTH);
		GridPane.setColumnSpan(titleLbl, 2);
		grid.add(titleLbl, 0, 0);

		// Add Shipping Address label
		Label shippingAddressLbl = new Label("Shipping Address");
		shippingAddressLbl.setAlignment(Pos.CENTER);
		shippingAddressLbl.setPrefWidth(WINDOW_WIDTH / 2);
		grid.add(shippingAddressLbl, 0, 1);

		// Add Shipping Address label
		Label billingAddressLbl = new Label("Billing Address");
		billingAddressLbl.setAlignment(Pos.CENTER);
		billingAddressLbl.setPrefWidth(WINDOW_WIDTH / 2);
		grid.add(billingAddressLbl, 1, 1);

		// grid.setGridLinesVisible(true);

		// Add Shipping Address Controls
		// Create GridPane layout
		GridPane shippingAddGrid = new GridPane();
		shippingAddGrid.setVgap(10);
		shippingAddGrid.getStyleClass().add("bounding-border");
		shippingAddGrid.setAlignment(Pos.CENTER);
		shippingAddGrid.setPrefWidth(WINDOW_WIDTH / 2);
		grid.add(shippingAddGrid, 0, 2);

		// Add Name label
		Label nameLbl = new Label("Name");
		nameLbl.setPrefWidth(WINDOW_WIDTH / 2);
		shippingAddGrid.add(nameLbl, 0, 1);

		// Add Name TextField
		TextField nameTxtField = new TextField();
		nameTxtField.setPrefWidth(WINDOW_WIDTH / 2);
		shippingAddGrid.add(nameTxtField, 1, 1);

		// Add Address1 label
		Label address1Lbl = new Label("Address1");
		address1Lbl.setPrefWidth(WINDOW_WIDTH / 2);
		shippingAddGrid.add(address1Lbl, 0, 2);

		// Add Address1 TextField
		addressTxtField = new TextField();
		addressTxtField.setPrefWidth(WINDOW_WIDTH / 2);
		shippingAddGrid.add(addressTxtField, 1, 2);
//		addressTxtField.setText(shippingData.getStreet());

		// Add City label
		Label cityLbl = new Label("City");
		cityLbl.setPrefWidth(WINDOW_WIDTH / 2);
		shippingAddGrid.add(cityLbl, 0, 3);

		// Add city TextField
		cityTxtField = new TextField();
		cityTxtField.setPrefWidth(WINDOW_WIDTH / 2);
		shippingAddGrid.add(cityTxtField, 1, 3);
		

		// Add State label
		Label stateLbl = new Label("State");
		stateLbl.setPrefWidth(WINDOW_WIDTH / 2);
		shippingAddGrid.add(stateLbl, 0, 4);

		// Add State TextField
		stateTxtField = new TextField();
		stateTxtField.setPrefWidth(WINDOW_WIDTH / 2);
		shippingAddGrid.add(stateTxtField, 1, 4);
		

		// Add Zip label
		Label zipLbl = new Label("Zip");
		zipLbl.setPrefWidth(WINDOW_WIDTH / 2);
		shippingAddGrid.add(zipLbl, 0, 5);

		// Add Zip TextField
		zipTxtField = new TextField();
		zipTxtField.setPrefWidth(WINDOW_WIDTH / 2);
		shippingAddGrid.add(zipTxtField, 1, 5);
		

		// Add Billing Address Controls

		// Create GridPane layout
		GridPane billingAddGrid = new GridPane();
		billingAddGrid.setVgap(10);
		billingAddGrid.getStyleClass().add("bounding-border");
		billingAddGrid.setAlignment(Pos.CENTER);
		billingAddGrid.setPrefWidth(WINDOW_WIDTH / 2);
		grid.add(billingAddGrid, 1, 2);

		// Add Name label
		Label name1Lbl = new Label("Name");
		name1Lbl.setPrefWidth(WINDOW_WIDTH / 2);
		billingAddGrid.add(name1Lbl, 0, 1);

		// Add Name TextField
		TextField name1TxtField = new TextField();
		name1TxtField.setPrefWidth(WINDOW_WIDTH / 2);
		billingAddGrid.add(name1TxtField, 1, 1);

		// Add Address1 label
		Label address11Lbl = new Label("Address1");
		address11Lbl.setPrefWidth(WINDOW_WIDTH / 2);
		billingAddGrid.add(address11Lbl, 0, 2);

		// Add Address1 TextField
		TextField address1TxtField = new TextField();
		address1TxtField.setPrefWidth(WINDOW_WIDTH / 2);
		billingAddGrid.add(address1TxtField, 1, 2);

		// Add City label
		Label city1Lbl = new Label("City");
		city1Lbl.setPrefWidth(WINDOW_WIDTH / 2);
		billingAddGrid.add(city1Lbl, 0, 3);

		// Add city TextField
		TextField city1TxtField = new TextField();
		city1TxtField.setPrefWidth(WINDOW_WIDTH / 2);
		billingAddGrid.add(city1TxtField, 1, 3);

		// Add State label
		Label state1Lbl = new Label("State");
		state1Lbl.setPrefWidth(WINDOW_WIDTH / 2);
		billingAddGrid.add(state1Lbl, 0, 4);

		// Add State TextField
		TextField state1TxtField = new TextField();
		state1TxtField.setPrefWidth(WINDOW_WIDTH / 2);
		billingAddGrid.add(state1TxtField, 1, 4);

		// Add Zip label
		Label zip1Lbl = new Label("Zip");
		zip1Lbl.setPrefWidth(WINDOW_WIDTH / 2);
		billingAddGrid.add(zip1Lbl, 0, 5);

		// Add Zip TextField
		TextField zip1TxtField = new TextField();
		zip1TxtField.setPrefWidth(WINDOW_WIDTH / 2);
		billingAddGrid.add(zip1TxtField, 1, 5);

		// Adding Checkbox
		// Create GridPane layout
		GridPane checkBoxGrid = new GridPane();
		checkBoxGrid.setAlignment(Pos.CENTER);
		checkBoxGrid.setHgap(5);
		checkBoxGrid.setVgap(5);
		GridPane.setColumnSpan(checkBoxGrid, 2);
		grid.add(checkBoxGrid, 0, 3);

		CheckBox checkBox = new CheckBox(
				"Check if Billing Address is Same as Shipping");
		checkBox.setAlignment(Pos.CENTER);
		checkBoxGrid.add(checkBox, 0, 0);

		// Add Shipping Method
		GridPane shippingMthGrid = new GridPane();
		shippingMthGrid.setAlignment(Pos.CENTER);
		GridPane.setColumnSpan(shippingMthGrid, 2);
		grid.add(shippingMthGrid, 0, 4);

		Label shippingMthLbl = new Label("Shipping Method");
		shippingMthLbl.setAlignment(Pos.CENTER);
		shippingMthGrid.add(shippingMthLbl, 0, 0);

		// Add Radio Buttons
		GridPane rbGrid = new GridPane();
		rbGrid.getStyleClass().add("bounding-border");
		rbGrid.setAlignment(Pos.CENTER);
		rbGrid.setHgap(5);
		rbGrid.setVgap(5);
		GridPane.setColumnSpan(rbGrid, 2);
		grid.add(rbGrid, 0, 5);

		final ToggleGroup tg = new ToggleGroup();

		RadioButton cGroundRB = new RadioButton("Pigeon-carrier Ground");
		cGroundRB.setAlignment(Pos.CENTER);
		cGroundRB.setToggleGroup(tg);
		rbGrid.add(cGroundRB, 0, 0);

		RadioButton cAirRB = new RadioButton("Pigeon-carrier Air");
		cAirRB.setAlignment(Pos.CENTER);
		cAirRB.setToggleGroup(tg);
		rbGrid.add(cAirRB, 0, 1);

		RadioButton cOvernightRB = new RadioButton("Pigeon-carrier Overnight");
		cOvernightRB.setAlignment(Pos.CENTER);
		cOvernightRB.setToggleGroup(tg);
		rbGrid.add(cOvernightRB, 0, 2);

		// Add Bottom Buttons
		GridPane bottomBtnGrid = new GridPane();
		bottomBtnGrid.setHgap(10);
		bottomBtnGrid.setVgap(10);
		bottomBtnGrid.setAlignment(Pos.CENTER);
		GridPane.setColumnSpan(bottomBtnGrid, 2);
		grid.add(bottomBtnGrid, 0, 6);

		Button shippingAddressBtn = new Button("Select Shipping Address");
		shippingAddressBtn.setOnAction(evt -> {
			ShippingAddress shippingAddress = new ShippingAddress(this);
			shippingAddress.show();
			hide();
		});
		shippingAddressBtn.setAlignment(Pos.CENTER);
		bottomBtnGrid.add(shippingAddressBtn, 0, 0);

		Button proceedWithCheckOutBtn = new Button("proceed With Checkout");
		proceedWithCheckOutBtn
				.setOnAction(evt -> {
					ProceedWithCheckout proceedWithCheckout = new ProceedWithCheckout(this);
					proceedWithCheckout.show();
					hide();
				});
		proceedWithCheckOutBtn.setAlignment(Pos.CENTER);
		bottomBtnGrid.add(proceedWithCheckOutBtn, 1, 0);

		Button backCartBtn = new Button("Back To Cart");
		backCartBtn.setAlignment(Pos.CENTER);
		backCartBtn.setOnAction(evt ->{
			cartItems.show();
			hide();
		});
		bottomBtnGrid.add(backCartBtn, 2, 0);

		Scene scene = new Scene(grid, WINDOW_WIDTH, WINDOW_HEIGHT);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);

	}
	
	
	
	public void setShippingData(Shipping shippingData){
		stateTxtField.setText(shippingData.getState());
		zipTxtField.setText(shippingData.getZip());
		addressTxtField.setText(shippingData.getStreet());
		cityTxtField.setText(shippingData.getCity());
	}

}