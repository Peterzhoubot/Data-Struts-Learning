package uf;
/**
 * @author suyu
 * @version 1.0.0
 * @ClassName UnionFindFour
 * @Description 并查集第四版,基于rank的优化
 *              rank 代表树的深度
 * @Date 2018年07月21日12:55:17
 */
public class UnionFindFour implements UF{

    private int[] parent;

    /**
     * rank[i]表示以i为根的集合所表示树的层数
     */
    private int[] rank;

    public UnionFindFour(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }


    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程,查找元素p对应的集合编号
     * O(h)复杂度,h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 查看p和q是否属于同一集合
     * O(h)复杂度,h为树的高度
     *
     * @param p 参数1
     * @param q 参数2
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p,q 所属的集合
     * O(h)复杂度,h为树的高度
     *
     * @param p 参数1
     * @param q 参数2
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        //根据两个元素所在树的rank不同判断合并方向
        //将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        }else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        } else { //sz[qRoot] == sz[pRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
