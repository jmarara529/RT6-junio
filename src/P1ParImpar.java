import java.io.*;

public class P1ParImpar {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("entrada.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("salida.txt"))) {

            String line;
            int pares = 0, impares = 0;

            while ((line = reader.readLine()) != null) {
                String[] numeros = line.split(" ");

                for (String numeroStr : numeros) {

                    int numero = Integer.parseInt(numeroStr);

                    if (numero == -1) {
                        writer.write("pares:" + pares + " impares:" + impares);
                        writer.newLine();
                        pares = 0;
                        impares = 0;
                    } else {
                        if (numero % 2 == 0) {
                            pares++;
                        } else {
                            impares++;
                        }
                    }
                }
            }

            writer.write("FIN");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

