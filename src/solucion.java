import java.util.Random;

public class solucion {
	listaComuna componentes=new listaComuna();
	listaComuna comunasRegion=new listaComuna();
	solucion(listaComuna comunas){
		this.comunasRegion=comunas;
		randomSolution(comunas);
	}
	solucion(solucion actual,listaComuna comunas){
		this.comunasRegion=comunas;
		for(int i=0;i<actual.componentes.size();i++){
			componentes.addComuna(comunasRegion.getComunID(actual.componentes.listaComunas.get(i).getID()));
			
		}
	}
	
	
	public void randomSolution(listaComuna comunas){
		comuna nueva=new comuna();
		while(componentes.cobertura().size()<comunasRegion.size()){
			
			nueva=addComunaAzar();
			if(componentes.getArray().contains(nueva)){}
			else{ componentes.addComuna(nueva);}
		}
		
	}
	public comuna addComunaAzar(){
		Random azar=new Random();
		
		int index=(int)(azar.nextDouble() *comunasRegion.size()  );
		return getComuna(index);
	}
	public comuna getComuna(int index){
		
		return comunasRegion.getComuna(index);
	}
	
	public void movimiento(){
		Random azar=new Random();

		int index=(int)(azar.nextDouble() *componentes.size()  );
		int flag =1;
;
		componentes.removeComuna(getComuna(index));
		if(componentes.cobertura().size()==comunasRegion.size()){
			flag=0;
		}
		comuna nueva=new comuna();
		
		while(flag ==1){
			
			nueva=addComunaAzar();
			if(componentes.getArray().contains(nueva)){
				flag=1;
			}
			else{ 
				componentes.addComuna(nueva);
				flag=0;
			}
		}
		
	}
	
	public float fitnessCostOne(){

		return componentes.fitnessCostOne();
	}
	public float fitnessCostTwo(){
		return componentes.fitnessCostTwo();
	}
	public void generarSolucionRandom(){
		
	}

}
