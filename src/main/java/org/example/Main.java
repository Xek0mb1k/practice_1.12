package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Akopyan Oganes RIBO-03-22 Variant 1");
            String directoryPath = ScanClass.getString("Input file name or file directory: ");

            String make = ScanClass.getString("Input mark your car: ");
            String model = ScanClass.getString("Input car model: ");
            int year = ScanClass.getInt("Input distribution year: ");
            int mileage = ScanClass.getInt("Input millage of your car: ");
            String review = ScanClass.getString("Tell me more information of car: ");

            Car car = new Car(make, model, year, mileage, review);

            FileOutputStream fileOut = new FileOutputStream(directoryPath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);


            Thread thFrExtern = new ThreadFrExtern(car, objectOut, fileOut);
            thFrExtern.start();



            System.out.println("File saved in directory: " + directoryPath);


        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}