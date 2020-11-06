package com.star.springbootdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: StarC
 * @Date: 2019/9/18 13:41
 * @Description:
 */
@NoArgsConstructor
@Data
public class MainData {


    /**公共字段**/
    private String ID;// ID
    private String FEXD;// 航班计划日期
    private String CYR;// 承运人
    private String FLNO;// 航班号
    private String APSD;// 起飞机场（三字码）
    private String APED;// 落地机场（三字码）
    private String FLIO;// 进出港
    private String GLCD;//是否关联仓单0：未关联 1：已关联

    /**IMF航班动态字段**/
    private String FLID;// 航班imf唯一编号
    private String AFID;// 关联航班ID
    private String FFID;// 航班标识
    private String MFID;// 主航班ID
    private String MFFI;// 主航标识
    private String PROX;// 代理
    private String SOURCE;// 来源
    private String CFNO;// 机号
    private String CFTP;// 机型
    private String FLTK;// 飞行性质(航班任务)
    private String HX;// 航线三字码
    private Date FPTT;// 计划起飞时间
    private Date FPLT;// 计划到达时间
    private Date FETT;// 预计起飞时间
    private Date FELT;// 预计到达时间
    private Date FRTT;// 实际起飞时间
    private Date FRLT;// 实际到达时间
    private String QJRQ;// 实际执行日期
    private String SADT;// 起降时间
    private String CONT;// 起降架次
    private Date CLDT;// 撤轮档时间
    private Date SLDT;// 上轮档时间
    private String STAT;// 航班状态
    private String GATE;// 登机口
    private Date BOET;// 登机预计时间
    private Date BORT;// 登机实际时间
    private Date TBRT;// 过登实际时间
    private Date LBDT;// 催机实际时间
    private Date POKT;// 催机结束时间
    private String BAGGAGE;// 行李转盘编号
    private Date BESTR;// 行李提取预计开始时间
    private Date BEEND;// 行李提取预计结束时间
    private Date BRSTR;// 行李提取实际开始时间
    private Date BREND;// 行李提取实际结束时间
    private String CKI;// 值机柜台
    private Date FCES;// 值机预计开始时间
    private Date FCEE;// 值机预计结束时间
    private Date FCRS;// 值机实际开始时间
    private Date FCRE;// 值机实际结束时间
    private String RUNWAY;// 跑道
    private String STND;// 停机位
    private String EXNO;// 达到出口
    private String BOARD_STAUS;// 登机状态
    private String CAAC_CODE;// 延误原因
    private String HD_TYPE;// 航段分类
    private String HX_TYPE;// 航线分类
    private String GXHBH; //共享航班
    private String STATE;// 数据状态(0:有效 1：无效)
    private String WHX;//无航线
    private String CDRQ;//仓单日期

    /**舱单数据字段**/
    private String RSTN;// 可供座位数
    private String STNM;// 最大座位数
    private String ADNO;// 成人人数
    private String CHNO;// 儿童人数
    private String BANO;// 婴儿人数
    private String PASS_ADNO;// 过站成人人数
    private String PASS_CHNO;// 过站儿童人数
    private String PASS_BANO;// 过站婴儿人数
    private String WJHZ;// 持外交护照人数
    private String RLLW;// 可供业载
    private String MXLW;// 最大业载
    private String BAG;// 行李重量
    private String POS;// 邮件重量
    private String FRE;// 货物重量
    private String FKGZW;//头等舱可供座位
    private String FCSJZW;//头等舱实际座位
    private String CCKGZW;//公务舱可供座位
    private String CCSJZW;//公务舱实际座位
    private String YCKGZW;//经济舱可供座位
    private String YCSJZW;//经济舱实际座位
    private String BAGJS;//行李件数
    private String POSJS;//邮件件数
    private String FREJS;//货物件数
    private String PASS_BAG;//过站行李重量
    private String PASS_POS;//过站邮件重量
    private String PASS_FRE;//过站货物重量
    private String PASS_BAGJS;//过站行李件数
    private String PASS_POSJS;//过站邮件件数
    private String PASS_FREJS;//过站货物件数
    private String ZZ_BAG;//中转行李重量
    private String ZZ_POS;//中转邮件重量
    private String ZZ_FRE;//中转货物重量
    private String ZZ_ADNO;//中转成人人数
    private String ZZ_CHNO;//中转儿童人数
    private String ZZ_BANO;//中转婴儿人数
    private String  ZZNUM ;//中转人数
    private String PASS_FCSJZW ;//过站头等舱实际人数
    private String PASS_CCSJZW ;//过站公务舱实际人数
    private String PASS_YCSJZW ;//过站经济舱实际人数
    private String  FTID ;//外部接口唯一ID

    /**公状态字段**/
    private String AUDIT_STATE;// 数据审核状态
    private String LOCK_STATE;// 数据锁定状态
    private String WARN_STATE;// 数据预警状态

    /**人工录入字段**/
    private String  LOCKUSER ;//锁定人
    private Date LOCKTIME  ;//锁定时间
    private String LOCKROLE ;//锁定角色
    private String AUDIT_BY;// 审核人
    private Date AUDIT_TIME;// 审核时间

    /**公共字段**/
    private String CREATE_BY;// 创建人
    private Date CREATE_TIME;// 创建时间
    private String UPDATE_BY;// 更新人
    private Date UPDATE_TIME;// 更新时间

    /**定时补充字段**/
    private String APSD_CN;// 起飞机场（名称）
    private String APED_CN;// 落地机场（名称）
    private String CITY_SD;// 起飞城市
    private String CITY_ED;// 落地城市
    private String QY_SD;// 起飞城市（区域）
    private String QY_ED;// 落地城市（区域）
    private String JCCODE;// 机场代码
    private String JCQC;// 机场全称
    private String JCJC;// 机场简称
    private String HX_CN;// 航线中文简称
    private String CS;//CS
    private String SF;//省份 国际的省份和国家一致
    private String GJ;//国家
    private String QY;//区域

    /**不用字段**/
    private String HD;//航段
    private String VIP;// 是否Vip
    private String MEAL;// 是否有餐食
    private String NIGHT;// 是否为过夜航班
    private String OUT;// 推出
    private String INN;// 推入
}
