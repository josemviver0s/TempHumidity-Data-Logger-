import java.util.List;
import java.util.Scanner;

/**
 * Aplicación principal del Data Logger.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataLogger logger = new DataLogger();
        
        System.out.println("========================================");
        System.out.println("   TEMPERATURE & HUMIDITY DATA LOGGER");
        System.out.println("========================================");
        System.out.println("Simulador de monitoreo ambiental");
        
        int option;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Generar una lectura");
            System.out.println("2. Generar 10 lecturas de prueba");
            System.out.println("3. Generar 50 lecturas (simulación histórica)");
            System.out.println("4. Ver últimas lecturas");
            System.out.println("5. Ver estadísticas completas");
            System.out.println("6. Exportar a CSV");
            System.out.println("7. Limpiar todos los datos");
            System.out.println("8. Salir");
            System.out.print("Seleccione: ");
            
            option = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            
            switch (option) {
                case 1:
                    SensorReading r = logger.generateReading();
                    System.out.println("✅ Lectura generada: " + r.toShortString());
                    break;
                    
                case 2:
                    logger.generateBulkReadings(10);
                    break;
                    
                case 3:
                    logger.generateBulkReadings(50);
                    break;
                    
                case 4:
                    logger.displayLastReadings(10);
                    break;
                    
                case 5:
                    List<SensorReading> all = logger.getAllReadings();
                    Statistics.StatsResult stats = Statistics.calculate(all);
                    if (stats != null) {
                        stats.print();
                    } else {
                        System.out.println("📭 No hay datos para calcular estadísticas.");
                    }
                    break;
                    
                case 6:
                    String filename = "datalogger_" + 
                            java.time.LocalDateTime.now().format(
                                java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) 
                            + ".csv";
                    CSVExporter.exportToCSV(logger.getAllReadings(), filename);
                    break;
                    
                case 7:
                    logger.clearReadings();
                    break;
                    
                case 8:
                    System.out.println("👋 Saliendo...");
                    break;
                    
                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (option != 8);
        
        scanner.close();
    }
}
