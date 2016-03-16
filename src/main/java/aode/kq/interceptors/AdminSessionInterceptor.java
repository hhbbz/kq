package aode.kq.interceptors;

import aode.kq.been.AjaxResult;
import aode.kq.model.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 商家拦截器
 */
public class AdminSessionInterceptor implements HandlerInterceptor {


	private List<String> excludeUrls;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		if (excludeUrls.contains(url)) {
			return true;
		} else {
			Admin loginAdmin = (Admin) request.getSession().getAttribute("loginAdmin");
			if (loginAdmin != null && loginAdmin.getId()!= null && !loginAdmin.getId().equals("")) {
				return true;
			} else {
				request.setAttribute("result", new AjaxResult(false, "您还没有登录或登录已超时，请重新登录"));
				request.getRequestDispatcher("/WEB-INF/admin/loginUI.jsp").forward(request, response);
				return false;
			}
		}
	}

}
