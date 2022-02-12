from Nodo import Nodo 

class Lista:
    """Estructura de datos en la que cada elemento apunta al siguiente, como punto de acceso a la lista se utiliza 
        una referencia al primer nodo"""
    def __init__(self):
        self.primero=None
        self.tamanio=0

    def estaVacia(self):
        "Comprueba si la lista esta vacia"
        return self.primero is None

    def insertarAlinicio(self,info):
        """Inserta un nuevo nodo al principio de la lista
            
            Parameters
            ----------
            info:
                informacion que se almacena en el nuevo nodo"""
        nuevo=Nodo(info)
        if self.estaVacia():
            self.primero=nuevo
            self.tamanio+=1
        else:
            nuevo.siguiente=self.primero
            self.primero=nuevo
            self.tamanio+=1
    
    def insertarfinal(self, info):
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

    def eliminar(self, datoEliminar):
        """Elimina un nodo  de la lista
            
            Parameters
            ----------
            datoEliminar:
                informacion contenida en el nodo que se desea eliminar"""
        actual=self.primero
        encontrado=False
        anterior=None

        while actual != None and (not encontrado):
            encontrado = actual.info == datoEliminar
            if not encontrado:
                anterior=actual
                actual=actual.siguiente

        if actual != None:
            if actual== self.primero:
                self.primero=actual.siguiente
            else:
                anterior.siguiente=actual.siguiente
            self.tamanio-=1

    def insertarOrdenado(self, dato):
        nuevo=Nodo(dato)

        if self.estaVacia():
            self.primero=nuevo
        elif dato < self.primero.info:
            nuevo.siguiente=self.primero
            self.primero=nuevo
        else:
            anterior=puntero=self.primero
            while puntero.siguiente is not None  and dato > puntero.info:
                anterior=puntero
                puntero=puntero.siguiente
        
            if dato > puntero.info:
                anterior=puntero
            
            nuevo.siguiente = anterior.siguiente
            anterior.siguiente = nuevo
        self.tamanio+=1
  
    def visualizar(self):
        "Recorre  la lista mostrando la informacion de cada nodo"
        actual=self.primero

        while actual is not None:
            print(actual.info, end=",")
            actual=actual.siguiente
        print()
  
if  __name__ ==  '__main__':
    lista=Lista()
    lista.insertarOrdenado(4)
    lista.insertarOrdenado(2)
    lista.insertarOrdenado(3)
    lista.insertarOrdenado(12)
    lista.insertarOrdenado(52)

    lista.visualizar()
    
