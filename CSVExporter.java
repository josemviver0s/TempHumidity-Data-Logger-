import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * Exporta lecturas a formato CSV.
 */
public class CSVExporter {
    
    public static boolean exportToCSV(List<SensorReading> readings, String filename) {
        if (readings.isEmpty()) {
            System.out.println("❌ No hay datos para exportar.");
            return false;
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            
            // Escribir metadatos
            writer.write("# Temperature & Humidity Data Logger");
            writer.newLine();
            writer.write("# Generated: " + java.time.LocalDateTime.now());
            writer.newLine();
            writer.write("# Total readings: " + readings.size());
            writer.newLine();
            
            // Cabecera
            writer.write(SensorReading.getCSVHeader());
            writer.newLine();
            
            // Datos
            for (SensorReading reading : readings) {
                writer.write(reading.toCSVString());
                writer.newLine();
            }
            
            System.out.println("✅ Datos exportados a: " + filename);
            return true;
            
        } catch (IOException e) {
            System.out.println("❌ Error al exportar: " + e.getMessage());
            return false;
        }
    }
}
