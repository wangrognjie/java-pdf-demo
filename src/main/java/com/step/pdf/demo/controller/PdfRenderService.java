package com.step.pdf.demo.controller;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.OutputStream;

/**
 * @author ddwrj
 */
@Component
@Slf4j
public class PdfRenderService {

    public void rendPdf(OutputStream output,String content) throws Exception {
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFont(ResourceUtils.getFile("classpath:fonts/simsun.ttf"), "simsun");
        builder.useFastMode();
        builder.withHtmlContent(content, ResourceUtils.getURL("classpath:img/").toString());
        builder.toStream(output);
        builder.run();
    }
}
