import java.util.GregorianCalendar;

public class NormalStaff extends Staff {

    public NormalStaff(String name, String mail, String gen, GregorianCalendar date, double f) {
        super(name, mail, gen, date, f);
    }

    @Override
    public double getGrant() {
        return 0;
    }
}
