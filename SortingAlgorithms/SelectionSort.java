public class SelectionSort extends SortAlgorithm {

	public SelectionSort(int input_array[]) {
		super(input_array);
	}

    @Override
    public void sort() {

        // Index variable to hold element with minimum value
        int enc_min;

        // Main loop traverses whole array
        for(int i = 0; i < arr.length - 1; i++){

            // Assign the index that searching is started from
            enc_min = i;

            for(int j = i+1; j < arr.length; j++){

                // If encountered element is lower than current minimum index 
                // Than assign it as new minimum 
                if(arr[j] < arr[enc_min])
                    enc_min = j;

                comparison_counter++;
            }

            // Swap the encountered minimum
            //System.out.println(i + " | " + enc_min );
            swap(enc_min, i);
        }
    }

    @Override
    public void print() {
    	System.out.print("Selection Sort\t=>\t");
    	super.print();
    }
}
