import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Magazin {
    List<Produs> produse;


    public Magazin() {}

    ;

    public Magazin(List<Produs> produse) {
        this.produse = produse;
    }

    public List<Produs> loadProducts(String url) {
        ArrayList<Produs> produse = new ArrayList<Produs>();
        try {
            FileReader fr = new FileReader(url);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                produse.add(process(s));
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Fisierul nu a fost gasit!" + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Eroare la citirea din fisier!" + exception.getMessage());
        }
        return produse;
    }

    public Produs process(String line) {
        String[] data = line.split(";");
        Produs resultedProduct = new Produs();
        resultedProduct.id = data[0].equals("null") ? 0 : Integer.parseInt(data[0]);
        resultedProduct.name = data[1].equals("null") ? null : data[1];
        resultedProduct.price = data[2].equals("null") ? 0 : Float.parseFloat(data[2]);
        resultedProduct.description = data[3].equals("null") ? null : data[3];
        resultedProduct.size = data[4].equals("null") ? null : data[4];
        resultedProduct.ageRange = data[5].equals("null") ? null : data[5];
        resultedProduct.gender = data[6].equals("null") ? 0 : data[6].charAt(0);
        resultedProduct.grams = data[7].equals("null") ? 0 : Integer.parseInt(data[7]);
        resultedProduct.liters = data[8].equals("null") ? 0 : Float.parseFloat(data[8]);
        resultedProduct.calories = data[9].equals("null") ? 0 : Integer.parseInt(data[9]);
        resultedProduct.discount = data[10].equals("null") ? 0 : Integer.parseInt(data[10]);
        resultedProduct.currency = data[11].equals("null") ? null : data[11];
        resultedProduct.screenSize = data[12].equals("null") ? 0 : Float.parseFloat(data[12]);
        resultedProduct.weight = data[13].equals("null") ? 0 : Integer.parseInt(data[13]);
        resultedProduct.brand = data[14].equals("null") ? null : data[14];
        resultedProduct.operatingSystem = data[15].equals("null") ? null : data[15];
        resultedProduct.culoare = data[16].equals("null") ? null : data[16];
        resultedProduct.resolution = data[17].equals("null") ? null : data[17];
        resultedProduct.tipTv = data[18].equals("null") ? null : data[18];
        if (data[19].equals("null")) {
            resultedProduct.expirationDate = null;
        } else {
            try {
                DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
                resultedProduct.expirationDate = formatter.parse(data[19]);
            } catch (ParseException parseException) {
                System.out.println("eroare la formatarea datei de expirare a produsului" + parseException);
            }
        }
        resultedProduct.networkConnection = data[20].equals("null") ? null : data[20];
        resultedProduct.alcool = data[21].equals("null") ? 0 : Integer.parseInt(data[21]);
        resultedProduct.gluten = data[22].equals("null") ? false : Boolean.parseBoolean(data[22]);

        return resultedProduct;
    }

    public String getAlcoholDrinkings() {
        String products = "";
        for (Produs produs : produse) {
            if (produs.alcool != 0) {
                products += produs.name + " - " + produs.description + "\n" + "Detalii: " + "\n"
                        + "id: " + produs.id + "\n"
                        + "pret: " + produs.price + produs.currency + "\n"
                        + "cantitate: " + produs.liters + "l\n"
                        + "calorii: " + produs.calories + "\n"
                        + "producator: " + produs.brand + "\n"
                        + "alcool: " + produs.alcool + "%\n";
            }
        }
        return products;
    }
}
