package com.star.api;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: sis_mh_profession
 * @Author: jeecg-boot
 * @Date:   2020-09-22
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
public class SisMhProfessionDto implements Serializable {
    private static final long serialVersionUID = 1L;

	/**检查专业ID*/

    private String id;
	/**专业编号*/

    private String bh;
	/**关联专业*/

    private String glzy;
	/**关联专业ID*/

    @JSONField(name = "glzyId")
    private String glzyid;
	/**专业名称*/
    @JSONField(name = "m_name")
    private String mName;
	/**状态：0-无效，9-有效*/

    private Integer status;
	/**版本号*/
    private String version;

}
