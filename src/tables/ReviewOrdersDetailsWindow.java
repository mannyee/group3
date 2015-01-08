package tables;



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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Order;

public class ReviewOrdersDetailsWindow extends Stage {

	private TableView<FinalOrder> table = new TableView<FinalOrder>();
	Stage reviewOrdersDetailsWindow;
	
	public ReviewOrdersDetailsWindow(Stage stage,Order order){
		this.reviewOrdersDetailsWindow = stage;
		setTitle("Order Detail");
		VBox root = new VBox();
		Label orderLbl = new Label("Order Detail");
		orderLbl.getStyleClass().add("custom-tile-font-style");
//		orderLbl.setFont(new Font("Arial", 16));
		HBox orderBox = new HBox();
		orderBox.setAlignment(Pos.CENTER);
		orderBox.getChildren().add(orderLbl);

		TableColumn<FinalOrder, String> product = new TableColumn<>("Product");
		//catalogNameCol.setMinWidth(250);
		product.setCellValueFactory(
            new PropertyValueFactory<FinalOrder, String>("item"));
		product.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<FinalOrder, Integer> quantity = new TableColumn<>("Quantity");
		quantity.setCellValueFactory(
	            new PropertyValueFactory<FinalOrder, Integer>("quantity"));
	//	quantity.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<FinalOrder, Double> unitPrice = new TableColumn<>("Price");
		unitPrice.setCellValueFactory(
	            new PropertyValueFactory<FinalOrder, Double>("price"));
	//	unitPrice.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<FinalOrder, Double> total = new TableColumn<>("total");
		total.setCellValueFactory(
	            new PropertyValueFactory<FinalOrder, Double>("total"));
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.getColumns().addAll(product,quantity,unitPrice,total);
	//	table.setItems(DefaultData.Final_order_data);
		table.setMinWidth(480);
		table.setItems(FXCollections.observableArrayList(DefaultData.orderHistory.get(order)));
		
		HBox gridBox = new HBox();
		gridBox.setPadding(new Insets(20, 0, 20, 0));
		gridBox.setAlignment(Pos.CENTER);
		gridBox.getChildren().addAll(table);

		Button okBtn = new Button("Ok");

		okBtn.setOnAction(evt ->{
			reviewOrdersDetailsWindow.show();
			hide();
		});

		HBox buttonsBox = new HBox(20);
		buttonsBox.setPadding(new Insets(0, 0, 20, 0));
		buttonsBox.setAlignment(Pos.CENTER);
		buttonsBox.getChildren().addAll(okBtn);

		root.getChildren().addAll(orderBox, gridBox, buttonsBox);
		Scene scene = new Scene(root, 500, 400);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
		show();
	}

}
