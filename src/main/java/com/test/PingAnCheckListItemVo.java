package com.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2020/7/8 9:40
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PingAnCheckListItemVo {
    private String versionId;
    private String themeId;
    private String theme;
    private String contentId;
    private String content;
    private String projectId;
    private String departId;
    private String title;
    private String endTime;

}
