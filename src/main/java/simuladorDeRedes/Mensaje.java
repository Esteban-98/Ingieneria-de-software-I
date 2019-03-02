package simuladorDeRedes;

import java.util.ArrayList;
/**
 * Clase dependiente, que recorre computador, dispositivo y canal
 * [Sus instacias las generan clase distintas a la Principal(Metodo Main)]
* @author Grupo5
 * @author Brayan Bejarano
 * @author Camilo Diaz
 * @author David Gallego
 * @author Santiago Valera
 *
 */
public class Mensaje {
	
	private String identificadorUnicoAleatorio;
	private String origen;
	private String destino;
	private String contenido;
	private int tiempoDeEntrega=0;
	private ArrayList<String> recorridoDispositivos = new ArrayList<String>();
	private ArrayList<String> recorridoCanales = new ArrayList<String>();
	/**
	 * GETTER de identificadorUnicoAleatorio
	 * @return identificadorUnicoAleatorio String
	 */
	public String getIdentificadorUnicoAleatorio() {
		return identificadorUnicoAleatorio;
	}
	/**
	 * SETTER de identificadorUnicoAleatorio
	 * @param identificadorUnicoAleatorio String
	 */
	public void setIdentificadorUnicoAleatorio(String identificadorUnicoAleatorio) {
		this.identificadorUnicoAleatorio = identificadorUnicoAleatorio;
	}
	/**
	 * GETTER de origen
	 * @return origen String
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * SETTER de origen
	 * @param origen String 
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * GETTER de destino
	 * @return destino String
	 */
	public String getDestino() {
		return destino;
	}
	/**
	 * SETTER de destino
	 * @param destino String 
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	/**
	 * GETTER de  contenido
	 * @return contenido String
	 */
	public String getContenido() {
		return contenido;
	}
	/**
	 * SETTER de contenido
	 * @param mensaje String
	 */
	public void setContenido(String mensaje) {
		this.contenido = mensaje;
	}
	/**
	 * GETTER de tiempoDeEntrega
	 * @return tiempoDeEntrega int
	 */
	public int getTiempoDeEntrega() {
		return tiempoDeEntrega;
	}
	/**
	 * SETTER de tiempoDeEntrega
	 * @param tiempoDeEntrega int
	 */
	public void setTiempoDeEntrega(int tiempoDeEntrega) {
		this.tiempoDeEntrega = tiempoDeEntrega;
	}
	/**
	 * GETTER de ArrayList recorridoDispositivos
	 * @return ArrayList recorridoDispositivos
	 */
	
	public ArrayList<String> getRecorridoDispositivos() {
		return recorridoDispositivos;
	}
	/**
	 * SETTER del ArrayList recorridoDispositivos
	 * @param idDispositivo ArrayList String
	 */
	public void setRecorridoDispositivos(String idDispositivo) {
		this.recorridoDispositivos.add(idDispositivo);
	}
	
	/**
	 * GETTER de ArrayList recorridoCanales
	 * @return ArrayList recorridoCanales
	 */
	public ArrayList<String> getRecorridoCanales() {
		return recorridoCanales;
	}
	/**
	 * SETTER de ArrayList recorridoCanales
	 * @param ultimoCanalVisitado ArrayList String
	 */
	public void setRecorridoCanales(String ultimoCanalVisitado) {
		this.recorridoCanales.add(ultimoCanalVisitado);
	}
	
	
	
	
	
	
	
	
	
	
	
}
