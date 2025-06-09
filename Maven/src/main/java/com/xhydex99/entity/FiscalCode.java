package com.xhydex99.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.*;

public class FiscalCode {

    public static String createFiscalCode(User user) {
        String retvalue = "";
        ArrayList<String> retvalueArray = new ArrayList<>();
        String surname = FiscalCode.surnameCode(user.getSurname());
        String name = FiscalCode.nameCode(user.getName());
        String birthday = FiscalCode.bdCode(user.getBirthdate(), user.getGender());
        String birthPlace = FiscalCode.cityCode(user.getCity(), user.getProvincia());
        retvalue = surname + name + birthday + birthPlace;
        for (int i = 0; i < retvalue.length(); i++) {
            retvalueArray.add(String.valueOf(retvalue.charAt(i)));
        }
        String checkCode = FiscalCode.controlCode(retvalueArray);
        retvalue = retvalue + checkCode;
        retvalueArray.add(checkCode);
        return retvalue;
    }

    private static String surnameCode(String surname) {
        String retvalue = "";
        String cons = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        String vocal = "aeiouAEIOU";
        ArrayList<String> surnameChar = new ArrayList<>();
        for (int i = 0; i < surname.length(); i++) {
            surnameChar.add(String.valueOf(surname.toUpperCase().charAt(i)));
        }
        ArrayList<String> consSurnContainer = new ArrayList<>();
        ArrayList<String> vocalSurnContainer = new ArrayList<>();

        for (int i = 0; i < surnameChar.size(); i++) {
            if (cons.contains(surnameChar.get(i))) {
                consSurnContainer.add(surnameChar.get(i));
            }
            if (vocal.contains(surnameChar.get(i))) {
                vocalSurnContainer.add(surnameChar.get(i));
            }
        }

        switch (consSurnContainer.size()) {
            case 0: {
                switch (vocalSurnContainer.size()) {
                    case 1: {
                        retvalue = vocalSurnContainer.get(0) + "XX";
                    }
                    break;
                    case 2: {
                        retvalue = vocalSurnContainer.get(0) + vocalSurnContainer.get(1) + "X";
                    }
                    break;
                    default: {
                        retvalue = vocalSurnContainer.get(0) + vocalSurnContainer.get(1) + vocalSurnContainer.get(2);
                    }
                    break;
                }
            }
            break;
            case 1: {
                retvalue = consSurnContainer.get(0);
                switch (vocalSurnContainer.size()) {
                    case 1: {
                        retvalue = retvalue + vocalSurnContainer.get(0) + "X";
                    }
                    break;
                    default: {
                        retvalue = retvalue + vocalSurnContainer.get(0) + vocalSurnContainer.get(1);
                    }
                    break;
                }
            }
            break;
            case 2: {
                retvalue = consSurnContainer.get(0) + consSurnContainer.get(1);
                switch (vocalSurnContainer.size()) {
                    case 0: {
                        retvalue = retvalue + "X";
                    }
                    break;
                    default: {
                        retvalue = retvalue + vocalSurnContainer.get(0);
                    }
                    break;
                }
            }
            break;
            default: {
                retvalue = consSurnContainer.get(0) + consSurnContainer.get(1) + consSurnContainer.get(2);
            }
            break;
        }
        return retvalue;
    }

    private static String nameCode(String name) {
        String retvalue = "";
        String cons = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        String vocal = "aeiouAEIOU";
        ArrayList<String> nameChar = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            nameChar.add(String.valueOf(name.toUpperCase().charAt(i)));
        }
        ArrayList<String> consNamContainer = new ArrayList<>();
        ArrayList<String> vocalNamContainer = new ArrayList<>();

        for (int i = 0; i < nameChar.size(); i++) {
            if (cons.contains(nameChar.get(i))) {
                consNamContainer.add(nameChar.get(i));
            }
            if (vocal.contains(nameChar.get(i))) {
                vocalNamContainer.add(nameChar.get(i));
            }
        }

