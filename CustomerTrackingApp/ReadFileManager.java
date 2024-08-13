import java.io.File;						// Import File Reader class
import java.util.Scanner;

public class ReadFileManager{

	protected operator[] op_List;
	protected customer[] cust_List;
	protected order[] order_List;


	public ReadFileManager(){

		op_List = new operator[100];
		cust_List = new customer[100];
		order_List = new order[100];
	}
	

	public void ReadTheFile(String filename){

		int operatorIndex = 0;
		int customerIndex = 0;
		int orderIndex = 0;
		
		try {

			// Create file object 
			File txtfile = new File(filename);

			// Create Scanner object
			Scanner in = new Scanner(txtfile);

			while(in.hasNextLine()) {

				String line = in.nextLine();

				// Split line at every ;
				String[] parts = line.split(";");
				
				//System.out.println("Found => " + parts[0]);

				switch (parts[0]) {
					case "operator":
							
						if(parts.length != 7){

							System.out.println("Corrupted Operator entry, ignored");
							break;
						}
						//System.out.println("Customer found");
						op_List[operatorIndex++] = new operator(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));

						break;

					case "customer":
						
						if(parts.length != 7){

							System.out.println("Corrupted customer entry, ignored");
							break;
						}
						//System.out.println("Customer found");
						cust_List[customerIndex++] = new customer(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));

						break;

					case "order":

						if(parts.length != 6){

							System.out.println("Corrupted order entry, ignored");
							break;
						}
						//System.out.println("Order found");
						order_List[orderIndex++] = new order(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));

						break;

					case "retail_customer":
						
						if(parts.length != 7){

							System.out.println("Corrupted retail customer entry, ignored");
							break;
						}
						//System.out.println("Retail Customer found");
						cust_List[customerIndex++] = new retail_customer(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));

						break;

					case "corporate_customer":

						if(parts.length != 8){

							System.out.println("Corrupted corporate customer entry, ignored");
							break;
						}
						//System.out.println("Corporate Customer found");
						cust_List[customerIndex++] = new corporate_customer(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), parts[7]);
						
						break;

					default:

						System.out.println("Unknown type encountered, ignored");
						break;
				}
				
				// New line
				//System.out.println();
				
			}

			in.close();
		} catch (Exception e) {

			System.out.println("File reading was not successfull!");
			e.printStackTrace();
		}
	}

	public void printCustList(){

		for (customer corporate_customer : cust_List) {
			
			if(corporate_customer != null)
				corporate_customer.print_customer();
		}
	}

	public void printOrdertList(){

		for (order orderInstance : order_List) {
			
			if(orderInstance != null)
				orderInstance.print_order();
		}
	}

	public void printOperatorList(){

		for (operator opInstance : op_List) {
			
			if(opInstance != null)
				opInstance.print_operator();
		}
	}

	public int FindPerson(int ID){

		for (customer customer : cust_List) {
			
			if( customer != null ){

				if(customer.ID == ID){
					
					customer.print_customer();
					customer.print_orders();
					return 0;
				}
			}
		}

		for (operator operator : op_List) {
			
			if( operator != null ){

				if(operator.ID == ID){

					operator.print_operator();
					operator.print_customers();
					return 0;
				}
			}
		}

		return -1;
	}

	public void LinkCustomerOrderList(){
		int index = 0;

		order[] copyCustList = new order[100];

		for (customer customerM : cust_List){

			if(customerM != null ) {

				for (order orderM : order_List) {

					if(orderM != null){
						
						//foundCustomer = FindCustomer(orderInstance.customer_ID);
		
						if(orderM.customer_ID == customerM.GetID()){
							
							//System.out.println(" Found same with ID ");
							copyCustList[index++] = orderM;
						}
					}
				}
				if(copyCustList.length != 0)
					customerM.define_orders(copyCustList);

				// Reset List
				copyCustList = new order[100];
			}
			
		}

	}

	public void LinkOperatorCustomerList(){

		int index = 0;

		customer[] copyOperatorList = new customer[100];

		for (operator operatorM : op_List){

			if(operatorM != null ) {

				for (customer customerM : cust_List) {

					if(customerM != null){
						
						//foundCustomer = FindCustomer(orderInstance.customer_ID);
		
						if(customerM.operator_ID == operatorM.GetID()){

							//System.out.print(" Customer => " + customerM.operator_ID );
							//System.out.print(" Operator => " + operatorM.GetID());
							//System.out.println("");
							
							copyOperatorList[index++] = customerM;
						}
					}
				}

				if(copyOperatorList.length != 0)
					operatorM.define_customers(copyOperatorList);

				// Reset List
				copyOperatorList = new customer[100];
			}
			
		}

	}	

	// Defines Customer & Order Arrays for persons
	public void LinkData(){
		
		LinkCustomerOrderList();
		LinkOperatorCustomerList();
	}



	public static void main(String[] args){

		ReadFileManager t = new ReadFileManager();
		t.ReadTheFile("content.txt");
		t.LinkData();


		//t.printCustList();

		//t.printOrdertList();
		//t.printOperatorList();

		/* 
		for(customer cust : t.cust_List){

			if(cust != null){

				System.out.println("Name : " + cust.name + " ====>");
				cust.print_orders();
				System.out.println("---------------------");	
			}
				
		}
		*/
		/* 
		System.out.println("////////////////////////////////");

		for(operator cust : t.op_List){

			if(cust != null){

				System.out.println("Name : " + cust.name + " ====>");
				cust.print_customers();
				System.out.println("---------------------");	
			}
				
		}
		*/
	}
}
