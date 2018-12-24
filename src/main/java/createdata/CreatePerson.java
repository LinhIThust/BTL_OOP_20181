package createdata;

import java.util.Random;

import entities.Entity;
import entities.Person;
import utility.FileUtil;

public class CreatePerson implements CreateData {
	private static String filePath = "lib\\Data\\Person\\";
	private String[] labelP = FileUtil.getListFromFile(filePath + "Label");
	private String[] descriptionP = FileUtil.getListFromFile(filePath + "Description");
	private String[] positionP = FileUtil.getListFromFile(filePath + "Position");
	private final Random rd = new Random();
	// ---
	private final int lengthLabelP = labelP.length;
	private final int lengthDesP = descriptionP.length;
	private final int lengthPosP = positionP.length;
	// -----

	@Override
	public Entity get() {
		String id = "Person" + java.time.LocalDateTime.now().toString();
		String label = this.labelP[rd.nextInt(lengthLabelP)];
		String description = this.descriptionP[rd.nextInt(lengthDesP)];
		String position = this.positionP[rd.nextInt(lengthPosP)];
		Person p = new Person(id, label, description, new CreateCitationOrigin().get(), position);
		return p;
	}
}
