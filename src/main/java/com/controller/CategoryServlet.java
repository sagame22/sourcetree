package com.controller;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.category.CategoryVO;
import com.util.ImageUtil;
import com.util.WriteImg;

@MultipartConfig
@Controller
@RequestMapping("/admin/category")
public class CategoryServlet extends FatherServlet {

	@RequestMapping("/add")
	public String add(HttpServletRequest request, CategoryVO c) {
		// 取得流
		InputStream is = ImageUtil.parseUpload(request);
		int id = categoryService.add(c);
		// 圖片寫入硬碟
		String saveDirectory = "img/category";
		String realPath = request.getServletContext().getRealPath(saveDirectory);
		File fsaveDirectory = new File(realPath);
		if (!fsaveDirectory.exists())
			fsaveDirectory.mkdirs();
		// 第一個file找到圖檔資料夾路徑,第二個file再創一個圖檔放進第一個file
		File file = new File(fsaveDirectory, id + ".jpg");
		WriteImg.writeImg(is, file);

		return "redirect:/index.jsp";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("categoryId") int id) {
		categoryService.delete(id);
		return "redirect:/index.jsp";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam("categoryId") int id ,Model m) {
		CategoryVO c = categoryService.get(id);
		System.out.println(c);
		m.addAttribute("c", c);
		return "admin/editCategory";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request, CategoryVO c) {
		InputStream is = ImageUtil.parseUpload(request);
		categoryService.update(c);
		// 圖片寫入硬碟
		String saveDirectory = "img/category";
		String realPath = request.getServletContext().getRealPath(saveDirectory);
		File fsaveDirectory = new File(realPath);
		if (!fsaveDirectory.exists())
			fsaveDirectory.mkdirs();
		File file = new File(fsaveDirectory, c.getCategoryId() + ".jpg");
		WriteImg.writeImg(is, file);

		return "redirect:/index.jsp";

	}

	@RequestMapping("/list")
	public String list(Model m) {
		List<CategoryVO> list = categoryService.list();
		m.addAttribute("list", list);
		return "admin/listCategory";
	}

}
