import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Project {
    private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner SC = new Scanner(System.in);
    private static int count = 0;
    private String id, name;
    private Date startDate , endDate ;
    private double investment;
    private NormalStaff manager;
    private StaffManagement Staffs;

    {
        this.id = String.format("%03d", ++count);
        startDate = new Date();
        endDate = new Date();
        Staffs = new StaffManagement();
    }

    public Project() {
        this.name = null;
        this.startDate = null;
        this.endDate = null;
        this.investment = 0.0;
    }

    public Project(String n, String start, String end, double inv) throws ParseException {
        this.name = n;
        this.startDate = F.parse(start);
        this.endDate = F.parse(end);
        this.investment = inv;
//        this.manager = new NormalStaff(m.getFullName(), m.getEmail(), m.getGender(),
//                m.getDateOfBirth(), m.getFactor());
    }

    public Project (Project x) {
        this.name = x.name;
        this.startDate = x.startDate;
        this.endDate = x.endDate;
        this.investment = x.investment;
    }

    public void importProject() throws ParseException {
        System.out.print("Nhap ten du an: ");
        this.name = SC.nextLine();
        System.out.print("Nhap ngay bat dau: ");
        this.startDate = F.parse(SC.nextLine());
        System.out.print("Nhap ngay ket thuc: ");
        this.endDate = F.parse(SC.nextLine());
        System.out.print("Nhap phi dau tu: ");
        this.investment = SC.nextDouble();
        SC.nextLine();
    }

    public void showSingle() {
        System.out.printf("- Ma du an: %s\n- Ten du an: %s\n- Thoi gian: %s - %s\n" +
                        "- Phi dau tu: %.1f\n\n", this.id, this.name, F.format(this.startDate.getTime()),
                F.format(this.endDate.getTime()), this.investment);
    }

    public int compareTo(Project x) {
        return (this.investment < x.investment) ? -1 : (this.investment > x.investment ? 1 : 0);
    }

    public static int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public double getInvestment() {
        return investment;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }
}
