class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> emailGroups = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if(!emailGroups.containsKey(email)) emailGroups.put(email, i);
                else uf.union(emailGroups.get(email), i);
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();
        for(String email : emailGroups.keySet()) {
            int unrankedGroup = emailGroups.get(email);
            int rankedGroup = uf.find(unrankedGroup);
            components.computeIfAbsent(rankedGroup, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for(Integer rankedGroup : components.keySet()) {
            List<String> emails = components.get(rankedGroup);
            Collections.sort(emails);
            List<String> list = new ArrayList<>();
            list.add(accounts.get(rankedGroup).get(0));
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