package tables;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class QuantityDesired extends Stage {
	private Product product;

	public QuantityDesired(Product product) {
		this.product = product;
		
		setTitle("Quantity Desired");
		VBox root = new VBox();
		Label paymentLbl = new Label("Quantity Desired");
		paymentLbl.setFont(new Font("Arial", 16));
		HBox paymentBox = new HBox();
		paymentBox.setAlignment(Pos.CENTER);
		paymentBox.getChildren().add(paymentLbl);

		TextField textField = new TextField();
		textField.setPrefWidth(80);
		textField.getStyleClass().add("bounding-border-textArea");
		

		HBox gridBox = new HBox();
		gridBox.setPadding(new Insets(20, 0, 20, 0));
		gridBox.setAlignment(Pos.CENTER);
		gridBox.getChildren().addAll(textField);

		Button ok = new Button("Ok");
		Button cancel = new Button("Cancel");
		
		ok.setOnAction(evt ->{
			CartItems cartItems = new CartItems(product, Integer.parseInt(textField.getText().trim()));
		//	Cart cart = new Cart(product, Integer.parseInt(textField.getText().trim()));
//			DefaultData.CART_ITEMS.add(cart);
			cartItems.show();
			hide();
		});


		HBox buttonsBox = new HBox(20);
		buttonsBox.setPadding(new Insets(50, 0, 0, 0));
		buttonsBox.setAlignment(Pos.CENTER);
		buttonsBox.getChildren().addAll(ok, cancel);

		root.getChildren().addAll(paymentBox, gridBox, buttonsBox);
		Scene scene = new Scene(root, 200, 200);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
		show();
	}
}
