package classes;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public List<Room> rooms;
    public List<Reservation> reservations;
    public List<Guest> guests;

    public Hotel() {
        rooms = new ArrayList<Room>();
        reservations = new ArrayList<Reservation>();
        guests = new ArrayList<Guest>();
    }

    // Método para cadastrar quartos
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Método para cadastrar reservas
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Método para realizar check-in
    public void checkIn(String guestName) {
        for (Reservation reservation : reservations) {
            if (reservation.guest.name.equals(guestName)) {
                int roomsNeeded = reservation.numRoomsReserved;
                for (Room room : rooms) {
                    if (room.type.equals(reservation.roomTypeReserved) && room.available && roomsNeeded > 0) {
                        room.available = false;
                        roomsNeeded--;
                        System.out.println("Check-in realizado no quarto " + room.number);
                    }
                }
                if (roomsNeeded == 0) {
                    return;
                } else {
                    System.out.println("Não há quartos suficientes disponíveis para o tipo solicitado.");
                    return;
                }
            }
        }
        System.out.println("Reserva não encontrada para o hóspede: " + guestName);
    }

    // Método para realizar check-out
    public void checkOut(int roomNumber) {
        for (Room room : rooms) {
            if (room.number == roomNumber) {
                room.available = true;
                System.out.println("Check-out realizado no quarto " + room.number);
                return;
            }
        }
        System.out.println("Quarto não encontrado.");
    }

    // Método para gerar relatório de ocupação
    public void occupancyReport() {
        System.out.println("Relatório de Ocupação de Quartos:");
        for (Room room : rooms) {
            if (!room.available) {
                System.out.println("Quarto " + room.number + " (" + room.type + ") está ocupado.");
            }
            //Lista os quartos desocupados
            else {
                System.out.println("Quarto " + room.number + " (" + room.type + ") está desocupado.");
            }
        }

        //Se todos os quartos estiverem desocupados
        if (rooms.stream().allMatch(room -> room.available)) {
            System.out.println("Todos os quartos estão desocupados.");
        }
    }

    // Método para gerar histórico de reservas
    public void reservationHistory(String guestName) {
        System.out.println("Histórico de Reservas para " + guestName + ":");
        for (Reservation reservation : reservations) {
            if (reservation.guest.name.equals(guestName)) {
                System.out.println("Data de reserva: " + reservation.checkInDate + " a " + reservation.checkOutDate);
                System.out.println("Número de quartos reservados: " + reservation.numRoomsReserved);
                System.out.println("Tipo de quarto reservado: " + reservation.roomTypeReserved);
                System.out.println("-----------------------------------");
            }
        }
    }
}

