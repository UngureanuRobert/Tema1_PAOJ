import java.util.ArrayList;
class Animal
{
    public void sunet()
    {
        System.out.println("Oare cum face animalul asta...");
    }
}

class Mamifer extends Animal
{

}

class Caine extends Mamifer
{
    @Override
    public void sunet()
    {
        System.out.println("Cainele latra");
    }
    public void latra()
    {
        System.out.println("Stai ba cuminte, ce vrei, sa ma musti?");
    }
}

class Pisica extends Mamifer
{
    @Override
    public void sunet()
    {
        System.out.println("Pisica miauna");
    }
    public void miauna()
    {
        System.out.println("A mieunat pisicul la mine!!");
    }
}


public class Problema7 {
    public static void main(String[] args)
    {
        //upcasting cu un array de animale unde introducem si caini si pisici
        ArrayList<Animal> animale = new ArrayList<>();
        animale.add(new Caine());
        animale.add(new Pisica());
        animale.add(new Caine());
        animale.add(new Pisica());
        for (Animal animal : animale)
        {
            if (animal instanceof Caine) 
            {
                System.out.println("Asta e caine");
                Caine caine = (Caine) animal; //downcasting explicit, din animal ii fac downcasting la caine
                caine.latra();
            }
            else if (animal instanceof Pisica)
            {
                System.out.println("Asta e pisica");
                Pisica pisica = (Pisica) animal; //downcasting explicit, din animal il downcastez la pisica
                pisica.miauna();
            }
        }
    }
}
