package com.sdl.hosp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadFileMvcConfig implements WebMvcConfigurer {
//	@Value("${file.staticAccessPath}")
//	private String staticAccessPath;
//
//	@Value("${file.uploadFolder}")
//	private String uploadFolder;


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\upload\\images\\";
		String macpath = System.getProperty("user.dir")+"/src/main/resources/static/upload/images/";
		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("win")) {
			registry.addResourceHandler("/static/upload/images/**").
					addResourceLocations("file:"+path);
		}else{//linux和mac系统 可以根据逻辑再做处理
			registry.addResourceHandler("/static/upload/images/**").
					addResourceLocations("file:"+macpath);
		}
		//super.addResourceHandlers(registry);

	}

}
