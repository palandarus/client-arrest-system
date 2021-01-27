package com.example.controllers.rest.Model;



public class Answer {

    private Long arrestId;

    private Integer resultCode;

    private String resultText;

    public Answer() {
    }

    public Answer(Integer arrestId, Integer resultCode, String resultText) {
        this.arrestId = arrestId.longValue();
        this.resultCode = resultCode;
        this.resultText = resultText;
    }

    public Long getArrestId() {
        return arrestId;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public String getResultText() {
        return resultText;
    }

    public void setArrestId(Long arrestId) {
        this.arrestId = arrestId;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }
}
