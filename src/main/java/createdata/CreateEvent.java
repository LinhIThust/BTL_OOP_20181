package createdata;

import java.util.Random;
import entities.Entity;
import entities.Event;
import utility.FileUtil;

public class CreateEvent implements CreateData {
	private static String filePath = "lib\\Data\\Event\\";
	private String[] labelP = FileUtil.getListFromFile(filePath + "Label");
	private String[] descriptionP = FileUtil.getListFromFile(filePath + "Description");
	private String[] date = FileUtil.getListFromFile(filePath + "Date");
	private final Random rd = new Random();
	// ---
	private final int lengthLabelP = labelP.length;
	private final int lengthDesP = descriptionP.length;
	private final int lengthDate = date.length;
	// -----

	@Override
	public Entity get() {
		String id = "Event" + java.time.LocalDateTime.now().toString();
		String label = this.labelP[rd.nextInt(lengthLabelP)];
		String description = this.descriptionP[rd.nextInt(lengthDesP)];
		String dateTime = this.date[rd.nextInt(lengthDate)];
		Event e = new Event(id, label, description, new CreateCitationOrigin().get(), dateTime);
		return e;
	}

}
