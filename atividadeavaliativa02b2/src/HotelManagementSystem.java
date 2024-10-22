import classes.Guest;
import classes.Hotel;
import classes.Reservation;
import classes.Room;

import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            clearScreen();
            System.out.println("=== Sistema de Gerenciamento de Hotel ===");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Realizar Check-in");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Relatório de Ocupação");
            System.out.println("6. Histórico de Reservas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            clearScreen();

            switch (option) {
                case 1:
                    System.out.println("=== Cadastro de Quarto ===");
                    System.out.print("Número do quarto: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo de quarto (solteiro, casal, suite): ");
                    String type = scanner.nextLine();
                    System.out.print("Preço diário: ");
                    double dailyPrice = scanner.nextDouble();
                    scanner.nextLine();
                    boolean available = true;
                    Room room = new Room(number, type, dailyPrice, available);
                    hotel.addRoom(room);
                    System.out.println("Quarto cadastrado com sucesso!");
                    pause();
                    break;
                case 2:
                    System.out.println("=== Cadastro de Reserva ===");
                    System.out.print("Nome do hóspede: ");
                    String guestName = scanner.nextLine();
                    Guest guest = new Guest(guestName);
                    hotel.guests.add(guest);
                    System.out.print("Data de check-in (dd/mm/aaaa): ");
                    String checkInDate = scanner.nextLine();
                    System.out.print("Data de check-out (dd/mm/aaaa): ");
                    String checkOutDate = scanner.nextLine();
                    System.out.print("Número de quartos reservados: ");
                    int numRoomsReserved = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo de quarto reservado (solteiro, casal, suite): ");
                    String roomTypeReserved = scanner.nextLine();
                    Reservation reservation = new Reservation(guest, checkInDate, checkOutDate, numRoomsReserved, roomTypeReserved);
                    hotel.addReservation(reservation);
                    System.out.println("Reserva cadastrada com sucesso!");
                    pause();
                    break;
                case 3:
                    System.out.println("=== Check-in ===");
                    System.out.print("Nome do hóspede para check-in: ");
                    String checkInGuestName = scanner.nextLine();
                    hotel.checkIn(checkInGuestName);
                    pause();
                    break;
                case 4:
                    System.out.println("=== Check-out ===");
                    System.out.print("Número do quarto para check-out: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    hotel.checkOut(roomNumber);
                    pause();
                    break;
                case 5:
                    System.out.println("=== Relatório de Ocupação ===");
                    hotel.occupancyReport();
                    pause();
                    break;
                case 6:
                    System.out.println("=== Histórico de Reservas ===");
                    System.out.print("Nome do hóspede para histórico de reservas: ");
                    String historyGuestName = scanner.nextLine();
                    hotel.reservationHistory(historyGuestName);
                    pause();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    pause();
                    break;
            }
        } while (option != 0);

        scanner.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause() {
        System.out.println("\nPressione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}

