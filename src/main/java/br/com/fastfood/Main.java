package br.com.fastfood;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TomGato tomgato = new TomGato();
        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem vindo ao servidor que te odeia");
        boolean rodando = true;
        do {
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Ligar o TomGato");
            System.out.println("2 - Desligar o TomGato");
            System.out.println("3 - Farmar Aura");
            System.out.println("4 - Sair");
            Integer escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> {
                    new Thread(() -> {
                        try {
                            TomGato.SERA = true;
                            tomgato.executaOTomGato();
                        } catch (IOException e) {
                            System.out.println("TomGato desligado");
                        }
                    }).start();
                    System.out.println("TomGato ligado na porta do Faz o Eli");
                }
                case 2 -> {
                    if (TomGato.instancia == null) {
                        System.out.println("Gatoff");
                    } else {
                        tomgato.instancia.close();
                    }
                }
                case 3 -> System.out.println("Deixa de ser Tchola");
                case 4 -> rodando = false;
                case 5 -> System.out.println("Deixa de ser burro e escolha algo válido");
            }
        } while (rodando);
    }
}
