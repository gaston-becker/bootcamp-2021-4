package junit.gastonb;

public class Ordenar {

    /**
     * Code Kata: junit.gbecker.Ordenar Cadena.
     * Cada palabra de la cadena contendrá un solo número.
     * Este número es la posición que debería tener la palabra en el resultado.
     *
     * Nota: Los números pueden ser del 1 al 9.
     * Por lo tanto, 1 será la primera palabra (no 0).
     *
     * Si la cadena de entrada está vacía,
     * devuelve una cadena vacía.
     * Las palabras en la cadena de entrada solo contendrán números consecutivos válidos.
     *
     * Ejemplos:
     *    "oraci4on un3a e2s Es1ta" -> "Es1ta e2s un3a oraci4on"
     *
     */
   /* public static void main(String[] args) {
        String cadena = "3la es2 ora4cion est1a ";

        char [] vecChar = cadena.toCharArray();//convertimos a un vector
        char [][] mat = new char[10][9];//10 numero al azar, y 9 cantidad maxima de palabras
        char aux;
        int u=0;
        /*if(cadena.isEmpty())
        {

        }//
        for (int i=0; i<vecChar.length ; i++)
        {
            char [] palabra = new char[vecChar.length];
            aux = vecChar[i];
            if (aux != ' ' ){ //&& aux != '\n'
                palabra[u] = aux;
                u++;
            }else{
                mat = meterEnMatriz(palabra, buscarPosicion(palabra), mat);
                u = 0;
                for (int m=0; m < palabra.length; m++){
                    palabra[m]=' ';
                }
            }
        } //muestro la matriz
        for (int x=0; x < 9; x++) {
            for (int y=0; y < mat[x].length; y++) {
                System.out.print(mat[y][x]);
            }System.out.println();
        }

    }
/*
    public static char[] ordenarPorNumero(char []cad){

        return cad;
    }//
    public static int buscarPosicion(char[] palabra){
        int pos = 0;
        for (int i=0; i<9; i++){
            if (palabra[i]>'0' && palabra[i]<='9')
                pos = Character.getNumericValue(palabra[i]);
            //pos = palabra[i]-'0';
        }
        return pos;
    }

    public static char[][] meterEnMatriz(char[] palabra, int pos, char[][] mat ){
        for (int i=0; i<= 9;i++){
            mat[i][pos] = palabra[i];
        }
        return mat;
    }
*/
}