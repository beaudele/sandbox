package com.sandbox.springmvc.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * The Class SandBoxInitializer.
 */
public class SandBoxInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#
   * getRootConfigClasses()
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {SandBoxConfiguration.class};
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#
   * getServletConfigClasses()
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings
   * ()
   */
  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletFilters(
   * )
   */
  @Override
  protected Filter[] getServletFilters() {
    Filter[] singleton = {new CorsFilter()};
    return singleton;
  }

}
