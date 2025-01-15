public class Filter {
    public void kurangDari(){
        Etalase etalase = new Etalase();
        etalase.gantiList("select * from product where price < 1000000");
    }
    public void Antara(){
        Etalase etalase = new Etalase();
        etalase.gantiList("select * from product where price < 5000000 and price > 1000001");
    }
    public void lebihDari(){
        Etalase etalase = new Etalase();
        etalase.gantiList("select * from product where price > 5000000");
    }
}
