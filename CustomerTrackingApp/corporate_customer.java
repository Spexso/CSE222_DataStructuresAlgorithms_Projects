public class corporate_customer extends customer {
	
	private String company_name;

	public corporate_customer(String name, String surname, String address, String phone, int ID, int operator_ID, String company_name){

		// Call parent
		super(name, surname, address, phone, ID, operator_ID);
		
		this.company_name = company_name;
	}

	public static void main(String[] args){

		corporate_customer cp = new corporate_customer("Beyza", "Tez", "Baal", "055544343434", 12, 2, "JS Holding");

		cp.print_customer();
	}

	public void print_customer(){

		System.out.println("*** Customer Screen ***");
		System.out.println("-------------------------------------");
		System.out.println("Name & Surname: " + GetName() + " " + GetSurname());
		System.out.println("Address: "  		+ GetAddress());
		System.out.println("Phone: "  			+ GetPhone());
		System.out.println("ID: "  				+ GetID());
		System.out.println("Operator ID: "  	+ GetOperatorID());
		System.out.println("Company Name: "  	+ GetCompanyName());
		System.out.println("-------------------------------------");
	}
	


	public String GetCompanyName(){
		
		return company_name;
	}

}