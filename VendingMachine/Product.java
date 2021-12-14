package VendingMachine;

public class Product{
	private int pid;
	private int price;
	private ProductType productType;

	public Product(int pid, int price,ProductType productType) {
		this.pid = pid;
		this.price = price;
		this.productType = productType;
	}
	public int getPid() {
		return pid;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", price=" + price + ", productType=" + productType + "]";
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public ProductType getproductType() {
		return productType;
	}
	public void setproductType(ProductType type) {
		this.productType = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}