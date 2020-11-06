package com.star.project;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: StarC
 * @Date: 2020/8/5 16:01
 * @Description:
 */
@Data
@AllArgsConstructor
public class DayplansVo {

    private String departId;
    private String departName;
    private String sysOrgCode;
    private String orgName;
    private Date startDate;

}
