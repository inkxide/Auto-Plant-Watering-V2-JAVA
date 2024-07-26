package eecs1021;

// Imports
import java.util.TimerTask;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import java.io.IOException;
import java.text.DecimalFormat;

public class Moisture_Task extends TimerTask {

    private static Pin moisturePin;
    private Pin pumpPin;

    static final int SENSOR = 15;
    static final int PUMP = 7;

    // Sets 2 moistureValue to decimal spaces
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Moisture_Task(Pin moisturePin, Pin pumpPin) {
        this.moisturePin = moisturePin;
        this.pumpPin = pumpPin;
    }

    public Moisture_Task(IODevice myArduinoBoard) {
        this.moisturePin = myArduinoBoard.getPin(SENSOR);
        this.pumpPin = myArduinoBoard.getPin(PUMP);
    }

    // Computes Moisture Value
    public static String computeMoistureValue() {

        int VoltValue = (int) moisturePin.getValue();
        double voltageRange = 5.0; // 5V voltage range
        double moistureValue = (VoltValue * voltageRange) / 1023.0;
        return df.format(moistureValue);
    }

    // State Machine Algorithm for determining when to pump water
    @Override
    public void run() {
        try {
            double moistureValue = Double.parseDouble(Moisture_Task.computeMoistureValue());

            if (moistureValue >= 3.4){
                System.out.println("Plant is: Dry");
                pumpPin.setValue(1);
            }
            else if (moistureValue <= 3.3) {
                System.out.println("Plant is: Wet");
                pumpPin.setValue(0);
            }
        }
        catch (IOException ex) {
            System.out.println("Pump is not working!");
        }
    }
}