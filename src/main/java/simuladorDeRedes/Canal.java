package simuladorDeRedes;

import java.util.ArrayList;
/**
 * Clase que sirve como mediador entre computador y computador(Contando con una vinculacion 
 * con los dispositivos)
 * @author Grupo5
 * @author Brayan Bejarano
 * @author Camilo Diaz
 * @author David Gallego
 * @author Santiago Valera
 */
public class Canal {

		private String identificadorCanalAleatorio;
		private ArrayList<Computador> computadores = new ArrayList<Computador>();
		private ArrayList<Dispositivo> dispositivos=new ArrayList<Dispositivo>();
		
		
		/**
		 * Constructor Clase
		 * @param identificadorCanalAleatorio String
		 */
		public Canal(String identificadorCanalAleatorio) {
			super();
			this.identificadorCanalAleatorio = identificadorCanalAleatorio;
		}
		
		
		
		/**
		 * GETTER de identificadorCanalAleatorio
		 * @return String indentificadorCanalAleatorio
		 */
		public String getIdentificadorCanalAleatorio() {
			return identificadorCanalAleatorio;
		}
		/**
		 * SETTER de identificadorCanalAleatorio
		 * @param identificadorCanalAleatorio String
		 */
		public void setIdentificadorCanalAleatorio(String identificadorCanalAleatorio) {
			
			this.identificadorCanalAleatorio = identificadorCanalAleatorio;
		}
		//compu
		/**GETTER de ArrayList computadores
		 * @return ArrayList Computador
		 */
		public ArrayList<Computador> getComputadores() {
			return computadores;
		}
		/**
		 * SETTER de ArrayList computadores
		 * @param computadores Computador
		 */
		public void setComputadores(Computador computadores) {
			this.computadores.add(computadores);
		}
	
		//fin compu
		
		//DIS
		/**
		 * GETTER de ArrayList dispositivos
		 * @return ArrayList Dispositivo
		 */
		public ArrayList<Dispositivo> getDispositivos() {
			return dispositivos;
		}
		/**
		 * SETTER de ArrayList dispositivos
		 * @param dispositivos Dispositivo
		 */
		public void setDispositivos(Dispositivo dispositivos) {
			this.dispositivos.add(dispositivos);
		}
		
		//fin DIS
		/**
		 * Metodo que recibe mensaje desde un objeto Dispositivo o Computador
		 * @param mensaje Mensaje
		 */
		public void recibirMensaje(Mensaje mensaje) {
			mensaje.setRecorridoCanales(this.identificadorCanalAleatorio);//mensaje registra que paso por este canal
			
			enviarMensaje(mensaje);
		}
		/**
		 * Metodo que envia un objeto mensaje a las clases computadores y dispositivo
		 * (Excepcion a dispositivo o computador de origen) 
		 * @param mensaje Mensaje
		 */
		private void enviarMensaje(Mensaje mensaje){
			//Canal envia el mensaje a sus computadores
			if(computadores != null){
				for(Computador c: computadores) {	
					if(c.getDireccionDeRed()!= mensaje.getOrigen()) {
						c.recibirMensaje(mensaje);
					}
				}
			}
			//FIN Canal envia el mensaje a sus computadores
			
			
			
			
			//Canal envia el mensaje a sus dispositivos
			for(Dispositivo d: dispositivos) {
				boolean encontrar = false;
				
				if(mensaje.getRecorridoDispositivos().size()!= 0) {
					for(String m: mensaje.getRecorridoDispositivos()){
						if(d.getIdentificadorDispositivo() == m) {
							encontrar = true;
						}
					}
					
					if(!encontrar) {
						d.recibirMensaje(mensaje);
					}
				}
				else {
					d.recibirMensaje(mensaje);
				}
			}
			//FIN Canal envia el mensaje a sus dispositivos
		}
}
