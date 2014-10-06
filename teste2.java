import org.xbill.DNS.*;

import java.util.Iterator;
import java.util.List;
import java.net.UnknownHostException;

public class teste2 {
	public static void main(String[] args) throws UnknownHostException, TextParseException
	  {
	Lookup look = null;
	try {
			look = new Lookup("RFID:gcom.uminho.pt",Type.ANY);
			look.setResolver(new SimpleResolver("127.0.0.1"));
			
		} catch (TextParseException e) {
			System.out.println(e.getMessage());
			
		} catch (UnknownHostException e1) {
			System.out.println(e1.getMessage());
		
		}
		
		look.run();
		
		Record[] records = look.getAnswers();
		
		for(int i=0;i<records.length;i++)
		{
			System.out.println(records[i]);
		}
		/*
		
		if(records==null) 
			System.out.println("o Paulo é bastante burro");
		else 
			System.out.println("o Paulo é bastante esperto");
		
		for (int i = 0; i < records.length; i++) {
			
			NAPTRRecord naptr = (NAPTRRecord) records[i];
			System.out.println("Host " + naptr.getService());
			//if (naptr.getService().equalsIgnoreCase("EPC+"+serviceGroup.getSelectedCheckbox().getLabel()))	naptrs.add(naptr);
		}
		
		
/*	if (naptrs.size()==0) {
		infoArea.append("No existem resultados para o servio especificado\n");
		return null;
	}
*/
}
}