public class retail_customer extends customer {
	

	public retail_customer(String name, String surname, String address, String phone, int ID, int operator_ID){

		// Call parent
		super(name, surname, address, phone, ID, operator_ID);
	}

	public void print_customer(){

		System.out.println("*** Customer Screen ***");
		System.out.println("-------------------------------------");
		System.out.println("Name & Surname: " + GetName() + " " + GetSurname());
		System.out.println("Address: "  		+ GetAddress());
		System.out.println("Phone: "  			+ GetPhone());
		System.out.println("ID: "  				+ GetID());
		System.out.println("Operator ID: "  	+ GetOperatorID());
		System.out.println("-------------------------------------");
	}

	public static void main(String[] args){

		retail_customer rc = new retail_customer("Beyza", "Tez", "Baal", "055544343434", 12, 2);

		System.out.println("Name & Surname: "  			+ rc.GetName());
		System.out.println(": "  		+ rc.GetSurname());
		System.out.println("Address: "  		+ rc.GetAddress());
		System.out.println("Phone: "  			+ rc.GetPhone());
		System.out.println("ID: "  				+ rc.GetID());
		System.out.println("Operator ID: "  	+ rc.GetOperatorID());
	}
}