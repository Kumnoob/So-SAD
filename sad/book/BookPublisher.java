package com.solid.book;

import java.util.List;

public class BookPublisher {
    public static void main(String[] args) {
        Book book = new Book("Tyland", List.of("I", "moved", "here", "recently", "too"));
        IPubPrinter pubPrinter = new BookPrinter(book);
        pubPrinter.printToFile();
    }
}