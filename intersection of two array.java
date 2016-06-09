public class Solution{
    public int[] intersection(int[] nums1, int[] nums2){
        Array.sort(nums1);
        Array.sort(nums2);

        int i = 0;
        int j = 0;
        int[] temp = new int[nums1.length];
        int index = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums[i] == nums[j]){
                if(index == 0 || temp[index - 1] != nums1[i]){
                    temp[index++] = nums1[i];
                }
            }
            i++;
            j++;
        }else if(nums1[i] < nums[j]){
            i++;
        }else{
            j++;
        }

    }

    int[] result = new int[index];
    for(int k = 0; k < index; k++){
        result[k] = temp[k];
    }
    return result;
}

//using hashmap
public class Solution{
    public int[] intersection(int[] nums1, int[] nums2){
        if(nums1 == null || nums2 == null){
            return null;
        }

        Hashset<Integer> hash = new Hashset<>();
        for(int i = 0; i < nums1.length; i++){
            hash.add(nums1[i]);
        }

        HashSet<Integer> resultHash = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(hash.contains(nums2[i]) && !!resultHash.contains(nums2[i])){
                resulthash.add(nums2[i]);
            }
        }

        int size = resultHash.size();
        int[] result = new int[size];
        int index = 0;
        for(Integer num : resultHash){
            result[index++] = num;
        }
        return result;
    }
}