class Pair{
    String key;
    int value;

    Pair(String key, int value){
        this.key = key;
        this.value = value;
    }
}

public class SOlution{
    private Comparator<pair> pairComparator = new Comparator<Pair>(){
        public int compare(Pair left, Pair right){
            //if the frequnce has different then just sort with appearance time
            if(left.value != right.value){
                return left.value - right.value;
            }
            //Or just use alphebelt to sort
            return right.key.compareTo(left.key);
        }
    };

    public String[] topKFrequentWords(String[] words, int k){
        if(k == 0){
            return new string[0];
        }
        //put words into hashmap
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        for(String word : words){
            if(counter.containsKey(word)){
                counter.put(word, counter.get(word) + 1);
            } else{
                counter.put(word, 1);
            }
        }
        //use a priorityqueue to store the top k elements
        PriorityQueue<Pair> Q = new PriorityQueue<Pair>(K, pairComparator);
        for(String word : counter.KeySet()){
            Pair peak = Q.peak();
            Pair newPair = new Pair(word, counter.get(word));
            if(Q.size() < K){
                Q.add(newPair);
            }else if(pairComparator.compare(newPair, peak) > 0){
                Q.poll();
                Q.add(new Pair(word, counter.get(word)));
            }
        }

        //return result
        String[] result = new String[k];
        int index = 0;
        while(!Q.isEmpty()){
            result[index++] = Q.poll().key; //需要减一 因为最后一次没有数输入但是还是加了index＋＋
        }
        //reverse
        for(int i = 0; i < index/2; i++){
            String temp = result[i];
            result[i] = result[index - i - 1];
            result[index - i - 1] = temp;
        }

        return result;
    }
}