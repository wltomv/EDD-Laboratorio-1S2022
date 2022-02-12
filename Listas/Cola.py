from Nodo import Nodo

class Cola:
    """"""
    def __init__(self):
        self.primero=None
        self.tamanio=0

    def estaVacia(self):
        "Comprueba si la lista esta vacia"
        return self.primero is None

    def enqueue(self, info):
        """Inserta un nuevo nodo al final de la lista
            
            Parameters
            ----------
            info:
                informacion que se almacena en el nuevo nodo"""
        nuevo = Nodo(info)
        puntero = self.primero

        if self.estaVacia():
            self.primero=nuevo
            
        else:
            while puntero.siguiente is not None:
                puntero = puntero.siguiente
            puntero.siguiente = nuevo
        self.tamanio+=1

    def peek(self):
        return self.primero.info

    def dequeue(self):
        self.primero=self.primero.siguiente

    def visualizar(self):
        "Recorre  la lista mostrando la informacion de cada nodo"
        actual=self.primero

        while actual is not None:
            print(actual.info, end=",")
            actual=actual.siguiente
        print()
 

cola=Cola()
cola.enqueue(1)
cola.enqueue(2)
cola.enqueue(3)
cola.visualizar()
cola.dequeue()
cola.visualizar()
