class Solution{
	public int strStr(String source, String target){
		if(source == null || target == null){
			return -1;
		}
		// from the start loop to the end, and the length would be 
		for(int i = 0; i < source.length() - target.length() + 1; i++){
			//j is used for check whether the letter is same from the start of the locate position
			int j = 0;
			for(int j = 0; j < target.length(); j++){
				if(source.charAt(i + j) != target.charAt(j)){
					break;
				}
			}
			//finish this loop and find the target
			if(j == target.length()){
				return i;
			}
		}

		return -1;
	}	
}