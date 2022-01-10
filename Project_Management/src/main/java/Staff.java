import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Staff {
    public  static final String email_pattern = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private String id, fullName, email, gender;
    private Date dateOfBirth;
    private int chooseGender;
    private static int count = 0;
    protected static final double salary = 6000000;
    private double factor = 0.0;
    private ProjectManagement projects;
    private Department department;
    public static final Scanner scanner = new Scanner(System.in);

    {
        this.id = String.format("%03d", ++count);
        dateOfBirth = new Date();
        projects = new ProjectManagement();
        department = new Department();
    }

    public Staff(Staff p) {
        this.fullName = p.fullName;
        this.dateOfBirth = p.dateOfBirth;
        this.email = p.email;
        this.gender = p.gender;
    }

    public Staff(String name, String mail, String gen, Date date){
        this.fullName = name;
        this.email = mail;
        this.gender = gen;
        this.dateOfBirth = date;
    }

    public Staff(){
        this(null, null,null,null);
    }

    //Nhập 1 nhân viên
    public void inputStaff(){
        boolean checkException;
        this.dateOfBirth = new Date(0);
        System.out.print("Nhap ho ten nhan vien: ");
        this.fullName = scanner.nextLine();
        do {
            System.out.print("Nhap email (vd:abc123@mail.com): ");
            this.email = scanner.nextLine();
            if (!Pattern.compile(email_pattern).matcher(this.email).matches())
                System.out.println("Nhap sai format email! Vui long nhap lai");
        } while (!Pattern.compile(email_pattern).matcher(this.email).matches());
        do {
            try {
                System.out.print("Gioi tinh: 1. Nu\t2. Nam\t3. Khac\nChon gioi tinh: ");
                this.setChooseGender(Integer.parseInt(scanner.nextLine()));
                checkException = true;
                if (this.getChooseGender() < 1 || this.getChooseGender() > 3)
                    System.out.println("Vui long nhap dung huong dan!");
            } catch (NumberFormatException exception) {
                checkException = false;
                System.out.println("Vui long nhap dung huong dan!");
            }
        } while (this.getChooseGender() < 1 || this.getChooseGender() > 3 || !checkException);
        if (this.getChooseGender() == 1) this.gender = "Nu";
        if (this.getChooseGender() == 2) this.gender = "Nam";
        if (this.getChooseGender() == 3) this.gender = "Khac";
        do {
            try {
                System.out.printf("Nhap ngay sinh theo format (%s): ", F.toPattern());
                this.dateOfBirth = F.parse(scanner.nextLine());
            } catch (ParseException ex ) {
                System.out.println("Nhap sai! Nhap lai!");
            }
        } while (this.dateOfBirth.getTime() == 0);
        System.out.print("Nhap phong ban truc thuoc: ");
        this.department.setName(scanner.nextLine());
    }

    //Hiển thị 1 nhân viên
    public void showSingle() {
        System.out.printf("- Ma nhan vien: %s\n- Ho ten: %s\n- Email: %s\n" +
                "- Gioi tinh: %s\n- Ngay sinh: %s\n" +
                "- Phong ban: %s\n", this.id, this.fullName, this.email, this.gender,
                F.format(this.dateOfBirth), this.department.getName());
    }

    //Nhập hệ số lương
    public void inputFactor() {
        do {
            System.out.print("Nhap he so luong cua nhan vien: ");
            this.factor = scanner.nextDouble();
            scanner.nextLine();
            if (this.factor <= 0) System.out.println("Nhap sai! Nhap lai!");
        } while (this.factor <= 0);
    }

    //Tính lương
    public double payroll() {
        return salary * this.factor + getGrant();
    }

    //Tính phụ cấp
    public abstract double getGrant();

    public abstract void inputGrant();

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Staff.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ProjectManagement getProjects() {
        return projects;
    }

    public void setProjects(ProjectManagement projects) {
        projects = projects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getChooseGender() {
        return chooseGender;
    }

    public void setChooseGender(int chooseGender) {
        this.chooseGender = chooseGender;
    }
}
