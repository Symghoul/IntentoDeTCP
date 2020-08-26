package model;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Scanner;

public class detectarIPs {

	public static void main(String[] args) {
		
		try { 
			InetAddress miRed = InetAddress.getLocalHost();
			String dir = ""+miRed.getHostAddress();
			System.out.println(dir);
			String[] direcciones = dir.split("\\.");
			NetworkInterface net = NetworkInterface.getByInetAddress(miRed);
			int pref = net.getInterfaceAddresses().get(0).getNetworkPrefixLength();
			int seg = 1;
			int ter = 1;
			int cua = 1;
			
			if(pref==8) {
				for(seg=1;seg<255;seg++) {
					for(ter=1; ter<255;ter++) {
						for( cua=1; cua<255; cua++) {						
							InetAddress ip = InetAddress.getByName(direcciones[0]+"."+seg+"."+ter+"."+cua);
							if(ip.isReachable(2000))
								System.out.println(ip);
						}
					}
				}
			}else if(pref==16) {
				
				for(ter=1; ter<255;ter++) {
					for( cua=1; cua<255; cua++) {						
						InetAddress ip = InetAddress.getByName(direcciones[0]+"."+direcciones[1]+"."+ter+"."+cua);
						if(ip.isReachable(2000))
							System.out.println(ip);
					}
				}
			}else if(pref==24) {
				
				for( cua=1; cua<255; cua++) {						
					InetAddress ip = InetAddress.getByName(direcciones[0]+"."+direcciones[1]+"."+direcciones[2]+"."+cua);
					if(ip.isReachable(2000))
						System.out.println(ip);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
