import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class CreateDummy {

    public static void createDummyFile() {
        String fileName = "dummy_file.txt";
        long fileSizeInBytes = 15 * 1024 * 1024; // 3MB in bytes

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            long bytesWritten = 0;
            String text = "{\"id\":\"1\",\"name\":\"ASTUTESECURITIESANDDEVELOPERSPVTLTD\",\"pincode\":\"\",\"telephone1\":\"\",\"telephone2\":\"\",\"mobileno\":\"\",\"emailid\":\"\",\"country\":\"India\",\"occupation\":\"\",\"introducer\":\"\",\"subBroker\":\"\",\"groups\":\"HO\",\"freezeStatus\":\"A\"}"; // Text to repeat

            while (bytesWritten < fileSizeInBytes) {
                writer.write(text);
                bytesWritten += text.length();
            }

            System.out.println("Dummy text file created successfully: " + fileName);
            System.out.println("File size: " + bytesWritten + " bytes");

        } catch (IOException e) {
            e.printStackTrace();
        }
        getSize(fileName);
    }
    public static void getSize(String fileName){
        java.nio.file.Path filePath = Paths.get(fileName); 
        String currentFilePath = filePath.toAbsolutePath().toString();
        File file = new File(currentFilePath);

        if (file.exists()) {
            long fileSizeInBytes = file.length();
            double fileSizeInKB = (double) fileSizeInBytes / 1024;
            System.out.println("File size in KB: " + fileSizeInKB);

        } else {
            System.out.println("File not found: " + filePath);
        }
    }

    public static void main(String[] args) {
        createDummyFile();
        getSize("dummy_file.txt");
    }
}

