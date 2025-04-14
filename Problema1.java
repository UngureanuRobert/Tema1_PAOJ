public class Problema1 {
    public static void main(String[] args)
    {
        if (args.length < 3)
        {
            System.out.println("Introdu minim 3 argumente");
            return;
        }
        int a = 0, b = 0;
        double c = 0.0;
        int eroare = 0;
        try
        {
            Integer w_a = Integer.parseInt(args[0]);
            Integer w_b = Integer.parseInt(args[1]);
            Double w_c = Double.parseDouble(args[2]);

            a = w_a;
            b = w_b;
            c = w_c;

            if (a == 0 || b == 0 || c == 0.0) 
            {
                eroare = 1;
            }
            else if (Double.isInfinite(c))
            {
                eroare = 2;
            }
        } catch (NumberFormatException e)
        {
            eroare = 3;
        }

        switch (eroare) {
            case 0:
                break;
            case 1:
                System.out.println("Cel putin unul dintre numere este 0!");
                return;
            case 2:
                System.out.println("c nu este un numar real valid!");
                return;
            case 3:
                System.out.println("Formatul numerelor gresit!");
                return;
        }
        double S = a + b + c;
        double M = (a + b + c) / 3;
        double P = a * b * c;

        System.out.println("Suma: " + S + " Media: " + M + " Produsul: " + P);
    }
}