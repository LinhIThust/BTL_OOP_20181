package createdata;

import java.util.Random;

import entities.CitationOrigin;
import utility.FileUtil;

public class CreateCitationOrigin {
	private static String filePath = "lib\\Data\\";
	private String[] linkList = FileUtil.getListFromFile(filePath + "Link");
	private String[] strDateList = FileUtil.getListFromFile(filePath + "Date");

	private final int lengthLink = linkList.length;
	private final int lengthDate = strDateList.length;

	private final Random rd = new Random();

	public CitationOrigin get() {
		String link = this.linkList[rd.nextInt(lengthLink)];
		String date = this.strDateList[rd.nextInt(lengthDate)];
		CitationOrigin co = new CitationOrigin(link, date);
		return co;
	}

}
