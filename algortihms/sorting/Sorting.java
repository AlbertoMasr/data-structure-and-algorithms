package algortihms.sorting;

public class Sorting {

    /*
     * Selection sort algorithm
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * @param list List to sort
     * @return void
     */
    public void selection(int[] list) {
        for(int i = 0; i < list.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < list.length; j++) {
                if(list[j] < list[min]) {
                    min = j;
                }
            }
            int temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
    }

    /*
     * Bubble sort algorithm
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * @param list List to sort
     * @return void
     */
    public void bubble(int[] list) {
        for(int i = 0; i < list.length - 1; i++) {
            boolean swapped = false;
            for(int j = 0; j < list.length - i - 1; j++) {
                if(list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }

    /*
     * Insertion sort algorithm
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * @param list List to sort
     * @return void
     */
    public void insertion(int[] list) {
        for(int i = 1; i < list.length; i++) {
            int value = list[i];
            int hole = i;
            while(hole > 0 && list[hole - 1] > value) {
                list[hole] = list[hole - 1];
                hole = hole - 1;
            }
            list[hole] = value;
        }
    }

    /*
     * Auxiliary method to partition the list in merge sort algorithm
     * @param list List to sort
     * @param low Lower index
     * @param high Higher index
     * @return void
     */
    private void mergeList(int[] leftList, int[] rightList, int[] list) {
        int lengthLeftList = leftList.length;
        int lengthRightList = rightList.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < lengthLeftList && j < lengthRightList) {
            if(leftList[i] < rightList[j]) {
                list[k] = leftList[i];
                i++;
            } else {
                list[k] = rightList[j];
                j++;
            }
            k++;
        }
        while(i < lengthLeftList) {
            list[k] = leftList[i];
            i++;
            k++;
        }

        while(j < lengthRightList) {
            list[k] = rightList[j];
            j++;
            k++;
        }
    }

    /*
     * Merge sort algorithm
     * Time complexity: O(n log n)
     * Space complexity: O(n)
     * @param list List to sort
     * @return void
     */
    public void merge(int[] list) {
        int length = list.length;
        if(length < 2) {
            return;
        }
        int middle = length / 2;
        int[] leftList = new int[middle];
        int[] rightList = new int[length - middle];
        for(int i = 0; i < middle; i++) {
            leftList[i] = list[i];
        }
        for(int i = middle; i < length; i++) {
            rightList[i - middle] = list[i];
        }
        merge(rightList);
        merge(leftList);
        mergeList(leftList, rightList, list);
    }

    /*
     * Auxiliary method to swap elements in quick sort algorithm
     * @param list List to sort
     * @param i Index i
     * @param j Index j
     * @return void
     */
    private void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    /*
     * Auxiliary method to partition the list in quick sort algorithm
     * @param list List to sort
     * @param startIndex Start index
     * @param endIndex End index
     * @return int
     */
    private int partition(int[] list, int startIndex, int endIndex) {   
        int pivot = list[endIndex];
        int partitionIndex = startIndex;
        for(int i = startIndex; i < endIndex; i++) {
            if(list[i] <= pivot) {
                swap(list, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(list, partitionIndex, endIndex);
        return partitionIndex;
    }

    /*
     * Quick sort algorithm
     * Time complexity: O(n log n)
     * Space complexity: O(log n)
     * @param list List to sort
     * @return void
     */
    public void quick(int[] list, int startIndex, int endIndex) {
        if(startIndex >= endIndex) {
            return;
        }

        int partitionIndex = partition(list, startIndex, endIndex);
        quick(list, startIndex, partitionIndex - 1);
        quick(list, partitionIndex + 1, endIndex);
    }
}
