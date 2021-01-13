package com.swj.vo;

import com.swj.entity.MlDetailed;
import lombok.Data;

@Data
public class PageDetailedVo {
    private Integer pageIndex;
    private Integer pageSize = 5;
    private MlDetailed mlDetailed;

    public Integer getPageIndex() {
        if (pageIndex == null) {
            pageIndex = 1;
            return pageIndex;
        }
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

}
