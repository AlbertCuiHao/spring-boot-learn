package com.example.leanpoi.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/export")
    public void export(HttpServletResponse response) {
        //1.构造数据
        String[] head = new String[3];
        List<String[]> content = new ArrayList<>();
        head[0] = "id";
        head[1] = "name";
        head[2] = "age";
        content.add(new String[]{"1", "Albert", "14"});
        content.add(new String[]{"2", "Ben", "17"});
        content.add(new String[]{"3", "June", "18"});
        String fileName = "poi_demo";
        exportExcel(response, head, content, fileName);
    }

    public void exportExcel(HttpServletResponse response, String[] head, List<String[]> content, String fileName) {
        //1.创建workbook工作簿
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             OutputStream output = response.getOutputStream()) {
            //2.创建表单Sheet
            Sheet sheet = workbook.createSheet();
            // 自动设置宽度
            sheet.autoSizeColumn(0);
            //3. title
            CellStyle titleStyle = getTitleStyle(workbook);
            writeTitle(sheet, head, titleStyle);
            //4. content
            CellStyle contentStyle = getContentStyle(workbook);
            writeContent(sheet, content, contentStyle);
            //5.文件流
            fileName = fileName + ".xlsx";
            setResponseHeader(response, fileName);
            //6.写入文件
            workbook.write(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void writeTitle(Sheet sheet, String[] head, CellStyle titleStyle) {
        Row titleRow = sheet.createRow(0);
        for (int i = 0; i < head.length; i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellValue(head[i]);
            cell.setCellStyle(titleStyle);
        }
    }

    public void writeContent(Sheet sheet, List<String[]> content, CellStyle contentStyle) {
        for (int i = 0; i < content.size(); i++) {
            Row titleRow = sheet.createRow(i + 1);
            String[] strings = content.get(i);
            for (int j = 0; j < strings.length; j++) {
                Cell cell = titleRow.createCell(j);
                cell.setCellValue(strings[j]);
                cell.setCellStyle(contentStyle);
            }
        }
    }

    public CellStyle getTitleStyle(Workbook workbook) {
        //标题样式
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.LEFT);
        // 设置字体样式
        Font titleFont = workbook.createFont();
        titleFont.setFontName("黑体");
        titleFont.setFontHeightInPoints((short) 13);
        titleStyle.setFont(titleFont);
        return titleStyle;
    }

    public CellStyle getContentStyle(Workbook workbook) {
        // 数据样式
        CellStyle contentStyle = workbook.createCellStyle();
        contentStyle.setAlignment(HorizontalAlignment.CENTER);
        return contentStyle;
    }

    private void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            fileName = new String(fileName.getBytes(), StandardCharsets.ISO_8859_1);
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
