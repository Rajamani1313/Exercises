package Array;

public class StorageOptimization {
    public static void main(String[] args){
        System.out.println(storage(3,2,new int[]{2},new int[]{2}));
    }

    private static int storage(int row, int col, int[] h, int[] v) {
        boolean[] hzntl = new boolean[row];
        boolean[] vrtcl = new boolean[col];
        for(int n: h){
            hzntl[n-1] = true;
        }
        for(int n: v){
            vrtcl[n-1] = true;
        }
        int hval = 1, val = 1,vval=1;
        for(int i=0;i<row;i++){
            if(hzntl[i]){
                val++;
                hval = Math.max(hval,val);
            }else
                val = 1;
        }
        val = 1;

        for(int i=0;i<col;i++){
            if(vrtcl[i]){
                val++;
                vval = Math.max(vval,val);
            }else
                val = 1;
        }
        return hval*vval;
    }
}
