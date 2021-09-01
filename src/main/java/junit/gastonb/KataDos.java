package junit.gastonb;

public class KataDos {

    public static String toAlternativeString(String s) {//cambie hello_world por s
        char[] vecC = s.toCharArray();
        char[] vecFin = new char[vecC.length];
        String fin = "";

        for (int i = 0; i < vecC.length; i++) {
            if (vecC[i]>='A' && vecC[i]<='Z'){
                vecFin[i] = Character.toLowerCase(vecC[i]);
            }else {
                if (vecC[i]>='a' && vecC[i]<='z')
                    vecFin[i] = Character.toUpperCase(vecC[i]);
                else
                    vecFin[i] = vecC[i];
            }
        fin = String.valueOf(vecFin);
        }
        return fin;
    }
}
