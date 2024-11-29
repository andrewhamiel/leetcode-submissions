class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> groups = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if(groups.containsKey(email)) uf.union(groups.get(email), i);
                else groups.put(email, i);
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();
        for(String email : groups.keySet()) {
            int rankedGroup = uf.find(groups.get(email));
            components.computeIfAbsent(rankedGroup, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for(int group : components.keySet()) {
            List<String> emails = components.get(group);
            String accountName = accounts.get(group).get(0);
            List<String> list = new ArrayList<>();
            Collections.sort(emails);
            list.add(accountName);
            list.addAll(emails);
            result.add(list);
        }
        return result;
    }

    class UnionFind {
        int[] group;
        int[] rank;

        public UnionFind(int n) {
            group = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                group[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if(group[x] != x) group[x] = find(group[x]);
            return group[x];
        }

        private void union(int a, int b) {
            int groupA = find(a), groupB = find(b);
            if(groupA == groupB) return;

            if(rank[groupA] < rank[groupB]) {
                rank[groupB]+= rank[groupA];
                group[groupA] = group[groupB];
            }else {
                rank[groupA]+= rank[groupB];
                group[groupB]= group[groupA];
            }
        }
    }
}