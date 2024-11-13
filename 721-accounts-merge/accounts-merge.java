class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> groups = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if(!groups.containsKey(email)) groups.put(email, i);
                else uf.union(groups.get(email), i);
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();
        for(String email : groups.keySet()) {
            int oldGroup = groups.get(email);
            int rankedGroup = uf.find(oldGroup);
            components.putIfAbsent(rankedGroup, new ArrayList<>());
            components.get(rankedGroup).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for(Integer group : components.keySet()) {
            List<String> emails = components.get(group);
            Collections.sort(emails);
            String accountName = accounts.get(group).get(0);
            List<String> list = new ArrayList<>();
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

        public void union(int a, int b) {
            int groupA = find(a), groupB = find(b);

            if(groupA == groupB) return;

            if(rank[groupA] <= rank[groupB]) {
                group[groupA] = group[groupB];
                rank[groupB]+= rank[groupA];
            }else {
                group[groupB] = group[groupA];
                rank[groupA]+= rank[groupB];
            }
        }
    }
}