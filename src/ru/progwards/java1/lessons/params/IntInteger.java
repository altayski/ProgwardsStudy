package ru.progwards.java1.lessons.params;

public class IntInteger extends AbsInteger{
    @Override
            public String toString(){
        return Integer.toString(value);
    }

    IntInteger(int value){
        super(value);
    }
}
