class DirectedGraphNode{
    int lable;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x){
        lable = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}

public class Solution{
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        //Build a hashmap for counting the appearance of node
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        //for loop all nodes that are not source node and store them in the hashmap
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(map.containsKey(neighbor)){
                    //nodes may have common neighbor
                    map.put(neighbor, map.get(neighbor) + 1);
                }else{
                    map.put(neighbor, 1);
                }
            }
        }
        //Build a queue to store all of the node without input(source node)
        //Then scan the whole file as a BFS
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for(DirectedGraphNode node : graph){
            if(!map.containsKey(node)){
                q.offer(node);
                result.add(node);
            }
        }
        //BFS
        while(!q.isEmpty()){
            DirectedGraphNode node = q.poll();
            for(DirectedGraphNode n : node.neighbors){
                map.put(n, map.get(n) - 1);
                //All common neighbor can be count as once in a toplogical sorting
                if(map.get(n) == 0){
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
}