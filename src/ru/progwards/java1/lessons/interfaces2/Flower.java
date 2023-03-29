package ru.progwards.java1.lessons.interfaces2;

import ru.progwards.java1.lessons.interfaces1.IColor;

public class Flower implements IColor {
    @Override
    public Color getColor(){
        return Color.WHITE;
    }
}
