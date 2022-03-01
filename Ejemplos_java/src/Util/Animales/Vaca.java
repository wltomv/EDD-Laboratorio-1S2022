package Util.Animales;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vaca extends AnimalGranja implements Comparable<Vaca> {
    private boolean marcada;
    
    /**
     * 
     * @param nombre nombre
     * @param peso
     * @param edad
     * @param precio
     * @param marcada
     */
    public Vaca(String nombre, float peso, int edad, float precio, boolean marcada) {
        super(nombre, "Vaca", peso, edad, precio);
        this.marcada = marcada;
    }

    public void muu(){
        System.out.println("Moo Mooo!");
    }

    @Override
    public int compareTo(Vaca vaca) {
        
        return this.getEdad() - vaca.getEdad();
    }

}
