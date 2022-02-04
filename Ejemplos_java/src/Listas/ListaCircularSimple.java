package Listas;

public class ListaCircularSimple {
    NodoS lc;

    public ListaCircularSimple() {
        this.lc = null;
    }

    public void insertar(Object dato){
        NodoS nuevo= new NodoS(dato);
        nuevo.setSiguiente(nuevo);

        if (this.lc!=null){
            nuevo.siguiente=lc.siguiente;
            lc.siguiente=nuevo;
        }
        lc=nuevo;
    }

    public void imprimir(){
        //TODO: Validar lista vacia
        NodoS actual=this.lc.siguiente;
        do{
            System.out.println(actual.toString());
            actual=actual.siguiente;
        }while(actual!=this.lc.siguiente);
    }
}
