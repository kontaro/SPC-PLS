import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class listaComuna {
	public ArrayList<comuna> listaComunas=new ArrayList<comuna>();
	
	public ArrayList<Integer> cobertura(){
		ArrayList<Integer> ret=new ArrayList<Integer>();
		for(comuna item:listaComunas){
			ArrayList<Integer> cob= item.getCobertura();
			for(int i=0; i<cob.size();i++){
				if(ret.contains(cob.get(i))){}
				else{
					ret.add(cob.get(i));
			
				}
			}
		}
		return ret;
	}
	
	public void readTxt(){
	    try {
	        //ruta de tu archivo;
	        
	        BufferedReader br = getBuffered("matriz_covertura.txt");
	        BufferedReader brCosto = getBuffered("id_costo.txt");
	        String lineacosto=brCosto.readLine();
	        lineacosto=brCosto.readLine();
	        //leemos la primera linea
	        String linea =  br.readLine();
	        //creamos la matriz vacia
	        String[] IDs = linea.split(",");
	        linea = br.readLine();
	        
	        //contador
	        int contador = 0;
	        
	        while(linea != null){
	        	
	        	String[] valuesCosto = lineacosto.split(";");
	        	//System.out.println(lineacosto.split(";")[0]);
	        	comuna nueva=new comuna(Integer.parseInt(valuesCosto[0]),Float.parseFloat(valuesCosto[1]),Float.parseFloat(valuesCosto[2]));
	        	String[] values = linea.split(",");
	        	//System.out.println(linea);
	            //recorremos el arrar de string
	            for (int i = 1; i<values.length; i++) {
	                if(Integer.parseInt(values[i])==1){
	                	nueva.addCobertura(Integer.parseInt(IDs[i]));
	                }
	            	
	                
	            }
	            contador++;
	            linea = br.readLine();
	            lineacosto=brCosto.readLine();
	            listaComunas.add(nueva);
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
	 
	 public ArrayList<comuna> getArray(){
		 return listaComunas;
		 
	 }
	 
	 
	 public comuna getComuna(int index){
		 return listaComunas.get(index);
	 }
	 public comuna getComunID(int id){
		 for(int i=0;i<listaComunas.size();i++){
			 if(listaComunas.get(i).getID()==id)return listaComunas.get(i);
		 }
		 return null;
	 }
	 public int size(){
		 return listaComunas.size();
	 }
	 public void addComuna(comuna e){
		 listaComunas.add(e);
	 }
	 public void removeComuna(comuna e){
		 listaComunas.remove(e);
	 }
	 public float fitnessCostOne(){
		float suma=0;
		for(comuna item:listaComunas){
			suma=suma+item.getCost1();
		}
		return suma;
	}
	public float fitnessCostTwo(){
		float suma=0;
		for(comuna item:listaComunas){
			suma=suma+item.getCost2();
		}
		return suma;
	}
	
}
