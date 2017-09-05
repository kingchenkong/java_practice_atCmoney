
public class insertionSort {

	public static void main(String[] args) {

		String str =  "the UN Security Council has a discuss at 10 a.m. ET. 1.5";
		String[] arr = str.split(" ");

		// print
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if( arr[i].compareToIgnoreCase(arr[j]) < 0 ) {
					String temp = arr[i];
					for(int k = i; k > j; k--) {
						arr[k] = arr[k-1];				
					}
					arr[j] = temp;		
				}
			}
		}

		System.out.println("------------------------");
		// print
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);



	}

}
