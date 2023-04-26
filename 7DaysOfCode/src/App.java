import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class App {

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("./properties/dados.properties");
		prop.load(file);
		String url = prop.getProperty("prop.url");

		ClienteHttp http = new ClienteHttp();
		String json = http.buscaDados(url);

		ExtratorDeConteudoDoIMDB extrator = new ExtratorDeConteudoDoIMDB();
		List<Conteudo> conteudos = extrator.extraiConteudosIMDB(json);

		for (int i = 0; i < 5; i++) {

			Conteudo conteudo = conteudos.get(i);
			System.out.println(conteudo.getTitulo());
			System.out.println(conteudo.getUrlImagem());
			System.out.println();

		}

	}
}
