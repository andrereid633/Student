import interfaces.StudentEnquireiesInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Main {

	public static void main(String[] args) {
		try {
			Registry r = LocateRegistry.getRegistry(4500);
			StudentEnquireiesInterface stud = (StudentEnquireiesInterface)r.lookup("Remote2");
			
				System.out.println("Hello");
			
			System.out.println("Hello1");
			
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}

}
