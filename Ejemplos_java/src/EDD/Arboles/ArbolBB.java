package EDD.Arboles;


public class ArbolBB<E extends Comparable<E>>{
    NodoBB<E> raiz;

    public ArbolBB(){
        this.raiz=null;
    }

    public void insertar(E dato){
        raiz=insertarNodo(raiz,dato);
    }

    private NodoBB<E> insertarNodo(NodoBB<E> raiz, E dato){

        if (raiz==null)
            raiz=new NodoBB<E>(dato);
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

    private void preOrden(NodoBB<E> raiz){
        if(raiz != null){
            System.out.print(raiz.dato.toString());
            preOrden(raiz.izquierdo);
            preOrden(raiz.derecho);
        }
    }
    
    private void inOrden(NodoBB<E> raiz){
        if(raiz != null){
            preOrden(raiz.izquierdo);
            System.out.print(raiz.dato.toString());
            preOrden(raiz.derecho);
        }
    }

    private void postOrden(NodoBB<E> raiz){
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

    private E buscar(NodoBB<E> raiz, E dato){
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

    private NodoBB<E> eliminar(NodoBB<E> raiz, E dato){
        // si el nodo ra??z es nulo, entonces no hay nada que eliminar o no es necesario m??s traves??a
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

    public E encontrarSucesor(NodoBB<E> raiz){
        while (raiz.izquierdo!=null){
            raiz=raiz.izquierdo;
        }
        return raiz.dato;
    }


}



class NodoBB<E>{
    E dato;
    NodoBB<E> izquierdo, derecho;

    public NodoBB(E dato ){
        this.dato=dato;
        this.izquierdo=this.derecho=null;
    }

}