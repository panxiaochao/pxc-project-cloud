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
	 * 微信小程序
	 */
	WECHAT_MA("wei_chat_ma", "微信小程序"),

	/**
	 * 微信公众号
	 */
	WECHAT_MP("wei_chat_mp", "微信公众号"),
	/**
	 * 企业微信
	 */
	WECHAT_CP("wei_chat_cp", "企业微信"),
	/**
	 * QQ
	 */
	QQ("qq", "QQ"),
	/**
	 * GITHUB
	 */
	GITHUB("github", "GITHUB"),
	/**
	 * GITEE
	 */
	GITEE("gitee", "GITEE"),
	/**
	 * 微博
	 */
	WEI_BO("wei_bo", "微博"),
	/**
	 * 钉钉
	 */
	DD("dd", "钉钉");

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
		throw new RuntimeException(String.format("登录设备'[%s]'暂不支持，请按提供的参数填写！", device));
	}

}
