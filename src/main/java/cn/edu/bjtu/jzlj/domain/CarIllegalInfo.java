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
public class CarIllegalInfo extends Model<CarIllegalInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 违法记录序号
     */
    @TableId(value = "ILLEGAL_ID", type = IdType.AUTO)
    private String illegalId;
    /**
     * 车序号
     */
    private String carId;
    /**
     * 违法时间
     */
    private Date illegalTime;
    /**
     * 违法位置
     */
    private String illegalAddress;
    /**
     * 违法原因
     */
    private String illegalReason;
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
        return this.illegalId;
    }

}
