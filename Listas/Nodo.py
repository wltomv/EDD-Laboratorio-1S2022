class Nodo:
    "Almacena la informacion y tiene un apuntador al siguiente nodo de la lista"
    def __init__(self,info):
        self.info=info
        self.siguiente=None