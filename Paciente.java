
public class Paciente {
	public static void main(String[] args) {
		System.out.println("Bemvindo ao TWO");
		basedados bd =new basedados();
		
		//Paciente quer consultar informação a ele associada
		//ver Epcs de medicamentos relacionados com ele
		
		//System.out.println(bd.nomeP(2));

		//System.out.println(bd.idPaciente("Maria"));
		
		/*SendMail a = new SendMail();
		a.sendMail("redesmiebiom",bd.email(4), "Nah", "ok");*/
		System.out.println(bd.email(4));
		
		System.out.println(bd.maxReceita());
	}

}
