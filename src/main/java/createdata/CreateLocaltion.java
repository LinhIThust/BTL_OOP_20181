package createdata;

import java.time.LocalDate;
import java.util.Random;

import entities.Entity;
import entities.Location;
import entities.Person;
import utility.FileUtil;

public class CreateLocaltion implements CreateData {
	private static String filePath = "lib\\Data\\Localtion\\";
	private String[] labelP = FileUtil.getListFromFile(filePath + "Label");
	private String[] descriptionP = FileUtil.getListFromFile(filePath + "Description");
	private String[] country = FileUtil.getListFromFile(filePath + "Country");
	private final Random rd = new Random();
	// ---
	private final int lengthLabelP = labelP.length;
	private final int lengthDesP = descriptionP.length;
	private final int lengthCou = country.length;
	// -----

	@Override
	public Entity get() {
		String id = "Localtion" + java.time.LocalDateTime.now().toString();
		String label = this.labelP[rd.nextInt(lengthLabelP)];
		String description = this.descriptionP[rd.nextInt(lengthDesP)];
		String country = this.country[rd.nextInt(lengthCou)];
		Location p = new Location(id, label, description, new CreateCitationOrigin().get(), country);
		return p;
	}

}
