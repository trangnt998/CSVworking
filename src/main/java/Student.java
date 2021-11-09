public class Student implements Comparable<Student>{
    private String ID;
    private String Name;
    private String Email;
    private float Bonus;
    private float Report;
    private float App;
    private float LT;
    private float AVG;

    public Student() {
    }

    public Student(String ID, String name, String email, float bonus, float report, float app, float LT) {
        this.ID = ID;
        this.Name = name;
        this.Email = email;
        this.Bonus = bonus;
        this.Report = report;
        this.App = app;
        this.LT = LT;
    }

    public Student(String ID, String name, String email, float bonus, float report, float app, float LT, float AVG) {
        this.ID = ID;
        this.Name = name;
        this.Email = email;
        this.Bonus = bonus;
        this.Report = report;
        this.App = app;
        this.LT = LT;
        this.AVG = AVG;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public float getBonus() {
        return Bonus;
    }

    public float getReport() {
        return Report;
    }

    public float getApp() {
        return App;
    }

    public float getLT() {
        return LT;
    }

    public float getAVG() {
        return AVG;
    }

    public void setAVG(float AVG) {
        this.AVG = AVG;
    }

    public String toString() {
        return "ID: " + ID
                + "\tName: " + Name
                + "\tEmail: " + Email
                + "\tBonus: " + Bonus
                + "\tReport: " + Report
                + "\tApp: " + App
                + "\tLT: " + LT;
    }

    public String toStringWithAvg() {
        return "ID: " + ID
                + "\tName: " + Name
                + "\tEmail: " + Email
                + "\tBonus: " + Bonus
                + "\tReport: " + Report
                + "\tApp: " + App
                + "\tLT: " + LT
                + "\tAVG: " + AVG;
    }

    public int compareTo(Student student){ //Sort theo diem LT
        if (this.getLT()-student.getLT() > 0){
            return 1;
        }
        else {
            return -1;
        }
    }


}
