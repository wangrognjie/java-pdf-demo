package com.step.pdf.demo.controller;

import com.step.pdf.demo.util.PdfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class DemoController {

    @Autowired
    private PdfRenderService pdfRenderService;

    @Autowired
    private PdfContentGenerator contentGenerator;

    @GetMapping("pdf")
    public void test(HttpServletResponse response) throws Exception {

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "filename=" + new String(("export.pdf").getBytes(), StandardCharsets.UTF_8));
        OutputStream os = response.getOutputStream();

        final String fileToBase64 = PdfUtil.encryptFileToBase64("C:\\Users\\ddwrj\\Pictures\\bg.jpg");

        ExportBean bean= ExportBean.builder()
                .text1("水平居中水平居中水平居中水平居中水平居中水平居中水平居中")
                .text2("垂直居中垂直居中垂直居中垂直居中垂直居中垂直居中垂直居中")
                .imgBase64(fileToBase64)
                .build();
        final String generate = contentGenerator.generate(bean);
        pdfRenderService.rendPdf(os,generate);
    }
}
