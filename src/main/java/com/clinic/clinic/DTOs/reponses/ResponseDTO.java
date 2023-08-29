package com.clinic.clinic.DTOs.reponses;

import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class ResponseDTO {
    private Object content;
    private PageableDTO pageable;
    private SortDTO sort;
    private String query;

    public ResponseDTO(Object content, Page page, String query) {
        this.content = content;
        if (page != null) {
            this.pageable = new PageableDTO(page);
            this.sort = new SortDTO(page);
        }
        this.query = query;
    }

    public ResponseDTO(Object content) {
        this.content = content;
    }
}
