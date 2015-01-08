package tables;

import java.time.format.DateTimeFormatter;

import javafx.stage.Stage;




public class AddProduct extends AddEditProduct {

	
	public AddProduct(Stage stage) {
		
		super(stage);
	}
	
	
	@Override
	public void performAddEdit(){
		btnSave.setOnAction(evt -> {
			Catalog c = cmbCatalog.getSelectionModel().getSelectedItem();
		
			Product p = new Product(Integer.valueOf(++DefaultData.PRODUCT_ID), txtName.getText().trim(), date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), 
									Integer.parseInt(txtQty.getText().trim()), Double.parseDouble(txtPrice.getText().trim()));
			
			
			DefaultData.PRODUCT_LIST_DATA.get(c).add(p);
			hide();
			
			ProductCatalog pc = new ProductCatalog(stage);
			pc.show();
		});
		
	}
}

