

class Nodo:
    "Almacena la informacion y tiene un apuntador al siguiente nodo de la lista"
    def __init__(self,info):
        self.info=info

        self.siguiente=None
    
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
    
    def instertarfinal(self, info):
        """Inserta un nuevo nodo al final de la lista
            
            Parameters
            ----------
            info:
                informacion que se almacena en el nuevo nodo"""
        nuevo = Nodo(info)
        puntero = self.primero

        if self.primero is not None:
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
  
    def visualizar(self):
        "Recorre  la lista mostrando la informacion de cada nodo"
        actual=self.primero

        while actual is not None:
            print(actual.info, end=",")
            actual=actual.siguiente
        print()
  
if  __name__ ==  '__main__':
    lista=Lista()
    lista.insertarAlinicio(1)
    lista.insertarAlinicio(2)
    lista.insertarAlinicio(3)
    lista.instertarfinal(4)
    lista.instertarfinal(5)
    
    lista.visualizar()
    lista.eliminar(5)
    lista.visualizar()
