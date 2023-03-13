package ru.progwards.java1.lessons.classescompare;

public class TestForAll {
    public static void main(String[] args) {
        System.out.println("Тест для Animal, Cow, Hamster, Duck");
        Cow burenka = new Cow("Burenka");
        Cow milanka = new Cow("Milanka");
        Cow burenkaClone = new Cow("Burenka");
        burenka.setWeight(150d);
        milanka.setWeight(150d);
        burenkaClone.setWeight(150);
        System.out.println("Буренка и Миланка одинаковы? " + burenka.equals(milanka));
        System.out.println("Поменять местами Миланку и Буренку (симметричность проверки) " + milanka.equals(burenka));
        System.out.println("Сравнить два Буренку с клоном " + burenka.equals(burenkaClone));
        System.out.println("Сравнение по весу " + burenka.compareTo(milanka) + "  = одинаковые");
        burenkaClone.setWeight(155);
        System.out.println("Клонированная Буренка лучше набирает вес " + burenka.compareTo(burenkaClone));

        System.out.println("Что ест Буренка ? "+burenka.getFoodKind());
        System.out.println("Коэффициент веса еды к весу Буренки  "+burenka.getFoodCoeff());
        System.out.println("Необходимый вес еды для Буренки "+burenka.calculateFoodWeight());
        Duck sonya = new Duck("Sonya");
        sonya.setWeight(2.2);
        System.out.println("Что ест Соня ? "+sonya.getFoodKind());
        System.out.println("Коэффициент веса еды к весу Сони  "+sonya.getFoodCoeff());
        System.out.println("Необходимый вес еды для Сони "+sonya.calculateFoodWeight());
        Duck krya  = new Duck("Krya");
        krya.setWeight(2.3);
        System.out.println("Сравним одинаковые ли утки "+sonya.equals(krya));
        System.out.println("Утки по весу "+sonya.compareTo(krya));
        System.out.println("Сравним по весу утку и корову "+sonya.compareTo(burenka));
        System.out.println("Несовместимые типы сравнения "+sonya.equals(burenka));
        System.out.println("Стоимость еды для Буренки "+burenka.calculateFoodPrice());
        System.out.println("Стоимость еды для Сони "+sonya.calculateFoodPrice());

    }
}
