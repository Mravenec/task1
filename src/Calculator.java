import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter input file path: ");
        String inputFile = in.nextLine(); //C:\Users\{YOU SHOULD TYPE YOUR USER}\Desktop\Task1\Task1\src\input-file\Input file.txt
        /*
        *  INPUT FILE
        *  1 + 5
        *  3 / 6
        *  a plus b
        *  21 - 4
        *  6 ; 1
        *  2 * 2
        *  =
        * */
        System.out.print("Enter output file path: ");
        String outputFile = in.nextLine(); //C:\Users\{YOU SHOULD TYPE YOUR USER}\Desktop\Task1\Task1\src\output-file\Output file.txt
        in.close();

        try {
            File input = new File(inputFile);
            File output = new File(outputFile);
            Scanner scanner = new Scanner(input);
            FileWriter writer = new FileWriter(output);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] tokens = line.split(" ");


                if (tokens[0].matches("=")) {
                    break;
                }

                if (tokens.length != 3 || !tokens[0].matches("\\d+") || !tokens[2].matches("\\d+")) {
                    writer.write("Error\n");
                    continue;
                }

                int a = Integer.parseInt(tokens[0]);
                int b = Integer.parseInt(tokens[2]);
                char operator = tokens[1].charAt(0);

                String result = "";

                switch (operator) {
                    case '+':
                        result = Integer.toString(a + b);
                        break;
                    case '-':
                        result = Integer.toString(a - b);
                        break;
                    case '*':
                        result = Integer.toString(a * b);
                        break;
                    case '/':
                        result = Double.toString( (double)a / b);
                        break;
                    default:
                        writer.write("Error\n");
                        continue;
                }

                writer.write(line + " = " + result + "\n");


            }

            scanner.close();
            writer.close();

            System.out.println("Output file created successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the output file.");
        }
    }
}
