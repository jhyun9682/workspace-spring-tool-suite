package com.itwill.tomorrowHome.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.tomorrowHome.controller.interceptor.LoginCheck;
import com.itwill.tomorrowHome.domain.Cart;
import com.itwill.tomorrowHome.domain.Qna;
import com.itwill.tomorrowHome.service.CartService;
import com.itwill.tomorrowHome.service.QnaService;
import com.itwill.tomorrowHome.util.PageMakerDto;

@Controller
public class QnaController {
	@Autowired
	private QnaService qnaService;
	@Autowired
	private CartService cartService;

	/*
	 * 게시글 리스트 반환
	 */
	@LoginCheck
	@RequestMapping("/qna_list")
	public String qna_list(@RequestParam(required = false, defaultValue = "1") Integer pageno, Model model,
			HttpSession session) {
		try {
			PageMakerDto<Qna> qnaList = qnaService.selectQnaList(pageno);
			List<Cart> cartList = cartService.cartListAll((String) session.getAttribute("sM_id"));
			model.addAttribute("qnaList", qnaList);
			model.addAttribute("pageno", pageno);
			model.addAttribute("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "tables";
	}

	/*
	 * 게시글 상세
	 */
	@LoginCheck
	@RequestMapping("/qna_view")
	public String qna_detail(@RequestParam Integer pageno, Integer q_no, Model model, HttpSession session) {
		if (pageno == null || q_no == null) {
			return "redirect:index";
		}
		try {
			Qna qna = qnaService.selectQna(q_no, "view");
			List<Cart> cartList = cartService.cartListAll((String) session.getAttribute("sM_id"));
			qnaService.updateReadCount(q_no);
			model.addAttribute("qna", qna);
			model.addAttribute("pageno", pageno);
			model.addAttribute("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "tables-detail";
	}

	/*
	 * 새글 등록
	 */
	@LoginCheck
	@RequestMapping("/qna_new_write")
	public String qna_new_write(@ModelAttribute Qna qna, @RequestParam Integer pageno) {
		if (pageno == null) {
			return "redirect:index";
		}
		try {
			qnaService.insertNewQna(qna);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:qna_list?pageno=" + pageno;
	}

	/*
	 * 답글 등록
	 */
	@LoginCheck
	@RequestMapping("/qna_reply_write")
	public String qna_reply_write(Integer pageno, Integer q_no, @RequestParam Map<String, String> params) {
		if (pageno == null || q_no == null) {
			return "redirect:index";
		}

		try {
			Qna qna = new Qna();
			qna.setQ_no(q_no);
			qna.setQ_title(params.get("q_title"));
			qna.setQ_content(params.get("q_content"));
			qna.setM_id(params.get("m_id"));
			qnaService.insertReply(qna);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:qna_list?pageno=" + pageno;
	}

	/*
	 * 게시글 수정
	 */
	@LoginCheck
	@RequestMapping("/qna_update")
	public String qna_update(@RequestParam Map<String, String> params) {
		String pageno = params.get("pageno");
		String q_no = params.get("q_no");
		if (pageno == null || q_no == null) {
			return "redirect:index";
		}
		try {
			Qna qna = new Qna();
			qna.setQ_no(Integer.parseInt(q_no));
			qna.setQ_title(params.get("q_title"));
			qna.setQ_content(params.get("q_content"));
			qnaService.updateQna(qna);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:qna_view?pageno=" + pageno + "&q_no=" + q_no;
	}

	/*
	 * 게시글 수정폼
	 */
	@LoginCheck
	@RequestMapping("/qna_update_form")
	public String qna_update_form(@RequestParam Integer pageno, Integer q_no, Model model, HttpSession session) {
		if (pageno == null || q_no == null) {
			return "redirect:index";
		}
		try {
			Qna qna = qnaService.selectQna(q_no, "modifyForm");
			List<Cart> cartList = cartService.cartListAll((String) session.getAttribute("sM_id"));
			model.addAttribute("qna", qna);
			model.addAttribute("pageno", pageno);
			model.addAttribute("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "tables-update";
	}

	/*
	 * 게시글 입력폼
	 */
	@LoginCheck
	@RequestMapping("/qna_write_form")
	public String qna_write_form(Integer pageno, Model model, HttpSession session) {
		if (pageno == null) {
			return "redirect:index";
		}
		try {
			List<Cart> cartList = cartService.cartListAll((String) session.getAttribute("sM_id"));
			model.addAttribute("pageno", pageno);
			model.addAttribute("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "tables-write";
	}

	/*
	 * 답글 입력폼
	 */
	@LoginCheck
	@RequestMapping("/qna_reply_form")
	public String qna_reply_form(Integer pageno, Integer q_no, Model model, HttpSession session) {
		if (pageno == null || q_no == null) {
			return "redirect:index";
		}
		try {
			Qna qna = qnaService.selectQna(q_no, "modifyForm");
			List<Cart> cartList = cartService.cartListAll((String) session.getAttribute("sM_id"));
			model.addAttribute("qna", qna);
			model.addAttribute("q_no", q_no);
			model.addAttribute("pageno", pageno);
			model.addAttribute("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "tables-reply-write";
	}

}
