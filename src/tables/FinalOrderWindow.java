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

public class FinalOrderWindow extends Stage {
	private TableView<FinalOrder> table = new TableView<FinalOrder>();
	
	@SuppressWarnings("unchecked")
	public FinalOrderWindow() { 
		setTitle("Final Order");
		VBox root = new VBox();
		Label paymentLbl = new Label("Final Order");
		paymentLbl.setFont(new Font("Arial", 16));
		HBox paymentBox = new HBox();
		paymentBox.setAlignment(Pos.CENTER);
		paymentBox.getChildren().add(paymentLbl);

		
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

		Button ok = new Button("Ok");
		Button cancel = new Button("Cancel");


		HBox buttonsBox = new HBox(20);
		buttonsBox.setPadding(new Insets(50, 0, 0, 0));
		buttonsBox.setAlignment(Pos.CENTER);
		buttonsBox.getChildren().addAll(ok, cancel);

		root.getChildren().addAll(paymentBox, gridBox, buttonsBox);
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
		show();
	}

}
