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
@TableName("CAR_INFO")
@ApiModel
public class CarInfo extends Model<CarInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 车序号
     */
    @ApiModelProperty(value = "车序号", dataType = "String", name = "carId", example = "2019C1234567890")
    @TableId(value = "CAR_ID", type = IdType.AUTO)
    private String carId;
    /**
     * 车牌号
     */
    @TableField(value = "CAR_NO")
    private String carNo;
    /**
     * 车队
     */
    @TableField(value = "FLEET")
    private String fleet;
    /**
     * 所属单位
     */
    @TableField(value = "CAR_UNIT")
    private String carUnit;
    /**
     * 联系人
     */
    @TableField(value = "LINKMAN")
    private String linkman;
    /**
     * 联系电话
     */
    @TableField(value = "PHONE_NO")
    private String phoneNo;
    /**
     * 可承载重量
     */
    @TableField(value = "WEIGHT")
    private String weight;
    /**
     * 重量单位
     */
    @TableField(value = "WEIGHT_UNIT")
    private String weightUnit;
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
        return this.carId;
    }

}
