
import Listas.ListaDoble;

public class App {
    public static void main(String[] args) throws Exception {

        //PRUEBA DE LISTA DOBLEMENTE ENLAZADA
        ListaDoble myList= new ListaDoble();

        myList.insertarAlFinal(1);
        myList.insertarAlFinal(2);
        myList.insertarAlFinal(3);
        myList.insertarAlFinal(4);
        myList.insertarAlFinal(5);
        myList.insertarAlFinal(6);
        myList.visualizar();
    }
}
