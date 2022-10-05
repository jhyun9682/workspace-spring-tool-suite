package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.PostDAO;
import com.example.demo.dao.ReplyDAO;
import com.example.demo.vo.PostVO;

import lombok.Setter;

@Controller
public class PostController {
   public static int pageSIZE=5;
   public static int pageMAX =5;      //�븳 �럹�씠吏��뿉�꽌 �럹�씠吏뺣컮 �닔
   public static int totalCount=0;   
   public static int totalPage=0;
   public static int updateHit=0;
   public static int nextId;
   public static int nextNo;
   
   @Autowired
   @Setter
   private PostDAO dao;

   @Autowired
   @Setter
   private ReplyDAO re_dao;
   
   @Autowired
   @Setter
   private CustomerDAO c_dao;
   
   //�쟾泥� 寃뚯떆湲� 紐⑸줉
   @RequestMapping("postList.do")
   public void postList(Model model, int group, @RequestParam(value = "pageNUM", defaultValue = "1") int pageNUM, String search, String option, HttpSession session, HttpServletRequest request) {
      System.out.println("***pageNUM : "+   pageNUM);

      System.out.println("search::::"+search);
      System.out.println("option::::"+option);
      
      if(search==null&&session.getAttribute("search")!=null) {
         search=(String)session.getAttribute("search");
         option=(String)session.getAttribute("option");
         System.out.println("search 1111 :  "+search);
         System.out.println("option 1111 :  "+option);
      }
      
      HashMap map=new HashMap();
      map.put("group", group);
      map.put("search", search);
      map.put("option", option);
            
      totalCount = dao.getTotalCount(map);
      totalPage = (int)Math.ceil( (double)totalCount/pageSIZE ) ;
      
      //�럹�씠吏� 踰꾪듉 �닽�옄
        int startPage = (pageNUM-1)/pageMAX*pageMAX+1;
        int endPage = startPage+pageMAX-1;
        if(endPage>totalPage) {
           endPage = totalPage;
        }

      //�럹�씠吏��뿉 異쒕젰�릺�뒗 �젅肄붾뱶 踰덊샇
      int start = (pageNUM-1)*pageSIZE + 1;
      int end = start + pageSIZE-1;
      if(end > totalCount) {
         end = totalCount;
      }
      map.put("start", start);
        map.put("end", end);

        System.out.println("***start : "+start);
      System.out.println("***end : "+end);
      System.out.println("***startPage : "+startPage);
      System.out.println("***endPage : "+endPage);
      System.out.println("***totalPage : "+totalPage);
      
      model.addAttribute("group", group);
      model.addAttribute("list", dao.findAll(map));
      model.addAttribute("totalCount", totalCount);
      model.addAttribute("totalPage", totalPage);
      model.addAttribute("startPage", startPage);
      model.addAttribute("endPage", endPage);
      model.addAttribute("pageNUM", pageNUM);
      
      //寃��깋�뼱 �엯�젰�븯硫� �꽭�뀡�뿉 �떎�뼱以��떎.
      if(search!=null && !search.equals("")) {
         session.setAttribute("search", search);
         session.setAttribute("option", option);
         System.out.println("search 2 :  "+search);
         System.out.println("option 2 :  "+option);
         
      }
   }

   //寃뚯떆湲� �긽�꽭蹂닿린
   //�쟾泥� �뙎湲�紐⑸줉
   @RequestMapping("postDetail.do")
   public void detail(int p_id, int group, Model model, HttpServletRequest request) {
      updateHit=dao.updateHit(p_id);
         
      HashMap map=new HashMap();
      map.put("p_id", p_id);
      map.put("group", group);
  
      System.out.println("DETAIL �긽�꽭湲� p_id  |  "+p_id);
      System.out.println("DETAIL �긽�꽭湲� p_no  |  "+dao.findById(map).getP_no());
      System.out.println("DETAIL �긽�꽭湲� cust_no |  "+dao.findById(map).getCust_no());
  
      model.addAttribute("post",dao.findById(map));
      model.addAttribute("group", group);
      model.addAttribute("listReply",re_dao.findAll(map));
      
      //濡쒓렇�씤�맂 �쉶�썝踰덊샇 諛쏆븘�삤湲�
      HttpSession session=request.getSession(); 
      session.setAttribute("cust_no", session.getAttribute("cust_no"));
      System.out.println("濡쒓렇�씤�맂 �쉶�썝踰덊샇  |  "+session.getAttribute("cust_no"));
      
   }
   
