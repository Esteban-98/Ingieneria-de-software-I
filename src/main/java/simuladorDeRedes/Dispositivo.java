package simuladorDeRedes;

import java.util.ArrayList;
/**
 * Clase el la cual sus metodos reciben mensajes y les proporcionan un Identificador
 * (Si ese mensaje no a sido recibido anteriormente)
 * Ademas lo envia a su canal vinculado
 * @author Grupo5
 * @author Brayan Bejarano
 * @author Camilo Diaz
 * @author David Gallego
 * @author Santiago Valera
 *
 */
public class Dispositivo {

	protected String identificadorDispositivo;
	protected ArrayList<Canal> canales = new ArrayList<Canal>();
	protected ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		
	
	
	/**
	 * Constructor
	 * @param identificadorDispositivo String
	 */
	public Dispositivo(String identificadorDispositivo) {
		super();
		this.identificadorDispositivo = identificadorDispositivo;
	}



	/**
	 * GETTER de identificadorDispositivo
	 * @return identificadorDispositivo String 
	 */
	public String getIdentificadorDispositivo() {
		return identificadorDispositivo;
	}
	/**
	 * SETTER de indetificadorDispositivo
	 * @param identificadorDispositivo String
	 */
	public void setIdentificadorDispositivo(String identificadorDispositivo) {
		this.identificadorDispositivo = identificadorDispositivo;
	}
	/**
	 * GETTER de ArrayList canales
	 * @return ArrayList Canal
	 */
	public ArrayList<Canal> getCanales() {
		return canales;
	}
	/**
	 * SETTER de ArrayList canales
	 * @param canales Canal
	 */
	public void setCanales(Canal canales) {
		this.canales.add(canales);
	}







	/**
	 * Metodo que recibe objetos mensaje de un canal vinculado
	 * @param mensaje Mensaje
	 */
	public void recibirMensaje(Mensaje mensaje){//Mensaje enviado desde un canal
		mensaje.setRecorridoDispositivos(this.identificadorDispositivo);
	
		enviarMensaje(mensaje);
	}
	
	/**
	 * Metodo que envia un objeto mensaje a un canal vinculado
	 * (si este objeto no a sido enviado anteriormente)
	 * @param mensaje Mensaje
	 */
	public void enviarMensaje(Mensaje mensaje) {
		boolean b = true;
		for(Mensaje m: this.mensajes) {
			//if que verifica si el mensaje del argumento ya habia sido mandado con el mismo contenido y con el mismo origen
			if(m.getContenido().equals(mensaje.getContenido()) && m.getOrigen().equals(mensaje.getOrigen())&&m.getDestino().equals(mensaje.getDestino())) {
				b = false;
				
			}
			if(!b) {
				System.out.println("El mensaje ha sido repetido, "+this.identificadorDispositivo+" no tiene permitido enviar mensajes repetidos");
			}
		}
		
		this.mensajes.add(mensaje);
		
		if(b){
		for(Canal c: this.canales) {//bloque de codigo que envia el mensaje a todos los canales vinculados con este dispositivo
			boolean encontrar = false;
			
				for(String m: mensaje.getRecorridoCanales()) {
					if(c.getIdentificadorCanalAleatorio()== m) {
						encontrar = true;
					}
				}
				if(!encontrar) {
					c.recibirMensaje(mensaje);
				}
			}
		}
	}
}
