package api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class ApiClient {
   
    private final HttpClient client = HttpClient.newHttpClient();
    
    public String listarChamados() throws Exception{
        
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/chamados")).GET().build();
        
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        
        return response.body();
              
    }
    public String listarMensagens(int idChamado) throws Exception {

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/mensagens-suporte/chamado/" + idChamado))
            .GET()
            .build();

    HttpResponse<String> response = client.send(
            request,
            HttpResponse.BodyHandlers.ofString()
    );

    return response.body();
}
    
    
    
public static void main(String[] args) {
    try {
        ApiClient api = new ApiClient();
        System.out.println(api.listarChamados());
    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
