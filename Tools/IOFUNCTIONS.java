package Tools;

import java.io.File;

public class IOFUNCTIONS {
	
	
	public static void deleteDirectory(File file) {
		if (file.isFile()) {// ��ʾ���ļ������ļ���
			file.delete();
		} else {
			// ���ȵõ���ǰ��·��
			String[] childFilePaths = file.list();
			for (String childFilePath : childFilePaths) {
				File childFile = new File(file.getAbsolutePath() + "/" + childFilePath);
				deleteDirectory(childFile);
			}
			file.delete();
		}
	}


}
