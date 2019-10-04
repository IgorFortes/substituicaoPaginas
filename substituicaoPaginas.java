import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class substituicaoPaginas {

	private int numeroErros;
 	private int numeroQuadros;
 	ArrayList<Entradas> particoesEntrada;

 	public substituicaoPaginas(int numeroQuadros
	){
 		this.numeroQuadros = numeroQuadros;
 		numeroErros = 0;
 	}

 	public void FIFO(List<Entradas> lista){

 		int INSERIR = 0;
		this.particoesEntrada = new ArrayList<>();
		
	  	for(int i = 0; i < lista.size(); i++){ 
	  		
	  		Entradas numeroPagina = lista.get(i);

	  		if (!particoesEntrada.contains(numeroPagina)) {
	   			if (particoesEntrada.size() < numeroQuadros) {
	    				particoesEntrada.add(numeroPagina);
	    				numeroErros++;
	    				continue;
	   			} else {
	    				particoesEntrada.remove(INSERIR);
	    				particoesEntrada.add(INSERIR, numeroPagina);
	    				INSERIR++;
	    				numeroErros++;
			    		if (INSERIR == numeroQuadros) {
			     			INSERIR = 0;
			    		}
	   			}
	   		}	
	    }

	    System.out.println("FIFO " + numeroErros);
	}

	public void OTM (List<Entradas> lista){

		int BASE  	   	= 0;
		int max_index  	= 0;		
		int j 		   	= 0;
		int tamanho    	= lista.size();
		int frame_index	= 0;

		Entradas valor;
		particoesEntrada = new ArrayList<>();
		
		for(int i = 0; i < tamanho; i++){
			Entradas numeroPaginas = lista.get(0);
			lista.remove(BASE);
			
			if(particoesEntrada.size() < numeroQuadros){
				particoesEntrada.add(numeroPaginas);
				numeroErros++;
				continue;
			}
			
			if(particoesEntrada.contains(numeroPaginas)){
				continue;
			}
			
			max_index = -1;
			
			for(j = 0; j < particoesEntrada.size(); j++){
				if(lista.indexOf(particoesEntrada.get(j)) == -1){
					frame_index = j;
					break;
				}
				if(lista.indexOf(particoesEntrada.get(j)) > max_index){
					frame_index = j;
					max_index = lista.indexOf(particoesEntrada.get(j));
				}
			}
			particoesEntrada.set(frame_index, numeroPaginas);
			numeroErros++;
		}
		System.out.println("OTM " + numeroErros);
	}

	public void LRU(List<Entradas> lista){

		boolean aux = false;
		ArrayList<Entradas> pilhaDeEntradas = new ArrayList<>(numeroQuadros);
		final int BASE = numeroQuadros -1;
		final int TOPO = 0;
		
		for (Entradas entrada : lista) {
			aux = false;
			for (Entradas quadro : pilhaDeEntradas) {
				if (quadro.getValor() == entrada.getValor()){
					pilhaDeEntradas.remove(quadro);
					pilhaDeEntradas.add(TOPO,entrada);
					aux = true;
					break;
				}
			}
			
			if(!aux){
				if (pilhaDeEntradas.size() != numeroQuadros){
					numeroErros++;
					pilhaDeEntradas.add(TOPO,entrada);
				} else {
					numeroErros++;
					pilhaDeEntradas.remove(BASE);
					pilhaDeEntradas.add(TOPO,entrada);
				}
			}
		}
		System.out.println("LRU " + numeroErros);
	}
	
	public void printList(List<Entradas> lista){
		
		if(lista.isEmpty()){
			System.out.println("A lista está vazia");
		}
		for (Entradas entrada : lista) {
			System.out.println(entrada.getValor()+" ");
		}
	}
}
