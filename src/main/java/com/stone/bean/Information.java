package com.stone.bean;

import java.util.Date;

public class Information {
    private Integer id;

    private Integer typeId;

    private String titel;

    private String description;

    private String titelUrl;

    private String author;

    private String edit;

    private Date creatDate;

    private Integer readCunt;


	public Information() {
	}

	public Information(Integer id, Integer typeId, String titel,
			String description, String titelUrl, String author, String edit,
			Date creatDate, Integer readCunt) {
		this.id = id;
		this.typeId = typeId;
		this.titel = titel;
		this.description = description;
		this.titelUrl = titelUrl;
		this.author = author;
		this.edit = edit;
		this.creatDate = creatDate;
		this.readCunt = readCunt;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel == null ? null : titel.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTitelUrl() {
        return titelUrl;
    }

    public void setTitelUrl(String titelUrl) {
        this.titelUrl = titelUrl == null ? null : titelUrl.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit == null ? null : edit.trim();
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Integer getReadCunt() {
        return readCunt;
    }

    public void setReadCunt(Integer readCunt) {
        this.readCunt = readCunt;
    }
}