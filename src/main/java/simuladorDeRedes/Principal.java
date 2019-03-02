package simuladorDeRedes;

import java.util.Random;
import java.util.Scanner;
/**
 * Metodo principal, en el cual se genere y se prueba las redes
 * 
* @author Grupo5
 * @author Brayan Bejarano
 * @author Camilo Diaz
 * @author David Gallego
 * @author Santiago Varela
 *
 */
public class Principal {
	/**
	 * Metodo que genera un numero aleatorio de 6 cifras
	 * @return numAl string
	 */
	public static String numeroAleatorio() 
	{
		Random r = new Random();
		String numAl;
		
		numAl = Integer.toString(r.nextInt(10))+Integer.toString(r.nextInt(10))+Integer.toString(r.nextInt(10))+Integer.toString(r.nextInt(10))+Integer.toString(r.nextInt(10))+Integer.toString(r.nextInt(10));
		return numAl;
	}
	/**
	 * Metodo que genera un menu principal
	 */
	public static void menu()
	{
		System.out.println("1) Simular RED 1");
		System.out.println("2) Simular RED 2");
		System.out.println("3) Simular RED 3");
		System.out.println("4) Salir");
		System.out.print("Opcion: ");
	}
/**
 * Metodo principal, en el cual se generanla redes y se prueban segun el 
 * criterio del usuario
 * @param args ejecucion del metodo main para iniciacion de las demás clases
 * 
 * se instancian objetos en esta clase acorde a las otras clases
 */
	public static void main( String[] args )
    {
		Scanner in = new Scanner(System.in);
		int op;
		
		menu();
		op = in.nextInt();
		while(op !=4) {
			switch(op) {
				case 1:
				{
					//Creacion de la RED1
					
					Canal canal1 = new Canal(numeroAleatorio());
					Canal canal2 = new Canal(numeroAleatorio());
					
					Computador comp1 = new Computador("175.0.0.90");
					Computador comp2 = new Computador("157.0.0.91");
					Computador comp3 = new Computador("157.0.0.92");
					
					Dispositivo dispositivo = new Bridge(numeroAleatorio());//Especificar el tipo de dispositivo Bridge,Router etc...
					
					comp1.setCanal(canal1);
					comp2.setCanal(canal2);
					comp3.setCanal(canal2);
					
					canal1.setComputadores(comp1);
					canal2.setComputadores(comp2);
					canal2.setComputadores(comp3);
					
					canal1.setDispositivos(dispositivo);
					canal2.setDispositivos(dispositivo);
					
					dispositivo.setCanales(canal1);
					dispositivo.setCanales(canal2);
					//fin de la cracion de la RED1
					
					Scanner in1 = new Scanner(System.in);
					String destino,
						   mensaje,
						   origen;
					do {
					System.out.print("\nPara salir de RED 1 introduzca en todas las opciones cero (0)\n");
					System.out.println("Computadores en la red: ");
					System.out.println(comp1.getDireccionDeRed());
					System.out.println(comp2.getDireccionDeRed());
					System.out.println(comp3.getDireccionDeRed());
					
					System.out.print("\nOrigen: ");
					origen = in1.nextLine();
					System.out.print("Destino: ");
					destino = in1.nextLine();
					System.out.print("Mensaje: ");
					mensaje = in1.nextLine();
					
					if(origen.equals(comp1.getDireccionDeRed())) {
						comp1.enviarMensaje(mensaje, destino);
					}else if(origen.equals(comp2.getDireccionDeRed())){
						comp2.enviarMensaje(mensaje, destino);
					}else if(origen.equals(comp3.getDireccionDeRed())) {
						comp3.enviarMensaje(mensaje, destino);
					}
					}while(!origen.equals("0")&&!destino.equals("0")&&!mensaje.equals("0"));
				}break;
				
				case 2:
				{
					//Creacion de la RED2
					Canal canal1 = new Canal(numeroAleatorio());
					Canal canal2 = new Canal(numeroAleatorio());
					Canal canal3 = new Canal(numeroAleatorio());
					Canal canal4 = new Canal(numeroAleatorio());
					
					Computador comp1 = new Computador("175.0.0.90");
					Computador comp2 = new Computador("157.0.0.91");
					Computador comp3 = new Computador("157.0.0.92");
					Computador comp4 = new Computador("157.0.0.93");
					
					Dispositivo dispositivo1 = new Hub(numeroAleatorio());//Especificar el tipo de dispositivo Bridge,Router etc...
					
					comp1.setCanal(canal1);
					comp2.setCanal(canal2);
					comp3.setCanal(canal3);
					comp4.setCanal(canal4);
					
					canal1.setComputadores(comp1);
					canal2.setComputadores(comp2);
					canal3.setComputadores(comp3);
					canal4.setComputadores(comp4);
					
					canal1.setDispositivos(dispositivo1);
					canal2.setDispositivos(dispositivo1);
					canal3.setDispositivos(dispositivo1);
					canal4.setDispositivos(dispositivo1);
					
					dispositivo1.setCanales(canal1);
					dispositivo1.setCanales(canal2);
					dispositivo1.setCanales(canal3);
					dispositivo1.setCanales(canal4);
					//fin de la cracion de la RED2
					
					Scanner in1 = new Scanner(System.in);
					String destino,
						   mensaje,
						   origen;
					do {
						System.out.print("\nPara salir de RED 2 introduzca en todas las opciones cero (0)\n");
						System.out.println("Computadores en la red: ");
						System.out.println(comp1.getDireccionDeRed());
						System.out.println(comp2.getDireccionDeRed());
						System.out.println(comp3.getDireccionDeRed());
						System.out.println(comp4.getDireccionDeRed());
						
						System.out.print("\nOrigen: ");
						origen = in1.nextLine();
						System.out.print("Destino: ");
						destino = in1.nextLine();
						System.out.print("Mensaje: ");
						mensaje = in1.nextLine();
						
						if(origen.equals(comp1.getDireccionDeRed())) {
							comp1.enviarMensaje(mensaje, destino);
						}else if(origen.equals(comp2.getDireccionDeRed())){
							comp2.enviarMensaje(mensaje, destino);
						}else if(origen.equals(comp3.getDireccionDeRed())) {
							comp3.enviarMensaje(mensaje, destino);
						}else if(origen.equals(comp4.getDireccionDeRed())) {
							comp4.enviarMensaje(mensaje, destino);
						}
					}while(!origen.equals("0")&&!destino.equals("0")&&!mensaje.equals("0"));
					
				}break;
				
				case 3:
				{
					//Creacion de la RED3
					Canal canal1 = new Canal(numeroAleatorio());
					Canal canal2 = new Canal(numeroAleatorio());
					Canal canal3 = new Canal(numeroAleatorio());
					
					Computador comp1 = new Computador("175.0.0.90");
					Computador comp2 = new Computador("157.0.0.91");
					Computador comp3 = new Computador("157.0.0.92");
					
					Dispositivo dispositivo1 = new Switch(numeroAleatorio());//Especificar el tipo de dispositivo Bridge,Router etc...
					Dispositivo dispositivo2 = new Router(numeroAleatorio());
					
					comp1.setCanal(canal1);
					comp2.setCanal(canal3);
					comp3.setCanal(canal3);
					
					canal1.setComputadores(comp1);
					canal3.setComputadores(comp2);
					canal3.setComputadores(comp3);
					
					dispositivo1.setCanales(canal1);
					dispositivo1.setCanales(canal2);
					dispositivo2.setCanales(canal2);
					dispositivo2.setCanales(canal3);
					
					canal1.setDispositivos(dispositivo1);
					canal2.setDispositivos(dispositivo1);
					canal2.setDispositivos(dispositivo2);
					canal3.setDispositivos(dispositivo2);
					//Fin de Creacion de la RED3
					
					
					
					Scanner in1 = new Scanner(System.in);
					String destino,
						   mensaje,
						   origen;
					
					do {
						System.out.print("\nPara salir de RED 3 introduzca en todas las opciones cero (0)\n");
						System.out.println("Computadores en la red: ");
						System.out.println(comp1.getDireccionDeRed());
						System.out.println(comp2.getDireccionDeRed());
						System.out.println(comp3.getDireccionDeRed());	
						System.out.print("\nOrigen: ");
						origen = in1.nextLine();
						System.out.print("Destino: ");
						destino = in1.nextLine();
						System.out.print("Mensaje: ");
						mensaje = in1.nextLine();
						
						if(origen.equals(comp1.getDireccionDeRed())) {
							comp1.enviarMensaje(mensaje, destino);
						}else if(origen.equals(comp2.getDireccionDeRed())){
							comp2.enviarMensaje(mensaje, destino);
						}else if(origen.equals(comp3.getDireccionDeRed())) {
							comp3.enviarMensaje(mensaje, destino);
						}
					}while(!origen.equals("0")&&!destino.equals("0")&&!mensaje.equals("0"));
					
				}break;
				
				default:
				{
					System.out.println("Opcion no valida");
				}
			}
			System.out.println();
			menu();
			op = in.nextInt();
	    }
    }	
}
