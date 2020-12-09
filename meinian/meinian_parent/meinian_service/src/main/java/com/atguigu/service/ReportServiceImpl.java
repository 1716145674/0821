package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.MemberMapper;
import com.atguigu.dao.OrderMapper;
import com.atguigu.dao.SetMealMapper;
import com.atguigu.pojo.MemberExample;
import com.atguigu.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service(interfaceClass = ReportService.class)
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
   private MemberMapper memberMapper;
    @Autowired
    private SetMealMapper setMealMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Map<String, Object> getMemberReportData() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        List<String> months=new ArrayList<>();
        List<Integer> memberCount=new ArrayList<>();
        //获得当前时间一年之前的日期
        Calendar now = Calendar.getInstance();

        now.add(Calendar.MONTH,-12);

        for (int i = 0; i <12 ; i++) {
            now.add(Calendar.MONTH,1);
            months.add(DateUtils.parseDate2String(now.getTime()));
            MemberExample memberExample = new MemberExample();
            memberExample.createCriteria().andRegtimeLessThanOrEqualTo(now.getTime());
            Long count = memberMapper.countByExample(memberExample);
            memberCount.add(count.intValue());
        }

        map.put("months",months);
        map.put("memberCount", memberCount);

        return map;
    }

    @Override
    public Map<String, Object> getSetmealReport() {
        Map<String,Object> data=new HashMap<>();
        List<String> names=new ArrayList<>();
        List<Map<String,Object>> mapperData=setMealMapper.getSetmealReport();

        for (Map<String, Object> mapperDatum : mapperData) {
            String name = (String) mapperDatum.get("name");
            names.add(name);
        }
        data.put("setmealNames",names);
        data.put("setmealCount",mapperData);

        return data;
    }

    @Override
    public Map<String, Object> getBusinessReportData() throws Exception {
        HashMap<String, Object> map;
        // 日期工具类
        // 1：当前时间
        String today = DateUtils.parseDate2String(DateUtils.getToday());
        // 2：本周（周一）
        String weekMonday = DateUtils.parseDate2String(DateUtils.getThisWeekMonday());
        // 3：本周（周日）
        String weekSunday = DateUtils.parseDate2String(DateUtils.getSundayOfThisWeek());
        // 4：本月（1号）
        String monthFirst = DateUtils.parseDate2String(DateUtils.getFirstDay4ThisMonth());
        // 5：本月（31号）
        String monthLast = DateUtils.parseDate2String(DateUtils.getLastDay4ThisMonth());
        // （1）今日新增会员数
        int todayNewMember = memberMapper.getTodayNewMember(today);
        // （2）总会员数
        int totalMember = memberMapper.getTotalMember();
        // （3）本周新增会员数
        int thisWeekNewMember = memberMapper.getThisWeekAndMonthNewMember(weekMonday);
        // （4）本月新增会员数
        int thisMonthNewMember = memberMapper.getThisWeekAndMonthNewMember(monthFirst);
        // （5）今日预约数
        int todayOrderNumber = orderMapper.getTodayOrderNumber(today);
        // （6）今日出游数
        int todayVisitsNumber = orderMapper.getTodayVisitsNumber(today);
        // （7）本周预约数
        Map<String,Object> paramWeek = new HashMap<String,Object>();
        paramWeek.put("begin",weekMonday);
        paramWeek.put("end",weekSunday);
        int thisWeekOrderNumber = orderMapper.getThisWeekAndMonthOrderNumber(paramWeek);
        // （9）本月预约数
        Map<String,Object> paramMonth = new HashMap<String,Object>();
        paramMonth.put("begin",monthFirst);
        paramMonth.put("end",monthLast);
        int thisMonthOrderNumber = orderMapper.getThisWeekAndMonthOrderNumber(paramMonth);
        // （8）本周出游数
        Map<String,Object> paramWeekVisit = new HashMap<String,Object>();
        paramWeekVisit.put("begin",weekMonday);
        paramWeekVisit.put("end",weekSunday);
        int thisWeekVisitsNumber = orderMapper.getThisWeekAndMonthVisitsNumber(paramWeekVisit);
        // （10）本月出游数
        Map<String,Object> paramMonthVisit = new HashMap<String,Object>();
        paramMonthVisit.put("begin",monthFirst);
        paramMonthVisit.put("end",monthLast);
        int thisMonthVisitsNumber = orderMapper.getThisWeekAndMonthVisitsNumber(paramMonthVisit);
        // （11）热门套餐
        List<Map<String,Object>> hotSetmeal = orderMapper.findHotSetmeal();

        map = new HashMap<>();
        /*
         *      reportDate（当前时间）--String
         *      todayNewMember（今日新增会员数） -> number
         *      totalMember（总会员数） -> number
         *      thisWeekNewMember（本周新增会员数） -> number
         *      thisMonthNewMember（本月新增会员数） -> number
         *      todayOrderNumber（今日预约数） -> number
         *      todayVisitsNumber（今日出游数） -> number
         *      thisWeekOrderNumber（本周预约数） -> number
         *      thisWeekVisitsNumber（本周出游数） -> number
         *      thisMonthOrderNumber（本月预约数） -> number
         *      thisMonthVisitsNumber（本月出游数） -> number
         *      hotSetmeal（热门套餐（取前4）） -> List<Setmeal>
         **/
        map.put("reportDate",today);
        map.put("todayNewMember",todayNewMember);
        map.put("totalMember",totalMember);
        map.put("thisWeekNewMember",thisWeekNewMember);
        map.put("thisMonthNewMember",thisMonthNewMember);
        map.put("todayOrderNumber",todayOrderNumber);
        map.put("todayVisitsNumber",todayVisitsNumber);
        map.put("thisWeekOrderNumber",thisWeekOrderNumber);
        map.put("thisWeekVisitsNumber",thisWeekVisitsNumber);
        map.put("thisMonthOrderNumber",thisMonthOrderNumber);
        map.put("thisMonthVisitsNumber",thisMonthVisitsNumber);
        map.put("hotSetmeal",hotSetmeal);
        return map;
    }


}
