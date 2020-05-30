package Maths;

public class MaximalSquare {
    public static void  main(String[] args){
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        int maxSquare = 0;
        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1')
                    maxSquare = Math.max(maxSquare,square(i,j,matrix));
            }
        }
        return maxSquare;
    }
    static int square(int rpos,int cpos,char[][] matrix){
        int cnt = 1;
//        System.out.println("rpos"+rpos+"cpos"+cpos);
        boolean flag = true;
        while((cpos+cnt) < matrix[0].length && (rpos+cnt) < matrix.length && flag){
            for (int i=rpos;i<=cnt+rpos;i++) {
                if (matrix[i][cpos + cnt] == '0') {
                    flag = false;
                    break;
                }
            }
            for(int j=cpos;j<=cnt+cpos;j++) {
                if (matrix[rpos + cnt][j] == '0') {
                    flag = false;
                    break;
                }
            }
            if(flag)
                cnt++;
        }
        return cnt*cnt;
    }
}