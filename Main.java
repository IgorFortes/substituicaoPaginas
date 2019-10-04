import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
	public static void main(String[] args){
		int numeroDeQuadros = 0;
		List<Entradas> sequencial = new ArrayList<>();
		List<Entradas> sequencial_otm = new ArrayList<>();

		try {
		    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		    String valor;
		    numeroDeQuadros = Integer.parseInt(entrada.readLine());
			
		    while( (valor = entrada.readLine()) != null ) {
				  sequencial.add(new Entradas(Integer.parseInt(valor)));
		    }

		} catch (IOException e) {
		    e.getMessage();
		}
	
		for(int i = 0; i < sequencial.size() ; i++){
			sequencial_otm.add(sequencial.get(i));
		}

		substituicaoPaginas fifo = new substituicaoPaginas(numeroDeQuadros);
		substituicaoPaginas otm  = new substituicaoPaginas(numeroDeQuadros);
		substituicaoPaginas lru  = new substituicaoPaginas(numeroDeQuadros);

		fifo.FIFO(sequencial);
		otm.OTM(sequencial_otm);
		lru.LRU(sequencial);
	}
}


