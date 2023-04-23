#### 特点：支持自定义框框数，支持自定义框框样式，支持自定义框框大小、支持粘贴功能
# 支付密码框效果 6位数验证码 4位数验证效果 使用说明：
---

 1. 下载该插件，然后解压将其文件 “verification-code-style2” 拖入至项目的components中
 2. 在需要使用的地方，使用
### 参数说明
|props| 类型 | 是否必填| 默认值| 说明 |
|--|--|--|--|--|
| latticeNum |Number  | 否 | 4 | 输入框框框的个数 |
| borderStyle|String| 否 | "border-bottom:1px solid gray;" | 显示的输入框的框框样式 |
| borderCheckStyle|String| 否 |"border:1px solid rgb(117, 202, 104);" | 输入框框框选中的样式|
| inputType|String| 否 |number | 输入框的类型（值和uniapp的input一样）|
| blurShow|Boolean| 否 |false| 失去焦点后是否继续显示，当前所对焦的输入框（样式））|
| ciphertextSty|	Number	| 否 |0| 	密文样式 1 圆点样式 2 星号 * 样式 默认为0 无密文|
| latticeSize|	Number	| 否 |100| 	输入框框框大小(单位rpx)|

`特别说明borderStyle:"border-bottom:1px solid gray;"与borderCheckStyle:"border:1px solid rgb(117, 202, 104);"在vue3编译情况下在h5中可能会出现下边框不显示的bug这是因为官方编译的问题，详情可以查看issue:`[https://ask.dcloud.net.cn/question/159089](https://ask.dcloud.net.cn/question/159089?notification_id-1184235__rf-false__item_id-222190__answer_id-222190__single-TRUE#!answer_222190)
### 事件说明
|方法| 参数 | 说明 |
|--|--|--|
|getValue  | - | 获取输入框的值 |
|cleanVal| - | 清空输入框的值 |
|setVerificationCode| String | 设置输入框的值 |
|inputVerificationChange| - | 输入框值改变时触发 |

# 示例代码如下：
---

```javascript
<template>
	<view class="main">
		<view style="width: 500rpx;margin: 100rpx auto;font-weight: bold;font-size: 30rpx;">
			<verification-code-style2 ref="verificationCodeStyle2" @inputVerificationChange="inputVerificationChange"></verification-code-style2>
		</view>
		
		<view class="options">
			<button type="default" @tap="getVal">获取值</button>
			<button type="warn" @tap="clearVal">清空值</button>
			<button type="primary" @tap="setVal">设置值</button>
		</view>
	</view>
</template>

<script>
export default {
	data() {
		return {
		};
	},
	methods: {
		getVal(){
			const val= this.$refs.verificationCodeStyle2.getValue()
			uni.showModal({
				content:"获取到值："+val,
				showCancel:false
			})
		},
		clearVal(){
			this.$refs.verificationCodeStyle2.cleanVal()
		},
		setVal(){
			this.$refs.verificationCodeStyle2.setVerificationCode('888')
		},
		inputVerificationChange(val){
			console.log('值改变了：'+val);
		}
	}
}; 
</script>

<style lang="less" scoped>
.options{
	margin-top: 200rpx;
	padding: 30rpx;
	display: flex;
	justify-content: space-between;
	align-items: center;
}
</style>

```
