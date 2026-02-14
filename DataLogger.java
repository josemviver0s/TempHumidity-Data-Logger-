import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Simula un data logger que genera lecturas de sensores.
 * Puede generar datos en tiempo real o simulaciones históricas.
 */
public class DataLogger {
    private List<SensorReading> readings;
    private Random random;
    
    // Rangos realistas para temperatura y humedad
    private static final double MIN_TEMP = 15.0;
    private static final double MAX_TEMP = 35.0;
    private static final double MIN_HUM = 30.0;
    private static final double MAX_HUM = 90.0;
    
    public DataLogger() {
        this.readings = new ArrayList<>();
        this.random = new Random();
    }
    
    /**
     * Genera una nueva lectura simulada y la agrega al registro.
     */
    public SensorReading generateReading() {
        double temp = MIN_TEMP + (MAX_TEMP - MIN_TEMP) * random.nextDouble();
        double hum = MIN_HUM + (MAX_HUM - MIN_HUM) * random.nextDouble();
        
        SensorReading reading = new SensorReading(temp, hum);
        readings.add(reading);
        return reading;
    }
    
    /**
     * Genera múltiples lecturas simuladas (para pruebas o históricos).
     * @param count Número de lecturas a generar
     */
    public void generateBulkReadings(int count) {
        System.out.println("⏳ Generando " + count + " lecturas simuladas...");
        for (int i = 0; i < count; i++) {
            generateReading();
            try {
                Thread.sleep(100); // Pequeña pausa para timestamps realistas
            } catch (InterruptedException e) {
                // Ignorar
            }
        }
        System.out.println("✅ " + count + " lecturas generadas.");
    }
    
    /**
     * Retorna todas las lecturas almacenadas.
     */
    public List<SensorReading> getAllReadings() {
        return new ArrayList<>(readings);
    }
    
    /**
     * Limpia todas las lecturas.
     */
    public void clearReadings() {
        readings.clear();
        System.out.println("🧹 Datos eliminados.");
    }
    
    /**
     * Muestra las últimas N lecturas en consola.
     */
    public void displayLastReadings(int n) {
        if (readings.isEmpty()) {
            System.out.println("📭 No hay lecturas almacenadas.");
            return;
        }
        
        int start = Math.max(0, readings.size() - n);
        System.out.println("\n📊 Últimas " + (readings.size() - start) + " lecturas:");
        for (int i = start; i < readings.size(); i++) {
            System.out.println("  " + readings.get(i).toShortString());
        }
    }
}
