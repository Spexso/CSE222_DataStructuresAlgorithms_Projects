public class QuickSort extends SortAlgorithm {

	public QuickSort(int input_array[]) {
		super(input_array);
	}
	
    private int partition(int low, int high){
        
        int pivot = 0;
        int i = 0;

        // Choosing the pivot
        pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(i, j);
            }

            comparison_counter++;
        }
        swap(i + 1, high);
        return (i + 1);
    }

    private void sort(int low, int high){
        
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pivot = partition(low, high);

            // Separately sort elements before
            // partition and after partition
            sort(low, pivot - 1);
            sort(pivot + 1, high);
        }
    }

    @Override
    public void sort() {
    	
        // Select pivot
        sort(0, arr.length - 1);
    }

    @Override
    public void print() {
    	System.out.print("Quick Sort\t=>\t");
    	super.print();
    }
}