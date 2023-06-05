type UnionFind struct {
    group []int
    rank []int
    count int
}

func NewUnionFind(n int) *UnionFind{
    uf := new(UnionFind)
    uf.group = make([]int, n)
    uf.rank = make([]int, n)
    for i := 0; i < n; i++ {
        uf.group[i] = i
    }
    uf.count = n
    return uf
}

func (uf *UnionFind) find(node int) int {
    if uf.group[node] != node {
        uf.group[node] = uf.find(uf.group[node])
    }
    return uf.group[node]
}

func (uf *UnionFind) union(node1, node2 int) bool {
    group1 := uf.find(node1)
    group2 := uf.find(node2)
    if group1 == group2 {
        return false
    }

    if uf.rank[group1] > uf.rank[group2] {
        uf.group[group2] = uf.group[group1]
    }else if uf.rank[group2] > uf.rank[group1] {
        uf.group[group1] = uf.group[group2]
    }else{
        uf.group[group2] = uf.group[group1]
        uf.count--
    }
    return true
}

func (uf *UnionFind) getCount() int {
    return uf.count
}

func findCircleNum(isConnected [][]int) int {
    uf := NewUnionFind(len(isConnected))
    for i := 0; i < len(isConnected); i++ {
        for j := 0; j < len(isConnected[0]); j++ {
            if isConnected[i][j] == 1 {
                uf.union(i, j)
            }
        }
    }
    return uf.getCount()
}