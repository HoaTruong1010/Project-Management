import java.text.ParseException;
import java.util.Date;

public class NormalStaff extends Staff {
    public NormalStaff() {
        super();
    }

    public NormalStaff(String name, String mail, String gen, Date date) {
        super(name, mail, gen, date);
    }

    public NormalStaff(NormalStaff p) {
        super(p);
    }

    @Override
    public void inputGrant() { }

    @Override
    public double getGrant() {
        return 0;
    }
}
