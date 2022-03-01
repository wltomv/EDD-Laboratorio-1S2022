package EDD.Arboles;


public class ArbolBB<E extends Comparable<E>>{
    NodoB<E> raiz;

    public ArbolBB(){
        this.raiz=null;
    }

    public void insertar(E dato){
        raiz=insertarNodo(raiz,dato);
    }

    private NodoB<E> insertarNodo(NodoB<E> raiz, E dato){

        if (raiz==null)
            raiz=new NodoB<E>(dato);
        else if (dato.compareTo(raiz.dato)< 0)
            raiz.izquierdo=insertarNodo(raiz.izquierdo,dato);
        else if(dato.compareTo(raiz.dato)> 0)
            raiz.derecho=insertarNodo(raiz.derecho, dato);
        //TODO: Validar la insercion de claves repetidas.
        return raiz;
    }

    public void preOrden(){
        preOrden(this.raiz);
    }

    private void preOrden(NodoB<E> raiz){
        if(raiz != null){
            System.out.print(raiz.dato.toString());
            preOrden(raiz.izquierdo);
            preOrden(raiz.derecho);
        }
    }

}



class NodoB<E>{
    E dato;
    NodoB<E> izquierdo, derecho;

    public NodoB(E dato ){
        this.dato=dato;
        this.izquierdo=this.derecho=null;
    }

}