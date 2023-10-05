package homeworks.homework10.parser;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Book {
    String bookName;
    StringBuilder bookText = new StringBuilder();
    List<Map.Entry<String, Integer>> counterPopWords = new ArrayList<>();
    int uniqeWords;


    public void bookChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title of the book you would like to read: ");
        while (true) {
            bookName = scanner.nextLine().toLowerCase().replace(" ", "");
            try (BufferedReader selectedBook = new BufferedReader(new FileReader("src/homeworks/homework10/parser/resources/" + bookName + ".txt"))) {
                selectedBook.lines().forEach(line -> bookText.append(line).append("\n"));
                System.out.println("great, you choose the book !");
                break;
            } catch (IOException e) {
                System.out.println("we not have this book:(  try again!");
            }
        }
    }
    public void getStatistic () {
        String[] allwords = bookText.toString().toLowerCase().split("\\s+");
        Map<String, Integer> allWords = new HashMap<>();
        Arrays.stream(allwords)
                .filter(word -> word.length() > 2)
                .forEach(word -> allWords.put(word, allWords.getOrDefault(word, 0) + 1));
        counterPopWords = allWords.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(10)
                .toList();
        System.out.println("ten most popular words is:");
        counterPopWords.forEach(w -> System.out.print(w + "; "));
        System.out.println();
        uniqeWords = allWords.size();
        System.out.println("number of unique words is - " + uniqeWords);
    }

    public void writeStatInFile (){
        try(PrintWriter writeStat = new PrintWriter(new FileWriter("src/homeworks/homework10/parser/resources/" + bookName + "_statistic.txt"))) {
            writeStat.write("ten most popular words is:");
            writeStat.write(counterPopWords.toString());
            writeStat.write("number of unique words is - " + uniqeWords);

            System.out.println("These statistics are recorded in a file");
        } catch (IOException e) {
            System.out.println("can't write");
        }
    }
}
