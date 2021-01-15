package com.labjava.question.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuestionPostDto {
    @NotNull
    private int id;
    @NotNull
    private int u_id;
    @NotBlank
    @Size(max=100)
    private String titlu;
    @Size(max=255)
    @NotNull
    private String desc;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public QuestionPostDto(@NotNull int id,
                           @NotBlank
                           @Size(max = 100) String titlu,
                           @Size(max = 255)
                           @NotNull String desc) {
        this.id = id;
        this.titlu = titlu;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
