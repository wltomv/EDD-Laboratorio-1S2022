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

    public void inOrden(){
        inOrden(this.raiz);
    }

    public void postOrden(){
        postOrden(this.raiz);
    }

    private void preOrden(NodoB<E> raiz){
        if(raiz != null){
            System.out.print(raiz.dato.toString());
            preOrden(raiz.izquierdo);
            preOrden(raiz.derecho);
        }
    }
    
    private void inOrden(NodoB<E> raiz){
        if(raiz != null){
            preOrden(raiz.izquierdo);
            System.out.print(raiz.dato.toString());
            preOrden(raiz.derecho);
        }
    }

    private void postOrden(NodoB<E> raiz){
        if(raiz != null){
            preOrden(raiz.izquierdo);
            preOrden(raiz.derecho);
            System.out.print(raiz.dato.toString());
        }
    }

    //  7
    // /  \
    //2    9


    public E buscar(E dato){
        return buscar(this.raiz,dato);
    }

    private E buscar(NodoB<E> raiz, E dato){
        if (raiz ==  null) return null;
        else if (dato.compareTo(raiz.dato) == 0) return raiz.dato;
        //si el resultado del metodo comparteTo es negativo significa que la raiz es mayor
        else if(dato.compareTo(raiz.dato) < 0) return buscar(raiz.izquierdo, dato);
        //si el resultado del metodo comparteTo es  positivo significa que la raiz es menor
        else return buscar(raiz.derecho, dato);

    }

    public void eliminar(E dato){
        this.raiz=eliminar(this.raiz, dato);
    }

    private NodoB<E> eliminar(NodoB<E> raiz, E dato){
        // si el nodo raíz es nulo, entonces no hay nada que eliminar o no es necesario más travesía
        if (raiz==null) return null;
        else if(dato.compareTo(raiz.dato)< 0){
            raiz.izquierdo=eliminar(raiz.izquierdo, dato);
        }
        else if(dato.compareTo(raiz.dato)> 0){
            raiz.derecho=eliminar(raiz.derecho, dato);
        }
        else{  
            //si es un nodo hoja (no tiene hijos)
            if (raiz.izquierdo==null && raiz.dato==null){
                return null;
            }
            // si el noto tiene solamente hijo izquierdo
            else if(raiz.derecho==null){
                return raiz.izquierdo;
            }
            // si el nodo tiene solamente hijo derecho
            else if(raiz.izquierdo==null){
                return raiz.derecho;
            }
            else{
                raiz.dato=encontrarSucesor(raiz.derecho);
                raiz.derecho=eliminar(raiz.derecho, raiz.dato);
                
            }
        }
        return raiz;

    }

    public E encontrarSucesor(NodoB<E> raiz){
        while (raiz.izquierdo!=null){
            raiz=raiz.izquierdo;
        }
        return raiz.dato;
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