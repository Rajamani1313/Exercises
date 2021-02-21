package Array;

public class FreshPromo {
    public static void main(String[] args){
        String promo[][] = new String[][]{{"apple","apple"},{"banana","anything","banana"}};
        String[] cart = new String[]{"apple","banana","apple","apple","orange","banana","orange","banana","orange"};
        System.out.println(promo(promo,cart));

    }

    private static int promo(String[][] promo, String[] cart) {
        int cartIndex = 0,promoGrpIndex = 0;
        while(cartIndex < cart.length && promoGrpIndex < promo.length){
            if(hasMatch(cart,cartIndex,promo[promoGrpIndex])){
                cartIndex += promo[promoGrpIndex].length;
                promoGrpIndex++;
            }else
                cartIndex++;
        }
        return promoGrpIndex == promo.length ? 1 : 0;
    }

    private static boolean hasMatch(String[] cart, int cartIndex, String[] promoGrp) {
        for(String promo: promoGrp) {
            if (promo.equals("anything") || promo.equals(cart[cartIndex]))
                cartIndex++;
            else
                return false;
        }
        return true;
    }
}
