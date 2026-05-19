package test_orders;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class AppLogger {
    //  création d'un logger nommé pour que plusieurs appels retournent la même instance
    private static final Logger logger = Logger.getLogger("OrderApp");
    // une seul execution avant constructeur
    static {
        try {
            // desactivation de logger root pour éviter d'afficher tous les éléments en double
            logger.setUseParentHandlers(false);

            Formatter formatter = new Formatter() {
                @Override
                // contrôle du format de chaque ligne de log (tT pour heure et -7s pour aligner sur 7 caractères)
                public String format(LogRecord record) {
                    return String.format("[%tT] [%-7s] %s%n",
                        record.getMillis(),
                        record.getLevel().getName(),
                        record.getMessage()
                    );
                }
            };
            // envoi des logs vers la console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            // Affichage de tous les niveaux
            consoleHandler.setLevel(Level.ALL);
            consoleHandler.setFormatter(formatter);
            // écriture dans un fichier et écrasement pour chaque démarrage
            FileHandler fileHandler = new FileHandler("orders.log", false);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(formatter);

            logger.addHandler(consoleHandler);
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        // Attraper l'erreur IO
        } catch (IOException e) {
            System.err.println("Erreur initialisation logger: " + e.getMessage());
        }
    }
    // afficher les logs
    public static Logger get() {
        return logger;
    }
}
