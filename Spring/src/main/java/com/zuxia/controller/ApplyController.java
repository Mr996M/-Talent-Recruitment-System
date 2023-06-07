package com.zuxia.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zuxia.entity.ApplyInfo;
import com.zuxia.entity.RecruitInfo;
import com.zuxia.service.IApplyServcie;
import com.zuxia.service.IEmployeeService;
import com.zuxia.service.IRecruitService;

@Controller
@RequestMapping(value="/appC")
public class ApplyController {
	private static Logger log=LoggerFactory.getLogger(RecruitController.class);
	@Resource(name="apseimpl")
	private IApplyServcie appseimpl;
	
	@Resource(name="empserimp")
	private IEmployeeService empser;
	
	@Resource(name="rserviceimp")
	private IRecruitService recser;
	//提交应聘信息方法
	@PostMapping(value = "/addApply")
	public ModelAndView addApply(@RequestParam(name="file1")MultipartFile mfile,HttpServletRequest req){
		boolean flag=false;
		
		//确定上传的文件位置
		File f=new File(req.getServletContext().getRealPath("/")+"/files/"+mfile.getOriginalFilename());
		try {
			//实现文件上传
			mfile.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		//拿到填写应聘信息的内容
		String aname= req.getParameter("aname");
		String tele= req.getParameter("tele");
		String education= req.getParameter("education");
		String status= req.getParameter("status");
		String position= req.getParameter("position");
		//将文件路径存起来
		String cvurl=f.getName();
		//将所有信息存入数据库中
		ApplyInfo applyInfo=new ApplyInfo(aname, tele, education, position,cvurl, status);
		ModelAndView mav=new ModelAndView("redirect:/recrC/info");
		try {
			
			flag=appseimpl.insert(applyInfo);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		if(flag){
			log.info("应聘成功");
			return mav;
			
		}	
			mav.setViewName("fail");
			return mav;
		
	}
	
	//查询方法
	@GetMapping(value = "/findApply")
	public ModelAndView findApply(){
		List<ApplyInfo> slist= appseimpl.selectAll();
		ModelAndView mav=new ModelAndView("appshow");
		mav.addObject("slist", slist);
		return mav;
	}
	
	//下载简历
		@GetMapping(value="/downFile")
		public void downFile(String fname,HttpServletRequest req,HttpServletResponse resp){
			try {
				//处理get请求中文乱码
				//fname=new String(fname.getBytes("ISO-8859-1"), "UTF-8");
				//设置下载响应的头部信息
				resp.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fname, "UTF-8"));
				//输入输出流
				InputStream is=new FileInputStream(new File(req.getServletContext().getRealPath("/")+"/files/"+fname));
				OutputStream os=resp.getOutputStream();
				byte[] bt=new byte[1024];
				int size=0;
				while((size = is.read(bt))!=-1){
					os.write(bt, 0, size);
					bt=new byte[1024];
				}
				os.close();
				is.close();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//前台发送面试邀约,更改状态	
		@GetMapping(value = "/upSta/{aid}")
		public ModelAndView updateSta(@PathVariable(name="aid")int aid){
			boolean flag=false;
			ModelAndView mav=new ModelAndView("redirect:/appC/findApply");
			try {
				flag= appseimpl.updateStatus(aid);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			if(flag){
				log.info("更改成功");
				return mav;
				
			}
			
				mav.setViewName("fail");
				return mav;
		}
		
		//当点击通过按钮执行该方法(面试状态变为已通过,将信息存入员工信息表,招聘职位的数量减少)
		@GetMapping(value = "/pass/{aid}/{aname}/{tele}/{position}")
		public ModelAndView passSta(@PathVariable(name="aid")int aid, @RequestParam(value="op", required=true) String op,@PathVariable(name="aname")String aname,@PathVariable(name="tele")String tele,@PathVariable(name="position")String position){
			if("通过".equals(op)) {
				
				
				RecruitInfo recruitInfo= recser.selectByPos(position);
				if(recruitInfo.getNumber()>0){
					empser.addEmployee(aname,position,tele);
					appseimpl.upnumber(position);
					appseimpl.passUpdate(aid, op);
				}
				
			}else if("不通过".equals(op)){
				appseimpl.passUpdate(aid, op);
			}
			ModelAndView mav=new ModelAndView("redirect:/appC/findApply");
			return mav;
		}
		
		
		
}
