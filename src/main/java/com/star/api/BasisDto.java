package com.star.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author StarC
 * @Date 2020/9/22 15:21
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasisDto implements Serializable {
    private String id;
    @JSONField(name = "bbh")
    private Integer bb;
    private Integer czbzId;
    private String jcdid;
    private String jcdwtid;
    private String jctkid;
    private String jctkmc;
    private String  jcyjid;
    private String jcyjmc;
    private String lyyjId;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JSONField(name ="xgsj")
    private Date xgs;
    private Integer xssx;
    private Integer zt;






}
