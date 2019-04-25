package cn.edu.bjtu.jzlj.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("CAR_CARRY_INFO")
@ApiModel
public class CarCarryInfo extends Model<CarCarryInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 运载序号
     */
    @ApiModelProperty(value = "运载序号", dataType = "String", name = "carryId", example = "2019Y1234567890")
    @TableId(value = "CARRY_ID", type = IdType.AUTO)
    private String carryId;
    /**
     * 车序号
     */
    @ApiModelProperty(value = "车序号", dataType = "String", name = "carId", example = "2019C1234567890")
    @TableField(value = "CAR_Id")
    private String carId;
    /**
     * 建筑垃圾序号
     */
    @TableField(value = "CONSTRUCTION_WASTE_ID")
    private String constructionWasteId;
    /**
     * 实际重量
     */
    @TableField(value = "ACTUAL_WEIGHT")
    private String actualWeight;
    /**
     * 实际重量单位
     */
    @TableField(value = "ACTUAL_WEIGHT_UNIT")
    private String actualWeightUnit;
    /**
     * 目的消纳厂序号
     */
    @TableField(value = "INTAKE_PLANT_ID")
    private String intakePlantId;
    /**
     * 录入人名称
     */
    @TableField(value = "INPUT_NAME")
    private String inputName;
    /**
     * 录入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    @TableField(value = "INPUT_TIME")
    private Date inputTime;
    /**
     * 备注
     */
    @TableField(value = "CONTENT")
    private String content;


    @Override
    protected Serializable pkVal() {
        return this.carryId;
    }

}
