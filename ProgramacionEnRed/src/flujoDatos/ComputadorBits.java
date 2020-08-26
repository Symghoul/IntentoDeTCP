package flujoDatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class ComputadorBits {
	
	public static void main(String[] args) {
		
		try {
			System.out.println("Enviando solicitud... ");
			Socket socket = new Socket("127.0.0.1", 5000);
			System.out.println("Conectado");
			
			String path = "D:\\recibidos\\algo.txt"; // direccion absoluta de donde se va a guardar el archivo (con el nombre del archivo). Path de salida
			File archivoRecibido = new File(path);
			
			InputStream is = socket.getInputStream();
			FileOutputStream fos = new FileOutputStream(archivoRecibido);
			
			byte[] buffer = new byte[500];		//Se crea un buffer para la transmision
			int bytesLeidos =0;
		 	
			
//			while((bytesLeidos = is.read(buffer))!= -1) {
//				fos.write(buffer, 0, bytesLeidos);
//				
//			}
			
			while(true) {}
			
//			is.close();
//			fos.close();
			
//			// PARA MANDAR UN MENSAJE
//			Scanner scanner = new Scanner(System.in);
//			String line = scanner.nextLine();
//			System.out.println("Enviando solicitud... ");
//			Socket socket = new Socket("2.tcp.ngrok.io", 15429);
//			System.out.println("Conectado");
//			
//			OutputStream os = socket.getOutputStream();
//			BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(os));
//			bwriter.write(line+"\n");
//			bwriter.flush();
//			
//			while(true) {
//				
//			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.out.println("Hmm no deberias estar leyendo esto we ._.");
		}
		
		
	}

}
