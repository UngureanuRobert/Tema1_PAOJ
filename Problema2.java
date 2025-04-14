import java.util.Arrays;
import java.util.Scanner;

public class Problema2 {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String linie = s.nextLine();
        String[] string_v = linie.split(" ");
        if (string_v.length < 5)
        {
            System.out.println("Array-ul trebuie sa aiba 5 elemente!");
            s.close();
            return;
        }

        Integer[] wrapper_v = new Integer[string_v.length];
        
        for (int i=0; i<wrapper_v.length; i++)
        {
            wrapper_v[i] = Integer.valueOf(string_v[i]);
        }

        int[] v = new int[wrapper_v.length];
        for (int i=0; i<v.length; i++)
        {
            v[i] = wrapper_v[i];
        }

        System.out.println("V initial: " + Arrays.toString(v));
        Arrays.sort(v);
        int x = v[3];
        int poz = Arrays.binarySearch(v, x);
        System.out.println("V sortat: " + Arrays.toString(v));
        System.out.println("Elementul " + x + " se afla pe pozitia " + poz);

        s.close();
    }
}
