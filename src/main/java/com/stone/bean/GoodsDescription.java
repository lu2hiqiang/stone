package com.stone.bean;

public class GoodsDescription {
    private String goodsName;

    private String goodsDescription;
    
    

    public GoodsDescription() {
	}

	public GoodsDescription(String goodsName, String goodsDescription) {
		this.goodsName = goodsName;
		this.goodsDescription = goodsDescription;
	}

	public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription == null ? null : goodsDescription.trim();
    }
}