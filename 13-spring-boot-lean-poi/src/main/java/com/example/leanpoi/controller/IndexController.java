package com.example.leanpoi.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        content.add(new String[]{"01", "Albert", "14"});
        content.add(new String[]{"02", "Ben", "17"});
        content.add(new String[]{"03", "June", "18"});
        String fileName = "poi_demo";
        exportExcel(response, head, content, fileName);
    }

    public void exportExcel(HttpServletResponse response, String[] head, List<String[]> content, String fileName) {
        //1.创建workbook工作簿
        try (XSSFWorkbook workbook = new XSSFWorkbook(); OutputStream output = response.getOutputStream()) {
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

    public CellStyle getTitleStyle(Workbook workbook) {
        //标题样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        // 设置字体样式
        Font font = workbook.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 13);
        cellStyle.setFont(font);
        return cellStyle;
    }

    public CellStyle getContentStyle(Workbook workbook) {
        // 数据样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        return cellStyle;
    }

    public void writeTitle(Sheet sheet, String[] head, CellStyle cellStyle) {
        Row row = sheet.createRow(0);
        for (int i = 0; i < head.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(head[i]);
            cell.setCellStyle(cellStyle);
        }
    }

    public void writeContent(Sheet sheet, List<String[]> content, CellStyle cellStyle) {
        for (int i = 0; i < content.size(); i++) {
            Row row = sheet.createRow(i + 1);
            String[] strings = content.get(i);
            for (int j = 0; j < strings.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(strings[j]);
                cell.setCellStyle(cellStyle);
            }
        }
    }

    private void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            fileName = new String(fileName.getBytes(), StandardCharsets.ISO_8859_1);
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
