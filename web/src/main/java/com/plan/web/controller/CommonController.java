package com.plan.web.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plan.common.vcode.Captcha;
import com.plan.common.vcode.GifCaptcha;
import com.plan.common.vcode.utils.VerifyCodeUtils;

/**
 * 通用控制器
 * @author weizx
 * @date 2017-11-23
 *
 */
@Controller
@Scope(value = "prototype")
public class CommonController {
	private static final Logger LOG = LoggerFactory.getLogger(CommonController.class);

	/**
	 * 获取验证码
	 * 
	 * @param response
	 */
	@RequestMapping(value = "/open/getVCode.html", method = RequestMethod.GET)
	public void getVCode(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpg");

			// 生成随机字串
			String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
			LOG.info("验证码：{}", verifyCode);
			// 生成图片
			int w = 146, h = 33;
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (Exception e) {
			LOG.error("获取验证码异常：{}", e.getMessage());
		}
	}

	/**
	 * 获取验证码（Gif版本）
	 * 
	 * @param response
	 */
	@RequestMapping(value = "/open/getGifCode.html", method = RequestMethod.GET)
	public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/gif");
			/**
			 * gif格式动画验证码 宽，高，位数。
			 */
			Captcha captcha = new GifCaptcha(146, 42, 4);
			// 输出
			ServletOutputStream out = response.getOutputStream();
			captcha.out(out);
			out.flush();
			LOG.info("验证码：{}", captcha.text().toLowerCase());
		} catch (Exception e) {
			LOG.error("获取验证码异常：{}", e.getMessage());
		}
	}
}
