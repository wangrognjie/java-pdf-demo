package com.step.pdf.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * @author ddwrj
 */
@Component
@Slf4j
public class PdfContentGenerator {

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    public String generate(ExportBean exportBean){
        Context context = new Context();
        context.setVariable("text_h_center", exportBean.getText1());
        context.setVariable("text_v_center", exportBean.getText2());
        context.setVariable("img_base64",exportBean.getImgBase64());

        return springTemplateEngine.process("experts-template", context);
    }
}
