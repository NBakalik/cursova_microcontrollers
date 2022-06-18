package com.example.cursova.util;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class Serial implements SerialPortDataListener {

    private final Logger logger = Logger.getAnonymousLogger();
    private int counter = 0;
    private int charCounter = 0;
    private String command = "";
    private int ldrValue = 0;
    private boolean setSensorState = false;
    private boolean setSystemState = false;
    SerialPort comPort;

    @Autowired
    private Parser parser;

    @PostConstruct
    public void enable() {
        comPort = SerialPort.getCommPorts()[0];
        comPort.setBaudRate(9600);

        comPort.openPort();
        if (!comPort.isOpen()) {
            logger.severe("Unable to open serial port");
            return;
        } else {
            logger.info("Port successfully open");
        }
        comPort.addDataListener(this);
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        byte[] newData = serialPortEvent.getReceivedData();
        int value = Byte.toUnsignedInt(newData[0]);

        if (value == 201) {
            setSensorState = true;
            return;
        }
        if (value == 202) {
            setSystemState = true;
            return;
        }

        if (setSystemState) {
            char convertedChar = (char) value;
            command += convertedChar;
            charCounter++;
            if (charCounter == 2) {
                parser.parseSystemState(command);
                command = "";
                charCounter = 0;
                setSystemState = false;
            }
        } else if (setSensorState) {
            char convertedChar = (char) value;
            command += convertedChar;
            charCounter++;
            if (charCounter == 2) {
                parser.parseSensorState(command);
                command = "";
                charCounter = 0;
                setSensorState = false;
            }
        } else {
            switch (counter) {
                case 0:
                    parser.parseTemperature(value);
                    counter++;
                    break;
                case 1:
                    parser.parseHumidity(value);
                    counter++;
                    break;
                case 2:
                    ldrValue = value * 256;
                    counter++;
                    break;
                case 3:
                    ldrValue += value;
                    parser.parseLight(ldrValue);
                    counter = 0;
            }
        }
    }

    public void updateSystemState(int id) {
        try {
            comPort.getOutputStream().write((byte) id);
            comPort.getOutputStream().flush();
            System.out.println("Sent number:" + id);
        } catch (IOException exception) {
            logger.severe("Cant write comPort");
        }
    }
}