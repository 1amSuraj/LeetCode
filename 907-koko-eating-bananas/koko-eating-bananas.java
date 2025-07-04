class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    static boolean canEatAll(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (int)Math.ceil(pile/(double)speed); // calculate the time required to eat this pile
            if (time > h) {
                return false; // if the total time is greater than h, return false
            }
        }
        return true; // if all piles can be eaten within h hours, return true
    }
}