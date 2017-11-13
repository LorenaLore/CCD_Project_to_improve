public class Main {
    static Magazin magazin;

    public static void main(String[] args) {
        magazin = new Magazin();
        magazin.produse = magazin.loadProducts("produse.txt");
        //nr total de produse
        System.out.println("In magazin sunt " + magazin.produse.size() + " produse");
        //lista de bauturi alcoolice
        System.out.println("++++++++++Bauturi alcoolice: \n" + magazin.getAlcoholDrinkings());
        //TODO:lista de bauturi non-alcoolice
        System.out.println("++++++++++Bauturi non-alcoolice: \n");
        //TODO: lista de alimente
        //System.out.println("++++++++++Alimente: \n");
        //TODO: lista de haine pentru adulti
        //System.out.println("++++++++++Articole de vestimentatie adulti: \n");
        //TODO: lista de haine de copii
        //System.out.println("++++++++++Articole de vestimentatie copii: \n");
        //TODO: lista de telefoane
        //System.out.println("++++++++++Telefoane: \n");
        //TODO: lista de tablete
        //System.out.println("++++++++++Tablete: \n");
        //TODO: lista de televizoare
        //System.out.println("++++++++++Televizoare: \n");
    }

}
