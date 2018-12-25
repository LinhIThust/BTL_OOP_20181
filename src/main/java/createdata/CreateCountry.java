package createdata;

import java.util.Random;

import entities.Country;
import entities.Entity;
import utility.FileUtil;

public class CreateCountry implements CreateData {
	private static String filePath = "lib\\Data\\Country\\";
	private String[] labelP = FileUtil.getListFromFile(filePath + "Label");
	private String[] descriptionP = FileUtil.getListFromFile(filePath + "Description");
	// ---
	private final int lengthLabelP = labelP.length;
	private final int lengthDesP = descriptionP.length;
	// ---
	private final Random rd = new Random();

	@Override
	public Entity get() {
		String id = "Country" + rd.nextInt()+java.time.LocalDateTime.now().toString();
		String label = this.labelP[rd.nextInt(lengthLabelP)];
		String description = this.descriptionP[rd.nextInt(lengthDesP)];
		Country c = new Country(id, label, description, new CreateCitationOrigin().get());
		return c;
	}
}