   //�깉湲� �옉�꽦
   @RequestMapping(value="postInsert.do", method = RequestMethod.GET)
   public void insertForm(Model model, int cust_no, String nickname, int group, PostVO post, HttpServletRequest request) {
      nextId=dao.getNextId(group);
      post.setP_id(nextId);
      nextNo=dao.getNextNo(group);
      post.setP_no(nextNo);
            
      System.out.println("�떎�쓬 湲� id : "+nextId);
      System.out.println("�떎�쓬 湲� no : "+nextNo);
      System.out.println("group : "+group);
      System.out.println("cust_no : "+c_dao.findByCust_No(cust_no).getCust_no());
      model.addAttribute("p_id", nextId);
      model.addAttribute("p_no", nextNo);
      model.addAttribute("group", group);
      model.addAttribute("c", c_dao.findByCust_No(cust_no));
   }
   @RequestMapping(value="postInsert.do", method = RequestMethod.POST)
   public ModelAndView insertSubmit(PostVO pvo, int group,int cust_no, int p_id, int p_no, String p_title,String p_content, HttpServletRequest request) {
      
      System.out.println("�룞�옉!!");
      
      String path=request.getRealPath("img");
      System.out.println("path : "+path);
      
      MultipartFile uploadFile = pvo.getUploadFile();
      String fname = uploadFile.getOriginalFilename();
      
      System.out.println("uploadFile name  :  "+uploadFile);
      System.out.println("fname  :  "+fname);
      
      if(fname != null && !fname.equals("")) {
         try {
            byte[] data = uploadFile.getBytes();
            FileOutputStream fos = new FileOutputStream(path + "/" + fname);
            fos.write(data);
            fos.close();
         }catch (Exception e) {
            System.out.println("�삁�쇅諛쒖깮 : " + e.getMessage());
         }
         pvo.setFname(fname);
        } else{
           pvo.setFname("");
        }
//      pvo.setFname(fname);
      
      
      //湲�癒몃━ option媛� 諛쏆븘�삤湲�
      System.out.println(request.getParameter("p_option"));
      String p_option=request.getParameter("p_option");
      
      
//      CustomerVO c=new CustomerVO();
      String p_writer=c_dao.findByCust_No(cust_no).getNickname();
      int p_hit=0;
      
      HashMap map=new HashMap();
      map.put("group", group);
      map.put("p_id", p_id);
      map.put("p_no", p_no);
      map.put("cust_no", cust_no);
      map.put("p_title", p_title);
      map.put("p_writer", p_writer);
      map.put("p_content", p_content);
      map.put("p_hit", p_hit);
      map.put("fname", fname);
      map.put("p_option", p_option);
            
      ModelAndView mav=new ModelAndView("redirect:/postList.do?option=p_title&search=&group="+group);
      int re=dao.insert(map);
      if(re<=0) {
         mav.addObject("msg", "寃뚯떆湲��씠 �젙�긽�쟻�쑝濡� �벑濡앸릺吏� �븡�븯�뒿�땲�떎.");
         mav.setViewName("error");
      }
      return mav;
   }
   
   //寃뚯떆湲� �닔�젙
   @RequestMapping(value="postUpdate.do", method = RequestMethod.GET)
   public void update(int group, int p_id, int cust_no, String nickname, Model model) {
      System.out.println("group  :  "+group);

      HashMap map=new HashMap();
      map.put("p_id", p_id);
      map.put("group", group);
      map.put("cust_no", cust_no);
      
      
      System.out.println("湲��벑濡앹옄 �쉶�썝踰덊샇 : "+dao.findById(map).getCust_no());
      System.out.println("濡쒓렇�씤�맂 �쉶�썝踰덊샇 : "+c_dao.findByCust_No(cust_no).getCust_no());
         
      model.addAttribute("group", group);
      model.addAttribute("c", c_dao.findByCust_No(cust_no));
      model.addAttribute("post", dao.findById(map));
   }
   @RequestMapping(value="postUpdate.do", method = RequestMethod.POST)
   public ModelAndView update(HttpServletRequest request, PostVO pvo, int group, MultipartFile uploadFile) {

      System.out.println("group  :  "+group);
      
      
      String path = request.getRealPath("img");
      System.out.println("path: "+path);
      String oldFname = pvo.getFname();
      String fname = uploadFile.getOriginalFilename();
      if(fname != null && !fname.equals("")) {
         pvo.setFname(fname);
         try {
            byte[] data = uploadFile.getBytes();
            FileOutputStream fos = new FileOutputStream(path + "/" + fname);
            fos.write(data);
            fos.close();
         }catch (Exception e) {
            System.out.println("�삁�쇅諛쒖깮 : " + e.getMessage());
         }
         pvo.setFname(fname);
        } else{
           // oldFname set�쑝濡� 異붽�
           pvo.setFname(oldFname);
        }
      
      //湲�癒몃━ option媛� 諛쏆븘�삤湲�
      System.out.println("�궡湲��닔�젙 �럹�씠吏� 湲�癒몃━ : "+request.getParameter("p_option"));
      String p_option=request.getParameter("p_option");
      pvo.setP_option(p_option);
      
      ModelAndView mav=new ModelAndView("redirect:/postDetail.do?p_id="+pvo.getP_id()+"&&group="+group);
      int re = dao.update(pvo);
      if(re<=0) {
         mav.addObject("msg", "寃뚯떆湲��씠 �젙�긽�쟻�쑝濡� �닔�젙�릺吏� �븡�븯�뒿�땲�떎.");
         mav.setViewName("error");
        }else {
         if(fname != null && !fname.equals("") && !pvo.getFname().equals("")) {
            File file = new File(path + "/" + oldFname);
                                    // oldFname�쑝濡� 蹂�寃�
            file.delete();
         }
        }
        return mav;
   }
   
   //寃뚯떆湲� �궘�젣
   @RequestMapping(value = "postDelete.do", method = RequestMethod.POST)
   @ResponseBody
   public String delete(int p_id, int cust_no, int group, HttpServletRequest request) {
      int re=-1;
            
      System.out.println("DEL 諛쏆븘�삩 cust_no :  "+cust_no);
      System.out.println("DEL 諛쏆븘�삩 p_id  :  "+p_id);
      
      
      HashMap map=new HashMap();
      map.put("group", group);
      map.put("p_id",p_id);
      map.put("cust_no",cust_no);
      
      System.out.println("DEL map :  "+ map);
      
      re=dao.delete(map);
      
      System.out.println("DEL re:   "+re);
      return Integer.toString(re);
   }
}