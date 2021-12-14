package VendingMachine;

import java.util.HashMap;
import java.util.Vector;

public class VendingMachine {
	private HashMap<Integer,Product> slots;
	private int capacity;
	
	public VendingMachine(int capacity) {
		this.capacity = capacity;
		slots = new HashMap<>();
	}
	public HashMap<Integer, Product> getSlots() {
		return slots;
	}
	public void setSlots(HashMap<Integer, Product> slots) {
		this.slots = slots;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	int addProduct(Product p){
		if(slots.size() >= capacity){
			return 0;
		}
		if(p == null)return 0 ;
		slots.put(p.getPid(), p);
		return 1;
	}

	void removeProductFromInventory(Vector<Product> productList){
		for (Product product : productList) {
			slots.remove(product.getPid());
		}
	}

	int checkout(Vector<Product> productList, PaymentTypes paymentTypes){
		int totalPrice =0 ;
		for (Product product : productList) {
			totalPrice += product.getPrice();
		}
		Payments payment = new Payments();
		int status = payment.makePayment(totalPrice,paymentTypes);
		if(status == 1){
			removeProductFromInventory(productList);
			return 1;
		}
		return 0; 
	}

	private Vector<Product> SelectProductsFromSelection() {
		Vector<Product> prodList= new Vector<>();
		prodList.add( this.slots.get(1));
		prodList.add( this.slots.get(2));
		return prodList;
	}
	
	private static void dispenseProducts(Vector<Product> selectedProducts) {
		
		for (Product product : selectedProducts) {
			System.out.println(product);	
		}
	}
	
	public static void main(String ... args) {
		VendingMachine vendingMachine = new VendingMachine(10);

		vendingMachine.addProduct(new Product(1, 12, ProductType.SNACK));
		vendingMachine.addProduct(new Product(2, 12, ProductType.DRINK));
		
		while(true){
			if( vendingMachine.slots.size() == 0 )break;
			Vector<Product> selectedProducts =  vendingMachine.SelectProductsFromSelection();
			int status = vendingMachine.checkout(selectedProducts, PaymentTypes.CARD);
			if(1 == status){
				dispenseProducts(selectedProducts);
			}
		}
	}
}