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
    private Staff manager;
    private StaffManagement staffs;

    {
        this.id = String.format("%03d", ++count);
        staffs = new StaffManagement();
    }

    public Project(String n, Date start, Date end, double inv){
        this.name = n;
        this.startDate = start;
        this.endDate = end;
        this.investment = inv;
    }

    public Project (Project x) {
        this.name = x.name;
        this.startDate = x.startDate;
        this.endDate = x.endDate;
        this.investment = x.investment;
    }

    public Project() {
        this(null, null, null, 0.0);
    }

    public void inputProject() throws ParseException {
        this.startDate = new Date();
        this.endDate = new Date();

        System.out.print("- Nhap ten du an: ");
        this.name = SC.nextLine();

        do {
            System.out.print("- Nhap ngay bat dau: ");
            this.startDate = F.parse(SC.nextLine());
            System.out.print("- Nhap ngay ket thuc: ");
            this.endDate = F.parse(SC.nextLine()) ;
            if(this.startDate.after(this.endDate))
                System.out.println("Nhap sai! Nhap lai!");
        }
        while (this.startDate.after(this.endDate));

        System.out.print("- Nhap phi dau tu: ");
        this.investment = SC.nextDouble();
        SC.nextLine();
    }

    public void showSingle() {
        System.out.printf("- Ma du an: %s\n- Ten du an: %s\n- Thoi gian: %s - %s\n" +
                        "- Phi dau tu: %.1f\n", this.id, this.name, F.format(this.startDate.getTime()),
                F.format(this.endDate.getTime()), this.investment);
        if (this.manager != null) {
            System.out.println("- Nguoi quan ly du an: ");
            this.manager.showSingle();
        }
        System.out.println();
    }

    public int compareTo(Project x) {
        return (this.investment < x.investment) ? -1 : (this.investment > x.investment ? 1 : 0);
    }

    public void setManager(Staff manager) {
        this.manager = manager;
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

    public static void setCount(int count) {
        Project.count = count;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Staff getManager() {
        return manager;
    }

    public StaffManagement getStaffs() {
        return staffs;
    }

    public void setStaffs(StaffManagement staffs) {
        staffs = staffs;
    }
}
