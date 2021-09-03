package junit.gastonb;


import java.util.LinkedList;

public class KataSeis {
    /*
 lista de animales:
        antílope come hierba
        pez grande come pez pequeño
        bicho come hojas
        oso come peces grandes
        oso come bicho
        oso come pollo
        oso come vaca
        oso come hojas
        el oso come ovejas
        pollo come bicho
        vaca come hierba
        zorro come pollo
        zorro come ovejas
        jirafa come hojas
        león come antílope
        león come vaca
        panda come hojas
        oveja come hierba
        -------------------------------------------------- --------------------------------------------------
        INPUT
        Una cadena separada por comas que representa todas las cosas del zoológico.

        TAREA
        Averigüe quién come a quién hasta que no sea posible comer más.

        OUTPUT
        Una lista de cadenas donde:

        El primer elemento es la cadena inicial (igual que INPUT)
        El último elemento es una cadena separada por comas de cómo se ve el zoológico cuando toda la comida ha terminado.
        Todos los demás elementos (del segundo al último-1) son de la forma X come Y describe lo que sucedió
        Notas

        Los animales solo pueden comer cosas a su lado.
        Los animales siempre comen hacia la IZQUIERDA antes de comer hacia la DERECHA
        Siempre el animal "Mas a la Izquierda" es capaz de comer antes que los demás.

        Cualquier otra cosa que pueda encontrar en el zoológico (que no esté en la lista anterior) no come nada y no es comestible

        Ejemplo
        "zorro, insecto, pollo, hierba, oveja"

        Laboral

        1 zorro no puede comer insecto
        "zorro, insecto, pollo, hierba, oveja"
        2 bicho no puede comer nada
        "zorro, insecto, pollo, hierba, oveja"
        3 pollo come bicho
        "zorro, pollo, pasto, oveja"
        4 zorro come pollo
        "zorro, hierba, oveja"
        5 el zorro no puede comer hierba
        "zorro, hierba, oveja"
        6 la hierba no puede comer nada
        "zorro, hierba, oveja"
        7 ovejas comen hierba
        "zorro, oveja"
        8 zorro come ovejas
        "zorro"
        Producción

        ["zorro, insecto, pollo, pasto, oveja", "el pollo come insecto", "el zorro come pollo", "la oveja come pasto", "el zorro come oveja", "zorro"]

        FUNDAMENTOS
*/
    static LinkedList<String> pasos = new LinkedList<>();
    static LinkedList<String> animales = new LinkedList<>();//***//

        public static Object[] whoEatsWho(final String zoo) {
            String[] array = zoo.split(",");

            String aux = "";
            int indice = 0;//indice del animal estoy analizando dentro de la LinkList

            //llenamos las linked list:
            for (int i = 0; i <array.length; i++) {
                animales.add(array[i]);
            }
            //desarrollo:
            while (indice<animales.size()) {
                if (posibleComer(animales, indice)) {
                    if (comerIzq(animales, indice, pasos))
                        //comerIzq(animales, indice, pasos);
                        indice = 0;
                    if(comerDer(animales, indice, pasos))
                        indice = 0;
                }
                indice++;
            }
            //cargo la lista de "pasos" en el vector final
            String[] fin = new String[pasos.size()+2]; //Zoo orginal + Lo maximo de pasos q pueda->todo se comen al menos 1
            fin[0] = zoo;//siempre empieza con el zoo orginal
            int i = 1;
            while (!pasos.isEmpty()){
                fin[i] = pasos.getFirst();
                pasos.removeFirst();
                i++;
            }
            //cargo el ultimo elemento, con los animales q quedaron del zoo
            while (!animales.isEmpty() && animales.size()>1) {
                aux += animales.getFirst() + ",";
                animales.removeFirst();
            }
            aux += animales.getFirst();
            fin[i] = aux;
            return fin;
        }
    //----------------------------------------------------------------------------------------------------------------------
        public static boolean posibleComer(LinkedList<String> listaE, int ind){ //ok
            /*if(comerIzq(listaE, ind, null)==null && comerDer(listaE, ind, null)==null){*/ //no me conviene de estar foma xq va a hacer todas la reiteracion de si pude comer, solo para devoler un treu/false
            if ((ind!=0 && cadenaAlimenticia(listaE.get(ind), listaE.get(ind-1))) || (ind<listaE.size()-1 && cadenaAlimenticia(listaE.get(ind), listaE.get(ind+1)))) {
                return true;
            }
            return false;
        }

        public static boolean comerIzq(LinkedList<String> animales, int ind, LinkedList<String> pasos){//
            boolean flag = false;
            if (ind!=0 && cadenaAlimenticia(animales.get(ind), animales.get(ind-1))){//preguntamos si es el primer elemento, sino no tiene nada a su izquierda
                pasos.add(animales.get(ind) + " eats " + animales.get(ind-1));
                animales.remove(ind-1);
                comerIzq(animales, 0, pasos);
                return true;
            }
            return flag;
        }

        public static boolean comerDer(LinkedList<String> animales, int ind, LinkedList<String> pasos){//   ->
            if (ind<(animales.size()-1) && cadenaAlimenticia(animales.get(ind), animales.get(ind+1))){////preguntamos si es el ultimo elemento de la lista, sino no tiene nada a su derecha
                pasos.add(animales.get(ind) + " eats " + animales.get(ind+1));
                animales.remove(ind+1);
                comerDer(animales, ind, pasos);
                return true;
            }
            return false;
        }

        public static boolean cadenaAlimenticia(String come, String comido){
            boolean flag = false;
            switch (come){
                case "antelope":
                    if (comido.equals("grass"))
                        flag = true;
                    break;
                case "big-fish":
                    if (comido.equals("little-fish"))
                        flag = true;
                    break;
                case "bug":
                    if (comido.equals("leaves"))
                        flag = true;
                    break;
                case "bear":
                    if (comido.equals("big-fish") || comido.equals("bug") || comido.equals("chicken") || comido.equals("cow") || comido.equals("leaves") || comido.equals("sheep"))
                        flag = true;
                    break;
                case "chicken":
                    if (comido.equals("bug"))
                        flag = true;
                    break;
                case "cow":
                    if (comido.equals("grass"))
                        flag = true;
                    break;
                case "fox":
                    if (comido.equals("chicken") || comido.equals("sheep"))
                        flag = true;
                    break;
                case "giraffe":
                    if (comido.equals("leaves"))
                        flag = true;
                    break;
                case "lion":
                    if (comido.equals("antelope") || comido.equals("cow"))
                        flag = true;
                    break;
                case "panda":
                    if (comido.equals("leaves"))
                        flag = true;
                    break;
                case "sheep":
                    if (comido.equals("grass"))
                        flag = true;
                    break;
             }
            return flag;
        }

  }

