package com.xhydex99;
import com.xhydex99.controller.InputReader;
import com.xhydex99.entity.User;
import com.xhydex99.entity.FiscalCode;


//Controllare gli stati esteri nel json comune
//Codice Fiscale Straniero Comune ***** Provincia (EE)
public class Main {
    public static void main(String[] args) {
        boolean retvalue;
        String fiscal = null;
        do {
            InputReader reader = new InputReader();
            String name = reader.insertName();
            String surname = reader.insertSurame();
            String city = reader.insertCity();
            String gender = reader.insertGender();
            String bd = reader.insertBirtdate();
            String provincia = reader.insertProvincia();
            try {
                User utente = new User(name, surname, city, gender, bd, provincia);
                fiscal = FiscalCode.createFiscalCode(utente);
                retvalue = false;
            } catch (Exception e){
                //pensare a cosa modificare per poter mostrare tutti gli errori
                retvalue = true;
                switch(e.getMessage()){
                    case "0x01" :{
                        System.out.println("Invalid name please reinsert it");
                    }continue;
                    case "0x02" :{
                        System.out.println("Invalid surname please reinsert it");
                    }continue;
                    case "0x03" :{
                        System.out.println("Invalid city please reinsert it");
                    }continue;
                    case "0x04" :{
                        System.out.println("Invalid provincia please reinsert it");
                    }continue;
                    case "0x05" :{
                        System.out.println("Invalid gender please reinsert it");
                    }continue;
                    case "0x06" :{
                        System.out.println("Invalid birthdate please reinsert it");
                    }continue;
                    default:{
                        System.out.println("There is unexpected error: " + e.getClass());
                    }
                }
            }
        } while(retvalue);
        System.out.println(fiscal);
    }
}