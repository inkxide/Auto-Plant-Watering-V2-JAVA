package eecs1021;

// Imports
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import org.firmata4j.IODeviceEventListener;

public class Button_Task implements IODeviceEventListener {
    private Pin buttonPin;

    public Button_Task (Pin buttonPin){
        this.buttonPin = buttonPin;
    }
    @Override
    public void onPinChange(IOEvent exit) {

        // When button is pressed it terminates the program
        if (buttonPin.getValue() == 1){
            System.out.println("Program Exited!");
            System.exit(0);
        }

    }
    @Override
    public void onStart(IOEvent exit) {}
    @Override
    public void onStop(IOEvent exit) {}
    @Override
    public void onMessageReceive(IOEvent exit, String message) {}
}
