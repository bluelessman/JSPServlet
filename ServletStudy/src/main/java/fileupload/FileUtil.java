package fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUtil {
	public static String uploadFile(HttpServletRequest req, String sDirectory) throws IOException, ServletException {
		//Part 객체를 통해 서버로 전송된 파일명 읽어오기
		Part part = req.getPart("ofile");
		//part 객체의 헤더값 중 content-disposition 읽어오기
		String partHeader = part.getHeader("content-disposition");
		//헤더값에서 파일명 잘라내기
		String[] phArr = partHeader.split("filename=");
		String originalFileName = phArr[1].trim().replace("\"","");
		if(!originalFileName.isEmpty()) {
			part.write(sDirectory+ File.separator + originalFileName);
		}
		return originalFileName;
	}
	public static String renameFile(String sDirectory, String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		String newFileName = now + ext;
		File oldFile = new File(sDirectory+File.separator+fileName);
		File newFile = new File(sDirectory+File.separator+newFileName);
		oldFile.renameTo(newFile);
		return newFileName;
	}
	public static ArrayList<String> multipleFile(HttpServletRequest req, String sDirectory) throws IOException, ServletException{
		ArrayList<String> listFileName = new ArrayList<String>();
		Collection<Part> parts = req.getParts();
		for (Part part : parts) {
			if(!part.getName().equals("ofile")) continue;
			String partHeader = part.getHeader("content-disposition");
			String[] phArr = partHeader.split("filename=");
			String originalFileName = phArr[1].trim().trim().replace("\"","");
			if(!originalFileName.isEmpty()) {
				part.write(sDirectory+ File.separator + originalFileName);
			}
			listFileName.add(originalFileName);
		}
		return listFileName;
	}
}
