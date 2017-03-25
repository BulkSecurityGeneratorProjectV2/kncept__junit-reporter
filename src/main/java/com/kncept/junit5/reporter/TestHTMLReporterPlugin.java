package com.kncept.junit5.reporter;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

public class TestHTMLReporterPlugin implements Plugin<Project> {
	
	@Override
	public void apply(Project project) {
		
		project.getExtensions().create("junit5HTMLReportSettings", TestHTMLReporterExtension.class);
		TestHTMLReporterPluginTask junit5HTMLReport = project.getTasks().create("junit5HTMLReport", TestHTMLReporterPluginTask.class);

		//can throw UnknownTaskException
		Task test = project.getTasks().getByName("test");
		junit5HTMLReport.dependsOn(test);
		Task assemble = project.getTasks().getByName("assemble");
		assemble.dependsOn(junit5HTMLReport);
	}

}