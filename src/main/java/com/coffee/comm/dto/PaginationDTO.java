package com.coffee.comm.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * PaginationDTO
 *
 * @author lmq
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevious;
    private Boolean showFirstPage;
    private Boolean showNext;
    private Boolean showEndPage;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(int totalCount, Integer page, Integer size) {

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        for(int i=3;i>0;i--){
            if(page-i>0){
                pages.add(page-i);
            }
        }
        this.page=page;
        for(int i=0;i<4;i++){
            if(page+i<=totalPage){
                pages.add(page+i);
            }
        }
        if(totalPage==0){
            totalPage=1;
            pages.add(1);
        }
        if(page==1){
            showPrevious = false;
        }else{
            showPrevious=true;
        }
        if(page.equals(totalPage)){
            showNext = false;
        }else{
            showNext=true;
        }
        if(pages.contains(1)){
            showFirstPage=false;
        }else{
            showFirstPage=true;
        }
        if(pages.contains(totalPage)){
            showEndPage=false;
        }else{
            showEndPage=true;
        }
    }

    @Override
    public String toString() {
        return "PaginationDTO{" +
                "questions=" + questions +
                ", showPrevious=" + showPrevious +
                ", showFirstPage=" + showFirstPage +
                ", showNext=" + showNext +
                ", showEndPage=" + showEndPage +
                ", page=" + page +
                ", totalPage=" + totalPage +
                ", pages=" + pages +
                '}';
    }
}
