package Tests;

public class Test3 {
    public static int sum( Integer b, final int c, Car cc) {
        
        
        cc.setMarque("fiat");
        return b + c ;
    }

    public static void main(String[] args) {

       Integer b1 = 1;
       Integer b2 = 2;
       Car c = new Car("renaud");
       c.setMarque("peugeot");

       System.out.println("car: " + c);


        int result = sum(b1,b2,c);
        Test4 f = new Test4("Tintin");
        
        System.out.println("sum: " + result);
        
        System.out.println("car: " + c);

        System.out.println("film categ: " + f.getCategory());
    }
}