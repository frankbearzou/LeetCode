/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n, mid = 0, result = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            result = guess(mid);
            if (result == -1)
                right = mid - 1;
            else if (result == 1)
                left = mid + 1;
            else if (result == 0)
                return mid;
        }
        return mid;
    }
}
