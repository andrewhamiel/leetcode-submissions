class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //1. Find groups
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
        //2. Connect components by group
        Map<Integer, List<String>> components = new HashMap<>();
        for(String email : groups.keySet()) {
            int group = groups.get(email);
            int rankedGroup = uf.find(group);
            components.computeIfAbsent(rankedGroup, k -> new ArrayList<>()).add(email);
        }
        //3. Build result
        List<List<String>> result = new ArrayList<>();
        for(int rankedGroup : components.keySet()) {
            List<String> emails = components.get(rankedGroup);
            String accountName = accounts.get(rankedGroup).get(0);
            Collections.sort(emails);
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

            if(rank[groupA] >= rank[groupB]) {
                rank[groupA]+= rank[groupB];
                group[groupB] = group[groupA];
            }else {
                rank[groupB]+= rank[groupA];
                group[groupA] = group[groupB];
            }
        }
    }
}