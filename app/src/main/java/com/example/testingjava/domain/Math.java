package com.example.testingjava.domain;


import com.example.testingjava.domain.utils.DotException;
import com.example.testingjava.domain.utils.EmptyException;
import com.example.testingjava.domain.utils.LettersException;
import com.example.testingjava.domain.utils.NegativeException;
import com.example.testingjava.domain.utils.NullException;
import com.example.testingjava.domain.utils.SymbolsException;
import com.example.testingjava.domain.utils.ZeroException;

import java.util.regex.Pattern;

public class Math {
    private final Pattern patternEn = Pattern.compile("[a-zA-Z]+");
    private final Pattern patternRu = Pattern.compile("[а-яА-Я]+");
    private String number = "\\d+";


    public String add(String first, String second) {
        String result;
        result = "v";
        try {
            if (first == null || second == null) {
                throw new NullException("Отправка null");
            } else if (patternRu.matcher(first).find() || patternRu.matcher(second).find()) {
                throw new LettersException("Отправка букв");
            } else if (patternEn.matcher(first).find() || patternEn.matcher(second).find()) {
                throw new LettersException("Отправка букв");
            } else if (first.contains("-") || second.contains("-")) {
                throw new NegativeException("Отрицательные числа");
            } else if (first.trim().isEmpty() || second.trim().isEmpty()) {
                throw new EmptyException("Пусто");
            } else if (first.contains(".") || second.contains(".")) {
                throw new DotException("Отправка точки");
            } else if (first.matches(number) && second.matches(number)) {
                int numberFirst = Integer.parseInt(first.trim());
                int numberSecond = Integer.parseInt(second.trim());
                result = String.valueOf(numberFirst + numberSecond);
            } else {
                throw new SymbolsException("Специальные символы");
            }
        } catch (LettersException | NullException | NegativeException
                | EmptyException | DotException | SymbolsException e) {
            result = e.getMessage();
        }
        return result;
    }

    public String div(String first, String second) {
        String result;
        result = "c";
        try {
            if (first == null || second == null) {
                throw new NullException("Отправка null");
            } else if (second.equals("0")) {
                throw new ZeroException("На 0 делить нельзя!");
            } else if (patternRu.matcher(first).find() || patternRu.matcher(second).find()) {
                throw new LettersException("Отправка букв");
            } else if (patternEn.matcher(first).find() || patternEn.matcher(second).find()) {
                throw new LettersException("Отправка букв");
            } else if (first.contains("-") || second.contains("-")) {
                throw new NegativeException("Отрицательные числа");
            } else if (first.trim().isEmpty() || second.trim().isEmpty()) {
                throw new EmptyException("Пусто");
            } else if (first.contains(".") || second.contains(".")) {
                throw new DotException("Отправка точки");
            } else if (first.matches(number) && second.matches(number)) {
                int numberFirst = Integer.parseInt(first.trim());
                int numberSecond = Integer.parseInt(second.trim());
                result = String.valueOf(numberFirst / numberSecond);
            } else {
                throw new SymbolsException("Специальные символы");
            }
        } catch (LettersException | NullException | NegativeException
                | EmptyException | DotException | SymbolsException | ZeroException e) {
            result = e.getMessage();
        }
        return result;
    }

}
