package eecs1021;

// Imports
import java.io.IOException;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoistureValueTest {

    private Moisture_Task moistureTask;

    @BeforeEach
    public void setUp1() {

        // Mock IODevice and pins
        IODevice mockArduinoBoard = mock(IODevice.class);
        Pin testMoisturePin = mock(Pin.class);
        Pin testPumpPin = mock(Pin.class);

        // Mock moisture values
        when(testMoisturePin.getValue()).thenReturn(Long.valueOf(512)); // Mocks a mid-range value

        // Initializes the Moisture_Task with mocked pins
        moistureTask = new Moisture_Task(testMoisturePin, testPumpPin);
    }

    // Tests for determining if the computeMoistureValue computes the equation properly and compares it to the expected value
    @Test
    public void testComputeMoistureValue() {
        // Mock a moisture value of 512, which should result in 2.50 (approximately)
        String expected = "2.50";
        String actual = Moisture_Task.computeMoistureValue();
        assertEquals(expected, actual);
    }

    // Tests for determining if the moisture value is within the Max and Min bounds
    @Test
    public void testComputeMoistureValueMaxandMin ()
            throws IOException, InterruptedException
    {
        String UsbPort = "COM4";
        IODevice myArduinoBoard = new FirmataDevice(UsbPort);
        myArduinoBoard.start();
        myArduinoBoard.ensureInitializationIsDone();

        Pin moistureSensorPin = myArduinoBoard.getPin(15);
        moistureSensorPin.setMode(Pin.Mode.ANALOG);
        int moistureValue = (int) moistureSensorPin.getValue();

        assertTrue(moistureValue < 1023); // Tests if the value does not exceed 1023 which is 5 Volts
        assertTrue(moistureValue > 0); // Tests if the value does not exceed 0 which is 0 Volts
    }
}
