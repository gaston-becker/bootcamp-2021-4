package junit.gastonb;

import java.util.HashMap;
import java.util.Map;

public class KataUno {
    public static String reverseWords(String s) { //cambie apple por s
        String[] palabrasSeparadas = s.split(" ");
        String res = "";
        for (String palabra: palabrasSeparadas){
            StringBuilder aux = new StringBuilder(palabra);
            res = res + String.valueOf(aux.reverse()) + " ";
        }
        System.out.println(res);
        return res;
    }
}
