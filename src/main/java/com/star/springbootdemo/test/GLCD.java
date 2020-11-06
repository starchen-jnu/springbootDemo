package com.star.springbootdemo.test;

/**
 * 关联舱单状态:(1:关联舱单,0:未关联舱单)
 *
 * @author mchen
 *
 */
public enum GLCD {
	ASSOCIATE_NO,ASSOCIATE_DONE,ASSOCIATION_YES;

	public String getValue() {
		return String.valueOf(this.ordinal());
	}

	public static GLCD value(String value) {
		for (GLCD v : values()) {
			if (v.getValue().equals(value.trim())) {
				return v;
			}
		}
		return null;
	}
}
