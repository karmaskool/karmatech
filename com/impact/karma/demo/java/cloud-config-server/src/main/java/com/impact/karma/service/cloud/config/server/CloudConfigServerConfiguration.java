package com.impact.karma.service.cloud.config.server;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Data
@Slf4j
public class CloudConfigServerConfiguration {

	@Value("${spring.cloud.config.server.git.basedir}")
	private String gitFolder;

	@Value("${spring.cloud.config.server.git.default-label}")
	private String gitLabel;
	
	public void printGitConfig() throws IOException {
		File f = new File(gitFolder);
		log.info("spring.cloud.config.server.git.basedir="+gitFolder);
		log.info("gitLabel="+gitLabel);
		log.info("git FOLDER:getAbsolutePath()="+f.getAbsolutePath());
		log.info("git FOLDER:getCanonicalPath()="+f.getCanonicalPath());
	}
}
