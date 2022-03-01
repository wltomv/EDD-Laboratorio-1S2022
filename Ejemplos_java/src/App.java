
import Util.Animales.*;
import Util.Granja.Granja;

public class App {
    public static void main(String[] args) throws Exception {       
        //PRUEBA DE LISTA DOBLEMENTE ENLAZADA
        Granja granja=new Granja();
        Vaca vaca=new Vaca("Lola",600, 15, 5000, true);
        Vaca vaca2=new Vaca("Negra",600, 17, 5000, true);
        Vaca vaca3=new Vaca("Manchitas",600, 20, 5000, true);
        Vaca vaca4=new Vaca("Besie",600, 9, 5000, true);

        granja.comprarVaca(vaca);
        granja.comprarVaca(vaca2);
        granja.comprarVaca(vaca3);
        granja.comprarVaca(vaca4);

        Gallina gallina=new Gallina("blanca",5.2, 1, 100.0);
        Gallina gallina2=new Gallina("roja",4.3, 2, 90.0);
        Gallina gallina3=new Gallina("cafe",2.1, 3, 70.0);
        Gallina gallina4=new Gallina("amarilla",6.89, 2, 50.0);
        
        

        granja.comprarGallina(gallina);
        granja.comprarGallina(gallina2);
        granja.comprarGallina(gallina3);
        granja.comprarGallina(gallina4);

        System.out.println("----Vacas----");
        granja.listarVacas();
        System.out.println("----Gallinas----");
        granja.listarGallinas();
    }
}
