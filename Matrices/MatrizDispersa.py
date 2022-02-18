class Nodo:
    def __init__(self,i, j, info) -> None:
        self.arriba=self.abajo=self.anterior=self.siguiente=None
        self.info=info
        self.i=i
        self.j=j

    def __str__(self) -> str:
        return f'[({self.i},{self.j}) INFO: {self.info}]'

class Matriz:
    """
    Arreglo de nodos que se crean dinámicamente conforme son necesitados.
    Se utiliza un convenio de filas y columnas para insertarlos de forma ordenada en la estructura,
    utilizando coordenadas.
    
    Las coordenadas tienen la forma (i,j) equivalente a (x,y), se utiliza como referencia la relación 
    entre el eje x del plano y el vector unitario i en su dirección & el eje y del plano y el vector 
    unitario j en su dirección. No confundir con el convenio de filas y columnas en arreglos estáticos
    donde i corresponde a las filas y j a las columnas.  Esto no influye en el desarrollo de la estructura
    solamente es una forma de identificar las coordenadas.
    """
    def __init__(self) -> None:
        self.raiz=Nodo(-1,-1,"Raiz")
        
    def insertarEnFila(self, nuevo, cabeceraFila) -> Nodo:
        """
            Inserta un nodo de forma ordenada en una fila específica
            Parameters
            ----------
            nuevo:
                Nodo que será insertado en la matriz
            cabeceraFila:
                Nodo a partir del cual se inicia el recorrido de la fila
                para determinar la posicion correcta del nuevo nodo
        """
        actual=cabeceraFila
        mayorEncontrado=False
        while True:
            if actual.i > nuevo.i:
                mayorEncontrado=True
                break

            elif actual.siguiente is not None:
                actual=actual.siguiente
            
            else:
                break
        
        if mayorEncontrado:
            nuevo.siguiente=actual
            nuevo.anterior=actual.anterior
            actual.anterior.siguiente=nuevo
            actual.anterior=nuevo
        else:
            actual.siguiente=nuevo
            nuevo.anterior=actual

        return nuevo

    def insertarEnColumna(self, nuevo, cabeceraColumna) -> Nodo:
        """
            Inserta un nodo de forma ordenada en una columna específica
            Parameters
            ----------
            nuevo:
                Nodo que será insertado en la matriz
            cabeceraFila:
                Nodo a partir del cual se inicia el recorrido de la columna
                para determinar la posicion correcta del nuevo nodo
        """
        actual=cabeceraColumna
        mayorEncontrado=False
        while True:
            if actual.j> nuevo.j:
                mayorEncontrado=True
                break

            elif actual.abajo is not None:
                actual=actual.abajo
            
            else:
                break
        
        if mayorEncontrado:
            nuevo.abajo=actual
            nuevo.arriba=actual.arriba
            actual.arriba.abajo=nuevo
            actual.arriba=nuevo
        else:
            actual.abajo=nuevo
            nuevo.arriba=actual

        return nuevo

    def buscarColumna(self,i):
        actual=self.raiz
        while actual is not None:
            if actual.i==i:
                return actual
            actual=actual.siguiente
        return None
    
    def buscarFila(self,j):
        actual=self.raiz
        while actual is not None:
            if actual.j==j:
                return actual
            actual=actual.abajo
        return None
        
    def crearColumna(self,i):
        return self.insertarEnFila(Nodo(i,-1,"Col"),self.raiz)
    
    def crearFila(self,j):
        return self.insertarEnColumna(Nodo(-1,j,"Row"),self.raiz)

    #TODO: Validar la insercion de nodos repetidos
    def insertarNodo(self,i, j, info):
        """
            Inserta un nuevo nodo en la matriz
            Parameters
            ----------
            i:
                columna en la cual se insertará el nodo, coordenada x del plano
            j:
                fila en la cual se insertará el nodo, coordenada y del plano
        """
        nuevo=Nodo(i,j,info)

        columna=self.buscarColumna(i)
        fila=self.buscarFila(j)

        #caso 1: 
        if columna is None and fila is None:
            columna=self.crearColumna(i)
            fila=self.crearFila(j)

            nuevo=self.insertarEnFila(nuevo,fila)
            nuevo=self.insertarEnColumna(nuevo,columna)
        #Caso 2: la columna existe y la fila no existe
        elif columna is not None and fila is None:
            fila=self.crearFila(j)
            nuevo=self.insertarEnFila(nuevo,fila)
            nuevo=self.insertarEnColumna(nuevo,columna)
        #Caso 3: la columna no existe y la fila existe
        elif columna is None and fila is not None:
            columna=self.crearColumna(i)
            nuevo=self.insertarEnFila(nuevo,fila)
            nuevo=self.insertarEnColumna(nuevo,columna)
        #Caso4: la columna y la fila existen
        else:
            nuevo=self.insertarEnFila(nuevo,fila)
            nuevo=self.insertarEnColumna(nuevo,columna)

    def imprimirFila(self,cabeceraFila):
        """
            Imprime una fila especifica de la matriz
            Parameters
            ----------
            cabeceraFila:
                nodo a partir del cual se inicia el recorrido de la fila
        """
        actual=cabeceraFila
        while actual is not None:
            print(str(actual), end=" ")
            actual=actual.siguiente
        print()
    
    def imprimirColumna(self,cabeceraColumna):
        """
            Imprime una columna especifa de la matriz
            Parameters
            ----------
            cabeceraColumna:
                nodo a partir del cual se inicia el recorrido de la columna
        """
        actual=cabeceraColumna
        while actual is not None:
            print(str(actual))
            actual=actual.abajo
        print()






