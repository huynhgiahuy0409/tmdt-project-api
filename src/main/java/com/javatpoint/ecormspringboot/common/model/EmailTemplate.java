package com.javatpoint.ecormspringboot.common.model;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class EmailTemplate {
    private String template;
    private Map<String, String> replacementParams;
    public String htmlPath;
    public EmailTemplate(String templateFilename) {
        try {
            this.template = loadTemplate(templateFilename);
            System.out.printf("ok" + this.template);
        } catch (Exception e) {
            this.template = "Empty";
            System.out.printf("!ok" + this.template);
        }
    }

    private String loadTemplate(String customeTemplate) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(customeTemplate);
        String content = "Empty";
        try {
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new Exception("Could not read template  = " + customeTemplate);
        }
        return content;
    }
    public String getTemplate(Map<String, String> replacements) {
        String cTemplate = this.template;
        //Replace the String
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            cTemplate = cTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return cTemplate;
    }
}
