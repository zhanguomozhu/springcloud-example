package com.dyq.springcloud.sleuth.payment8009.entity;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2023-04-21 13:54:55
 */
public class Payment implements Serializable {
    private static final long serialVersionUID = 864409092300616835L;
    /**
     * ID
     */
    private Long id;

    private String serial;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

}

