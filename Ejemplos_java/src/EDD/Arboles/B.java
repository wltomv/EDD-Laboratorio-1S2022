package EDD.Arboles;

/**
 *
 * @author Alex Rose
 */

/**
 * @version 1.2
 * Modificaciones Walter M.
 * Material de apoyo para los estudiantes de EDD 2022
 * Se modificó el código original únicamente con fines explicativos. 
 */

public class B {
    final int orden_arbol = 5;
    Pagina raiz;
    public B() {
        this.raiz = new Pagina();
    }
    public void insertar(int id) {
        NodoB nodo = new NodoB(id);
        NodoB obj = insertar_en_pagina(nodo, raiz);
        if (obj != null) {
            //si devuelve algo el metodo de insertar en rama quiere decir que creo una nueva rama, y se debe insertar en el arbol
            raiz = new Pagina();
            raiz.insertar(obj);
            raiz.hoja = false;
        }
    }

    private NodoB insertar_en_pagina(NodoB nodo, Pagina rama) {
        if (rama.hoja) {
            rama.insertar(nodo);
            return  (rama.contador == orden_arbol)? dividir(rama): null;
        } else {
            NodoB temp = rama.primero;
            do {
                if (nodo.id == temp.id) {
                    return null;
                } else if (nodo.id < temp.id) {
                    NodoB obj = insertar_en_pagina(nodo, temp.izquierda);
                    return validar_division(obj, rama);
                } else if (temp.siguiente == null) {
                    NodoB obj = insertar_en_pagina(nodo, temp.derecha);
                    return validar_division(obj, rama);
                }
                temp = (NodoB) temp.siguiente;
            } while (temp != null);
        }
        return null;
    }

    private NodoB validar_division(NodoB obj, Pagina rama){
        if (obj instanceof NodoB) {
            rama.insertar((NodoB) obj);
            if (rama.contador == orden_arbol) {
                return dividir(rama);
            }
        }
        return null;
    }

    private NodoB dividir(Pagina rama) {
        int val = -999;
        NodoB temp, Nuevito;
        NodoB aux = rama.primero;
        Pagina rderecha = new Pagina();
        Pagina rizquierda = new Pagina();

        int cont = 0;
        while (aux != null) {
            cont++;
            //implementacion para dividir unicamente ramas de 4 nodos
            if (cont < 3) {
                temp = new NodoB(aux.id, aux.izquierda,aux.siguiente.izquierda);
                //si la rama posee ramas deja de ser hoja
                rizquierda.hoja= !(temp.derecha != null && temp.izquierda != null);
                rizquierda.insertar(temp);
            } else if (cont == 3) {
                val = aux.id;
            } else {
                temp = new NodoB(aux.id, aux.izquierda,aux.derecha);
                //si la rama posee ramas deja de ser hoja
                rderecha.hoja= !(temp.derecha != null && temp.izquierda != null);
                rderecha.insertar(temp);
            }
            aux = aux.siguiente;
        }
        Nuevito = new NodoB(val,rizquierda,rderecha);
        return Nuevito;
    }
}
