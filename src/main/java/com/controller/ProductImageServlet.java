package com.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.product.ProductVO;
import com.productimage.ProductImageVO;
import com.service.ProductImageServiceImpl;
import com.util.ImageUtil;
import com.util.WriteImg;

@Controller
@MultipartConfig
@SessionAttributes(value= {"p","pisSingle","pisDetail"})
@RequestMapping("/admin/productImage")

public class ProductImageServlet extends FatherServlet {
	@RequestMapping("/add")
	public String add(HttpServletRequest request,int productId,ProductImageVO pi){
		// 取得上傳檔案的輸入流和圖檔名稱
		InputStream is = ImageUtil.parseUpload(request);
		ProductVO p = productService.get(productId);
		pi.setProduct(p);
		int id = productImageService.add(pi);
		// 生成文件,用新增的ID作為圖檔名稱
		String fileName = id + ".jpg";
		String imageFolder;
		String imageFolder_small=null;
		String imageFolder_middle=null;
		//判斷圖案類型選擇不一樣的存儲路徑
		if (ProductImageServiceImpl.type_single.equals(pi.getType())) {
			imageFolder = request.getSession().getServletContext().getRealPath("img/productSingle");
			imageFolder_small = request.getSession().getServletContext().getRealPath("img/productSingle_small");
			imageFolder_middle = request.getSession().getServletContext().getRealPath("img/productSingle_middle");
		}
		else
			imageFolder = request.getServletContext().getRealPath("img/productDetail");
		File f = new File(imageFolder);
		//判斷資料夾存在否,不存在創建
		if(!f.exists())
			f.mkdirs();
//		創建要寫入的路徑File
		File f2 = new File(f, fileName);
		
		//圖片縮小後存入
		try {if(null!=is && 0!=is.available()) {
			try(FileOutputStream fos = new FileOutputStream(f2)){
				byte b[]=new byte[1024*1024];
				int length=0;
				while(-1!=(length=is.read(b))) {
					fos.write(b, 0, length);
				}
				fos.flush();
			BufferedImage img = ImageUtil.change2jpg(f2);
			ImageIO.write(img,"jpg",f2);
			
			if(ProductImageServiceImpl.type_single.equals(pi.getType())){
				System.out.println("************************");
				File f_small = new File(imageFolder_small, fileName);
				File f_middle = new File(imageFolder_middle, fileName);
				ImageUtil.resizeImage(f2, 56, 56, f_small);
				ImageUtil.resizeImage(f2, 217, 190, f_middle);
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
		//圖片寫入
		WriteImg.writeImg(is, f2);

		return "redirect:/redirect/listProductImage.jsp?productId=" + productId;
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, int imageId) {
		ProductImageVO pi = productImageService.get(imageId);
		productImageService.delete(imageId);

		if (ProductImageServiceImpl.type_single.equals(pi.getType())) {
			String imageFolder_single = request.getServletContext().getRealPath("img/productSingle");
			String imageFolder_small = request.getServletContext().getRealPath("img/productSingle_small");
			String imageFolder_middle = request.getSession().getServletContext().getRealPath("img/productSingle_middle");
			//獲取圖檔位置刪除之
			File f_single = new File(imageFolder_single, pi.getImageId() + ".jpg");
			f_single.delete();
			File f_small = new File(imageFolder_small, pi.getImageId() + ".jpg");
			f_small.delete();
			File f_middle = new File(imageFolder_middle, pi.getImageId() + ".jpg");
			f_middle.delete();

		}
		else {
			String imageFolder_detail = request.getSession().getServletContext().getRealPath("img/productDetail");
			File f_detail = new File(imageFolder_detail, pi.getImageId() + ".jpg");
			f_detail.delete();
		}
		return "redirect:/redirect/listProductImage.jsp?productId=" + pi.getProduct().getProductId();
	}

	public String edit(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	public String update(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	@RequestMapping("/list")
	public String list(Integer productId,Model m) {
		//用該產品ID和圖片類型找出圖檔VO對象選發至View
		if(productId!=null) {
		ProductVO p = productService.get(productId);
		List<ProductImageVO> pisSingle = productImageService.list(p, ProductImageServiceImpl.type_single);
		List<ProductImageVO> pisDetail = productImageService.list(p, ProductImageServiceImpl.type_detail);
		System.err.println(pisSingle.size());
		m.addAttribute("p", p);
		m.addAttribute("pisSingle", pisSingle);
		m.addAttribute("pisDetail", pisDetail);
		}
		return "admin/listProductImage";
	}
}
