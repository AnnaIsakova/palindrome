import java.util.ArrayList;
import java.util.Arrays;

public class IsakovaAnnaPalindrome {

    static boolean isPrime(long n) {
        if (n % 2 == 0) return false;
        for(int i = 3; i*i <= n; i += 2) {
            if(n%i == 0)
                return false;
        }
        return true;
    }

    static ArrayList<Long> findPrimes(int lower, int upper){
        ArrayList<Long> primes = new ArrayList<>();
        for (long i = upper; i >= lower ; i--) {
            if (isPrime(i)){
                primes.add(i);
            }
        }
        return primes;
    }

    static boolean isPalindrome(long n){
        long reverse = 0;
        long num = n;
        while (num != 0)
        {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return reverse == n;
    }

    static long[] findGreatestPalindrome(ArrayList<Long> numsToMul){
        long[] nums = new long[3];
        long result = 0;
        long max = 0;
        for (int i = 0; i < numsToMul.size(); i++) {
            for (int j = i; j < numsToMul.size(); j++) {
                result = numsToMul.get(i) * numsToMul.get(j);
                if (isPalindrome(result) && result > max){
                    max = result;
                    nums[0] = numsToMul.get(i);
                    nums[1] = numsToMul.get(j);
                    nums[2] = max;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        ArrayList<Long> primes = findPrimes(10000, 99999);
        long[] res = findGreatestPalindrome(primes);
        long after = System.currentTimeMillis();
        System.out.println(after - before); //2670 ms
        System.out.println(Arrays.toString(res)); //[33211, 30109, 999949999]
    }
}
