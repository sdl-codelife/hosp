package com.sdl.hosp.model.entity;

import java.io.Serializable;

/**
 * (TBanner)实体类
 *
 * @author makejava
 * @since 2020-02-14 15:12:21
 */
public class TBanner implements Serializable {
    private static final long serialVersionUID = 616944597569237533L;
    
    private Integer id;
    
    private String title;
    
    private String url;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TBanner{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}