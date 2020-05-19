/**
 * 
 */
package com.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
@RequestMapping(path = "/api")
public class SampleApi {
	@Value("${hellomessage}")
	private String hello;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getConf() {
		return this.hello;
	}
}
