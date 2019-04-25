package cn.edu.bjtu.jzlj.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
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
public class SourceInfo extends Model<SourceInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 产生源序号
     */
    @TableId(value = "SOURCE_ID", type = IdType.AUTO)
    private String sourceId;
    /**
     * 产生源位置
     */
    private String sourceAddress;
    /**
     * 产生源经度
     */
    private Double sourceLong;
    /**
     * 产生源纬度
     */
    private Double sourceLat;
    /**
     * 上报时间
     */
    private Date startDate;
    /**
     * 属性
     */
    private String soourceAttrbute;
    /**
     * 责任单位
     */
    private String sourceCompany;
    /**
     * 产生垃圾类型
     */
    private String sourceType;
    /**
     * 成分分析
     */
    private String wasteComponent;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 垃圾总量
     */
    private String wasteTotal;
    /**
     * 总量单位
     */
    private String wasteUnit;
    /**
     * 处置建议
     */
    private String suggestion;
    /**
     * 录入人名称
     */
    private String inputName;
    /**
     * 录入时间
     */
    private Date inputTime;
    /**
     * 备注
     */
    private String content;


    @Override
    protected Serializable pkVal() {
        return this.sourceId;
    }

}
