import java.util.ArrayList;
import java.util.Collections;

public class Function {
    //2. Liệt kê danh sách 10 sinh viên có điểm thi LT cao nhất
    public void top10Desc(ArrayList<Student> students){
        ArrayList<Student> studentsAct = new ArrayList<Student>();
        studentsAct = (ArrayList<Student>) students.clone();
        Collections.sort(studentsAct);

        ArrayList<Student> studentsTop10 = new ArrayList<Student>();
        for (int i = studentsAct.size()-1; i > studentsAct.size() - 11; i--){
            studentsTop10.add(studentsAct.get(i));
        }

        for (Student s:studentsTop10){
            System.out.println(s.toString());
        }

    }


    //3. Tính điểm tổng kết cho từng sinh viên, làm tròn đến 0.5
    public float calAVG(Student student){
        float avg = (float) (0.1 * student.getBonus()
                        + 0.3 * student.getReport()
                        + 0.15 * student.getApp()
                        + 0.45 * student.getLT());

        float avgSquare = (Math.round(avg*2));

        return avgSquare/2;
    }

    public void calAVGForStudents(ArrayList<Student> students){
        float avg;
        for (int i = 0; i < students.size();  i++){
            avg = calAVG(students.get(i));
            students.get(i).setAVG(avg);
        }
    }


    //4. Liệt kê danh sách 10 sinh viên có điểm tổng kết thấp nhất
    public void top10Asc(ArrayList<Student> students){
        ArrayList<Student> studentsAct = new ArrayList<Student>();
        studentsAct = (ArrayList<Student>) students.clone();
        calAVGForStudents(studentsAct);

        for (int i = 0; i < studentsAct.size()-1; i++){
            for (int j = i; j < studentsAct.size(); j++){
                if (studentsAct.get(i).getAVG() > studentsAct.get(j).getAVG()){
                    Collections.swap(studentsAct,i,j);
                }
            }
        }

        for (int i = 0; i < 10; i++){
            System.out.println(studentsAct.get(i).toStringWithAvg());
        }
    }
}
