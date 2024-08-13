public class customer extends person{
	
	// Order List variable 
	protected order[] orders;

	// Operator of Customer
	protected int operator_ID;

	public customer(String name, String surname, String address, String phone, int ID, int operator_ID){

		// Call parent
		super(name, surname, address, phone, ID);

		this.operator_ID = operator_ID;	
		orders = new order[100];
	}

	public static void main(String[] args){

		customer customer1 = new customer("Kagan", "Cakıroglu", "Mugla", "05393126614", 2, 1);

		customer1.print_customer();
	}

	// Print Customer Information
	public void print_customer(){

		System.out.println("*** Customer Screen ***");
		System.out.println("-------------------------------------");
		System.out.println("Name: " 		+ GetName());
		System.out.println("Surname: " 		+ GetSurname());
		System.out.println("Address: " 		+ GetAddress());
		System.out.println("Phone: " 		+ GetPhone());
		System.out.println("ID: " 			+ GetID());
		System.out.println("Operator ID: " 	+ operator_ID);
		System.out.println("-------------------------------------");
		//print_orders();
	}

	// Print orders of customer 
	public void print_orders(){

		int count = 0;

		if(orders.length == 0){
			
			System.out.println("This customer doesn't have any orders");
			return;
		}

		if(orders != null){

			for(order orderinstance : orders){

				if(orderinstance != null)
					count++;
					System.out.println("Order #" + count + " => ");
					orderinstance.print_order();
			}
		}
		
	}

	// Decleare definiton list
	public void define_orders(order[] OrderList){

		// Copy Order List
		orders = OrderList;
	}

	public int GetOperatorID(){

		return operator_ID;
	}


}