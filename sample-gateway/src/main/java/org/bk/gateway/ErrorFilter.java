package org.bk.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ErrorFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		
		RequestContext requestContext = RequestContext.getCurrentContext();
		//System.out.println("~~~~~~~~~~~~~~~~:"+requestContext.get("error.status_code"));
		
		if(requestContext.get("error.status_code") != null){
			//int status = Integer.parseInt((String)requestContext.get("error.status_code"));
			String status = String.valueOf(requestContext.get("error.status_code"));
			if(status.equals("500")){
				 return true;
			}
			
		}
		
		
		return false;
		
	}

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		System.out.println("--------start invoke my error filter--------------");
		return "invoke my error filter";
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
