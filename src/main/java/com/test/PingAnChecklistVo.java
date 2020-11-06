package com.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: StarC
 * @Date: 2020/7/8 9:37
 * @Description:
 */
@Data

@NoArgsConstructor
public class PingAnChecklistVo {
    List<PingAnCheckListItemVo> checkListItemVoList;
}
