package com.xhydex99;

import com.xhydex99.controller.InputReader;
import com.xhydex99.entity.User;
import com.xhydex99.entity.FiscalCode;
import com.xhydex99.excpetion.InvalidBirthdateException;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.json.JavalinJackson;

//Controllare gli stati esteri nel json comune
//Codice Fiscale Straniero Comune ***** Provincia (EE)
public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(cfg -> {
            cfg.jsonMapper(new JavalinJackson());
        });

        app.post("/calculate", ctx -> {
            User user = ctx.bodyAsClass(User.class);
            user.checkUser();
            System.out.println(FiscalCode.createFiscalCode(user));
            String fiscalCode = FiscalCode.createFiscalCode(user);
            ctx.status(HttpStatus.ACCEPTED).result(fiscalCode);
        });

        app.exception(Exception.class, (exception, ctx) -> {
            ctx.status(409).result(exception.getMessage());
        });
        app.start(7000);
    }


}

