package fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
	
	public static void download(HttpServletRequest req, HttpServletResponse resp, String directory, String sFileName, String oFileName) {
		InputStream iStream = null;
		OutputStream oStream = null;
		String sDirectory = req.getServletContext().getRealPath(directory);
		try {
			File file = new File(sDirectory,sFileName);
			iStream = new FileInputStream(file);
			
			String client = req.getHeader("User-Agent");
			if(client.indexOf("WOW64")==-1) {
				oFileName = new String(oFileName.getBytes("UTF-8"),"ISO-8859-1");
			}else {
				oFileName = new String(oFileName.getBytes("KCS5601"),"ISO-8859-1");
			}
			
	    	resp.reset();
	    	resp.setContentType("application/octet-stream");
	    	resp.setHeader("Content-Disposition", "attachment; filename=\""+oFileName+"\"");
	    	resp.setHeader("Content-Length", ""+file.length());
	    	oStream = resp.getOutputStream();
	    	
	    	byte b[] = new byte[(int)file.length()];
	    	int readBuffer = 0;
	    	while((readBuffer=iStream.read(b))>0){
	    		oStream.write(b, 0, readBuffer);
	    	}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외가 발생하였습니다.");
			e.printStackTrace();
		}finally {
			if(iStream!=null){
    	    	try {
					iStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(oStream!=null){
    	    	try {
					oStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void deleteFile(HttpServletRequest req, String directory, String filename) {
		String sDirectory = req.getServletContext().getRealPath(directory);
		File file = new File(sDirectory + File.separator + filename);
		if(file.exists()) {
			file.delete();
		}
	}
}
