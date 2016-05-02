public class Qsort{
    public static void main(String[] args) {
        int[] data = new int[]{5,6,7,7,8,34,5234,};
        quickSort(data, 0, data.length - 1);
    }

    public static void quicksort(int[] arr, int left, int right){
        int i = left;
        int j = right;
        int temp;
        int pivot = arr[(left + right)/2];
        while(i < j){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i <= j){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j--;
            }
        }
        if(left < j){
            quicksort(arr[], left, j);
        }
        if(i < right){
            quicksort(arr[], i, right);
        }

    }
}


public class HashMap {

    public int hash(String key)

    public void put(String key, Object value);
    Entry newvalue = new Entry(key, value);
    newvalue = table(bucket);
    table(bucket)=newvalue;
    hashval = hash(key);
    bukVal = hashval/bucketNum;
    HashMap.insert(bukVal,value);


    HashMap<>
    public Object get(String key);


    public void remove(String key);
}