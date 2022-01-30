package Listas;

public class ListaDoble {
    Nodo primero;
    Nodo ultimo;
    
    public ListaDoble(){
        this.primero=null;
    }

    public boolean estaVacia(){
        return primero==null;
    }

    public void insertarAlFinal(int info){
        Nodo nuevo=new Nodo(info);
        if (this.estaVacia()){
            this.primero=nuevo;
        }
        else{
            Nodo actual=this.primero;
            while (actual.siguiente!=null) actual=actual.siguiente;

            actual.siguiente=nuevo;
            nuevo.anterior=actual;
        }
    }

    public void visualizar(){
        Nodo actual= this.primero;

        while( actual!= null){
            if (actual.siguiente!=null) System.out.print(actual.info + ",");
            else System.out.println(actual.info);
            actual=actual.siguiente;
        }
            
    }
}

class Nodo{
    int info;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(int info){
        this.info=info;
        anterior=siguiente=null;
    }
}
