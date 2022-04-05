package edu.escuelaing.arem;

/**
 * Hello world!
 *
 */
import com.google.gson.Gson;

import static spark.Spark.*;
public class Servicio
{
    private static Gson gson = new Gson();
    public static void main( String[] args )
    {
        secure("keystrokes/keystore.p12", "123456", null, null);
        port(getPort());
        get("/sumardos/:uno/:dos", (req, res) -> sumar(req.params(":uno"), req.params(":dos")));
    }

    public static String sumar(String uno, String dos){

        return gson.toJson(Integer.parseInt(uno)+Integer.parseInt(dos));

    }


    public static int getPort(){
        if(System.getenv("PORT")!= null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}
