package Utils;

import java.io.*;

public class SolutionWriter {

    public static void writeLog(String log){
        try {
            FileOutputStream file = new FileOutputStream("log.txt", true);
            file.write((log + "\n").getBytes());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
