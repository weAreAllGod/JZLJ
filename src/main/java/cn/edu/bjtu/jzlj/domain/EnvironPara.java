package cn.edu.bjtu.jzlj.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author LiuYi
 * @since 2019-04-17
 */
@Data
@Accessors(chain = true)
@TableName("ENVIRON_PARA")
public class EnvironPara extends Model<EnvironPara> {

    private static final long serialVersionUID = 1L;

    /**
     * 环境参数序号
     */
    @TableId(value = "ENVIRON_PARA_ID", type = IdType.AUTO)
    private String environParaId;
    /**
     * 消纳厂序号
     */
    @TableField(value = "INTAKE_PLANT_ID")
    private String intakePlantId;
    /**
     * 建筑垃圾序号
     */
    @TableField(value = "CONSTRUCTION_WASTE_ID")
    private String constructionWasteId;
    /**
     * 安全风险评价因子
     */
    @TableField(value = "SAFE_PARA")
    private String safePara;
    /**
     * 水环境影响因子
     */
    @TableField(value = "WATER_PARA")
    private String waterPara;
    /**
     * 土壤环境影响因子
     */
    @TableField(value = "SOIL_PARA")
    private String soilPara;
    /**
     * 大气环境影响因子
     */
    @TableField(value = "ATM_PARA")
    private String atmPara;
    /**
     * 预警阈值
     */
    @TableField(value = "WARN_PARA")
    private String warnPara;
    /**
     * 风险结果显示
     */
    @TableField(value = "RESULT")
    private String result;
    /**
     * 录入时间
     */
    @TableField(value = "INPUT_TIME")
    private Date inputTime;
    /**
     * 备注
     */
    @TableField(value = "CONTENT")
    private String content;


    @Override
    protected Serializable pkVal() {
        return this.environParaId;
    }

}
