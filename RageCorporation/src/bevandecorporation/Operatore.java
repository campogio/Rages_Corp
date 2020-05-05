package bevandecorporation;

import java.sql.SQLException;
import java.util.ArrayList;

public class Operatore {

	public int idAmministratore;
	static ConnessioneMySql connessione;
	public int id;
	public String nome = "";
	public String password = "";
	public boolean occupato = false;
	
	
	
	//TEST MAIN

	public Operatore(String nome, String password) {

	}

	public float valOccupato() {
		float occupanza = 0;

		return occupanza;

	}

	public boolean getOccupato() {
		return this.occupato;
	}

	public void setOccupato() {

	}

	public int getID() {

		return 0; ////////
	}
	
	/*
	 * 
	 * 
	 */
	
	public static int getIdOrdineAssegnato() throws SQLException {
		String result;
		
		result= connessione.RichiestaDataString("SELECT idOrdine FROM Ordine WHERE Operatore_idOperatore =2   AND OrdineAttuale = 1", "idOrdine");
		
		
		return Integer.parseInt(result);
	}/*
	
	IMPORTANTE^^^^^^^^^^^^^^^^  INSERIRE IL VERO ID OPERATORE    ^^^^^^^^^^^^^^^^^^^^^^^
	
	*/
	
	public static ArrayList getStoricoIdOrdine() throws SQLException {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ArrayList<String> result = new ArrayList<String>();
		
		result= connessione.RichiestaData("SELECT idOrdine FROM Ordine WHERE Operatore_idOperatore =2   AND OrdineAttuale = 0", "idOrdine");
		
		for(int i=0;i<result.size();i++) {
			ids.add(Integer.parseInt(result.get(i)));
			System.out.println(ids.get(i));
		}
		
		return ids;
	} /*
	
	IMPORTANTE^^^^^^^^^^^^^^^^  INSERIRE IL VERO ID OPERATORE    ^^^^^^^^^^^^^^^^^^^^^^^
	
	*/
	
	public static void cambiaStatoOrdine(int statoOrdine) throws SQLException {
		
		connessione.ManipolaData("UPDATE ordine SET StatoOrdine = "+statoOrdine+" Where idOrdine = "+getIdOrdineAssegnato());
		
	}
	
	

}
