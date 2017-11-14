package com.wujiuye.yezishop.api;

import java.util.HashMap;
import java.util.Map;

public final class ResponseJsonResult {

	private final static String STATE_CODE_KEY = "error_code";
	private final static String STATE_MESSAGE_KEY = "error_message";
	public final static String RESPONSE_DATA_KEY = "data";

	public enum StateMessageKeyEnum {
		SUCCESS(0, "请求成功！"), ERROR(1, "数据获取失败！");

		private int value;
		private String message;

		StateMessageKeyEnum(int value, String message) {
			this.value = value;
			this.message = message;
		}

		public int getValue() {
			return this.value;
		}

		public String getMessage() {
			return this.message;
		}
	}

	private final static Map<String, Map<String, Object>> WEBAPP_RESULT_MANAGER = new HashMap<String, Map<String, Object>>();

	@SuppressWarnings("serial")
	private static final Map<StateMessageKeyEnum, Map<String, Object>> RESPONSE_JSON_RESULT = new HashMap<StateMessageKeyEnum, Map<String, Object>>() {
		{
			put(StateMessageKeyEnum.SUCCESS, new HashMap<String, Object>() {
				{
					put(STATE_CODE_KEY, StateMessageKeyEnum.SUCCESS.getValue());
					put(STATE_MESSAGE_KEY, StateMessageKeyEnum.SUCCESS.getMessage());
				}
			});
			put(StateMessageKeyEnum.ERROR, new HashMap<String, Object>() {
				{
					put(STATE_CODE_KEY, StateMessageKeyEnum.ERROR.getValue());
					put(STATE_MESSAGE_KEY, StateMessageKeyEnum.ERROR.getMessage());
				}
			});
		}
	};

	public static Map<String, Object> getResponseStateJsonResult(String requestAction, StateMessageKeyEnum state) {
		if (WEBAPP_RESULT_MANAGER.containsKey(requestAction + state))
			return WEBAPP_RESULT_MANAGER.get(requestAction + state);
		else {
			WEBAPP_RESULT_MANAGER.put(requestAction + state, new HashMap<>(RESPONSE_JSON_RESULT.get(state)));
			return WEBAPP_RESULT_MANAGER.get(requestAction + state);
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getDataMap(Map<String, Object> result) {
		if (result.containsKey(RESPONSE_DATA_KEY)) {
			Map<String, Object> data = (Map<String, Object>) result.get(RESPONSE_DATA_KEY);
			data.clear();
			return data;
		} else {
			Map<String, Object> data = new HashMap<>();
			result.put(RESPONSE_DATA_KEY, data);
			return data;
		}
	}
}
