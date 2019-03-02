package simuladorDeRedes;
/**
 * Clase que hereda de Dispositivo y tiene metodos
 * que otorgan atribustos a los objetos tipo Dispositivo
 * @author Grupo5
 * @author Brayan Bejarano
 * @author Camilo Diaz
 * @author David Gallego
 * @author Santiago Valera

 */
public class Repeater extends Dispositivo{
	private  String nombre = "Repeater";
	private  int delay = 3;
	
	
	/** 
	 * Constructor Clase
	 * @param identificadorDispositivo String
	 */
	public Repeater(String identificadorDispositivo) {
		super(identificadorDispositivo);
		this.identificadorDispositivo=nombre+this.identificadorDispositivo;
	}
	/**
	 * Metodo que recibe un mensaje y lo envia a un canal vinculado
	 */
	
	
	@Override	
	public void recibirMensaje(Mensaje mensaje){//Mensaje enviado desde un canal
		
		mensaje.setRecorridoDispositivos(this.identificadorDispositivo);
		
		int aux=mensaje.getTiempoDeEntrega();
		mensaje.setTiempoDeEntrega(aux+this.delay);;
		//this.mensaje = mensaje;
		enviarMensaje(mensaje);
	}
}
