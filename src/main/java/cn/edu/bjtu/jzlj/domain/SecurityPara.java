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
@TableName("SECURITY_PARA")
public class SecurityPara extends Model<SecurityPara> {

    private static final long serialVersionUID = 1L;

    /**
     * 安全参数序号
     */
    @TableId(value = "SECURITY_PARA_ID", type = IdType.AUTO)
    private String securityParaId;
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
     * 建筑垃圾堆填体位置
     */
    @TableField(value = "CONSTRUCTION_WASTE_POSITION")
    private String constructionWastePosition;
    /**
     * 建筑垃圾类型
     */
    @TableField(value = "CONSTRUCTION_WASTE_TYPE")
    private String constructionWasteType;
    /**
     * 建筑垃圾体量
     */
    @TableField(value = "CONSTRUCTION_WASTE_SIZE")
    private String constructionWasteSize;
    /**
     * 地面调查、监测传感器采集的现场图像数据
     */
    @TableField(value = "SECURITY_PARA_DATA1")
    private String securityParaData1;
    /**
     * 多源多时相遥感影像目标识别与信息提取、变化监测成果数据
     */
    @TableField(value = "SECURITY_PARA_DATA2")
    private String securityParaData2;
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
        return this.securityParaId;
    }

}
