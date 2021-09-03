package junit.gastonb;

public class KataSiete {
    public static long digPow(int i, int i1) {
        int total = 0;
        int k;
        String numero = String.valueOf(i);
        char [] vecNum = numero.toCharArray();
        if(i>0 && i1>=0){
            for (int j = 0; j < vecNum.length; j++) {
                total += Math.pow(Character.getNumericValue(vecNum[j]), i1);
                i1++;
            }
            System.out.println(total);
            if ((total%i) == 0) {
                k = total/i;
                return k;
            }
        }
        return -1;//-1 si no existe un k
    }
}
