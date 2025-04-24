package main.taskForStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task11 {
    public static void main(String[] args) {
        List<Book2> books1 = Arrays.asList(
                new Book2("Book1", 300), new Book2("Book2", 200)
        );
        List<Book2> books2 = Arrays.asList(
                new Book2("Book3", 400), new Book2("Book4", 150)
        );

        Author2 author1 = new Author2("Author1", books1);
        Author2 author2 = new Author2("Author2", books2);

        List<Author2> authors = Arrays.asList(author1, author2);

        authors.stream()
                .flatMap(a ->  a.getBooks().stream())
                .filter(b -> b.getPages() > 200)
                .sorted(Comparator.comparingInt(Book2::getPages))
                .map(Book2::getTitle)
                .forEach(System.out::println);
    }
}

class Author2 {
    String name;
    List<Book2> books;

    Author2(String name, List<Book2> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book2> getBooks() {
        return books;
    }
}

class Book2 {
    String title;
    int pages;

    Book2(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }
}
