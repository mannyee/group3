package tables;



import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TermsAndCondition extends Stage {

	public TermsAndCondition() {
		this.setTitle("Terms And Condition");
		VBox root = new VBox();
		Label termsAndCondition = new Label("Terms And Condition");
		termsAndCondition.getStyleClass().add("custom-tile-font-style");
//		termsAndCondition.setFont(new Font("Arial", 16));
		HBox paymentBox = new HBox();
		paymentBox.setAlignment(Pos.CENTER);
		paymentBox.getChildren().add(termsAndCondition);

		TextArea text = new TextArea("this is text Area");
		text.getStyleClass().add("bounding-border-textArea");
		

		HBox gridBox = new HBox();
		gridBox.setPadding(new Insets(20, 0, 20, 0));
		gridBox.setAlignment(Pos.CENTER);
		gridBox.getChildren().addAll(text);

		Button acceptTerms = new Button("Accept Terms and Conditions");
		acceptTerms.setOnAction(evt -> {
			FinalOrderWindow finalOrder = new FinalOrderWindow();
			finalOrder.show();
			hide();
		});
		Button exit = new Button("Exit E-Bazzar");
		exit.setOnAction(evt -> Platform.exit());

		HBox buttonsBox = new HBox(20);

		buttonsBox.setAlignment(Pos.CENTER);
		buttonsBox.getChildren().addAll(acceptTerms, exit);

		root.getChildren().addAll(paymentBox, gridBox, buttonsBox);
		Scene scene = new Scene(root, 550, 300);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
		show();
	}

}
