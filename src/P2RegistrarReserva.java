import java.io.*;
import java.util.Scanner;

public class P2RegistrarReserva {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("reservas.dat"))) {

            int dia, invitados;
            int totalAperturas = 0;

            do {
                do {
                    System.out.println("Día:");
                    dia = sc.nextInt();
                    if (dia < 0 || dia > 31) {
                        System.out.println("Día incorrecto");
                    }
                } while (dia < 0 || dia > 31);

                if (dia != 0) {
                    do {
                        System.out.println("¿Cuántos invitados nuevos?");
                        invitados = sc.nextInt();
                        if (invitados < 1) {
                            System.out.println("Debe ser mayor a 0");
                        }
                    } while (invitados < 1);

                    dos.writeUTF("Día " + dia + ": " + invitados);
                    dos.writeUTF(System.lineSeparator());
                    totalAperturas++;
                }
            } while (dia != 0);

            dos.writeUTF("Hay " + totalAperturas + " aperturas este mes");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
