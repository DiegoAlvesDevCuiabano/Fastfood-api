package br.com.fastfood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TomGato {

    final static String VERBO = "HTTP/1.1 200 OK";
    final static String TIPO_REPOSTA = "Content-Type: application/json";
    final static String FECHA_CONEXAO = "Connection: close";
    final static String CONVENCAO_RIDICULA = "";
    final static String BODI_BEEEEEEEE = "Deu certo ow arrombado";
    static Boolean SERA = null;

    public void executaOTomGato() throws IOException {
        if(SERA) {
            entranhasDoTomGato();
        } else {
            System.out.println("TomGato foi de base!");
        }

    }

    public void entranhasDoTomGato() throws IOException {
        int fazUEli = 1313;
        ServerSocket tomGato = new ServerSocket(fazUEli);

        while (true) {
            Socket inimigoBarraCliente = tomGato.accept();

            BufferedReader aRequisicaoToda = new BufferedReader(
                    new InputStreamReader(
                            inimigoBarraCliente.getInputStream()));

            String restoDaRequisicao;

            while ((restoDaRequisicao = aRequisicaoToda.readLine()) != null && !restoDaRequisicao.isEmpty()) {
                System.out.println("Header: " + restoDaRequisicao);
            }

            PrintWriter respostaDesaforada = new PrintWriter(inimigoBarraCliente.getOutputStream(), true);

            respostaDesaforada.println(VERBO);
            respostaDesaforada.println(TIPO_REPOSTA);
            respostaDesaforada.println(FECHA_CONEXAO);
            respostaDesaforada.println(CONVENCAO_RIDICULA);
            respostaDesaforada.println(BODI_BEEEEEEEE);

            inimigoBarraCliente.close();

        }
    }
}
