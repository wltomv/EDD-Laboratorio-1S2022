package Util.Animales;

public class Gallina extends AnimalGranja  implements Comparable<Gallina>{
    private int pollitos;
    
    public Gallina(String nombre, double peso, int edad, double precio){
        super(nombre,"Gallina",peso,edad, precio);
        this.pollitos=0;
    }

    public void ponerHuevo(){
        cacarear();
        System.out.println("Hay un nuevo huevo");
    }

    public void cacarear(){
        System.out.println("clo clo clo");
    }

    @Override
    public int compareTo(Gallina gallina) {
        return (int)Math.round(this.getPrecio())- (int)Math.round(gallina.getPrecio());
    }
}
