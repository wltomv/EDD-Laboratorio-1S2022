package Util.Granja;

import EDD.Arboles.ArbolBB;
import Util.Animales.*;

public class Granja {
    private ArbolBB<Vaca> vacas;
    private ArbolBB<Gallina> gallinas;

    public Granja(){
        this.vacas=new ArbolBB<>();
        this.gallinas=new ArbolBB<>();
    }

    public void comprarVaca(Vaca vaca){
        this.vacas.insertar(vaca);
    }

    public void listarVacas(){
        this.vacas.preOrden();
    }

    public void comprarGallina(Gallina gallina){
        this.gallinas.insertar(gallina);
    }
    public void listarGallinas(){
        this.gallinas.preOrden();
    }
    
}
