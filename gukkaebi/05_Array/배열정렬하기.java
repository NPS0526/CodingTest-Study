/*input
[1,-5,2,4,3]
[2,1,1,3,2,5,4]
[6,1,7]*/

/*output
[-5,1,2,3,4]
[1,1,2,2,3,4,5]
[1,6,7]
 */

import java.util.Arrays;

private static int[] solution(int[] arr) {
//	V1
	Arrays.sort(arr);
	return arr

//	V2
	int[] clone = arr.clone();
	Arrays.sort(clone);
	return clone;		
}


