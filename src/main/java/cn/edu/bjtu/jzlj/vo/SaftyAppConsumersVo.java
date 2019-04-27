package cn.edu.bjtu.jzlj.vo;

import lombok.Data;

@Data
public class SaftyAppConsumersVo {
    String id;
    String name;
    Double latitude;
    Double longtitude;

    String type;
    String area;
    String volume;
    String vedio;

    String environparaid;
    String safepara;
    String waterpara;
    String solfpara;
    String atmpara;
    String warnpara;

}
