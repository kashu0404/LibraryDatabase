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


}
