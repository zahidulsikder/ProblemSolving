import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Read_from_file_duplicates_make_new_file {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\OS\\Desktop\\New folder\\files\\alltext.txt"; // Path to your input file
        String outputFilePath = "C:\\Users\\OS\\Desktop\\New folder\\files\\uniqueElements.txt"; // Path to your output file

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            Set<String> aliasSet = new TreeSet<>();

            // Read lines from input file and populate the set
            while ((line = reader.readLine()) != null) {
                Arrays.stream(line.split("\\|"))
                        .forEach(aliasSet::add);
            }

            // Write unique elements to the output file
            for (String element : aliasSet) {
                if (element!=null){
                    writer.write(element);
                    writer.newLine(); // Add a newline after each element
                }
            }

            System.out.println("Unique elements written to: " + outputFilePath);
            System.out.println("Total: " + aliasSet.size());

        } catch (IOException e) {
            e.printStackTrace(); // Handle any I/O exceptions
        }
    }
}
