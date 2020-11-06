package com.easypoi;

import lombok.Cleanup;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @Author: StarC
 * @Date: 2020/6/15 15:53
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws Exception {
        File file = new File("D:/20200616.xlsx");
        String fileName = "20200616.xlsx";
        getData(fileName,file);

    }

    public static List<CExcellVo> getData(String fileName, File file)throws Exception{
        @Cleanup Workbook workbook = CExcelUtil.getExcelEngine(fileName, file);
        if (workbook == null) {
            return null;
        }
        Sheet sheet = workbook.getSheetAt(0);
        List<String[]> list = CExcelUtil.adjustExcelParse(sheet, 3, 1, -1, 6, true);
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<CTempLibVo> tempLibVos = new ArrayList<>();
        for(int i = 0;i <list.size();i++){
            String[] col = list.get(i);
            CTempLibVo tempLibVo = new CTempLibVo();
            for(int j = 0;j<col.length;j++ ){
                if(StringUtils.equals(col[j],"null") || StringUtils.isBlank(col[j])){
                    col[j] = list.get(i-1)[j];
                }
            }

            tempLibVo.setOrder(col[0]);
            tempLibVo.setProject(col[1]);
            tempLibVo.setCheckContent(col[2]);
            tempLibVo.setKeyWord(col[3]);
            tempLibVo.setStandard(col[4]);
            tempLibVo.setRule(col[5]);

            tempLibVos.add(tempLibVo);

        }

        List<CExcellVo> excelVos = new ArrayList<>();
        TreeMap<String, List<CTempLibVo>> mapGoupByproject = tempLibVos.stream().collect(Collectors.groupingBy(CTempLibVo::getProject, TreeMap::new, Collectors.toList()));
        for(Map.Entry<String,List<CTempLibVo>> entry:mapGoupByproject.entrySet()){
            CExcellVo excellVo = new CExcellVo();
            TreeMap<String,List<CTempLibVo>> mapGroupByContent = entry.getValue().stream().collect(Collectors.groupingBy(CTempLibVo::getCheckContent,TreeMap::new, Collectors.toList()));
            for(Map.Entry<String,List<CTempLibVo>> itemEntry:mapGroupByContent.entrySet()){
                CItemVo itemVo = new CItemVo();
                List<CTempLibVo> items = itemEntry.getValue();
                for(CTempLibVo item:items){
                    CBasisVo basisVo = new CBasisVo();
                    excellVo.setOrder(item.getOrder());
                    excellVo.setProject(item.getProject());
                    itemVo.setCheckContent(item.getCheckContent());
                    itemVo.setKeyWord(item.getKeyWord());
                    itemVo.setStandard(item.getStandard());
                    basisVo.setRule(item.getRule());
                    itemVo.getBasisVos().add(basisVo);
                }
                excellVo.getItems().add(itemVo);

            }
            excelVos.add(excellVo);
        }
        return excelVos;
    }
}
