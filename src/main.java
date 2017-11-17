import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		int iter=1000;
		int vecindad=150;
		int contador=0;
		// TODO Auto-generated method stub
		listaComuna lista=new listaComuna();
		lista.readTxt();
		
		
		solucion actual=new solucion(lista);
		actual.movimiento();

		
		
		ArrayList<solucion> frontera=new ArrayList();
		
		frontera.add(actual);
		int tamano=0;
		while(contador<iter){
			tamano=frontera.size();
			for(int i=0;i<tamano;i++){
				actual=frontera.get(i);
				ArrayList<solucion> vecindadActual=crearVecindad(actual,vecindad,lista);
				for(int j=0;j<vecindadActual.size();j++)frontera.add(vecindadActual.get(j));
				
				
			}
			frontera=nonDominated(frontera);		
			contador++;
		}
		for(int i=0;i<frontera.size();i++){
			
			System.out.println(frontera.get(i).fitnessCostOne()+" "+frontera.get(i).fitnessCostTwo());
			}
		
		//lista fronteraPareto
		//lista auxiliar
		//generamos solucion random
		//generamos vecino
		//se buscan los no dominado y se agregan a la frontera
		//mientras se pueda
		//auxiliar= por cada no dominado generar vecino y sumar
		//buscar no dominancia y agregar a la frontera de pareto
		//devolver cada solucion
		

	}
	public static ArrayList<solucion> crearVecindad(solucion actual,int vecindad,listaComuna listaC){
		ArrayList<solucion> lista=new ArrayList();
		for(int i=0;i<vecindad;i++){
			solucion nuevo=new solucion(actual,listaC);
			
			nuevo.movimiento();
			lista.add(nuevo);
			
		}
		return lista;
	}

	public static ArrayList<solucion> nonDominated(ArrayList<solucion> soluciones){
		ArrayList<solucion> frontera=new ArrayList();
		int flag=0;
		for(int i=0;i<soluciones.size();i++){
			flag=0;
			//System.out.println("badera1-"+flag);
			for(int j=0;j<soluciones.size();j++){
				if(i!=j){				
					if((soluciones.get(i).fitnessCostOne()>soluciones.get(j).fitnessCostOne()&&soluciones.get(i).fitnessCostTwo()>soluciones.get(j).fitnessCostTwo())){
						flag=1;
						break;
					//	System.out.println("entro");
					}
					if((soluciones.get(i).fitnessCostOne()>soluciones.get(j).fitnessCostOne()&&soluciones.get(i).fitnessCostTwo()>=soluciones.get(j).fitnessCostTwo())){
						flag=1;
						break;
					//	System.out.println("entro");
					}
					if((soluciones.get(i).fitnessCostOne()>=soluciones.get(j).fitnessCostOne()&&soluciones.get(i).fitnessCostTwo()>soluciones.get(j).fitnessCostTwo())){
						flag=1;
						break;
					//	System.out.println("entro");
					}
				}
			}

			
			//System.out.println("badera2-"+flag);
			if(flag==0){
				if(!frontera.equals(soluciones.get(i)))
					frontera.add(soluciones.get(i));
			}
			
				
		}
		
		for(int j=0;j<frontera.size();j++){
			for(int k=0;k<frontera.size();k++){
				if(k!=j){
					if(frontera.get(k).fitnessCostOne()==frontera.get(j).fitnessCostOne() && frontera.get(k).fitnessCostTwo()==frontera.get(j).fitnessCostTwo()){
						frontera.remove(k);
						j=0;
						k=0;
					}
				}
			}
		}
		return frontera;
	}
}

