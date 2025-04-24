package main.taskForStream;

import java.util.Arrays;
import java.util.List;

public class Task9 {
    public static void main(String[] args) {
        Author author1 = new Author("J.K. Rowling", 55);
        Author author2 = new Author("George Orwell", 46);
        Author author3 = new Author("J.R.R. Tolkien", 81);

        List<Book> books = Arrays.asList(
                new Book("Harry Potter", author1),
                new Book("1984", author2),
                new Book("The Hobbit", author3),
                new Book("Animal farm", author2)
        );

        books.stream()
                .filter(b -> b.author.getAge() > 50)
                .map(Book::getTitle)
                .sorted()
                .forEach(System.out::println);
    }
}

class Author {
    String name;
    int age;

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Book {
    String title;
    Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
}