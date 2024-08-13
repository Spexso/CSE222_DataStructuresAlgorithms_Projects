public class BubbleSort extends SortAlgorithm {

	public BubbleSort(int input_array[]) {
		super(input_array);
	}
	
    @Override
    public void sort() {
    	
        // Reserve length of array to a variable
        int size = arr.length;
        // Set flag for to check if array is sorted
        boolean is_sorted = false;

        // Traverse the array by compering adjacent elements until its sorted
        for(int i = 0; i < size - 1;i++){
            // Set flag as true
            is_sorted = true;

            for(int j = 1; j < size - i; j++){

                // if next element is lower than current index
                // Than Swap them
                if(arr[j-1] > arr[j]){

                    // Set flag so outer loop wont end
                    is_sorted = false;
                    swap(j, j-1);
                }

                // Increase counter at every if statement
                comparison_counter++;
            }

            // If no sorting happened then array is sorted
            // So terminate
            if(is_sorted == true)
                break;
        }
    }
    
    @Override
    public void print() {
    	System.out.print("Bubble Sort\t=>\t");
    	super.print();
    }
}
