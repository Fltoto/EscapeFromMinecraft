package Tools;

import java.io.File;

public class IOFUNCTIONS {
	
	
	public static void deleteDirectory(File file) {
		if (file.isFile()) {// 表示该文件不是文件夹
			file.delete();
		} else {
			// 首先得到当前的路径
			String[] childFilePaths = file.list();
			for (String childFilePath : childFilePaths) {
				File childFile = new File(file.getAbsolutePath() + "/" + childFilePath);
				deleteDirectory(childFile);
			}
			file.delete();
		}
	}


}
