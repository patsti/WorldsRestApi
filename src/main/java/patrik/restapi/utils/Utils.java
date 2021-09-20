package patrik.restapi.utils;


import java.io.*;
import java.util.Base64;

public abstract class Utils {

    /**
     * Read the object from Base64 string.
     */
    public static Object deserialize(String s) throws IOException,
            ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

    /**
     * Write the object to a Base64 string.
     */
    public static String serialize(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    public static String getHelpText() {
        String helptext = "";
        helptext += "Use the following paths for some alternative: \n";
        helptext += "Generate a game instance: localhost:8080/api/init-game \n";
        helptext += "Get all Cities from DB: localhost:8080/api/city \n";
        helptext += "Get all Countries from DB: localhost:8080/api/countries \n";
        helptext += "Get all CountryLanguages from DB: localhost:8080/api/countrylanguages \n";
        helptext += "..?countrycode=XXX can be used to apply filters";

        return helptext;
    }

}
