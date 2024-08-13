public class order {
		
	// Variables
	protected String product_name;
	protected int count;
	protected int total_price;
	protected int status;
	protected int customer_ID;

	// Constructor
	public order(String product_name, int count, int total_price, int status, int customer_ID){

		this.product_name = product_name;
		this.count = count;
		this.total_price = total_price;
		this.status = status;
		this.customer_ID = customer_ID;
	}

	public static void main(String[] args){

		order order1 = new order("Chocolate", 12, 5, 2, 21);

		order1.print_order();
	}

	public void print_order() {

		String StatusString = ProcessStatusCode(GetStatus());

		System.out.println("Product Name: " + GetProductName());
		System.out.println("Count: " + GetCount());
		System.out.println("Total Price: " + GetTotalPrice());
		System.out.println("Status: " + StatusString);
		System.out.println("customer ID: " + GetCustomerID());

	}

	private String ProcessStatusCode(int StatusCode){

		if(StatusCode == 0){

			return "Initialized";
		}
		else if(StatusCode == 1){

			return "Processing";
		}
		else if(StatusCode == 2){

			return "Completed";
		}
		else if(StatusCode == 3){

			return "Cancelled";
		}
		else
			return "Undefined";
	}

	public String GetProductName(){

		return product_name;
	}

	public int GetCount(){

		return count;
	}

	public int GetTotalPrice(){

		return total_price;
	}

	public int GetStatus(){

		return status;
	}

	public int GetCustomerID(){

		return customer_ID;
	}
}