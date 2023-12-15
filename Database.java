import java.util.ArrayList;

import java.util.Iterator;


public class Database {
    
    private ArrayList<Books> bookList = new ArrayList<>();

    public Database() {

        this.bookList = new ArrayList<>();

    }

    public void displayDatabase() {
        //prints all current books
        for (Books b : bookList) {
            b.printBook();
        }
    }

    public void addBook(Books b) {
        bookList.add(b);
    }

    public void deleteBook(Books b) {
        Iterator<Books> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Books book = iterator.next();
            if (book.equals(b)) {
                iterator.remove();
                System.out.println("Book has been deleted successfully.\n");
            }
        }
    }

    public boolean searchBook(String search) { //search book based on title, author or isbn
        boolean found = false;
        
        for (Books book : bookList) {
            if (book.getTitle().equalsIgnoreCase(search) ||
            book.getAuthor().equalsIgnoreCase(search) || book.getIsbn().equalsIgnoreCase(search)) {
                book.printBook();
                found= true;
            } else {
                System.out.println("Book not found!");
            }
        }
        return found;
    }

    public void updateDatabase(Books newBook) {
        if (!(searchBook(newBook.getTitle()))) {
            bookList.add(newBook);
            System.out.println("Book added successfully!\n");
        } else { //update book if already present in database
            Iterator<Books> iterator = bookList.iterator();
            while (iterator.hasNext()) {
                Books book = iterator.next();
                if (book.equals(newBook)) {
                    iterator.remove(); //remove old book

                    bookList.add(newBook); //add updated old book
                    System.out.println("Book added successfully.\n");
                }
            }
        }   
    }

    public void userMenu() {
        int choice;

        do {
            System.out.println("1. Display Database");
            System.out.println("2. Add Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Book Using Author, Title or ISBN");
            System.out.println("5. Update a Book");
            System.out.println("0. Exit");

            System.out.println("Enter your choice");
            choice = scan.nextInt();

            switch(choice) {
                case 1:
                    displayDatabase();
                    break;
                case 2:
                    System.out.println("Enter Author Name: ");
                    String author = scan.nextLine();
                    System.out.println("Enter Title: ");
                    String title = scan.nextLine();
                    System.out.println("Enter ISBN: ");
                    String is = scan.nextLine();
                    System.out.println("Enter Publication Date: ");
                    int date = scan.nextInt();

                    addBook(new Books(title, author, date, is));

                    break;
                case 3:
                    scan.nextLine();
                    System.out.println("Enter Title to delete book: ");
                    String str = scan.nextLine();
                    deleteBook(new Books(str, "", 0, ""));
                    break;
                case 4 :
                    System.out.println("Enter Author, Title or ISBN");
                    String searchInput = scan.nextLine();
                    searchBook(searchInput);
                    break;
                case 5:
                    System.out.println("Enter the Updated Book (Title,Author,Date and ISBN):");
                    System.out.println("Enter Author Name: ");
                    String a = scan.nextLine();
                    System.out.println("Enter the exact Title: ");
                    String t = scan.nextLine();
                    System.out.println("Enter exact ISBN: ");
                    String i = scan.nextLine();
                    System.out.println("Enter exact Publication Date: ");
                    int d = scan.nextInt();

                    updateDatabase(new Books(t, a, d, i));
                    break;

            }
        } while (choice!=0);
        
    }

    public static void main(String[] args) {
        Database bookDatabase = new Database();
        bookDatabase.userMenu();
    }



}
