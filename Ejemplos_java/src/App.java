
import Listas.ListaCircularSimple;
import Listas.ListaDoble;
import Arreglos.Ordenamientos;

public class App {
    public static void main(String[] args) throws Exception {       
        //PRUEBA DE LISTA DOBLEMENTE ENLAZADA
        ListaDoble myList= new ListaDoble();

        int[] arreglo={4,7,42,1,12};
        myList.insertarAlFinal(1);
        myList.insertarAlFinal(2);
        myList.insertarAlFinal(3);
        myList.insertarAlFinal(4);
        myList.insertarAlFinal(5);
        myList.insertarAlFinal(6);
        myList.visualizar();

        // //PRUEBA DE LISTA CIRCULAR
        ListaCircularSimple circular= new ListaCircularSimple();
        circular.insertar(1);
        circular.insertar(2);
        circular.insertar(3);
        circular.insertar(4);
        circular.imprimir();

        Ordenamientos.quicksort(arreglo);
        // Ordenamientos.insercion(arreglo);
        // Ordenamientos.seleccion(arreglo);
        // Ordenamientos.burbuja(arreglo);
        Ordenamientos.imprimir(arreglo);
        
    }
}
