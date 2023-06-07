package com.zuxia.controller;

import java.security.interfaces.RSAKey;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zuxia.entity.RecruitInfo;
import com.zuxia.service.IRecruitService;

@Controller
@RequestMapping(value="/recrC")
public class RecruitController {
	private static Logger log=LoggerFactory.getLogger(RecruitController.class);
	@Resource(name="rserviceimp")
	private IRecruitService recrus;
	
	//查询的访问方法
		@GetMapping(value="/showRec")
		public ModelAndView showStu(){
			List<RecruitInfo> slist= recrus.selectAll();
			ModelAndView mav=new ModelAndView("show");
			mav.addObject("slist", slist);
			return mav;
		}
	//修改回显
		@GetMapping(value="/upShow/{id}")
		public String upShow(@PathVariable(name="id")int id,HttpServletRequest req){
			RecruitInfo recruitInfo= recrus.selectById(id);
			
			if(recruitInfo!=null) {
				req.getSession().setAttribute("recruit", recruitInfo);
				return "update";
			}
				
				return "redirect:/recrC/showRec";
		}
		//修改
		@PostMapping(value="/update")
		public String update(RecruitInfo rec){
			boolean flag=false;
			try {
				flag=recrus.update(rec);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			if(flag){
				log.info("修改信息成功");
				return "redirect:/recrC/showRec";
				
			}
				return "fail";
			
		}
		
		
		//删除	
		@GetMapping(value="/del/{id}")
		public String delete(@PathVariable(name="id")int id,HttpServletRequest req){
			boolean flag=false;
			try {
				flag=recrus.delete(id);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			if(flag){
				log.info("信息删除成功");
				return "redirect:/recrC/showRec";
				
			}
				return "fail";
			
			
		}	
		
		//添加招聘信息
		@PostMapping(value="/insert")
		public String insert(RecruitInfo rec){
			boolean flag=false;
			try {
				flag=recrus.insert(rec);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			if(flag){
				log.info("发布信息成功");
				return "redirect:/recrC/showRec";
				
			}
				return "fail";
			
		}
		//查询的首页方法
				@GetMapping(value="/info")
				public ModelAndView info(){
					List<RecruitInfo> slist= recrus.selectAll();
					ModelAndView mav=new ModelAndView("info");
					mav.addObject("slist", slist);
					return mav;
				}

}
