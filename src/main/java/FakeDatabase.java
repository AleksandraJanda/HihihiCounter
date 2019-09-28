import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FakeDatabase {
    static List<String> listOfDayLaughCounts = new ArrayList<>();
    static List<String> listOfSingleLaughs = new ArrayList<>();

    static String allDays = "AllDays";
    static String allLaughs = "AllLaughs";

    static void readData(List<String> list, File file) throws FileNotFoundException {
        Scanner read = new Scanner(file);
        while(read.hasNext()){
            list.add(read.nextLine());
        }
    }

    static void saveData(List<String> data, String name) throws IOException {
        FileWriter writer = new FileWriter(new File(name + ".txt"));
        for (String x : data) {
            writer.write(x);
            writer.write("\r\n");
        }
        writer.close();
    }

    static int readCurrentDayCount() {
        if(isLastCurrentDay()){
            String[] array = getLastDay().split(" ");
            return Integer.parseInt(array[1]);
        } else {
            return 0;
        }
    }

    static boolean isLastCurrentDay() {
        LocalDate current = LocalDate.now();
        return getLastDay().startsWith(current.toString());
    }

    private static String getLastDay() {
        String last = "";
        if(listOfDayLaughCounts.size()>0) {
            last = listOfDayLaughCounts.get(listOfDayLaughCounts.size()-1);
        }
        return last;
    }

}
