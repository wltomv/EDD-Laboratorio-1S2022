from Nodo import Nodo

class Pila:
    """"""
    def __init__(self):
        self.cima=None
        self.tamanio=0

    def estaVacia(self):
        "Comprueba si la pila esta vacia"
        return self.cima is None

    def push(self,info):
        """Inserta un nuevo nodo al principio de la lista
            
            Parameters
            ----------
            info:
                informacion que se almacena en el nuevo nodo"""
        nuevo=Nodo(info)
        if self.estaVacia():
            self.cima=nuevo
            self.tamanio+=1
        else:
            nuevo.siguiente=self.cima
            self.cima=nuevo
            self.tamanio+=1
    
    def peek(self):
        return self.cima.info

    def pop(self):
        self.cima=self.cima.siguiente

    def visualizar(self):
        "Recorre  la lista mostrando la informacion de cada nodo"
        actual=self.cima

        while actual is not None:
            print(actual.info, end=",")
            actual=actual.siguiente
        print()
 
pila= Pila()

pila.push(1)
pila.push(2)
pila.push(3)

pila.visualizar()
pila.pop()
pila.visualizar()
print(pila.peek())
