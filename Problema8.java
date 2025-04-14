import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student>
{
    private final String nume;
    private final int varsta;
    private final double medie;

    public Student(String nume, int varsta, double medie)
    {
        this.nume = nume;
        this.varsta = varsta;
        this.medie = medie;

    }

    @Override
    public int compareTo(Student other)
    {
        return Double.compare(other.medie, this.medie); //ordine descrescatoare
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return varsta == other.varsta && Double.compare(medie, other.medie) == 0 && nume.equals(other.nume);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(nume, varsta, medie);   
    }

    @Override
    public String toString()
    {
        return "Student: " + "{" + "nume= " + this.nume + " varsta= " + this.varsta + " medie= " + this.medie + " }";
    }

    public String get_nume()
    {
        return this.nume;
    }

    public int get_varsta()
    {
        return this.varsta;
    }

    public double get_media()
    {
        return this.medie;
    }
}

class Grup<K extends Student>
{
    private ArrayList<K> studenti;
    public Grup()
    {
        studenti = new ArrayList<>();
    }

    public void adaugare_student(K student)
    {
        studenti.add(student);
    }

    public K cautare_student(String nume)
    {
        for (K student : studenti)
        {
            if (student.get_nume().equals(nume))
            {
                return student;
            }
        }
        return null;
    }

    public void sortare_studenti()
    {
        Collections.sort(studenti);
    }

    public String raport_textual() //cu StringBuilder
    {
        StringBuilder sb = new StringBuilder("Raport Textual StringBuilder");
        for (K student : studenti)
        {
            sb.append(student + "\n");
        }
        return sb.toString();
    }

    public String raport_sincronizat() //cu StringBuffer
    {
        StringBuffer sbf = new StringBuffer("Raport Sincronizat StringBuffer");
        for (K student : studenti)
        {
            sbf.append(student + "\n");
        }
        return sbf.toString();
    }

    public ArrayList<K> get_studenti()
    {
        return studenti;
    }
}

public class Problema8 {
    public static void main(String[] args)
    {
        Grup<Student> grup = new Grup<>();
        grup.adaugare_student(new Student("Gonica Andre", 20, 9.0));
        grup.adaugare_student(new Student("Gonica Andreea", 20, 8.5));
        grup.adaugare_student(new Student("Bolocvia Marian", 22, 7.5));

        System.out.println("Toti studentii din grup:");
        for (Student student : grup.get_studenti())
        {
            System.out.println(student);
        }

        Student student1 = grup.cautare_student("Honica Andre");
        if (student1 != null)
        {
            System.out.println("Student gasit");
        }
        else
        {
            System.out.println("Nu exista niciun student cu numele acesta!");
        }

        grup.sortare_studenti();
        for (Student student : grup.get_studenti())
        {
            System.out.println(student);
        }
        System.out.println("Raport StringBuilder: ");
        System.out.println(grup.raport_textual());

        System.out.println("Raport StringBuffer: ");
        System.out.println(grup.raport_sincronizat());

        /*
         * Diferenta intre StringBuilder si StringBuffer este ca StringBuilder nu este sincronizat, ceea ce il face mai rapid decat StringBuffer.
         * Cu toate acestea, StringBuilder nu este thread-safe, deoarece nu este sincronizat. Deci daca mai multe threaduri care lucreaza in paralel
         * acceseaza acelasi obiect in acelasi timp si incep sa lucreze cu el, se vor produce ori modificari neasteptate si eronate, ori se poate
         * bloca.
         * 
         * StringBuffer este sincronizat, ceea ce le permite mai multor threaduri sa acceseze acelasi obiect si sa il prelucreze in paralel, 
         * fara modificari neasteptate. Cu toate acestea, din cauza acestui aspect, este mai neeficient decat StringBuilder.
         */
    }
}
