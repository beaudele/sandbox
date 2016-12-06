package com.sandbox.springmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * The Class SandBoxConfiguration.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sandbox.springmvc")
@ImportResource("classpath:application-context.xml")
public class SandBoxConfiguration extends WebMvcConfigurerAdapter {

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#
   * configureViewResolvers(org.springframework.web.servlet.config.annotation.ViewResolverRegistry)
   */
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/WEB-INF/views/");
    viewResolver.setSuffix(".jsp");
    registry.viewResolver(viewResolver);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(
   * org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCachePeriod(0);
  }

}
