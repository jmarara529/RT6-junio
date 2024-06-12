import java.io.*;

public class P2ListarReservas {
    public static void main(String[] args) {

        try (DataInputStream dis = new DataInputStream(new FileInputStream("reservas.dat"))) {

            String linea;
            while ((linea = dis.readUTF()) != null) {
                System.out.println(linea);
            }

        } catch (EOFException e) {
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no existe.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
