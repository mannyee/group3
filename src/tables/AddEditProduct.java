package tables;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class AddEditProduct extends Stage{
	
	 Label lblProductName;
	 TextField txtName;
	 Label lblCatalog;
	 ComboBox<Catalog> cmbCatalog;
	 Label lblPrice;
	 TextField txtPrice;
	 Label lblMfg;
	 DatePicker date;
	 Label lbtQty;
	 TextField txtQty;
	 Button btnSave;
	 Button btnClose;
	 HBox btnBox;
	 TextField txtProductId;

	public AddEditProduct() {
		
		final Text header = new Text("Add New Product");
        header.setFont(new Font("Arial", 16));
        HBox labelHbox = new HBox(10);
        labelHbox.setAlignment(Pos.CENTER);
        labelHbox.getChildren().add(header);
        
        
        lblProductName = new Label("Product Name");
        txtName = new TextField();
        lblCatalog = new Label("Catalog");
        
		cmbCatalog = new ComboBox<Catalog>();
		cmbCatalog.getItems().setAll(DefaultData.CATALOG_LIST_DATA);
		cmbCatalog.setValue(DefaultData.CATALOG_LIST_DATA.get(0));
		
		lblPrice = new Label("Price Per Unit");
		txtPrice = new TextField();
		
		lblMfg = new Label("Mfg. Date");
		date = new DatePicker();
		
		lbtQty = new Label("Quantity");
		txtQty = new TextField();
		
		
		
		btnSave = new Button("Save");
		btnClose = new Button("Close");
		
		performAddEdit();
		
		
		
		btnClose.setOnAction(evt -> {
			hide();
			ProductCatalog pc = new ProductCatalog();
			pc.show();
		});
		
		btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(btnSave, btnClose);
		
		txtProductId = new TextField();
		txtProductId.setVisible(false);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10); 
		grid.setHgap(10);
		grid.add(labelHbox, 0, 0, 2, 1);
		grid.add(lblProductName, 0, 1);
		grid.add(txtName, 1, 1);
		grid.add(lblCatalog, 0, 2);
		grid.add(cmbCatalog, 1, 2);
		grid.add(lblPrice, 0, 3);
		grid.add(txtPrice, 1, 3);
		grid.add(lblMfg, 0, 4);
		grid.add(date, 1, 4);
		grid.add(lbtQty, 0, 5);
		grid.add(txtQty, 1, 5);
		grid.add(btnBox,0,6);
		grid.add(txtProductId, 0, 7);
		
        
   
        Scene scene = new Scene(grid,300, 250);  
		setScene(scene);
	}

	public void performAddEdit() {
		// TODO Auto-generated method stub
		
	}
}
