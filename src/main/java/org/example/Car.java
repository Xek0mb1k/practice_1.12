package org.example;

import java.io.*;

public class Car extends Thread implements Externalizable {
    private String mark;
    private String model;
    private int year;
    private int mileage;
    private String additionInf;

    public Car() {
        //Externalize
    }

    @Override
    public void run(){

    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public String getAdditionInf() {
        return additionInf;
    }

    public Car(String mark, String model, int year, int mileage, String additionInf) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.additionInf = additionInf;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeObject(getMark());
        out.writeObject(getModel());
        out.writeInt(getYear());
        out.writeInt(getMileage());
        out.writeObject(getAdditionInf());

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        mark = (String) in.readObject();
        model = (String) in.readObject();
        year = in.readInt();
        mileage = in.readInt();
        additionInf = (String) in.readObject();
    }
}
