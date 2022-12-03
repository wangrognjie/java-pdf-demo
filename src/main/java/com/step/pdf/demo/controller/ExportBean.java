package com.step.pdf.demo.controller;

import lombok.Builder;
import lombok.Data;

/**
 * @author ddwrj
 */
@Data
@Builder
public class ExportBean {

    private String text1;
    private String text2;
    private String imgBase64;
}
