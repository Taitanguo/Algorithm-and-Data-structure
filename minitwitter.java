// This system use pull model

public class MiniTwitter{
    class Node{
        public int order;
        public Tweet tweet;
        public Node(int o, Tweet t){
            this.order = o;
            this.tweet = t;
        }
    }
    class SortByOrder implements Comparator {
        public int compare(Object obj1,Object obj2){
            Node node1 = (Node) obj1;
            Node node2 = (Node) obj2;
            if(node1.order < node2.order){
                return 1;
            else
                return -1;
            }
        }
    }
    private Map<Integer, Map<Integer, Boolean>> friends;
//Store all users tweets in this Hash_Table
    private Map<Integer, List<Node>> users_tweets;
    private int order;
//which return list of last ten
    public List<Node> getLastTen(List<Node> tmp){
        int last = 10;
        if(tmp.size < 10){
            last = tmp.size();
        }
        return tmp.sublist(tmp.size() - last, tmp.size());
    }
//which return the list of first 10
    public List<Node> getFirstTen(List<NOde> tmp){
        int last = 10;
        if(tmp.size() < 10){
            last = tmp.size();
        }
        return tmp.sublist(0, last);
    }
    public MiniTwitter(){
        this.friends = new HashMap<Integer, Map<Integer, Boolean>>();
        this.users_tweets = new HahsMap<Integer, List<Node>>();
        this.order = 0;
    }

    public Tweet postTweet(int user_id, String tweet_text){
        Tweet tweet = Tweet.create(user_id, tweet_text);
        if(!users_tweets.containsKey(user_id))
            users_tweets.put(user_id, new ArrayList<Node>());
        order += 1;
        users_tweets.get(user_id).add(new Node(order, tweet));
        return tweet;
    }

    public List<Tweet> getnewsFeed(int user_id){
        List<Node> tmp = new ArrayList<Node>();
        //get last ten twitters of user_id itself
        if(users_tweets.containsKey(user_id))
            tmp.addAll(getlastTen(users_tweets.get(user_id)));
        // get the last tne twitter of all user_id's friends
        if(friends.containsKey(user_id)){
            for(Map.Entry<Integer, Boolean> entry : friends.get(user_id).entrySet()){
                int user = entry.getKey();
                if(users_tweets.containsKey(user))
                    tmp.addAll(getLastTen(users_tweets.get(user)));
            }
        }

        Collection.sort(tmp, new SortByOrder()); // decendance order
        List<Tweet> rt = new ArrayList<Tweet>();
        tmp = getFirstTen(tmp);
        for(Node node : tmp){
            rt.add(node.tweet);
        }
        return rt;
    }

        public List<Tweet> getTimeLine(int user_id){
            List<Node> tmp = new ArrayList<Node>();
            if(users_tweets.containsKey(user_id)){
                tmp.addAll(getLastTen(users_tweets.get(user_id)));

                Collection.sort(tmp, new SortByOrder());
                List<Tweet> rt = new ArrayList<Tweet>();
                tmp = getFirstTen(tmp);
                for(Node node : tmp)
                    rd.add(node.tweet);
                return rt;
            }
        }

        public void follow(int from_user_id, int to_user_id){
            if(!friends.containsKey(from_user_id))
                friends.put(from_user_id, new HashMap<Integer, Boolean>());

            friends.get(from_user_id).put(to_user_id, true);
        }

        public void unfollow(int from_user_id, int to_user_id){
            if(friends.containsKey(from_user_id)){
                friends.get(from_user_id).remove(to_user_id);
            }
        }
}