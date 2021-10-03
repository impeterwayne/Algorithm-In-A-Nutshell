package QuickSort;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12, 4, 9 , 32, 5, 8, 44, 1, 22, 81, 3, 7};
		quickSort(arr, 0, arr.length-1);
		for(int i=0 ; i<arr.length; i++)
		{
			System.out.print(arr[i] + "\t");
			 
		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int index;
		if(low<high)
		{
			index = partition(arr, low, high);
			quickSort(arr, low, index-1);
			quickSort(arr, index+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot  = arr[low];
		int left = low;
		int right = high;
		while(left<right)
		{
			while(arr[left]<= pivot&&left<arr.length-1)
			{
				left++;
			}
			while(arr[right]>pivot&&right>0)
			{
				right--;
			}
			if(left<right)
			{
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		int temp = arr[right];
		arr[right] = arr[low];
		arr[low] = temp;
		return right;
	}

}
