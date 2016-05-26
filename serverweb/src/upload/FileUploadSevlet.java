package upload;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadSevlet
 */
@WebServlet(name = "upload", urlPatterns = { "/upload.do" })
public class FileUploadSevlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String saveFolder ="/upload2";
		String encType ="euc-kr";
		int size = 5*1024*1024;
		String realFolder = "";
		//1. 실제 업로드될 폴더의 경로를 구한다. - 서버가 인식하는 위치
		//====> ServletContext객체(context에 대한 정보를 담고있고, 할수있는 기능을 지원)
		ServletContext context = getServletContext();
		realFolder = context.getRealPath(saveFolder);
		System.out.println(realFolder);
		
		//2. cos.jar에서 지원하는 MultipartRequest
		MultipartRequest multipart = new MultipartRequest(request, realFolder, size, encType,new DefaultFileRenamePolicy());
		
		//3. 파일정보 추출
		Enumeration<String> files = multipart.getFileNames();
		while(files.hasMoreElements()){
			String file = files.nextElement();
			System.out.println(file);
			System.out.println(multipart.getFilesystemName(file));
			System.out.println(multipart.getOriginalFileName(file));
		}
		
		//4. 다른 요청정보 추출하기 
		// - 파일업로드를 진행하는 경우에는 무조건 MultipartRequest의 getParameter를 
		//   이용해서 요청정보를 추출한다.
		System.out.println("사용자명:"+multipart.getParameter("user"));
		System.out.println("제목:"+multipart.getParameter("title"));
		
	}

}
