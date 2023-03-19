package ru.progwards.java1.lessons.arrays1;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;

    public Eratosthenes(int N) {
        sieve = new boolean[N];
        Arrays.fill(sieve, true);
        sift();
    }

    private void sift() {
        sieve[0]=false;
        sieve[1]=false;
        for (int i = 2; i*i < sieve.length; i++) {
            if (sieve[i]) {
                for (int j=i*i; j<sieve.length ; j+=i) {
                    sieve[j]=false;
                }
            }
        }
    }
    public boolean isSimple(int n){
        for (int i = 2; i <= n; i++) {
            if(sieve[n]) return true;
        }
        return false;
    }

    public static void main(String[] args) {

      Eratosthenes sto = new Eratosthenes(30);
        System.out.println("Число является простым: "+sto.isSimple(29));
    }
}