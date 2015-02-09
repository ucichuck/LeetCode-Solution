package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

/*	Another way is to calculate every digit. 
 * For example, assuming we are going to solve the problem when n = 3 and k = 5. 
 * In fact, because k starts from 1, we need to subtract 1 from it to make it starting from 0. 
 * So we are going to find the permutation 4 now. 
 * To calculate the first digit, we can calculate it by k % (n ¨C 1)! = 4 / 2! = 2, 
 * which is the position of 3 in array [1,2,3]. Now we need to delete 3 from the array, 
 * so the array becomes [1, 2]. And k should become 4 % 2! = 0. Now we calculate k / (n ¨C 2)! = 0 / 1 = 0,
 *  which is the position of 1 in array [1, 2]. So the second digit should be 1. We need to delete 1 from the array.
 *   And there is only one entry left in the array. So the final digit should be 2. 
 *   Finally we get the permutation: 312.
*/	
	
	public String getPermutation(int n, int k) {
        int t = 1;
        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            t = t * i;
            numbers.add(i);
        }
        t /= n;
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 1; i--) {
            int p = k / t;
            int np = numbers.get(p);
            sb.append(String.valueOf(np));
            numbers.remove(p);
            k %= t;
            t /= i;
        }
        sb.append(String.valueOf(numbers.get(0)));
        return sb.toString();
    }
}
