
# TempHumidity-Data-Logger-
Simulator for a temperature and humidity data logger. Generates simulated readings from environmental sensors, stores them in memory, calculates basic statistics (average, maximum, minimum), and exports the data to CSV for analysis in Excel. Ideal for environmental monitoring in greenhouses, computer centers, or laboratories.


# 🌡️ Temperature & Humidity Data Logger

![Java](https://img.shields.io/badge/Java-17-orange)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)
![License](https://img.shields.io/badge/License-MIT-blue)
![IoT](https://img.shields.io/badge/Simulation-IoT_Data_Logger-blue)

A Java console application that simulates a **temperature and humidity data logger**, commonly used in environmental monitoring for greenhouses, server rooms, laboratories, or weather stations.

---

## 🎯 Features

- ✅ Generate **real-time simulated sensor readings** (temperature °C, humidity %).
- ✅ Bulk generation for **historical data simulation** (10, 50, or custom readings).
- ✅ **Statistical analysis**: average, max, min for both temperature and humidity.
- ✅ **Export to CSV** for analysis in Excel, MATLAB, or Python.
- ✅ Clean, menu-driven console interface.

---

## 🧠 Logic & Concepts Applied

- **Object-Oriented Programming** (`SensorReading`, `DataLogger`, `Statistics`)
- **File I/O** (CSV export with metadata)
- **Data structures** (`ArrayList` for dynamic storage)
- **Statistical calculations** (mean, min, max)
- **Randomized data generation** within realistic ranges (15–35°C, 30–90% RH)
- **Timestamp handling** with `LocalDateTime`

---

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/temp-humidity-datalogger.git
2. Open in IntelliJ IDEA (or any Java IDE).

3. Compile and run Main.java.


