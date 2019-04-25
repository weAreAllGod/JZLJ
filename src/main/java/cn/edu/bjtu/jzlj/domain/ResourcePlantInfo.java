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
public class ResourcePlantInfo extends Model<ResourcePlantInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源厂序号
     */
    @TableId(value = "RESOURCE_PLANT_ID", type = IdType.AUTO)
    private String resourcePlantId;
    /**
     * 资源厂名称
     */
    private String resourcePlantName;
    /**
     * 位置
     */
    private String resourcePlantAddress;
    /**
     * 经度
     */
    private Double resourcePlantLong;
    /**
     * 纬度
     */
    private Double resourcePlantLat;
    /**
     * 法人
     */
    private String legalPerson;
    /**
     * 负责人
     */
    private String responsiblePerson;
    /**
     * 类型
     */
    private String resourcePlantType;
    /**
     * 每日收纳量
     */
    private String dailyAcceptance;
    /**
     * 日产出量
     */
    private String dailyOutput;
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
        return this.resourcePlantId;
    }

}
