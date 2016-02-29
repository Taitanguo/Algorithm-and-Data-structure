public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>  map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i + 1;
            }
            else map.put(target - nums[i], i + 1);//store the difference
        }
        return result;
        
    }