import java.io.*;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class Compression {

    public static void main(String[] args) {
        // HashMap to store different versions of the string data
        HashMap<String, String> dataMap = new HashMap<>();

        // File path to read
        String filePath = "D:\\Stoxbox Service\\java examples\\random_file.txt";

        // Read the file contents into a string
        String inputString = readFileToString(filePath);
        dataMap.put("inputString", inputString); // Store input string in map

        try {
            // Compress the input string
            byte[] compressedData = compressString(inputString);
            String compressedString = new String(compressedData, "UTF-8"); // Convert compressed byte[] to String
            dataMap.put("compressedString", compressedString); // Store compressed string in map

            // Decompress the compressed data
            String decompressedString = decompressString(compressedData);
            dataMap.put("decompressedString", decompressedString); // Store decompressed string in map

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print sizes of each string version
        System.out.println("Number of entries in dataMap: " + dataMap.size());
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Input String size (KB): " + (dataMap.get("inputString").length() / 1024));
        System.out.println("Compressed String size (KB): " + (dataMap.get("compressedString").length() / 1024));
        System.out.println("Decompressed String size (KB): " + (dataMap.get("decompressedString").length() / 1024));
    }

    /**
     * Reads a file and returns its contents as a string.
     *
     * @param filePath Path to the file to be read
     * @return Contents of the file as a string
     */
    private static String readFileToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    /**
     * Compresses a string using GZIP.
     *
     * @param inputString String to compress
     * @return Compressed byte array
     * @throws IOException If an I/O error occurs
     */
    private static byte[] compressString(String inputString) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
            gzipOutputStream.write(inputString.getBytes("UTF-8"));
        }
        return outputStream.toByteArray();
    }

    /**
     * Decompresses a byte array using GZIP.
     *
     * @param compressedData Compressed byte array
     * @return Decompressed string
     * @throws IOException If an I/O error occurs
     */
    private static String decompressString(byte[] compressedData) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(compressedData);
             GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        }
        return outputStream.toString("UTF-8");
    }

    public static void compressFileToFile(String sourceFilePath, String compressedFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream(compressedFilePath);
             GZIPOutputStream gzipOS = new GZIPOutputStream(fos)) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, len);
            }
        }
    }
}
