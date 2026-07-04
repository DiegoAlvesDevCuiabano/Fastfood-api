package br.com.fastfood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

@GerarAcessores
public class Requisicao {

    private Socket inimigoBarraCliente;

    @GetSet
    private String verbo;
    @GetSet
    private String rota;
    @GetSet
    private List<String> headers;
    @GetSet
    private String body;

    public void trabalhaRequisicao(Socket inimigoBarraCliente) throws IOException {
        BufferedReader aRequisicaoToda = new BufferedReader(
                new InputStreamReader(
                        inimigoBarraCliente.getInputStream()));

        String restoDaRequisicao;

        extraiMetodoRotaDeFuga(aRequisicaoToda);

        while ((restoDaRequisicao = aRequisicaoToda.readLine()) != null && !restoDaRequisicao.isEmpty()) {
            headers.add(restoDaRequisicao);
        }
    }

    private void extraiMetodoRotaDeFuga(BufferedReader aRequisicaoToda) throws IOException {
        String identificadorDeVerbo = aRequisicaoToda.readLine();
        String[] quebraQuebra = identificadorDeVerbo.split(" ");
        verbo = quebraQuebra[0];
        rota = quebraQuebra[1];


    }

    @Override
    public String toString() {
        return "Requisicao{" +
                "inimigoBarraCliente=" + inimigoBarraCliente +
                ", verbo='" + verbo + '\'' +
                ", rota='" + rota + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }
}
