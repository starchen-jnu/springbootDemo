package com.star.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: sis_mh_standard
 * @Author: jeecg-boot
 * @Date:   2020-09-22
 * @Version: V1.0
 */
@Data
public class SisMhStandardDto implements Serializable {
    private static final long serialVersionUID = 1L;


    private String id;
	/**版本号*/

    private Integer bbh;
	/**检查标准名称*/

    private String bzmc;
	/**操作标识 0：未变更，1：新增，2：修改*/
    @JSONField(name = "czbzId")
    private Integer czbs;
	/**检查项目ID*/

    @JSONField(name = "jcdId")
    private String jcdid;
	/**检查内容ID*/


    private String jcdwtid;
	/**lybzid*/


    private String lybzid;
	/**修改时间*/

	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH-mm-ss")
    private Date xgsj;
	/**显示顺序*/

    private Integer xssx;
	/**状态：1-有效*/

    private Integer zt;
}
