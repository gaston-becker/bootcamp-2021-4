package junit.gastonb;
import java.math.*;
public class BuyCar {

    public static int[] nbMonths(int i, int i1, int i2, double v) {//viejo-nuevo-4month-decrease
        final double porcentTwoM = 0.5;
        int month=0;
        double porcent = v;
        Double sobra = (double)i-i1;
        int ahorro = 0;
        int vec[] = new int[2];

        if (i<i1) {
            double precioActualViejo = i;
            double precioActualNuevo = i1;
            while(sobra<=0){
                month++;//pasó 1 mes
                if (month%2==0 ) {//le agregamos el 0.5 por los 2 meses
                    porcent += porcentTwoM;
                }
                precioActualViejo -= (precioActualViejo*porcent)/100;//acutalizamos el precio de los autos
                precioActualNuevo -= (precioActualNuevo*porcent)/100;
                ahorro += i2;
                sobra = ahorro+precioActualViejo-precioActualNuevo;
            }
        }
        vec[0] = month;
        vec[1] = (int)Math.round(sobra);
        return vec;
    }
}
