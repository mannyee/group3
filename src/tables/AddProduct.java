package tables;

import java.time.format.DateTimeFormatter;




public class AddProduct extends AddEditProduct {

	
	public AddProduct() {
		
		super();
	}
	
	
	@Override
	public void performAddEdit(){
		btnSave.setOnAction(evt -> {
			Catalog c = cmbCatalog.getSelectionModel().getSelectedItem();
		
			Product p = new Product(Integer.valueOf(++DefaultData.PRODUCT_ID), txtName.getText().trim(), date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), 
									Integer.parseInt(txtQty.getText().trim()), Double.parseDouble(txtPrice.getText().trim()));
			
			
			DefaultData.PRODUCT_LIST_DATA.get(c).add(p);
			hide();
			
			ProductCatalog pc = new ProductCatalog();
			pc.show();
		});
		
	}
}

