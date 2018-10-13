package com.al.iblog.enums;

public enum ArticleStateEnum {
	CHECK(0, "审核中"), OFFLINE(-1, "非法文章"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"), INNER_ERROR(-1001,
			"内部系统错误"), NULL_ARTICLEID(-1002, "ArticleId为空"),NULL_ARTICLE(-1003, "shop信息为空");
	private int state;
	private String stateInfo;

	private ArticleStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static ArticleStateEnum stateOf(int state) {
		for (ArticleStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

}
