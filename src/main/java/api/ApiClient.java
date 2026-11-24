package api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;

public class ApiClient {

    private final HttpClient client = HttpClient.newHttpClient();

    public String listarChamados() throws Exception {

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/chamados")).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }

    public String listarMeusChamados(int idSuporte) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "http://localhost:8080/chamados/suporte/" + idSuporte
                ))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "Erro ao listar meus chamados: " + response.statusCode()
            );
        }

        return response.body();
    }

    public String listarMensagens(int idChamado) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/mensagens-suporte/chamado/" + idChamado))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public void marcarMensagensComoLidas(int idChamado, int idUsuario) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "http://localhost:8080/mensagens-suporte/chamado/"
                        + idChamado + "/lidas?idUsuario=" + idUsuario)).PUT(HttpRequest.BodyPublishers.noBody()).build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new RuntimeException(
                    "Erro ao marcar mensagens como lidas: "
                    + response.statusCode()
            );
        }
    }

    public void encerrarChamado(int idChamado, String solucao) throws Exception {

        JsonObject json = new JsonObject();
        json.addProperty("solucao", solucao);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "http://localhost:8080/chamados/"
                        + idChamado + "/encerrar"
                ))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new RuntimeException(
                    "Erro ao encerrar chamado: " + response.statusCode()
            );
        }
    }

    public static void main(String[] args) {
        try {
            ApiClient api = new ApiClient();
            System.out.println(api.listarChamados());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HttpResponse<String> cadastrarSuporte(String nome, String cpf, String email, String telefone, String senha, String dataNasc, String rua, String numero, String complemento, String bairro, String cidade, String estado, String cep) throws Exception {
        JsonObject json = new JsonObject();

        json.addProperty("nome", nome);
        json.addProperty("cpf", cpf);
        json.addProperty("email", email);
        json.addProperty("telefone", telefone);
        json.addProperty("senha", senha);
        json.addProperty("dataNasc", dataNasc);
        json.addProperty("rua", rua);
        json.addProperty("numeroCasa", numero);
        json.addProperty("complemento", complemento);
        json.addProperty("bairro", bairro);
        json.addProperty("cidade", cidade);
        json.addProperty("estado", estado);
        json.addProperty("cep", cep);

        // monto a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/usuarios/suporte"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString());

        return response;
    }

    public HttpResponse<String> login(String email, String senha) throws Exception {

        JsonObject json = new JsonObject();

        json.addProperty("login", email);
        json.addProperty("senha", senha);
        // monto a requisição
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/auth/login")).header("Content-type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json.toString())).build();

        //envio da requisição
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    public void assumirChamado(int idChamado, int idSuporte) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "http://localhost:8080/chamados/"
                        + idChamado + "/assumir?idSuporte=" + idSuporte
                ))
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new RuntimeException(
                    "Erro ao assumir chamado: " + response.statusCode()
            );
        }
    }

    public String buscarPerfilSuporte(int idUsuario) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "http://localhost:8080/usuarios/suporte/" + idUsuario
                ))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "Erro ao buscar perfil: " + response.statusCode()
            );
        }

        return response.body();
    }

    public void atualizarPerfilSuporte(
            int idUsuario, JsonObject dados) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "http://localhost:8080/usuarios/suporte/" + idUsuario
                ))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(dados.toString()))
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 204) {
            throw new RuntimeException(
                    "Erro ao atualizar perfil: "
                    + response.statusCode()
                    + " - " + response.body()
            );
        }
    }

    public void alterarSenha(
            int idUsuario,
            String senhaAtual,
            String novaSenha) throws Exception {

        JsonObject dados = new JsonObject();

        dados.addProperty("senhaAtual", senhaAtual);
        dados.addProperty("novaSenha", novaSenha);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "http://localhost:8080/usuarios/suporte/"
                        + idUsuario + "/senha"
                ))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(dados.toString()))
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 204) {
            throw new RuntimeException(
                    "Erro ao alterar senha: "
                    + response.statusCode()
                    + " - " + response.body()
            );
        }
    }

}
