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

        //2. rank components
        Map<Integer, List<String>> components = new HashMap<>(); 
        for(String email : groups.keySet()){
            int unranked = groups.get(email);
            int rankedGroup = uf.find(unranked);
            components.putIfAbsent(rankedGroup, new ArrayList<>());
            components.get(rankedGroup).add(email);
        }

        //3. Build result
        List<List<String>> result = new ArrayList<>();
        for(Integer group : components.keySet()){
            List<String> emails = components.get(group);
            Collections.sort(emails);
            String accountName = accounts.get(group).get(0);
            List<String> toAdd = new ArrayList<>();
            toAdd.add(accountName);
            toAdd.addAll(emails);
            result.add(toAdd);
        }
        return result;
    }

    class UnionFind {
        int[] group;
        int[] rank;

        public UnionFind(int size){
            group = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++){
                group[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(group[x] != x) group[x] = find(group[x]);
            return group[x];
        }

        public void union(int a, int b){
            int groupA = find(a), groupB = find(b);
            if(groupA == groupB) return;

            if(rank[groupA] >= rank[groupB]){
                rank[groupA]+= rank[groupB];
                group[groupB] = group[groupA];
            }else{
                rank[groupB]+= rank[groupA];
                group[groupA] = group[groupB];
            }
        }
    }
}