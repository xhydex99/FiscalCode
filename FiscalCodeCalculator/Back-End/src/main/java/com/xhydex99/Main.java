package com.xhydex99;
import com.xhydex99.controller.InputReader;
import com.xhydex99.entity.User;
import com.xhydex99.entity.FiscalCode;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.json.JavalinJackson;

//Controllare gli stati esteri nel json comune
//Codice Fiscale Straniero Comune ***** Provincia (EE)
public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(cfg ->{
            cfg.jsonMapper(new JavalinJackson());
        });

        app.post("/calculate", ctx -> {
            String fiscalCode = null;
            try {
                User user = ctx.bodyAsClass(User.class);
                user.checkUser();
                fiscalCode = FiscalCode.createFiscalCode(user);
            } catch (Exception e) {
                ctx.status(HttpStatus.BAD_REQUEST).result(e.getMessage());

            }
            ctx.status(HttpStatus.ACCEPTED).result(fiscalCode);
        });
        app.start(7000);
    }
}

