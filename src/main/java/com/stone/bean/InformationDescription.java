package com.stone.bean;

public class InformationDescription {
    private Integer informationId;

    private String content;
    
    public InformationDescription() {
	}
    
	public InformationDescription(Integer informationId, String content) {
		this.informationId = informationId;
		this.content = content;
	}



	public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}