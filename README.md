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



