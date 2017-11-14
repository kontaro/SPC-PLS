import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class listaComuna {
	ArrayList<comuna> listaComunas=new ArrayList<comuna>();
	
	public ArrayList<Integer> cobertura(){
		ArrayList<Integer> ret=new ArrayList<Integer>();
		for(comuna item:listaComunas){
			ArrayList<Integer> cob= item.getCobertura();
			for(int i=0; i<cob.size();i++){
				ret.add(cob.get(i));
			}
		}
		return ret;
	}
	
	public void readTxt(){
	    try {
	        //ruta de tu archivo;
	        String ruta = "matriz.txt";
	        BufferedReader br = getBuffered(ruta);
	        //leemos la primera linea
	        String linea =  br.readLine();
	        //creamos la matriz vacia
	        String[] IDs = linea.split(",");
	        
	        //contador
	        int contador = 0;
	        while(linea != null){
	        	comuna nueva=new comuna();
	        	String[] values = linea.split(",");
	            //recorremos el arrar de string
	            for (int i = 1; i<values.length; i++) {
	                IDs[i]
	                
	            }
	            contador++;
	            linea = br.readLine();
	        }
	    } catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
	}
	
	 public BufferedReader getBuffered(String link){

		    FileReader lector  = null;
		    BufferedReader br = null;
		    try {
		         File Arch=new File(link);
		        if(!Arch.exists()){
		           System.out.println("No existe el archivo");
		        }else{
		           lector = new FileReader(link);	
		           br = new BufferedReader(lector);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return br;
		}
	
	
}
