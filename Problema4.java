import java.text.SimpleDateFormat;
import java.util.Date;

class Logger
{
    private static Logger instanta = null;
    private Logger()
    {

    }

    private static String ora()
    {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static Logger getInstance()
    {
        if (instanta == null)
        {
            instanta = new Logger();
        }
        return instanta;
    }

    public static void logInfo(String mesaj)
    {
        System.out.println("Info " + ora() + " " + mesaj);
    }
    public static void logWarning(String mesaj)
    {
        System.out.println("Warning " + ora() + " " + mesaj);
    }
    public static void logError(String mesaj)
    {
        System.out.println("Error " + ora() + " " + mesaj);
    }
}


public class Problema4 {
    public static void main(String[] args)
    {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        if (logger1 == logger2) System.out.println("Aceasi instanta de logger");
        Logger.logInfo("Aplicatia ruleaza");
        Logger.logWarning("Avem un warning!");
        Logger.logError("Avem o eroare!");
    }
}
