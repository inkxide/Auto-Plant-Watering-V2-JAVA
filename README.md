# inkxide-Auto-Plant-Watering-V2-JAVA

Introduction:

The context of my main project is to create an Auto Plant Watering program in Java on Intellij IDEA using the JSSC, Firmata4j, Slf4j, Princeton libraries. I utilized Arduino Grove Board to monitor and maintain soil moisture along while graphing the moisture value versus time on a live graph using the Princeton StdLib graphing library.

Context:

This project was to create a program in Intellij IDEA in Java that allows long-term monitoring of the plant soil to ensure that the plant receives water as it needs it and to measure the soil moisture using a soil moisture sensor attached to the Arduino Grove board. Automated watering system is important, as it ensures that the plant is water periodically whenever the soil is sensed to be dry and to halt when sensed the soil is wet. This ensures that a healthy plant is grown, without the need for regularly checking if the plant is watered or not.
Technical Requirements/Specifications:







Components List:

•	Arduino Grove Board     
•	MOSFET
•	Moisture Sensor
•	Battery
•	Pump
•	Water Outlet
•	Container for spills
•	Pot for Plant

Procedure:

Process: An Arduino Grove Board was connected to a MOSFET and Moisture sensor, and a program on IntelliJ IDEA in Java was written, where when the moisture sensor senses the soil is dry, the MOSFET sensor turns the water pump on to deliver water to the soil, turns off the water pump when moisture sensor senses that the soil is wet and waits until the soil is dry again to start the process over again. Results [CLO5]: The Automated Plant Watering system with the code ran the program, pumped water into the soil when dry, and stopped pumping water when wet.
 Test:













I tested that the system worked by creating unit testing class, which checked whether the computeMoistureValue() method computed the moisture value correctly by comparing it with equalassert(), to see if the expected value matches up with the actual value, as well as, I tested if the moisture value properly converted to volts from analog value by testing it from min bound to max bound 0 to 1023, to see if the value exceeded and remained within those bounds.
Learning Outcomes:

[CLO 1]: In the 1st learning outcome, I addresses as I integrated a Unit testing class in my program, which tests the if the moisture value is computed correctly and doesn’t exceed the 0 to 1023 bounds when being computer from analog value to moisture value in volts. This also indicates if the moisture value is sensed correctly.
[CLO 2]: In the 2nd learning outcome, my project addresses as I used Princeton StdLib and firmata4j as they are appropriate for this project because StdLib allowed me to draw a live graph of my moisture value plotted against time with ease. Firmata4j is the best library for writing code on Java and making use of Arduino grove board to create Arduino-Java programs. I used 3 different classes: Main.java, Moisture_Task.java, Button_task.java and MositureValueTest.java (for unit testing). 
[CLO 3]: In the 3rd  learning outcome, my project addresses it as my sensor data to be stored in an HashMap prior to graphing by initializing the HashMap to store moisture data which then inside a while loop I wrote “moistureData.put(point, moistureValue, “*”)”, this plotted the asterisk on the live graph based on the condtional of point is greater than 1, then moisturedata,get(point-1) stored in previousValue which inside a nested if statement does not equal null and then so on it draws the lines based on the set of given instruction following the position of the asterisk point plotted on the graph.
[CLO 4]: In the 4th learning outcome, my project addresses it as I utilized 2 different state machine one in main class inside the while loop, and the other in Moisture_Task class. Based on moisture value being greater than or equal to 3.4 turned the water pump on and displayed moisture value on OLED and if moisture value being less than or equal to 3.3 turned the water pump off and displayed the moisture value on OLED.
[CLO 5]: In the 5th learning outcome, my project addresses it as I used multiple classes, and used @Override, then public void run(){}, which is polymorphism and I used private variable which is data hiding.


Conclusion:
¬¬
The conclusion includes that the moisture sensor senses that the soil is wet and turns the pump off, but since the soil was already wet the pump was off, so to simulate a dry condition, the moisture sensor was pulled out of the soil manually, and to simulate a wet condition I covered the moisture sensor in a wet paper towel. The water pump turned on following the state machine algorithm in Java and turned off when the moisture sensor was put back into the wet paper towel. In conclusion, dry soil value on the graph ranged from an average value of greater than or equal to 3.4 volts and the wet soil ranged less than or equal to 3.3 volts. 












