package tables;

public class FinalOrder {
	String item;
	int quantity;
	double price;
	double total;
	public FinalOrder(String string, int i, double d, double e) {
		this.item = string;
		this.quantity = i;
		price = d;
		total = e;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
	    return item;
	}   
	@Override
	public int hashCode() {
	    int hash = 0;
	    hash += (item != null ? item.hashCode() : 0);
	    return hash;
	}
	
}
