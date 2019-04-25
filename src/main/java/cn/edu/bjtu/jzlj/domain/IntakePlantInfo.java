package cn.edu.bjtu.jzlj.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("INTAKE_PLANT_INFO")
@ApiModel
public class IntakePlantInfo extends Model<IntakePlantInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 消纳厂序号
     */
    @ApiModelProperty(value = "消纳场的序号", dataType = "String", name = "carryId", example = "2019Y1234567890")
    @TableId(value = "INTAKE_PLANT_ID", type = IdType.AUTO)
    private String intakePlantId;
    /**
     * 消纳厂名称
     */
    @TableField(value = "INTAKE_PLANT_NAME")
    private String intakePlantName;
    /**
     * 位置
     */
    @TableField(value = "INTAKE_PLANT_ADDRESS")
    private String intakePlantAddress;
    /**
     * 经度
     */
    @TableField(value = "INTAKE_PLANT_LONG")
    private Double intakePlantLong;
    /**
     * 纬度
     */
    @TableField(value = "INTAKE_PLANT_LAT")
    private Double intakePlantLat;
    /**
     * 录入人名称
     */
    @TableField(value = "INPUT_NAME")
    private String inputName;
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
        return this.intakePlantId;
    }

}
