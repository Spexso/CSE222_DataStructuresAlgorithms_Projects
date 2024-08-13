public class MergeSort extends SortAlgorithm {
	
	public MergeSort(int input_array[]) {
		super(input_array);
	}
	
    // Merges two subarrays of arr[].
    // First subarray is arr[left..mid]
    // Second subarray is arr[mid+1..right]
	private void merge(int left, int mid, int right){
        
        // Counter variables
        int x, y;

        // Temp arrays for storing compated 
        int size1 = mid - left + 1;
        int size2 = right - mid;

        // Initialize arrays for sorting
        int leftArr[] = new int[size1];
        int rightArr[] = new int[size2];

        // Group temporary arrays for copying
        for (x = 0; x < size1; ++x)
            leftArr[x] = arr[left + x];

        for (y = 0; y < size2; ++y)
            rightArr[y] = arr[mid + 1 + y];

        // Reset counter
        x = 0; 
        y = 0;

        // Initial index of merged subarray
        int m = left;
        
        // Merge loop
        while (y < size2 && x < size1){

            // Count number of comparisons between cells
            comparison_counter++;

            // Select the smaller of two elements
            // Then assign it
            if (leftArr[x] <= rightArr[y]){

                // Assign from left array list 
                // Then increase left array counter
                arr[m] = leftArr[x];
                x++;
            }
            else
            {
                // Else assign from right array list 
                // Then increase right array counter
                arr[m] = rightArr[y];
                y++;
            }

            m++;
        }

        // Until index of left array reaches middle of initial list assign elements 
        while (x < size1){

            arr[m] = leftArr[x];
            x++;
            m++;
        }

        // Until index of right array reaches end of initial list assign elements 
        while (y < size2){

            arr[m] = rightArr[y];
            y++;
            m++;
        }
    }

    private void sort(int left, int right){
            
        // Check if the segment is valid with more than one element
        if (left < right) {

            // Calculate the middle point of the segment to divide the array into two halves
            // Avoids the potential overflow that (l+r)/2 might cause
            int mid = left + (right - left) / 2;

            //System.out.println("Mid=> " + mid + " Left=> " + left + " right=> "+ right);
            
            // Recursively sort the first half of the array from index l to m
            sort(left, mid);
            
            // Recursively sort the second half of the array from index m+1 to r
            sort(mid + 1, right);

            //System.out.println("Mid=> " + mid + " Left=> " + left + " right=> "+ right);
            //System.out.println("Before merge");

            // Merge the two sorted halves back together
            merge(left, mid, right);
        }
    }
    
    @Override
    public void sort() {

        int left = 0;
        int right = arr.length - 1;

    	sort(left, right);
    }
    
    @Override
    public void print() {
    	System.out.print("Merge Sort\t=>\t");
    	super.print();
    }
}
