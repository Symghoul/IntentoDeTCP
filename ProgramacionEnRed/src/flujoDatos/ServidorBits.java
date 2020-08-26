package flujoDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBits {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(5000);
			
			System.out.println("Esperando conexion...");
			Socket socket = server.accept();
			System.out.println("Conectado OwO ");

			String path = "D:\\por enviar"; // direccion absoluta del archivo a enviar
			File file = new File(path);
			
			FileInputStream fis = new FileInputStream((file));
			OutputStream os = socket.getOutputStream();
			
			
			byte[] buffer = new byte[1200];
			int bytesLeidos =0;
		 	
			while((bytesLeidos = fis.read(buffer))!= -1) {
				os.write(buffer, 0, bytesLeidos);
				
			}
			
			fis.close();
			os.close();
		
//			//PARA RECIBIR MENSAJES 
//			InputStream is = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader bReader = new BufferedReader(isr);
//			String line = bReader.readLine();
//			System.out.println("Mensaje recibido: "+line);
//			
//			Socket proximo = new Socket("2.tcp.ngrok.io",15429 );
//			
//			OutputStream os = proximo.getOutputStream();
//			BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(os));
//			bwriter.write(line+"\n");
//			bwriter.flush();
//			
//			while(true) {
//			}
//			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Hmm no deberias estar leyendo esto we ._.");
		}
	}
}
