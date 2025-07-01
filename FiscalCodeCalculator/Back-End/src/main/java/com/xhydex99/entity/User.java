package com.xhydex99.entity;

import com.xhydex99.excpetion.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class User {
    //eliminato attributo fiscalCode
    private String name, surname, city, gender, provincia, birthdate;
    private LocalDate birthdateDate;

    public User() {
    }

    public void checkUser() throws InvalidNameException,InvalidSurnameException,InvalidCityException, InvalidGenderException, InvalidProvinciaException, InvalidBirthdateException {
        this.name = checkName(name);
        this.surname = checkSurname(surname);
        this.city = checkCity(city);
        this.gender = checkGender(gender);
        this.birthdateDate = checkBirthdate(birthdate);
        this.provincia = checkProvincia(provincia);

    }

    private String checkName(String name) throws InvalidNameException {
        if (name.length() < 2) {
            throw new InvalidNameException("0x01");
        }
        return name;
    }

    private String checkSurname(String surname) throws InvalidSurnameException {
        if (name.length() < 2) {
            throw new InvalidSurnameException("0x02");
        }
        return surname;
    }

    private String checkCity(String city) throws InvalidSurnameException {
        String retvalue = "";
        if (JsonToMap.cityArray("nome").indexOf(city.toUpperCase()) < 0) {
            throw new InvalidCityException("0x03");
        }
        for (int i = 0; i < city.length(); i++) {
            if (i == 0) {
                retvalue = String.valueOf(city.charAt(i));
            } else {
                retvalue = retvalue + String.valueOf(city.charAt(i));
            }
        }
        return retvalue;
    }

    private String checkProvincia(String provincia) throws InvalidProvinciaException {
        String retvalue = provincia.toUpperCase();
        if (JsonToMap.cityArray("sigla").indexOf(retvalue) < 0) {
            throw new InvalidProvinciaException("0x04");
        }
        return retvalue;
    }

    private String checkGender(String gender) throws InvalidGenderException {
        String retvalue = "";
        for (int i = 0; i < gender.length(); i++) {
            if(i == 0){
                retvalue = String.valueOf(gender.charAt(i)).toUpperCase();
            } else {
                retvalue = retvalue + String.valueOf(gender.charAt(i));
            }
        }

        switch (retvalue) {
            case "Man": {
                return retvalue;
            }
            case "Woman": {
                return retvalue;
            }
            default: {
                throw new InvalidGenderException("0x05");
            }
        }
    }
    public LocalDate checkBirthdate(String birthdate){
        LocalDate retvalue = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato della stringa

        try {
            retvalue = LocalDate.parse(birthdate, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidBirthdateException("0x06");
        } catch (Exception e) {
            System.err.println("Errore durante la conversione: " + e.getClass()); // Gestione degli errori
        }
        return retvalue;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }

    public String getProvincia() {
        return provincia;
    }

    public LocalDate getBirthdate() {
        return birthdateDate;
    }
    //inserire i controlli e la correzione di tutti gli input dell'utente
}
