package com.productcatalog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	private String productName;

	private String cat;

	private String strImage;

	private String skuCode;

	private float price;

	private String recipe;

	private String companyName;

	private String subCategory;

	private String specification;

	private Integer weight;

	private String productType;

	private String nutritionInformation;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getStrImage() {
		return strImage;
	}

	public void setStrImage(String strImage) {
		this.strImage = strImage;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getNutritionInformation() {
		return nutritionInformation;
	}

	public void setNutritionInformation(String nutritionInformation) {
		this.nutritionInformation = nutritionInformation;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", cat=" + cat + ", strImage="
				+ strImage + ", skuCode=" + skuCode + ", price=" + price + ", recipe=" + recipe + ", companyName="
				+ companyName + ", subCategory=" + subCategory + ", specification=" + specification + ", weight="
				+ weight + ", productType=" + productType + ", nutritionInformation=" + nutritionInformation + "]";
	}

	
}
