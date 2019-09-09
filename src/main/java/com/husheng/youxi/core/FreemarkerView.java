package com.husheng.youxi.core;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

public class FreemarkerView extends FreeMarkerView {

	@Override
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		String base = RequestUtil.getBasePath(request);
		model.put("rootPath", base);
		model.put("adminPath", base+"/admin");
		super.exposeHelpers(model, request);
	}
}
