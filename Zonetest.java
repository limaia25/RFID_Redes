import java.io.IOException;
import java.lang.Object;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.*;

import org.xbill.*;
import org.xbill.DNS.ARecord;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.MXRecord;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.ReverseMap;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;
import org.xbill.DNS.ZoneTransferException;
import org.xbill.DNS.ZoneTransferIn;

public class Zonetest {

	int port = 53;

	Name zona;
	ZoneTransferIn xfr = null;

	public Zonetest() {

		try {
			zona = new Name("RFID.gcom.di.uminho.pt");
			xfr = ZoneTransferIn.newAXFR(zona, "localhost", port, null);

		} catch (TextParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int buscaid(int epcp) {
		
		String[] aux = new String[5];
		String[] aux1 = new String[8];
		String novo = null;
		String epcaux = Integer.toString(epcp);
		int id = 0;
		try {
			List records = xfr.run();

			for (int i = 0; i < records.size() - 1; i++) {
				String registo = records.get(i).toString();
				aux1=records.get(i).toString().split(" ");
				if (registo.matches(".*NAPTR.*") == true && (aux1[1].equalsIgnoreCase(epcaux)==true) ) {
					aux = records.get(i).toString().split("!");
					novo = aux[2];
					System.out.println(novo);
				}
			}
			id = Integer.parseInt(novo);
		} catch (IOException e) {e.printStackTrace();
		} catch (ZoneTransferException e) {e.printStackTrace();}
		return id;

	}
}