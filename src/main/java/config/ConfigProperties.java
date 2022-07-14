package config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:./src/main/resources/config.properties"})
public interface ConfigProperties extends Config {
	
	@DefaultValue("${baseUrl}")
	String baseUrl();
	
	@DefaultValue("${firstname}")
	String firstname();
	
	@DefaultValue("${lastname}")
	String lastname();
	
	@DefaultValue("${phone}")
	String phone();
	
	@DefaultValue("${password}")
	String password();

}
