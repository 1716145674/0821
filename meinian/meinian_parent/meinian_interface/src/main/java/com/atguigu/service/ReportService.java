package com.atguigu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface ReportService {
    Map<String, Object> getMemberReportData() throws Exception;

    Map<String, Object> getSetmealReport();

    Map<String, Object> getBusinessReportData() throws Exception;


}
