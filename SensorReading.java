import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa una única lectura de sensor (temperatura + humedad).
 * Incluye timestamp automático.
 */
public class SensorReading {
    private double temperature;  // °C
    private double humidity;     // %
    private LocalDateTime timestamp;
    
    public SensorReading(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters
    public double getTemperature() { return temperature; }
    public double getHumidity() { return humidity; }
    public LocalDateTime getTimestamp() { return timestamp; }
    
    /**
     * Formato corto para mostrar en consola
     */
    public String toShortString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("[%s] Temp: %.1f°C | Hum: %.1f%%", 
                timestamp.format(formatter), temperature, humidity);
    }
    
    /**
     * Formato CSV (una línea)
     */
    public String toCSVString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%s,%.2f,%.2f", 
                timestamp.format(formatter), temperature, humidity);
    }
    
    public static String getCSVHeader() {
        return "Timestamp,Temperature_C,Humidity_%";
    }
}
