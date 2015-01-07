package tables;



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

public class CartItems extends Stage {
	private Product product;
	private TableView<FinalOrder> table = new TableView<FinalOrder>();
	
	@SuppressWarnings("unchecked")
	public CartItems(Product p, int qty) { 
		DefaultData.Final_order_data.add(new FinalOrder(p.getProductName(), qty, p.getUnitPrice(), qty * p.getUnitPrice()));
		setTitle("Cart Items");
		VBox root = new VBox();
		Label paymentLbl = new Label("Cart Items");
		paymentLbl.setFont(new Font("Arial", 16));
		HBox paymentBox = new HBox();
		paymentBox.setAlignment(Pos.CENTER);
		paymentBox.getChildren().add(paymentLbl);

//		TextField textField = new TextField();
//		textField.setPrefWidth(80);
//		textField.getStyleClass().add("bounding-border-textArea");
		
		
		TableColumn<FinalOrder, String> item = new TableColumn<>("Item");
		
		//catalogNameCol.setMinWidth(250);
		item.setCellValueFactory(
            new PropertyValueFactory<FinalOrder, String>("item"));
		item.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<FinalOrder, Integer> quantity = new TableColumn<>("Quantity");
		quantity.setCellValueFactory(
	            new PropertyValueFactory<FinalOrder, Integer>("quantity"));
	//	quantity.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<FinalOrder, Integer> unitPrice = new TableColumn<>("Unit Price");
		unitPrice.setCellValueFactory(
	            new PropertyValueFactory<FinalOrder, Integer>("price"));
	//	unitPrice.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<FinalOrder, Integer> totalPrice = new TableColumn<>("Total Price");
		totalPrice.setCellValueFactory(
	            new PropertyValueFactory<FinalOrder, Integer>("total"));
	//	totalPrice.setCellFactory(TextFieldTableCell.forTableColumn());
		
		table.getColumns().addAll(item,quantity,unitPrice,totalPrice);

		table.setItems(DefaultData.Final_order_data);
		
		HBox gridBox = new HBox();
		gridBox.setPadding(new Insets(20, 0, 20, 0));
		gridBox.setAlignment(Pos.CENTER);
		gridBox.getChildren().addAll(table);

		Button proceedCheck = new Button("Proceed To Check Out");
		proceedCheck.setOnAction(evt -> {
			ShippingBillingInfoWindow shippingBillingInfoWindow = new ShippingBillingInfoWindow();
			shippingBillingInfoWindow.show();
			hide();
		});
		Button continueShopping = new Button("Continue Shopping");
		Button saveCart = new Button("Save Cart");
		Button exit = new Button("Exit E-Bazzar");


		HBox buttonsBox = new HBox(20);
		buttonsBox.setPadding(new Insets(50, 0, 0, 0));
		buttonsBox.setAlignment(Pos.CENTER);
		buttonsBox.getChildren().addAll(proceedCheck, continueShopping, saveCart, exit);

		root.getChildren().addAll(paymentBox, gridBox, buttonsBox);
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
		show();
	}

}
