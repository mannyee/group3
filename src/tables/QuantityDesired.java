package tables;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class QuantityDesired extends Stage {
	Stage primaryStage;
	public QuantityDesired(Stage s,Product product) {
		primaryStage = s;
		setTitle("Quantity Desired");
		VBox root = new VBox();
		Label paymentLbl = new Label("Quantity Desired");
		paymentLbl.setFont(new Font("Arial", 16));
		HBox paymentBox = new HBox();
		paymentBox.setAlignment(Pos.CENTER);
		paymentBox.getChildren().add(paymentLbl);

		TextField textField = new TextField();
		textField.setText("1");
		textField.setPrefWidth(80);
		textField.getStyleClass().add("bounding-border-textArea");
		

		HBox gridBox = new HBox();
		gridBox.setPadding(new Insets(20, 0, 20, 0));
		gridBox.setAlignment(Pos.CENTER);
		gridBox.getChildren().addAll(textField);

		Button ok = new Button("Ok");
		Button cancel = new Button("Cancel");
		
		HBox errorBox = new HBox();
		final Text errorText = new Text();
		errorText.setFont(new Font("Arial", 16));
		errorText.setFill(Color.RED);
		errorBox.setAlignment(Pos.CENTER);
		errorBox.getChildren().addAll(errorText);

		ok.setOnAction(evt ->{
			int quantityOrder = Integer.parseInt(textField.getText().trim());
			if(quantityOrder <= 0 || quantityOrder > product.getQuantityAvail()){
				errorText.setText("Order Quanity is not valid");
			}else{
				CartItems cartItems = new CartItems(product, quantityOrder);
				product.setQuantity(product.getQuantityAvail() - quantityOrder);
			//	Cart cart = new Cart(product, Integer.parseInt(textField.getText().trim()));
	//			DefaultData.CART_ITEMS.add(cart);
				cartItems.show();
				hide();
			}
		}); 

		cancel.setOnAction(evt -> {
			primaryStage.show();
			hide();
		});

		HBox buttonsBox = new HBox(20);
		buttonsBox.setPadding(new Insets(50, 0, 0, 0));
		buttonsBox.setAlignment(Pos.CENTER);
		buttonsBox.getChildren().addAll(ok, cancel);

		root.getChildren().addAll(paymentBox, gridBox, errorBox,buttonsBox);
		Scene scene = new Scene(root, 200, 200);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
		show();
	}
	
}
