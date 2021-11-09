import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws IOException {
        CSVWorking readCSV = new CSVWorking();
        ArrayList<Student> students;

        students = readCSV.readCSV("src/test/data.csv");
        for (Student s: students){
            System.out.println(s.toString());
        }


        //2. danh sach 10 sinh vien co diem LT cao nhat
        System.out.println("\nDanh sách 10 sinh vien có điểm thi lí thuyết cao nhất:============================");
        Function function = new Function();
        function.top10Desc(students);


        //3. Tính điểm tổng kết cho từng sinh viên, làm tròn đến 0.5
        System.out.println("\nĐiểm tổng kết cho từng sinh viên:============================");
        function.calAVGForStudents(students);
        for (int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).toStringWithAvg());;
        }


        //4. Liệt kê danh sách 10 sinh viên có điểm tổng kết thấp nhất
        System.out.println("\n10 Sinh viên có diểm tổng kết thấp nhất:============================");
        function.top10Asc(students);


        //5.Ghi điểm tổng kết vào cột cuối trong file output.csv
        System.out.println("\nGhi file output.csv:============================");
        CSVWorking writeCSV = new CSVWorking();
        writeCSV.writeCSV(students, "src/test/output.csv");

    }
}
