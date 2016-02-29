public void select(int stream[], int n, int k){
    int i;
    int[] reservoir = new int[k];
    for(i = 0; i < k; i++){
        reservoir[i] = stream[i];
    }
    for(; i < n; i++){
        int j = Math.random() * (i + 1);
        if(j < k) reservoir[j] = stream[i];
    }
}