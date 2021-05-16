package com.impact.karma.common.business.bom;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.impact.karma.common.business.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

	@JsonAlias({ "id", "_id" })
	private String id;
	private String title;
	private String isbn;

	private int pageCount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.DATE_001)
	private Date publishedDate;

	private String thumbnailUrl;
	private String shortDescription;
	private String longDescription;
	private String status;

	private List<String> authors;

	private List<String> categories;
}
