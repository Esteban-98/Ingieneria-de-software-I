package simuladorDeRedes;

import java.util.Random;
/**
 * Clase en la cual sus metodos generan mensajes y los recepcionan
 * 
 * @author Grupo5
 * @author Brayan Bejarano
 * @author Camilo Diaz
 * @author David Gallego
 * @author Santiago Valera
 */
public class Computador {
	private String direccionDeRed;
	private Canal canal;
	
	/**
	 * Cosntructor 
	 * @param direccionDeRed String 
	 */
	public Computador(String direccionDeRed) {
		super();
		this.direccionDeRed = direccionDeRed;
	}
	/**
	 * GETTER de canal
	 * @return canal Canal
	 */
	public Canal getCanal() {
		return canal;
	}
	/**
	 * SETTER de canal
	 * @param canal Canal
	 */
	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	/**
	 * SETTER de direccionDeRed
	 * @param direccionDeRed String
	 */
	public void setDireccionDeRed(String direccionDeRed) {
		this.direccionDeRed = direccionDeRed;
	}
	/**
	 * GETTER de direccionDeRed
	 * @return direccionDeRed String 
	 */
	public String getDireccionDeRed() {
		return direccionDeRed;
	}
	//Fin de Getters y Setters
	/**
	 * Metodo que genera el mensaje y lo envia segun el parametro del usuario
	 * @param contenido String definido por el usuario
	 * @param destino String definido por el usuario
	 */
	public void enviarMensaje(String contenido, String destino) {//un computador crea el mensaje y se lo pasa al metodo enviar mensaje
		Mensaje mensajeAEnviar = new Mensaje();
		
		mensajeAEnviar.setIdentificadorUnicoAleatorio(numeroAleatorio());
		mensajeAEnviar.setOrigen(this.direccionDeRed);;
		mensajeAEnviar.setDestino(destino);
		mensajeAEnviar.setContenido(contenido);
		
		System.out.println("\nMensaje enviado por computador con IP "+this.direccionDeRed+"\n");
		System.out.println("Con destino al computador con IP "+destino+"\n");
		System.out.println("Contenido del mensaje: "+contenido+"\n\n\n");
		
		this.canal.recibirMensaje(mensajeAEnviar);	
	}
	
	/**
	 * Metodo, que recibe como parametro un objeto mensaje y lo imprime en pantalla 
	 * (si es un mensaje publico = * o va dirigido a su IP)
	 * @param mensaje Mensaje
	 */
	
	public void recibirMensaje(Mensaje mensaje) {//metodo que recibe un mensaje de(uno solo) this.canal
		
		if(mensaje != null)//if que evita excepciones de la clase NullPointerException
		{	
			if(mensaje.getDestino().equals(this.direccionDeRed) || mensaje.getDestino().equals("*")){
				System.out.println("Mensaje recibido por computador con IP "+this.direccionDeRed+"\n");
				System.out.println("El mensaje lo envió el computador con IP "+mensaje.getOrigen()+"\n");
				
				//Bloque de codigo que guarda el recorrido del mensaje en orden y con comas por los dispositivos
				String aux; 
				if(mensaje.getRecorridoDispositivos().size() != 0) {
					aux = mensaje.getRecorridoDispositivos().get(0);
					for(int i=1;i<mensaje.getRecorridoDispositivos().size();i++) {//no cambiar a un for mejorado ya que i no inicia en cero sino en 1
						aux=aux+", "+mensaje.getRecorridoDispositivos().get(i);
					}
				}else {
					aux = "Este mensaje no paso por dispositivos";
				}
				
				System.out.println("El mensaje pasó por los siguientes dispositivos: "+aux+"; tiempo total del envío del mensaje:  "+mensaje.getTiempoDeEntrega()+" segundos"+"\n");
				System.out.println("Contenido del mensaje: "+mensaje.getContenido()+"\n\n");
			}
		}
	}
	
	/**
	 * Metodo estatico que genera un numero aleatorio de 6 cifras
	 * @return numAl String 
	 */
	public static String numeroAleatorio() 
	{
		Random r = new Random();
		String numAl;
		
		numAl = Integer.toString(r.nextInt(10))+Integer.toString(r.nextInt(10))+Integer.toString(r.nextInt(10))+Integer.toString(r.nextInt(10))+Integer.toString(r.nextInt(10))+Integer.toString(r.nextInt(10));
		return numAl;
	}
}
