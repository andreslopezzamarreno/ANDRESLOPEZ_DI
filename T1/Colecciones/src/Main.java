import model.Coche;

public class Main {
    public static void main(String[] args) {

        Coche coche1 = new Coche("audi","tt",1234);
        Coche coche2 = new Coche("ford","focus",1235);
        Coche coche3 = new Coche("ford","fiesta");

        coche1.acelerar(10);
        coche1.acelerar(50);


        coche2.acelerar(20);

        System.out.println(coche1.getVelocidad());

        coche1.frenar();
        coche2.frenar();
        coche3.frenar();
    }
}
