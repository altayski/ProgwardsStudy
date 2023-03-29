package ru.progwards.java1.lessons.interfaces2;

public interface CompareWeight {
    enum CompareResult {
        LESS,
        EQUAL,
        CREATER
    }
     CompareResult compareWeight(CompareWeight smthHasWeight);
     double getWeight();
}
