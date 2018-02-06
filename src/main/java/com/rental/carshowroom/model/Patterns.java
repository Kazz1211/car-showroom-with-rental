package com.rental.carshowroom.model;

public class Patterns {
    public static final String PESEL = "[0-9]{11}";
    public static final String DATE = "yyyy-MM-dd";
    public static final String DATETIME = "yyyy-MM-dd hh:mm:ss";
    public static final String VIN = "^(?<wmi>[A-HJ-NPR-Z\\d]{3})(?<vds>[A-HJ-NPR-Z\\d]{5})(?<check>[\\dX])(?<vis>(?<year>[A-HJ-NPR-Z\\d])(?<plant>[A-HJ-NPR-Z\\d])(?<seq>[A-HJ-NPR-Z\\d]{6}))$";
    public static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+\\.[A-Za-z]{2,6}$";
}
