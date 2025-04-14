class Carte implements Cloneable
{
    private String titlu, autor;
    private int anAparitie;

    public Carte(String titlu, String autor, int anAparitie)
    {
        this.titlu = titlu;
        this.autor = autor;
        this.anAparitie = anAparitie;
    }

    public void afiseazaDetalii()
    {
        System.out.println("Cartea cu titlul: " + this.titlu + " are autorul " + this.autor + " si a aparut in anul " + anAparitie);
    }

    public void afiseazaDetalii(boolean detalii_complete)
    {
        if (detalii_complete == true)
        {
            afiseazaDetalii();
        }
        else
        {
            System.out.println("Cartea cu titlul: " + this.titlu + " are autorul " + this.autor);
        }
    }
    //shallow copy
    /**
     * Shallow copy va face o copiere superficiala, intrucat copiaza doar referintele atributelor clasei Carte (titlu, autor, anAparitie).
     * Shallow copy afecteaza doar obiectele mutabile, fara String, acestea fiind modificate in toate instantele
     */
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    //deep copy
    /*
     * Deep copy creeaza o noua instanta a clasei Carte cu instante noi petnru fiecare atribut din clasa, inclusiv String.
     * Deci modificarile asupra unei copii nu va afecta nicio alta instanta a clasei.
     */
    public Carte(Carte carte1)
    {
        this.titlu = new String(carte1.titlu);
        this.autor = new String(carte1.autor);
        this.anAparitie = carte1.anAparitie;
    }

    @Override
    public String toString()
    {
        return "Carte{titlu = ''" + this.titlu + "' autor= '" + this.autor + "' anAparitie= '" + this.anAparitie + "'}";
    }
}




public class Problema5 {
    public static void main(String[] args)
    {
        Carte carte = new Carte("De veghe in lanul de scrumbie", "Chuck Morris", 2012);

        //cartea originala
        carte.afiseazaDetalii();
        carte.afiseazaDetalii(false);
        System.out.println(carte);

        //shallow copy
        try
        {
            Carte shallow_copy = (Carte) carte.clone();
            System.out.println("Shallow Copy: " + shallow_copy);
        } catch(CloneNotSupportedException e)
        {
            System.out.println("Clone not supported");
        }

        //deep copy
        Carte deep_copy = new Carte(carte);
        System.out.println("Deep Copy: " + deep_copy);
        
        //Verificare carte cu deep copy
        System.out.println(carte == deep_copy);
    }
}
