public class operator extends person {
	
	// Variables
	protected int wage;
	protected customer[] customers;

	// Constructor
	public operator (String name, String surname, String address, String phone, int ID, int wage){

			// Call Parent
			super(name, surname, address, phone, ID);

			this.wage = wage;
			customers = new customer[100];

	}

	// Main for Test Purposes
	public static void main(String[] args){

		operator opt1 = new operator("Kagan", "Cakıroglu", "Denizli", "06666", 2, 2500);

		opt1.print_operator();
	}

	// Print Customer Information
	public void print_operator(){

		System.out.println("*** Operator Screen ***");
		System.out.println("-------------------------------------");
		System.out.println("Name & Surname: " + GetName() + " " + GetSurname());
		System.out.println("Address: " 		+ GetAddress());
		System.out.println("Phone: " 		+ GetPhone());
		System.out.println("ID: " 			+ GetID());
		System.out.println("Wage: " 		+ wage);
		System.out.println("-------------------------------------");

		//print_customers();
	}

	// Print orders of customer 
	public void print_customers(){

		boolean isnull = true;

		if(customers != null){

			for(customer a : customers){

				if( a != null ){
					
					isnull = false;
				}
	
			}

			if(isnull == true){
				
				System.out.println("This Operator doesn't have any customers");
				return;
			}


			for(customer customerInstance : customers){

				if(customerInstance != null)
					customerInstance.print_customer();
			}
		}
		
	}

	// Decleare definiton list
	public void define_customers(customer[] CustomerList){

		// Copy Customer Lıst
		customers = CustomerList;
	}
}
