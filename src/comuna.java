import java.util.ArrayList;

public class comuna {

	private int ID;
	private float cost1;
	private float cost2;
	private ArrayList<Integer>cobertura= new ArrayList<Integer>();
	
	
	public comuna(){
		
	}
	public comuna(int ID,float cost1,float cost2){
		this.ID=ID;
		this.cost1=cost1;
		this.cost2=cost2;
		
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public float getCost1() {
		return cost1;
	}


	public void setCost1(int cost1) {
		this.cost1 = cost1;
	}


	public float getCost2() {
		return cost2;
	}


	public void setCost2(int cost2) {
		this.cost2 = cost2;
	}


	public void  addCobertura(int id) {
		cobertura.add(id);
		
	}

	public ArrayList<Integer> getCobertura() {
		return this.cobertura;
	}

	public void setCobertura(ArrayList<Integer> cobertura) {
		this.cobertura = cobertura;
	}
	
}
