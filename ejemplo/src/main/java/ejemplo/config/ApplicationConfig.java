package ejemplo.config;

import java.util.List;
import java.util.Locale;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.orm.hibernate4.support.OpenSessionInViewInterceptor;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ejemplo"})
public class ApplicationConfig extends WebMvcConfigurerAdapter {

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		OpenSessionInViewInterceptor osivi = new OpenSessionInViewInterceptor();
		osivi.setSessionFactory(sessionFactory);
		registry.addWebRequestInterceptor(osivi);
	}
	
	@Override
    public void configureMessageConverters( List<HttpMessageConverter<?>> converters ) {
        converters.add(converter());
    }

    @Bean
    MappingJacksonHttpMessageConverter converter() {
    	MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
    	return converter;
    }
	
    @Bean
    /**
     * MultiPart Resolver.
     */
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
    
    
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver isvr = new InternalResourceViewResolver();
		isvr.setPrefix("/WEB-INF/views/");
		isvr.setSuffix(".jsp");
		return isvr;
	}

}
