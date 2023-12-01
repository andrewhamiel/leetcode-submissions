class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> groups = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if(!groups.containsKey(email)) groups.put(email, i);
                else uf.union(i, groups.get(email));
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();
        for(String email : groups.keySet()){
            int oldGroup = groups.get(email);
            int rankedGroup = uf.find(oldGroup);
            components.putIfAbsent(rankedGroup, new ArrayList<>());
            components.get(rankedGroup).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for(int group : components.keySet()){
            List<String> emails = components.get(group);
            Collections.sort(emails);
            String account = accounts.get(group).get(0);
            List<String> toAdd = new ArrayList<>();
            toAdd.add(account);
            toAdd.addAll(emails);
            result.add(toAdd);
        }
        return result;
    }

    class UnionFind {
        int[] rank;
        int[] group;

        public UnionFind(int n){
            rank = new int[n];
            group = new int[n];
            
            for(int i = 0; i < rank.length; i++){
                group[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(group[x] != x) group[x] = find(group[x]);
            return group[x];
        }

        public void union(int a, int b){
            int group1 = find(a), group2 = find(b);
            if(group1 == group2) return;

            if(rank[group1] >= rank[group2]){
                rank[group1]+= rank[group2];
                group[group2] = group[group1];
            }else {
                rank[group2]+= rank[group1];
                group[group1] = group[group2];
            }
        }
    }
}