package tables;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import javafx.stage.Stage;


public class EditProduct extends AddEditProduct{
	Product prod;
	Catalog catalog;
	
	
	public EditProduct(Product p, Catalog c, Stage stage){
		super(stage);
		
		this.prod = p;
		this.catalog = c;
		
		txtName.setText(p.getProductName());
		//cmbCatalog.setValue(p.);;
		txtPrice.setText(String.valueOf(p.getUnitPrice()));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy"); // single M and d to accomodate both one digit and two digit values
		LocalDate dt = LocalDate.from(dtf.parse(p.getMfgDate()));
		date.setValue(dt);

		
		txtQty.setText(String.valueOf(p.getQuantityAvail()));;
		txtProductId.setVisible(false);
		txtProductId.setText(String.valueOf(p.getProductId()));
		
	}
	
	
	@Override
	public void performAddEdit(){
		
		btnSave.setOnAction(evt -> {
			hide();
			Catalog cat = cmbCatalog.getSelectionModel().getSelectedItem();
			
			//TODO convert this section to lambda expression
			
			Iterator<Product> listProd = DefaultData.PRODUCT_LIST_DATA.get(cat).iterator();
			
			while(listProd.hasNext()){
				Product p = listProd.next();
				
				// String str = txtProductId.getText().trim();
				
				// p.getProductId() != null && (str != null && str != "")
				if(p.getProductId() == Integer.parseInt(txtProductId.getText().trim())){
					System.out.println("dkjfasd;fj : " + p.getProductId());
						listProd.remove();
				}
			}
			
		
			
			Product prod = new Product(Integer.parseInt(txtProductId.getText().trim()), txtName.getText().trim(), date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), 
									Integer.parseInt(txtQty.getText().trim()), Double.parseDouble(txtPrice.getText().trim()));
			
			
			
			
			
			DefaultData.PRODUCT_LIST_DATA.get(cat).add(prod);
			
			
			// find out if the catalog of the product has changed
			if(!cat.equals(this.catalog)){
				
				DefaultData.PRODUCT_LIST_DATA.get(this.catalog).remove(this.prod);
			}
			
			
			ProductCatalog pc = new ProductCatalog(stage);
			pc.show();
		});
		
	}

}
