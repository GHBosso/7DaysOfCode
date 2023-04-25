import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Properties;

public class App {
	
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("./properties/dados.properties");
		prop.load(file);
		String url = prop.getProperty("prop.url");
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create(url))
		      .GET()
		      .build();
		client.sendAsync(request, BodyHandlers.ofString())
		      .thenApply(HttpResponse::body)
		      .thenAccept(System.out::println)
		      .join();
	}
}
