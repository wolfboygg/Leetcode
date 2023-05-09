package mostglod;

public class MostGold {

    public int mostGold(int totalPeople, int totalGoldNum, int[] peoples, int[] golds) {
        if (totalPeople == 0 || totalGoldNum == 0) {
            return 0;
        }
        if (totalPeople < peoples[totalGoldNum - 1]) {
            return mostGold(totalPeople, totalGoldNum - 1, peoples, golds);
        }
        int totalGold = Math.max(mostGold(totalPeople, totalGoldNum - 1, peoples, golds),
                mostGold(totalPeople - peoples[totalGoldNum - 1], totalGoldNum - 1, peoples, golds) + golds[totalGoldNum - 1]);
        return totalGold;
    }

    public static int getBestGoldMining(int w,int n,int[] p,int[] g){
        if(w==0||n==0){
            return 0;
        }
        if (w<p[n-1]){
            return getBestGoldMining(w,n-1,p,g);
        }
        return Math.max(getBestGoldMining(w,n-1,p,g),
                getBestGoldMining(w-p[n-1],n-1,p,g)+g[n-1]);
    }


    public static void main(String[] args) {
        int[] g = {400, 500, 200, 300, 350};
        int[] p = {5, 5, 3, 4, 3};
        int n = 5; // 金矿的数量
        int w = 10; // 矿工的人数
        System.out.println(new MostGold().mostGold(w, n, p, g));
    }
}
