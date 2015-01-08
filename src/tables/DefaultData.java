package tables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Shipping;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class DefaultData {

	public static final Catalog BOOKS_CATALOG 		= new Catalog("Books");
	public static final Catalog CLOTHES_CATALOG 	= new Catalog("Clothes");
	public static final Product MESSIAH_BOOK 		= new Product("Messiah Of Dune", "11/11/2000", 20, 15.00);
	public static final Product GONE_BOOK 			= new Product("Gone with the Wind", "12/5/1995", 15, 12.00);
	public static final Product GARDEN_BOOK 		= new Product("Garden of Rama", "1/1/2005", 5, 18.00);
	public static final Product PANTS 				= new Product("Pants", "11/1/2000", 20, 15.00);
	public static final Product SKIRTS 				= new Product("Skirts", "1/5/1995", 15, 12.00);
	public static final Product TSHIRTS 			= new Product("T-Shirts", "1/10/2005", 10, 22.00);
	public static int PRODUCT_ID			= 1;
	
	public static List<Product> listProd 			= new ArrayList<Product>();
	public static List<Product> listClothes 		= new ArrayList<Product>();
	static{
		listProd.add(MESSIAH_BOOK);
		listProd.add(GONE_BOOK);
		listProd.add(GARDEN_BOOK);
		
		listClothes.add(PANTS);
		listClothes.add(SKIRTS);
		listClothes.add(TSHIRTS);
		
	}
	
	// Shipping Address Data
	public static final ObservableList<Shipping> shippingItemList 				= FXCollections.observableArrayList(
																						new Shipping("1000 N.", "Fairfield", "Iowa", "52557"), 
																						new Shipping("2000 N.", "Fairfield", "NY", "42997"));
	
	public static final ObservableList<Catalog> CATALOG_LIST_DATA 				= FXCollections.observableArrayList(BOOKS_CATALOG, CLOTHES_CATALOG);
	public static ObservableMap<Catalog, List<Product>> PRODUCT_LIST_DATA		= FXCollections.observableHashMap();
	public static final List<String> DISPLAY_PRODUCT_FIELDS 					= Arrays.asList("Item Name", "Price", "Quantity Available", "Review");
	public static ObservableList<FinalOrder> Final_order_data 					= FXCollections.observableArrayList();

	
	static {
		MESSIAH_BOOK
				.setDescription("You saw how good Dune was. \nThis is Part 2 of this \nunforgettable trilogy.");
		GONE_BOOK
				.setDescription("A moving classic that tells \na tale of love and \na tale of courage.");
		GARDEN_BOOK
				.setDescription("Highly acclaimed Book \nof Isaac Asimov. A real \nnail-biter.");
		PANTS.setDescription("I've seen the Grand Canyon. \nI've camped at Yellowstone. But nothing \non earth compares to the look and feel of \nthese pants.");
		SKIRTS.setDescription("Once this brand of skirts \nbecomes well-known, watch out!");
		TSHIRTS.setDescription("Can be worn by men or women. \nAlways in style.");

	//	PRODUCT_LIST_DATA.put(BOOKS_CATALOG, Arrays.asList(MESSIAH_BOOK, GONE_BOOK, GARDEN_BOOK));
		PRODUCT_LIST_DATA.put(BOOKS_CATALOG, listProd);

//		PRODUCT_LIST_DATA.put(CLOTHES_CATALOG,Arrays.asList(PANTS, SKIRTS, TSHIRTS));
		PRODUCT_LIST_DATA.put(CLOTHES_CATALOG, listClothes);

	}
}
