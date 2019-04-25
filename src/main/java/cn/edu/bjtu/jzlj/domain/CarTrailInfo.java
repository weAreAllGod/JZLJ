package cn.edu.bjtu.jzlj.domain;

import com.baomidou.mybatisplus.activerecord.Model;
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
@TableName("CAR_TRAIL_INFO")
public class CarTrailInfo extends Model<CarTrailInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 轨迹序号
     */
    @TableId(value = "TRAIL_ID", type = IdType.AUTO)
    private String trailId;
    /**
     * 车序号
     */
    private String carId;
    /**
     * 速度
     */
    private String speed;
    /**
     * 经度
     */
    private Double carLong;
    /**
     * 纬度
     */
    private Double carLat;
    /**
     * 密闭
     */
    private String airtight;
    /**
     * 举升
     */
    private String lift;
    /**
     * 视频存储路径
     */
    private String videoAddress;
    /**
     * 采集时间
     */
    private Date inputTime;
    /**
     * 备注
     */
    private String content;


    @Override
    protected Serializable pkVal() {
        return this.trailId;
    }

}
