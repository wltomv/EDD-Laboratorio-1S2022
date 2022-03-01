package EDD.Listas;

public class NodoS {
    Object info;
    NodoS siguiente;

    public NodoS(Object info){
        this.info=info;
        this.siguiente=null;
    }

    public void setSiguiente(NodoS siguiente){
        this.siguiente=siguiente;
    }
    
    public String toString(){
        return "Informacion: "+ this.info;
    }

}
