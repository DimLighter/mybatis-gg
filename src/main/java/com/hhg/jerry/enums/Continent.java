package com.hhg.jerry.enums;

public enum Continent {
        Asia("Asia"),
        Europe("Europe"),
        NorthAmerica("North America"),
        Africa("Africa"),
        Oceania("Oceania"),
        Antarctica("Antarctica"),
        SouthAmerica("South America");

        public final String value;
        Continent(String value){
            this.value = value;
        }
    }