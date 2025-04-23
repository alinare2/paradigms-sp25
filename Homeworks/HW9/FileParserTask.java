import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileParserTask implements Runnable {
    private final String filePath;
    private Map<String, Integer> namesCount;
    private Map<String, Integer> occupationsCount;

    public FileParserTask(File file, Map<String, Integer> namesCount, Map<String, Integer> occupationsCount) {
        this.filePath = file.getAbsolutePath();
        this.namesCount = namesCount;
        this.occupationsCount = occupationsCount;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String firstName = parts[3].trim();
                String profession = parts[1].trim();

                synchronized (FileParserMain.nameLock) {
                    namesCount.put(firstName,namesCount.getOrDefault(firstName, 0) + 1);
                }

                synchronized (FileParserMain.occupationLock) {
                    occupationsCount.put(profession, occupationsCount.getOrDefault(profession, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        }
    }
}
