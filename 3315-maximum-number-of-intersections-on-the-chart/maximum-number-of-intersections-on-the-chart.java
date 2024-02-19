class Solution {
    public int maxIntersectionCount(int[] y) {
        int n = y.length;
        Map<Integer, Integer> map = new TreeMap();
        
        for (int i = 1; i < n; ++i) {
            int s = 2 * y[i - 1];
            int e = 2 * y[i] + (i == n - 1 ? 0 : y[i] > y[i-1] ? -1 : 1);
            map.put(Math.min(s, e), map.getOrDefault(Math.min(s, e), 0) + 1);
            map.put(Math.max(s, e) + 1, map.getOrDefault(Math.max(s, e) + 1, 0) - 1);
        }
        
        int count = 0, res = 0;
        
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int c = m.getValue();
            res = Math.max(res, count += c);
        }
        
        return res;
    }
}