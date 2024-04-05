package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ThreadFrExtern extends Thread {
    private final Car car;
    private final ObjectOutputStream objectOut;
    private final FileOutputStream fileOut;

    public ThreadFrExtern(Car car, ObjectOutputStream objectOut, FileOutputStream fileOut) {
        this.car = car;
        this.objectOut = objectOut;
        this.fileOut = fileOut;
    }

    @Override
    public void run() {
        try {
            car.writeExternal(objectOut);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
