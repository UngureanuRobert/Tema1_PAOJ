class Profesor
{
    private String nume, specializare;
    private final int codIdentificare;

    public Profesor(String nume, String specializare, int codIdentificare)
    {
        this.nume = nume;
        this.specializare = specializare;
        this.codIdentificare = codIdentificare;
    }
    public void set_nume(String nume)
    {
        this.nume = nume;
    }

    public void set_specializare(String specializare)
    {
        this.specializare = specializare;
    }

    public String get_nume()
    {
        return this.nume;
    }

    public String get_specializare()
    {
        return this.specializare;
    }

    public int get_codIdentificare()
    {
        return this.codIdentificare;
    }
    
}

class Curs
{
    private Profesor profesor;
    private String[] studenti;

    public Curs(String nume, String specializare, int codIdentificare, String[] studenti)
    {
        this.studenti = studenti; //agregare
        this.profesor = new Profesor(nume, specializare, codIdentificare); //compozitie
    }

    public Profesor get_profesor()
    {
        return profesor;
    }
    public String[] get_studenti()
    {
        return studenti;
    }

    public void afisare_curs()
    {
        System.out.println("Profesorul " + profesor.get_nume() + " preda " + profesor.get_specializare() + " si are codul de identificare " + profesor.get_codIdentificare());
        System.out.println("Studentii sai sunt: ");
        for (int i=0; i<studenti.length; i++)
        {
            System.out.println(studenti[i]);
        }
    }
}

public class Problema6 {
    public static void main(String[] args)
    {
        String[] studenti = {"Andrei Bocaru", "Baalae Georgica", "Maria Ioana", "Dinut Danel", "Dinut Danela"};
        //accesare atribute profesor prin constructor Curs si atribuirea acestora. De asemenea, atribuirea valorilor pentru lista de studenti.
        Curs curs = new Curs("Boloianu Vasel", "Programare Avansata", 1234, studenti);
        curs.afisare_curs();
        //modificarea atributului unui profesor direct din clasa Curs, prin getter de profesor(din clasa curs) si setter al clasei profesor
        curs.get_profesor().set_specializare("Algoritmi Fundamentali"); 
        curs.afisare_curs();
        //Afisare profesor, demonstrarea modului in care preiau datele profesorului: din Curs, cu getterul de profesor, si apoi cu getterele de atribute ale sale
        System.out.println("Detalii profesor: " + curs.get_profesor().get_nume() + " " + curs.get_profesor().get_specializare() + " " + curs.get_profesor().get_codIdentificare());
    }
}
