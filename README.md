# Create Dummy File Java Program

This Java program (`CreateDummy.java`) demonstrates how to create a dummy text file of a specified size and retrieve its size information using Java File I/O operations.

## Description

The `CreateDummy.java` program performs the following tasks:
- **Creating a Dummy File**: Generates a text file (`dummy_file.txt`) filled with repeated JSON text data.
- **File Size Retrieval**: Retrieves and prints the size of the created file in both bytes and kilobytes.

## How It Works

1. **Create Dummy File**:
   - The `createDummyFile()` method creates a file named `dummy_file.txt`.
   - It fills the file with a specified JSON string repeatedly until the desired file size (15 MB in this case) is reached.
   - Uses `BufferedWriter` and `FileWriter` for efficient writing of large amounts of text to the file.

2. **Retrieve File Size**:
   - The `getSize(String fileName)` method retrieves the size of the file (`dummy_file.txt`).
   - Uses `java.nio.file.Path`, `Paths`, and `File` classes to get and print the size of the file in both bytes and kilobytes.

## Usage

To run the program:
- Ensure you have Java installed on your system.
- Compile the `CreateDummy.java` file: `javac CreateDummy.java`
- Run the compiled program: `java CreateDummy`

## Output

Upon successful execution, the program will:
- Print messages indicating the successful creation of the file and its size in bytes and kilobytes.

### Example Output:
```
Dummy text file created successfully: dummy_file.txt
File size: 15728640 bytes
File size in KB: 15360.0
```
# Compression Java Program

This Java program (`Compression.java`) demonstrates file compression and decompression using GZIP.

## Description

The `Compression` class provides methods to:
- Read a file and convert its contents into a string.
- Compress a string using GZIP compression.
- Decompress a byte array using GZIP decompression.
- Optionally, compress a file and save the compressed version to another file.

## Features

- **File Compression**: Uses GZIP compression to compress strings or files.
- **File Decompression**: Decompresses GZIP-compressed data back into its original form.
- **String Handling**: Supports reading from files and handling string data compression.

## Methods

### `readFileToString(String filePath)`

- **Parameters**: `filePath` - Path to the file to be read.
- **Returns**: Contents of the file as a string.
- **Description**: Reads the specified file and returns its contents as a single string.

### `compressString(String inputString)`

- **Parameters**: `inputString` - String to compress.
- **Returns**: Compressed byte array.
- **Throws**: `IOException` - If an I/O error occurs.
- **Description**: Compresses the input string using GZIP compression and returns the compressed data as a byte array.

### `decompressString(byte[] compressedData)`

- **Parameters**: `compressedData` - Compressed byte array to decompress.
- **Returns**: Decompressed string.
- **Throws**: `IOException` - If an I/O error occurs.
- **Description**: Decompresses the input byte array using GZIP decompression and returns the decompressed string.

### `compressFileToFile(String sourceFilePath, String compressedFilePath)`

- **Parameters**:
  - `sourceFilePath` - Path to the source file to compress.
  - `compressedFilePath` - Path to save the compressed file.
- **Throws**: `IOException` - If an I/O error occurs.
- **Description**: Compresses the specified file using GZIP and saves the compressed version to another file.

## Usage

To use this program:
- Ensure you have Java installed on your system.
- Compile the `Compression.java` file: `javac Compression.java`
- Run the compiled program: `java Compression`



