package api;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class ChatWebSocketClient extends WebSocketClient {
    private java.util.function.Consumer<String> aoReceberMensagem;

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
    }

    if (mensagem.startsWith("MESSAGE")) {
        String conteudo = mensagem.substring(mensagem.indexOf("\n\n") + 2)
                .replace("\u0000", "");

        if (aoReceberMensagem != null) {
            aoReceberMensagem.accept(conteudo);
        }
    }
}

    private void inscreverNoChamado() {
        String comando = "SUBSCRIBE\n"
                + "id:chamado-" + idChamado + "\n"
                + "destination:/topic/chamado/" + idChamado + "\n\n"
                + "\u0000";

        send(comando);

        System.out.println("Inscrito no chamado: " + idChamado);
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