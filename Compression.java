import java.io.*;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class Compression {

    public static void main(String[] args) {

        HashMap <String,String > mp = new HashMap<>();

        String filePath ="D:\\Stoxbox Service\\java examples\\random_file.txt";
        String inputString = readFileToString(filePath);
        mp.put("inputString", inputString);

        try {
            // Compress the input file data
            byte[] compressedData = compressString(inputString);
            String compressedString = new String(compressedData, "UTF-8"); // Convert byte[] to String
            mp.put("compressedString", compressedString);

            // Display sizes
            // System.out.println("Original size: " + inputString.length());
            // System.out.println("Compressed size: " + compressedString.length());

            // Decompress the compressed data
            String decompressedString = decompressString(compressedData);
            mp.put("decompressedString", decompressedString);
            // System.out.println("Decompressed String: " + decompressedString.length());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(mp.size());
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Input String size : " + (mp.get("inputString").length()/1024));
        System.out.println("Compressed String size : " + (mp.get("compressedString").length()/1024));
        System.out.println("Decompressed String size : " + (mp.get("decompressedString").length()/1024));
    }

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

    private static byte[] compressString(String inputString) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
            gzipOutputStream.write(inputString.getBytes("UTF-8"));
        }
        return outputStream.toByteArray();
    }


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
