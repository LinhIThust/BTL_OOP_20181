package createdata;

import java.util.Random;

import entities.Entity;
import entities.Organization;
import entities.Person;
import utility.FileUtil;

public class CreateOrganization implements CreateData {
	private static String filePath = "lib\\Data\\Organization\\";
	private String[] labelP = FileUtil.getListFromFile(filePath + "Label");
	private String[] descriptionP = FileUtil.getListFromFile(filePath + "Description");
	private String[] headQ = FileUtil.getListFromFile(filePath + "HeadQuarters");
	private final Random rd = new Random();
	// ---
	private final int lengthLabelP = labelP.length;
	private final int lengthDesP = descriptionP.length;
	private final int lengthHeadQ = headQ.length;
	// -----

	@Override
	public Entity get() {
		String id = "Organization" + java.time.LocalDateTime.now().toString();
		String label = this.labelP[rd.nextInt(lengthLabelP)];
		String description = this.descriptionP[rd.nextInt(lengthDesP)];
		String head = this.headQ[rd.nextInt(lengthHeadQ)];
		Organization o = new Organization(id, label, description, new CreateCitationOrigin().get(), head);
		return o;
	}

}
