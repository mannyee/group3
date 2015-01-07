package tables;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProceedWithCheckout extends Stage {

	public ProceedWithCheckout() {
		VBox root = new VBox();
		Label paymentLbl = new Label("Payment Method");
		paymentLbl.setFont(new Font("Arial", 16));
		HBox paymentBox = new HBox();
		paymentBox.setAlignment(Pos.CENTER);
		paymentBox.getChildren().add(paymentLbl);

		GridPane grid = new GridPane();
		grid.getStyleClass().add("bounding-border");
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(new Label("Name on Card"), 0, 0);
		grid.add(new Label("Card Number"), 0, 1);
		grid.add(new Label("Card Type"), 0, 2);
		grid.add(new Label("Expiration Date"), 0, 3);

		TextField cardName = new TextField();
		TextField cardNumber = new TextField();
		ComboBox<String> cardType = new ComboBox<String>();
		cardType.getItems().addAll("Visa", "Master");
		TextField expirationDate = new TextField();

		grid.add(cardName, 1, 0);
		grid.add(cardNumber, 1, 1);
		grid.add(cardType, 1, 2);
		grid.add(expirationDate, 1, 3);

		HBox gridBox = new HBox();
		gridBox.setPadding(new Insets(20, 0, 20, 0));
		gridBox.setAlignment(Pos.CENTER);
		gridBox.getChildren().addAll(grid);

		Button checkOutBtn = new Button("Proceed With Checkout");
		checkOutBtn.setOnAction(evt ->{
			TermsAndCondition termsAndCondition = new TermsAndCondition();
			termsAndCondition.show();
			hide();
		});
		Button backToCard = new Button("Back To Cart");


		HBox buttonsBox = new HBox(20);

		buttonsBox.setAlignment(Pos.CENTER);
		buttonsBox.getChildren().addAll(checkOutBtn, backToCard);

		root.getChildren().addAll(paymentBox, gridBox, buttonsBox);
		Scene scene = new Scene(root, 400, 300);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
	}

}
