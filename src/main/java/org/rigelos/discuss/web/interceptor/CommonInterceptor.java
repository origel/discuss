package org.rigelos.discuss.web.interceptor;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class CommonInterceptor extends ControllerInterceptorAdapter {

	static final Log LOG = LogFactory.getLog(CommonInterceptor.class);

	@Override
	public Object before(Invocation inv) throws Exception {
		inv.addModel("contextPath", inv.getRequest().getContextPath());
		inv.addModel("now", System.currentTimeMillis());
		return true;
	}
}
