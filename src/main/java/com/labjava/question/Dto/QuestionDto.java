package com.labjava.question.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuestionDto {
    @NotNull
    private long id;
    @NotNull
    private long u_id;
    @NotBlank
    @Size(max=100)
    private String titlu;
    @Size(max=255)
    @NotNull
    private String desc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public QuestionDto() {
    }

    public QuestionDto(@NotBlank long u_id, @NotBlank @Size(max = 100) String titlu, @Size(max = 255) @NotNull String desc) {
        this.u_id = u_id;
        this.titlu = titlu;
        this.desc = desc;
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
