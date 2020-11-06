package com.star.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: sis_mh_item
 * @Author: jeecg-boot
 * @Date:   2020-09-22
 * @Version: V1.0
 */
@Data
public class SisMhItemDto implements Serializable {
    private static final long serialVersionUID = 1L;

	/**检查项目ID*/

    private String id;
	/**版本号*/

    private Integer bbh;
	/**备注*/

    private String bz;
	/**操作备注：0：未变更, 1：新增, 2: 修订, 4: 即将失效*/

    @JSONField(name = "czbzId")
    private Integer czbzid;
	/**发布时间*/

    private String fbsj;
	/**检查项目编号*/
    @JSONField(name = "jcdBh")
    private String jcdbh;
	/**检查项目名称*/

    private String jcdmc;
	/**有效结束日期*/

	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH-mm-ss")
    private Date jsrq;
	/**有效开始日期*/

	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH-mm-ss")
    private Date ksrq;
	/**来源ID(父版本ID)*/

    @JSONField(name = "lyId")
    private String lyid;
	/**适用范围(21.22这种是历史原因写入的，目前已经失去意义)*/

    private String syfw;
	/**业务ID*/

    @JSONField(name = "ywId")
    private String ywid;
	/**业务类型: 1-标准库，2-临时库*/

    @JSONField(name = "ywlxId")
    private Integer ywlx;
	/**状态：4-即将失效，8-归档失效(当前项目下的内容失效)，9-有效*/

    private Integer zt;
	/**专业ID*/

    @JSONField(name = "zyId")
    private String zyid;
}
