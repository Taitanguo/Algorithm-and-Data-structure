class Solution{
    public static Solution instance = null;
    public static getInstance(){
        if(instance == null){
            instance = new Solution();
        }
        return instance;
    }
}