import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome!");
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("\n1. ADD BOOK \n2. ADD MEMBER \n3. CHECK IN \n4. CHECKOUT \n5. DISPLAY");
            System.out.print("ENTER OPTION: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Book addBook = new Book();
                    library.add(addBook);
                    break;
                
                case 2:
                    Member addMember = new Member();
                    library.add(addMember);
                    break;
                
                case 3:
                    System.out.println("CHOOSE BOOK: ");
                    int indexCheckinBook = scanner.nextInt();

                    System.out.println("CHOOSE MEMBER: ");
                    int indexChecinMember = scanner.nextInt();
                    scanner.nextLine();

                    if(indexCheckinBook > library.books.size() || indexChecinMember > library.members.size()){
                        System.out.println("ERROR");
                        continue;
                    }

                    System.out.println("ENTER DUE DATE (YYYYMMDD): ");
                    int checkoutDate = scanner.nextInt();
                    scanner.nextLine();

                    library.checkin(library.books.get(indexCheckinBook - 1), library.members.get(indexChecinMember - 1), checkoutDate);
                    break;
                
                case 4:
                    System.out.println("CHOOSE BOOK: ");
                    int indexCheckoutBook = scanner.nextInt();

                    System.out.println("CHOOSE MEMBER: ");
                    int indexCheckoutMember = scanner.nextInt();
                    scanner.nextLine();

                    library.checkout(library.books.get(indexCheckoutBook - 1), library.members.get(indexCheckoutMember - 1));
                    break;
                
                case 5:
                    System.out.println("--- DISPLAY ---");
                    library.display();
                    break;

                default:
                    break;
            }
        }

    }
}

class Book{
    String title, author, publisher, genre;
    int pages;

    Book(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Title: ");
        this.title = scanner.nextLine();

        System.out.print("Author: ");
        this.author = scanner.nextLine();

        System.out.print("Publisher: ");
        this.publisher = scanner.nextLine();

        System.out.print("Genre: ");
        this.genre = scanner.nextLine();

        System.out.print("Pages: ");
        this.pages = scanner.nextInt();
        scanner.nextLine();
    }

    Book(String title, String author, String publisher, String genre, int pages){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.pages = pages;
    }
}

class Member{
    String name, address, phoneNo, email;

    Member(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        this.name = scanner.nextLine();

        System.out.print("Address: ");
        this.address = scanner.nextLine();

        System.out.print("Contact: ");
        this.phoneNo = scanner.nextLine();

        System.out.print("Email: ");
        this.email = scanner.nextLine();
    }
    
    Member(String name, String address, String phoneNo, String email){
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }
}

class Loan{
    Book book;
    Member member;
    int due;

    Loan(){}
    Loan(Book book, Member member, int due){
        this.book = book;
        this.member = member;
        this.due = due;
    }
}