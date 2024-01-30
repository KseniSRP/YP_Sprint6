package com.example;

import java.util.List;

public class Alex extends Lion {

    public Alex(Feline feline) throws Exception {
        super("Самец", feline); // Алекс - самец, передаем это значение в конструктор базового класса
    }

    @Override
    public int getKittens() {
        return 0; // У Алекса нет львят
    }

    public List<String> getFriends() {
        // Список друзей Алекса
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        // Место обитания Алекса
        return "Нью-Йоркский зоопарк";
    }
}
