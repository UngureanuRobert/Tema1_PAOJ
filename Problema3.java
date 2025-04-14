

abstract class Vehicul
{
    protected String marca, model;
    int anFabricatie;

    public Vehicul(String marca, String model, int anFabricatie)
    {
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
    }

    public abstract String descriere();
}

class Masina extends Vehicul
{
    private String tip_transmisie;
    public Masina(String marca, String model, int anFabricatie, String tip_transmisie)
    {
        super(marca, model, anFabricatie);
        this.tip_transmisie = tip_transmisie;
    }
    @Override
    public String descriere()
    {
        return ("Masina " + this.marca + " " + " modelul " + this.model + " fabricata in anul " + this.anFabricatie + " are tipul de transmisie " + this.tip_transmisie);
    }
}


class Motocicleta extends Vehicul
{
    private String clasa_putere;
    public Motocicleta(String marca, String model, int anFabricatie, String clasa_putere)
    {
        super(marca, model, anFabricatie);
        this.clasa_putere = clasa_putere;
    }
    @Override
    public String descriere()
    {
        return ("Motocicleta " + this.marca + " " + " modelul " + this.model + " fabricata in anul " + this.anFabricatie + " are clasa de putere " + this.clasa_putere);
    }
}


public class Problema3 {
    public static void main(String[] args)
    {
        Vehicul[] vehicule = new Vehicul[5];
        vehicule[0] = new Masina("Dacia", "Logan", 2019, "Manuala");
        vehicule[1] = new Motocicleta("Yamaha", "Mt-15", 2017, "A2");
        vehicule[2] = new Masina("Reanult", "Talisman", 2015, "Manuala");
        vehicule[3] = new Motocicleta("Yamaha", "R3", 2019, "A");
        vehicule[4] = new Masina("Audi", "A5", 2018, "Automata");
        
        System.out.println("Vehicule: ");
        for (Vehicul vehicul : vehicule)
        {
            System.out.println(vehicul.descriere());
        }
    }
}
