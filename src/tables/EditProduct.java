package tables;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;


public class EditProduct extends AddEditProduct{
	
	public EditProduct(Product p, Catalog c){
		super();
		
		txtName.setText(p.getProductName());
		//cmbCatalog.setValue(p.);;
		txtPrice.setText(String.valueOf(p.getUnitPrice()));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy"); // single M and d to accomodate both one digit and two digit values
		LocalDate dt = LocalDate.from(dtf.parse(p.getMfgDate()));
		date.setValue(dt);

		
		txtQty.setText(String.valueOf(p.getQuantityAvail()));;
		txtProductId.setVisible(true);
		txtProductId.setText(String.valueOf(p.getProductId()));
		
	}
	
	
	@Override
	public void performAddEdit(){
		
		btnSave.setOnAction(evt -> {
			Integer pid = null;
			hide();
			Catalog cat = cmbCatalog.getSelectionModel().getSelectedItem();
			
			//TODO convert this section to lambda expression
			
			Iterator<Product> listProd = DefaultData.PRODUCT_LIST_DATA.get(cat).iterator();
			
			while(listProd.hasNext()){
				Product p = listProd.next();
				
				System.out.println("edit id: " + txtProductId.getText().trim());
				System.out.println("product id from table: " + p.getProductId());
				
//				Integer.parseInt(txtProductId.getText().trim())
				String str = txtProductId.getText().trim();
				
				if(p.getProductId() != null && (str != null && str != "")){
					
					if(p.getProductId() == Integer.parseInt(txtProductId.getText().trim())){
						pid = p.getProductId();
						listProd.remove();
					}
				}
			}
			
		
			Product prod = new Product(pid, txtName.getText().trim(), date.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), 
									Integer.parseInt(txtQty.getText().trim()), Double.parseDouble(txtPrice.getText().trim()));
			
			
			DefaultData.PRODUCT_LIST_DATA.get(cat).add(prod);
			
			ProductCatalog pc = new ProductCatalog();
			pc.show();
		});
		
	}

}
