package action;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class MemberImgAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getServletContext().getRealPath("/") + "model2/member/img/";
		MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr");
		boolean imgable = multi.getContentType("picture").contains("image");
		if (!imgable) {
			request.setAttribute("msg", "이미지파일만 업로드가 가능합니다.");
			request.setAttribute("url", "memberimgForm.jsp");
			return new ActionForward(false, "../alert.jsp");
		}
		String filename = multi.getFilesystemName("picture");
		//file을 BufferedImage이미지로 로드. 
		ParameterBlock pb = new ParameterBlock();
		pb.add(path + filename);
		RenderedOp rop = JAI.create("fileload", pb);
		BufferedImage bi = rop.getAsBufferedImage();
		//썸네일의 크기 설정
		int width = bi.getWidth() / 5;
		int height = bi.getHeight() / 5;

		//thumb : 이미지가 없다. 틀만 설정
		BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = thumb.createGraphics();
		g.drawImage(bi, 0, 0, width, height, null); //썸네일 이미지를 buffer에 그리기. thumb은 이미지가 존재
		//버퍼이미지를 파일로 저장
		File f = new File(path + "sm_" + filename);
		ImageIO.write(thumb, "jpg", f);
		request.setAttribute("filename", filename);
		return new ActionForward(false, "memberimg.jsp");
	}
}
