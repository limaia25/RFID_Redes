import java.util.Scanner;


public class Médico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bemvindo ao TWO");
		basedados bd =new basedados();
		
		
		//Doente passa no leitor de rfid
		
		Scanner s = new Scanner(System.in);
		System.out.println("Introduza valor obtido pelo leitor de RFID:");
		Zonetest bla = new Zonetest();
		int epcd=s.nextInt();
		
		// IR buscar o Epc ao servidor
		System.out.println(bla.buscaid(epcd));
		
		System.out.println("Medicamento");
		bd.consultamedicamentos();
		for(int i=1; i< bd.consultamedicamentos().size();i++)
		{
			System.out.println(bd.consultamedicamentos().get(i));
		}
		
		bd.consultamedicamentos();
	
		
       
		/*Médico Seleciona o medicamento pretendido
		System.out.println("Introduza EPC do medicamento ");
		int epcm=s.nextInt();
		*/
		//Efectua prescrição
		
		bd.prescrever(400,1,201,8,12);
		
		//System.out.println(bd.nomeMedicamento(201));
		System.out.println(bd.EPCm("Pantoprazol"));
		
		//System.out.println(bd.nomeM(400));
		//System.out.println(bd.idMedico("Paulo"));
		
		/*SendMail a = new SendMail();
		a.sendMail("redesmiebiom",bd.emailMedico(400), "Nah", "ok");*/
	
		System.out.println(bd.emailMedico(400));
	}

}
