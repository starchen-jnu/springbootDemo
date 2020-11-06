package com.star.api;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: sis_mh_businesses
 * @Author: jeecg-boot
 * @Date:   2020-09-22
 * @Version: V1.0
 */
@Data

public class SisMhBusinessesDto implements Serializable {
    private static final long serialVersionUID = 1L;

	/**业务id*/

    private String id;
	/**版本号*/

    private Integer bbh;
	/**公司手册*/

    private String handbook;
	/**状态：9-有效*/

    private Integer status;
	/**业务编号*/

    @JSONField(name = "ywNo")
    private String ywno;
	/**业务类型: 1-正式，2-临时*/

    @JSONField(name = "ywlxId")
    private Integer ywlxid;
	/**业务名称*/

    private String ywmc;
	/**业务所属专业ID*/

    @JSONField(name = "zyId")
    private String zyid;
}
