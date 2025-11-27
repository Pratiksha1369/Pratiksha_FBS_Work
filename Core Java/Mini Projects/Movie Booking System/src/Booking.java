//Bollywood Movie Ticket Booking System (Menu-Driven)

import java.util.Scanner;

// ---------------- Movie Class ----------------
class Movie {

    private String name;
    private int seats;

    Movie(String name, int seats) {
        this.name = name;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public int getSeats() {
        return seats;
    }

    // checks if housefull
    public boolean isHouseFull() {
        return seats == 0;
    }

    // booking updates seats
    public void book(int count) throws TicketsSoldOutException {

        if (isHouseFull()) {
            throw new TicketsSoldOutException();
        }

        if (count > seats) {
            throw new TicketsSoldOutException();
        }

        seats -= count;  // seat update happens here
    }
}


// ---------------- Booking System Class ----------------
    class BookingSystem {

        private Movie[] movies;

        BookingSystem(Movie[] movies) {
            this.movies = movies;
        }

        public void showMenu() {
            System.out.println("\n--- MOVIES AVAILABLE ---");
            for (int i = 0; i < movies.length; i++) {

                Movie m = movies[i];

                // Show (HOUSEFULL) when seats reach 0
                if (m.isHouseFull()) {
                    System.out.println((i + 1) + ". " + m.getName() + "  (HOUSEFULL)");
                } else {
                    System.out.println((i + 1) + ". " + m.getName() + "  [Seats: " + m.getSeats() + "]");
                }
            }
        }

        // Validate selection
        public Movie selectMovie(int choice) throws InvalidMovieSelectionException {

            if (choice < 1 || choice > movies.length) {
                throw new InvalidMovieSelectionException();
            }

            Movie m = movies[choice - 1];

            if (m.isHouseFull()) {
                throw new InvalidMovieSelectionException();
            }

            return m;
        }
    }


// ---------------- Main Class ----------------
    public class Booking {
        public static void main(String[] args) {

            Movie[] movies = {
                new Movie("3 Idiots", 10),
                new Movie("Dangal", 5),
                new Movie("Bahubali 2", 3)
            };

            BookingSystem system = new BookingSystem(movies);
            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("\n===== MAIN MENU =====");
                System.out.println("1. Show Movies");
                System.out.println("2. Book Tickets");
                System.out.println("3. Exit");
                System.out.println("=====================");
                System.out.print("Enter choice: ");

                int menuChoice = sc.nextInt();
                sc.nextLine();

                switch (menuChoice) {

                    case 1:
                        system.showMenu();
                        break;

                    case 2:
                        system.showMenu();
                        System.out.print("\nSelect movie: ");
                        int choice = sc.nextInt();
                        sc.nextLine();

                        try {
                            Movie selected = system.selectMovie(choice);

                            System.out.print("Enter number of tickets: ");
                            int count = sc.nextInt();
                            sc.nextLine();

                            selected.book(count);

                            System.out.println("Booking successful!");

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;

                    case 3:
                        System.out.println("Thank you for using our booking system!");
                        return;

                    default:
                        System.out.println("Invalid option!");
                }
            }
        }
    }
