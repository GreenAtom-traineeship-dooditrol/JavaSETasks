package com.dooditrol.javasetasks.streamapi;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {



    public static void main(String[] args) {
        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));//
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));//
        Developer dev4 = new Developer("Игорь", Arrays.asList("C", "JavaScript"));
        Developer dev5 = new Developer("Максим", Arrays.asList("C", "Ruby"));//
        Developer dev6 = new Developer("Наташа", Arrays.asList("Java", "PHP", "Scala"));//
        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3, dev4, dev5, dev6);

        Map<String, Integer> popularityOfLanguages = new HashMap<>();

        Consumer<Developer> calc = (dev)->{
            for (String language : dev.getLanguages()) {
                Integer numberOfLanguageUsers = popularityOfLanguages.get(language);

                if (numberOfLanguageUsers != null) {
                    popularityOfLanguages.put(language, ++numberOfLanguageUsers);
                }
                else {
                    popularityOfLanguages.put(language, 1);
                }
            }
        };

        Predicate<Developer> pred = (dev)->{
            for (String language : dev.getLanguages()) {

                if (popularityOfLanguages.get(language) == 1) {
                    return true;
                }
            }
            return false;
        };

        developerStream
                .peek(calc)
                .collect(Collectors.toList()).stream()
                .filter(pred)
                .forEach(dev->System.out.println(dev.getName() + " "));

       /*developerStream
                .flatMap(dev->dev.getLanguages()
                        .stream()
                        .map(l->new AbstractMap.SimpleEntry<>(l, dev.getName())))
               .collect(Collectors.groupingBy(Map.Entry::getKey,
                       Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
               .values()
               .stream()
               .filter(list->list.size() == 1)
               .map(list->list.get(0))
               .distinct()
               .forEach(name->System.out.print(name + " "));*/
    }
}
