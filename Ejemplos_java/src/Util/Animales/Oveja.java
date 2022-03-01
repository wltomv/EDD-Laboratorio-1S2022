package Util.Animales;
import lombok.Getter;

@Getter
public class Oveja extends AnimalGranja {
    private int lana;

    public Oveja(String nombre,float peso, int edad, float precio){
        super(nombre,"Oveja",peso,edad, precio);
        this.lana=0;
    }

    public void balido(){
        System.out.println("Baaaah Baaaah");
    }
}
