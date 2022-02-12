package Arreglos;

public class Ordenamientos {


    public static void burbuja(int[] arreglo){
        int aux,i;

        for(i=0; i<arreglo.length-1; i++){
            //ordenar el arreglo
            for(int j=0; j<arreglo.length-i-1;j++){  
                if(arreglo[j]>arreglo[j+1]){
                    aux=arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=aux;
                }
            }
        }
    }

    public static void seleccion(int[] arreglo){
        int menor, temp;  //menor tiene el indice del elemento menor, no el valor
        for(int i=0; i< arreglo.length; i++){
            menor=i;
            for(int j=i+1; j< arreglo.length;j++){
                if(arreglo[j]< arreglo[menor]){
                    menor=j;
                }
            }

            temp=arreglo[i];
            arreglo[i]=arreglo[menor];
            arreglo[menor]=temp;
        }
    }

    public static void insercion(int[] arreglo){
        int actual, pos;    // actual es el valor clave
        for(int i=0;i<arreglo.length;i++){
            actual=arreglo[i];
            pos=i;

            while(pos > 0 && arreglo[pos-1] > actual){
                arreglo[pos]=arreglo[pos-1];
                pos--;
            }

            arreglo[pos]=actual;
        }
    }

    private static void quicksort(int[] arreglo,int primero, int ultimo){
        int i, j, central;
        int pivote;
        central=(primero+ultimo)/2;
        pivote=arreglo[central];
        
        i=primero;
        j=ultimo;

        do{
            while(arreglo[i]< pivote) 
                i++;
            while(arreglo[j]> pivote) 
                j--;

            if(i<=j){
                intercambiar(arreglo, i, j);
                i++;
                j--;
            }
        }while(i<=j);

        if(primero < j) quicksort(arreglo, primero, j); //mismo proceso con sublista izquierda
        if(i < ultimo) quicksort(arreglo,i,ultimo); // mismo proceso con sublista derecha
    }

    private static void intercambiar(int[] arreglo,int i, int j){
        int aux=arreglo[i];
        arreglo[i]=arreglo[j];
        arreglo[j]=aux;
    }
    
    public static void quicksort(int[] arreglo){
        quicksort(arreglo,0,arreglo.length-1);
    }

    public static void imprimir(int[] arreglo){
        System.out.println("Arreglo: ");
        for(int x:arreglo) System.out.print(x + ", ");
        System.out.println();
    }
}
