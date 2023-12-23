import java.util.ArrayList;
import java.util.Scanner;

public class Library extends LibraryTemplate {
    static final int DUE_FINE = 100;

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Book> availableBooks = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Loan> loans = new ArrayList<>();

    Library(){}

    // Polymorphism
    public void add(Book book){
        books.add(book);
        availableBooks.add(book);
    }

    public void add(Member member){
        members.add(member);
    }

    public void add(Loan loan){
        loans.add(loan);
    }

    // LIBRARY METHODS:-
    public void checkout(Book book, Member member){
        String bookName = book.title;
        String memberName = member.name;

        for(int i=0; i<loans.size(); i++){
            if(loans.get(i).book.title == bookName && loans.get(i).member.name == memberName){
                loans.remove(i);
                availableBooks.add(book);
                System.out.println(member.name + " CHECKED OUT: " + book.title);
            }
        }
    }

    public void checkin(Book book, Member member, int due){
        if(members.contains(member) && availableBooks.contains(book)){
            Loan assign = new Loan(book, member, due);
            loans.add(assign);
            System.out.println(member.name + " CHECKED IN: " + book.title);
            availableBooks.remove(book);
        }
    }

    public int calculateDues(Member member, int today){  //YYYY-MM-DD
        int totalDues = 0;

        for(int i=0; i<loans.size(); i++){
            if(loans.get(i).member.name == member.name && loans.get(i).due > today){
                totalDues += DUE_FINE;
            }
        }

        return totalDues;
    }

    public void display(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("DISPLAY: \n1.Books \n2.Members \n3. OverDue Books \n4. Checkout Books \n5. Available Books \n6. Check Dues");
        
        System.out.println("ENTER OPTION: ");
        int option = scanner.nextInt();
        scanner.nextLine(); //Consume New Line

        switch (option) {
            case 1:
                for(int i=0; i<books.size(); i++){
                    System.out.println(i+1 + ") " + books.get(i).title);
                }
                break;
        
            case 2:
                for(int i=0; i<members.size(); i++){
                    System.out.println(i+1 + ") " + members.get(i).name);
                }
                break;
        
            case 3:
                System.out.println("ENTER TODAY's DATE:- (YYYYMMDD)");
                int todayDate = scanner.nextInt();
                scanner.nextLine();
                for(int i=0; i<loans.size(); i++){
                    if(loans.get(i).due < todayDate){
                        System.out.println(i+1 + ") " + loans.get(i).book.title);
                    }
                }
                break;
                
            case 4:
                for(int i=0; i<loans.size(); i++){
                    System.out.println(i+1 + ") " + loans.get(i).book.title);
                }
                break;

            case 5:
                for(int i=0; i<availableBooks.size(); i++){
                    System.out.println(i+1 + ") " + availableBooks.get(i).title);
                }
                break;

            case 6:
                System.out.println("ENTER NAME: ");
                String memberName = scanner.nextLine();

                System.out.println("ENTER TODAY's DATE:- (YYYYMMDD)");
                int checkDueDate = scanner.nextInt();
                scanner.nextLine();

                int totalDueOfMember = 0;
                for(int i=0; i<loans.size(); i++){
                    if(memberName.equals(loans.get(i).member.name) && loans.get(i).due < checkDueDate){
                        totalDueOfMember += DUE_FINE;
                    }
                }

                System.out.println("TOTAL DUE:- " + totalDueOfMember);

                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }
}
