import java.io.*;
import java.util.ArrayList;

public class CSVWorking {
    private static final String COMMA_DELIMITER = ",";
    private static final String FILE_HEADER = "ID,Name,Email,Bonus,Report,App,LT,AVG";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static ArrayList<Student> readCSV(String path) {
        ArrayList<Student> students = new ArrayList<Student>();
        BufferedReader br = null;

        try {
            String line;
            br = new BufferedReader(new FileReader(path));
            line = br.readLine();

            while ((line = br.readLine()) != null){
                String[] value = line.split(COMMA_DELIMITER);
                String ID = value[0];
                String Name = value[1];
                String Email = value[2];
                float Bonus = Float.parseFloat(value[3]);
                float Report = Float.parseFloat(value[4]);
                float App = Float.parseFloat(value[5]);
                float LT = Float.parseFloat(value[6]);

                students.add(new Student(ID,Name,Email,Bonus,Report,App,LT));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }


    //Ghi điểm tổng kết vào cột cuối trong file output.csv
    public static void writeCSV(ArrayList<Student> students, String path) throws IOException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(path);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Student s: students){
                fileWriter.append(s.getID());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(s.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(s.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Float.toString(s.getBonus()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Float.toString(s.getReport()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Float.toString(s.getApp()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Float.toString(s.getLT()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Float.toString(s.getAVG()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fileWriter.flush();
            fileWriter.close();
        }
    }
}
