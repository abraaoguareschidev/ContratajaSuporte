package api;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class ChatWebSocketClient extends WebSocketClient {
    private java.util.function.Consumer<String> aoReceberMensagem;
    private java.util.function.Consumer<Integer> aoReceberLeitura;

    private final Integer idChamado;

    public ChatWebSocketClient(Integer idChamado) throws Exception {
        super(new URI("ws://localhost:8080/ws"));
        this.idChamado = idChamado;
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        System.out.println("WebSocket conectado!");

        String comando = "CONNECT\n"
                + "accept-version:1.2\n"
                + "host:localhost\n\n"
                + "\u0000";

        send(comando);
    }

    @Override
public void onMessage(String mensagem) {

    System.out.println("Mensagem recebida: " + mensagem);

    if (mensagem.startsWith("CONNECTED")) {
        inscreverNoChamado();
        return;
    }

    if (mensagem.startsWith("MESSAGE")) {

        int inicioCorpo = mensagem.indexOf("\n\n");

        if (inicioCorpo == -1) {
            return;
        }

        String corpo = mensagem.substring(inicioCorpo + 2)
                .replace("\u0000", "").trim();

        // Verifica se é um aviso de leitura
        if (mensagem.contains("destination:/topic/chamado/" + idChamado + "/leitura")) {

            com.google.gson.JsonObject aviso =
                    com.google.gson.JsonParser.parseString(corpo)
                            .getAsJsonObject();

            int idUsuario = aviso.get("idUsuario").getAsInt();

            if (aoReceberLeitura != null) {
                aoReceberLeitura.accept(idUsuario);
            }

            return;
        }

        // Se não for aviso de leitura, é uma mensagem normal
        if (aoReceberMensagem != null) {
            aoReceberMensagem.accept(corpo);
        }
    }
}
public void setAoReceberLeitura(
        java.util.function.Consumer<Integer> callback) {

    this.aoReceberLeitura = callback;
}

    private void inscreverNoChamado() {

    // Inscrição para receber mensagens da conversa
    String comando = "SUBSCRIBE\n"
            + "id:chamado-" + idChamado + "\n"
            + "destination:/topic/chamado/" + idChamado + "\n\n"
            + "\u0000";

    send(comando);

    // Inscrição para receber avisos de leitura
    String comandoLeitura = "SUBSCRIBE\n"
            + "id:leitura-" + idChamado + "\n"
            + "destination:/topic/chamado/" + idChamado + "/leitura\n\n"
            + "\u0000";

    send(comandoLeitura);

    System.out.println("Inscrito no chamado: " + idChamado);
    System.out.println("Inscrito no tópico de leitura!");
}

    @Override
    public void onClose(int codigo, String motivo, boolean remoto) {
        System.out.println("Conexão encerrada.");
    }

    @Override
    public void onError(Exception erro) {
        erro.printStackTrace();
    }
    public void setAoReceberMensagem(java.util.function.Consumer<String> callback) {
    this.aoReceberMensagem = callback;
}
    
    public void enviarMensagem(String conteudo, Integer idRemetente) {

    com.google.gson.JsonObject json = new com.google.gson.JsonObject();

    json.addProperty("idRemetente", idRemetente);
    json.addProperty("conteudo", conteudo);

    String comando = "SEND\n"
            + "destination:/app/chamado/" + idChamado + "\n"
            + "content-type:application/json\n\n"
            + json.toString()
            + "\u0000";

    send(comando);
}
}