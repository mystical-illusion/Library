import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        Admin admin = new Admin(1, "Maya", "admin@library.com");
        Member member = new Member(2, "Ravi", "ravi@gmail.com");

        boolean exit = false;

        System.out.println("📚 Welcome to the Library Management System!");

        while (!exit) {
            System.out.println("\nWho are you?");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int role = sc.nextInt();

            switch (role) {
                case 1:
                    admin.showRole();
                    boolean adminExit = false;
                    while (!adminExit) {
                        System.out.println("\n📋 Admin Menu:");
                        System.out.println("1. Add Book");
                        System.out.println("2. Remove Book");
                        System.out.println("3. View All Books");
                        System.out.println("4. Exit Admin");
                        System.out.print("Enter choice: ");
                        int adminChoice = sc.nextInt();
                        sc.nextLine(); // consume newline

                        switch (adminChoice) {
                            case 1:
                                System.out.print("Enter Book ID: ");
                                int id = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter Book Title: ");
                                String title = sc.nextLine();
                                System.out.print("Enter Book Author: ");
                                String author = sc.nextLine();

                                Book newBook = new Book(id, title, author);
                                admin.addBook(library, newBook);
                                break;

                            case 2:
                                System.out.print("Enter Book ID to remove: ");
                                int removeId = sc.nextInt();
                                admin.removeBook(library, removeId);
                                break;

                            case 3:
                                library.showAllBooks();
                                break;

                            case 4:
                                adminExit = true;
                                break;
                            case 5:
                                System.out.print("Enter keyword to search: ");
                                String adminKeyword = sc.nextLine();
                                library.searchBooks(adminKeyword);
                                break;

                            default:
                                System.out.println("❌ Invalid choice.");
                        }
                    }
                    break;

                case 2:
                    member.showRole();
                    boolean memberExit = false;
                    while (!memberExit) {
                        System.out.println("\n📋 Member Menu:");
                        System.out.println("1. Borrow Book");
                        System.out.println("2. Return Book");
                        System.out.println("3. View My Books");
                        System.out.println("4. View All Available Books");
                        System.out.println("5. Exit Member");
                        System.out.print("Enter choice: ");
                        int memberChoice = sc.nextInt();

                        switch (memberChoice) {
                            case 1:
                                System.out.print("Enter Book ID to borrow: ");
                                int bookId = sc.nextInt();
                                member.borrowBook(library, bookId);
                                break;

                            case 2:
                                System.out.print("Enter Book ID to return: ");
                                int returnId = sc.nextInt();
                                member.returnBook(library, returnId);
                                break;

                            case 3:
                                member.showIssuedBooks();
                                break;

                            case 4:
                                library.showAllBooks();
                                break;

                            case 5:
                                memberExit = true;
                                break;

                            default:
                                System.out.println("❌ Invalid choice.");
                        }
                    }
                    break;

                case 3:
                    exit = true;
                    System.out.println("👋 Thank you for using the Library Management System!");
                    break;

                default:
                    System.out.println("❌ Invalid input. Please try again.");
            }
        }

        sc.close();
    }
}
