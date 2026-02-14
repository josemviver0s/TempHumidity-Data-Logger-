import java.util.List;

/**
 * Calcula estadísticas básicas de las lecturas de sensores.
 */
public class Statistics {
    
    public static class StatsResult {
        public double avgTemp;
        public double maxTemp;
        public double minTemp;
        public double avgHum;
        public double maxHum;
        public double minHum;
        public int count;
        
        public void print() {
            System.out.println("\n📈 ESTADÍSTICAS DE " + count + " LECTURAS");
            System.out.println("─────────────────────────────");
            System.out.printf("🌡️ Temperatura:  Prom=%.2f°C | Máx=%.2f°C | Mín=%.2f°C\n", 
                    avgTemp, maxTemp, minTemp);
            System.out.printf("💧 Humedad:      Prom=%.2f%% | Máx=%.2f%% | Mín=%.2f%%\n", 
                    avgHum, maxHum, minHum);
        }
    }
    
    public static StatsResult calculate(List<SensorReading> readings) {
        if (readings.isEmpty()) {
            return null;
        }
        
        StatsResult result = new StatsResult();
        result.count = readings.size();
        
        double sumTemp = 0;
        double sumHum = 0;
        result.maxTemp = Double.MIN_VALUE;
        result.minTemp = Double.MAX_VALUE;
        result.maxHum = Double.MIN_VALUE;
        result.minHum = Double.MAX_VALUE;
        
        for (SensorReading r : readings) {
            double temp = r.getTemperature();
            double hum = r.getHumidity();
            
            sumTemp += temp;
            sumHum += hum;
            
            if (temp > result.maxTemp) result.maxTemp = temp;
            if (temp < result.minTemp) result.minTemp = temp;
            if (hum > result.maxHum) result.maxHum = hum;
            if (hum < result.minHum) result.minHum = hum;
        }
        
        result.avgTemp = sumTemp / result.count;
        result.avgHum = sumHum / result.count;
        
        return result;
    }
}
