package algortihms.searching;

public class Searching {

    /*
     * Linear search algorithm
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param list: list of integers
     * @param number: number to search
     * @return index of the number in the list
     */
    public int linear(int[] list, int number) {
        for(int i = 0; i < list.length; i++) {
            if (list[i] == number) {
                return i;
            }
        }
        return -1;
    }

    /*
     * Binary search algorithm
     * Time complexity: O(log n)
     * Space complexity: O(1)
     * @param list: list of integers
     * @param number: number to search
     * @return index of the number in the list
     */
    public int binaryIterative(int[] list, int number) {
        int low = 0;
        int high = list.length - 1;
        
        while(low <= high) {
            int middle = (low + high) / 2;
            if(number == list[middle]) {
                return middle;
            } else if(number < list[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /*
     * Binary search algorithm using recursion
     * Time complexity: O(log n)
     * Space complexity: O(log n)
     * @param list: list of integers
     * @param low: low index of the list
     * @param high: high index of the list
     * @param number: number to search
     * @return index of the number in the list
     */
    public int binaryRecursive(int[] list, int low, int high, int number) {
        if(low > high) {
            return -1;
        }

        int middle = (low + high) / 2;

        if(number == list[middle]) {
            return middle;
        } else if(number < list[middle]) {
            return binaryRecursive(list, low, middle - 1, number);
        } else {
            return binaryRecursive(list, middle + 1, high, number);
        }
    }
}
