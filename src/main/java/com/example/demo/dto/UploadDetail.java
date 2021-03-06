package com.example.demo.dto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadDetail {
	int number;
	String id;
	String orgfile;
	String newfile;
	String thumbnail;
	String name;
	String category;
	String version;
	int amount;
	String orgdate;
	String newdate;
	String youtube;
	String explain;
	
	public UploadDetail(UploadDTO upload) {
		this.newfile = upload.getNewfile();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgfile() {
		return orgfile;
	}

	public void setOrgfile(String orgfile) {
		this.orgfile = orgfile;
	}

	public String getNewfile() {
		return newfile;
	}

	public void setNewfile(String newfile) {
		this.newfile = newfile;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getOrgdate() {
		return orgdate;
	}

	public void setOrgdate(String orgdate) {
		this.orgdate = orgdate;
	}

	public String getNewdate() {
		return newdate;
	}

	public void setNewdate(String newdate) {
		this.newdate = newdate;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	@Override
	public String toString() {
		return "UploadDetail [number=" + number + ", id=" + id + ", orgfile=" + orgfile + ", newfile=" + newfile
				+ ", thumbnail=" + thumbnail + ", name=" + name + ", category=" + category + ", version=" + version
				+ ", amount=" + amount + ", orgdate=" + orgdate + ", newdate=" + newdate + ", youtube=" + youtube
				+ ", explain=" + explain + "]";
	}
	
}
