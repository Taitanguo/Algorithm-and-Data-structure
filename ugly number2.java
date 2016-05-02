class Solution{
    public int nthUglyNumber(int n){
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);
        int cur = 2;
        int p1 = 0, p2 = 0, p3 = 0;
        int min1, min2, min3;
        while(uglys.size() < n){
            while(uglys.get(p1) * 2 < cur)
                p1++;
            min1 = uglys.get(p1) * 2;

            while(uglys.get(p1) * 3 < cur)
                p1++;
            min1 = uglys.get(p1) * 3;

            while(uglys.get(p1) * 5 < cur)
                p1++;
            min1 = uglys.get(p1) * 5;

            int next = min1 < min2 ? min1 : min2;
            next = next < min3 ? next : min3;

            cur = next + 1;
            uglys.add(next);
        }

        return uglys.get(n - 1);
    }
}