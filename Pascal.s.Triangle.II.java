public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for(int i = 0; i < rowIndex; i++){
            for(int j = result.size() - 2; j >= 0; j--){
                result.set(j + 1, result.get(j + 1) + result.get(j));
            }
            result.add(1);
        }
        return result;
    }
}