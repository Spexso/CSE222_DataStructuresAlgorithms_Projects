public class person {
	
	// Variables
	protected String name;
	protected String surname;
	protected String address;
	protected String phone;
	protected int ID; 

	// Constructor
	public person(String name, String surname, String address, String phone, int ID) {

		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.ID = ID;
	}

	// For test purposes
	public static void main(String[] args){

		person personOr = new person("Orhun", "Ozturk", "GocaMoGLA", "05316663169", 2020140028);

		System.out.println("Name: " 	+ personOr.GetName()	);
		System.out.println("Surname: " 	+ personOr.GetSurname()	);
		System.out.println("Address: " 	+ personOr.GetAddress()	);
		System.out.println("Phone: " 	+ personOr.GetPhone()	);
		System.out.println("ID: " 		+ personOr.GetID()		);
	}	

	public String GetName() {

		return name;
	}

	public String GetSurname() {

		return surname;
	} 

	public String GetAddress() {

		return address;
	} 

	public String GetPhone() {

		return phone;
	} 

	public int GetID() {

		return ID;
	} 


}