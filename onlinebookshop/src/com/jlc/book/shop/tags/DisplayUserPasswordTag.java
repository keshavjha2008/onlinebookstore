package com.jlc.book.shop.tags;

import java.io.Writer;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;

import com.jlc.book.shop.to.*;

import org.apache.log4j.Logger;

public class DisplayUserPasswordTag extends TagSupport {
Logger log=Logger.getLogger(this.getClass());
public int doEndTag() throws JspException{
	try {
		HttpSession sess=(HttpSession)pageContext.getSession();
		Object obj=sess.getAttribute("USER_TO");
		if(obj!=null){
			UserTO uto=(UserTO)obj;
			int l=uto.getPassword().length();
			Writer out=pageContext.getOut();
			for (int i = 0; i < l; i++) {
				out.write("*");
			}
		}
	} catch (Exception e) {
		log.error("Exception in ValidateSessionTag", e);
	}
	return EVAL_PAGE;
}
}
