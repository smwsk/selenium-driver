package com.smu.selenium.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * <pre>
 * 配置文件读取工具,不建议使用该类,只有在这种写法: @Value("${demo.demoValue}")<br/>
 * private String test; 无法满足需求时,再建议使用该类(因为@value写法在服务器没有重启的时候不会生效)
 * </pre>
 */
public class PropertiesUtil {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    private Properties properties;

    private String fileName;

    /**
     * 默认的属性文件名称
     **/
    public static final String DEFAULT_PROPERTY = "application.properties";

    /**
     * @param fileName 配置文件名，放置与 classpath 根目录
     * @throws IOException
     */
    public PropertiesUtil(String fileName) {
        this.fileName = fileName;
        try {
            Resource resource = new ClassPathResource(fileName);
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            log.error("加载配置{}文件失败!", fileName, e);
            properties = new Properties();
        }
    }

    /**
     * 构造方法，默认加载application.properties
     */
    public PropertiesUtil() {
        this.fileName = DEFAULT_PROPERTY;
        try {
            Resource resource = new ClassPathResource(fileName);
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (Exception e) {
            log.error("加载配置文件[{}]失败:{}", this.fileName, e.getMessage());
            properties = new Properties();
        }
    }

    /**
     * 获取属性值
     *
     * @param propertyName 属性名称
     * @return String
     */
    public String getProperty(String propertyName) {
        if (BaseUtil.isNullOrEmpty(propertyName)) {
            return null;
        }
        return properties.getProperty(propertyName);
    }

    /**
     * 获取属性值
     *
     * @param propertyName 属性名称
     * @param defalutValue 默认值
     * @return String
     */
    public String getProperty(String propertyName, String defalutValue) {
        String property = getProperty(propertyName);
        if (BaseUtil.isNullOrEmpty(property)) {
            return property;
        }
        return defalutValue;
    }

    /**
     * 获取属性名称列表
     *
     * @return Properties
     */
    public Properties getProperties() {
        return this.properties;
    }
}
