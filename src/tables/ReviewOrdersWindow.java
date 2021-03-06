package tables;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;
import model.Order;

public class ReviewOrdersWindow extends Stage {

	private TableView<Order> table = new TableView<Order>();
	Stage reviewOrder;
	
	public ReviewOrdersWindow(Stage stage){
		this.reviewOrder = stage;
		setTitle("Order History");
		VBox root = new VBox();
		Label orderLbl = new Label("Order History");
		orderLbl.getStyleClass().add("custom-tile-font-style");
		//orderLbl.setFont(new Font("Arial", 16));
		HBox orderBox = new HBox();
		orderBox.setAlignment(Pos.CENTER);
		orderBox.getChildren().add(orderLbl);

		TableColumn<Order, String> orderID = new TableColumn<>("Order ID");
		//catalogNameCol.setMinWidth(250);
		orderID.setCellValueFactory(
            new PropertyValueFactory<Order, String>("orderId"));
		orderID.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<Order, String> orderDate = new TableColumn<>("Date");
		orderDate.setCellValueFactory(
	            new PropertyValueFactory<Order, String>("orderDate"));
		orderDate.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<Order, Double> totalCost = new TableColumn<>("Total Cost");
		totalCost.setCellValueFactory(
	            new PropertyValueFactory<Order, Double>("totalCost"));
	//	unitPrice.setCellFactory(TextFieldTableCell.forTableColumn());
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.getColumns().addAll(orderID,orderDate,totalCost);
	//	table.setItems(DefaultData.Final_order_data);
		table.setMinWidth(480);
		

		table.setItems(FXCollections.observableArrayList(DefaultData.orderHistory.keySet()));
		
		
		HBox gridBox = new HBox();
		gridBox.setPadding(new Insets(20, 0, 20, 0));
		gridBox.setAlignment(Pos.CENTER);
		gridBox.getChildren().addAll(table);
		
		Button viewDetails = new Button("View Details");
		viewDetails.setOnAction(evt -> {
			Order order = table.getSelectionModel().getSelectedItem();
			if(order != null){
				ReviewOrdersDetailsWindow reviewOrdersDetailsWindow = new ReviewOrdersDetailsWindow(this,order);
				reviewOrdersDetailsWindow.show();
				hide();
			}
			
		});

		Button cancel = new Button("Cancel");
		cancel.setOnAction(evt ->{
			reviewOrder.show();
			hide();
		});

		HBox buttonsBox = new HBox(20);
		buttonsBox.setPadding(new Insets(0, 0, 20, 0));
		buttonsBox.setAlignment(Pos.CENTER);
		buttonsBox.getChildren().addAll(viewDetails, cancel);

		root.getChildren().addAll(orderBox, gridBox, buttonsBox);
		Scene scene = new Scene(root, 500, 400);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
		show();
	}

}
