public void mergeSort (int[] list, int lowIndex, int highIndex) {
    //base case of divide  every recursive function need one
    if (lowIndex == highIndex)
            return;
    else {
            int midIndex = (lowIndex + highIndex) / 2;
            mergeSort(list, lowIndex, midIndex);
            mergeSort(list, midIndex + 1, highIndex);
            merge(list, lowIndex, midIndex, highIndex);
            printIt(list, 0, list.length-1);
    }
}
//this is the merge step which will merge two list into one
//mid index has divide this list into two sorted list
public void merge(int[] list, int lowIndex, int midIndex, int highIndex) {
    //split into two separate list
    int[] L = new int[midIndex - lowIndex + 2];
        for (int i = lowIndex; i <= midIndex; i++) {
            L[i - lowIndex] = list[i];
        }
    L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;

    int[] R = new int[highIndex - midIndex + 1];
        for (int i = midIndex + 1; i <= highIndex; i++) {
            R[i - midIndex - 1] = list[i];
        }
    R[highIndex - midIndex] = Integer.MAX_VALUE;

    int i = 0, j = 0;
    for (int k = lowIndex; k <= highIndex; k++) {
        if (L[i] <= R[j]) {
                list[k] = L[i];
                i++;
        }
        else {
                list[k] = R[j];
                j++;
        }
    }