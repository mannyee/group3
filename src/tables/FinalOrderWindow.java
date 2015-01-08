package tables;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Order;

public class FinalOrderWindow extends Stage {
	private TableView<FinalOrder> table = new TableView<FinalOrder>();
	Stage confirmStage = null;
	@SuppressWarnings("unchecked")
	public FinalOrderWindow() {
		setTitle("Final Order");
		VBox root = new VBox();
		Label paymentLbl = new Label("Final Order");
		paymentLbl.getStyleClass().add("custom-tile-font-style");
		// paymentLbl.setFont(new Font("Arial", 16));
		HBox paymentBox = new HBox();
		paymentBox.setAlignment(Pos.CENTER);
		paymentBox.getChildren().add(paymentLbl);

		TableColumn<FinalOrder, String> item = new TableColumn<>("Item");

		// catalogNameCol.setMinWidth(250);
		item.setCellValueFactory(new PropertyValueFactory<FinalOrder, String>(
				"item"));
		item.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<FinalOrder, Integer> quantity = new TableColumn<>(
				"Quantity");
		quantity.setCellValueFactory(new PropertyValueFactory<FinalOrder, Integer>(
				"quantity"));
		// quantity.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<FinalOrder, Integer> unitPrice = new TableColumn<>(
				"Unit Price");
		unitPrice
				.setCellValueFactory(new PropertyValueFactory<FinalOrder, Integer>(
						"price"));
		// unitPrice.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<FinalOrder, Integer> totalPrice = new TableColumn<>(
				"Total Price");
		totalPrice
				.setCellValueFactory(new PropertyValueFactory<FinalOrder, Integer>(
						"total"));
		// totalPrice.setCellFactory(TextFieldTableCell.forTableColumn());
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.getColumns().addAll(item, quantity, unitPrice, totalPrice);
		table.setMinWidth(480);

		table.setItems(DefaultData.Final_order_data);

		HBox gridBox = new HBox();
		gridBox.setPadding(new Insets(20, 0, 20, 0));
		gridBox.setAlignment(Pos.CENTER);
		gridBox.getChildren().addAll(table);

		Button ok = new Button("Ok");
		ok.setOnAction(evt -> {
			showConfirmDialog();
		});
		Button cancel = new Button("Cancel");
		cancel.setOnAction(evt -> Platform.exit());

		HBox buttonsBox = new HBox(20);
		buttonsBox.setPadding(new Insets(0, 0, 20, 0));
		buttonsBox.setAlignment(Pos.CENTER);
		buttonsBox.getChildren().addAll(ok, cancel);

		root.getChildren().addAll(paymentBox, gridBox, buttonsBox);
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
		show();
	}

	public void showConfirmDialog() {
		if(confirmStage == null){
			confirmStage = new Stage();
			VBox vbox = new VBox();
			vbox.setPadding(new Insets(10, 10, 0, 10));
			Text text = new Text(
					"Thank you for shopping :) \n Do you want to continue shopping?");
			Button yesBtn = new Button("Yes");
			yesBtn.setOnAction(evt -> {
				double totalCost = 0;
				for(FinalOrder finalOrder : DefaultData.Final_order_data){
					totalCost += finalOrder.getTotal();
				}
				DefaultData.orderHistory.put(new Order(getUniqueID(),
						getCurrentDate(), totalCost), DefaultData.Final_order_data);
				DefaultData.Final_order_data = null;
				DefaultData.Final_order_data = FXCollections.observableArrayList();
				confirmStage.hide();
				hide();
				ProductListWindow.catalogList.show();
			});
			Button noBtn = new Button("No");
			noBtn.setOnAction(evt -> Platform.exit());

			HBox hbox = new HBox(15);
			hbox.setPadding(new Insets(20, 0, 0, 0));
			hbox.getChildren().addAll(yesBtn, noBtn);
			vbox.getChildren().addAll(text, hbox);

			Scene scene = new Scene(vbox, 300, 110);
			scene.getStylesheets().add(
					getClass().getResource("style.css").toExternalForm());
			confirmStage.setScene(scene);
			confirmStage.initModality(Modality.APPLICATION_MODAL);
			confirmStage.show();
		}
	}
	

	public String getCurrentDate(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	public String getUniqueID(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		return "EBID" + dateFormat.format(date).replace("/", "").replace(":", "").replace(" ", "");
	}

}
