package ru.progwards.java1.lessons.params;

public class ShortInteger extends AbsInteger{
    @Override
    public String toString() {
        return "ShortInteger(" +
                 + this.value +
                ')';
    }

    ShortInteger(short value){
        super(value);
    }
}
