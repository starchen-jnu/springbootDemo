package com.star.api;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: sis_mh_content
 * @Author: jeecg-boot
 * @Date:   2020-09-22
 * @Version: V1.0
 */
@Data

public class SisMhContentDto implements Serializable {
    private static final long serialVersionUID = 1L;

	/**内容id*/

    private String id;
	/**版本号*/

    private Integer bbh;
	/**编号*/

    private String bh;
	/**0：未变更，1：新增，2：修改，3：删除*/

    @JSONField(name = "czbzId")
    private Integer czbzid;
	/**检查项目ID*/

    @JSONField(name = "jcdId")
    private String jcdid;
	/**检查方式: 1-远程文件检查，2-实地文件检查，3-远程现场检查，4-实地现场检查*/
    @JSONField(name = "jcfsId")
	private Integer jcfs;
	/**检查频次: 第一值是次数; 第三个值 1表示月，2表示年; 比如1,1,2表示 1(第二个值)年(第三个值)检查1次(第一个值)*/

    private String jcpc;
	/**检查频次类型：1-固定，2-手动输入*/

    private Integer jcpclx;
	/**类型*/

    private Integer lx;
	/**类型：3-检查内容*/

    @JSONField(name = "lxId")
    private Integer lxid;
	/**来源ID*/

    @JSONField(name = "lywtId")
    private String lywtid;
	/**名称*/

    private String mc;
	/**是否可以不列入行政检查计划 1：是 ，0：否*/

    private String sfzc;
	/**适用相对人类型*/

    private String sylx;
	/**序号*/

    private String xh;
	/**状态: 1-有效*/

    private Integer zt;
	/**检查专业ID*/

    @JSONField(name = "zyId")
    private String zyid;
}
