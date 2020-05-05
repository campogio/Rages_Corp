package bevandecorporation;

import java.sql.SQLException;
import java.util.ArrayList;

public class Amministratore {

	public int id;
	public String nome;
	public String password;
	static ConnessioneMySql connessione;

	public Amministratore(String nome, String password) {

	}

	
	// TEST MAIN

	public static void CreaOperatore(String nome, String password) throws SQLException {

		new Operatore(nome, password);
		connessione.ManipolaData(
				"INSERT INTO operatore(NomeOperatore,Password,OperatoreOccupato,Amministratore_idAmministratore)"
						+ "VALUES('" + nome + "','" + password + "',0,1)");
// NON COMPLETO ------------------------------------------------------------------------

	}

	public static void ModificaOperatore(String nome, String newnome, String password) throws SQLException {
		connessione.ManipolaData("UPDATE operatore SET nomeoperatore = '" + newnome + "',password = '" + password
				+ "' WHERE nomeoperatore = '" + nome + "';");
	}

	public static void EliminaOperatore(String nome) throws SQLException {
		connessione.ManipolaData("DELETE FROM operatore WHERE Nomeoperatore='" + nome + "';");
	}

	public static void CreaBevanda(String nome, int qta, int eusarimento) throws SQLException {
		connessione.ManipolaData("INSERT INTO bevanda(Nomebevanda,NumeroDisponibile,NumeroEusarimento)" + "VALUES('"
				+ nome + "'," + qta + "," + eusarimento + ")");
	}

	public static void ModificaBevandaNome(String nome, String newnome) throws SQLException {
		connessione
				.ManipolaData("UPDATE bevanda SET nomebevanda = '" + newnome + "' WHERE nomebevanda = '" + nome + "';");

	}

	public void ModificaBevandaNumero(String nome, int numero) throws SQLException {
		connessione.ManipolaData(
				"UPDATE bevanda SET numerodisponibile = '" + numero + "' WHERE nomebevanda = '" + nome + "';");
	}

	public void ModificaBevandaLimite(String nome, int limite) throws SQLException {
		connessione.ManipolaData(
				"UPDATE bevanda SET numeroeusarimento = '" + limite + "' WHERE nomebevanda = '" + nome + "';");

	}

	public static void EliminaBevanda(String nome) throws SQLException {
		connessione.ManipolaData("DELETE FROM bevanda WHERE Nomebevanda='" + nome + "';");
	}

	public static void AssegnaOrdine(int idOrdine, String nome) throws SQLException {

		connessione.ManipolaData("UPDATE operatore SET operatoreOccupato = 1 WHERE nomeoperatore = '" + nome + "';");

		String idOperatore = connessione.RichiestaDataString(
				"SELECT idOperatore FROM operatore where nomeoperatore= '" + nome + "';", "idOperatore");

		connessione.ManipolaData("UPDATE ordine SET operatore_IdOperatore = " + idOperatore
				+ ", OrdineAttuale = 1 WHERE idOrdine = " + idOrdine + ";");

		// EXPERIMENTAL

	}

	public static void CreaOrdine(String nome, ArrayList<String> nomi, ArrayList<Integer> qta) throws SQLException {

		connessione.ManipolaData("INSERT INTO ordine(nomeOrdine) VALUES('" + nome + "')");
		String idOrdine = connessione
				.RichiestaDataString("SELECT idOrdine FROM Ordine WHERE nomeOrdine ='" + nome + "'", "idOrdine");
		System.out.println(idOrdine);

		if (nomi.size() != qta.size()) {
			// Esci un errore
		} else {
			int size = nomi.size();
			String idattuale;
			for (int i = 0; i < size; i++) {
				idattuale = connessione.RichiestaDataString(
						"SELECT idTipoBevanda FROM Bevanda WHERE nomebevanda = '" + nomi.get(i) + "'", "idTipoBevanda");
				connessione
						.ManipolaData("INSERT INTO Bevanda_has_Ordine(Bevanda_idBevanda,Ordine_idOrdine,NumeroBevande)"
								+ "VALUES(" + idattuale + "," + idOrdine + "," + qta.get(i) + ")");

				// RICORDA DI UPDATARE IL NUMERO DI BEVANDE AGGIUNTE ALL ORDINE TOGLIENDOLE
				// DALLO STOCK
			}
		}

	}

	public static ArrayList bevandeInEsaurimento() throws SQLException {
		ArrayList<String> array = new ArrayList<String>();

		array = connessione.RichiestaData("SELECT nomebevanda FROM bevanda WHERE numerodisponibile < numeroeusarimento","nomebevanda");

		return array;

	}

}
