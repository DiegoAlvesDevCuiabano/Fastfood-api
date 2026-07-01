package br.com.fastfood;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TomGato tomgato = new TomGato();
        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem vindo ao servidor que te odeia");
        boolean sair = false;
        do {
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Ligar o TomGato");
            System.out.println("2 - Desligar o TomGato");
            System.out.println("3 - Farmar Aura");
            System.out.println("4 - Sair");
            Integer escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> {
                    TomGato.SERA = true;
                    tomgato.executaOTomGato();
                }
                case 2 -> {
                    TomGato.SERA = false;
                    tomgato.executaOTomGato();
                }
                case 3 -> System.out.println("Deixa de ser Tchola");
                case 4 -> sair = true;
                case 5 -> System.out.println("Deixa de ser burro e escolha algo válido");
            }
        } while (sair);
    }
}
