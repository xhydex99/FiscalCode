import entity.FiscalCode;
import entity.User;
import controller.InputReader;

//Dopo aver sistemato tutte le classi ed aver completato quasi totalmente il progetto inserire metodo che calcola
//tutti i codici fiscali possibili in modo da riconoscere ogni possibile codice fiscale esistente

//Controllare mail luca tassano e dirlo a gio a meno che non siano "ok"

public class Main {
    public static void main(String[] args) {
            boolean retvalue = false;
            String fiscal = null;
        do {
            InputReader.insertName(InputReader.)

            String surname = "Vitale";
            String city = "Palermo";
            String gender = "Man";
            String bd = "07/02/2000";
            String provincia = "PA";
            try {
                User utente = new User(name, surname, city, gender, bd, provincia);
                fiscal = FiscalCode.createFiscalCode(utente);
                retvalue = false;
            } catch (Exception e){
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