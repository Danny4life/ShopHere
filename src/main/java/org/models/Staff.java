package org.models;

import org.storeEnum.Gender;
import org.storeEnum.Position;

public abstract class Staff {

    private String name;
    private String phoneNumber;
    private static Position position;
    private String emailAddress;
    final Gender gender;

    public Staff(String name, String phoneNumber, Position position, String emailAddress, Gender gender) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public static Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position=" + position +
                ", emailAddress='" + emailAddress + '\'' +
                ", gender=" + gender +
                '}';
    }
}



