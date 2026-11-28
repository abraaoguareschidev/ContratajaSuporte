/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import java.net.URI;
import java.util.function.Consumer;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

/**
 *
 * @author ywdyl
 */
public class ChamadosWebSocketClient extends WebSocketClient{
    private Consumer<String> aoReceberAtualizacao;

    public ChamadosWebSocketClient() throws Exception {
        super(new URI("ws://localhost:8080/ws"));
    }

    @Override
    public void onOpen(ServerHandshake handshake) {

        String comando = "CONNECT\n"+ "accept-version:1.2\n"+ "host:localhost\n\n"+ "\u0000";

        send(comando);
    }

    @Override
    public void onMessage(String mensagem) {

        if (mensagem.startsWith("CONNECTED")) {

            String comando = "SUBSCRIBE\n"+ "id:atualizacao-chamados\n"+ "destination:/topic/chamados\n\n"+ "\u0000";

            send(comando);
            return;
        }

        if (mensagem.startsWith("MESSAGE")) {

            int inicioCorpo = mensagem.indexOf("\n\n");

            if (inicioCorpo == -1) {
                return;
            }

            String corpo = mensagem.substring(inicioCorpo + 2).replace("\u0000", "").trim();

            if (aoReceberAtualizacao != null) {
                aoReceberAtualizacao.accept(corpo);
            }
        }
    }

    public void setAoReceberAtualizacao(Consumer<String> callback) {
        this.aoReceberAtualizacao = callback;
    }

    @Override
    public void onClose(int codigo, String motivo, boolean remoto) {
        System.out.println("WebSocket de chamados desconectado.");
    }

    @Override
    public void onError(Exception erro) {
        erro.printStackTrace();
    }
    
}
