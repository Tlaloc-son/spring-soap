package pokemon.api.configuration;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import pokemon.api.service.LogService;
import pokemon.api.tool.Context;

@Component
@Order(1)
public class TimingFilter implements Filter{

	public static final Log LOGGER = LogFactory.getLog(TimingFilter.class);
	
	private LogService logService;
	
	public TimingFilter(LogService logService) {
		this.logService = logService;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		pokemon.api.entity.Log log = logService.save(req.getRemoteAddr(), Context.resource.get(), System.currentTimeMillis() - start);
        LOGGER.info(String.format("resource:[%s] ip:[%s] took:[%d ms]", log.getResource(), log.getIp(), log.getTook()));		
	}
}
