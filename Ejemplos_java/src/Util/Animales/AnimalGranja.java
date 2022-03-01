package Util.Animales;


import lombok.Getter;

@Getter
public class AnimalGranja {
    private String nombre;
    private String especie;
    private double peso;
    private int edad;
    private double precio;

    public AnimalGranja(String nombre, String especie, double peso, int edad , double precio) {
        this.nombre = nombre;
        this.especie = especie;
        this.peso = peso;
        this.edad = edad;
        this.precio= precio;
    }

    public String toString(){
        return "Animal: " + this.especie + ", Nombre: " + this.nombre 
            + ", Edad: " + this.edad + ", Peso: " +this.peso + "\n";
    }

    public void comer(String comida){
        System.out.println(" Comiendo: " + comida); 
        
    }
}


