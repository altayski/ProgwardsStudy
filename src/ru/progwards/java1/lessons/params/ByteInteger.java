package ru.progwards.java1.lessons.params;

public class ByteInteger extends AbsInteger{
    public ByteInteger(byte value) {
        super(value);
    }

    @Override
    public String toString() {
        return Byte.toString( (byte) value);
    }
}
