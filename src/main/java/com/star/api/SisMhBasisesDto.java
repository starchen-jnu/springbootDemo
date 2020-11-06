package com.star.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: sis_mh_basises
 * @Author: jeecg-boot
 * @Date:   2020-09-22
 * @Version: V1.0
 */
@Data

public class SisMhBasisesDto implements Serializable {
    private static final long serialVersionUID = 1L;

	/**检查依据id*/

    private String id;
	/**版本号*/

    private Integer bbh;
	/**0：未变更, 1：新增, 2：修改*/

    @JSONField(name = "czbzId")
    private Integer czbzid;
	/**检查项目ID*/


    private String jcdid;
	/**检查项目ID*/


    private String jcdwtid;
	/**法规条款ID*/


    private String jctkid;
	/**法规条款*/

    private String jctkmc;
	/**法规依据ID*/


    private String jcyjid;
	/**法规依据名称*/

    private String jcyjmc;
	/**法规依据id*/
    @JSONField(name = "lyyjId")
    private String lyyjid;
	/**更新时间*/

	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH-mm-ss")
    private Date xgsj;
	/**显示顺序*/

    private Integer xssx;
	/**状态: 1-有效*/

    private Integer zt;
}
