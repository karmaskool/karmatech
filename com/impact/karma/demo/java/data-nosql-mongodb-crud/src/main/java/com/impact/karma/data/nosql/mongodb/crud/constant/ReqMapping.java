package com.impact.karma.data.nosql.mongodb.crud.constant;

public final class ReqMapping {

	public static final String MONGO_BOOK_BASE = "/bookmongo";
	
	public static final String P_ID = "id";

//	Common Generic Request Mapping for RestController about CRUD operations 
	public static final String CREATE = "/create";
	public static final String READ = "/{"+P_ID+"}";
	public static final String UPDATE = "/update";
	public static final String DELETE = "/delete";

	public static final String CREATEALL = "/createALl";
	public static final String READALL = "/getAll";
	public static final String UPDATEALL = "/updateAll";
	public static final String DELETEALL = "/deleteAll";

	private ReqMapping() {
	}
}
