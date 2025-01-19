public class Filter {
    public void kurangDari(Etalase eta){
        eta.gantiList("select * from product where price < 1000000");
    }
    public void Antara(Etalase eta){
        eta.gantiList("select * from product where price < 5000000 and price > 1000001");
    }
    public void lebihDari(Etalase eta){
        eta.gantiList("select * from product where price > 5000000");
    }
}
