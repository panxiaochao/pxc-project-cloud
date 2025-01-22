package io.github.panxiaochao.system.satoken.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 登录设备类型
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-20
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum DeviceType {

	/**
	 * 电脑端
	 */
	PC("pc", "电脑端"),

	/**
	 * 手机端
	 */
	MOBILE("mobile", "手机端"),

	/**
	 * 安卓手机端
	 */
	MOBILE_ANDROID("mobile_android", "安卓手机端"),

	/**
	 * 苹果手机端
	 */
	MOBILE_APPLE("mobile_apple", "苹果手机端"),

	/**
	 * H5端
	 */
	H5("h5", "H5端"),

	/**
	 * 微信小程序端
	 */
	WEI_XIN_MA("wei_xin_ma", "微信小程序端"),

	/**
	 * 微信公众号端
	 */
	WEI_XIN_MP("wei_xin_mp", "微信公众号端"),;

	/**
	 * 设备编码
	 */
	private final String device;

	/**
	 * 设备描述
	 */
	private final String remark;

	public static DeviceType ofDevice(String device) {
		for (DeviceType deviceType : DeviceType.values()) {
			if (deviceType.getDevice().equals(device)) {
				return deviceType;
			}
		}
		throw new RuntimeException("登录设备暂不支持！");
	}

}
