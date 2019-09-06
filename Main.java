import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
//		int n = 5;
//		int[] arr1 = {9, 20, 28, 18, 11};
//		int[] arr2 = {30, 1, 21, 17, 28};
//		// return ["#####","# # #", "### #", "# ##", "#####"]

		int n = 6;
		int[] arr1 = {46,33,33,22,31,50};
		int[] arr2 = {27,56,19,14,14,10};
		// return ["######", "### #", "## ##", " #### ", " #####", "### # "]

		System.out.println(Arrays.toString(new Solution().solution(n, arr1, arr2)));
	}
}

class Solution {
	  public String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];

	      for (int i = 0; i < n; i++) {
	    	  answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
	    	  int diff = n - answer[i].length();
	    	  while (diff-- != 0) {
	    		  answer[i] = "0" + answer[i];
	    	  }
	    	  answer[i] = answer[i].replace('1','#').replace('0',' ');
	      }
	      
	      return answer;
	  }
}