        switch (consNamContainer.size()) {
            case 0: {
                switch (vocalNamContainer.size()) {
                    case 1: {
                        retvalue = vocalNamContainer.get(0) + "XX";
                    }
                    break;
                    case 2: {
                        retvalue = vocalNamContainer.get(0) + vocalNamContainer.get(1) + "X";
                    }
                    break;
                    default: {
                        retvalue = vocalNamContainer.get(0) + vocalNamContainer.get(1) + vocalNamContainer.get(2);
                    }
                    break;
                }
            }
            break;
            case 1: {
                retvalue = consNamContainer.get(0);
                switch (vocalNamContainer.size()) {
                    case 1: {
                        retvalue = retvalue + vocalNamContainer.get(0) + "X";
                    }
                    break;
                    default: {
                        retvalue = retvalue + vocalNamContainer.get(0) + vocalNamContainer.get(1);
                    }
                    break;
                }
            }
            break;
            case 2: {
                retvalue = consNamContainer.get(0) + consNamContainer.get(1);
                switch (vocalNamContainer.size()) {
                    case 0: {
                        retvalue = retvalue + "X";
                    }
                    break;
                    default: {
                        retvalue = retvalue + vocalNamContainer.get(0);
                    }
                    break;
                }
            }
            break;
            case 3: {
                retvalue = consNamContainer.get(0) + consNamContainer.get(1) + consNamContainer.get(2);
            }
            break;
            default: {
                retvalue = consNamContainer.get(0) + consNamContainer.get(2) + consNamContainer.get(3);
            }
            break;
        }
        return retvalue;
    }

    private static String bdCode(LocalDate birthdate, String gender) {
        String retvalue = "";
        String year = String.valueOf(birthdate.getYear());
        String month = "";
        String day = "";
        switch (gender) {
            case "Man": {
                if (birthdate.getDayOfMonth() < 10) {
                    day = "0" + String.valueOf(birthdate.getDayOfMonth());
                } else {
                    day = String.valueOf(birthdate.getDayOfMonth());
                }
            }
            break;
            case "Woman": {
                day = String.valueOf(birthdate.getDayOfMonth() + 40);
            }
            break;
        }
        switch (birthdate.getMonth().getValue()) {
            case 1: {
                month = "A";
            }
            break;
            case 2: {
                month = "B";
            }
            break;
            case 3: {
                month = "C";
            }
            break;
            case 4: {
                month = "D";
            }
            break;
            case 5: {
                month = "E";
            }
            break;
            case 6: {
                month = "H";
            }
            break;
            case 7: {
                month = "L";
            }
            break;
            case 8: {
                month = "M";
            }
            break;
            case 9: {
                month = "P";
            }
            break;
            case 10: {
                month = "R";
            }
            break;
            case 11: {
                month = "S";
            }
            break;
            case 12: {
                month = "T";
            }
            break;
        }
        retvalue = year.substring(2) + month + day;

        return retvalue;
    }

    private static String cityCode(String city, String province) {
        String retvalue = "";
        Map<String, String> cityMapped = JsonToMap.cityMap();
        String regex = "^\\([a-zA-Z]{2,2}\\)";
        String birthplace = "";
        if (Pattern.matches(regex, province)) {
            birthplace = city + " " + province.toUpperCase();
        } else {
            birthplace = city + " (" + province.toUpperCase() + ")";
        }
        retvalue = cityMapped.get(birthplace);
        return retvalue;
    }

    private static String controlCode(ArrayList<String> tFiscalCode) {
        String retvalue = "";
        Map<String, String> oddMap = JsonToMap.checkCodeMap("odd.json");
        Map<String, String> peerMap = JsonToMap.checkCodeMap("peer.json");
        Map<String, String> checkMap = JsonToMap.checkCodeMap("checkCode.json");
        int controlValue = 0;
        for (int i = 0; i < tFiscalCode.size(); i++) {
            if (i % 2 == 0) {
                //odd
                controlValue = controlValue + Integer.parseInt(oddMap.get(tFiscalCode.get(i)));
            } else {
                //peer
                controlValue = controlValue + Integer.parseInt(peerMap.get(tFiscalCode.get(i)));
            }
        }
        retvalue = checkMap.get(String.valueOf(controlValue % 26));
        return retvalue;
    }



}
